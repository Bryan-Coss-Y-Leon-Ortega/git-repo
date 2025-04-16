package main;

/* Author: Bryan Coss Y Leon Ortega
 * Class CSC 400 Data Structures and Algorithms
 * Purpose:
 * 1. Design a Java class called Bag that implements a bag data structure
 * 2. Bag class needs add, remove, contains
 * 3. Main class needs
 * 		X Bag Class
 * 		X Add several elements, incuding duplicates
 * 		X Print the bag contents
 * 		X Test the contains methods for a few elements
 * 		X test the count method for a few elements
 * 		X Remove element from bag
 * 		X Print the content from the bag again
 * 		X Test contains for removed elements
 * 		X Test count for the removed elements
 * 4. Comment to explain functionality fo each method. 
 * 
 * 
 * 
 * */


public class Main {

	public static void main(String[] args) {

		// Bag class, using objects to grab every data type 
		Bag<Object>bagList = new Bag<Object>();
		
		// Adding items to a bag including dupes
		bagList.add("Bryan");
		bagList.add(30);
		bagList.add("Monserrato");
		bagList.add("Alexis");
		bagList.add("Bryan");
		bagList.add(30);
		bagList.add("Bryan");
		bagList.add(30);
		bagList.add(2.001);
		bagList.add("Monserrat");
		bagList.add("Monserrat");	
		bagList.add(20);
		bagList.add("Alexis");
		bagList.add(10);
		
		// Print the bag content
		bagList.Print();
		System.out.println("Bag size is: " + bagList.size() + "\n");

		//Test the content of the bag
		System.out.println("Testing the content of the bag");
		System.out.println("Monserrat "+ bagList.contains("Monserrat"));
		System.out.println("Oscar " + bagList.contains("Oscar"));
		System.out.println("String 2.001 " + bagList.contains("2.001"));
		System.out.println("Integer 2.001 " + bagList.contains(2.001) + "\n");
		
		// Test the dups function
		System.out.println("Test the frequency of certain items in bag");
		System.out.println(bagList.freqOf("Monserrat"));
		System.out.println(bagList.freqOf("Bryan"));
		System.out.println(bagList.freqOf(30) + "\n");
		
		// Remove elements from the bag
		bagList.remove("Monserrat");
		bagList.remove("Monserrato");
		bagList.remove("Bryan");
		bagList.remove(20);
		
		// Test the frequency function after removing items
		System.out.println("Test the frequency of certain items in bag after removing items");
		System.out.println(bagList.freqOf("Monserrat"));
		System.out.println(bagList.freqOf("Monserrato"));
		System.out.println(bagList.freqOf("Bryan"));
		System.out.println(bagList.freqOf(20) + "\n");

		
		// Print bag content again
		bagList.Print();
		System.out.println("Bag size is: " + bagList.size() + "\n");
		
		// Test contains for removed items
		System.out.println("Testing the contains method ");
		System.out.println("Integer 20 " + bagList.contains(20));
		System.out.println("Monserrat " + bagList.contains("Monserrat"));
		System.out.println("Monserrato " + bagList.contains("Monserrato"));
		System.out.println("Bryan "+bagList.contains("Bryan") + "\n");

		

		//Testing a clear function
		System.out.println("Clearing out the bag list");
		bagList.clear();
		bagList.Print();
		System.out.println("Bag size is: " + bagList.size());



		
	}

}
