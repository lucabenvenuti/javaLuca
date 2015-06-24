package beings5;

public interface Teacher extends Worker {
	
	public void teach(); 
	
	default void work() {
		teach(); 
	}
	
}
