package first;

import java.util.function.Consumer;
import java.util.function.Predicate;

import second.Receiver;

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
		super();
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
	 * @see second.Receiver#receive(java.lang.Object)
	 */
	@Override
	public void receive(A a) {
		onReceive.accept(a);
		onSend.accept(a);
		if (predicate.test(a)) { // apply the filter function
			if (left != null) {
				left.receive(a); // pass the value to the whatEver component
			}
		} else {
			if (right != null) {
				right.receive(a); // pass the value to the whatEver component
			}
		}
	}

}
