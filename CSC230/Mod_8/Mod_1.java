
													/* Module 1: Critical Thinking


													* Bryan Coss Y Leon Ortega
													* Colorado State University, Global
													* CSC320-1
													* Douglas Mujeye
													* October 13, 2024
													*/



/*	Module 1: Critical thinking
 *
 * 1. Developing pseudocode that prints the following information for a restaurant in your city:
 *		Restaurant name
 *		Business address
 *		City, State, Zip code
 *	2. Creating a simple java application that will print the items listed above in the same format.
 *		Compile and submit your pseudocode, source code, and screenshots of the application executing the application, 
 *		the results and GIT repository in a single document.
 */

/* Psuedocode:
 * Restaurant name: Forno 301
 * Business address: 1616 N central Ave #104, Phoenix, AZ, 85004
 * City: Phoenix
 * State: Az
 * Zipcode: 85004
 *  
 *  print restaurant name
 *  print business address
 *  print city +, + state +, + zip
 */

public class Main{
	
	public static void main (String[] args) {
		
		
		String Rest_name = "Forno 301";
		String Bus_add = "1616 N Central Ave #104";
		String City = "Phoenix";
		String State = "AZ";
		int Zip = 85004;
		
		System.out.println(Rest_name);
		System.out.println(Bus_add);
		System.out.println(City +", "+  State+ ", " + Zip);
	}
}