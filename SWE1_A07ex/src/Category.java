
public class Category {
	
	private char symbol;
	private double price;
	
	
	public static final double priceA=24.0;
	public static final double priceB=30.0;
	public static final double priceC=33.0;
	
	public Category(char symbol){
		this.symbol = symbol;
		this.setPrice(symbol);
	}

	/**
	 * @return the symbol
	 */
	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol){
		this.symbol = symbol;
		this.setPrice(symbol);		
	}
	
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(char symbol) {
		switch(symbol){
		case 'A': this.price= priceA;break;
		case 'B': this.price= priceB;break;
		case 'C': this.price= priceC;break;
		default: this.price= 0.0;
		}
	}

}
