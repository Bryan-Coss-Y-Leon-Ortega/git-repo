/*
    This example will print all values within an array us a "for of loop"
*/

let arr = ["Bryan", "Matt", "Roy", "Matias", "Giovanny", 6]
for (let variable of arr){
    
    console.log(variable);
}


/*
    This example will show printing all values of an object using a "for in loop"
*/
let car = {
    model: "Jetta",
    make: "Volks",
    year: 1999,
    color: "Black" 
};
for(let prop in car){
    console.log(car[prop]);
}

/*
    This will loop over an object and convert the keys into an array
*/
let arrKeys = Object.keys(car);
console.log(arrKeys);

/*
    This will loop the keys and values together
*/
for(let i = 0; i< arrKeys.length; i++){
    console.log(arrKeys[i] + ": " + car[arrKeys[i]]);
}

let arrEntries = Object.entries(car);
console.log(arrEntries);

for(const[key, value] of Object.entries(car)){
    console.log(key, ":", value);
}

let arr1 = [];
let arr2 = [];
let arr3 = [];
let arr4 = [];
let arr5 = [];

let arrOfArr=[arr1, arr2, arr3, arr4, arr5];

let x = 1;
for(let i = 0; i < 5; i++){
    for(j = 1; j < 6; j++){

        arrOfArr[i].push(j*x);
    }
    x++;
}
console.log(arrOfArr);

