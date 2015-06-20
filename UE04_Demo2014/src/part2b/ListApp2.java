package part2b;

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

		List<? super Student> somePersons = students;
		somePersons.add(new Student("Mueller"));
		// for (Student p : somePersons) {
		// System.out.println(p.name);
		// }

	}

}
