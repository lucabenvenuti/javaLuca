package part0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This version shows the use of generic methods
 * 
 * @param <E>
 *            the element type
 */
public class LinkedList implements List {

	@Override
	public int size() {
		return n;
	}

	@Override
	public boolean contains(Object obj) {
		for (Object elem : this) {
			if (elem.equals(obj))
				return true;
		}
		return false;
	}

	public boolean add(Object elem) {
		head = new Node(elem, head);
		n++;
		return true;
	}

	@Override
	public Iterator iterator() {
		return new IteratorImpl();
	}

	// private and protected --------------------------------------------------

	protected Node head = null;

	protected int n = 0;

	// inner class Node -------------------------------------------------------

	protected static class Node {
		final Object value;
		Node next;

		Node(Object elem, Node next) {
			this.value = elem;
			this.next = next;
		}
	}

	// inner class IteratorImpl -----------------------------------------------

	private class IteratorImpl implements Iterator {

		private Node current;

		IteratorImpl() {
			current = head;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Object next() {
			if (current != null) {
				Object value = current.value;
				current = current.next;
				return value;
			} else {
				throw new NoSuchElementException("No more element in list");
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException(
					"removal of elements not supported");
		}

	}

}
