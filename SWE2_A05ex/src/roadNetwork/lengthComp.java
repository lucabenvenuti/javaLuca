package roadNetwork;

import java.util.Comparator;

public class lengthComp implements Comparator<Link> {

	@Override
	public int compare(Link link1, Link link2) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;

		if (link1.getLength() == link2.getLength())
			return EQUAL;
		if (link1.getLength() < link2.getLength())
			return BEFORE;
		if (link1.getLength() > link2.getLength())
			return AFTER;
		return EQUAL;
	}

}
