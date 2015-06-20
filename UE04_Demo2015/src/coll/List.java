package coll;

public interface List<E> extends Iterable<E> {
	
	public int size(); 
	
	public boolean contains(Object obj); 
	
	public boolean add(E elem); 
	
	public boolean addAll(Iterable<? extends E> elems); 
	
	public boolean containsAll(Iterable<?> c); 
	
	public E[] toEArray(); 
	
	public Object[] toArray(); 
	
	public <T> T[] toArray(T[] a); 
	
}
