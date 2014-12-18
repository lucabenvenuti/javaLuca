
public class Place {

	/**
	 * fixed place conditions, K is for future expansion
	 */
	public static final char EMPTY_SEAT = '#';
	public static final char TAKEN_SEAT = 'X';
	public static final char OBSTACLE = 'K';

	private char availability;


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
