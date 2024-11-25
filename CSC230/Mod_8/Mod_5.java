package Mod_8;

import java.util.*;

/*
 * Option #1: Get Weekly Temperatures
 * 
 * 
 * Psuedocode:
 * 
 * The user will be prompted to give the program the average temperature per day of a week
 * The days of the week will be give, the user will input a double
 * The information will be stored in two different arrays, a temperature array and a day of the week array
 * 
 * After the user inputs the average temps, the program will move into a do while with options for the user
 * if the user wants a temperature of a specific day, the user needs to input that day
 * if the user wants all the temperatures, the user needs to input week 
 * At the end, the average temperature will be returned
 * 
 * 
 * */

public class Mod_5 {

	// This is a function that will print out all the temperatures in a week
	private static void printall(ArrayList<String> week, ArrayList<Double> avgTemp) {
		for (int j = 0; j < week.size(); j++) {
			System.out.println(week.get(j) + ": " + avgTemp.get(j));
		}

	}

	public static void main(String[] args) {

		double temp;
		String day;
		ArrayList<String> week = new ArrayList<>();
		ArrayList<Double> avgTemp = new ArrayList<>();
		boolean loop = true;
		Scanner scan = new Scanner(System.in);

		/*
		 * Here I am filling the weeks arraylist with the days we are using
		 * 
		 */
		week.add("Monday");
		week.add("Tuesday");
		week.add("Wednesday");
		week.add("Thursday");
		week.add("Friday");
		week.add("Saturday");
		week.add("Sunday");

		/*
		 * Here is a loop that will iterate through every day of the week Here the user
		 * will input the average temperature in each day
		 */
		System.out.println("Hello, this is the weekly average temperature tracker.");
		System.out.println("We will give you the weekday, and you will give us the temperature of that day. ");
		for (int i = 0; i < week.size(); i++) {
			System.out.print("Please insert the average temperature for " + week.get(i) + ": ");
			temp = scan.nextDouble();
			avgTemp.add(temp);
		}
		

		// This will return every day with every temperature.
		int x;
		double y = 0;
		for (x = 0; x < avgTemp.size(); x++) {
			y = y + avgTemp.get(x);
		}

		double average = y / avgTemp.size();

		//This do while will act as an interactive for the users.
		//the user has the choice of inputting a specific day, week or quit, anything else will be an error.
		do {
			System.out.println("Enter a day of the week to view its temperature or type 'week' to view all: ");
			System.out.println("Type 'quit' to Quit");
			day = scan.next();
			x = week.lastIndexOf(day);
			if (x == -1) {
				if (day.equals("week")) {
					printall(week, avgTemp);
				} else if (day.equals("quit")) {
					loop = false;
					break;
				}
			} else {
				System.out.println(week.get(x) + " " + avgTemp.get(x));
			}

		} while (loop);
		scan.close();
		System.out.println("Weekly average temperature is: " + average);
	}

}
