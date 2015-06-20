package part05;

public class Person implements Comparable<Person> {

	private final String surName;
	private final String firstName;
	private final int age;

	public Person(String firstName, String surName, int age) {
		this.firstName = firstName;
		this.surName = surName;
		this.age = age;
	}

	@Override
	public String toString() {
		return firstName + " " + surName + " " + age;
	}

	public int getAge() {
		return age;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSurName() {
		return surName;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person other = (Person) obj;
			return this.surName.equals(other.surName)
					&& this.firstName.equals(other.firstName);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.surName.hashCode() ^ firstName.hashCode();
	}

	@Override
	public int compareTo(Person other) {
		int compare = this.surName.compareTo(other.surName);
		if (compare == 0) {
			compare = this.firstName.compareTo(other.firstName);
		}
		return compare;
	}

}
