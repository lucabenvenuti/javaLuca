package beings5;

public interface HasName extends Comparable<HasName> {
	
	public String getName(); 
	
	default int compareTo(HasName o) {
		return this.getName().compareTo(o.getName());
	}
	
	default boolean isNameValid() {
		return getName() != null && ! getName().equals("") &&
				Character.isAlphabetic(getName().charAt(0));
	}

}
