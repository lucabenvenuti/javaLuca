/**
 * DoublyLinkedPlaceList.java
 *
 * A {@link DoublyLinkedPlaceList} is a class which holds the head and tail of a
 * {@link DoublyLinkedPlace} list.
 * 
 * Software Development I, 2014WS
 * JKU Linz
 * 
 * @author Michael Haslgrübler
 * @author Welma Pereira
 * @author Andreas Riener
 * @author Luca Benvenuti
 * 
 * @version 2014-12-18
 */

public class DoublyLinkedPlaceList {
	private DoublyLinkedPlace head;
	private DoublyLinkedPlace tail;
	private DoublyLinkedPlaceList next;
	private DoublyLinkedPlaceList prev;
	private int size;
	private int row;
	
	/*	public Department(Department oldDepartment) {
    this.id = oldDepartment.id;
    this.name = oldDepartment.name;
}*/
	
	/*	this.firstNode = firstNode1;
	// so basically I am chaining elements from "copy" to firstNode1 and then making "this" = to firstNode1. 

	SortedLinkedSetNode currentNode = copy.firstNode;

	while (currentNode.next !=null) {  
	    firstNode1.add(currentNode.next.value);
	    this.firstNode = firstNode1;
	    currentNode = currentNode.next;
	 }*/
	
	public DoublyLinkedPlaceList(DoublyLinkedPlaceList oldDoublyLinkedPlaceList) {
		
		for ( DoublyLinkedPlace linkedPlace=oldDoublyLinkedPlaceList.getHead(); 
				linkedPlace != 	null ; 
				linkedPlace=linkedPlace.getNext()){
			add(new DoublyLinkedPlace(linkedPlace))		;	
		}

	//	this.head = oldDoublyLinkedPlaceList.head.copy(oldDoublyLinkedPlaceList.head);
	//	this.tail = oldDoublyLinkedPlaceList.tail.copy(oldDoublyLinkedPlaceList.tail);
	//	this.head = oldDoublyLinkedPlaceList.head;
	//	this.tail = oldDoublyLinkedPlaceList.tail;
//		this.next = oldDoublyLinkedPlaceList.next;
	//	this.prev = oldDoublyLinkedPlaceList.prev;
		this.size = oldDoublyLinkedPlaceList.size;
		this.row = oldDoublyLinkedPlaceList.row;
		
	}
	
/*	public static DoublyLinkedPlaceList copy(DoublyLinkedPlaceList doublyLinkedPlaceList) {
        return new DoublyLinkedPlaceList(doublyLinkedPlaceList);
    }*/
	

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
