package patterns.decoratorCoffee2;

/**
 * Abstract base class for the letterComponent and the decorators
 */
public interface Coffee {

	/**
	 * Gets the letter text.
	 * 
	 * @return the text of the letter.
	 */
	abstract public String getText();
	
	abstract public int getPrice();

}
