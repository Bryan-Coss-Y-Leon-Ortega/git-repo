package CSC372.MOD_5;

import java.util.Scanner;


public class Main{

    private static double productFive(Scanner scan, int INPUTS, double product) {

        if (INPUTS ==0){
            return product;
        }else{
            try{
                double x = scan.nextDouble();
                return productFive(scan, INPUTS -1, product * x);
            }
            catch (Exception excpt){
                System.out.println(excpt.getMessage());
                System.out.println("Cannot compute, please only use integers");
            }             
        }
                return product;
    }

    public static void main(String[] args){
        int INPUTS = 5;
        double product = 1;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter 5 numbers. ");

        System.out.println(productFive(scan, INPUTS, product));
            
            }
        
            
}
