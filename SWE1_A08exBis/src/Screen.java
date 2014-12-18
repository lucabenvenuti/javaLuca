public class Screen {
	public final static int MAXROWS = 5;
	private ScreenRow head;
	private ScreenRow tail;
	private int size;
	
	public void add(ScreenRow node){
		node.setNext(null);
		node.setRow(node.getDoublyLinkedPlaceList().getRow());
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
	
	public Screen(ScreenRow one) {
		add(one);
	}
	public Screen(ScreenRow one	, ScreenRow two){
		this(one);
		add(two);
	}
	public Screen(ScreenRow one	, ScreenRow two	, ScreenRow three){
		this(one, two);
		add(three);
	}

	public Screen(ScreenRow one, ScreenRow two, ScreenRow three, ScreenRow four) {
		this(one, two, three);
		add(four);
		}
	
	public Screen(ScreenRow one, ScreenRow two, ScreenRow three, ScreenRow four, ScreenRow five) {
		this(one, two, three, four);
		add(five);
	}
	
	
	public boolean book(int row, int position, int seats){
		for(ScreenRow screenRow = head; screenRow != null && screenRow.getRow()<=(row);
				screenRow = screenRow.getNext()){
			if(screenRow.getRow()==row){
				
				return screenRow.book(position-1, seats);
			}
		}
		

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
