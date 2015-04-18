package roadNetwork;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

class Location implements Comparable<Location> {

	private final int x;
	private final int y;
	private final String name;
	private Collection<Link> links;
//	private List<Location> neighbors;

	protected Location(int x, int y, String name) {
		super();
		this.x = x;
		this.y = y;
		this.name = name;
	}
	
	void addLink(Link link){
		links.add(link);
	}

	Collection<Link> getLinks() {
		return links;
	}

	void setLinks(Collection<Link> links) {
		this.links = links;
	}
	
	Collection<Location> getNeighbors() {
	//	links.stream().
		
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

/*	@Override
	public int compareTo(Location o) {
		int compare = this.x == o.x ? 0 : 1;
		if (compare == 0) {
			compare = this.y == o.y ? 0 : 1;
		}
		if (compare == 0) {
			compare = this.name.compareTo(o.name);
		}
		return compare;
	}*/
	

	@Override
	public int compareTo(Location location) {
	    final int BEFORE = -1;
	    final int EQUAL = 0;
	    final int AFTER = 1;
		
	    if (this == location) return EQUAL;
	    if (this.x < location.x) return BEFORE;
	    if (this.x > location.x) return AFTER;
	    
	    if (this.y < location.y) return BEFORE;
	    if (this.y > location.y) return AFTER;
	    
	    int comparison = this.name.compareTo(location.name);
	    if (comparison != EQUAL) return comparison;
	    
	    return EQUAL;
	}
	

}
