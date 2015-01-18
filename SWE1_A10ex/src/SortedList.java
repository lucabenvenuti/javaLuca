/* SortedList.java
 * Software Development 1.12 Stack, List and Queue
 * Institute for Pervasive Computing, JKU Linz, Austria
 * http://www.pervasive.jku.at
 * author: 2007-10-1 Michael Matscheko
 * last change: 2012-12-06 Michael Matscheko */

public class SortedList extends List {

	public SortedList() {
		super();
	}

	public void insert(Object x) { // add value in sorted list
		Node p = head; // go to list start (empty head-node)
		// skip all elements that are smaller than x
		while (p.next != null && ((Comparable)p.next.element).compareTo(x) < 0)
			p = p.next;
		// now insert x between p and p.next
		p.next = new Node(x, p.next);
	}
	
	// search for Node by value.
	// search is protected: it would be strange to return
	// protected Node objects to an external class
	protected Node search(Object x) {
		Node p = head.next; // go to first Node following the head-node
		// search for a matching or greater node (or list end)
		while (p != null && ((Comparable)p.element).compareTo(x) < 0)
			p = p.next;
		// if p is null or not a match, x is not in list
		if (p == null || ((Comparable)p.element).compareTo(x) != 0) return null;
		else return p;
	}



	public static void main(String[] args) {
		// create test list
		SortedList l = new SortedList();
		l.insert(new Integer(5));
		l.insert(new Integer(2));
		l.insert(new Integer(6));
		l.insert(new Integer(5));
		l.insert(new Integer(3));
		
		l.reset();           // go to list start
		while(!l.endpos()) { // display list content
			System.out.println(l.elem());
			l.advance();
		}
		
		// search for nodes
		if (l.search(new Integer(3)) != null) System.out.println("Node >3< found");
		if (l.search(new Integer(4)) != null) System.out.println("Node >4< found");
	}

}
