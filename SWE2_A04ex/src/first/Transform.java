package first;

import java.util.function.Consumer;
import java.util.function.Function;
//import java.util.function.Predicate;
import java.util.function.Supplier;

//import test.Transformer;

public final class Transform<A, B> {

	//private Receiver<A> onReceive;
	private final Supplier<A> getter;
	private final Function<A, B> processor;
	private final Consumer<B> user;



    public Transform(Supplier<A> getter, Function<A, B> processor,
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
		A a = getter.get();
		B b = processor.apply(a);
		user.accept(b);
		
	}
	
/*	static public <A, B> void doGetTestProcessUse(
			Supplier<A> getter, 
			Predicate<A> condition, 
			Function<A, B> processor, 
			Consumer<B> user) {
		A a = getter.get(); 
		if (condition.test(a)) {
			B b = processor.apply(a); 
			user.accept(b); 
		}
	}*/
	
	/*Function<Float, Float> processor = new Function<Float, Float>() {
		@Override
		public Float apply(Float i) {
			return i*10; 
		} 
		
	};*/
	
/*	Function<Float, Float> multiply2 = f -> {
		if (f == null) return (float) 0; 
		else return f.floatValue();//*10; 
	};*/
	
}
