package coll;


//public interface SortedList<E extends Comparable<E>> 
	//This first version does not work with SortedList<Student> 
	//because Comparable<Student> not a subtype of Comparable<Person>

public interface SortedList<E extends Comparable<? super E>> 
	extends List<E> {

}
