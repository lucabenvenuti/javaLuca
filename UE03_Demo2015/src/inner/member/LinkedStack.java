package inner.member;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack implements Iterable<Object> {

	private static class Node {

		Object value;
		Node next;

		Node(final Object value, final Node next) {
			this.value = value;
			this.next = next;
		}

	}

	Node head;

	public void push(final Object val) {
		head = new Node(val, head);
	}

	public void pop() throws NoSuchElementException {
		if (isEmpty())
			throw new NoSuchElementException();
		head = head.next;
	}

	public Object top() throws NoSuchElementException {
		if (isEmpty())
			throw new NoSuchElementException();
		return head.value;
	}

	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public Iterator<Object> iterator() {

		return new LinkedStackIterator();
	}

	public class LinkedStackIterator implements Iterator<Object> {

		Node current;

		LinkedStackIterator() {
			current = head;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Object next() {
			if (current == null)
				throw new NoSuchElementException();
			final Object val = current.value;
			current = current.next;
			return val;
		}

//		@Override
//		public void remove() {
//			throw new UnsupportedOperationException();
//		}

	}

}
