package coll;

import persons.Person;
import persons.Student;
import persons.Teacher;

public class ListApp {

	public static void main(String[] args) {
		
		List<Student> students = new LinkedList<Student>(); 
		students.add(new Student("Mike")); 
		students.add(new Student("Joe")); 
		for (Student s: students) {
			s.learn(); 
		}
		
		List<Teacher> teachers = new LinkedList<Teacher>(); 
		teachers.add(new Teacher("Maier")); 
		teachers.add(new Teacher("Huber")); 
		for (Teacher t: teachers) {
			t.teach(); 
		}
		
		// Type compatibility  ------------------------------------------------
		
		
		// Wildcards ----------------------------------------------------------
		
//		List<?> some = students; 
//		// some.add(new Teacher("Mueller")); // The method add(capture#1-of ?) in the type List<capture#1-of ?> is not applicable for the arguments (Teacher)
//		for (Object o: some) {
//			System.out.println(o.toString()); 	
//		}
//				
//		List<? extends Person> somePersons = students; 
//		// somePersons.add(new Teacher("Mueller")); // The method add(capture#1-of ? extends Person) in the type List<capture#1-of ? extends Person> is not applicable for the arguments (Teacher)
//		for (Person p: somePersons) {
//			System.out.println(p.name); 
//		}
		
		// Methods ------------------------------------------------------------
		
//		persons = new LinkedList<Person>(); 
//		persons.addAll(students);
//		persons.addAll(teachers); 
//		System.out.println(); 
//		for (Person p: persons) {
//			p.print(); 
//		}
//		
//		System.out.println(); 
//		System.out.println(persons.containsAll(students));
		
		// toArray ------------------------------------------------------------
		
		Object[] o1 = students.toArray();
		System.out.println(); 
		for (Object o: o1) {
			System.out.println(o.toString()); 
		}
		
		// toEArray tests
		
		// toEArray would work with Object[]: 
//		Object[] ox = students.toEArray(); 
//		System.out.println(); 
//		for (Object o: ox) {
//			System.out.println(o.toString()); 
//		}
		
		// toEArray would not work with any other Array than Object[]: 
//		Person[] pa1 = students.toEArray(); 
//	 	does not work (ClassCastException: cannot convert from Object[] to Person[])

		// generic method <T> E[] toArray(T[]] test
		
		// generic method toArray works when used properly, 
		//     i.e. array element type subtype of list element type 
		
		Person[] pa3 = students.toArray(new Person[0]); 
		System.out.println(); 
		for (Person p: pa3) {
			p.print(); 
		}
		
		String[] str = students.toArray(new String[0]);
		
		// generic method toArray results in ArrayStoreException when used with 
		// wrong type, i.e. array element type not subtype of list element type 
		
//		Student[] sa = teachers.toArray(new Student[0]);
//		for (Person p: sa) {
//			p.print(); 
//		}
//		
//		Object[] os = new Person[10]; 
//		
//		os[0] = "ABC"; // ArrayStoreException
//		
		
		//Exception in thread "main" java.lang.ArrayStoreException: persons.Teacher
	}
		
}
