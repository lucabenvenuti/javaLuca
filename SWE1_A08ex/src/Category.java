public class Category {
	
	private char symbol;
	private int price;
	
	public static final int PRICEA=8;
	public static final int PRICEB=10;
	public static final int PRICEC=11;
	public static final int PRICED=20;
	
	public Category(char symbol){
		setSymbol(symbol);
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol){
		this.symbol = symbol;
		setPrice(symbol);		
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(char symbol) {
		switch(symbol){
		case 'A': price= PRICEA;break;
		case 'B': price= PRICEB;break;
		case 'C': price= PRICEC;break;
		case 'D': price= PRICED;break;
		default: price= 0;
		}
	}

}
