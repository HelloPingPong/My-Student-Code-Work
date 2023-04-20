/*
* Add Events and functions to move the Ship and Win the game
*/
let frame;
const obstacles = ['pirate', 'iceberg'];
const directions = ['up','right','down', 'left'];
let clock;

// Creates the Grid -- this should only occur after the DOM loads
document.addEventListener('DOMContentLoaded', () => {
    frame = document.getElementById('frame');
    createGrid();

    document.querySelector('body').addEventListener('keyup', (event) => {
        if (event.key.toLowerCase() === 'w') {
            moveShipUp();
        }
        if (event.key.toLowerCase() === 's') {
            moveShipDown();
        }
        if (event.key.toLowerCase() === 'a') {
            moveShipLeft();
        }
        if (event.key.toLowerCase() === 'd') {
            moveShipRight();
        }

    });

    document.getElementById('resetButton').addEventListener('click', (event) => {
        resetGame();
        event.preventDefault();
    });

});


/*
  Move the Ship 
*/
function moveShipRight() {
    const ship = getShipLocation();
    const right = ship.nextElementSibling;
    moveShip(ship, right);
}

function moveShipLeft() {
    const ship = getShipLocation();
    const left = ship.previousElementSibling;
    moveShip(ship, left);
}

function moveShipDown() {
    const ship = getShipLocation();
    const down = getElementAtSameIndex(ship, ship.parentElement.nextElementSibling);
    moveShip(ship,down);
}

function moveShipUp() {
    const ship = getShipLocation();
    const up = getElementAtSameIndex(ship, ship.parentElement.previousElementSibling);
    moveShip(ship, up);
}

function moveShip(oldLocation, newLocation) {
    if (isWin(newLocation)) {
        win();
    } if (isLoss(newLocation)) {
        lose('You were sunk!');
    } else if (canMoveToElement(newLocation)) {
        oldLocation.classList.remove('boat');
        newLocation.classList.add('boat');
    }
}

function canMoveToElement(element) {
    if (!element || element.classList.contains('pirate') 
        || element.classList.contains('iceberg')) {
        return false;
    }
    return true;
}

function getElementAtSameIndex(ship, newParent) {
    let elementAtIndex = null;

    if (newParent) {
        const originalIndex = Array.from(ship.parentNode.children).indexOf(ship);
        elementAtIndex = newParent.childNodes[originalIndex];
    }

    return elementAtIndex;
}

function getShipLocation() {
    // Get the return the current location of the ship
    return document.getElementById('frame').querySelector('.boat');
}





/*
  Win Conditions
*/
function isWin(nextElement) {
    return (nextElement && nextElement.classList.contains('treasure'));
}

function win() {
    document.querySelector('.announce').innerText = 'You Win!';
    document.querySelector('.announce').classList.add('winText');
    getShipLocation().classList.remove('boat');
}


/*
    Loss Conditions
*/
function isLoss(nextElement) {
    return nextElement.classList.contains('pirate') 
    || nextElement.classList.contains('iceberg');
}

function lose(message) {
    document.querySelector('.announce').innerText = message;
    document.querySelector('.announce').classList.add('winText');
    const shipLocation = getShipLocation();
    shipLocation.classList.remove('boat');

    shipLocation.classList.add('boat_explosion');
    setTimeout( () => {
        shipLocation.classList.remove('boat_explosion');
        shipLocation.classList.add('boat_sunk');
    }, 500);
    
}



/**
 * Reset the Game
 */
function resetGame() {

    removeShip();

    // Create Obstacles
    createObstacles();

    // Tell the user they can start
    document.querySelector('section h1.announce').innerText = 'Play!';
    
    // Set the starting point of the boat and the treasure
    frame.firstElementChild.firstElementChild.classList.add('boat');
    frame.lastElementChild.lastElementChild.classList.add('treasure');
    
}

function removeShip() {
    const ship = getShipLocation();
    if (ship) {
        ship.classList.remove('boat');
    }
    const shipSunk = frame.querySelector('.boat_sunk');
    if (shipSunk) {
        shipSunk.classList.remove('boat_sunk');
    }
}


/*
    Setup the Game
*/
/**
 * Creates the game grid
 */
function createGrid() {

    // Get a Reference to the game board 

    for (let i = 0; i < 10 ; i++) {
        buildRow(frame); 
    }
    resetGame();
}

/**
 * Builds the grid rows
 * @param {HTMLElement} frame 
 */
function buildRow(frame) {
    // Create a Div to be the row
    const row = document.createElement('div');
    // Add the row class to the row div
    row.classList.add('row');
    // Append the row div to the game board (frame)
   frame.insertAdjacentElement('beforeend', row)
    for (let i = 0; i < 10 ; i++) {
        buildSquare(row, i); 
    }    
}

/**
 * Builds the grid squares 
 * @param {HTMLElement} row 
 * @param {int} count 
 */
function buildSquare(row, count) {
   // Create a Div for the game board square
   const square  = document.createElement('div');
   // Add the square class to the div
   square.classList.add('square');
   // Insert the square at the end of the row
  row.appendChild(square);
}


function createObstacles() {
    const rows = frame.children;
    Array.from(rows).forEach( (row, rowIndex) => {
        const cells = row.children;
        Array.from(cells).forEach( (cell, cellIndex) => {
            if ( !(rowIndex === 0 && cellIndex === 0) &&
                !(rowIndex === rows.length - 1 && cellIndex === cells.length - 1)) {
                    addObstacles(cell);     
                }
        });
    });
    
}

/**
 * Adds random obstacles to a game cell
 * 
 * @param {HTMLElement} cell 
 */
function addObstacles(cell) {
    // remove any existing pirates or icebergs
    cell.classList.remove('pirate');
    cell.classList.remove('iceberg');

    const rand = getRandomNumber(100, false);

    if (rand > 85) {
        // Add iceberg here
        cell.classList.add('iceberg');
 
    } else if (rand > 80) {
        // Add pirates here
        cell.classList.add('pirate');

    } 
}


/*
  Move the Pirates
*/



function getRandomNumber(top, zeroBased) {
    let randNumber = (Math.floor(Math.random() * top) + 1);
    return zeroBased ? randNumber - 1: randNumber;
}
