package roadNetwork;

import java.util.LinkedList;
import java.util.List;

public class Link implements Comparable<Link> {

	private final String name;
	private final LinkType linkType;
	private final int length;
	private final Location start;
	private final Location end;
	private final int travelTimeInHours;

	Link(String name, LinkType linkType, int length, Location start,
			Location end) {
		this.name = name;
		this.linkType = linkType;
		this.length = length;
		this.start = start;
		this.end = end;
		travelTimeInHours = length / linkType.getVel();
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

	int getTravelTimeInHours() {
		return travelTimeInHours;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + length;
		result = prime * result
				+ ((linkType == null) ? 0 : linkType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Link other = (Link) obj;
		if (length != other.length)
			return false;
		if (linkType != other.linkType)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Link link) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;

		if (this == link)
			return EQUAL;
		if (this.length < link.length)
			return BEFORE;
		if (this.length > link.length)
			return AFTER;

		int comparison = this.linkType.compareTo(link.linkType);
		if (comparison != EQUAL)
			return comparison;

		return this.name.compareTo(link.name);
	}

	public String toString(Location location) {
		return (linkType == null) ? "" : "  " + linkType.toString() + " "
				+ name + ": " + length + " km to "
				+ getOtherLocation(location).getName();
	}

	@Override
	public String toString() {
		return "Link [name=" + name + ", linkType=" + linkType + ", length="
				+ length + ", start=" + start + ", end=" + end + "]";
	}

}
