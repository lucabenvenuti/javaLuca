package roadNetwork;

import java.util.Comparator;

/**
 * LengthComp.java
 *
 * A {@link LengthComp} is a class which implements a Comparator<Link>
 * interface. It compares two given links by their length.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class LengthComp implements Comparator<Link> {

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 *      compares two given links by their length.
	 */
	@Override
	public int compare(Link link1, Link link2) {
		return link1.getLength() - link2.getLength();
	}
}
