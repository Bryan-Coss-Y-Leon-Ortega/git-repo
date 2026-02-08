/*
    This will be a chapter that focuses on 
*/


class Doggos {
    constructor(name, weight){
        this.name = name;
        this.weight = weight;
    }
    greet(){
        console.log("Bark bake amigo!");
    }
    compliment(name){
        return "Hello "+ name;
    }
}

let bigDog = new Doggos("Bryan", 3.7);

console.log("My dog is:", bigDog.name, " and weighs ", bigDog.weight);
bigDog.greet();
bigDog.compliment("Bryan");
console.log(bigDog.compliment("Bryan"));

class Persons{

    constructor(firstname, lastname){
        if(firstname.startsWith("M")){
            this.firstname = firstname;
        }else{
            this.firstname = "M"+firstname;
        }
        if(lastname.startsWith("W")){
            this.lastname = lastname;
        }else{
            this.lastname = "W"+lastname;
        }
        
    }
    greet(){
        console.log("How are you doing weirdo");
    }
    compliment(name){
        return "looking good " + name; 
    }
}

let p1 = new Persons("Mitch", "Western");
console.log(p1.firstname, p1.lastname);
p1.greet();
p1.compliment("Bryan");

let p2 = new Persons("Bryan", "East");
console.log(p2.firstname, p2.lastname);

/*
    This is an example of an encapulated type of class. 
    The setters and getters give the system permission to change the names and types.
*/
class Pokemon{
    #name;
    #type;
    constructor(name, type){
        this.#name = name;
        this.#type = type;
    }
    get name(){
        return this.#name;
    }
    set name(name){
        this.#name = name;
    }
    get type(){
        return this.#type;
    }
    set type(type){
        this.#type = type;
    }
}

let pichu = new Pokemon("Pichu", "Electric");
console.log(pichu.name, "is an", pichu.type, "type");
// this will change the variable informatiop
pichu.type = "Fighting";
console.log(pichu.type);

class godPokemons extends Pokemon{
    #color;
    #speed;
    constructor(name, type, color, speed){
        super(name, type);
        this.#color = color;
        this.#speed = speed;
    }
    get speed(){
        return this.#speed;
    }
    set speed(speed){
        this.#speed = speed;
    }
    get color(){
        return this.#color;
    }
    set color(color){
        this.#color = color;
    }
    call(){
        console.log("ROOOARR!!!");
    }
}

let arceus = new godPokemons("Arceus", "Psychic", "White", 15);
arceus.call();
console.log(arceus.name, arceus.type, arceus.color, arceus.speed);