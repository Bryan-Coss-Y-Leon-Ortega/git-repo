package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CustomLinkedList {

	private Node head;
	
	public Iterator<Integer> iterator(){
		return new LinkedListIterator();
	}
	
	private class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	private class LinkedListIterator implements Iterator<Integer>{
		private Node current = head;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}
		
		@Override
		public Integer next() {
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			int data = current.data;
			current = current.next;
			return data;
		}
		
	}

	/*
	 * This insert method will create a new node, assign it the integer value
	 * and make the current list the next value, making the new value the head. 
	 * */
	public void insert(int i) {
		Node newNode = new Node(i);
		newNode.next = this.head;
		this.head = newNode;
		
	}
	/*
	 * This method of delete will get an integer value and search for that value in the linked list
	 * We check the head to make sure it is not null
	 * if the value is the head, we will make the next value the head
	 * if it is in the body, we replace it by making the current value's next next next value the next value
	 * */
	public void delete(int i) {
		// if head is null
		if(this.head == null ) {
			System.out.println("Cannot remove from empty linked list");
			return;
		}
		if(this.head.data == i) {
			this.head = head.next;
			return;
		}
		
		//Remove from body
		Node newNode = this.head;
		while (newNode.next != null) {
			if(newNode.next.data == i) {
				newNode.next = newNode.next.next;
				return;
			}
			newNode = newNode.next;
		}
		
		System.out.print("Value " + i + " not found in the list");
	}
	
	
	/*
	 * This method will scan through a file of numbers and delete that number from the linked list
	 * The commented lines are there to help see what numbers from the delete file are read through
	 * */
	public void readDelete(File file) {
		//System.out.println("Delete File: ");
		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()) {
				String num = scan.nextLine();
				int nums = Integer.parseInt(num);
				//System.out.print(nums + " " );
				delete(nums);
			}
			scan.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		//System.out.println();
	}
	
	public void readInsert(File file) {

		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()) {
				String num = scan.nextLine();
				int nums = Integer.parseInt(num);
				insert(nums);
			}
			scan.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	

	
}
