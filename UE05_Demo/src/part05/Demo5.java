package part05;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.OptionalInt;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Demo5 {

	public static void main(String[] args) {

		// sorted set
		SortedSet<Person> ss = new TreeSet<Person>();
		ss.add(new Person("Franz", "Maier", 20));
		ss.add(new Person("Alois", "Mueller", 26));
		ss.add(new Person("Gustav", "Maier", 30));
		ss.add(new Person("Berta", "Maier", 56));
		ss.forEach(p -> System.out.println(p));

		System.out.println();

		// show java 8 features:
		// sort by firstname
		// fileter maiers
		// map fn to uppercase
		// print

		List<Person> persons = new LinkedList<>();
		persons.addAll(ss);
		Collections.sort(persons,
				(p1, p2) -> -p1.getFirstName().compareTo(p2.getFirstName()));
		List<Person> maiers = new LinkedList<>();
		for (Person p : persons) {
			if (p.getSurName().equals("Maier")) {
				maiers.add(p);
			}
		}
		List<String> firstName = new LinkedList<>();
		for (Person p : maiers) {
			firstName.add(p.getFirstName());
		}
		List<String> upperCaseName = new LinkedList<>();
		for (String s : firstName) {
			upperCaseName.add(s.toUpperCase());
		}
		for (String s : upperCaseName) {
			System.out.println(s);
		}

		ss.stream()
				.sorted((p1, p2) -> -p1.getFirstName().compareTo(
						p2.getFirstName()))
				.filter(s -> s.getSurName().equals("Maier"))
				.map(p -> p.getFirstName()).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		ss.stream()
				.sorted((p1, p2) -> -p1.getFirstName().compareTo(
						p2.getFirstName()))
				.filter(p -> p.getSurName().equals("Maier"))
				.map(p -> p.getFirstName().toUpperCase())
				.forEach(p -> System.out.println(p));

		System.out.println();

		List<Person> theMaiers = ss.parallelStream()
				.filter(s -> s.getSurName().equals("Maier"))
				.collect(Collectors.toList());
		theMaiers.forEach(s -> System.out.println(s));

		System.out.println();

		int sum = ss.stream().mapToInt(Person::getAge).sum();
		System.out.println("Lachelmannculo");
		System.out.println(sum);
		double sum2 = ss.stream().mapToInt(p -> p.getAge()).average().orElse(0);
		System.out.println("Lachelmannculo");
		System.out.println(sum2);

		System.out.println();

		ss.stream().mapToInt(p -> p.getAge()).max()
				.ifPresent(m -> System.out.println(m));

		OptionalInt max = ss.stream().mapToInt(p -> p.getAge()).max();
		if (max.isPresent()) {
			System.out.println(max.getAsInt());
		}
	}
}
