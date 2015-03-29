package first;

import java.util.function.Consumer;
import java.util.function.Function;
//import java.util.function.Predicate;
import java.util.function.Supplier;

//import test.Transformer;

public final class Transform<A, B> {

	//private Receiver<A> onReceive;
	private final Receiver<A> getter;
	private final Function<A, B> processor;
	private final Consumer<B> user;



    public Transform(Receiver<A> getter, Function<A, B> processor,
			Consumer<B> user) {
		//super();
		this.getter = getter;
		this.processor = processor;
		this.user = user;
	}



/*	public void setNext(Receiver<A> next) {
		this.next = next;
	}*/
	
	
	public void multiply() {
		getter.receive(a);
		B b = processor.apply(a);
		user.accept(b);
		
	}
	
	Function<Float, Float> processor2 = new Function<Float, Float>() {
		@Override
		public Float apply(Float i) {
			return i*10; 
		} 
		
	};
	
/*	Function<Float, Float> multiply2 = f -> {
		if (f == null) return (float) 0; 
		else return f.floatValue();//*10; 
	};*/
	
}
