/*
    This will focus on the different methods to data types we have seen: String, math, date, array, numbers, etc.

*/let example = "Hello";
console.log(
    example.concat(" there!")
    .toUpperCase()
    .replace("THERE", "you")
    .concat(" Cowboy!")
)

let uriExample = "https://www.example.com/submit?name=Bryan Coss Y Leon";
let encode_uri = encodeURI(uriExample);
let encode_uri2 = encodeURIComponent(uriExample);
console.log(encode_uri);
console.log(encode_uri2);
let decode_uri = decodeURI(encode_uri);
let decode_uri2 = decodeURIComponent(encode_uri2);
console.log(decode_uri);
console.log(decode_uri2);

//THis is an example of how to parse strings into numbers to be used.
//This is important to take user input and convert it into numbers for programs
let str_int = "6";
let int_int = parseInt(str_int);
console.log("Type of", int_int, "is", typeof int_int)

// more example of string parsing
let str_float = 6.7;
let int_str = parseInt(str_float);
let flt_str = parseFloat(str_float);
console.log("type of", int_str, typeof int_str);
//This will not return 'float', but number as type
console.log("type of", flt_str, typeof flt_str);

//Here is an example of parse a string to an int or float and the results
let str_str = "Hello";
let str_str_int = parseInt(str_str);
let str_str_flt = parseFloat(str_str);
console.log("Type of", str_str_int, typeof str_str_int);
console.log("Type of", str_str_flt, typeof str_str_flt);
//The int and float variables will return as not a number (NaN).

let arr = ["Fruit", 13, "Vegetables", 7.6, true];

function printStuff(element, index){
    console.log("We are printing: ", element, "on position: ", index, "type of", typeof element);
}
function filterString(element){
    return typeof element === "string";
}
arr.forEach(printStuff);
let strArr = arr.filter(filterString)
console.log(strArr);

//Mapping the values of an Array
let newArr = [1,2,3,4,5];
let mapped_arr = newArr.map(x=> x+1);
console.log(mapped_arr);
console.log(mapped_arr.lastIndexOf(1))
console.log(mapped_arr.lastIndexOf(5))

//Converting strings to arrays
let str_arr = "Hello Moto";
let arr_result = str_arr.split(" ");
console.log(arr_result);

//converting arrays into strings
// The join() by itself will add a comma to the value
// Adding something to the join("") will change the return string. 
let arr_str = ["Hello", "Moto"];
let str_result = arr_str.join(" ");
console.log(str_result);

//This is creating a substring in JS
let slice_str = "We are creating a substring";
let sub1 = slice_str.slice(5);
let sub2 = slice_str.slice(0,6);
console.log(sub1);
console.log(sub2);

//This is replacing parts of a string with .replace()
let new_str = "The wheels on the blouse";
let newer_str = new_str.replace("blouse", "bus");
console.log(newer_str);

// Creating dates in JavaScript
let currentDateTime = new Date();
console.log(currentDateTime);
console.log("Day of the week:", currentDateTime.getDay());
console.log("Day of the month:", currentDateTime.getDate());
console.log("Month:", currentDateTime.getMonth());
console.log("Year:", currentDateTime.getFullYear());
console.log("Time:", currentDateTime.getTime());
// There are options to set the dates and times