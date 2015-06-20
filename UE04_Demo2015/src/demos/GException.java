package demos;

// Generische Exception-Klassen nicht erlaubt. 
public class GException/*<T>*/ extends Exception {
	//T elem; 
	
	public static void main(String[] args)  {
		
		try {
			throw new GException(); 
			// do something 
		} catch (GException excpt) { // kann nicht funktionieren
			
		}
		
	}

}
