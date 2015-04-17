package part07;

import inout.Out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Demo7 {

	public static void main(String[] args) {

		Out.println("---- test comparator --------------");

		SortedSet<Person> scss = new TreeSet<Person>((p1, p2) -> p2.hired
				- p1.hired);

		scss.add(new Person("Franz", "Maier", 2004));
		scss.add(new Person("Alois", "Müller", 2003));
		scss.add(new Person("Gustav", "Maier", 1999));
		scss.add(new Person("Berta", "Maier", 2003));
		scss.forEach(p -> System.out.println(p));

		Out.println("---- test list sort --------------");

		List<Person> plist = new ArrayList<Person>();

		plist.add(new Person("Franz", "Maier", 2004));
		plist.add(new Person("Alois", "Müller", 2003));
		plist.add(new Person("Gustav", "Maier", 1999));
		plist.add(new Person("Berta", "Maier", 2003));
		Collections.sort(plist, (p1, p2) -> p2.hired - p1.hired);
		plist.stream().sorted((p1, p2) -> p2.hired - p1.hired)
				.forEach(p -> System.out.println(p));
		plist.forEach(p -> Out.println(p));
		Out.println();

	}
}
