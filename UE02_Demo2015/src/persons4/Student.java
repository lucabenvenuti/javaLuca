package persons4;

import inout.Out;

public class Student extends Person {
	
	// overriding and overloading ---------------------------------------------
	
	@Override
	public void meetsWith(Person p) {
		
		Out.println("Student meets " + p.getClass().getName()); 
	}

	public void meetsWith(Professor p) {
		Out.println("Student meets professor"); 
	}
	
	public void meetsWith(Student p) {
		Out.println("Student meets student"); 
	}

	// ------------------------------------------------------------------------
	
	private String study;
	
	public Student(String name, String study) {
		super(name); 
		this.study = study; 
	}

	public String getStudy() {
		return study;
	}

	public void setStudy(String study) {
		this.study = study;
	}

	@Override
	protected void work() {
		Out.println("Learn");
	}

	@Override
	protected void haveFun() {
		Out.println("Drink beer");
	}

	@Override
	public void live() {
		Out.println("Call Mam"); 
		super.live();
	}
			
	@Override
	public String toString() {
		return super.toString()+  " [study = " + study + "]";
	}

	@Override
	protected String getPersonType() {
		return "Student";
	} 
	
}
