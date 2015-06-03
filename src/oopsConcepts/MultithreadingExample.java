package oopsConcepts;

class MultiThreading implements Runnable {

	private Thread thread;
	private int threadNumber;

	public MultiThreading(int threadNumber) {
		this.threadNumber = threadNumber;
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
		for (int i = 0; i < 70; i++) {
			System.out.println("Thread " + this.threadNumber + ": " + i);
		}
	}

}

public class MultithreadingExample {

	public static void main(String[] args) {

		MultiThreading e1 = new MultiThreading(1);
		e1.printNumbers();

		MultiThreading e2 = new MultiThreading(2);
		e2.printNumbers();

		MultiThreading e3 = new MultiThreading(3);
		e3.printNumbers();
	}

}
