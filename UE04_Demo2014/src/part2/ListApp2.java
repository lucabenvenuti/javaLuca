package part2;

import persons.Student;
import persons.Teacher;
import persons.Person;

public class ListApp2 {

	public static void main(String[] args) {

		List<Student> students = new LinkedList<Student>();
		students.add(new Student("Mike"));
		students.add(new Student("Joe"));
		for (Student s : students) {
			s.learn();
		}

		List<Teacher> teachers = new LinkedList<Teacher>();
		teachers.add(new Teacher("Maier"));
		teachers.add(new Teacher("Huber"));
		for (Teacher t : teachers) {
			t.teach();
		}

		//
		// // Wildcards
		// ----------------------------------------------------------
		//
		List<?> some = students;
		// some.add(new Teacher("Mueller"));
		for (Object o : some) {
			System.out.println(o.toString());
		}

		List<? extends Person> somePersons = students;
		// somePersons.add(new Teacher("Mueller"));
		// somePersons.add(new Student("Mueller"));
		for (Person p : somePersons) {
			System.out.println(p.name);
		}

	}

}
