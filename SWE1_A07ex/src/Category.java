
public class Category {
	
	private char symbol;
	private double price;
	
	public static final double PRICEA=24.0;
	public static final double PRICEB=30.0;
	public static final double PRICEC=33.0;
	
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
		case 'A': this.price= PRICEA;break;
		case 'B': this.price= PRICEB;break;
		case 'C': this.price= PRICEC;break;
		default: this.price= 0.0;
		}
	}

}
