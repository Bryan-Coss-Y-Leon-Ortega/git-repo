package CSC372.MOD_8;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main extends Algorithm{
    public static void main(String[] args) throws IOException{
        LinkedList<Car> garage = new LinkedList<Car>();

        Car chevy = new Car("Chevy", "Cobalt", 2007);
        Car Mazda = new Car("Mazda", "Sport", 20.2);
        Car Ford = new Car("Ford", "F-150", 15.2);

        garage.add(chevy);
        garage.add(Mazda);
        garage.add(Ford);

        numSort(garage);
        System.out.println(garage.toString());

        FileInputStream fileInput = null;
        Scanner scan = null;
        String make;
        String model;
        double mpg;

        //Attempt at opening file
        System.out.println("Opening CarList.txt");
        fileInput = new FileInputStream("C:\\Users\\bryan\\git-repo\\CSC372\\MOD_8\\CarList.txt");
        scan = new Scanner(fileInput);

        make = scan.next();
        model = scan.next();
        mpg = scan.nextDouble();

        System.out.println(make);
        System.out.println(model);
        System.out.println(mpg);

        Car newCar = new Car(make, model, mpg);
        garage.add(newCar);
        System.out.println(garage.toString());


        fileInput.close();
        scan.close();




    }
}
