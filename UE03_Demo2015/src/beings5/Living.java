package beings5;

import inout.Out;

public interface Living {
	
	void live(); 
	
	default void sleep() { 
		Out.println("Schnarch!"); 
	} 

}
