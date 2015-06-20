package part5;

import persons.Person;
import persons.Student;

public class SortedListApp {

	public static void main(String[] args) {

		SortedList<Person> persons = new SortedLinkedList<Person>();
		persons.add(new Student("Mike"));
		persons.add(new Student("Joe"));
		for (Person p : persons) {
			p.print();
		}

		LinkedList<Person> p = new LinkedList<>();
		p.add(new Person("a"));
		Person[] arr = p.toEArray();
	}

}
