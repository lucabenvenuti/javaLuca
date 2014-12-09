
public class Category {
	
	private char symbol;
	private double price;
	
	public static final double PRICEA=8.0;
	public static final double PRICEB=10.0;
	public static final double PRICEC=11.0;
	
	public Category(char symbol){
		setSymbol(symbol);
	}

	/**
	 * @return the symbol
	 */
	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol){
		this.symbol = symbol;
		setPrice(symbol);		
	}
	
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	public void setPrice(char symbol) {
		switch(symbol){
		case 'A': price= PRICEA;break;
		case 'B': price= PRICEB;break;
		case 'C': price= PRICEC;break;
		default: price= 0.0;
		}
	}

}
