package Mod_8;

import java.util.Scanner;
import java.text.DecimalFormat;

/* 													 Module 3: Critical Thinking


													 Bryan Coss Y Leon Ortega
													 Colorado State University, Global
													 CSC320-1
													 Douglas Mujeye
													 October 27, 2024
*/

/* Module 3 critical thinking
 * 
 * Create a program that will calculate the weekly average tax withholding for a customer
 * given the following weekly income guidelines:
 * Income less than $500: tax rate 10%
 * Incomes greater than/equal to $500 and less than $1500: tax rate 15%
 * Incomes greater than/equal to $1500 and less than $2500: tax rate 20%
 * Incomes greater than/equal to $2500: tax rate 30% 
 */

/*
 * Psuedocode: 
 * Prompt user to input their weekly income 
 * 
 *  if 500 or less, tax is 10%
 *  if <= 500 and > 1500, tax is 15%
 *  if <= 1500 and > 2500, tax is 20%
 *  if <=2500, tax is 30%
 *  
 */

public class Mod_3 {

	public static void main(String[] args) {
		
		double weekly_income = 0;
		double tax = 0;
		Scanner scan = new Scanner(System.in);
		final DecimalFormat df = new DecimalFormat("0.00");
		
		System.out.print("What is your weekly salary: ");
		weekly_income = scan.nextFloat();
		
		if(weekly_income < 500) {
			tax = weekly_income * 0.10;
			System.out.println("The tax on your income is " + df.format(tax));
		}else if(weekly_income >= 500 && weekly_income < 1500) {
			tax = weekly_income * 0.15;
			System.out.println("The tax on your income is " + df.format(tax));
		}else if(weekly_income >= 1500 && weekly_income < 2500) {
			tax = weekly_income * 0.20;
			System.out.println("The tax on your income is " + df.format(tax));
		}else {
			tax = weekly_income * 0.30;
			System.out.println("The tax on your income is " + df.format(tax));
		}
		scan.close();
	}
}









