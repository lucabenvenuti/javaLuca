
public class Category {
	
	private double price;
	private char symbol;
	
	public Category(char symbol){
		this.symbol = symbol;
	}

	public Category(double price){
		this.price = price;
	}
	
	public Category(char symbol, double price){
		this(symbol);
		this.price = price;
	}
	
	public Category(double price, char symbol){
		this(price);
		this.symbol = symbol;
	}
}
