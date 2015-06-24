package beings5;

import inout.Out;

public class Student extends Person {
	
	private Studies study;
	
	public Student(String name, Studies study) {
		super(name); 
		this.study = study; 
	}

	public Studies getStudy() {
		return study;
	}

	public void setStudy(Studies study) {
		this.study = study;
	}

	@Override
	public void work() {
		Out.println("Learn");
	}

	@Override
	public void haveFun() {
		Out.println("Drink beer");
	}

	@Override
	public void live() {
		Out.println("Call Mam"); 
		super.live();
	}
	
}
