public class Category {
	
	private char symbol;
	private int price;
	
	public Category(int price, char symbol) {
		super();
		this.price = price;
		this.symbol = symbol;
	}

	public int getPrice() {
		return price;
	}

	public char getSymbol() {
		return symbol;
	}
}
