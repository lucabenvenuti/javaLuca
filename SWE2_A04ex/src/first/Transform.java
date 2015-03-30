package first;

import java.util.function.Consumer;
import java.util.function.Function;

import second.Receiver;

/**
 * Transform.java
 *
 * A {@link Transform} is a generic class which implements a Receiver interface;
 * next Receiver can be set after instantiation. The remaining fields
 * (Function<A, B> function, Consumer<A> onReceive, Consumer<B> onSend) are for
 * the high level method receive(A a).
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 * 
 * @param <A>
 * @param <B>
 */
public class Transform<A, B> implements Receiver<A> {

	private Receiver<B> next;

	private final Consumer<A> onReceive;
	private final Function<A, B> function;
	private final Consumer<B> onSend;

	/**
	 * @param function
	 * @param onReceive
	 * @param onSend
	 */
	public Transform(Function<A, B> function, Consumer<A> onReceive,
			Consumer<B> onSend) {
		this.onReceive = onReceive;
		this.function = function;
		this.onSend = onSend;
	}

	/**
	 * @param next
	 */
	public void setNext(Receiver<B> next) {
		this.next = next;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see second.Receiver#receive(java.lang.Object) B b = function.apply(a)
	 *      applies the function and return a new type. next.receive(b) passes
	 *      the new type to the whatEver component
	 */
	@Override
	public void receive(A a) {
		onReceive.accept(a);
		B b = function.apply(a);
		onSend.accept(b);
		if (next != null) {
			next.receive(b);
		}

	}

}
