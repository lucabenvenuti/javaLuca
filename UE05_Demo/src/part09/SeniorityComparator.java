package part09;

import java.util.Comparator;

public class SeniorityComparator implements Comparator<Person> {
	@Override
	public int compare(Person p1, Person p2) {
		int compare = p2.hired - p1.hired;
		if (compare == 0) {
			compare = p1.compareTo(p2);
		}
		return compare;
	}
}
