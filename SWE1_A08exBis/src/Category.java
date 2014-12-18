/**
 * Category.java
 *
 * A {@link Category} is a class which holds the symbol and the price
 * of a ScreenRow
 * 
 * Software Development I, 2014WS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 * 
 * @version 2014-12-18
 */
public class Category {

	private char symbol;
	private int price;

	/**
	 * @param price
	 * @param symbol
	 */
	public Category(int price, char symbol) {
		super();
		this.price = price;
		this.symbol = symbol;
	}

	/**
	 * @return
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @return
	 */
	public char getSymbol() {
		return symbol;
	}
}
