package first;

import java.util.function.Consumer;
import java.util.function.Predicate;

import second.Receiver;

/**
 * Filter.java
 *
 * A {@link Filter} is a generic class which implements a Receiver interface;
 * next Receiver can be set after instantiation.
 * The remaining fields (Consumer<A> onReceive, Predicate<A> predicate,
			Consumer<A> onSend) 
 * are for the high level method receive(A a).
 * 
 * Software Development II, 2015SS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 * 
 * @param <A>
 */
public class Filter<A> implements Receiver<A> {

	private Receiver<A> next;

	private final Consumer<A> onReceive;
	private final Predicate<A> predicate;
	private final Consumer<A> onSend;

	/**
	 * @param onReceive
	 * @param predicate
	 * @param onSend
	 */
	public Filter(Consumer<A> onReceive, Predicate<A> predicate,
			Consumer<A> onSend) {
		this.onReceive = onReceive;
		this.predicate = predicate;
		this.onSend = onSend;
	}


	/**
	 * @param next
	 */
	public void setNext(Receiver<A> next) {
		this.next = next;
	}
	
	
	/** (non-Javadoc)
	 * @see second.Receiver#receive(java.lang.Object)
	 * predicate.test(a)) applies the filter function.
	 * next.receive(a) left.receive(a) passes the value to the whatEver component
	 */
	@Override
	public void receive(A a) {
		onReceive.accept(a);
		if (predicate.test(a)) { 
			onSend.accept(a);
			if (next != null) {
				next.receive(a);
			}

		}
	}

}
