package patterns.decoratorCoffee2;

public class BlackCoffee implements Coffee {

	//private final Coffee next;
	private String text;
	private int price = 5;
	

	
	public BlackCoffee() {
		super();
		//this.next = next;
		this.text = "Black";
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return text;
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
	
	public void appendLine(String line) {
		text = text + line + "\n";
	}

}
