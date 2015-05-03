package test;

import inout.In;

/*import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.InputStreamReader;*/

class Buffer {

	public final static String TERMINATIONLINE = "x";

	private String data[];
	private int head;
	private int tail;
	private int elements;

	public Buffer(Integer number) {
		data = new String[number];
		head = 0;
		tail = 0;
		elements = 0;
	}

	public synchronized void put(String value) throws InterruptedException {
		while (bufferFull()) {
			wait();
		}

		data[tail++] = value;
		if (tail == data.length) {
			tail = 0;
		}
		elements++;
		notify();
	}

	public synchronized String get() throws InterruptedException {
		while (bufferEmpty()) {
			wait();
		}

		String value = data[head++];
		if (head == data.length) {
			head = 0;
		}
		elements--;
		notify();
		return value;
	}

	private boolean bufferEmpty() {
		return elements == 0;
	}

	private boolean bufferFull() {
		return elements == data.length;
	}
}

class Producer extends Thread {

	private final Buffer buffer;

	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {

		while (true) {
			try {
				System.out.println("read");
				String value = In.readLine();

				if (Buffer.TERMINATIONLINE.equals(value)) {
					buffer.put(value);
					break;
				}
				buffer.put(value);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// System.out.println("Producer terminated ");
	}

}

class Consumer extends Thread {
	private final Buffer buffer;

	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {

		while (true) {
			try {
				String getter = buffer.get();

				if (Buffer.TERMINATIONLINE.equals(getter)) {
					// send
					System.out.println(getter);			
					writer.println(getter);
					writer.flush();
					
					break;
				}
				writer.println(getter);
				writer.flush();
				System.out.println(getter);
				// send
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// System.out.println("Producer terminated ");
	}

}

public class ProducerConsumerApp {

	public static void main(String[] args) {

		Buffer buffer = new Buffer(3);

		Producer p1 = new Producer(buffer);
		Consumer c1 = new Consumer(buffer);
		// Producer p2 = new Producer(buffer);
		// Consumer c2 = new Consumer(buffer);

		p1.start();
		c1.start();
		/*
		 * p2.start(); c2.start();
		 */
		/*
		 * try { Thread.sleep(10000); } catch (InterruptedException e) { }
		 * 
		 * p1.interrupt(); c1.interrupt(); p2.interrupt(); c2.interrupt();
		 * 
		 * try { p1.join(); c1.join(); p2.join(); c2.join(); } catch
		 * (InterruptedException e) { }
		 */

		System.out.println("Application terminated ");
	}

}
