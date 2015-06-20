package part4solved;

import persons.Person;
import persons.Student;
import persons.Teacher;

public class SortedListApp4 {

	public static void main(String[] args) {

		SortedList<Person> persons = new SortedLinkedList<Person>();
		persons.add(new Student("Mike"));
		persons.add(new Student("Joe"));
		for (Person p : persons) {
			p.print();
		}

		SortedList<Student> students = new SortedLinkedList<Student>();
		students.add(new Student("Mike"));
		students.add(new Student("Joe"));
		for (Student s : students) {
			s.learn();
		}

		SortedList<Teacher> teachers = new SortedLinkedList<Teacher>();
		teachers.add(new Teacher("Maier"));
		teachers.add(new Teacher("Huber"));
		for (Teacher t : teachers) {
			t.teach();
		}

	}

}
