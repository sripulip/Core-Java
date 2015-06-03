package oopsConcepts;

class MultiThreading implements Runnable {

	private Thread thread;
	private static int number = 1;
	private int threadNumber;

	public MultiThreading() {
		this.threadNumber = number++;
		System.out.println("Creating Thread " + this.threadNumber);
	}

	public void run() {
		print();
	}

	public void printNumbers() {
		// Thread thread;
		thread = new Thread(this);
		System.out.println("Starting thread " + threadNumber);
		thread.start();
	}

	private void print() {
		for (int i = 0; i < 35; i++) {
			System.out.println("Thread " + this.threadNumber + ": " + i);
		}
		System.out.println("Thread " + this.threadNumber + " exiting");
	}

}

public class MultithreadingExample {

	public static void main(String[] args) {

		MultiThreading e1 = new MultiThreading();
		e1.printNumbers();

		MultiThreading e2 = new MultiThreading();
		e2.printNumbers();

		MultiThreading e3 = new MultiThreading();
		e3.printNumbers();
	}

}
