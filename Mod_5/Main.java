package Mod_5;

import java.util.*;

/*
 * 2 different arraylists
 * 1 stores average temp
 * 1 stores day of the week
 * 
 * if week, return all temps and week
 * 
 * 
 * 
 * 
 * */

public class Main {

	private static void printall(ArrayList<String> week, ArrayList<Double> avgTemp) {
		for (int j = 0; j < week.size(); j++) {
			System.out.println(week.get(j) + ": " + avgTemp.get(j));
		}

	}
	
	//TODO: make everything into F and change everything to it. 
	

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
		 * */
		week.add("Monday");
		week.add("Tuesday");
		week.add("Wednesday");
		week.add("Thursday");
		week.add("Friday");
		week.add("Saturday");
		week.add("Sunday");

		/*
		 * Here is a loop that will iterate through every day of the week
		 * Here the user will input the average temperature in each day
		 * */
		System.out.println("Hello, this is the weekly average temperature tracker.");
		System.out.println("We will give you the weekday, and you will give us the temperature of that day. ");
		for (int i = 0; i < week.size(); i++) {
			System.out.print("Please insert the average temperature for " + week.get(i) + ": ");
			temp = scan.nextDouble();
			avgTemp.add(temp);
		}
		scan.close();
		// This will return every day with every temperature. 
		/*
		for (int j = 0; j < week.size(); j++) {
			System.out.println(week.get(j) + ": " + avgTemp.get(j));
		}
		*/
		// int x = week.lastIndexOf("zeno");
		int x;
		double y = 0;
		for(x = 0; x < avgTemp.size(); x++) {
			y = y + avgTemp.get(x);
		}
		

		double average = y / avgTemp.size();
		

		do {
			System.out.println("Enter a day of the week to view its temperature or type 'week' to view all: ");
			System.out.println("Type 'quit' to Quit");
			day = scan.next();
			x = week.lastIndexOf(day);
			if (x == -1) {
				if (day.equals("week")) {
					printall(week, avgTemp);
				}else if( day.equals("quit")) {
					loop = false;
					break;
				}
			}
			else{
				System.out.println(week.get(x) + " " + avgTemp.get(x));
			}
			
			

		} while (loop);
		System.out.println("Weekly average temperature is: " + average);
		
	}

}
