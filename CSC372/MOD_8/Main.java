package CSC372.MOD_8;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main extends Algorithm {
    public static void main(String[] args) throws IOException {

        /*
         * 
         * This is the information of the file that is located in the folder.
         */
        File file = new File("C:\\Users\\bryan\\git-repo\\CSC372\\MOD_8\\CarList.txt"); // file path
        Scanner scan = null; // Scanner to grab all information from file

        // This is where all the cars will be stored, a linkedlist of cars named garage
        LinkedList<Car> garage = new LinkedList<Car>();

        // These are cars that will be placed into the garage, manually inserted
        Car chevy = new Car("Chevy", "Cobalt", 2007);
        Car Mazda = new Car("Mazda", "Sport", 20.2);
        Car Ford = new Car("Ford", "F-150", 15.2);

        // All cars added to the garage.
        garage.add(chevy);
        garage.add(Mazda);
        garage.add(Ford);

        /*
         * This is the switch statement that will give the user the ability to read and
         * write into the text file
         * 1 to print the garage
         * 2 to write into the garage
         * 3 to quit
         * This will be in a do-while loop
         */
        int choice = 0;
        Scanner scann = new Scanner(System.in);

        // This will read all file of the garage
        // FileInputStream fileInput = new FileInputStream(file);

        do {
            System.out.println(
                    "This is the garage interface, here we will interact with a text file for the following options:");
            System.out.println("1 to print the garage\n2 to write into the garage\n3 to quit");

            choice = scann.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Here is the content of the file: ");
                    try (FileInputStream fileInput = new FileInputStream(file)) {
                        //scan = new Scanner(fileInput);
                        readText(garage, fileInput);
                        //fileInput.close();
                        numSort(garage);
                        System.out.println(garage.toString());
                    } catch (IOException e) {
                        System.out.println("Error reading file:" + e);
                    }
                    break;

                case 2:
                    System.out.println("Opening the garage file");
                    writeGarage(garage, file);
                    break;

                case 3:
                    System.out.println("Thank you for using the program");
                    break;

                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
            //scann.next();

        } while (choice != 3);

        // Here we close what we have opened.
        // fileInput.close();
        //scan.close();
        scann.close();

        // reread the file after writing new data

        //numSort(garage);

    }

}
