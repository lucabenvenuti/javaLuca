package pizza.c_abstractFactory;

import pizza.dishes.Pizza;
import pizza.dishes.Spaghetti;

/**
 * Implementation of a pizza store using the design pattern "abstract factory"
 */
public class PizzaStore {
	
	private AbstractStyleFactory factory;

	public PizzaStore(AbstractStyleFactory factory) {
		this.factory = factory;
	}

	public Pizza orderPizza() {
		Pizza pizza = factory.createPizza();

		pizza.prepare();
		pizza.bake();
		pizza.box();
		return pizza;
	}

	public Spaghetti orderSpaghetti() {
		Spaghetti spaghetti = factory.createSpaghetti();

		spaghetti.cook();
		return spaghetti;
	}

	public void setFactory(AbstractStyleFactory factory) {
		this.factory = factory;
	}
	
}
