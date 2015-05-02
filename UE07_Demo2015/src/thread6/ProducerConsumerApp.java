package thread6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Buffer {

	private Object obj = null;

	public synchronized void put(Object o) {
		obj = o;
	}

	public synchronized Object retrieve() {
		Object o = obj;
		obj = null;
		return o;
	}

	public synchronized boolean isEmpty() {
		return obj == null;
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
					System.out.println("Producer produced " + s);
					buffer.notifyAll();
				}
				Thread.sleep((int) (1000 * Math.random()));
			} catch (InterruptedException e) {
				interrupt();
			}
		}
		System.out.println("Producer terminated ");
	}

	private void doSomeHeavyWork() throws InterruptedException {
		// Thread.sleep(100);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter String");
		try {
			String s = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
					Object o = buffer.retrieve();
					System.out.println("  Consumer found " + o);
					buffer.notifyAll();
				}
				Thread.sleep((int) (1000 * Math.random()));
			} catch (InterruptedException e) {
				interrupt();
			}
		}
		System.out.println("Consumer terminated ");
	}

	private void doSomeHeavyWork() throws InterruptedException {
		Thread.sleep(100);
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
