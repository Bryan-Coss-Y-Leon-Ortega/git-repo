var CubeWired = function () {
    var canvas;
    var gl;



    var numDividends = 3;

    var posArray = [];
    var colorsArr = [];
    var normalsArr = [];

    var vBuffer, cBuffer, nBuffer;

    var numPosition = 36;

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

    // Rotation
    var xAxis = 0;
    var yAxis = 1;
    var zAxis = 2;
    var axis = 0;
    var thetaAxis = [0, 0, 0];
    var flag = false;



    // The light fixtures
    var va = vec4(0.0, 0.0, -1.0, 1);
    var vb = vec4(0.0, 0.942809, 0.333333, 1);
    var vc = vec4(-0.816497, -0.471405, 0.333333, 1);
    var vd = vec4(0.816497, -0.471405, 0.333333, 1);

    var lightPosition = vec4(1.0, 1.0, 1.0, 0.0);
    var lightAmbient = vec4(0.2, 0.2, 0.2, 1.0);
    var lightDiffuse = vec4(1.0, 1.0, 1.0, 1.0);
    var lightSpecular = vec4(1.0, 1.0, 1.0, 1.0);

    var materialAmbient = vec4(1.0, 0.0, 1.0, 1.0);
    var materialDiffuse = vec4(1.0, 0.8, 0.0, 1.0);
    var materialSpecular = vec4(1.0, 1.0, 1.0, 1.0);
    var materialShininess = 20.0;

    var ctm;
    var ambientColor, diffuseColor, specularColor;

    var modelViewMatrix, projectionMatrix;
    var modelViewMatrixLoc, projectionMatrixLoc;
    var nMatrix, nMatrixLoc;


    var eye;
    const at = vec3(0.0, 0.0, 0.0);
    const up = vec3(0.0, 1.0, 0.0);



    var drawMode = "Wire";

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
        [1.0, 0.2, 1.0, 1.0],
        [0.1, 0.0, 0.5, 1.0],
        [0.3, 1.0, 1.0, 1.0]
    ];

    function compNormal(a, b, c) {
        var t1 = subtract(b, a);
        var t2 = subtract(c, a);
        return normalize(cross(t1, t2));
    }

    function quadColor(a, b, c, d, color) {

        var normal = compNormal(vertices[a], vertices[b], vertices[c]);

        [a, b, c, a, c, d].forEach(v => {
            posArray.push(vertices[v]);
            normalsArr.push(normal);
            colorsArr.push(color);
        });

    }


    function divideQuad(a, b, c, d, count, color) {
        if (count > 0) {
            var ab = mix(vertices[a], vertices[b], 0.5);
            var bc = mix(vertices[b], vertices[c], 0.5);
            var cd = mix(vertices[c], vertices[d], 0.5);
            var da = mix(vertices[d], vertices[a], 0.5);
            var center = mix(ab, cd, 0.5);

            // New midpoint to vertex array
            var mid_ab = vertices.push(ab) - 1;
            var mid_bc = vertices.push(bc) - 1;
            var mid_cd = vertices.push(cd) - 1;
            var mid_da = vertices.push(da) - 1;
            var mid_center = vertices.push(center) - 1;

            divideQuad(a, mid_ab, mid_center, mid_da, count - 1, color);
            divideQuad(mid_ab, b, mid_bc, mid_center, count - 1, color);
            divideQuad(mid_center, mid_bc, c, mid_cd, count - 1, color);
            divideQuad(mid_da, mid_center, mid_cd, d, count - 1, color);
        }
        else {
            quadColor(a, b, c, d, color);
        }


    }
    // this is the color cube similar to the cube example of page 156
    // the quad function must generate 2 triangles for each face, 6 vertices
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

        divideQuad(1, 0, 3, 2, numDividends, vertexColors[0]);
        divideQuad(2, 3, 7, 6, numDividends, vertexColors[1]);
        divideQuad(3, 0, 4, 7, numDividends, vertexColors[2]);
        divideQuad(6, 5, 1, 2, numDividends, vertexColors[3]);
        divideQuad(4, 5, 6, 7, numDividends, vertexColors[4]);
        divideQuad(5, 4, 0, 1, numDividends, vertexColors[5]);

        numPosition = posArray.length;
    }

    // Upload buffers to GPU
    function uploadBuffers() {
        // Position buffer
        gl.bindBuffer(gl.ARRAY_BUFFER, vBuffer);
        gl.bufferData(gl.ARRAY_BUFFER, flatten(posArray), gl.STATIC_DRAW);

        // Color buffer
        gl.bindBuffer(gl.ARRAY_BUFFER, cBuffer);
        gl.bufferData(gl.ARRAY_BUFFER, flatten(colorsArr), gl.STATIC_DRAW);

        // Normals buffer
        gl.bindBuffer(gl.ARRAY_BUFFER, nBuffer);
        gl.bufferData(gl.ARRAY_BUFFER, flatten(normalsArr), gl.STATIC_DRAW);
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

        // Hidden surface removal
        gl.enable(gl.CULL_FACE);
        gl.cullFace(gl.BACK);
        gl.frontFace(gl.CCW);

        // This will initialize the vertex-shaders and the fragment-shaders in the html doc
        var program = initShaders(gl, "vertex-shader", "fragment-shader");
        gl.useProgram(program);

        // Creates and load postion buffer
        vBuffer = gl.createBuffer();
        cBuffer = gl.createBuffer();
        nBuffer = gl.createBuffer();


        // How to access position data from buffer
        var PositionLoc = gl.getAttribLocation(program, "aPosition");
        gl.bindBuffer(gl.ARRAY_BUFFER, vBuffer);
        gl.vertexAttribPointer(PositionLoc, 4, gl.FLOAT, false, 0, 0)
        gl.enableVertexAttribArray(PositionLoc);

        // How to uce the color buffer data
        var colorLoc = gl.getAttribLocation(program, "aColor");
        gl.bindBuffer(gl.ARRAY_BUFFER, cBuffer);
        gl.vertexAttribPointer(colorLoc, 4, gl.FLOAT, false, 0, 0);
        gl.enableVertexAttribArray(colorLoc)

        // Normal attributes
        var normalLoc = gl.getAttribLocation(program, "aNormal");
        gl.bindBuffer(gl.ARRAY_BUFFER, nBuffer);
        gl.vertexAttribPointer(normalLoc, 3, gl.FLOAT, false, 0, 0);
        gl.enableVertexAttribArray(normalLoc);

        // Uniform locations
        modelViewMatrixLoc = gl.getUniformLocation(program, "uModelViewMatrix");
        projectionMatrixLoc = gl.getUniformLocation(program, "uProjectionMatrix");
        nMatrixLoc = gl.getUniformLocation(program, "uNormalMatrix");

        // Light uniforms
        var ambientProduct = mult(lightAmbient, materialAmbient);
        var diffuseProduct = mult(lightDiffuse, materialDiffuse);
        var specularProduct = mult(lightSpecular, materialSpecular);

        gl.uniform4fv(gl.getUniformLocation(program, "uAmbientProduct"), flatten(ambientProduct));
        gl.uniform4fv(gl.getUniformLocation(program, "uDiffuseProduct"), flatten(diffuseProduct));
        gl.uniform4fv(gl.getUniformLocation(program, "uSpecularProduct"), flatten(specularProduct));
        gl.uniform4fv(gl.getUniformLocation(program, "uLightPosition"), flatten(lightPosition));
        gl.uniform1f(gl.getUniformLocation(program, "uShininess"), materialShininess);

        // Build the initial cube
        colorCube();
        uploadBuffers();

        //Button stuff
        document.getElementById("WiredCube").onclick = function () {
            drawMode = 'Wire';
        }
        document.getElementById("SolidCube").onclick = function () {
            drawMode = "Solid";
        }

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

        document.getElementById("xAxis").onclick = function () { axis = xAxis; };
        document.getElementById("yAxis").onclick = function () { axis = yAxis; };
        document.getElementById("zAxis").onclick = function () { axis = zAxis; };
        document.getElementById("rotate").onclick = function () { flag = !flag; };

        // This increases the wire amount
        document.getElementById("incSub").onclick = function () {
            numDividends += 1;
            colorCube();
            uploadBuffers()
        };
        
        // This decreases the wire amount
        document.getElementById("decSub").onclick = function () {
            if (numDividends > 0) {
                numDividends -= 1;
                colorCube();
                uploadBuffers()
            }
        };

        render();
    }
    //This will render the wired cube
    function render() {

        gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);

        if (flag) thetaAxis[axis] += 1.0;

        var rotationMatrix = mat4();
        rotationMatrix = mult(rotationMatrix, rotate(thetaAxis[xAxis], vec3(1, 0, 0)));
        rotationMatrix = mult(rotationMatrix, rotate(thetaAxis[yAxis], vec3(0, 1, 0)));
        rotationMatrix = mult(rotationMatrix, rotate(thetaAxis[zAxis], vec3(0, 0, 1)));

        // Camera
        eye = vec3(radius * Math.sin(theta) * Math.cos(phi),
            radius * Math.sin(theta) * Math.sin(phi),
            radius * Math.cos(theta));

        var cameraMatrix = lookAt(eye, at, up);
        projectionMatrix = ortho(left, right, bottom, ytop, near, far);
        modelViewMatrix = mult(cameraMatrix, rotationMatrix);

        // compute normal matrix
        nMatrix = normalMatrix(modelViewMatrix, true);

        gl.uniformMatrix4fv(modelViewMatrixLoc, false, flatten(modelViewMatrix));
        gl.uniformMatrix4fv(projectionMatrixLoc, false, flatten(projectionMatrix));
        gl.uniformMatrix3fv(nMatrixLoc, false, flatten(nMatrix));

        if (drawMode === "Wire") {
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
