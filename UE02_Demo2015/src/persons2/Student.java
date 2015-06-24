package persons2;

import inout.Out;

public class Student extends Person {

	public Student(String name) {
		super();
		Out.println("Student constructor");
	}
	
	@Override
	public void live() {
		Out.println("Student life " + getName().toString());
	}	
	
}
