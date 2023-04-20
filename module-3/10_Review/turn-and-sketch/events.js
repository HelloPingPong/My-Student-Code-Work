let canvas;
let context;
let pontsize = 6;
let dotlocation;
let lineColor = "#222424";
let current_left_rotation = 0;
let current_right_rotation = 0;
let leftKnob;
let rightKnob;


document.addEventListener('DOMContentLoaded', ()=> {

    init();

    leftKnob.firstElementChild.addEventListener('click', (event) => {
        rotateLeftKnob(-5);
        moveLeft();
    });

    leftKnob.lastElementChild.addEventListener('click', (event) => {
        rotateLeftKnob(5);
        moveRight();
    });

    rightKnob.firstElementChild.addEventListener('click', (event) => {
        rotateRightKnob(-5);
        moveDown();
    });

    rightKnob.lastElementChild.addEventListener('click', (event) => {
        rotateRightKnob(5);
        moveUp();
    });

    document.querySelector('#container button').addEventListener('click', ()=> {
        clear();
    });

    document.querySelector('#container input[type=color]').addEventListener('change', ()=> {
        setLineColorFromPicker();
    })

});



function init() {
    leftKnob = document.querySelector("#sketcher > div.controls > div.left");
    rightKnob = document.querySelector("#sketcher > div.controls > div.right");
    canvas = document.getElementById('canvas');
    context = canvas.getContext("2d");
    cordDisplay = document.getElementById('cursorPosition');
    document.querySelector('#container input[type=color]').value = lineColor;
    createStartingDot();
}

function rotateLeftKnob(degrees) {
    current_left_rotation += degrees;
    leftKnob.style.transform = 'rotate(' + current_left_rotation + 'deg)'
}

function rotateRightKnob(degrees) {
    current_right_rotation += degrees;
    rightKnob.style.transform = 'rotate(' + current_right_rotation + 'deg)'
}

function setLineColorFromPicker() {
    lineColor = document.querySelector('#container input[type=color]').value;
    drawCoordinates(dotlocation.x,dotlocation.y);
}

function createStartingDot() {
    dotlocation = { x: canvas.width/2, y: canvas.height/2}
    drawCoordinates(dotlocation.x,dotlocation.y); 
}


function moveRight() {
    const newX = dotlocation.x + 5;
    if (newX < canvas.width) {
        move(dotlocation.x + 5, dotlocation.y);
    }
}

function moveLeft() {
    const newX = dotlocation.x - 5;
    if (newX > 0) {
        move(newX, dotlocation.y);
    }
}

function moveUp() {
    const newY = dotlocation.y - 5;
    if (newY > 0) {
        move(dotlocation.x, newY);
    }
}

function moveDown() {
    const newY = dotlocation.y + 5;
    if (newY < canvas.height) {
        move(dotlocation.x, newY);
    }
}

function move(newX, newY) {
    dotlocation.x = newX;
    dotlocation.y = newY;
    drawCoordinates(newX, newY); 
}

function getMousePosition(event){
    const rect = canvas.getBoundingClientRect();
    const x = (event.clientX - rect.left) / (rect.right - rect.left) * canvas.width
    const y =  (event.clientY - rect.top) / (rect.bottom - rect.top) * canvas.height
    dotlocation = { x: x, y: y}
    drawCoordinates(x,y);
}

function drawCoordinates(x,y){	
    context.fillStyle = lineColor; 
    context.beginPath();
    context.arc(x, y, pontsize, 0, Math.PI * 2, true);
    context.fill();
}

function clear() {
    shakeframe();
    setTimeout(resetDrawing, 500);
    
}

function shakeframe() {
    const sketcher = document.getElementById('sketcher');
    sketcher.classList.remove('shakeit');
    void sketcher.offsetWidth
    sketcher.classList.add('shakeit');
}

function resetDrawing() {
    context.clearRect(0, 0, canvas.width, canvas.height);
    leftKnob.style.transform = 'rotate(' + 0 + 'deg)';
    rightKnob.style.transform = 'rotate(' + 0 + 'deg)';
    current_left_rotation = 0;
    current_right_rotation = 0;
    lineColor = "#222424";
    document.querySelector('#container input[type=color]').value = lineColor;
    createStartingDot();
}