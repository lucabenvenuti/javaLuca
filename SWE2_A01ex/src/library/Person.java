package library;

/**
 * Person.java
 *
 * A {@link Person} is a class which 
 * store a person information.
 * 
 * Software Development II, 2015SS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 */
public final class Person {

	
	private final int id;
	
	private final String firstName;
	private final String lastName;
	
	private String address;
	
	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param address
	 */
	Person(int id, String firstName, String lastName, String address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	/**
	 * @return the person ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the person first name
	 */
	String getFirstName() {
		return firstName;
	}

	/**
	 * @return the person last name
	 */
	String getLastName() {
		return lastName;
	}

	/**
	 * @return the person address
	 */
	String getAddress() {
		return address;
	}
	
	/**
	 * @param address
	 */
	void setAddress(String address) {
		this.address = address;
	}


	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", address=" + address + "]";
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
	
}
