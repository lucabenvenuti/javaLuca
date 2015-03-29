package test;

import java.util.function.Consumer;

import first.Receiver;

public class Sink<A> {

	private final Receiver<A> getter;
	private final Consumer<A> user;



    public Sink(Receiver<A> getter, 
			Consumer<A> user) {
		//super();
		this.getter = getter;
		this.user = user;
	}



	
	public void multiply(A a) {
		getter.receive(a);
		user.accept(a);
		
	}
	
}
