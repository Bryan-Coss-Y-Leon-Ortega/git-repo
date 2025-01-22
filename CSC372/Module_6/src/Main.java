import java.util.ArrayList;

/*
 * Author: Bryan Coss Y Leon Ortega
 * 
 * Program: Array manipulations
 * 
 * Create a Java program that will store 10 student objects in an ArrayList, 
 * ArrayList<Student>. A student object consists of the following fields:
 * int rollno
 * String name
 * String address
 * Implement two comparator classes to sort student objects by name and by rollno (roll number). 
 * Implement your own selection sort method and place your code in a separate Java source file. 
 * Do not use a sort method from the Java collections library.
 * */
public class Main extends arrayManipulation{

	public static void main(String[] args) {
		
		//This is going to be the arraylist that holds all the students
		
		ArrayList<Student> rollCall = new ArrayList<Student>();
		
		//This is all the students in the class
		Student Bryan = new Student("Bryan", "1234 w", 77);
		Student Alexis = new Student("Alexis", "12345 e", 15);
		Student Berenice = new Student("Berenice", "2312 w", 33);
		Student Oscar = new Student("Oscar", "3210 e", 405);
		Student Giovanni = new Student("Giovanni", "4560 N", 1);
		Student Monse= new Student("Monse", "9876 W", 88);
		Student Gael = new Student("Gael", "7825 E", 21);
		Student Liam = new Student("Liam", "78523 E", 16);
		Student Mathius = new Student("Mathius", "8995 S", 2);
		Student Chole = new Student("Chole", "12 S", 45);
		
		//Adding all students to the roll call
		rollCall.add(Bryan);
		rollCall.add(Alexis);
		rollCall.add(Berenice);
		rollCall.add(Oscar);
		rollCall.add(Giovanni);
		rollCall.add(Monse);
		rollCall.add(Gael);
		rollCall.add(Liam);
		rollCall.add(Mathius);
		rollCall.add(Chole);
		
		System.out.println("This is the roll call before any sort method");
		printArray(rollCall);
		
		System.out.println("\nThis is the roll call sorted by roll number");
		sortNum(rollCall);
		printArray(rollCall);
		
		System.out.println("\nThis is the roll call sorted by name");
		sortName(rollCall);
		printArray(rollCall);
		
		System.out.println("\nThis is the roll call sorted in reverse roll number");
		reverseSortNum(rollCall);
		printArray(rollCall);
		
		System.out.println("\nThis is the roll call sorted by name in reverse");
		reverseSortName(rollCall);
		printArray(rollCall);

		

		
		
	}

}
