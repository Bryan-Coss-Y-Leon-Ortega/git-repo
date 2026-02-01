let arr1 = ["Black", "Blue", "White"];
console.log(arr1);

cars = ["Toyota", "Volkswagon","Chevy"];
console.log(cars[0]);

colors = ["black", "orange", "pink"]
booleans = [true, false, false, true];
emptyArray = [];

console.log("Length of colors:", colors.length);
console.log("Length of booleans:", booleans.length);
console.log("Length of empty array:", emptyArray.length);

shoppingList = ["Milk", "Bread", "Apple"];
console.log(shoppingList);
console.log(shoppingList.length);
shoppingList[1] = "Bananas";
console.log(shoppingList);

let findValue = shoppingList.find(function(e){ return e === "Milk"});
console.log("This is the find value for Milk test:",findValue);

let findIndex = shoppingList.indexOf("Apple");
console.log("This is the find index for Apple test:",findIndex);

shoppingList.sort();
console.log(shoppingList);

shoppingList.reverse();
console.log(shoppingList);

shoppingList.push("Cookies");
shoppingList.push("Pop");

console.log(shoppingList);
shoppingList.sort();
shoppingList.reverse();
console.log(shoppingList);

let arrVal1 = [1,2,3];
let arrVal2 = [4,5,6];
let arrVal3 = [7,8,9];
let arrOfArrays = [arrVal1, arrVal2, arrVal3];
//this will add 0 to the begining of the array without deleting any other values.
arrVal1.splice(0,0,0)

console.log(arrOfArrays);
console.log("This is splice added to the beginning",arrVal1)

let dog = {
    dogName: "Bryan",
    weight: 2.14,
    color: "brown",
    biter: true,
};

let dogColor = dog["color"];
let dogWeight = dog.weight;
console.log(dogColor); //this will return the color of the dog object, brown
console.log(dogWeight); //THis will return the weight of the dog object, 2.14
console.log(dog);
dog["age"] = "Three"; //Values can be added to the dog object. 
console.log(dog);
dog.weight = "two"; //Values types can be explcitly changed
console.log(dog);

// Practicing objects in objects
let company = {
    name: "Bryan's Company",
    activity: "Procrastination",
    address:{
        street: "Where I am at",
        zipCode: "42069",
        state: "Grinding"
    },
    employees: 324
};

console.log(company.name, company.address.state);
//This will practice arrays in objects
let activities = {
    name: "Bryan's Place of Fun",
    address:{
        streets: "Grove Street",
        number: 42069,
        zipcode: 187,
        city: "Los Santos"
    },
    activity: ["Swimming", "Soccer", "Baseball"]
};
console.log(activities.name); //Print names
//Prints the objects inside the object
console.log(activities.address.streets, activities.address.city); 
//This will print some of the array values within the object
console.log(activities.activity[0], activities.activity[2]);
//This will push a new value in the array
activities.activity.push("Hockey");
//printing the new array
console.log(activities.activity[3]);
//This will sort the array values inside the object
activities.activity.sort();
//This will print the array values inside the object.
console.log(activities.activity)

//This will be the objects in array example
let farm = [
    {
        animal1: "Pig",
        animal2: "Cow",
        animal3: "Dog"
    },
    {
        equip1: "tractor",
        equip2: "Ho",
        equip3: "Lawnmower"
    }
];
//This is the general format to print the objects within the array
console.log(farm[0].animal1, farm[1].equip3);

//This will be the object in Array in Objects
let club = {
    club1: "Club Penguin",
    nightClub:["Santa Fe", "Charlies", "Downtown", 
        {
        name1: "Street",
        name2: "Butterfly",
        street: "Grove Street"
        }
            ],  
    club3: "Wizard School"
};
//This will return the objects, it will also show the array
console.log(club)
//This will call the array and return all the values in the array
console.log(club.nightClub[3])
//this will return the value of the object in the array
console.log(club.nightClub[3].street)