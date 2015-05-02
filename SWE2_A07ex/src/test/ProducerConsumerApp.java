package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Buffer {

	private String[] stringArray = new String[3];

	public synchronized void put(String s) {
		if (stringArray[0] == null) {
			stringArray[0] = s;
		} else if (stringArray[1] == null) {
			stringArray[1] = s;
		}
		// else if (stringArray[2]==null){stringArray[2] = s;}
		else {
			stringArray[2] = s;
		}
		// stringArray = o;
	}

	public synchronized String[] retrieve() {
		String[] o = stringArray;
		stringArray[0] = null;
		stringArray[1] = null;
		stringArray[2] = null;
		return o;
	}

	public synchronized boolean isEmpty() {
		return stringArray[0] == null && stringArray[1] == null
				&& stringArray[2] == null;
	}

}

class Producer extends Thread {

	private final Buffer buffer;

	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		int i = 0;

		while (!interrupted()) {
			try {
				synchronized (buffer) {
					while (!buffer.isEmpty()) {
						System.out.println(" ++ Producer blocked");
						buffer.wait();
					}
					String s = this.getId() + " : " + i++;
					doSomeHeavyWork();
					buffer.put(s);
					buffer.put(s + "2");
					buffer.put(s + "3");
					System.out.println("Producer produced " + s);
					buffer.notifyAll();
				}
				Thread.sleep((int) (100 * Math.random()));
			} catch (InterruptedException e) {
				interrupt();
			}
		}
		System.out.println("Producer terminated ");
	}

	private void doSomeHeavyWork() throws InterruptedException {
		Thread.sleep(10);
		/*
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); System.out.print("Enter String"); try
		 * { String s = br.readLine(); } catch (IOException e) {
		 * e.printStackTrace(); }
		 */
	}

}

class Consumer extends Thread {
	private final Buffer buffer;

	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		while (!interrupted()) {
			try {
				synchronized (buffer) {
					while (buffer.isEmpty()) {
						System.out.println(" ++ Consumer blocked");
						buffer.wait();
					}
					doSomeHeavyWork();
					String[] o = buffer.retrieve();

					for (int i = 0; i < o.length && o[i] != null; i++) {
						System.out.println("  Consumer found " + o[0]);
					}
					System.out.println("pippo");
					buffer.notifyAll();
				}
				Thread.sleep((int) (100 * Math.random()));
			} catch (InterruptedException e) {
				interrupt();
			}
		}
		System.out.println("Consumer terminated ");
	}

	private void doSomeHeavyWork() throws InterruptedException {
		Thread.sleep(10);
	}
}

public class ProducerConsumerApp {

	public static void main(String[] args) {

		Buffer buffer = new Buffer();

		Producer p1 = new Producer(buffer);
		Consumer c1 = new Consumer(buffer);
		Producer p2 = new Producer(buffer);
		Consumer c2 = new Consumer(buffer);

		p1.start();
		c1.start();
		p2.start();
		c2.start();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}

		p1.interrupt();
		c1.interrupt();
		p2.interrupt();
		c2.interrupt();

		try {
			p1.join();
			c1.join();
			p2.join();
			c2.join();
		} catch (InterruptedException e) {
		}

		System.out.println("Application terminated ");
	}

}
