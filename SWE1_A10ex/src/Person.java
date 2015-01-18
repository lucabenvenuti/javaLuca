/* Person.java
 * Software Development 1.07 Objects III
 * Institute for Pervasive Computing, JKU Linz, Austria
 * http://www.pervasive.jku.at
 * author: 2007-10-1 Michael Matscheko
 * last change: 2012-11-11 Michael Matscheko */

//package at.jku.pervasive.swe1.vo7;
import java.util.Calendar;

public class Person {
	public String firstName, lastName; // name of person
	public Date birthdate;             // date of birth

	public Person(String firstName, String lastName, int day, int month, int year) {
		this.firstName = firstName;
		this.lastName = lastName;
		birthdate = new Date(day, month, year);
	}
	
	public Person(Person p) {  // alternative constructor
		this(p.firstName, p.lastName, p.birthdate.day, p.birthdate.month, p.birthdate.year);
	}
	
	public int age() {         // get age of person
		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		return thisYear - birthdate.year;
	}
	
	public int subsidy() {     // usually no subsidy is granted
		return 0;
	}
}
