/* DoubleLinkedList.java
 * Software Development 1.12 Stack, List and Queue
 * Institute for Pervasive Computing, JKU Linz, Austria
 * http://www.pervasive.jku.at
 * author: 2007-10-1 Michael Matscheko
 * last change: 2012-12-06 Michael Matscheko */

public class DoubleLinkedList {

	// node class: contains value and link to previous and next node
	public class Node {
		Object element;
		Node prev, next;

		public Node(Node prev, Object element, Node next) { 
			this.prev = prev;
			this.element = element;
			this.next = next;
		}
	}
	
	// first and last node of list
	Node head, tail;

	public DoubleLinkedList() {
		head = null;
		tail = null;
	}

	// insert Object x at list start
	public void insert(Object x) {
		head = new Node(null, x, head); // create new node at list start
		if (tail == null) tail = head;  // if the list was empty, set tail
		else head.next.prev = head;     // otherwise, connect previous head node
		  
	}

	// insert Object x after Node p
	public void insert(Object x, Node p) {
		Node tmp = new Node(p, x, p.next); // create new node after p
		p.next = tmp;                      // connect p to new node
		if (tmp.next == null) tail = tmp;  // if this is the last node, set tail
		else tmp.next.prev = tmp;          // otherwise, connect next node
	}
	
	// remove Node p
	public void delete(Node p) {
		if (p == head) head = p.next; // if this is the first node, set head
		else p.prev.next = p.next;    // otherwise, connect previous node to next
		if (p == tail) tail = p.prev; // if this is the last node, set tail
		else p.next.prev = p.prev;    // otherwise, connect next node to previous
	}

	
	public static void main(String[] args) {
		// todo: add some test operations
	}

}
