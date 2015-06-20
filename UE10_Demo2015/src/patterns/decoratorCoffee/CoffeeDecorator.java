package patterns.decoratorCoffee;

public abstract class CoffeeDecorator implements Coffee{

	@Override
	public String getIncre() {
		// TODO Auto-generated method stub
		return next;
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	private final Coffee next;

	public CoffeeDecorator(Coffee next) {
		super();
		this.next = next;
	}
	
	
	
}
