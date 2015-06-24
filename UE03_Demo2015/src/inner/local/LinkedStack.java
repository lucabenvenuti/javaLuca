package inner.local;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack implements Iterable<Object> {

	private static class Node {

		Object value;
		Node next;

		Node(Object value, Node next) {
			this.value = value;
			this.next = next;
		}

	}

	Node head;

	public void push(Object val) {
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

		class LinkedStackIterator implements Iterator<Object> {

			Node current;

			LinkedStackIterator() {
				current = head;
			}

			@Override
			public boolean hasNext() {
				return current != head;
			}

			@Override
			public Object next() throws NoSuchElementException {
				if (current == null)
					throw new NoSuchElementException();
				Object val = current.value;
				current = current.next;
				return val;
			}

		}
		return new LinkedStackIterator();
	}

}
