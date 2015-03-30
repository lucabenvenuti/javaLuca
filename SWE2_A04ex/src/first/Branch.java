package first;

import java.util.function.Consumer;
import java.util.function.Predicate;

import second.Receiver;

/**
 * Branch.java
 *
 * A {@link Branch} is a generic class which implements a Receiver interface;
 * left, right or both Receivers can be set after instantiation.
 * The remaining fields (Consumer<A> onReceive, Predicate<A> predicate, Consumer<A> onSend) 
 * are for the high level method receive(A a).
 * 
 * Software Development II, 2015SS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 * 
 * @param <A>
 */
public class Branch<A> implements Receiver<A> {

	private Receiver<A> left;
	private Receiver<A> right;

	private final Consumer<A> onReceive;
	private final Predicate<A> predicate;
	private final Consumer<A> onSend;

	/**
	 * @param onReceive
	 * @param predicate
	 * @param onSend
	 */
	public Branch(Consumer<A> onReceive, Predicate<A> predicate,
			Consumer<A> onSend) {
		this.onReceive = onReceive;
		this.predicate = predicate;
		this.onSend = onSend;
	}

	/**
	 * @param left
	 * @param right
	 */
	public void SetLeftRight(Receiver<A> left, Receiver<A> right) {
		setLeft(left);
		setRight(right);
	}

	/**
	 * @param left
	 */
	public void setLeft(Receiver<A> left) {
		this.left = left;
	}

	/**
	 * @param right
	 */
	public void setRight(Receiver<A> right) {
		this.right = right;
	}

	/** (non-Javadoc)
	 * @see second.Receiver#receive(java.lang.Object).
	 * predicate.test(a)) applies the filter function.
	 * left.receive(a) passes the value to the whatEver left component
	 * right.receive(a) passes the value to the whatEver right component
	 */
	@Override
	public void receive(A a) {
		onReceive.accept(a);
		onSend.accept(a);
		if (predicate.test(a)) {
			if (left != null) {
				left.receive(a); 
			}
		} else {
			if (right != null) {
				right.receive(a); 
			}
		}
	}

}
