const canvas = document.getElementById("glCanvas");
const gl = canvas.getContext("webgl");

// Check if WebGL is available
if (!gl) {
  alert("WebGL not supported!");
}

// Vertex shader
const vsSource = `
  attribute vec2 a_Position;
  void main() {
    gl_Position = vec4(a_Position, 0.0, 1.0);
    gl_PointSize = 1.0;
  }
`;

// Fragment shader, here every fragment (pixel-like) will get a color 
const fsSource = `
  void main() {
    gl_FragColor = vec4(1.0, 0.2, 0.1, 1.0);
  }
`;

// Compile shader
function createShader(gl, type, source) {
  const shader = gl.createShader(type);
  gl.shaderSource(shader, source);
  gl.compileShader(shader);
  return shader;
}

// Link shaders into program
function createProgram(gl, vShader, fShader) {
  const program = gl.createProgram();
  gl.attachShader(program, vShader);
  gl.attachShader(program, fShader);
  gl.linkProgram(program);
  return program;
}

const vertexShader = createShader(gl, gl.VERTEX_SHADER, vsSource);
const fragmentShader = createShader(gl, gl.FRAGMENT_SHADER, fsSource);
const program = createProgram(gl, vertexShader, fragmentShader);
gl.useProgram(program);

// Recursive triangle subdivision
let points = [];

function midpoint(a, b) {
  return [(a[0] + b[0]) / 2, (a[1] + b[1]) / 2];
}

function divideTriangle(a, b, c, count) {
  if (count === 0) {
    points.push(a, b, c);
  } else {
    const ab = midpoint(a, b);
    const bc = midpoint(b, c);
    const ca = midpoint(c, a);
    count--;
    divideTriangle(a, ab, ca, count);
    divideTriangle(b, bc, ab, count);
    divideTriangle(c, ca, bc, count);
  }
}

// Initial triangle 
 A = [-1, -1];
 B = [0, 1];
 C = [1, -1];
 recursionDepth = 7;

divideTriangle(A, B, C, recursionDepth);

// Flatten points
 vertices = new Float32Array(points.flat());

// Send data to GPU
var buffer = gl.createBuffer();
gl.bindBuffer(gl.ARRAY_BUFFER, buffer);
gl.bufferData(gl.ARRAY_BUFFER, vertices, gl.STATIC_DRAW);

var a_Position = gl.getAttribLocation(program, 'a_Position');
gl.vertexAttribPointer(a_Position, 2, gl.FLOAT, false, 0, 0);
gl.enableVertexAttribArray(a_Position);

// Clear and draw
gl.clearColor(1.0, 1.0, 1.0, 1.0);
gl.clear(gl.COLOR_BUFFER_BIT);
gl.drawArrays(gl.TRIANGLES, 0, vertices.length / 2);