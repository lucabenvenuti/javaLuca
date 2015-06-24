package beings4;

import inout.Out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Student stdt = new Student("Hans", Studies.CS);
		Professor prof = new Professor("Wirth", "Software");

		Person person1 = stdt;
		Person person2 = prof;

		Pet pet1 = new Pet("Minki");
		Pet pet2 = new Pet("Lessie");

		List<HasName> list = new ArrayList<HasName>();
		list.add(person2);
		list.add(person1);
		list.add(pet1);
		list.add(pet2);

		print(list);
		Out.println();
		Collections.sort(list);
		print(list);
		Out.println();

		pet1.live();
		Out.println();
		person2.live();
		Out.println();
		person1.talkWith(pet2);
		Out.println();
		person2.work();
		Out.println();
		stdt.work();
		Out.println();
		prof.teach();
		Out.println();
	}

	private static void print(List<HasName> list) {
		for (HasName p : list) {
			Out.println(p.getName());
		}
	}

}
