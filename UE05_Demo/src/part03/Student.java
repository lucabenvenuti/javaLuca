package part03;

public class Student extends Person {

	final int studentId;

	public Student(String firstName, String surName, int studentId) {
		super(firstName, surName);
		this.studentId = studentId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student other = (Student) obj;
			return this.surName.equals(other.surName)
					&& this.firstName.equals(other.firstName)
					&& this.studentId == other.studentId;
		}
		return false;
	}

}
