package first;

import java.util.function.Consumer;

import second.Receiver;

/**
 * Sink.java
 *
 * A {@link Sink} is a generic class which implements a Receiver interface;
 * next Receiver can be set after instantiation.
 * The remaining field (Consumer<A> onReceive) 
 * are for the high level method receive(A a).
 * 
 * Software Development II, 2015SS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 * 
 * @param <A>
 */
public final class Sink<A> implements Receiver<A> {

	private Receiver<A> next;

	private final Consumer<A> onReceive;

	/**
	 * @param onReceive
	 */
	public Sink(Consumer<A> onReceive) {
		this.onReceive = onReceive;
	}

	/**
	 * @param next
	 */
	public void setNext(Receiver<A> next) {
		this.next = next;
	}

	/** (non-Javadoc)
	 * @see second.Receiver#receive(java.lang.Object)
	 * next.receive(a) passes the value to the whatEver component
	 */
	@Override
	public void receive(A a) {
		onReceive.accept(a);
		if (next != null) {
			next.receive(a);
		}

	}

}
