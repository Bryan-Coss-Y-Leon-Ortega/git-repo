"use strict";

const canvas = document.getElementById("glCanvas");
const gl = canvas.getContext("webgl");

if(!gl){
    alert("WebGL not supported");
    throw new Error("WebGL not Supported");
}

//Vertex Shader Source
const vsSource = `
    attribute vec2 a_Position;
    uniform mat4 user_Scale;
    void main(){
        gl_Position = user_Scale * vec4(a_Position, 0.0, 1.0);
    }

`;

//Fragment Shader Source
const fsSource = `
    precision mediump float;
    void main(){
        gl_FragColor = vec4(0.2, 0.6, 0.9, 1.0);
    }

`
//Compile Shader
function compileShader(type, source){
    const shader = gl.createShader(type);
    gl.shaderSource(shader, source);
    gl.compileShader(shader);

    if(!gl.getShaderParameter(shader, gl.COMPILE_STATUS)){
        console.error("Shader compile failed: ", gl.getShaderInfoLog(shader));
        gl.deleteShader(shader);
        return null;
    }
    return shader;
}

//Create program
const vertexShader = compileShader(gl.VERTEX_SHADER, vsSource);
const fragmentShader = compileShader(gl.FRAGMENT_SHADER, fsSource);
const program = gl.createProgram();
gl.attachShader(program, vertexShader);
gl.attachShader(program, fragmentShader);
gl.linkProgram(program);
gl.useProgram(program);

//This is for the scale
const user_Scale = gl.getUniformLocation(program, "user_Scale");

if(!gl.getProgramParameter(program, gl.LINK_STATUS)){
    console.error("Program link failed: ", gl.getProgramInfoLog(program));
}
//Set triangle vertices
const vertices = new Float32Array([
    0.0, 0.5,
    -0.5, -0.5,
    0.5, -0.5
]);

// Set square vertices
const vertices4 = new Float32Array([
    -0.5, 0.5,
    -0.5, -0.5,
    0.5, 0.5,
    0.5, -0.5
])
function scaleMatrix(scale, x, y){
    return new Float32Array([
        scale, 0.0, 0.0, 0.0,
        0.0, scale, 0.0, 0.0,
        0.0, 0.0, 1.0, 0.0,
        x, y, 0.0, 1.0
]);
}

//Create buffer
const buffer = gl.createBuffer();
gl.bindBuffer(gl.ARRAY_BUFFER, buffer);
gl.bufferData(gl.ARRAY_BUFFER, vertices4, gl.STATIC_DRAW);

//Link Vertex Attribute
const a_Position = gl.getAttribLocation(program, "a_Position");
gl.enableVertexAttribArray(a_Position);
gl.vertexAttribPointer(a_Position, 2, gl.FLOAT, false, 0, 0);

gl.viewport(0, 0, canvas.width, canvas.height);
gl.clearColor(0.0, 0.0, 0.0, 1.0);
gl.clear(gl.COLOR_BUFFER_BIT);

//Clear and Draw

function draw(scale, x, y){
    const sMatrix = scaleMatrix(scale, x, y);
    gl.uniformMatrix4fv(user_Scale, false, sMatrix);
    gl.clear(gl.COLOR_BUFFER_BIT);
    gl.drawArrays(gl.TRIANGLE_STRIP, 0, 4);
}
const scaleSlider = document.getElementById("scale");
const xTrans = document.getElementById("X-translation");
const yTrans = document.getElementById("Y-translation");


function updateDraw(){
    const scale = parseFloat(scaleSlider.value);
    const x = parseFloat(xTrans.value);
    const y = parseFloat(yTrans.value);

    draw(scale, x, y);
}

let x = 0.0;
let y = 0.0;

const halfSize = scale / 2;


scaleSlider.addEventListener("input", updateDraw);
xTrans.addEventListener("input", updateDraw);
yTrans.addEventListener("input", updateDraw);

document.addEventListener('keydown', (event) => {
    const step = 0.01;
    const scale = parseFloat(scaleSlider.value);

    switch (event.key) {
        case "ArrowLeft":
        case "a":
        case "A":
            x -= step;
            break;
        case "ArrowRight":
        case "d":
        case "D":
            x += step;
            break;
        case "ArrowUp":
        case "w":
        case "W":
            y += step;
            break;
        case "ArrowDown":
        case "s":
        case "S":
            y -= step;
            break;
        default:
            return; // don't redraw if it's not a movement key
    }
    
    xTrans.value = x.toFixed(2);
    yTrans.value = y.toFixed(2);

    if(x > 1){
        x = 1;
    }
    if (x < -1){
        x = -1;
    }

    if(y > 1){
        y = 1;
    }
    if (y < -1){
        y = -1;
    }

    draw(scale, x, y);

})

updateDraw()