package library;

import java.util.Calendar;

public final class Book {

	private final int id;
	
	private final String title;
	
	private final String location;
	
	private boolean lended;
	
	private Person lender;
	
	private Calendar cal;

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
		this.cal.add(Calendar.DATE,10000);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	public boolean isLended() {
		return lended;
	}

	public boolean setLended(boolean lended) {
		this.lended = lended;
		return true;
	}

	public Person getLender() {
		return lender;
	}

	public boolean setLender(Person lender) {
		this.lender = lender;
		return true;
	}

	public Calendar getCal() {
		return cal;
	}

	public void setCal(int days) {
		this.cal = Calendar.getInstance();
		this.cal.add(Calendar.DATE,days);
	}
	
	public void extendCal(int days) {
		//this.cal = Calendar.getInstance();
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

	
}
