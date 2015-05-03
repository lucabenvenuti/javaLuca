package net;

import inout.In;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketsServerDemo {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		ServerSocket server = null;
		// new ServerSocket(12345); // In.readInt());
		do {
			System.out.println("Digit port number");
			String portNumber = In.readLine();
			try {
				int n = Integer.parseInt(portNumber);
				server = new ServerSocket(n);
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid port number");

			}

		} while (server == null);

		boolean continuation;
		do {
			Socket socket = null;
			PrintWriter writer = null;
			BufferedReader reader = null;
			try {
				System.out.println("Waiting for client requests... ");
				socket = server.accept();
				System.out.println("Connected to client ");

				reader = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));

				writer = new PrintWriter(socket.getOutputStream());
				String line;
				String lineOut;
				while ((line = reader.readLine()) != null) {
					try {
						int n = Integer.parseInt(line);
						if (superSlowIsPrimeImplementation(n)) {
							lineOut = line + " is a prime number";
						} else {
							lineOut = line + " is not a prime number";
						}
					} catch (NumberFormatException e) {
						if (Buffer.TERMINATIONLINE.equals(line)) {
							System.out.println("terminated");
							break;
						} else {
							lineOut = line + " is not an integer";
						}
					}

					writer.println(lineOut);
					System.out.println(lineOut);

				}
				writer.flush();
				socket.shutdownOutput();

			} finally {
				System.out.println("Closing stuff");
				writer.close();
				reader.close();
				socket.close();
			}
			System.out
					.println("Wait for another client? y = yes, any other char = no");
			continuation = (In.readChar() == 'y');
		} while (continuation);
		System.out.println("server terminated");
	}

	private static boolean superSlowIsPrimeImplementation(int n) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
		if (n <= 1) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		for (int i = 2; i <= Math.sqrt(n) + 1; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
