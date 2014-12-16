
public class SinglyLinkedLinearListSeatRows {

	private DoublyLinkedPlaceList doublyLinkedPlaceList;
	
	private DoublyLinkedPlaceList next=null;
	private DoublyLinkedPlaceList head=null;
	private DoublyLinkedPlaceList tail=null;
	
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
		//singleLinkedList, I add at the end
		doublyLinkedPlaceList.setNext(null);
		 if (getHead() == null) { 
			// System.out.println("trota1");
			 if (getTail() != null){
				 System.out.println("trotaculo");
			 } 
			 
			 setHead(doublyLinkedPlaceList);
			 setTail(getHead());
		 } else{
			// System.out.println("trota2");
			 getTail().setNext(doublyLinkedPlaceList); ///setNext(doublyLinkedPlaceList);
		//	 setPrev(getTail());
			// this.setNext(null);
			 setTail(doublyLinkedPlaceList);
			 
		 }
		// System.out.println("trota5");
	}

	
	
	
}
