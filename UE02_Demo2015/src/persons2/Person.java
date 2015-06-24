package persons2;

import inout.Out; 

public class Person extends Object {
	
	String name; 
	
	public Person() {
		this(""); 
	}
	
	public Person(String name) {
		super(); 
		Out.println("Person constructor");
		// DON'T DO THAT: live(); 
		// NEVER CALL DYNAMICALLY BOUND METHOD IN CONSTRUCTOR
		this.name = name; 
	}

	public void live() {
		Out.println("Person life ");
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}

	public String getName() {
		return name;
	}
	

}
