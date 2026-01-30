"use strict";

  let gl;
  let theta = 0.0;
  let thetaLoc;
  let delay = 100;
  let direction = true;

  window.onload = function () {
    const canvas = document.getElementById("gl-canvas");
    gl = canvas.getContext("webgl");

    if (!gl) {
      alert("WebGL not supported");
      return;
    }

    gl.viewport(0, 0, canvas.width, canvas.height);
    gl.clearColor(1.0, 1.0, 1.0, 1.0);

    // Get shader sources
    const vsSource = document.getElementById("vertex-shader").text.trim();
    const fsSource = document.getElementById("fragment-shader").text.trim();

    // Compile and link shaders
    const program = createProgram(gl, vsSource, fsSource);
    gl.useProgram(program);

    // Define diamond vertices (x, y)
    const vertices = new Float32Array([
       0.0,  0.8,
      -0.8,  0.0,
       0.0, -0.8,
       0.8,  0.0
    ]);

    // Create buffer and upload data
    const buffer = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, buffer);
    gl.bufferData(gl.ARRAY_BUFFER, vertices, gl.STATIC_DRAW);

    // Setup attribute pointer
    const positionLoc = gl.getAttribLocation(program, "aPosition");
    gl.vertexAttribPointer(positionLoc, 2, gl.FLOAT, false, 0, 0);
    gl.enableVertexAttribArray(positionLoc);

    // Get uniform location
    thetaLoc = gl.getUniformLocation(program, "uTheta");

    // Setup controls
    document.getElementById("Direction").onclick = () => {
      direction = !direction;
    };

    document.getElementById("Controls").onclick = (event) => {
      switch (event.target.index) {
        case 0:
          direction = !direction;
          break;
        case 1:
          delay /= 2;
          if (delay < 10) delay = 10;
          break;
        case 2:
          delay *= 2;
          if (delay > 1000) delay = 1000;
          break;
      }
    };

    window.onkeydown = (event) => {
      switch (event.key) {
        case '1':
          direction = !direction;
          break;
        case '2':
          delay /= 2;
          if (delay < 10) delay = 10;
          break;
        case '3':
          delay *= 2;
          if (delay > 1000) delay = 1000;
          break;
      }
    };

    render();
  };

  function render() {
    gl.clear(gl.COLOR_BUFFER_BIT);

    theta += direction ? 0.1 : -0.1;
    gl.uniform1f(thetaLoc, theta);

    gl.drawArrays(gl.TRIANGLE_FAN, 0, 4);

    setTimeout(() => requestAnimationFrame(render), delay);
  }

  function createProgram(gl, vertexSource, fragmentSource) {
    const vertexShader = compileShader(gl, gl.VERTEX_SHADER, vertexSource);
    const fragmentShader = compileShader(gl, gl.FRAGMENT_SHADER, fragmentSource);

    const program = gl.createProgram();
    gl.attachShader(program, vertexShader);
    gl.attachShader(program, fragmentShader);
    gl.linkProgram(program);

    if (!gl.getProgramParameter(program, gl.LINK_STATUS)) {
      console.error('Program failed to link:', gl.getProgramInfoLog(program));
      return null;
    }
    return program;
  }

  function compileShader(gl, type, source) {
    const shader = gl.createShader(type);
    gl.shaderSource(shader, source);
    gl.compileShader(shader);

    if (!gl.getShaderParameter(shader, gl.COMPILE_STATUS)) {
      console.error('Shader compile failed:', gl.getShaderInfoLog(shader));
      gl.deleteShader(shader);
      return null;
    }
    return shader;
  }
  
  