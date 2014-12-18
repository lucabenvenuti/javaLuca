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
