package net;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Date;

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

	public synchronized String get(
//			PrintWriter writer, BufferedReader reader,
//			PrintWriter writerFile
			) throws InterruptedException {
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