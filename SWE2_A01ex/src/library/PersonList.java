package library;

/**
 * PersonList.java
 *
 * A {@link PersonList} is a class which 
 * store an head object {@link PersonNode} of a list, 
 * and allows a series of operation
 * 
 * Software Development II, 2015SS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 */
final class PersonList {

	private PersonNode head;

	/**
	 * @param head
	 */
	PersonList() {
		this.head = null;
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @return the created PersonNode object
	 */
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
		
	/**
	 * @param id
	 * @return the PersonNode with a Person object with the same ID as id
	 */
	PersonNode lookup(int id){
		PersonNode node = head;
		
		while (node != null){
			if (node.getPerson().getId()==id){
				return node;
			}
			node = node.getNext();
		}
		return null;
	}
		
	boolean isFirstLastName(String firstName, String lastName){
		PersonNode node = head;
		while (node != null){
			if (node.getPerson().getFirstName().equals(firstName) 
					&& node.getPerson().getLastName().equals(lastName)){
				return true;
			}
			
			node = node.getNext();
		}
		return false;
	}
	
	PersonNode lookup(String firstName, String lastName) {
		PersonNode node = head;
		while (node != null){
			if (node.getPerson().getFirstName().equals(firstName) 
					&& node.getPerson().getLastName().equals(lastName)){
				return node;
			}
			
			node = node.getNext();
		}
		return null;
	}
	
	
	/**
	 * @return all the PersonNode objects stored in this list as PersonNode array
	 */
	PersonNode[] getPersonArray(){
		PersonNode node = head;
		
		int i=0;
		while (node != null){
			
				i++;
			
			node = node.getNext();
		}
		
		PersonNode[] personNodeLookupList = new PersonNode[i];
		i=0;
		node = head;
		while (node != null){
			
				personNodeLookupList[i]=node;
			i++;
			node = node.getNext();
		}
		
		return personNodeLookupList;
	}
	
	/**
	 * @return the head = first element in the list
	 */
	PersonNode firstPerson() {
		return head; 
	} // firstPerson
	
	/**
	 * @return the head = first element in the list
	 */
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
