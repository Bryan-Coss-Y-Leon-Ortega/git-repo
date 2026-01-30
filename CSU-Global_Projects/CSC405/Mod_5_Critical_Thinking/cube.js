"use strict";

var canvas;
var gl;

// 2 triangles per face, 6 faces, and 3 verticies
var numPosition = 36;

var positionArr = [];
var colorsArr = [];


// up and at and other fixed values are set
const at = vec3(0.0, 0.0, 0.0);
const up = vec3(0.0, 1.0, 0.0);
var modelViewMatrix, projectionMatrix;
var modelViewMatrixLoc, projectionMatrixLoc;
var eye;

var near = -1;
var far = 1;
var radius = 1;
var theta = 0.0;
var phi = 0.0;
var dr = 5.0 * Math.PI / 180.0;

var left = -1.0;
var right = 1.0;
var ytop = 1.0;
var bottom = -1.0;

// Vertices, using the homogenous coordinates 
var vertices = [
    vec4(-0.5, -0.5, 0.5, 1.0),
    vec4(-0.5, 0.5, 0.5, 1.0),
    vec4(0.5, 0.5, 0.5, 1.0),
    vec4(0.5, -0.5, 0.5, 1.0),
    vec4(-0.5, -0.5, -0.5, 1.0),
    vec4(-0.5, 0.5, -0.5, 1.0),
    vec4(0.5, 0.5, -0.5, 1.0),
    vec4(0.5, -0.5, -0.5, 1.0)
];

// Random colors, fun to do when I am color blind
var vertexColors = [
    [0.4, 0.0, 0.0, 1.0],
    [1.0, 0.5, 0.4, 1.0],
    [1.0, 1.0, 0.6, 1.0],
    [0.1, 0.8, 0.0, 1.0],
    [0.0, 0.3, 1.0, 1.0],
    [1.0, 0.2, 1.0, 1.0],
    [0.1, 0.0, 0.5, 1.0],
    [0.3, 1.0, 1.0, 1.0]
];

function quad(a, b, c, d) {

    positionArr.push(vertices[a]);
    colorsArr.push(vertexColors[a]);
    positionArr.push(vertices[b]);
    colorsArr.push(vertexColors[a]);
    positionArr.push(vertices[c]);
    colorsArr.push(vertexColors[a]);
    positionArr.push(vertices[a]);
    colorsArr.push(vertexColors[a]);
    positionArr.push(vertices[c]);
    colorsArr.push(vertexColors[a]);
    positionArr.push(vertices[d]);
    colorsArr.push(vertexColors[a]);

}
// this is the color cube similar to the cube example of page 156
// the quad function must generate 2 triangles for each face, 6 vertices
function colorCube() {

    quad(1, 0, 3, 2);
    quad(2, 3, 7, 6);
    quad(3, 0, 4, 7);
    quad(6, 5, 1, 2);
    quad(4, 5, 6, 7);
    quad(5, 4, 0, 1);
}

window.onload = function init() {

    canvas = document.getElementById("glCanvas");

    gl = canvas.getContext('webgl2');
    if (!gl) {
        alert("WebGL 2.0 isn't available");
        return;
    }


    gl.viewport(0, 0, canvas.width, canvas.height);
    gl.clearColor(1.0, 1.0, 1.0, 1.0);

    // This will enable 3d depth testing
    gl.enable(gl.DEPTH_TEST);

    // This will initialize the vertex-shaders and the fragment-shaders in the html doc
    var program = initShaders(gl, "vertex-shader", "fragment-shader");
    gl.useProgram(program);

    colorCube();

    //Creates a cube buffer for the colors created and fills the sides
    var cBuffer = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, cBuffer);
    gl.bufferData(gl.ARRAY_BUFFER, flatten(colorsArr), gl.STATIC_DRAW);

    // How to uce the color buffer data
    var colorLoc = gl.getAttribLocation(program, "aColor");
    gl.vertexAttribPointer(colorLoc, 4, gl.FLOAT, false, 0, 0);
    gl.enableVertexAttribArray(colorLoc);

    // Creates and load postion buffer
    var vBuffer = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, vBuffer);
    gl.bufferData(gl.ARRAY_BUFFER, flatten(positionArr), gl.STATIC_DRAW);

    // How to access position data from buffer
    var PositionLoc = gl.getAttribLocation(program, "aPosition");
    gl.vertexAttribPointer(PositionLoc, 4, gl.FLOAT, false, 0, 0)
    gl.enableVertexAttribArray(PositionLoc);



    modelViewMatrixLoc = gl.getUniformLocation(program, "uModelViewMatrix");
    projectionMatrixLoc = gl.getUniformLocation(program, "uProjectionMatrix");

    // This will be the action slides that will change the rotation
    document.getElementById("depthSlider").oninput = function (event) {
        far = event.target.value / 2;
        near = -event.target.value / 2;
        render();
    };
    document.getElementById("radiusSlider").oninput = function (event) {
        radius = event.target.value;
        render();
    }
    document.getElementById("thetaSlider").oninput = function (event) {
        theta = event.target.value * Math.PI / 180.0;
        render();
    }
    document.getElementById("phiSlider").oninput = function (event) {
        phi = event.target.value * Math.PI / 180.0;
        render();

    }
    document.getElementById("widthSlider").oninput = function (event) {
        right = event.target.value / 2;
        left = -event.target.value / 2;
        render();

    }
    document.getElementById("heightSlider").oninput = function (event) {
        ytop = -event.target.value / 2;
        bottom = event.target.value / 2;
        render();

    }
    render()

    function render() {
        gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);

        eye = vec3(radius * Math.sin(theta) * Math.cos(phi),
                   radius * Math.sin(theta) * Math.sin(phi),
                   radius * Math.cos(theta));

        modelViewMatrix = lookAt(eye, at, up);
        projectionMatrix = ortho(left, right, bottom, ytop, near, far);

        gl.uniformMatrix4fv(modelViewMatrixLoc, false, flatten(modelViewMatrix));
        gl.uniformMatrix4fv(projectionMatrixLoc, false, flatten(projectionMatrix));

        gl.drawArrays(gl.TRIANGLES, 0, numPosition);
        requestAnimationFrame(render);
    }
}