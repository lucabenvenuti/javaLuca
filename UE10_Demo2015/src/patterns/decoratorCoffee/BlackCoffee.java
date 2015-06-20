package patterns.decoratorCoffee;

public class BlackCoffee implements Coffee {

	private final Coffee next;
	
	public BlackCoffee(Coffee next) {
		super();
		this.next = next;
	}

	@Override
	public String getIncre() {
		// TODO Auto-generated method stub
		return "Black";
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 5;
	}

}
