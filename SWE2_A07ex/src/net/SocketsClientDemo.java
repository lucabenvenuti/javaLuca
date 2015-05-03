package net;

import inout.In;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class SocketsClientDemo {

	public static void main(String[] args) throws UnknownHostException,
			IOException {

		Socket socket = null;// new Socket("localhost", 12345);

		do {
			System.out.println("Digit host name");
			String hostName = In.readLine();
			System.out.println("Digit port number");
			String portNumber = In.readLine();
			try {
				int n = Integer.parseInt(portNumber);
				socket = new Socket(hostName, n);
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid port number");

			}

		} while (socket == null);

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			/*
			 * String line; while ((line = reader.readLine()) != null) {
			 * System.out.println(line); }
			 */

			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			PrintWriter writerFile = new PrintWriter("out.txt");

			Buffer buffer = new Buffer(3);

			Producer p1 = new Producer(buffer);
			Consumer c1 = new Consumer(buffer, writer, reader, writerFile);

			p1.start();
			c1.start();

			try {
				p1.join();
				c1.join();
			} catch (InterruptedException e) {
			}

			socket.shutdownOutput();
			writer.close();
			writerFile.close();

		} finally {
			socket.close();

		}
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
					System.out.println("Producer terminated ");
					break;
				}
				buffer.put(value);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class Consumer extends Thread {
	private final Buffer buffer;
	private PrintWriter writer;
	private BufferedReader reader;
	private PrintWriter writerFile;

	public Consumer(Buffer buffer, PrintWriter writer, BufferedReader reader,
			PrintWriter writerFile) {
		this.buffer = buffer;
		this.writer = writer;
		this.reader = reader;
		this.writerFile = writerFile;
	}

	@Override
	public void run() {

		while (true) {
			try {
				String getter = buffer.get(
					//	writer, reader, writerFile
						);
				writer.println(getter);
				writer.flush();
				/*
				 * try { // while ((line = reader.readLine()) != null) {
				 * System.out.println(reader.readLine()); // } } catch (IOException e) {
				 * // TODO Auto-generated catch block e.printStackTrace(); }
				 */
				writerFile.println(getter + "   " + new Date());
				writerFile.flush();

				if (Buffer.TERMINATIONLINE.equals(getter)) {
					// send
					System.out.println("Producer terminated ");
					break;
				}
				// send
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
