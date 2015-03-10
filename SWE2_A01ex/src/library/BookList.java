package library;

import java.util.Calendar;

final class BookList {
	
	private BookNode head;


	/**
	 * @param head
	 */
	BookList() {
		this.head = null;
	}

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
		
		//System.out.println(i);
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
	
	
	BookNode firstBook() {
		return head; 
	} // firstBook
	
	BookNode getHead() {
		return head; 
	} // firstEntry
	
	
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
	
	boolean givebackBook(String title){
		BookNode[] bookNodeLookupList = lookup(title);
		if (bookNodeLookupList.length !=1 )
		{return false;}
		BookNode bookNode = bookNodeLookupList[0];
		bookNode.getBook().setLended(false);
		bookNode.getBook().setCal(Book.LIBRARY_TERMINATION);
		return true;		
	}
	
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

	int lendBook(Person person, int idBook) {
		BookNode bookNode = lookup(idBook);
		if (bookNode==null){
			//System.out.println("trotaculo");
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

	int available(int idBook) {
		BookNode bookNode = lookup(idBook);
		if (bookNode==null){return 0;}
		else {return available(bookNode)?1:2;}
	}

	boolean available(BookNode bookNode) {
		//BookNode bookNode = lookup(idBook);
		return bookNode.getBook().isLended();
	}

}
