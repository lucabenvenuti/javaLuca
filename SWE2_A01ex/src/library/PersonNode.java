package library;

/**
 * PersonNode.java
 *
 * A {@link PersonNode} is a class which 
 * store an object {@link Person} and the next {@link PersonNode} object
 * 
 * Software Development II, 2015SS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 */
public final class PersonNode {
	
	private Person person;
	private PersonNode next;
	/**
	 * @param person
	 * @param next
	 */
	PersonNode(Person person, PersonNode next) {
		this.setPerson(person);
		this.setNext(next);
	}
	
	/**
	 * @param person
	 */
	PersonNode(Person person){
		this(person, null);
	}
	
	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}
	/**
	 * @param person the person to set
	 */
	void setPerson(Person person) {
		this.person = person;
	}
	/**
	 * @return the next
	 */
	PersonNode getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	void setNext(PersonNode next) {
		this.next = next;
	}

}
