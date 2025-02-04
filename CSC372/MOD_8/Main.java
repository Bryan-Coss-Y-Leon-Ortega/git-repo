package CSC372.MOD_8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
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

        writeGarage(garage, file);
        
        // This will read all file of the garage
        FileInputStream fileInput = new FileInputStream(file);
        scan = new Scanner(fileInput);
        readText(garage, fileInput);
        fileInput.close();
        scan.close();

        

        // reread the file after writing new data

        numSort(garage);

        System.out.println("Content of the garage \n" + garage.toString());

    }

}
