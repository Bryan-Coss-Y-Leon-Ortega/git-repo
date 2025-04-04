/*
 * Name: Main.java
 * Author: Bryan Coss Y Leon
 * 
 * Purpose: Your application should create two threads that will act as counters. 
 * 			One thread should count up to 20. Once thread one reaches 20, 
 * 			then a second thread should be used to count down to 0.
 * 
 * */


public class Main extends Thread{
	

	public static void main(String[] args) throws InterruptedException {
		
		//Initialize
		countUp start = new countUp();
		countDown end = new countDown();
		
		//Create threads for both the counting up and the counting down
		Thread thread1 = new Thread(start);
		Thread thread2 = new Thread(end);
		
		//Start thread1
		thread1.start();
		// Join() is used to make the first thread finish before the second thread starts. 
		thread1.join();
		//Second thread counts down. 
		thread2.start();
		//This ensure thread2 is able to completely process before the completion output
		try {
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Threads completed");
		

	}

}
