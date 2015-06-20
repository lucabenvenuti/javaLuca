package part02bsolved;

import inout.Out;

import java.util.HashSet;

public class Demo2 {

	public static void main(String[] args) {

		// equals test
		Person franz1 = new Person("Franz", "Maier");
		Person franz2 = new Person("Franz", "Maier");
		boolean eq = franz1.equals(franz2);
		Out.println(eq);

		// hashCode
		int franz1Hash = franz1.hashCode();
		Out.println(franz1Hash);
		int franz2Hash = franz2.hashCode();
		Out.println(franz2Hash);

		// Hash
		HashSet<Person> hs = new HashSet<Person>();
		hs.add(franz1);
		boolean franz2Contained = hs.contains(franz2);
		Out.println(franz2Contained);
		hs.add(franz2);

		franz2Contained = hs.contains(franz2);
		Out.println(franz2Contained);

	}
}
