package net;

import inout.In;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * SocketsClientDemo.java
 *
 * A {@link SocketsClientDemo} is a public class. It starts a Socket, which can
 * communicate with a server. After being connected to a Server, a Producer ( =
 * Reader ) reads user inputs and send them to a Buffer object. Synchronously, a
 * Consumer ( = Sender ) reads Strings from the Buffer object, it sends them to
 * the Server and receives from the Server a String indicating if it is a number
 * and, eventually, prime. Finally, the Consumer writes these evaluations to a
 * file.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class SocketsClientDemo {

	public static void main(String[] args) throws UnknownHostException,
			IOException {

		Socket socket = null;

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

			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			PrintWriter writerFile = new PrintWriter("out.txt");
			writerFile.println("#-#-# This is the beginning of the file #-#-#");
			writerFile.flush();

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

	/**
	 * It reads user inputs and send them to a Buffer object. Insertion is
	 * user-terminated by {@link Buffer.TERMINATIONLINE}.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {

		while (true) {
			try {
				System.out.println("Insert a new number:");
				String value = In.readLine();

				if (Buffer.TERMINATIONLINE.equals(value)) {
					buffer.put(value);
					System.out.println("[Producer] terminated.");
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

	/**
	 * It reads Strings from the Buffer object, it sends them to the Server and
	 * receives from the Server a String indicating if it is a number and,
	 * eventually, prime. Finally, the Consumer writes these evaluations to a
	 * file. It stops when it reads {@link Buffer.TERMINATIONLINE} from the
	 * Buffer.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {

		while (true) {
			try {
				String value = buffer.get();

				writer.println(value);
				writer.flush();
				String result = reader.readLine();

				if (result == null) {
					writerFile
							.println("#-#-# This is the end of the file #-#-#");
				} else {
					writerFile.println(result);
				}
				writerFile.flush();

				if (Buffer.TERMINATIONLINE.equals(value)) {
					System.out.println("[Consumer] terminated.");
					break;
				}
			} catch (InterruptedException | IOException e) {
				e.printStackTrace();
			}
		}
	}

}