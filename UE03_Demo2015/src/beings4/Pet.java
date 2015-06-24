package beings4;

import inout.Out;

public class Pet extends Animal implements CanListen {
	
	private final String name; 
	
	public Pet(String name) {
		super();
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int compareTo(HasName o) {
		return this.getName().compareTo(o.getName());
	}

	@Override
	public void listenTo(CanTalk other) {
		Out.println(this.getName() + " listens to " + other.getName()); 
	}
	
}
