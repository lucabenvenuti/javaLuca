package net;

/**
 * Buffer.java
 *
 * A {@link Buffer} is a class. It contains an array of Strings, two internal
 * pointers (head, tail) and the number of elements. Its methods can
 * synchronously put a new String into the array and get a String from the
 * array.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 */
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

	/**
	 * This method can synchronously put a new String into the array, eventually
	 * replacing an existing one.
	 * 
	 * @param value
	 * @throws InterruptedException
	 */
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

	/**
	 * This method can synchronously get a String from the array. No String is
	 * removed from the array by this method.
	 * 
	 * @return String
	 * @throws InterruptedException
	 */
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