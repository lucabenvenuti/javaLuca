package pizza.b_factoryMethod;

import inout.In;
import inout.Out;
import pizza.dishes.Pizza;
import pizza.dishes.Spaghetti;

public class PizzaTest {
	public static void main(String[] args) {
		
		Out.println("Welcome to the SSW pizza store (implementation using factory method)");
		Out.println("Please select your preferred style:");
		Out.println("1) Italian style");
		Out.println("2) American style");

		PizzaStore pizzaStore;
		switch (In.readInt()) {
		case 1:
			pizzaStore = new ItalianPizzaStore();
			break;
		case 2:
			pizzaStore = new AmericanPizzaStore();
			break;
		default:
			Out.println("invalid input");
			return;
		}

		Pizza pizza = pizzaStore.orderPizza();
		Out.println("ready to eat " + pizza);
		Out.println();

		Spaghetti spaghetti = pizzaStore.orderSpaghetti();
		Out.println("ready to eat " + spaghetti);
		Out.println();
	}
}
