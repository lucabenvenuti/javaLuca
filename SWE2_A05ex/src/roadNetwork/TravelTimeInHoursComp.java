package roadNetwork;

import java.util.Comparator;

/**
 * TravelTimeInHoursComp.java
 *
 * A {@link TravelTimeInHoursComp} is a class which implements a Comparator<Link> interface. It
 * compares two given links by their travel time.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class TravelTimeInHoursComp implements Comparator<Link> {

	/** (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 * compares two given links by travel time.
	 */
	@Override
	public int compare(Link link1, Link link2) {
		return Math.round(Math.signum(link1.getTravelTimeInHours()
				- link2.getTravelTimeInHours()));
	}
}