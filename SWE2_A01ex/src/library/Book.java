package library;

import java.util.Calendar;

/**
 * @author luca
 * Book class to store book and eventually lending information
 */
public final class Book {

	private final int id;
	
	private final String title;
	
	private final String location;
	
	private boolean lended;
	
	private Person lender;
	
	private Calendar cal;
	
	/**
	 * days when the library will be closed forever, first loan duration and extended loan duration
	 */
	protected final static int LIBRARY_TERMINATION = 10000;
	public final static int DAYS_FIRST_LOAN = 14; //test -14
	public final static int DAYS_EXTENDED_LOAN = 7;


	/**
	 * @param id
	 * @param title
	 * @param location
	 */
	Book(int id, String title, String location) {
		this.id = id;
		this.title = title;
		this.location = location;
		this.setLended(false);
		this.setLender(null);
		this.cal = Calendar.getInstance();
		this.cal.add(Calendar.DATE,LIBRARY_TERMINATION);
	}

	/**
	 * @return the id
	 */
	int getId() {
		return id;
	}

	/**
	 * @return the title
	 */
	String getTitle() {
		return title;
	}

	/**
	 * @return the location
	 */
	String getLocation() {
		return location;
	}

	/**
	 * @return true if a book is lended, false otherwise
	 */
	boolean isLended() {
		return lended;
	}

	/**
	 * @param lended
	 * @return true if the status has been changed correctly
	 */
	boolean setLended(boolean lended) {
		this.lended = lended;
		return true;
	}

	/**
	 * @return lender as Person object
	 */
	Person getLender() {
		return lender;
	}

	/**
	 * @param lender
	 * @return true if the information has been changed correctly
	 */
	boolean setLender(Person lender) {
		this.lender = lender;
		return true;
	}

	/**
	 * @return cal object
	 */
	Calendar getCal() {
		return cal;
	}

	/**
	 * @param days, set up the expiration date of the lending in days from today
	 */
	void setCal(int days) {
		this.cal = Calendar.getInstance();
		this.cal.add(Calendar.DATE,days);
	}
	
	/**
	 * @param days, extend the expiration date of the lending in days from the initial expiration day
	 */
	void extendCal(int days) {
		this.cal.add(Calendar.DATE,days);
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [id=" + id + ", "
				+ (title != null ? "title=" + title + ", " : "")
				+ (location != null ? "location=" + location + ", " : "")
				+ "lended=" + lended + ", "
				+ (lender != null ? "lender=" + lender + ", " : "")
				+ (cal != null ? "cal=" + cal.getTime(): "") + "]";
	}
	
}
