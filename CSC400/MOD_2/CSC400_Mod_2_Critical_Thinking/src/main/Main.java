package main;

/* Author: Bryan Coss Y Leon Ortega
 * Class CSC 400 Data Structures and Algorithms
 * Purpose:
 * 
 * 
 * 
 * */


public class Main {

	public static void main(String[] args) {

		// Bag class, using objects to grab every data type 
		Bag<Object>bagList = new Bag<Object>();
		Bag<Object>bag2 = new Bag<Object>();
		
		
		// Adding items to a bag including dupes
		bagList.add("Bryan");
		bagList.add("Oscar");
		bagList.add("Monserrat");
		bagList.add("Monserrat");
		bagList.add("Monserrat");
		bagList.add("Monserrat");
		bagList.add("Alexis");
		bagList.add("Giovanni");
		bagList.add(30);
		
		// Adding items to second bag
		bag2.add("Mathius");
		bag2.add(30);
		bag2.add(2.001);
		bag2.add("Liam");
		bag2.add("Gael");
		bag2.add("Bryan");
		bag2.add("Gael");	
		bag2.add("Giovanni");
		bag2.add("Gael");		
		
		// Print the contents of each bag
		System.out.println("bagList size: " + bagList.size());
		bagList.Print();
		System.out.println("bag2 size: " + bag2.size());
		bag2.Print();
		
		//This will merge bag2 to the end of bagList
		System.out.println("Merged bag: ");
		bagList.merge(bag2);
		
		// This will print out the results of the merged bags
		System.out.println("Merged bags: ");
		bagList.Print();
		
		// This will test the distinct class. the following will have a new bag created
		// Go through the distinct() method and then print the results. 
		System.out.println("Testing Distinct()");
		Bag<Object> newBag = bagList.distinct();
		System.out.println("newBag size: " + newBag.size());
		newBag.Print();


		
	}

}
