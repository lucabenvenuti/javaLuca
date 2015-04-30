package exception;

import java.io.FileNotFoundException;
import java.net.ConnectException;

public class ExceptionsDemo {

	public static void main(final String[] args) {
		try {
			exceptionsTest(1);
		} catch (ConnectException | FileNotFoundException e) {
			throw new AssertionError(e);
			// System.out.println(e.getMessage());
			// e.printStackTrace();
		}
	}

	public static void exceptionsTest(final int x) throws ConnectException,
			FileNotFoundException {
		if (x == 1) {
			throw new ConnectException("something bad happened!");
		} else {
			throw new FileNotFoundException();
		}
		// System.out.println("some code...");
	}
}
