package thread5;

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

		while (true) {
			try {
				synchronized (buffer) {
					while (!buffer.isEmpty()) {
						System.out.println(" ++ Producer " + this.getId()
								+ " blocked");
						buffer.wait();
					}
					String s = " " + i++;
					doSomeHeavyWork();
					buffer.put(s);
					System.out.println("Producer " + this.getId()
							+ " produced " + s);
					buffer.notifyAll();
				}
				Thread.sleep((int) (100 * Math.random()));
			} catch (InterruptedException e) {

			}
		}
	}

	private void doSomeHeavyWork() throws InterruptedException {
		Thread.sleep(10);
	}

}

class Consumer extends Thread {
	private final Buffer buffer;

	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		while (true) {
			try {
				synchronized (buffer) {
					while (buffer.isEmpty()) {
						System.out.println(" ++ Consumer " + this.getId()
								+ " blocked");
						buffer.wait();
					}
					doSomeHeavyWork();
					Object o = buffer.retrieve();
					System.out.println("  Consumer " + this.getId() + " found "
							+ o);
					buffer.notifyAll();
				}

			} catch (InterruptedException e) {

			}
		}
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
			Thread.sleep(1_000);
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
