package part7isfunny;

import persons.Student;
import persons.Teacher;

public class ListApp1 {

	public static void main(String[] args) {

		List<Student> students = new LinkedList<Student>();
		students.add(new Student("Mike"));
		students.add(new Student("Joe"));

		Object o = students;
		List<Student> realStudents = (List<Student>) o;
		List<Teacher> noRealTeachers = (List<Teacher>) o;
		noRealTeachers.add(new Teacher("real Teacher"));
		for (Teacher t : noRealTeachers) {
			System.out.println(t.name);
		}

	}

}
