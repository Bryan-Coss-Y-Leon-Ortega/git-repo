"use strict";

let gl, thetaLoc, theta = 0.0;

window.onload = () => {
  const canvas = document.getElementById("gl-canvas");
  gl = canvas.getContext("webgl");

  if (!gl) {
    alert("WebGL not supported");
    return;
  }

  // Setup viewport and clear color
  gl.viewport(0, 0, canvas.width, canvas.height);
  gl.clearColor(1.0, 1.0, 1.0, 1.0);

  // Get shader sources from script tags
  const vsSource = document.getElementById("vertex-shader").text;
  const fsSource = document.getElementById("fragment-shader").text;

  // Compile and link shaders
  const program = initShaders(gl, vsSource, fsSource);
  gl.useProgram(program);

  // Define diamond shape
  const vertices = new Float32Array([
    0.0,  0.6,
   -0.6,  0.0,
    0.6,  0.0,
    0.0, -0.6
  ]);

  // Upload vertex data
  const buffer = gl.createBuffer();
  gl.bindBuffer(gl.ARRAY_BUFFER, buffer);
  gl.bufferData(gl.ARRAY_BUFFER, vertices, gl.STATIC_DRAW);

  // Link attribute
  const positionLoc = gl.getAttribLocation(program, "aPosition");
  gl.vertexAttribPointer(positionLoc, 2, gl.FLOAT, false, 0, 0);
  gl.enableVertexAttribArray(positionLoc);

  // Link uniform
  thetaLoc = gl.getUniformLocation(program, "uTheta");

  render();
};

function render() {
  gl.clear(gl.COLOR_BUFFER_BIT);

  theta += 0.01;
  gl.uniform1f(thetaLoc, theta);

  gl.drawArrays(gl.TRIANGLE_STRIP, 0, 4);
  requestAnimationFrame(render);
}

// Shader compiler
function initShaders(gl, vsSource, fsSource) {
  function compileShader(type, source) {
    const shader = gl.createShader(type);
    gl.shaderSource(shader, source);
    gl.compileShader(shader);

    if (!gl.getShaderParameter(shader, gl.COMPILE_STATUS)) {
      console.error("Shader compile error:", gl.getShaderInfoLog(shader));
      return null;
    }
    return shader;
  }

  const vertexShader = compileShader(gl.VERTEX_SHADER, vsSource);
  const fragmentShader = compileShader(gl.FRAGMENT_SHADER, fsSource);

  const program = gl.createProgram();
  gl.attachShader(program, vertexShader);
  gl.attachShader(program, fragmentShader);
  gl.linkProgram(program);

  if (!gl.getProgramParameter(program, gl.LINK_STATUS)) {
    console.error("Program link error:", gl.getProgramInfoLog(program));
    return null;
  }

  return program;
}
