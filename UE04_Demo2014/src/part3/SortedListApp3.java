package part3;

import persons.Person;
import persons.Student;

public class SortedListApp3 {

	public static void main(String[] args) {

		SortedList<Person> persons = new SortedLinkedList<Person>();
		persons.add(new Student("Mike"));
		persons.add(new Student("Joe"));
		for (Person p : persons) {
			p.print();
		}
	}

}
