/**
 * DoublyLinkedPlaceList.java
 *
 * A {@link DoublyLinkedPlaceList} is a class which holds the head and tail of a
 * {@link DoublyLinkedPlace} list.
 * 
 * Software Development I, 2014WS
 * Institute for Pervasive Computing, JKU Linz
 * 
 * @author Michael Haslgrübler
 * @author Welma Pereira
 * @author Andreas Riener
 * 
 * @version 2014-12-09
 */

/// IS NOT DOUBLE LINKED NOWWWWW!!!!!!!!!!!!!!!!!!!!
//IT IS BITCH!  , SEE SETPREV, LINE 86
//IT IS NOT DOUBLE BITCH

public class DoublyLinkedPlaceList {
	private DoublyLinkedPlace head;
	private DoublyLinkedPlace tail;
	private DoublyLinkedPlaceList next;
	private DoublyLinkedPlaceList prev;
	private int size;
	private int row;
	private ScreenRow screenRow;
	
	public DoublyLinkedPlaceList(int row){
		this.setRow(row);
	}
	
	public DoublyLinkedPlaceList(int row, ScreenRow screenRow){
		this.setRow(row);
		this.setScreenRow(screenRow);
	}

	public DoublyLinkedPlace getHead() {
		return head;
	}

	public void setHead(DoublyLinkedPlace head) {
		this.head = head;
	}

	public DoublyLinkedPlace getTail() {
		return tail;
	}

	public void setTail(DoublyLinkedPlace tail) {
		this.tail = tail;
	}

	/**
	 * 
	 * @return the size of the list
	 */
	public int length() {
		return getSize();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * 
	 * @param node
	 *            a node to append to the list
	 */
	public void add(DoublyLinkedPlace node) {
		node.setNext(null);
		
		 if (getHead() == null) { 
			 if (getTail() != null){
				 System.out.println("ERROR");
			 } 
			 setHead(node);
			 setTail(getHead());
			 size =1;
		 } else{
			 getTail().setNext(node);
			 node.setPrev(getTail());
			 
			 setTail(node);
			 size = size+1;
			 
		 }

		
	}
	
	public void print() {
		DoublyLinkedPlace p = head;
		while (p != null) {
		}
		System.out.println("end of list.");
	}

	public DoublyLinkedPlaceList getNext() {
		return next;
	}

	public void setNext(DoublyLinkedPlaceList next) {
		this.next = next;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public ScreenRow getScreenRow() {
		return screenRow;
	}

	public void setScreenRow(ScreenRow screenRow) {
		this.screenRow = screenRow;
	}

	public DoublyLinkedPlaceList getPrev() {
		return prev;
	}

	public void setPrev(DoublyLinkedPlaceList prev) {
		this.prev = prev;
	}
}
