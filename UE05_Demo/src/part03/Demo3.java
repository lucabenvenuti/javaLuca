package part03;

public class Demo3 {

	public static void main(String[] args) {
		Person p = new Person("Ralf", "Berger");
		Student s = new Student("Ralf", "Berger", 9955123);
		boolean pEqualsS = p.equals(s);
		System.out.println(pEqualsS);
		boolean sEqualsP = s.equals(p);
		System.out.println(sEqualsP);

	}
}
