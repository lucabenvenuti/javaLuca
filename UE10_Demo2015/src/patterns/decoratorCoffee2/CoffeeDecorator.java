package patterns.decoratorCoffee2;

/**
 * Base class for all decorators of letters.
 */
abstract public class CoffeeDecorator implements Coffee {

	private final Coffee next;

	/**
	 * Constructor.
	 * 
	 * @param next
	 *            the next letter object, which is either the concrete letter or the next decorator.
	 */
	public CoffeeDecorator(Coffee next) {
		this.next = next;
	}

	@Override
	public String getText() {
		return next.getText();
	}

	@Override
	public int getPrice() {
		return next.getPrice();
	}
}
