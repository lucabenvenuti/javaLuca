package first;

import java.util.function.Consumer;

public final class Sink<A> implements Receiver<A> {

	private Receiver<A> next;

	private final Consumer<A> onReceive;

	public Sink(Consumer<A> onReceive) {
		this.onReceive = onReceive;
	}

	public void setNext(Receiver<A> next) {
		this.next = next;
	}

	@Override
	public void receive(A a) {
		onReceive.accept(a);
		if (next != null) {
			next.receive(a);
		}

	}

}
