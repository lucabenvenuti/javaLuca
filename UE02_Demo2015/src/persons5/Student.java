package persons5;

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
	
	private Study study;
	
	public Student(String name, Study study) {
		super(name); 
		this.study = study; 
	}

	public Study getStudy() {
		return study;
	}

	public void setStudy(Study study) {
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
