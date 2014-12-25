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
	//private Screen screen;


	private Movie movie;
	private String screeningTime;

	private int size;
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	/**
	 * @param node
	 *            a ScreenRow node to append to the list
	 */
	public void add(ScreenRow node){
		node.setNext(null);
		node.setRow(node.getDoublyLinkedPlaceList().getRow());
	//	System.out.println("trota1");
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

	/*public Screen (ScreenRow head, ScreenRow tail, int size){
		setHead(head);
		setTail(tail);
		setSize(size);
		
	}
	
	  public Screen newInstance(Screen aGalaxy) {
		    return new Screen(aGalaxy.getHead(), aGalaxy.getTail(), aGalaxy.getSize());
		  }*/
	
	public Screen(Screen screen, Movie movie, String screeningTime){
	//clone constructor
			this.head=new ScreenRow(screen.head); 
			this.tail=new ScreenRow(screen.tail); 
			this.size=screen.size;
		
		//	} 
		//Screen a = newInstance(screen);
		//setHead(a.getHead()); 
		//setTail(a.getTail()); 
		//setSize(a.getSize());
		
	/*	public Employee(Employee oldEmployee) {
	        this.id = oldEmployee.id;
	        this.name = oldEmployee.name;
	        this.department = new Department(oldEmployee.department);    //deep cloning
	    }*/
		
	//	this.screen = new Screen(scr)
		
		setMovie(movie);
		setScreeningTime(screeningTime);	
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

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getScreeningTime() {
		return screeningTime;
	}

	public void setScreeningTime(String screeningTime) {
		this.screeningTime = screeningTime;
	}
	
/*	Screen copyScreen (Screen screen){
		  Screen f = new Screen(screen.getHead());
		  //for all properties in FOo
		  f.setMovie(screen.getMovie());
		  f.setTail(getTail());
		  f.setScreeningTime(getScreeningTime());
		  return f;
		}*/
	
/*	private Screen dummy;

	  public Screen(Screen another) {
	    this.dummy = another.dummy; // you can access  
	  }*/
	
}
