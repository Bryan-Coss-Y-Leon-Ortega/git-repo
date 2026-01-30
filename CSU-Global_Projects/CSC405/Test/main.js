"use strict";

var CubeWired = function () {
    var canvas;
    var gl;

    var numDividends = 3;
    var posArray = [];
    var colorsArr = [];
    var numPosition = 36;

    var near = -10;
    var far = 10;
    var radius = 8.0;
    var theta = 0.0;
    var phi = 0.0;
    var dr = 5.0 * Math.PI / 180.0;

    var left = -2.0;
    var right = 2.0;
    var ytop = 2.0;
    var bottom = -2.0;

    var modelViewMatrix, projectionMatrix;
    var modelViewMatrixLoc, projectionMatrixLoc;
    var eye;
    const at = vec3(0.0, 0.0, 0.0);
    const up = vec3(0.0, 1.0, 0.0);

    var drawMode = "wire"; // default mode

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

    var vertexColors = [
        [0.4, 0.0, 0.0, 1.0],
        [1.0, 0.5, 0.4, 1.0],
        [1.0, 1.0, 0.6, 1.0],
        [0.1, 0.8, 0.0, 1.0],
        [0.0, 0.3, 1.0, 1.0],
        [1.0, 0.2, 1.0, 1.0]
    ];

    function quadColor(a, b, c, d, color) {
        posArray.push(vertices[a]); colorsArr.push(color);
        posArray.push(vertices[b]); colorsArr.push(color);
        posArray.push(vertices[c]); colorsArr.push(color);
        posArray.push(vertices[a]); colorsArr.push(color);
        posArray.push(vertices[c]); colorsArr.push(color);
        posArray.push(vertices[d]); colorsArr.push(color);
    }

    function divideQuad(a, b, c, d, count, color) {
        if (count > 0) {
            var ab = mix(vertices[a], vertices[b], 0.5);
            var bc = mix(vertices[b], vertices[c], 0.5);
            var cd = mix(vertices[c], vertices[d], 0.5);
            var da = mix(vertices[d], vertices[a], 0.5);
            var center = mix(ab, cd, 0.5);

            var mid_ab = vertices.push(ab) - 1;
            var mid_bc = vertices.push(bc) - 1;
            var mid_cd = vertices.push(cd) - 1;
            var mid_da = vertices.push(da) - 1;
            var mid_center = vertices.push(center) - 1;

            divideQuad(a, mid_ab, mid_center, mid_da, count - 1, color);
            divideQuad(mid_ab, b, mid_bc, mid_center, count - 1, color);
            divideQuad(mid_center, mid_bc, c, mid_cd, count - 1, color);
            divideQuad(mid_da, mid_center, mid_cd, d, count - 1, color);
        } else {
            quadColor(a, b, c, d, color);
        }
    }

    function colorCube() {
        posArray = [];
        colorsArr = [];
        vertices = [
            vec4(-0.5, -0.5, 0.5, 1.0),
            vec4(-0.5, 0.5, 0.5, 1.0),
            vec4(0.5, 0.5, 0.5, 1.0),
            vec4(0.5, -0.5, 0.5, 1.0),
            vec4(-0.5, -0.5, -0.5, 1.0),
            vec4(-0.5, 0.5, -0.5, 1.0),
            vec4(0.5, 0.5, -0.5, 1.0),
            vec4(0.5, -0.5, -0.5, 1.0)
        ];

        // Build 6 faces with colors
        divideQuad(1, 0, 3, 2, numDividends, vertexColors[0]);
        divideQuad(2, 3, 7, 6, numDividends, vertexColors[1]);
        divideQuad(3, 0, 4, 7, numDividends, vertexColors[2]);
        divideQuad(6, 5, 1, 2, numDividends, vertexColors[3]);
        divideQuad(4, 5, 6, 7, numDividends, vertexColors[4]);
        divideQuad(5, 4, 0, 1, numDividends, vertexColors[5]);

        numPosition = posArray.length;
    }

    function uploadBuffers() {
        // Position buffer
        gl.bindBuffer(gl.ARRAY_BUFFER, vBuffer);
        gl.bufferData(gl.ARRAY_BUFFER, flatten(posArray), gl.STATIC_DRAW);

        // Color buffer
        gl.bindBuffer(gl.ARRAY_BUFFER, cBuffer);
        gl.bufferData(gl.ARRAY_BUFFER, flatten(colorsArr), gl.STATIC_DRAW);
    }

    var vBuffer, cBuffer;

    window.onload = function init() {
        canvas = document.getElementById('gl-canvas');

        gl = canvas.getContext('webgl2');
        if (!gl) {
            alert("WebGL 2.0 isn't available");
            return;
        }
        gl.viewport(0, 0, canvas.width, canvas.height);
        gl.clearColor(1.0, 1.0, 1.0, 1.0);
        gl.enable(gl.DEPTH_TEST);

        var program = initShaders(gl, "vertex-shader", "fragment-shader");
        gl.useProgram(program);

        vBuffer = gl.createBuffer();
        cBuffer = gl.createBuffer();

        var PositionLoc = gl.getAttribLocation(program, "aPosition");
        gl.bindBuffer(gl.ARRAY_BUFFER, vBuffer);
        gl.vertexAttribPointer(PositionLoc, 4, gl.FLOAT, false, 0, 0);
        gl.enableVertexAttribArray(PositionLoc);

        var ColorLoc = gl.getAttribLocation(program, "aColor");
        gl.bindBuffer(gl.ARRAY_BUFFER, cBuffer);
        gl.vertexAttribPointer(ColorLoc, 4, gl.FLOAT, false, 0, 0);
        gl.enableVertexAttribArray(ColorLoc);

        modelViewMatrixLoc = gl.getUniformLocation(program, "uModelViewMatrix");
        projectionMatrixLoc = gl.getUniformLocation(program, "uProjectionMatrix");

        // Build initial cube and upload
        colorCube();
        uploadBuffers();

        // Toggle buttons
        document.getElementById("WiredCube").onclick = function () {
            drawMode = "wire";
        };
        document.getElementById("SolidCube").onclick = function () {
            drawMode = "solid";
        };

        // Subdivision controls
        document.getElementById("incSub").onclick = function () {
            numDividends++;
            colorCube();
            uploadBuffers();
        };
        document.getElementById("decSub").onclick = function () {
            if (numDividends > 0) {
                numDividends--;
                colorCube();
                uploadBuffers();
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

        if (drawMode === "wire") {
            for (var i = 0; i < numPosition; i += 3) {
                gl.drawArrays(gl.LINE_LOOP, i, 3);
            }
        } else {
            gl.drawArrays(gl.TRIANGLES, 0, numPosition);
        }

        requestAnimationFrame(render);
    }
}

CubeWired();
