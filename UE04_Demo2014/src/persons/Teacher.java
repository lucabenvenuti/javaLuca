package persons;

public class Teacher extends Person {
	
	public Teacher(String name) {
		super(name); 
	}
	
	public void teach() {
		System.out.println("Teacher " + name + " is teaching"); 
	}

}
