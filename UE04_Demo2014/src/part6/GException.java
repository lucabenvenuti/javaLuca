package part6;

// Generische Exception-Klassen nicht erlaubt. 
public class GException/* <T> */extends Exception {
	// T elem;

	/**
	 * 
	 */
	private static final long serialVersionUID = 2143996528440831152L;

	public static void main(String[] args) {

		try {
			throw new GException();
			// do something
		} catch (GException excpt) { // kann nicht funktionireren

		}

	}

}
