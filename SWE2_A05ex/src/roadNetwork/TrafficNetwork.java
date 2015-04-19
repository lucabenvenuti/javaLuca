package roadNetwork;

import java.util.SortedMap;
import java.util.TreeMap;

public class TrafficNetwork {

	private final SortedMap<String, Location> networkMap = new TreeMap<String, Location>();

	public void addLocation(Location location) {
		networkMap.put(location.getName(), location);
	}
	
	public void removeLocation(Location location) {
		networkMap.remove(location.getName());
	}

	public void removeLocation(String name) {
		networkMap.remove(name);
	}

	public Location getLocation(String name){
		return networkMap.get(name);
	}
}

/*
 * Comparator<Link> lengthOrder = new Comparator<Link>() {
 * 
 * @Override public int compare(Link s1, Link s2) { return s1.getLength() -
 * s2.getLength(); } };
 * 
 * //SortedMap<Location, String> sortedMap; //SortedMap<Location, String> mapA =
 * new TreeMap<Location, String>(lengthOrder);
 */
