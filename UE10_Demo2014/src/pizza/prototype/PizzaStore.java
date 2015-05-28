package pizza.prototype;

import java.util.ArrayList;
import java.util.List;

import pizza.dishes.Pizza;
import pizza.dishes.Spaghetti;

/**
 * Implementation of a pizza store using the design pattern "prototype"
 */
public class PizzaStore {
	
	private Pizza pizzaPrototype;
	private Spaghetti spaghettiPrototype;
	
	private List<Pizza> menu = new ArrayList<Pizza>(); 

	public PizzaStore(Pizza pizzaPrototype, Spaghetti spaghettiPrototype) {
		menu.add(pizzaPrototype); 
		this.pizzaPrototype = pizzaPrototype;
		this.spaghettiPrototype = spaghettiPrototype;
	}
	
	public void addPizza(Pizza proto) {
		menu.add(proto); 
	}

	public Pizza orderPizza() {
		
		Pizza pizza = pizzaPrototype.clone();

		pizza.prepare();
		pizza.bake();
		pizza.box();
		return pizza;
	}

	public Spaghetti orderSpaghetti() {
		Spaghetti spaghetti = spaghettiPrototype.clone();

		spaghetti.cook();
		return spaghetti;
	}
	
}
