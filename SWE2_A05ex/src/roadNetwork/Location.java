package roadNetwork;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Location implements Comparable<Location> {

	private final int x;
	private final int y;
	private final String name;
	private Collection<Link> links = new TreeSet<Link>();

	public Location(int x, int y, String name) {
		super();
		this.x = x;
		this.y = y;
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getName() {
		return name;
	}

	public void addLink(Link link) {
		getLinks().add(link);
	}

	public Collection<Link> getLinks() {
		return links;
	}

	void setLinks(Collection<Link> links) {
		this.links = links;
	}

	// use streams
	Collection<Location> getNeighbors() {
		Collection<Location> neighbors = new LinkedList<Location>();
		for (Link l : getLinks()) {
			neighbors.add(getNeighborFor(l));
		}
		return neighbors;
	}

	Location getNeighborFor(Link lnk) {
		return lnk.getOtherLocation(this);
	}

	// use streams
	Link getLinkTo(Location neighbor) {
		for (Link l : links) {
			if (l.getEnd().equals(neighbor) || l.getStart().equals(neighbor))
				return l;
		}

		return null;
	}

	public List<Link> getLinkedSorted(Comparator<Link> linkComparator) {
		return getLinks().stream().sorted(linkComparator)
				.collect(Collectors.toList());
	}

	public List<Location> getNeighborsSorted(
			Comparator<Location> locationComparator) {
		return getNeighbors().stream().sorted(locationComparator)
				.collect(Collectors.toList());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public int compareTo(Location location) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;

		if (this == location)
			return EQUAL;
		if (this.x < location.x)
			return BEFORE;
		if (this.x > location.x)
			return AFTER;

		if (this.y < location.y)
			return BEFORE;
		if (this.y > location.y)
			return AFTER;

		return this.name.compareTo(location.name);
	}

	@Override
	public String toString() {
		return "You are currently in " + name + " (" + x + "/" + y + ")" + "\n"
				+ "From " + name + " you can go";
	}

}
