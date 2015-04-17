package roadNetwork;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

class Location implements Comparable<Location> {

	private final int x;
	private final int y;
	private final String name;
	private Collection<Link> links;
	private List<Location> locations;

	protected Location(int x, int y, String name) {
		super();
		this.x = x;
		this.y = y;
		this.name = name;
	}

	Collection<Link> getLinks() {
		return links;
	}

	void setLinks(Collection<Link> links) {
		this.links = links;
	}
	
	Collection<Link> getNeighbors() {
		return null;
	}
	
	Location getNeighborFor(Link lnk){
		return null;
	}
	
	Link getLinkTo(Location neighbor){
		return null;
	}
	
	List<Link> getLinkedSorted(Comparator<Link> linkComparator){
		return null;
	}
	
	List<Location> getNeighborsSorted(Comparator<Location> locationComparator){
		return null;
	}
	

	// void addLink()

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
	public int compareTo(Location o) {
		int compare = this.x == o.x ? 0 : 1;
		if (compare == 0) {
			compare = this.y == o.y ? 0 : 1;
		}
		if (compare == 0) {
			compare = this.name.compareTo(o.name);
		}
		return compare;
	}

}
