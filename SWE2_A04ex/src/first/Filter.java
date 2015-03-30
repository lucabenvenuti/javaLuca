package first;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Filter<A> implements Receiver<A> {

	private Receiver<A> next;

	private final Consumer<A> onReceive;
	private final Predicate<A> predicate;
	private final Consumer<A> onSend;

	public Filter(Consumer<A> onReceive, Predicate<A> predicate,
			Consumer<A> onSend) {
		super();
		this.onReceive = onReceive;
		this.predicate = predicate;
		this.onSend = onSend;
	}


	public void setNext(Receiver<A> next) {
		this.next = next;
	}
	
	
	@Override
	public void receive(A a) {
		onReceive.accept(a);
		if (predicate.test(a)) { // apply the filter function
			onSend.accept(a);
			if (next != null) {
				next.receive(a); // pass the value to the whatEver component
			}

		}
	}

}
