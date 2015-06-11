package patterns.decoratorCoffee;

public class App {

	public static void main(String[] args) {
		Coffee coffee = new MilkDecorator(new BlackCoffee());

	}

}
