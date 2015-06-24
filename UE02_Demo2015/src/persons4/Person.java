package persons4;

import inout.Out; 

public class Person extends Object {
	
	// overriding and overloading ---------------------------------------------
	
	public void meetsWith(Person p) {
		Out.println("Person meets person"); 
	}
	
	// ------------------------------------------------------------------------
	
	private final String name; 
	
	public Person(String name) {
		super(); 
		this.name = name; 
	}

	public String getName() {
		return name;
	}

	public void live() {
		work(); 
		haveFun();
		sleep(); 
	}
	
	protected void work() { } 	
	protected void haveFun() { }
	
	protected void sleep() { 
		Out.println("Schnarch!"); 
	}

	@Override
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
		return getPersonType() + ": " + getName();
	}

	protected String getPersonType() {
		return "Person"; 
	}
	
	
}
