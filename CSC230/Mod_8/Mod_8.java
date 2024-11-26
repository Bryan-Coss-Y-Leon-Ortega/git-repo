package Mod_8;

import java.util.Scanner;

public class Mod_8 {

    

    public static class Automobile{
        private String make;
        private String model;
        private String color;
        private int year;
        private int mileage;

        //This is the default constructor
        public Automobile(){
            make = "Moot";
            model = "Null";
            color = "Null";
            year = -1;
            mileage = -1;
        }

        //This is the initialized constructor for automobile
        public Automobile(String make, String model, String color, int year, int mileage){
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;

        }   

        /*
         * 
         * X default constructor
         * X parameterized constructor
         *   add a new vehicle  method
         *   list vehicle information (return string array)
         *   remove a vehicle method
         *   update vehicle attributes method
         * 
         * 
        */
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
        
        @Override
        public String toString(){
            return "Make: " + make + ", Model: " + model + ", Color: " + color + ", Year: " + year + ", Mileage: " + mileage; 
    }

    }
    private static void printDealership(Automobile[] dealership) {

        for(int i = 0; i < dealership.length; i++){
            System.out.println(dealership[i].toString());
        }
        
    }
    private static Automobile[] addCar(Automobile[] dealership2, Scanner scan) {
        String tempMake = "";
        String tempModel = "";
        String tempColor = "";
        int tempYear = 0;
        int tempMiles = 0;
        String reset = "";
        
        Automobile[] tempDealer = new Automobile[dealership2.length + 1];

        System.out.println("Please enter make: ");
        tempMake = scan.nextLine();

        System.out.println("Please enter model: ");
        tempModel = scan.nextLine();

        System.out.println("Please enter color: ");
        tempColor = scan.nextLine();

        System.out.println("Please enter Year: ");
        tempYear = scan.nextInt();

        System.out.println("Please enter Mileage");
        tempMiles = scan.nextInt();

        // Here we create a car, this will be added to the list. 
        Automobile tempCar = new Automobile(tempMake, tempModel, tempColor, tempYear, tempMiles);

        //this resets the scans after the int variables. 
        reset = scan.nextLine();

        //Array copy method
        for(int i = 0; i < dealership2.length; i++){
            tempDealer[i] = dealership2[i];
        }
        tempDealer[dealership2.length] = tempCar;

        return tempDealer;
    }

    //This will use the car information to seek out the car that needs to be deleted
    private static Automobile[] deleteCar(Automobile[] dealership, Scanner scan) {
        String tempMake = "";
        String tempModel = "";
        String tempColor = "";
        int tempYear = 0;
        int tempMiles = 0;
        String reset = "";
        Boolean carFound = false;
        int i= 0;
        Automobile[] tempDeal = new Automobile[dealership.length -1];
       
        System.out.println("Please enter make: ");
        tempMake = scan.nextLine();

        System.out.println("Please enter model: ");
        tempModel = scan.nextLine();

        System.out.println("Please enter color: ");
        tempColor = scan.nextLine();

        System.out.println("Please enter Year: ");
        tempYear = scan.nextInt();

        System.out.println("Please enter Mileage");
        tempMiles = scan.nextInt();
    
        Automobile tempCar = new Automobile(tempMake, tempModel, tempColor, tempYear, tempMiles);

        //this resets the scans after the int variables. 
        reset = scan.nextLine();
        
        //This will search for the car
        for(Automobile car : dealership){
            if(car.getMake().equalsIgnoreCase(tempCar.getMake()) && 
                car.getModel().equalsIgnoreCase(tempCar.getModel()) && 
                car.getColor().equalsIgnoreCase(tempCar.getColor()) &&
                car.getYear() == (tempCar.getYear()) &&
                car.getMileage() == tempCar.getMileage()){
                
                System.out.println("Perfect Match");
                carFound = true;
                }
        }
        if(carFound == false){
            System.out.println("There is no car matching the given criteria");
            return dealership;
        }
        for(Automobile car : dealership){
            if(!(car.getMake().equalsIgnoreCase(tempCar.getMake()) && 
                car.getModel().equalsIgnoreCase(tempCar.getModel()) && 
                car.getColor().equalsIgnoreCase(tempCar.getColor()) &&
                car.getYear() == (tempCar.getYear()) &&
                car.getMileage() == tempCar.getMileage())){
                    tempDeal[i++] = car;
                }
        }
        System.out.println("Car removed");
        return tempDeal;
    }   
    private static Automobile[] changeStat(Automobile[] dealership, Scanner scan) {
        String tempMake = "";
        String tempModel = "";
        String tempColor = "";
        int tempYear = 0;
        int tempMiles = 0;
        int choice = 0;;
        int place = 0;

        System.out.println("What car would you like to update");

        System.out.println("Please enter make: ");
        tempMake = scan.nextLine();

        System.out.println("Please enter model: ");
        tempModel = scan.nextLine();

        System.out.println("Please enter color: ");
        tempColor = scan.nextLine();

        System.out.println("Please enter Year: ");
        tempYear = scan.nextInt();

        System.out.println("Please enter Mileage");
        tempMiles = scan.nextInt();
        
        for(int i = 0; i < dealership.length; i++){
            if(dealership[i].getMake().equalsIgnoreCase(tempMake) &&
               dealership[i].getModel().equalsIgnoreCase(tempModel) &&
               dealership[i].getColor().equalsIgnoreCase(tempColor) &&
               dealership[i].getYear() == (tempYear) &&
               dealership[i].getMileage() == (tempMiles)){
                System.out.println("Perfect Match");
                place = i;

            }
        }
        
        do{
        System.out.println("What attribute would you like to update, pick from the following choices ");
        System.out.println("Make: 1\nModel: 2\nColor: 3\nYear: 4\nMileage: 5\nQuit: 6");
        choice = scan.nextInt();

            switch (choice){
                //README: needs an exception for inputMismatchException
                case 1:
                    System.out.println("What is the new Make: ");
                    tempMake = scan.next();
                    dealership[place].setMake(tempMake);
                    break;
                case 2:
                    System.out.println("What is the new Model: ");
                    tempModel = scan.next();
                    dealership[place].setModel(tempModel);
                    break;
                case 3:
                    System.out.println("What is the new Color: ");
                    tempColor = scan.next();
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
                    dealership[place].setMileage(place);
                    break;
                case 6:
                    System.out.println("Selected quit");
                    break;
                default:
                    System.out.println("Not a valid input");
                    break;
            }

        }while(choice != 6);

        return dealership;
    }

        
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        //String x = "";
        Automobile[] dealership = new Automobile[5];
        //Automobile[] dealership2 = new Automobile[0];
        //Automobile carZ = new Automobile();

        Automobile car0 = new Automobile("Chevy", "Cruz", "blue", 2004,145000);
        Automobile car1 = new Automobile("Honda", "Accord", "red", 2004,75000);
        Automobile car2 = new Automobile("Ferrary", "Bryan", "purple", 2004,14366);
        Automobile car3 = new Automobile("Monse", "Vazquez", "green", 2004,89112);
        Automobile car4 = new Automobile("Chevy", "Cruz", "blue", 2004,135000);


        dealership[0] = car0;
        dealership[1] = car1;
        dealership[2] = car2;
        dealership[3] = car3;
        dealership[4] = car4;

        dealership[2].setColor("Black");

        //printDealership(dealership);

        //dealership2 = addCar(dealership2, scan);
        //printDealership(dealership2);

        //dealership = addCar(dealership, scan);

        //printDealership(dealership);   
        //printDealership(dealership);
        //dealership = deleteCar(dealership, scan);
        //printDealership(dealership);
        dealership = changeStat(dealership, scan);
        printDealership(dealership);
        
                
                scan.close();               
                }
            
            
         
}
