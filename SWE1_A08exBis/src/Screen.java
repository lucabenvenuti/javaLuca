public class Screen {
	public final static int MAXROWS = 5;
//	public SinglyLinkedLinearListSeatRows singlyLinkedLinearListSeatRows;
//	private ScreenRow screenRow;
	private ScreenRow head;
	private ScreenRow tail;
	private int size;
	
	public void add(ScreenRow node){
		node.setNext(null);
		 if (getHead() == null) { 
			 if (getTail() != null){
				 System.out.printf("%s%n","error");
			 } 
			 
			 setHead(node);
			 setTail(getHead());
			 size = 1;
		 } else{
			// doublyLinkedPlaceList.setPrev(getTail());
			 getTail().setNext(node);
			 node.setPrev(getTail());
			 setTail(node);
			 size = size + 1;
			 
		 }
	}
	
	public Screen(ScreenRow one) {
	/*	singlyLinkedLinearListSeatRows = new SinglyLinkedLinearListSeatRows();
		singlyLinkedLinearListSeatRows.add(one.getDoublyLinkedPlaceList());
		singlyLinkedLinearListSeatRows.getTail().setScreenRow(one);*/
	//	ScreenRow screenRow  =  new ScreenRow();//(one.getCategory(), one.getRowLayout().toString(), one.getRow());
		//screenRow.add(one.getDoublyLinkedPlaceList());
	//	doublyLinkedPlaceList.add(newDoublyLinkedPlace);
	//	head = one;
	//	tail = one;
		add(one);
		
	}
	public Screen(ScreenRow one	, ScreenRow two){
		this(one);
	//	singlyLinkedLinearListSeatRows.add(two.getDoublyLinkedPlaceList());
	//	singlyLinkedLinearListSeatRows.getTail().setScreenRow(two);
		//one.setNext(two);
		//two.setPrev(one);
		add(two);
	}
	public Screen(ScreenRow one	, ScreenRow two	, ScreenRow three){
		this(one, two);
	//	singlyLinkedLinearListSeatRows.add(three.getDoublyLinkedPlaceList());
	//	singlyLinkedLinearListSeatRows.getTail().setScreenRow(three);
		add(three);
	}

	public Screen(ScreenRow one, ScreenRow two, ScreenRow three, ScreenRow four) {
		this(one, two, three);
		//		singlyLinkedLinearListSeatRows.add(four.getDoublyLinkedPlaceList());
		//		singlyLinkedLinearListSeatRows.getTail().setScreenRow(four);
		add(four);
		}
	
	public Screen(ScreenRow one, ScreenRow two, ScreenRow three, ScreenRow four, ScreenRow five) {
		this(one, two, three, four);
	//	singlyLinkedLinearListSeatRows.add(five.getDoublyLinkedPlaceList());
	//	singlyLinkedLinearListSeatRows.getTail().setScreenRow(five);
		add(five);
	}
	
	
	public boolean book(int row, int position, int seats){
		for(ScreenRow screenRow = head; screenRow != null && screenRow.getRow()<=(row);
				screenRow = screenRow.getNext()){
			if(screenRow.getRow()==row){
				return screenRow.book(position-1, seats);
			}
		}
		
		/*for ( DoublyLinkedPlaceList linkedPlaceList = head.getHead(); 
				linkedPlaceList != null && linkedPlaceList.getRow()<=(row); 
				linkedPlaceList = linkedPlaceList.getNext()){
			if (linkedPlaceList.getRow()==row){//-1){
				return linkedPlaceList.getScreenRow().book(position-1, seats);
			}
		}*/
		return false;
	}
	public ScreenRow getHead() {
		return head;
	}
	public void setHead(ScreenRow head) {
		this.head = head;
	}
	public ScreenRow getTail() {
		return tail;
	}
	public void setTail(ScreenRow tail) {
		this.tail = tail;
	}
}
