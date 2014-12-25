/**
 * Place.java
 *
 * A {@link Place} is a class which holds the availability of a Place
 * of a ScreenRow
 * 
 * Software Development I, 2014WS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 * 
 * @version 2014-12-18
 */
public class Place {

	/**
	 * fixed place conditions, K is for future expansion
	 */
	public static final char EMPTY_SEAT = '#';
	public static final char TAKEN_SEAT = 'X';
	public static final char OBSTACLE = 'K';

	private char availability;

	public Place(Place oldPlace) {
		this.availability = oldPlace.availability;		
	}
	/**
	 * @param taken
	 */
	public Place(int taken){
		setAvailability(taken);
	}

	/**
	 * @param taken
	 */
	public Place(char taken){
		setAvailability(taken);
	}

	/**
	 * @return
	 */
	public char getAvailability() {
		return availability;
	}


	/**
	 * @param taken
	 */
	public void setAvailability(int taken) {
		switch (taken){
		case 0: availability = TAKEN_SEAT;break;
		case 1: availability = EMPTY_SEAT;break;
		default:  availability = OBSTACLE;
		}

	}

	/**
	 * @param taken
	 */
	public void setAvailability(char taken) {
		switch (taken){
		case TAKEN_SEAT: availability = TAKEN_SEAT;break;
		case EMPTY_SEAT: availability = EMPTY_SEAT;break;
		default:  availability = OBSTACLE;
		}
	}
}
