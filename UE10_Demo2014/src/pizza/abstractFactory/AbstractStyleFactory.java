package pizza.abstractFactory;

import pizza.dishes.Pizza;
import pizza.dishes.Spaghetti;

public abstract class AbstractStyleFactory {
	
	public abstract Pizza createPizza();

	public abstract Spaghetti createSpaghetti();
}
