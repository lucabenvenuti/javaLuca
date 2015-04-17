package part09;

public class Student extends Person {

	final int studentId;

	public Student(String firstName, String surName, int studentId) {
		super(firstName, surName);
		this.studentId = studentId;
	}

}
