package CSC372.MOD_8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
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
     * Need a way to try catch for the file (FileNotFoundException)
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
                words = line.split("\s+"); // Splits the line into 3 different words 
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
    //This is a program the will read the existing list of the garage and return all the values. 
    public static void readList(LinkedList<Car> garage) {
        
        for(Car car: garage){
            System.out.println(car.toString());
        }
    }


    public static void writeGarage(LinkedList<Car> garage, File file) throws IOException{

        String make = "";
        String model = "";
        Double mpg = 0.00;
        boolean flag = false;
        Scanner scan = new Scanner(System.in);
        try (BufferedWriter output = new BufferedWriter(new FileWriter(file, true))) {
            System.out.println("You will be writing into the garage file. The format to enter a new car is Make Model MPG");
            System.out.println("If a car is more than one word, please attach them with a dash");

            while(flag == false){
                flag = true;
                try{
                    System.out.println("Please enter the Make of the vehicle: ");
                    make = scan.nextLine();
                    
                    System.out.println("Please enter the Model of the vehicle: ");
                    model = scan.nextLine();
                    
                    System.out.println("Please enter the MPG of the vehicle: ");
                    mpg = scan.nextDouble();
                    
   
                }catch(Exception e){
                    System.out.println(e.getMessage());
                    System.out.println("Error with the input formatting");
                    scan.nextLine();
                    flag = false;
                }
                
            }
            System.out.println("Saving: "+ make + " " + model + " " + mpg);
            output.append(make + " " + model + " " + mpg + "\n");
            output.flush();
        }

        scan.close();
    }


}
