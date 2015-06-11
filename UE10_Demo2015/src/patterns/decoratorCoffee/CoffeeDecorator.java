package patterns.decoratorCoffee;

public abstract class CoffeeDecorator implements Coffee{

	private final Coffee next;

	public CoffeeDecorator(Coffee next) {
		super();
		this.next = next;
	}
	
	
	
}
