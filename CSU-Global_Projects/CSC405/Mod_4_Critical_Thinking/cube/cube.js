"use strict";

var canvas;
var gl;

// 2 triangles per face, 6 faces, and 3 verticies
var numPosition = 36;

var positionArr = [];
var colorsArr = [];

var xAxis = 0;
var yAxis = 1;
var zAxis = 2;

// this will rotate at the (1,2,3) axis respectively
var axis = 2;
var theta = [0, 0, 0];


var thetaLoc;

window.onload = function init() {

    canvas = document.getElementById("glCanvas");

    gl = canvas.getContext('webgl2');
    if (!gl) {
        alert("WebGL 2.0 isn't available");
        return;
    }


    colorCube();

    gl.viewport(0, 0, canvas.width, canvas.height);
    gl.clearColor(1.0, 1.0, 1.0, 1.0);

    // This will enable 3d depth testing
    gl.enable(gl.DEPTH_TEST);

    // This will initialize the vertex-shaders and the fragment-shaders in the html doc
    var program = initShaders(gl, "vertex-shader", "fragment-shader");
    gl.useProgram(program);

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

    thetaLoc = gl.getUniformLocation(program, "uTheta");

    
    // This will be the action buttons that will change the rotation type
    document.getElementById( "xButton" ).onclick = function () {
        axis = xAxis;
    };
    document.getElementById( "yButton" ).onclick = function () {
        axis = yAxis;
    };
    document.getElementById( "zButton" ).onclick = function () {
        axis = zAxis;
    };

    render();

};

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

// 
function quad(a, b, c, d) {

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

    var indices = [a, b, c, a, c, d];

    for (var i = 0; i < indices.length; ++i) {

        positionArr.push(vertices[indices[i]]);

        colorsArr.push(vertexColors[a]);


    }

    // This will start the render process for the cube, page 174

}

function render() 
{
    gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);

    theta[axis] += 3.0;

    gl.uniform3fv(thetaLoc, (theta));

    gl.drawArrays(gl.TRIANGLES, 0, numPosition);
    requestAnimationFrame(render);
}