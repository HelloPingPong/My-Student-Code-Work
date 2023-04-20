let canvas;
let context;
let pontsize = 6;
let dotlocation;
let cordDisplay;
let clearOnMove = true;
let lineColor = "#ff2626";

/*
    The DOMContentLoaded event waits for the HTML to be loaded into
    the DOM.
*/
document.addEventListener('DOMContentLoaded', ()=> {

    init();

    /*
        Adds a mouse click event to the drawing area that
        places a dot at the mouse location.
    */
    canvas.addEventListener('click', (event) => {
        getMousePosition(event);
    })

    /*
        Adds a keydown event to the body.  The event.key property
        is used to determine which key was pressed and then moves
        the dot in that direction.
    */
    document.querySelector('body').addEventListener('keydown', (event) => {
        if (event.key === 'ArrowRight') {
            moveRight();
        }
        if (event.key === 'ArrowLeft') {
            moveLeft();
        }
        if (event.key === 'ArrowDown') {
            moveDown();
        }
        if (event.key  === 'ArrowUp') {
            moveUp();
        }
      
    });

    /*
        Adds a mouseenter event to the drawing area.
        When the mouse enters the area a border is added.
    */
    canvas.addEventListener('mouseenter', ()=> {
        addBorderToCanvas();
    });

    /*
        Adds a mouseleave event to the drawing area.
        When the mouse leaves the area a border is removes and
        the coordinates text is removed.
    */
    canvas.addEventListener('mouseleave', ()=> {
        removeBorderFromCanvas();
    });


    /*
        Adds a mousemove event to the drawing area.  As the mouse
        moves it updates the coordinates area to show the current mouse
        location in the area.
    */
    canvas.addEventListener('mousemove', (event) => {
        showMouseCoordinates(event)
    });


    /*
        Adds a click event to the draw/move button.  When clicks it toggles
        the area between moving the dot and using it to draw.  When the dot is
        changed to move it clears the drawing area.
    */
    document.querySelector('#container button').addEventListener('click', ()=> {
        setLineDraw();
    });

    /*
        Adds a change event to the HTML5 Color picker.  When a new color is selected
        it updtes the current color of the dot/line being drawn.
    */
    document.querySelector('#container input[type=color]').addEventListener('change', ()=> {
        setLineColorFromPicker();
    })

});




/*
Code beyond this comment provide the functionality
*/
function init() {
    canvas = document.getElementById('canvas');
    context = canvas.getContext("2d");
    cordDisplay = document.getElementById('cursorPosition');
    document.querySelector('#container input[type=color]').value = lineColor;
    createStartingDot()
}

function addBorderToCanvas() {
    canvas.classList.remove('noborder');
    canvas.classList.add('border');
}

function removeBorderFromCanvas() {
    canvas.classList.remove('border');
    canvas.classList.add('noborder');
    clearCoordinates();
}

function setLineColorFromPicker() {
    lineColor = document.querySelector('#container input[type=color]').value;
    drawCoordinates(dotlocation.x,dotlocation.y);
}

function createStartingDot() {
    if (!dotlocation) {
        dotlocation = { x: canvas.width/2, y: canvas.height/2}
        drawCoordinates(dotlocation.x,dotlocation.y);
    }
}

function setLineDraw() {
    const button = document.querySelector('#container button');
    clearOnMove = !clearOnMove;
    if (clearOnMove) {
        button.innerText = "Draw";
        drawCoordinates(dotlocation.x, dotlocation.y)
    } else {
        button.innerText = "Move";
    }
}

function showMouseCoordinates(event) {
    cordDisplay.innerText = `Cordinates: x:${event.x} y:${event.y}`
}

function clearCoordinates() {
    cordDisplay.innerText = '';
}

function moveRight() {
    move(dotlocation.x + 5, dotlocation.y);
}

function moveLeft() {
    move(dotlocation.x - 5, dotlocation.y);
}

function moveUp() {
    move(dotlocation.x, dotlocation.y - 5);
}

function moveDown() {
    move(dotlocation.x, dotlocation.y + 5);
}

function move(newX, newY) {
    dotlocation.x = newX;
    dotlocation.y = newY;
    drawCoordinates(newX, newY)
}


function getMousePosition(event){
    const rect = canvas.getBoundingClientRect();
    const x = (event.clientX - rect.left) / (rect.right - rect.left) * canvas.width
    const y =  (event.clientY - rect.top) / (rect.bottom - rect.top) * canvas.height
    dotlocation = { x: x, y: y}
    drawCoordinates(x,y);
}

function drawCoordinates(x,y){	
    if (clearOnMove) {
        context.clearRect(0, 0, canvas.width, canvas.height);
    }
    context.fillStyle = lineColor; 
    context.beginPath();
    context.arc(x, y, pontsize, 0, Math.PI * 2, true);
    context.fill();
}