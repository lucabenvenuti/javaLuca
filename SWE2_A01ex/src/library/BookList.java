package library;

final class BookList {
	
	private BookNode head;
	//private static final int NUM_BOOKS = 400;

	/**
	 * @param head
	 */
	BookList() {
		this.head = null;
	}

	BookNode insertEntry(String name, String location) {
		if (this.head == null){
			head = new BookNode(new Book(0, name, location));
		return head;}
		else {
			BookNode pred = null;
			BookNode curr = head;
			while (curr != null){
				pred = curr;
			curr = curr.getNext();
		} // while
			BookNode node = new BookNode(new Book(pred.getBook().getId()+1, name, location));
			pred.setNext(node);
			//node.setNext(curr);
			return node;
		}
	}	
		
	BookNode[] lookup(String name){
		//str1.toLowerCase().contains(str2.toLowerCase())
		BookNode node = head;
		
		int i=0;
		while (node != null){
			if (node.getBook().getTitle().toLowerCase().contains(name.toLowerCase())){
				i++;
			}
		}
		
		BookNode[] bookNodeLookupList = new BookNode[i];
		i=0;
		node = head;
		while (node != null){
			if (node.getBook().getTitle().toLowerCase().contains(name.toLowerCase())){
				bookNodeLookupList[i]=node;
			}
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
}
