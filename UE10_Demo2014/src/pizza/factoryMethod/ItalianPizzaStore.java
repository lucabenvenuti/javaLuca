package pizza.factoryMethod; // since these methods only produces objects

import pizza.dishes.ItalianPizza;
import pizza.dishes.Pizza;
import pizza.dishes.Spaghetti;

public class ItalianPizzaStore extends PizzaStore {
	
	@Override
	public Pizza createPizza() {
		return new ItalianPizza();
	}

	@Override
	public Spaghetti createSpaghetti() {
		return new Spaghetti("italian");
	}
}
