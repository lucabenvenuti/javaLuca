package roadNetwork;

import inout.Window;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * TrafficNetwork.java
 *
 * A {@link TrafficNetwork} is a class that contains a SortedMap of locations.
 * Here locations and links can be added.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class TrafficNetwork {

	private final SortedMap<String, Location> networkMap = new TreeMap<String, Location>();

	/**
	 * @param location
	 *            , if not already inserted, is added to the map and drawn.
	 */
	public void addLocation(Location location) {
		if (!networkMap.containsKey(location.getName())) {
			networkMap.put(location.getName(), location);
			Window.drawPoint(location.getX(), location.getY());
			Window.drawText(location.getName(), location.getX() + 10,
					location.getY());
		}
	}

	/**
	 * @param name
	 * @return the location with the given key name.
	 */
	public Location getLocation(String name) {
		return networkMap.get(name);
	}

	/**
	 * @param name
	 * @param linkType
	 * @param length
	 * @param start
	 * @param end
	 * @return the Link with the given parameters, after checking if it was
	 *         already inserted, and inserting it if not.
	 */
	public Link addLink(String name, LinkType linkType, int length,
			Location start, Location end) {
		Link link = start.checkExistingLink(length, linkType, name);
		if (link != null)
			return link;
		link = end.checkExistingLink(length, linkType, name);
		if (link != null)
			return link;

		addLocation(start);
		addLocation(end);

		link = new Link(name, linkType, length, start, end);
		start.addLink(link);
		end.addLink(link);
		Window.drawLine(start.getX(), start.getY(), end.getX(), end.getY(),
				linkType.getColor());
		return link;
	}
}