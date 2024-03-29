/**
 * Screen.java
 *
 * A {@link Screen} is a class which holds the head and tail of a
 * {@link ScreenRow} list, and it does booking at a screen level
 * 
 * Software Development I, 2014WS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 * 
 * @version 2014-12-18
 */
public class Screen {
	/**
	 * for now a screen can have a maximum of 5 rows
	 */
	public final static int MAXROWS = 5;
	private ScreenRow head;
	private ScreenRow tail;
	private int size;
	public int rowCounter = 0;

	/**
	 * @param node
	 *            a ScreenRow node to append to the list
	 */
	public void add(ScreenRow node){
		node.setNext(null);
		if (getHead() == null) { 
			if (getTail() != null){
				System.out.printf("%s%n","error");
			} 

			setHead(node);
			setTail(getHead());
			size = 1;
			rowCounter = 1;
			node.setRow(1);
		} else{
			getTail().setNext(node);
			setTail(node);
			size = size + 1;
			rowCounter++;
			node.setRow(rowCounter);
		}
	}

	/**
	 * @param one
	 */
	public Screen(ScreenRow one) {
		add(one);
	}
	/**
	 * @param one
	 * @param two
	 */
	public Screen(ScreenRow one	, ScreenRow two){
		this(one);
		add(two);
	}
	/**
	 * @param one
	 * @param two
	 * @param three
	 */
	public Screen(ScreenRow one	, ScreenRow two	, ScreenRow three){
		this(one, two);
		add(three);
	}

	/**
	 * @param one
	 * @param two
	 * @param three
	 * @param four
	 */
	public Screen(ScreenRow one, ScreenRow two, ScreenRow three, ScreenRow four) {
		this(one, two, three);
		add(four);
	}

	/**
	 * @param one
	 * @param two
	 * @param three
	 * @param four
	 * @param five
	 */
	public Screen(ScreenRow one, ScreenRow two, ScreenRow three, ScreenRow four, ScreenRow five) {
		this(one, two, three, four);
		add(five);
	}


	/**
	 * @param row
	 * @param position
	 * @param seats
	 * @return
	 * here the seats are booked
	 */
	public boolean book(int row, int position, int seats){
		for(ScreenRow screenRow = head; screenRow != null && screenRow.getRow()<=(row);
				screenRow = screenRow.getNext()){
			if(screenRow.getRow()==row){
				return screenRow.book(position-1, seats);
			}
		}


		return false;
	}
	/**
	 * @return
	 */
	public ScreenRow getHead() {
		return head;
	}
	/**
	 * @param head
	 */
	public void setHead(ScreenRow head) {
		this.head = head;
	}
	/**
	 * @return
	 */
	public ScreenRow getTail() {
		return tail;
	}
	/**
	 * @param tail
	 */
	public void setTail(ScreenRow tail) {
		this.tail = tail;
	}
}
