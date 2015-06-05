package oopsConcepts;

class ThreadTest implements Runnable {

	private static int number = 1;
	private int threadNumber;

	public ThreadTest() {
		this.threadNumber = number++;
	}

	@Override
	public void run() {
		print();
	}

	public void printNumbers() {
		new Thread(this).start();
	}

	private void print() {
		for (int i = 0; i < 35; i++) {
			System.out.println("Thread " + threadNumber + ":" + i);
		}
	}
}

public class MultithreadingExample {

	public static void main(String[] args) {

		ThreadTest[] threadArray = new ThreadTest[3];

		for (int i = 0; i < threadArray.length; i++) {
			threadArray[i] = new ThreadTest();
		}
		for (ThreadTest thread : threadArray) {
			thread.printNumbers();
		}
	}
}
