/*
    This will be a few example of how to create functions in javascript.
    These will not be extensive, they will only serve so i can familiarize with the syntax.

*/
let globalVariable = "Something that can be accessed anywhere"

let sayHelloFunction = function sayHello(){
    let you = prompt("What is your name? ");
    console.log("Hello", you + "!");
    console.log(globalVariable);
}


sayHelloFunction();

let x = 10;

let arrowStuff = x => console.log(x);
arrowStuff(x);
    console.log(globalVariable);


let sayHigh = () => console.log("Hi");
sayHigh();

const arr = ["Squirrel", 2, "Buddy"];
arr.forEach(e => console.log(e));

function addTwoNumbers(x,y){
    console.log(x+y);
}
function addFourNumbers(x,y,j,k){
    console.log(x+y+j+k);
    console.log(globalVariable);

}

let arrNum = [5 ,9];
let arrNum2 = [6, 7];

addTwoNumbers(...arrNum);
addTwoNumbers(...arrNum2);

addFourNumbers(...arrNum, ...arrNum2);

function multTwoNumber(param1, param2){
    return param1 * param2;
}
let sol = multTwoNumber(7,3);
console.log(sol);

//This is an example of an IIFE

(function(){
    console.log("This is something that is sent out anon");
})();

//This is an example of the recursive function 
function getRecursive(nr){
    console.log(nr);
    if(nr > 0){ 
        getRecursive(nr-1);
    }else{
        console.log("End of the function!");
    }
}
getRecursive(9);

// this is an anonymous function

// this is invoking the anonymous function
let secretMessage = function(){
    console.log("Secret message.");
};
secretMessage();

//Function Callbacks
function doCallBacks(secretMessage){
    secretMessage();
    console.log("Inside callback function");
}
doCallBacks(secretMessage);