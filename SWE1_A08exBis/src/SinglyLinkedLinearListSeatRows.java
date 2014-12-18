
public class SinglyLinkedLinearListSeatRows {

	private DoublyLinkedPlaceList doublyLinkedPlaceList;
	
	private DoublyLinkedPlaceList next=null;
	private DoublyLinkedPlaceList head=null;
	private DoublyLinkedPlaceList tail=null;
	private int size;
	
	
	public DoublyLinkedPlaceList getNext() {
		return next;
	}

	public DoublyLinkedPlaceList getDoublyLinkedPlaceList() {
		return doublyLinkedPlaceList;
	}



	public void setDoublyLinkedPlaceList(DoublyLinkedPlaceList doublyLinkedPlaceList) {
		this.doublyLinkedPlaceList = doublyLinkedPlaceList;
	}


	public void setNext(DoublyLinkedPlaceList next) {
		this.next = next;
	}



	public DoublyLinkedPlaceList getHead() {
		return head;
	}



	public void setHead(DoublyLinkedPlaceList head) {
		this.head = head;
	}



	public DoublyLinkedPlaceList getTail() {
		return tail;
	}



	public void setTail(DoublyLinkedPlaceList tail) {
		this.tail = tail;
	}
	
	public void add(DoublyLinkedPlaceList doublyLinkedPlaceList){
		doublyLinkedPlaceList.setNext(null);
		 if (getHead() == null) { 
			 if (getTail() != null){
				 System.out.printf("%s%n","error");
			 } 
			 
			 setHead(doublyLinkedPlaceList);
			 setTail(getHead());
			 size = 1;
		 } else{
			 doublyLinkedPlaceList.setPrev(getTail());
			 getTail().setNext(doublyLinkedPlaceList);
			 setTail(doublyLinkedPlaceList);
			 size = size + 1;
			 
		 }
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
