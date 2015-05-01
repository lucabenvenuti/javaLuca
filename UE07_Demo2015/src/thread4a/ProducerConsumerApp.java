package thread4a;

class Buffer {

	private Object obj = null;

	public void put(Object o) {
		obj = o;
	}

	public Object retrieve() {
		Object o = obj;
		obj = null;
		return o;
	}

	public boolean isEmpty() {
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
				if (buffer.isEmpty()) {
					String s = " " + i++;
					doSomeHeavyWork();
					buffer.put(s);
					System.out.println("Producer " + this.getId()
							+ " produced " + s);
				} else {
					System.out.println("Producer " + this.getId()
							+ " produced nothing");

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

public class ProducerConsumerApp {

	public static void main(String[] args) {

		Buffer buffer = new Buffer();

		Producer p1 = new Producer(buffer);
		Producer p2 = new Producer(buffer);

		p1.start();
		p2.start();

		try {
			Thread.sleep(1_000);
		} catch (InterruptedException e) {
		}

		p1.interrupt();
		p2.interrupt();

		try {
			p1.join();
			p2.join();
		} catch (InterruptedException e) {
		}

		System.out.println("Application terminated ");
	}

}
