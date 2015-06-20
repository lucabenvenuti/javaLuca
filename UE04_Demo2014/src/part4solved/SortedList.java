package part4solved;

//							Student		    Person super Student
public interface SortedList<E extends Comparable<? super E>> extends List<E> {
}

// Student extends Person implements Comparable<Person>