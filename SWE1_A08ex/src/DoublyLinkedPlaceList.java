/**
 * DoublyLinkedPlaceList.java
 *
 * A {@link DoublyLinkedPlaceList} is a class which holds the head and tail of a
 * {@link DoublyLinkedPlace} list.
 * 
 * Software Development I, 2014WS
 * Institute for Pervasive Computing, JKU Linz
 * 
 * @author Michael Haslgrübler
 * @author Welma Pereira
 * @author Andreas Riener
 * 
 * @version 2014-12-09
 */

public class DoublyLinkedPlaceList {
	private DoublyLinkedPlace head;
	private DoublyLinkedPlace tail;
	private int size;

	public DoublyLinkedPlace getHead() {
		return head;
	}

	public void setHead(DoublyLinkedPlace head) {
		this.head = head;
	}

	public DoublyLinkedPlace getTail() {
		return tail;
	}

	public void setTail(DoublyLinkedPlace tail) {
		this.tail = tail;
	}

	/**
	 * 
	 * @return the size of the list
	 */
	public int length() {
		return getSize();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * 
	 * @param node
	 *            a node to append to the list
	 */
	public void add(DoublyLinkedPlace node) {
		
		 if (getHead() == null) { 
			// System.out.println("trota1");
			 if (getTail() != null){
				 System.out.println("trotaculo");
			 } 
			 setHead(node);
			 setTail(getHead());
		 } else{
			// System.out.println("trota2");
			 getTail().setNext(node);
			 node.setPrev(getTail());
			 node.setNext(null);
			 setTail(node);
			 
		 }
		
		// TODO implement me
	/*	//DoublyLinkedPlace q = new DoublyLinkedPlace()???);
	//	System.out.println(getTail());
		DoublyLinkedPlace p = getHead();
		System.out.println(node.getPosition());
		if (node.getPosition()+1>getSize()){
			setSize(node.getPosition()+1);
		}
		
		while (p != null && p.getPosition() < node.getPosition()) {
			p = p.getNext();
			
		//	System.out.println(p);//.getPlace().getAvailability());
		}
		
		if (p == getHead()) {
		//	System.out.println("trota");
			//head = node;
			setHead(node);
			node.setNext(p);
			if (p != null){
			p.setPrev(node);}
		} else if (p == getTail()){
		//	System.out.println("trota3");
		//	System.out.println(node.getPosition());
		//	if (p != null){
				setTail(node);
				for (int i =0; i<getSize(); i++){
					if (p == null){
						getHead().setNext(node);
						break;
					} else {
						
					}
					
				}
				
				
				
		//		System.out.println(getSize());
			//	p.getPrev().setNext(node);
		//		System.out.println(node);
			//	node.setPrev(p.getPrev());
		//	}
		} 	else{
		//	System.out.println("trota2");
			if (p != null){
		node.setNext(p.getPrev().getNext());
		node.setPrev(p.getPrev());
		p.getPrev().setNext(node);
		p.setPrev(node);}
		
		}
		//getTail()
	//	p.setPrev(node);*/
		
	}
	
	public void print() {
		DoublyLinkedPlace p = head;
		while (p != null) {
			System.out.println(p.getPlace().getAvailability());
		}
		System.out.println("end of list.");
	}
}
