
public class SinglyLinkedLinearListSeatRows {

	private DoublyLinkedPlaceList doublyLinkedPlaceList;
	
	public DoublyLinkedPlaceList next=null;
	public DoublyLinkedPlaceList head=null;
	public DoublyLinkedPlaceList tail=null;
	public DoublyLinkedPlaceList getNext() {
		return next;
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
		
		 if (getHead() == null) { 
			// System.out.println("trota1");
			 if (getTail() != null){
				 System.out.println("trotaculo");
			 } 
			 setHead(doublyLinkedPlaceList);
			 setTail(getHead());
		 } else{
			// System.out.println("trota2");
			 getTail().setNext(doublyLinkedPlaceList);
			 doublyLinkedPlaceList.setPrev(getTail());
			 doublyLinkedPlaceList.setNext(null);
			 setTail(doublyLinkedPlaceList);
			 
		 }
	}
	
	
}
