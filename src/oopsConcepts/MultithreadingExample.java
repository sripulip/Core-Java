package oopsConcepts;

class ThreadTest implements Runnable {

	private static int number = 1;
	private int threadNumber;
	protected int count = 0;

	public ThreadTest() {
		this.threadNumber = number++;
	}

	@Override
	public void run() {
		print(this.threadNumber);
	}

	public int printNumbers() {
		new Thread(this).start();
		return this.threadNumber;
	}

	private void print(int i) {
		System.out.println("" + this.threadNumber + ": " + (this.count += i));
	}
}

public class MultithreadingExample {

	public static void main(String[] args) {

		ThreadTest[] threadArray = new ThreadTest[3];

		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i] = new ThreadTest();
		}
		for (int i = 0; i < threadArray.length; i++) {
			int threadNum = threadArray[i].printNumbers();
			System.out.println("Thread " + threadNum + " returned");
		}
	}
}
