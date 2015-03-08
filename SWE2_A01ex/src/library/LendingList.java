package library;

/**
 * @author luca
 * LendingList or PersonNode or Hircocervus
 */
final class LendingList {

	private LendingNode head;
	
	private Person person;
	private LendingList next;
	/**
	 * @param head
	 * @param person
	 * @param next
	 */
	LendingList(Person person, LendingList next) {
		this.head = null;
		this.person = person;
		this.next = next;
	}
	
	LendingNode insertLending(String name) {
		return insertLending(new Entry(name, areaCode, number)); 
	}
	
	/**
	 * @return the head
	 */
	LendingNode getHead() {
		return head;
	}
	/**
	 * @param head the head to set
	 */
	void setHead(LendingNode head) {
		this.head = head;
	}
	/**
	 * @return the person
	 */
	Person getPerson() {
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
	LendingList getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	void setNext(LendingList next) {
		this.next = next;
	}
}
