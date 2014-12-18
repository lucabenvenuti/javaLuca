/**
 * DoublyLinkedPlace.java
 *
 * A {@link DoublyLinkedPlace} is a class which holds the next and previous
 * place/seat within a list. It also stores the position within the list and the
 * seat itself.
 * 
 * Software Development I, 2014WS Institute for Pervasive Computing, JKU Linz
 * 
 * @author Michael Haslgrübler
 * @version 2014-12-09
 */


public class DoublyLinkedPlace {
	private DoublyLinkedPlace next;
	private DoublyLinkedPlace prev;
	private Place place;
	private int position;

	public DoublyLinkedPlace(Place place, int position) {
		super();
		this.place = place;
		this.position = position;
	}

	public DoublyLinkedPlace(DoublyLinkedPlace prev, Place place, int position) {
		this(place, position);
		this.prev = prev;
	}

	public DoublyLinkedPlace getNext() {
		return next;
	}

	public boolean hasNext() {
		return next != null;
	}

	public void setNext(DoublyLinkedPlace next) {
		this.next = next;
	}

	public DoublyLinkedPlace getPrev() {
		return prev;
	}

	public boolean hasPrev() {
		return prev != null;
	}

	public void setPrev(DoublyLinkedPlace prev) {
		this.prev = prev;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Place getPlace() {
		return place;
	}
}
