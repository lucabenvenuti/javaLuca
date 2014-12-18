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
	private DoublyLinkedPlaceList prev;
	private int size;
	private int row;

	/**
	 * @param row
	 */
	public DoublyLinkedPlaceList(int row){
		this.setRow(row);
	}

	/**
	 * @return
	 */
	public DoublyLinkedPlace getHead() {
		return head;
	}

	/**
	 * @param head
	 */
	public void setHead(DoublyLinkedPlace head) {
		this.head = head;
	}

	/**
	 * @return
	 */
	public DoublyLinkedPlace getTail() {
		return tail;
	}

	/**
	 * @param tail
	 */
	public void setTail(DoublyLinkedPlace tail) {
		this.tail = tail;
	}

	/**
	 * 
	 * @return the size of the list
	 */
	/**
	 * @return
	 */
	public int length() {
		return getSize();
	}

	/**
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * 
	 * @param node
	 *            a DoublyLinkedPlace node to append to the list
	 */
	public void add(DoublyLinkedPlace node) {
		node.setNext(null);

		if (getHead() == null) { 
			if (getTail() != null){
				System.out.printf("%s%n","error");
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

	/**
	 * print the list of DoublyLinkedPlace
	 */
	public void print() {
		DoublyLinkedPlace p = head;
		while (p != null) {
		}
		System.out.printf("%s%n","end of list.");
	}

	/**
	 * @return
	 */
	public DoublyLinkedPlaceList getNext() {
		return next;
	}

	/**
	 * @param next
	 */
	public void setNext(DoublyLinkedPlaceList next) {
		this.next = next;
	}

	/**
	 * @return
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @return
	 */
	public DoublyLinkedPlaceList getPrev() {
		return prev;
	}

	/**
	 * @param prev
	 */
	public void setPrev(DoublyLinkedPlaceList prev) {
		this.prev = prev;
	}
}
