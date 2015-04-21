package roadNetwork;

import java.util.Comparator;

/**
 * LocationComp.java
 *
 * A {@location LocationComp} is a class which implements a Comparator<Location> interface. It
 * compares two given locations.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class LocationComp implements Comparator<Location> {

	/** (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 * compares two given locations by their length.
	 */
	@Override
	public int compare(Location location1, Location location2) {
		return location1.compareTo(location2);
	}
}
