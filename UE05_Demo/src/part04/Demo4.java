package part04;

import java.util.SortedSet;
import java.util.TreeSet;

public class Demo4 {

	public static void main(String[] args) {

		// sorted set
		SortedSet<Person> ss = new TreeSet<Person>();
		ss.add(new Person("Franz", "Maier"));
		ss.add(new Person("Alois", "Müller"));
		ss.add(new Person("Gustav", "Maier"));
		ss.add(new Person("Berta", "Maier"));
		ss.forEach(p -> System.out.println(p));

	}
}
