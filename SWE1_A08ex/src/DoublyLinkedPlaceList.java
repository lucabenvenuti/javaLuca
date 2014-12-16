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

public class DoublyLinkedPlaceList {
	private DoublyLinkedPlace head;
	private DoublyLinkedPlace tail;
	private DoublyLinkedPlaceList next;
//	private DoublyLinkedPlaceList prev;
	private int size;
	private int row;

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
		
		 if (getHead() == null) { 
			// System.out.println("trota1");
			 if (getTail() != null){
				 System.out.println("trotaculo");
			 } 
			 setHead(node);
			 setTail(getHead());
		 } else{
			// System.out.println("trota2");
			 getTail().setNext(node);
			 node.setPrev(getTail());
			 node.setNext(null);
			 setTail(node);
			 
		 }

		
	}
	
	public void print() {
		DoublyLinkedPlace p = head;
		while (p != null) {
			System.out.println(p.getPlace().getAvailability());
		}
		System.out.println("end of list.");
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public DoublyLinkedPlaceList getNext() {
		return next;
	}

	public void setNext(DoublyLinkedPlaceList next) {
		this.next = next;
	}
}
