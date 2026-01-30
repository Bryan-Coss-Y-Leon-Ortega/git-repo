"use strict";

var sphere = function () {
    var canvas;
    var gl;

    var numDividends = 3;

    var index = 0;

    var posArray = [];

    var near = -10;
    var far = 10;
    var radius = 8.0;
    var theta = 0.0;
    var phi = 0.0;
    var dr = 5.0 * Math.PI / 180.0;

    var left = -2.0;
    var right = 2.0;
    var ytop = 2.0
    var bottom = -2.0;

    var modelViewMatrix, projectionMatrix;
    var modelViewMatrixLoc, projectionMatrixLoc;
    var eye;
    const at = vec3(0.0, 0.0, 0.0);
    const up = vec3(0.0, 1.0, 0.0);

    // Triangles that will be added to the wires
    function triangle(a, b, c) {
        posArray.push(a);
        posArray.push(b);
        posArray.push(c);
        index += 3;
    }
    // Midpoint subdivision
    function divideTriangles(a, b, c, count) {
        if (count > 0) {
            var ab = normalize(mix(a, b, 0.5), true);
            var ac = normalize(mix(a, c, 0.5), true);
            var bc = normalize(mix(b, c, 0.5), true);

            divideTriangles(a, ab, ac, count - 1);
            divideTriangles(ab, b, bc, count - 1);
            divideTriangles(bc, c, ac, count - 1);
            divideTriangles(ab, bc, ac, count - 1);

        }
        else {
            // Draws triangle at the end of the recursion
            triangle(a, b, c);
        }
    }
    function tetrahedron(a, b, c, d, n) {
        divideTriangles(a, b, c, n);
        divideTriangles(d, c, b, n);
        divideTriangles(a, d, b, n);
        divideTriangles(a, c, d, n);
    }


    window.onload = function init() {
        canvas = document.getElementById('gl-canvas');

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

        // Approximation where we will draw the tetrahedron
        // This will be the vertices
        var va = vec4(0.0, 0.0, -1.0, 1);
        var vb = vec4(0.0, 0.941809, 0.333333, 1);
        var vc = vec4(-0.816497, -0.471405, 0.333333, 1);
        var vd = vec4(0.816497, -0.471405, 0.333333, 1);

        // This will initiate the recursion that will add or sub the wires
        tetrahedron(va, vb, vc, vd, numDividends);
        
        // Creates and load postion buffer
        var vBuffer = gl.createBuffer();
        gl.bindBuffer(gl.ARRAY_BUFFER, vBuffer);
        gl.bufferData(gl.ARRAY_BUFFER, flatten(posArray), gl.STATIC_DRAW);

        // How to access position data from buffer
        var PositionLoc = gl.getAttribLocation(program, "aPosition");
        gl.vertexAttribPointer(PositionLoc, 4, gl.FLOAT, false, 0, 0)
        gl.enableVertexAttribArray(PositionLoc);

        modelViewMatrixLoc = gl.getUniformLocation(program, "uModelViewMatrix");
        projectionMatrixLoc = gl.getUniformLocation(program, "uProjectionMatrix");


        // Theta will rotate in the x direction
        document.getElementById("thetaPlus").onclick = function () {
            theta += dr
        };
        document.getElementById("thetaMinus").onclick = function () {
            theta -= dr
        };
        // Phi will rotate in the y direction
        document.getElementById("phiPlus").onclick = function () {
            phi += dr
        };
        document.getElementById("phiMinus").onclick = function () {
            phi -= dr
        };

        // This increases the wire amount
        document.getElementById("incSub").onclick = function () {
            numDividends += 1;
            index = 0;
            posArray = [];
            init();
        };

        // This decreases the wire amount
        document.getElementById("decSub").onclick = function () {
            if (numDividends > 0) {

                numDividends -= 1;
                index = 0;
                posArray = [];
                init();
            }

        };




        render();


    }
    function render() {

        gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);

        eye = vec3(radius * Math.sin(theta) * Math.cos(phi),
            radius * Math.sin(theta) * Math.sin(phi),
            radius * Math.cos(theta));

        modelViewMatrix = lookAt(eye, at, up);
        projectionMatrix = ortho(left, right, bottom, ytop, near, far);

        gl.uniformMatrix4fv(modelViewMatrixLoc, false, flatten(modelViewMatrix));
        gl.uniformMatrix4fv(projectionMatrixLoc, false, flatten(projectionMatrix));

        for (var i = 0; i < index; i += 3) {
            gl.drawArrays(gl.LINE_LOOP, i, 3);
        }
        requestAnimationFrame(render);
    }
}
sphere();