function DivObject(id) {
    this.html = document.getElementById(id);
    this.x = document.getElementById(id).offsetLeft;
    this.y = document.getElementById(id).offsetTop;
    this.height = document.getElementById(id).offsetHeight;
    this.width = document.getElementById(id).offsetWidth;
    this.speed = 5;
    this.moveRight = function () {
        this.x += this.speed;
        this.html.style.left = this.x + 'px';
    };
    this.moveLeft = function () {
        this.x -= this.speed;
        this.html.style.left = this.x + 'px';
    };
    this.moveUp = function () {
        this.y -= this.speed;
        this.html.style.top = this.y + 'px';
    };
    this.moveDown = function () {
        this.y += this.speed;
        this.html.style.top = this.y + 'px';
    };
}

/* 0 - vacio (empty)
 * 1 - bloque (block)
 * 2 - moneda (coin)
 * 3 - pacman  (pacman)
 * 4 - fantasma (ghost)
*/
var map = [
    [1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
    [1, 2, 0, 0, 0, 0, 0, 0, 0, 1],
    [1, 0, 1, 1, 1, 1, 1, 1, 0, 1],
    [1, 3, 0, 0, 0, 0, 0, 0, 0, 1],
    [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
];

var collidesStack = [];

function drawMap() {
    let output = '';
    for (let i = 0; i < map.length; i++) {
        output += '<div class="row">\n';
        for (let j = 0; j < map[i].length; j++) {
            if (map[i][j] === 0) {
                output += '\t<div class="empty"></div>\n';
            } else if (map[i][j] === 1) {
                output += '\t<div class="block"></div>\n';
            } else if (map[i][j] === 2) {
                output += '\t<div class="coin"></div>\n';
            } else if (map[i][j] === 3) {
                output += '\t<div class="pacman"></div>\n';
            }
        }
        output += '</div>\n';
    }
    document.getElementById('map').innerHTML = output;
}

function drawCoordinates(x, y) {
    document.getElementById('pacman-cc').innerHTML = 'X: ' + x + '<br>' + 'Y: ' + y;
}
drawCoordinates('undefined', 'undefined');

document.addEventListener('keydown', function (event) {
    let pacman_div = document.getElementById('pacman');
    let pacman = new DivObject('pacman');
    let collides = isCollideWithBlock(pacman_div, '');
    if (event.code === 'ArrowRight' ) {
        pacman.moveRight();
    } else if (event.code === 'ArrowLeft') {
        pacman.moveLeft();
    } else if (event.code === 'ArrowUp' ) {
        pacman.moveUp();
    } else if (event.code === 'ArrowDown' ) {
        pacman.moveDown();
    }
    drawCoordinates(pacman.x, pacman.y);
});


function isCollideWithBlock(obj, side) {
    let blocks = document.getElementsByClassName('block');
    for (let i = 0; i < blocks.length; i++) {
        // return checkSide(side, blocks[i], obj);
        if (isCollide(blocks[i], obj)) {
            blocks[i].setAttribute('style', 'background-color: red;');
        }
    }
    return -1;
}

/*
 * Colisión superior:   0
 * Colisión inferior:   1
 * Colisión derecha:    2
 * Colisión izquierda:  3
*/
function checkSide(side, a, b) {
    let aRect = a.getBoundingClientRect();
    let bRect = b.getBoundingClientRect();
    switch (side) {
        case 'up'   :   return !(aRect.y > (bRect.y + bRect.height));
        case 'down' :   return !((aRect.y + aRect.height) < (bRect.y));
        case 'right':   return !((aRect.x + aRect.width) < bRect.x);
        case 'left' :   return !(aRect.x > (bRect.x + bRect.width));
        default     :   return -2;
    }
}


// detector de colisiones basado en: https://en.wikipedia.org/wiki/Minimum_bounding_rectangle
// fuente algoritmo: https://stackoverflow.com/questions/2440377
// a y b: dos objetos con coordenadas y tamaño
// a: bloque 
// b: pacman
function isCollide(a, b) {
    let aRect = a.getBoundingClientRect();
    let bRect = b.getBoundingClientRect();
    return !(
        ((aRect.y + aRect.height) < (bRect.y)) ||
        (aRect.y > (bRect.y + bRect.height)) ||
        ((aRect.x + aRect.width) < bRect.x) ||
        (aRect.x > (bRect.x + bRect.width))
    );
}

drawMap();