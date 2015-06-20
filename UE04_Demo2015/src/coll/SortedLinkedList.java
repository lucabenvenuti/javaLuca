package coll;

//public class SortedLinkedList<E extends Comparable<E>> 
	//This first version does not work with SortedList<Student> 
	//because Comparable<Student> not a subtype of Comparable<Person>

public class SortedLinkedList<E extends Comparable<? super E>> 
	extends LinkedList<E> 
	implements SortedList<E> 
{

	@Override
	public boolean add(E elem) {
		Node<E> prev = null; 
		Node<E> curr = head; 
		while (curr != null && curr.value.compareTo(elem) < 0) {
			prev = curr; 
			curr = curr.next; 
		}
		if (curr != null && curr.value.compareTo(elem) == 0) {
			return false; // elem already contained; do not insert a second time
		} else {
			Node<E> node = new Node<E>(elem, curr); 
			if (prev == null) { 
				head = node;
			} else {
				prev.next = node;
			}
			n++; 
			return true;
		}
	}

	@Override
	public boolean contains(Object obj) {
		// if (obj instanceof E) // does not work, because E erased at run time
		try {
			E elem = (E) obj; 
			for (E e: this) {
				if (e.equals(elem)) {
					return true; 
				}
				if (elem.compareTo(e) < 0) {
					return false; 
				}
			}
		}
		catch (ClassCastException e) {
		}
		return false; 
	}

	@Override
	public boolean containsAll(Iterable<?> elems) {
		for (Object e: elems) {
			if (! contains(e)) 
				return false; 
		}
		return true; 
	}


}
