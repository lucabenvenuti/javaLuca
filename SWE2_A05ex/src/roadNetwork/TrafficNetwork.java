package roadNetwork;

import java.util.SortedMap;
import java.util.TreeMap;

public class TrafficNetwork {

	private final SortedMap<String, Location> networkMap = new TreeMap<String, Location>();

	public void addLocation(Location location) {
		if (!networkMap.containsKey(location.getName())) {
			networkMap.put(location.getName(), location);
		}
	}

	public Location getLocation(String name) {
		return networkMap.get(name);
	}

	public Link addLink(String name, LinkType linkType, int length,
			Location start, Location end) {
		addLocation(start);
		addLocation(end);
		Link link = new Link(name, linkType, length, start, end);
		start.addLink(link);
		end.addLink(link);
		return link;
	}
}