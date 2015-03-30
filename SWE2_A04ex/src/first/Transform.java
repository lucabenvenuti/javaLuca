package first;

import java.util.function.Consumer;
import java.util.function.Function;

public class Transform<A, B> implements Receiver<A> {

	private Receiver<B> next;

	private final Consumer<A> onReceive;
	private final Function<A, B> function;
	private final Consumer<B> onSend;

	public Transform(Function<A, B> function, Consumer<A> onReceive,
			Consumer<B> onSend) {
		this.onReceive = onReceive;
		this.function = function;
		this.onSend = onSend;
	}

	public void setNext(Receiver<B> next) {
		this.next = next;
	}
	
	
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
