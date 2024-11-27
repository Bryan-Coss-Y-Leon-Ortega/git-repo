package Mod_8;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.PrintWriter;
//import java.io.FileOutputStream;


public class Mod_8 {

    public static class Automobile {
        private String make;
        private String model;
        private String color;
        private int year;
        private int mileage;

        // This is the default constructor
        public Automobile() {
            make = "Moot";
            model = "Null";
            color = "Null";
            year = -1;
            mileage = -1;
        }

        // This is the initialized constructor for automobile
        public Automobile(String make, String model, String color, int year, int mileage) {
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;

        }

        public String getMake() {
            return make;
        }

        public void setMake(String make) {
            this.make = make;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getMileage() {
            return mileage;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        // This is an override to print the array in a specific format.
        @Override
        public String toString() {
            return make + " " + model + " " + color + " " + year + " " + mileage;
        }

    }

    // Prints everything in the dealership array
    private static void printDealership(Automobile[] dealership) {

        for (int i = 0; i < dealership.length; i++) {
            System.out.println(dealership[i].toString());
        }

    }

    // This method Creates a car for use
    private static Automobile addVehicle(Scanner scan){

        String tempMake = "";
        String tempModel = "";
        String tempColor = "";
        int tempYear = 0;
        int tempMiles = 0;
        String reset = "";

        System.out.println("Please enter make: ");
        tempMake = scan.nextLine();

        System.out.println("Please enter model: ");
        tempModel = scan.nextLine();

        System.out.println("Please enter color: ");
        tempColor = scan.nextLine();

        while (true) {
            System.out.println("Please enter Year: ");
            try {
                tempYear = scan.nextInt();
                if (tempYear > 1886 && tempYear <= 2024) { // Assuming valid car years are between 1886 and the current
                                                           // year
                    break;
                } else {
                    System.out.println("Invalid year. Please enter a year between 1886 and 2024.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid numeric year.");
                scan.nextLine(); // Clear invalid input
            }
        }

        while (true) {
            System.out.println("Please enter Mileage: ");
            try {
                tempMiles = scan.nextInt();
                if (tempMiles >= 0) { // Mileage cannot be negative
                    break;
                } else {
                    System.out.println("Invalid mileage. Please enter a positive number.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid numeric mileage.");
                scan.nextLine(); // Clear invalid input
            }
        }
        // this resets the scans after the int variables.
        reset = scan.nextLine();

        Automobile tempCar = new Automobile(tempMake, tempModel, tempColor, tempYear, tempMiles);
        return tempCar;
        
    }
    
    // This method adds a car into the inventory
    // This is done by creating a new automobile array length +1
    // Adding everything in the original garage and then adding the new one in the
    // back
    private static Automobile[] addCar(Automobile[] dealership2, Scanner scan) {
        

        Automobile tempCar = addVehicle(scan);
        
        Automobile[] tempDealer = new Automobile[dealership2.length + 1];
        // Array copy method
        for (int i = 0; i < dealership2.length; i++) {
            tempDealer[i] = dealership2[i];
        }
        tempDealer[dealership2.length] = tempCar;

        return tempDealer;
    }

    // This will use the car information to seek out the car that needs to be
    // deleted
    // This uses the for loop that looks like python
    // This finds the specific car and deletes it
    // Returns an error if there is no car matching the description
    
    private static Automobile[] deleteCar(Automobile[] dealership, Scanner scan) {
   
        Boolean carFound = false;
        int i = 0;
        Automobile[] tempDeal = new Automobile[dealership.length - 1];

        Automobile tempCar = addVehicle(scan);
        // This will search for the car
        for (Automobile car : dealership) {
            if (car.getMake().equalsIgnoreCase(tempCar.getMake()) &&
                    car.getModel().equalsIgnoreCase(tempCar.getModel()) &&
                    car.getColor().equalsIgnoreCase(tempCar.getColor()) &&
                    car.getYear() == (tempCar.getYear()) &&
                    car.getMileage() == tempCar.getMileage()) {

                carFound = true;
            }
        }
        if (carFound == false) {
            System.out.println("There is no car matching the given criteria");
            return dealership;
        }
        for (Automobile car : dealership) {
            if (!(car.getMake().equalsIgnoreCase(tempCar.getMake()) &&
                    car.getModel().equalsIgnoreCase(tempCar.getModel()) &&
                    car.getColor().equalsIgnoreCase(tempCar.getColor()) &&
                    car.getYear() == (tempCar.getYear()) &&
                    car.getMileage() == tempCar.getMileage())) {
                tempDeal[i++] = car;
            }
        }
        System.out.println("Car removed");
        return tempDeal;
    }
    // ChangeStat is a program that lets the user find a specific car and change the
    // attributes.
    // This method will find the car and allow you to change items until you quit
    

    private static Automobile[] changeStat(Automobile[] dealership, Scanner scan) {
        String tempMake = "";
        String tempModel = "";
        String tempColor = "";
        int tempYear = 0;
        int tempMiles = 0;
        int choice = 0;
        int place = 0;

        System.out.println("What car would you like to update");

        System.out.println("Please enter make: ");
        tempMake = scan.nextLine();

        System.out.println("Please enter model: ");
        tempModel = scan.nextLine();

        System.out.println("Please enter color: ");
        tempColor = scan.nextLine();

        while (true) {
            System.out.println("Please enter Year: ");
            try {
                tempYear = scan.nextInt();
                if (tempYear > 1886 && tempYear <= 2024) { // Assuming valid car years are between 1886 and the current
                                                           // year
                    break;
                } else {
                    System.out.println("Invalid year. Please enter a year between 1886 and 2024.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid numeric year.");
                scan.nextLine(); // Clear invalid input
            }
        }

        while (true) {
            System.out.println("Please enter Mileage: ");
            try {
                tempMiles = scan.nextInt();
                if (tempMiles >= 0) { // Mileage cannot be negative
                    break;
                } else {
                    System.out.println("Invalid mileage. Please enter a positive number.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid numeric mileage.");
                scan.nextLine(); // Clear invalid input
            }
        }

        for (int i = 0; i < dealership.length; i++) {
            if (dealership[i].getMake().equalsIgnoreCase(tempMake) &&
                    dealership[i].getModel().equalsIgnoreCase(tempModel) &&
                    dealership[i].getColor().equalsIgnoreCase(tempColor) &&
                    dealership[i].getYear() == (tempYear) &&
                    dealership[i].getMileage() == (tempMiles)) {
                // System.out.println("Perfect Match");
                place = i;

            }
        }

        do {
            System.out.println("What attribute would you like to update, pick from the following choices ");
            System.out.println("Make: 1\nModel: 2\nColor: 3\nYear: 4\nMileage: 5\nQuit: 6");
            choice = scan.nextInt();

            switch (choice) {
                // README: needs an exception for inputMismatchException
                case 1:
                    System.out.println("What is the new Make: ");
                    tempMake = scan.next().trim();
                    dealership[place].setMake(tempMake);
                    break;
                case 2:
                    System.out.println("What is the new Model: ");
                    tempModel = scan.next().trim();
                    dealership[place].setModel(tempModel);
                    break;
                case 3:
                    System.out.println("What is the new Color: ");
                    tempColor = scan.next().trim();
                    dealership[place].setColor(tempColor);
                    break;
                case 4:
                    System.out.println("What is the new Year: ");
                    tempYear = scan.nextInt();
                    dealership[place].setYear(tempYear);
                    break;
                case 5:
                    System.out.println("What is the new Mileage: ");
                    tempMiles = scan.nextInt();
                    dealership[place].setMileage(tempMiles);
                    break;
                case 6:
                    System.out.println("Selected quit");
                    break;
                default:
                    System.out.println("Not a valid input");
                    break;
            }

        } while (choice != 6);

        return dealership;
    }

    // This program will print to a file called Garage.txt
    // this has 2 parts, the file is created and file is written in.

    private static void printToFile(Automobile[] dealership) {

        // This will create a file garage

        try {
            File myFile = new File("C:\\Users\\bryan\\Documents\\Garage.txt");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }

        // this will write into the file garage
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\bryan\\Documents\\Garage.txt");
            for (Automobile car : dealership) {
                if (car != null) {
                    myWriter.write(car.toString() + "\n");
                }
            }
            myWriter.close();
            System.out.println("File written successfully");
        } catch (IOException e) {
            System.out.println("An error has occured");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Automobile[] finalGarage = new Automobile[0];
        Scanner scan = new Scanner(System.in);

        int choice = 0;
        boolean validInput = false;
        String print;

        /*
         * Here is the program
         * This will be a text and input menu.
         */
        System.out.println("Welcome to the Bryan's garage.");
        System.out.println("Here are your options in the garage");
        do {
            System.out
                    .println("1. Add car\n2. Remove car\n3. Update car attributes\n4. Print dealership list\n5. Quit");
            choice = scan.nextInt();
            print = scan.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Please insert the following information");
                    finalGarage = addCar(finalGarage, scan);
                    printDealership(finalGarage);
                    break;
                case 2:
                System.out.println("Please insert the following information");
                    printDealership(finalGarage);
                    finalGarage = deleteCar(finalGarage, scan);
                    printDealership(finalGarage);
                    break;
                case 3:
                System.out.println("Please insert the following information");
                    printDealership(finalGarage);
                    finalGarage = changeStat(finalGarage, scan);
                    printDealership(finalGarage);
                    break;
                case 4:
                    while (!validInput) {
                        try {
                            System.out.println("Would you like to print to file or print to string. Y to file, N to screen");
                            print = scan.nextLine();

                            if (print.equalsIgnoreCase("Y")) {
                                // All the messages are in the function
                                printToFile(finalGarage);
                                validInput = true;
                                break;
                            } else if (print.equalsIgnoreCase("N")) {
                                printDealership(finalGarage);
                                validInput = true;
                                break;
                            } else {
                                System.out.println("Invalid input. Please enter Y for file or N to screen.");
                            }
                        } catch (InputMismatchException  e) {
                            System.out.println(" Invalid inputs. Please enter a number from 1 to 5.");
                            scan.nextLine();
                            e.printStackTrace();
                        }
                    } validInput = false;
            }
        } while (choice != 5);
        scan.close();
    }
}
