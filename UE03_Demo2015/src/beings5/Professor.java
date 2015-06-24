package beings5;

import inout.Out;

public class Professor extends Person implements Teacher {
	
	String area;

	public Professor(String name, String area) {
		super(name);
		this.area = area;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	} 
	
	@Override
	public void work() {
		Out.println("Do research in " + area);
		teach(); 
	}

	@Override
	public void teach() {
		Out.println("Teach " + area);	
	}

	@Override
	public void haveFun() {
		Out.println("No fun"); 
	}

	@Override
	public void sleep() {
		Out.println("No sleep"); 
	}
	
}
