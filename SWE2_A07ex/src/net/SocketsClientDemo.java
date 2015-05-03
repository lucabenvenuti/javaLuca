package net;

import inout.In;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketsClientDemo {

	public static void main(String[] args) throws UnknownHostException,
			IOException {

		// /////////////////////////////////
		// client socket demo

		Socket socket = new Socket("localhost", 12345);

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

			PrintWriter writer = new PrintWriter(socket.getOutputStream());

			Buffer buffer = new Buffer(3);

			Producer p1 = new Producer(buffer);
			Consumer c1 = new Consumer(buffer, writer);
			// Producer p2 = new Producer(buffer);
			// Consumer c2 = new Consumer(buffer);

			p1.start();
			c1.start();
			// writer.println("OK");
			// writer.println("123");
			// writer.println("11");
			// writer.println("q");
			// writer.println("11");
			// writer.flush();
			
			try {
				p1.join();
				c1.join();
			} catch (InterruptedException e) {
			}
			
			socket.shutdownOutput();

		} finally {
			socket.close();
		}
	}
}

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

	public synchronized String get(PrintWriter writer) throws InterruptedException {
		while (bufferEmpty()) {
			wait();
		}

		String value = data[head++];
		if (head == data.length) {
			head = 0;
		}
		elements--;
		writer.println(value);
		writer.flush();
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
				System.out.println("insert a new number:");
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
	private PrintWriter writer;

	public Consumer(Buffer buffer, PrintWriter writer) {
		this.buffer = buffer;
		this.writer = writer;
	}

	@Override
	public void run() {

		while (true) {
			try {
				String getter = buffer.get(writer);

				if (Buffer.TERMINATIONLINE.equals(getter)) {
					// send
				//	System.out.println(getter);
	//				writer.println(getter);
	//				writer.flush();

					break;
				}
	//			writer.println(getter);
	//			writer.flush();
		//		System.out.println(getter);
				// send
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// System.out.println("Producer terminated ");
	}

}
