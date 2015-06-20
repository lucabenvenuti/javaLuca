package part06solved;

import java.util.SortedSet;
import java.util.TreeSet;

public class Demo6 {

	public static void main(String[] args) {

		// sorted set
		SortedSet<Person> ss = new TreeSet<Person>();
		ss.add(new Person("Franz", "Maier"));
		ss.add(new Person("Alois", "M�ller"));
		ss.add(new Person("Gustav", "Maier"));
		ss.add(new Person("Berta", "Maier"));
		ss.forEach(p -> System.out.println(p));
		System.out.println();
		// ss.first().surName = "Zimmermann";

		ss.remove(new Person("Berta", "Maier"));
		ss.forEach(p -> System.out.println(p));
		System.out.println();

		ss.add(new Person("Berta", "Zimmermann"));
		ss.forEach(p -> System.out.println(p));
		System.out.println();

	}
}
