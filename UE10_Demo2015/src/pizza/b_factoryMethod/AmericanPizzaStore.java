package pizza.b_factoryMethod;

import pizza.dishes.AmericanPizza;
import pizza.dishes.Pizza;
import pizza.dishes.Spaghetti;

public class AmericanPizzaStore extends PizzaStore {
	
	@Override
	public Pizza createPizza() {
		return new AmericanPizza();
	}

	@Override
	public Spaghetti createSpaghetti() {
		return new Spaghetti("american");
	}
}
