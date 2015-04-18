package roadNetwork;

import java.util.Comparator;

public class TravelTimeInHoursComp implements Comparator<Link> {

	@Override
	public int compare(Link link1, Link link2) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;

		if (link1.getTravelTimeInHours() == link2.getTravelTimeInHours())
			return EQUAL;
		if (link1.getTravelTimeInHours() < link2.getTravelTimeInHours())
			return BEFORE;
		if (link1.getTravelTimeInHours() > link2.getTravelTimeInHours())
			return AFTER;
		return EQUAL;
	}

}