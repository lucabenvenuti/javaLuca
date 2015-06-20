package patterns.decoratorCoffee2;

/**
 * Decorator class to add a formal salutation to a letter
 */
public class MilkDecorator extends CoffeeDecorator {

	public MilkDecorator(Coffee next) {
		super(next);
		this.name = " and Milk ";
	}



	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return super.getPrice()+1;
	}



	private String name;



	@Override
	public String getText() {
		return super.getText() + name;
	}
}
