/**
 * ScreenRow.java
 *
 * A {@link ScreenRow} is a class which holds the head and tail of a
 * {@link DoublyLinkedPlaceList} list, and it does booking 
 * checks and actual booking at a row level
 * 
 * Software Development I, 2014WS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 * 
 * @version 2014-12-18
 */
public class ScreenRow {
	private Category category;
	public StringBuffer rowLayout;

	private DoublyLinkedPlaceList head;
	private DoublyLinkedPlaceList tail;
	private DoublyLinkedPlaceList doublyLinkedPlaceList; //must be initialized
	private ScreenRow next;
	private ScreenRow prev;
	private int size;
	private int row;

	/**
	 * @param node
	 *            a DoublyLinkedPlaceList node to append to the list
	 */
	public void add(DoublyLinkedPlaceList node){
		node.setNext(null);
		if (getHead() == null) { 
			if (getTail() != null){
				System.out.printf("%s%n","error");
			} 

			setHead(node);
			setTail(getHead());
			size = 1;
		} else{
			getTail().setNext(node);
			node.setPrev(getTail());
			setTail(node);
			size = size + 1;

		}
	}

	/**
	 * @return
	 */
	public DoublyLinkedPlaceList getDoublyLinkedPlaceList() {
		return doublyLinkedPlaceList;
	}

	/**
	 * @param category
	 * @param rowLayout
	 * @param rowNumber
	 * constructor with all the necessary inputs to completely define a ScreenRow
	 */
	public ScreenRow(Category category, String rowLayout, int rowNumber) { //(){//
		this.setCategory(category);
		this.setRowLayout(new StringBuffer(rowLayout));
		doublyLinkedPlaceList  =  new DoublyLinkedPlaceList(rowNumber);
		for (int i=0; i<rowLayout.length(); i++){
			Place newPlace = new Place(rowLayout.charAt(i));
			DoublyLinkedPlace newDoublyLinkedPlace = new DoublyLinkedPlace(newPlace, i);
			doublyLinkedPlaceList.add(newDoublyLinkedPlace);
		}
	}

	/**
	 * @return
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * @param seats
	 * @return
	 */
	public int calcPrice(int seats) {
		return category.getPrice() * seats;
	}

	/**
	 * @param position
	 * @return
	 * check if a seat is empty or not before booking
	 * should never be used - legacy method
	 */
	public boolean isEmptySeat(int position) {

		for ( DoublyLinkedPlace linkedPlace=doublyLinkedPlaceList.getHead(); linkedPlace !=
				null && linkedPlace.hasNext() && linkedPlace.getPosition()< position; 
				linkedPlace=linkedPlace.getNext()){
			if (linkedPlace.getPosition()==position){
				if(linkedPlace.getPlace().getAvailability()==Place.EMPTY_SEAT){
					return true;}
			}
		}
		return false; 
	}

	/**
	 * @param linkedPlace
	 * @return
	 * check if a seat is empty or not before booking - list method
	 */
	public boolean isEmptySeat(DoublyLinkedPlace linkedPlace) {
		return linkedPlace.getPlace().getAvailability()==Place.EMPTY_SEAT;
	}

	/**
	 * @param linkedPlace
	 */
	private void bookSeat(DoublyLinkedPlace linkedPlace) {
		linkedPlace.getPlace().setAvailability(Place.TAKEN_SEAT);
	}

	/**
	 * @param position
	 * @param seats
	 * @return
	 * books the seats
	 */
	public boolean book(int position, int seats) {
		if(position+seats>doublyLinkedPlaceList.getSize()){
			return false;
		}
		if (position> (int)(Math.round(doublyLinkedPlaceList.getSize())/2) ){
			return bookBackward(position, seats, doublyLinkedPlaceList); 			
		}
		else{
			return bookForward(position, seats, doublyLinkedPlaceList); 	
		}
	}

	/**
	 * @param position
	 * @param seats
	 * @param doublyLinkedPlaceList2
	 * @return
	 * left portion of the bisection algorithm to check if all the required places are free
	 */
	private boolean bookForward(int position, int seats,
			DoublyLinkedPlaceList doublyLinkedPlaceList2) {
		int i =0;
		DoublyLinkedPlace linkedPlaceStart=doublyLinkedPlaceList.getHead();

		for ( DoublyLinkedPlace linkedPlace=doublyLinkedPlaceList.getHead(); linkedPlace !=
				null && linkedPlace.hasNext()  && linkedPlace.getPosition()< position+seats; //
				linkedPlace=linkedPlace.getNext()){
			if (linkedPlace.getPosition()==position){linkedPlaceStart =linkedPlace;} 
			if (linkedPlace.getPosition()==position+i){
				if(!isEmptySeat(linkedPlace)){
					return false;
				}else{	i++;	}
			}
		}
		bookRightSeatForward(linkedPlaceStart, position, seats);
		return true;
	}

	/**
	 * @param linkedPlaceStart
	 * @param position
	 * @param seats
	 * left portion of the bisection algorithm to book all the required places
	 */
	private void bookRightSeatForward(DoublyLinkedPlace linkedPlaceStart,
			int position, int seats) {
		int i = 0;
		for ( DoublyLinkedPlace linkedPlace=linkedPlaceStart; linkedPlace !=
				null  && linkedPlace.getPosition()< position+seats; //&& linkedPlace.hasNext()
				linkedPlace=linkedPlace.getNext()){
			if (linkedPlace.getPosition()==position+i){
				bookSeat(linkedPlace);i++;
				rowLayout.replace(linkedPlace.getPosition(), linkedPlace.getPosition()+1, 
						String.valueOf(linkedPlace.getPlace().getAvailability()));
			}
		}
	}

	/**
	 * @param position
	 * @param seats
	 * @param doublyLinkedPlaceList2
	 * @return
	 * right portion of the bisection algorithm to check if all the required places are free
	 */
	private boolean bookBackward(int position, int seats,
			DoublyLinkedPlaceList doublyLinkedPlaceList2) {
		DoublyLinkedPlace linkedPlaceEnd =doublyLinkedPlaceList.getTail();
		int i = seats;
		position--;
		for ( DoublyLinkedPlace linkedPlace=doublyLinkedPlaceList.getTail();linkedPlace !=
				null&& linkedPlace.hasPrev()  && linkedPlace.getPosition()>position; 
				linkedPlace=linkedPlace.getPrev()){
			if (linkedPlace.getPosition()==position+seats){linkedPlaceEnd =linkedPlace;} 
			if (linkedPlace.getPosition()==position+i){
				if(!isEmptySeat(linkedPlace)){
					return false;
				}else{	i--;	}
			}
		}
		bookRightSeatBackward(linkedPlaceEnd, position, seats);
		return true;
	}

	/**
	 * @param linkedPlaceEnd
	 * @param position
	 * @param seats
	 * right portion of the bisection algorithm to book all the required places
	 */
	private void bookRightSeatBackward(DoublyLinkedPlace linkedPlaceEnd,
			int position, int seats) {
		int i = seats;
		for ( DoublyLinkedPlace linkedPlace=linkedPlaceEnd; linkedPlace !=
				null && linkedPlace.hasPrev() && linkedPlace.getPosition()>position; //
				linkedPlace=linkedPlace.getPrev()){
			if (linkedPlace.getPosition()==position+i){
				bookSeat(linkedPlace);i--;
				rowLayout.replace(linkedPlace.getPosition(), linkedPlace.getPosition()+1, 
						String.valueOf(linkedPlace.getPlace().getAvailability()));
			}
		}		
	}

	/**
	 * @return
	 */
	public StringBuffer getRowLayout() {
		return rowLayout;
	}

	/**
	 * @param rowLayout
	 */
	public void setRowLayout(StringBuffer rowLayout) {
		this.rowLayout = rowLayout;
	}

	/**
	 * @return
	 */
	public ScreenRow getNext() {
		return next;
	}

	/**
	 * @param next
	 */
	public void setNext(ScreenRow next) {
		this.next = next;
	}

	/**
	 * @return
	 */
	public DoublyLinkedPlaceList getHead() {
		return head;
	}

	/**
	 * @param head
	 */
	public void setHead(DoublyLinkedPlaceList head) {
		this.head = head;
	}

	/**
	 * @return
	 */
	public DoublyLinkedPlaceList getTail() {
		return tail;
	}

	/**
	 * @param tail
	 */
	public void setTail(DoublyLinkedPlaceList tail) {
		this.tail = tail;
	}

	/**
	 * @return
	 */
	public ScreenRow getPrev() {
		return prev;
	}

	/**
	 * @param prev
	 */
	public void setPrev(ScreenRow prev) {
		this.prev = prev;
	}

	/**
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row
	 */
	public void setRow(int row) {
		this.row = row;
	}

}