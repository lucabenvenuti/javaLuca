package roadNetwork;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Location.java
 *
 * A {@link Location} is a class which implements a Comparable<Location>
 * interface. It contains the x, y position of the location, its name and the
 * links in and out.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class Location implements Comparable<Location> {

	private final int x;
	private final int y;
	private final String name;
	private Collection<Link> links = new TreeSet<Link>();

	public Location(int x, int y, String name) {
		this.x = x;
		this.y = y;
		this.name = name;
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}

	/**
	 * @return the location name
	 */
	public String getName() {
		return name;
	}

	void addLink(Link link) {
		getLinks().add(link);
	}

	Collection<Link> getLinks() {
		return links;
	}

	void setLinks(Collection<Link> links) {
		this.links = links;
	}

	Link checkExistingLink(int length, LinkType linkType, String name) {
		return getLinks().stream()
				.filter(l -> l.compareTo(length, linkType, name) == 0)
				.findFirst().orElse(null);
	}

	Collection<Location> getNeighbors() {
		return getLinks().stream().map(l -> getNeighborFor(l))
				.collect(Collectors.toList());
	}

	Location getNeighborFor(Link lnk) {
		return lnk.getOtherLocation(this);
	}

	Link getLinkTo(Location neighbor) {
		return getLinks()
				.stream()
				.filter(l -> l.getEnd().equals(neighbor)
						|| l.getStart().equals(neighbor)).findFirst()
				.orElse(null);
	}

	/**
	 * @param linkComparator
	 * @return a List<Link> sorted by the given linkComparator
	 */
	public List<Link> getLinkedSorted(Comparator<Link> linkComparator) {
		return getLinks().stream().sorted(linkComparator)
				.collect(Collectors.toList());
	}

	public List<Location> getNeighborsSorted(
			Comparator<Location> locationComparator) {
		return getNeighbors().stream().sorted(locationComparator)
				.collect(Collectors.toList());
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object) comparison based on
	 *      x, then y, then name
	 */
	@Override
	public int compareTo(Location location) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;

		if (this == location)
			return EQUAL;
		if (this.getX() < location.getX())
			return BEFORE;
		if (this.getX() > location.getX())
			return AFTER;

		if (this.getY() < location.getY())
			return BEFORE;
		if (this.getY() > location.getY())
			return AFTER;

		return this.getName().compareTo(location.getName());
	}

	/**
	 * @return a String with the info on the location.
	 */
	public String locationToString() {
		return "You are currently in " + getName() + " (" + getX() + "/"
				+ getY() + ")" + "\n" + "From " + getName() + " you can go :";
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * basic eclipse implementation of to string for test purposes
	 */
	@Override
	public String toString() {
		return "Location [x=" + getX() + ", y=" + getY() + ", name="
				+ getName() + "]";
	}

}
