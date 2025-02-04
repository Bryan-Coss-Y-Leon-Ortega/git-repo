package CSC372.MOD_8;

public class Car {
    
    private String make;
    private String model;
    private double mpg;
    public Car(){

        this.make = "Empty car";
        this.model = "No model";
        this.mpg = 0.00;
    }
    public Car(String make, String model, double mpg){
        this.make = make;
        this.model = model;
        this.mpg = mpg;

    }

    /*
     * These are created if they are needed, so far, they have not been needed for anything
     * 
     */
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }public double getMpg() {
        return mpg;
    }public void setMake(String make) {
        this.make = make;
    }public void setModel(String model) {
        this.model = model;
    }public void setMpg(double mpg) {
        if(mpg < 0.00){
            System.out.println("Cannot be negative, try again. ");
        }
        this.mpg = mpg;
    }
    /*
     * This will be the format on how present the cars in the list.  
    */
    @Override
    public String toString(){
        return this.make + " " + this.model + " " + this.mpg + "\n";
    }
    
}
