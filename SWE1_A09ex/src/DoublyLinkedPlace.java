/**
 * DoublyLinkedPlace.java
 *
 * A {@link DoublyLinkedPlace} is a class which holds the next and previous
 * place/seat within a list. It also stores the position within the list and the
 * seat itself.
 * 
 * Software Development I, 2014WS 
 * JKU Linz
 * 
 * @author Michael Haslgrubler
 * @author Luca Benvenuti
 * @version 2014-12-26
 */


public class DoublyLinkedPlace {
	private DoublyLinkedPlace next;
	private DoublyLinkedPlace prev;
	private Place place;
	private int position;

	/**
	 * @param oldDoublyLinkedPlace
	 * deep copy constructor
	 */
	public DoublyLinkedPlace(DoublyLinkedPlace oldDoublyLinkedPlace) {
		if (oldDoublyLinkedPlace.next != null){
			this.next = new DoublyLinkedPlace(oldDoublyLinkedPlace.next.getPlace(),
					oldDoublyLinkedPlace.next.getPosition()) ;}
		if (oldDoublyLinkedPlace.prev != null){
			this.prev = new DoublyLinkedPlace(oldDoublyLinkedPlace.prev.getPlace(),
					oldDoublyLinkedPlace.prev.getPosition()) ;}
		this.place = new Place(oldDoublyLinkedPlace.place);
		this.position = oldDoublyLinkedPlace.position; 

	}

	/**
	 * @param place
	 * @param position
	 */
	public DoublyLinkedPlace(Place place, int position) {
		super();
		this.place = place;
		this.position = position;
	}

	/**
	 * @param prev
	 * @param place
	 * @param position
	 */
	public DoublyLinkedPlace(DoublyLinkedPlace prev, Place place, int position) {
		this(place, position);
		this.prev = prev;
	}

	/**
	 * @return
	 */
	public DoublyLinkedPlace getNext() {
		return next;
	}

	/**
	 * @return
	 */
	public boolean hasNext() {
		return next != null;
	}

	/**
	 * @param next
	 */
	public void setNext(DoublyLinkedPlace next) {
		this.next = next;
	}

	/**
	 * @return
	 */
	public DoublyLinkedPlace getPrev() {
		return prev;
	}

	/**
	 * @return
	 */
	public boolean hasPrev() {
		return prev != null;
	}

	/**
	 * @param prev
	 */
	public void setPrev(DoublyLinkedPlace prev) {
		this.prev = prev;
	}

	/**
	 * @return
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @param position
	 */
	public void setPosition(int position) {
		this.position = position;
	}

	/**
	 * @return
	 */
	public Place getPlace() {
		return place;
	}
}
