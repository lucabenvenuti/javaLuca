package library;

/**
 * @author luca
 * PersonList or BorrowersList or UsersList 
 */
final class PersonList {

	private PersonNode head;
	//private static final int NUM_BOOKS = 400;

	/**
	 * @param head
	 */
	PersonList() {
		this.head = null;
	}

	PersonNode insertPerson(String firstName, String lastName, String address) {
		if (this.head == null){
			head = new PersonNode(new Person(0, firstName, lastName, address));
			//Person(int id, String firstName, String lastName, String address)
		return head;}
		else {
			PersonNode pred = null;
			PersonNode curr = head;
			while (curr != null){
				pred = curr;
			curr = curr.getNext();
		} // while
			PersonNode node = new PersonNode(new Person(pred.getPerson().getId()+1, firstName, lastName, address));
			pred.setNext(node);
			//node.setNext(curr);
			return node;
		}
	}	
		
	PersonNode lookup(int id){
		//str1.toLowerCase().contains(str2.toLowerCase())
		PersonNode node = head;
		
		int i=0;
		while (node != null){
			if (node.getPerson().getId()==id){
				return node;
			}
			node = node.getNext();
		}
		return null;
	/*	PersonNode[] personNodeLookupList = new PersonNode[i];
		i=0;
		node = head;
		while (node != null){
			if (node.getPerson().getId()==id){
				personNodeLookupList[i]=node;
			}
			node = node.getNext();
		}
		
		return personNodeLookupList;*/
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
