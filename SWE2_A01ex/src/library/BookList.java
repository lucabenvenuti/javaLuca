package library;

import java.util.Calendar;

/**
 * @author luca
 * BookList class stores the head of a BookNode list, and allows a series of operation
 */
final class BookList {
	
	private BookNode head;

	/**
	 * @param head
	 */
	BookList() {
		this.head = null;
	}

	/**
	 * @param name
	 * @param location
	 * @return the created BookNode object
	 */
	BookNode insertBook(String name, String location) {
		if (this.head == null){
			head = new BookNode(new Book(0, name, location));
		return head;}
		else {
			BookNode pred = null;
			BookNode curr = head;
			while (curr != null){
				pred = curr;
			curr = curr.getNext();
		} 
			BookNode node = new BookNode(new Book(pred.getBook().getId()+1, name, location));
			pred.setNext(node);
			return node;
		}
	}	
		
	/**
	 * @param name
	 * @return the BookNode objects array which Books have titles coincide with name
	 */
	BookNode[] lookup(String name){
		BookNode node = head;
		
		int i=0;
		while (node != null){
			if (node.getBook().getTitle().toLowerCase().contains(name.toLowerCase())){
				i++;
			}
			node = node.getNext();
		}
		
		if (i==0) return null;
		
		BookNode[] bookNodeLookupList = new BookNode[i];
		i=0;
		node = head;
		while (node != null){
			if (node.getBook().getTitle().toLowerCase().contains(name.toLowerCase())){
				bookNodeLookupList[i]=node;
				i++;
			}
			node = node.getNext();
		}
		return bookNodeLookupList;
	}
	
	/**
	 * @return all the BookNode objects stored in this list as BookNode array
	 */
	BookNode[] getBookArray(){
		BookNode node = head;
		
		int i=0;
		while (node != null){
			
				i++;
				
			node = node.getNext();
		}
		
		BookNode[] bookNodeLookupList = new BookNode[i];
		i=0;
		node = head;
		while (node != null){
			
				bookNodeLookupList[i]=node;
				i++;
			node = node.getNext();
		}
		
		return bookNodeLookupList;
	}
	
	/**
	 * @param idBook
	 * @return the BookNode with the Book object thas has an ID coincident with idBook
	 */
	BookNode lookup(int idBook) {
		BookNode node = head;
		
		while (node != null){
			if (node.getBook().getId()==idBook){
				return node;
			}
			node = node.getNext();
		}
		return null;
	}
	
	/**
	 * @return the BookNode objects array which Books have restitution dates later than today
	 */
	BookNode[] overdue(){
		BookNode node = this.head;
		
		int i=0;
		while (node != null){
			if (node.getBook().getCal().before(Calendar.getInstance())){
				i++;
			}
			node = node.getNext();
		}
		
		BookNode[] bookNodeLookupList = new BookNode[i];
		i=0;
		node = head;
		while (node != null){
			if (node.getBook().getCal().before(Calendar.getInstance())){
				bookNodeLookupList[i]=node;
				i++;
			}
			node = node.getNext();
		}
		
		return bookNodeLookupList;
	}
	
	/**
	 * @param idPerson
	 * @return a BookNode objects array which Books have been borrowed by a Person object with the same ID
	 * as idPerson
	 */
	BookNode[] onePersonBorrowedList(int idPerson){
		BookNode node = this.head;
		int i=0;
		while (node != null){

			if (node.getBook().isLended() && node.getBook().getLender().getId()==idPerson){
				
				i++;
			}
			node = node.getNext();
		}
		BookNode[] bookNodeLookupList = new BookNode[i];
		i=0;
		node = head;
		while (node != null){
			if (node.getBook().isLended() && node.getBook().getLender().getId()==idPerson){
				bookNodeLookupList[i]=node;
				i++;
			}
			node = node.getNext();
		}
		
		return bookNodeLookupList;
	}
	
	
	/**
	 * @return firstBook = head of the list
	 */
	BookNode firstBook() {
		return head; 
	}
	
	/**
	 * @return head = firstBook of the list
	 */
	BookNode getHead() {
		return head; 
	} 
	
	
	/** 
	 * Returns the next entry node for the given current node. 
	 * @param current the given current node
	 * @return the next node after the node current 
	 */
	BookNode nextBook(BookNode current) {
		if (current == null) {
			return null; // no next book
		}
		return current.getNext(); // return next book
	} // nextBook
	
	/**
	 * Returns true if list is empty, false otherwise.  
	 * @return true if list is empty, false otherwise
	 */
	boolean isEmpty() {
		return head == null; 
	}
	
	/**
	 * DEPRECATED: please use 
	 * "int lendBook(Person person, int idBook)"
	 * @param person
	 * @param title
	 * @return true if a book is correctly lended, false otherwise
	 */
	boolean lendBook(Person person, String title){
		BookNode[] bookNodeLookupList = lookup(title);
		if (bookNodeLookupList.length !=1 )
		{return false;}
		BookNode bookNode = bookNodeLookupList[0];
		
		if (available(bookNode) && bookNode.getBook().getLender().getId()!=person.getId()){
			return false;
		} else if (available(bookNode) && bookNode.getBook().getLender().getId()==person.getId()){
			bookNode.getBook().extendCal(Book.DAYS_EXTENDED_LOAN);
			return true;
		} else {
		bookNode.getBook().setLended(true);
		bookNode.getBook().setLender(person);
		bookNode.getBook().setCal(Book.DAYS_FIRST_LOAN);
		return true;}
	}
	
	/**
	 * DEPRECATED: please use 
	 * "boolean givebackBook(int idBook)"
	 * @param title
	 * @return true if a book is correctly given back, false otherwise
	 */
	boolean givebackBook(String title){
		BookNode[] bookNodeLookupList = lookup(title);
		if (bookNodeLookupList.length !=1 )
		{return false;}
		BookNode bookNode = bookNodeLookupList[0];
		bookNode.getBook().setLended(false);
		bookNode.getBook().setCal(Book.LIBRARY_TERMINATION);
		return true;		
	}
	
	/**
	 * @param idBook
	 * @return true if a book is correctly given back, false otherwise
	 */
	boolean givebackBook(int idBook){
		BookNode bookNode = lookup(idBook);
		if (bookNode==null || bookNode.getBook().isLended()==false) {
			return false;
		} else {
		bookNode.getBook().setLended(false);
		bookNode.getBook().setLender(null);
		bookNode.getBook().setCal(Book.LIBRARY_TERMINATION);
		return true;}		
	}

	/**
	 * @param person
	 * @param idBook
	 * @return 2 if a book is correctly lended, 1 if a loan is extended, 0 otherwise
	 */
	int lendBook(Person person, int idBook) {
		BookNode bookNode = lookup(idBook);
		if (bookNode==null){
			return 0;}
		
		if (available(bookNode) && bookNode.getBook().getLender().getId()!=person.getId()){
			return 0;
		} else if (available(bookNode) && bookNode.getBook().getLender().getId()==person.getId()){
			bookNode.getBook().extendCal(Book.DAYS_EXTENDED_LOAN);
			return 1;
		} else {
		bookNode.getBook().setLended(true);
		bookNode.getBook().setLender(person);
		bookNode.getBook().setCal(Book.DAYS_FIRST_LOAN);
		return 2;}
	}

	/**
	 * DEPRECATED: please use 
	 * "boolean available(BookNode bookNode)"
	 * @param idBook
	 * @return, given a BookNode object with a Book object with ID equal to idBook, 
	 * 0 if it does not exist, 
	 * 1 if it is lended,
	 * 2 if it is not lended.
	 */
	int available(int idBook) {
		BookNode bookNode = lookup(idBook);
		if (bookNode==null){return 0;}
		else {return available(bookNode)?1:2;}
	}

	/**
	 * @param bookNode
	 * @return, given a BookNode object with a Book object,
	 * true if it is lended,
	 * false if it is not lended.
	 */
	boolean available(BookNode bookNode) {
		return bookNode.getBook().isLended();
	}

}
