package library;

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
