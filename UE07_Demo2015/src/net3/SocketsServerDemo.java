package net3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketsServerDemo {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		ServerSocket server = new ServerSocket(12345);

		// /////////////////////////////////
		// Version 3: calling accept repeatedly

		while (true) {
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
				for (int i = 0; i < 3; i++){
				writer.println("Hello World!");}
				writer.flush();
				socket.shutdownOutput();
				
				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
				}

			} finally {
				System.out.println("Closing stuff");
				writer.close();
				reader.close();
				socket.close();
			}
		}

	}

}
