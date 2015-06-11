package patterns.decoratorCoffee;

public class BlackCoffee implements Coffee {

	//public final Coffee next;
	
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
