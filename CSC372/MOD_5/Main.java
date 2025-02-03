package CSC372.MOD_5;

import java.util.Scanner;
/*
 * Author: Bryan Coss Y Leon Ortega
 * 
 * Option #1:  Implementing Recursion to Provide a Product
 * 
 * Using recursion, create a program that will allow a user to enter five numbers,
 * this program will provide the product of all five numbers using a recursive method
 * 
 */

public class Main{

    /*
     * productFive will take in three different variables, a scanner, int and product.
     * The scanner will take in the input from the user in the format ## ## ## ## ##.
     *      The input format will reqquire each number be seperated by a space
     * The int INPUTS is the count for how many time the program will read the in user inputs
     * the double product will be the product of all the numbers input by the user. 
     */
    private static double productFive(Scanner scan, int INPUTS, double product) {
        if (INPUTS ==0){
            return product;
        }else{
            // In this part, we are grabbing the scan fucntion, 
            // reading through the inputs
            // and multiplying the next input to the running product. 
            try{
                double x = scan.nextDouble();
                return productFive(scan, INPUTS -1, product * x);
            }
            // this catch will make sure there is only integers
            catch (Exception excpt){
                System.out.println(excpt.getMessage());
                System.out.println("Cannot compute, please only use integers");
                return 0;
            }             
        }
    }
    public static void main(String[] args){

        int INPUTS = 5;                         //Amount of times a user can input
        double product = 1;                     //Making a running product table, 1 because anything * 0 is 0
        Scanner scan = new Scanner(System.in);  //Scanner to input into the productFive method. 

        //Message for the user. 
        System.out.println("Please enter 5 numbers. The numbers can be integer or mixed numbers, and can be seperated by a space or new line. ");

        //Since the return is a double, the easiest way to return 
        System.out.println("The product is: " + productFive(scan, INPUTS, product));

        //Close the scanner
        scan.close();
            
            }
        
        
            
}
