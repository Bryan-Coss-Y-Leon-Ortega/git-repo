package CSC372.MOD_8;

import java.util.LinkedList;

public class Main extends Algorithm{
    public static void main(String[] args){
        LinkedList<Car> garage = new LinkedList<Car>();

        Car chevy = new Car("Chevy", "Cobalt", 2007);
        Car Mazda = new Car("Mazda", "Sport", 20.2);
        Car Ford = new Car("Ford", "F-150", 15.2);

        garage.add(chevy);
        garage.add(Mazda);
        garage.add(Ford);

        numSort(garage);
        System.out.println(garage.toString());

    }
}
