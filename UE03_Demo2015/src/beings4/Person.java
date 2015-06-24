package beings4;

import inout.Out;

public abstract class Person extends Object implements CanTalk, Worker {
	
	private final String name; 
	
	public Person(String name) {
		super(); 
		this.name = name; 
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(HasName o) {
		return this.getName().compareTo(o.getName());
	}

	@Override
	public void talkWith(CanListen other) {
		Out.println(this.getName() + " talks with " + other.getName());
		other.listenTo(this); 
	}
	
	@Override
	public void listenTo(CanTalk other) {
		Out.println(this.getName() + " listens to " + other.getName()); 
	}
	
	@Override
	public void live() {
		work(); 
		haveFun();
		sleep(); 
	}
	
	public abstract void haveFun();
	
	@Override
	public void sleep() { 
		Out.println("Schnarch!"); 
	}
}
