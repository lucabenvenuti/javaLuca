package part7isfunny;

public interface List<E> extends Iterable<E> {

	public int size();

	public boolean contains(Object obj);

	public boolean add(E elem);

}
