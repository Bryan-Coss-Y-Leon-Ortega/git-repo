package main;

import java.io.File;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		// Linked list we are using
		CustomLinkedList linkedList = new CustomLinkedList();
		
		// file paths for the files we are going to use for this
		String filePath1 = "C:\\Users\\bryan\\eclipse-workspace2\\CSC400_Mod_6_Critical_Thinking\\src\\res\\LinkedListAdd";
		String filePath2 = "C:\\Users\\bryan\\eclipse-workspace2\\CSC400_Mod_6_Critical_Thinking\\src\\res\\LinkedListDelete";
		
		// Insert these files to add and delete in the linkedlist
		File file1 = new File(filePath1);
		File file2 = new File(filePath2);
		
		linkedList.delete(0);
		// Read files into the arrays
		linkedList.readInsert(file1);
		
		
		//Insert some elements
			
		linkedList.insert(1);
		linkedList.insert(2);
		linkedList.insert(7);
		linkedList.insert(3);
		linkedList.insert(4);
		linkedList.insert(8);
		linkedList.insert(7);
		linkedList.insert(7);
		linkedList.insert(7);
		linkedList.insert(4);
		
		Print(linkedList);

		// Delete an instance of the following element
		linkedList.readDelete(file2);
		linkedList.delete(4);
		linkedList.delete(8);
		
		Print(linkedList);
	

	}
	/*
	 * This function will print the values of the linked list
	 * */
	public static void Print(CustomLinkedList linkedList) {
		Iterator<Integer> iterator = linkedList.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}
	

}
