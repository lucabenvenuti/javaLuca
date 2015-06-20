package part4;

// new: <E extends Comparable<? super E>>
// old: <E extends Comparable<E>>
//		Stu					Stu
public interface SortedList<E extends Comparable<E>> extends List<E> {
}
