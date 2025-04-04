
public class countDown implements Runnable{

	public void run() {
		for(int i = 20; i >= 0; i--) {
			System.out.println("Thread 2: " + i);
		}
	}
}
