
public class countUp implements Runnable{

	public void run() {
		for (int i = 0; i <= 20; i++) {
			System.out.println("Thread 1 :" + i);
		}
	}
}
