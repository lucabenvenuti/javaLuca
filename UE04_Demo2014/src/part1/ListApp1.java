package part1;

import persons.Person;
import persons.Student;
import persons.Teacher;

public class ListApp1 {

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

		// // Type compatibility
		// ------------------------------------------------
		//
		List<Person> persons;
		List<Student> students2;
		List<Object> objects;
		List l;

		students2 = students;
		// teachers = students;

		// persons = students;
		// objects = students;

		l = students;
		l.add(new Teacher("Mueller"));
		for (Student s : students) {
		s.learn();
		}

	}

}
