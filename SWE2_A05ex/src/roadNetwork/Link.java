package roadNetwork;

import java.util.List;

class Link implements Comparable<Link> {

	private final String name;
	private final LinkType linkType;
	private final int length;
	private final Location start;
	private final Location end;
	private final int travelTimeInHours;
	private List<Location> locations;

	Link(String name, LinkType linkType, int length, Location start,
			Location end) {
		this.name = name;
		this.linkType = linkType;
		this.length = length;
		this.start = start;
		this.end = end;
		travelTimeInHours = length / linkType.getVel();
		locations.add(start);
		locations.add(end);
	}

	List<Location> getStartEnd() {
		return locations;
	}
	
	List<Location> getLocations() {
		return locations;
	}

	Location getOtherLocation(Location loc) {
		if (loc.equals(start)) {
			return end;
		}
		return start;
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
	public int compareTo(Link o) {
		int compare = this.length == o.length ? 0 : 1;
		if (compare == 0) {
			compare = this.linkType.compareTo(o.linkType); 
		}
		if (compare == 0) {
			compare = this.name.compareTo(o.name);
		}
		return compare;
	}

}
