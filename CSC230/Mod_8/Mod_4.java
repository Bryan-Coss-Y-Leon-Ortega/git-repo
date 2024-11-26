package Mod_8;



/*
 * Option #1: Looping Construct with Floating Point Numbers
 * Write a program that utilizes a while-loop to read
 * a set of five floating-point values from user input.
 * Include code to prevent an endless loop.
 * Ask the user to enter the values,
 * then print the following data:
 * 
 * Psuedocode:
 * Set total to 0.0
 * Set Maximum to the lowest possible number
 * Set Minimum to the highest possible number
 * 
 * Create a scanner scan that intakes user input
 * 
 * Create a do while loop that reads all the inputs and does the following
 * 
 * adds every value to the total number
 * 
 * compares every imput to the Max and the Min
 * 
 * increments a count, since we are only doing 5 numbers, we do 5 cycles
 * 
 * From this, we will get the information we need to return
 * 
 * Total, Max, Min
 * 
 * Average is total / 5
 * 
 * Total with 20% interest
 * 
 * 
 * 
 * */
import java.util.Scanner;

public class Mod_4 {

	public static void main(String[] args) {

		double[] arrNums = new double[5];
		double total = 0.0;
		double average;
		double Maximum = Double.MIN_VALUE;
		double Minimum = Double.MAX_VALUE;
		double Interest = 0.20;
		Scanner scan = new Scanner(System.in);

		//This will prompt the user to input numbers into the array
		for(int i = 0; i < arrNums.length; i++){
			arrNums[i] = scan.nextInt();
		}
		
		for(int j = 0; j < arrNums.length; j++){
			total = total + arrNums[j];
			if(Maximum < arrNums[j]){
				Maximum = arrNums[j];
			}
			if(Minimum > arrNums[j]){
				Minimum = arrNums[j];
			}
		}
		average = total / 5.0;


		System.out.println("Maximum number: " + Maximum);
		System.out.println("Minimum number: " + Minimum);
		System.out.println("Total: " + total);
		System.out.println("Average: " + average);
		System.out.println("Total with 20% interest: " + (total + (total * Interest)));
		
		scan.close();

	}

}