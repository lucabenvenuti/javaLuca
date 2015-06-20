package demos;

class G<T> {
	T t; 
	public G(T t) {
		this.t = t; 
		// Objekterzeugung mit Typparameter nicht möglich
//		T t = new T(); 	// does not work
//		T[] ts = new T[10]; 	// does not work	
	}
	
	public static void main(String[] args)  {
		
		// Typcast auf generische Typen nicht möglich 
		
		Object io = new G<Integer>(1); 
		
		if (io instanceof G<?>) {
			System.out.println("It's a G<?>");
		}
		
		Object so = new G<String>("G"); 
		
		if (so instanceof G<?>) {
			System.out.println("It's a G<?>");
		}
		
		// Metaklassen von generischen Typen nicht bekannt: 
		//Class clazz = G<T>.class; 
		Class clazz = G.class; 
	}
}
