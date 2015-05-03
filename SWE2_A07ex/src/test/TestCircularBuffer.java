package test;

public class TestCircularBuffer {

	public static void main(String[] args) {
		TestCircularBuffer t = new TestCircularBuffer();
	  }

	  public TestCircularBuffer() {
	    CircularBuffer c = new CircularBuffer(3);

	    System.out.println("Storing: 1");
	    try {
			c.put("1");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			System.out.println("Reading: " + c.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("Storing: 2");
	    try {
			c.put("1");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("Storing: 3");
	    try {
			c.put("1");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("Storing: 4");
	  }
	}

	class CircularBuffer {
		private String data[];
		private int head;
		private int tail;
		private int elements;

		public CircularBuffer(Integer number) {
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