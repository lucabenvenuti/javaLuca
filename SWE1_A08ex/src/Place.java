
public class Place {
	
	public static final char EMPTY_SEAT = '#';
	public static final char TAKEN_SEAT = 'X';
	public static final char OBSTACLE = ' ';
	
	private char availability;

	
	public Place(int taken){
		setAvailability(taken);
	}


	public char getAvailability() {
		return availability;
	}


	public void setAvailability(int taken) {
		switch (taken){
		case 0: availability = TAKEN_SEAT;break;
		case 1: availability = EMPTY_SEAT;break;
		default:  availability = OBSTACLE;
		}
		System.out.println(availability);
		
	}
	

}
