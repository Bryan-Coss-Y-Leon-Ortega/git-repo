package CSC372.MOD_8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Algorithm extends Car {

    public static void numSort(LinkedList<Car> Garage) {

        int min;
        for (int i = 0; i < Garage.size() - 1; i++) {
            min = i;
            for (int j = i + 1; j < Garage.size(); j++) {
                if (Garage.get(j).getMpg() < Garage.get(min).getMpg()) {
                    Car temp = Garage.get(i);
                    Garage.set(i, Garage.get(j));
                    Garage.set(j, temp);
                }

            }
        }
    }

    /*
     * 
     * This will read a file into my arraylist
     * 
     */
    public static void readText(LinkedList<Car> garage, FileInputStream fileInput) throws FileNotFoundException{

        String line;
        String[] words;
        String make;
        String model;
        double mpg;

        try (Scanner scan = new Scanner(fileInput)){
            while (scan.hasNextLine()) {

                line = scan.nextLine().trim(); //grabs the next line and removes any extra blank space
                words = line.split("\\s+"); // Splits the line into 3 different words 
                make = words[0];
                model = words[1];            

                try{
                    mpg = Double.parseDouble(words[2]);
                    if(mpg > 0){
                        Car car = new Car(make, model, mpg);
                        garage.add(car);
                    }else{
                        //this will return an error if there is a negative MPG in the car
                        System.out.println(make + " " + model + " has a negative or Zero MPG of: " + mpg + "\nThis car will be removed from the garage list"); 
                    }
                } catch (NumberFormatException e){
                    System.out.println("Invalid MPG value for: " + e);
                } 
            } 
        }
    }

    public static void writeGarage(LinkedList<Car> garage, FileInputStream fileInput){

        System.out.println("You will be writing into the garage file. The file is Make Model MPG");


    }




}
