/* Student.java
 * Software Development 1.07 Objects III
 * Institute for Pervasive Computing, JKU Linz, Austria
 * http://www.pervasive.jku.at
 * author: 2007-10-1 Michael Matscheko
 * last change: 2012-11-11 Michael Matscheko */

//package at.jku.pervasive.swe1.vo7;

public class Student extends Person {
	// unique id number for next student
	static private int nextStudentID = 100000; 
	
	public int studentID; // unique student id number (e.g. matrikelnummer)
	public String branch; // study branch (e.g. "computer science")

	public Student(String firstName, String lastName, int day, int month, int year, String branch) {
		super(firstName, lastName, day, month, year); // call super constr.
		studentID = nextStudentID++; // assign new student id
		this.branch = branch; 
	}
	
	public Student(Student s) {
		super(s); // call super constructor
		studentID = nextStudentID++; // assign new student id
		this.branch = s.branch; 
	}
	
	public int subsidy() { // students get subsidy if younger than 26
		return age() < 26 ? 150 : 0;
	}
}
