package roadNetwork;

import java.util.Comparator;

public class LengthComp implements Comparator<Link> {

	@Override
	public int compare(Link link1, Link link2) {
		return link1.getLength() - link2.getLength();
	}

}
