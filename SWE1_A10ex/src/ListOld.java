/* List.java
 * Software Development 1.12 Stack, List and Queue
 * Institute for Pervasive Computing, JKU Linz, Austria
 * http://www.pervasive.jku.at
 * author: 2007-10-1 Michael Matscheko
 * last change: 2012-12-06 Michael Matscheko */

//import at.jku.pervasive.swe1.vo7.Student;

public class ListOld {

	protected class Node { // internal node class
		Object element;    // content of this list entry
		Node next;         // next list entry
		
		public Node(Object element, Node next) {
			this.element = element;
			this.next = next;
		}
	}

	protected Node head; // list head

	protected Node pos;  // current list entry

	public ListOld() {      // create empty list
		// the list ALWAYS contains an empty head-node
		head = pos = new Node(null, null);
	}

	public boolean empty() { // true if list empty
		return head.next == null;
	}

	public boolean endpos() { // true if at end of list
		return pos.next == null;
	}

	public void reset() {  // go to list start
		pos = head;
	}

	public void advance() { // go to next list entry
		if (endpos()) System.err.println("advance: at list end");
		else pos = pos.next;
	}

	public Object elem() { // get current list entry value
		if (endpos()) {
			System.err.println("elem: at list end");
			return null;
		} else return pos.next.element;
	}

	public void insert(Object x) { // add value as new current entry
		pos.next = new Node(x, pos.next);
	}

	public void delete() { // remove current element
		if (endpos()) System.err.println("delete: at list end");
		else pos.next = pos.next.next;
	}

	
	public static void main(String[] args) {
		// create test list
		ListOld l = new ListOld();
		l.insert(new Student("Julia","Maus",29,2,1980,"Informatik"));
		l.advance();
		l.insert(new Student("Anton","Sommer",17,7,1980,"Mechatronik"));
		l.advance();
		l.insert(new Student("Peter","Kalb",7,11,1973,"WIN"));
		
		l.reset();           // go to list start
		while(!l.endpos()) { // display list content
			Student s = (Student)l.elem();
			System.out.println(s.firstName+" "+s.lastName);
			l.advance();
		}
		
		l.reset();
		while (!l.empty()) l.delete(); // clear list
	}

}
