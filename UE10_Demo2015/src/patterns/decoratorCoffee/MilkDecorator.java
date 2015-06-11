package patterns.decoratorCoffee;

public class MilkDecorator extends CoffeeDecorator {
	
	private final Coffee next;

	public MilkDecorator(Coffee next) {
		this.next = next;
	}

	@Override
	public String getIncre() {
		// TODO Auto-generated method stub
		return super.;
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

}
