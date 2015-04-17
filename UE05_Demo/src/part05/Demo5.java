package part05;

import java.util.SortedSet;
import java.util.TreeSet;

public class Demo5 {

	public static void main(String[] args) {

		// sorted set
		SortedSet<Person> ss = new TreeSet<Person>();
		ss.add(new Person("Franz", "Maier"));
		ss.add(new Person("Alois", "Müller"));
		ss.add(new Person("Gustav", "Maier"));
		ss.add(new Person("Berta", "Maier"));
		ss.forEach(p -> System.out.println(p));

		System.out.println();

		// show java 8 features:
		ss.stream().sorted((p1, p2) -> -p1.firstName.compareTo(p2.firstName))
				.filter(p -> p.surName.equals("Maier"))
				.map(p -> p.firstName.toUpperCase())
				.forEach(p -> System.out.println(p));

		int sum = ss.stream()
				.mapToInt(p -> p.firstName.length() + p.surName.length()).sum();
		System.out.println(sum);

	}
}
