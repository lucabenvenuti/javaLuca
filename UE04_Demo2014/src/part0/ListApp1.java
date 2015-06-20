package part0;

import persons.Person;
import persons.Student;
import persons.Teacher;

public class ListApp1 {

	public static void main(String[] args) {

		List students = new LinkedList();
		students.add(new Student("Mike"));
		students.add(new Student("Joe"));
		for (Object s : students) {
			((Student) s).learn();
		}

		List teachers = new LinkedList();
		teachers.add(new Teacher("Maier"));
		teachers.add(new Teacher("Huber"));
		for (Teacher t : teachers) {
			t.teach();
		}

	}

}
