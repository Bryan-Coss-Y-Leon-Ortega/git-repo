package main;

import java.util.ArrayList;


public class Bag<T> {
	
	// Using Array list to the bag
	public ArrayList<T> items;
	
	// Bag constructor will be an arraylist.
	// Array list are easier to manage
	public Bag() {
		items = new ArrayList<T>();
		
	}
	
	// add() will add item to the bag arraylist
	public void add(T item) {
		items.add(item);
	}
	
	// remove() will remove first occurence of item from the array list
	public void remove(T item) {
		items.remove(item);
	}
	
	// Will return true or false if item is located in the bag array list
	public boolean contains(T item) {
		return items.contains(item);
	}
	
	// This will return the size of the bag as an integer
	public int size() {
		return items.size();
	}
	
	// This will delete all items in the bag
	public void clear() {
		this.items.clear();
	}
	
	// This funtion will be used to print out the content of the bag.
	// It will print out a message for the bag content, print every item 
	// and end with a new line
	public void Print() {
		System.out.println("Bag content: ");
		for(int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i));
		}
		System.out.println();
	}
	public T get(int i) {
		return this.items.get(i);
		
	}
	//  This will return the number of duplicates in the bag
	// the return is in a string form that returns the name of the item and the ammount
	public String freqOf(T item) {
	
		int count = 0;
		for (int i = 0; i < items.size(); i++) {
			if(items.get(i) == item) {
				count++;
			}
		}
		return "Item \"" + item + "\" count: " + count;
	}
	
	// This method will merge a new bag to the end of the current bag
	public void merge(Bag<T> otherBag) {
		
		for(int i = 0; i < otherBag.size(); i++) {
			this.items.add(otherBag.get(i));
		}
	}
	
	//This Method will return a bag with distinct items. 
	// This will skip every element that is a duplicate in the bag
	Bag<T> distinct(){
		Bag<T> temp = new Bag<T>();
		
		for(int i = 0; i < items.size(); i++) {
			T currItem = items.get(i);
			if(!temp.contains(items.get(i))) {
				temp.add(currItem);
			}
			
		}
		return temp;
		
	}
	
}
