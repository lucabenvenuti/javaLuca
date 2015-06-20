package part05;

public class Student extends Person {

	final int studentId;

	public Student(String firstName, String surName, int age, int studentId) {
		super(firstName, surName, age);
		this.studentId = studentId;
	}

}
