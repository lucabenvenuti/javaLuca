package part3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This version shows the use of generic methods
 * 
 * @param <E>
 *            the element type
 */
public class LinkedList<E> implements List<E> {

	@Override
	public int size() {
		return n;
	}

	@Override
	public boolean contains(Object obj) {
		for (E elem : this) {
			if (elem.equals(obj))
				return true;
		}
		return false;
	}

	public boolean add(E elem) {
		head = new Node<E>(elem, head);
		n++;
		return true;
	}

	@Override
	public Iterator<E> iterator() {
		return new IteratorImpl();
	}

	// private and protected --------------------------------------------------

	protected Node<E> head = null;

	protected int n = 0;

	// inner class Node -------------------------------------------------------

	protected static class Node<F> {
		final F value;
		Node<F> next;

		Node(F elem, Node<F> next) {
			this.value = elem;
			this.next = next;
		}
	}

	// inner class IteratorImpl -----------------------------------------------

	private class IteratorImpl implements Iterator<E> {

		private Node<E> current;

		IteratorImpl() {
			current = head;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			if (current != null) {
				E value = current.value;
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
