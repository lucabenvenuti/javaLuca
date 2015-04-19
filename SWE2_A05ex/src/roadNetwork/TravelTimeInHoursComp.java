package roadNetwork;

import java.util.Comparator;

public class TravelTimeInHoursComp implements Comparator<Link> {

	@Override
	public int compare(Link link1, Link link2) {
		return link1.getTravelTimeInHours() - link2.getTravelTimeInHours();
	}

}