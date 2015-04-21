package roadNetwork;

import java.util.LinkedList;
import java.util.List;

/**
 * Link.java
 *
 * A {@link Link} is a class which implements a Comparable<Link> interface. It
 * contains the name of the link, its type, length and travel time, and the two
 * locations between which the link is.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class Link implements Comparable<Link> {

	private final String name;
	private final LinkType linkType;
	private final int length;
	private final Location start;
	private final Location end;
	private final float travelTimeInHours;

	Link(String name, LinkType linkType, int length, Location start,
			Location end) {
		this.name = name;
		this.linkType = linkType;
		this.length = length;
		this.start = start;
		this.end = end;
		travelTimeInHours = (float) length / linkType.getVel();
	}

	List<Location> getLocations() {
		LinkedList<Location> locations = new LinkedList<Location>();
		locations.add(start);
		locations.add(end);
		return locations;
	}

	Location getOtherLocation(Location loc) {
		if (loc.equals(start)) {
			return end;
		} else if (loc.equals(end)) {
			return start;
		} else {
			return null;
		}
	}

	String getName() {
		return name;
	}

	LinkType getLinkType() {
		return linkType;
	}

	int getLength() {
		return length;
	}

	Location getStart() {
		return start;
	}

	Location getEnd() {
		return end;
	}

	float getTravelTimeInHours() {
		return travelTimeInHours;
	}

	String travelTimeInHoursMinutesToString() {
		int hours = (int) Math.floor(getTravelTimeInHours());
		int minutes = (int) (Math.floor(getTravelTimeInHours() * 60) - hours * 60);
		int seconds = (int) (Math.floor(getTravelTimeInHours() * 3600) - hours
				* 3600 - minutes * 60);
		return hours + " hours, " + minutes + " minutes, " + seconds
				+ " seconds.";
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object) comparison based on
	 *      length, then linkType, then name
	 */
	@Override
	public int compareTo(Link link) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;

		if (this == link)
			return EQUAL;
		if (this.getLength() < link.getLength())
			return BEFORE;
		if (this.getLength() > link.getLength())
			return AFTER;

		int comparison = this.getLinkType().compareTo(link.getLinkType());
		if (comparison != EQUAL)
			return comparison;

		return this.getName().compareTo(link.getName());
	}

	int compareTo(int length, LinkType linkType, String name) {
		return compareTo(new Link(name, linkType, length, null, null));
	}

	/**
	 * @param location
	 * @return a String with the info on the link.
	 */
	public String linkToString(Location location) {
		return (getLinkType() == null) ? "" : "  " + getLinkType().toString()
				+ " " + getName() + ": " + getLength() + " km to "
				+ getOtherLocation(location).getName() + ". Travel time: "
				+ travelTimeInHoursMinutesToString();
	}

}
