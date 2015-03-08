package library;

/**
 * @author luca
 * PersonList or BorrowersList or UsersList 
 */
final class PersonList {

	private PersonNode head;

	/**
	 * @param head
	 */
	PersonList() {
		this.head = null;
	}

	PersonNode insertPerson(String firstName, String lastName, String address) {
		if (this.head == null){
			head = new PersonNode(new Person(0, firstName, lastName, address));
		return head;}
		else {
			PersonNode pred = null;
			PersonNode curr = head;
			while (curr != null){
				pred = curr;
			curr = curr.getNext();
		}
			PersonNode node = new PersonNode(new Person(pred.getPerson().getId()+1, firstName, lastName, address));
			pred.setNext(node);
			return node;
		}
	}	
		
	PersonNode lookup(int id){
		PersonNode node = head;
		
		int i=0;
		while (node != null){
			if (node.getPerson().getId()==id){
				return node;
			}
			node = node.getNext();
		}
		return null;
	}
		
	PersonNode firstPerson() {
		return head; 
	} // firstPerson
	
	PersonNode getHead() {
		return head; 
	} // firstEntry
	
	
	/** 
	 * Returns the next entry node for the given current node. 
	 * @param current the given current node
	 * @return the next node after the node current 
	 */
	PersonNode nextPerson(PersonNode current) {
		if (current == null) {
			return null; // no next person
		}
		return current.getNext(); // return next person
	} // nextPerson
	
	/**
	 * Returns true if list is empty, false otherwise.  
	 * @return true if list is empty, false otherwise
	 */
	boolean isEmpty() {
		return head == null; 
	}
	
	
}
