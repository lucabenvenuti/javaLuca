
public class Item {

	private String name = "";
	
	public void setName(String newName) {
		if(newName != null && !newName.isEmpty())
			name = new String(newName);
		else
			name = "";
		}
	
	public String getName() {
		return name;
	}
	public void printName() {
		System.out.printf("%s%n", name);
	}
///////////////////////////////////////////////////	
	private int quantity = 0;
	
	public void setQuantity(int newQuantity) {
		if(newQuantity != 0)
			quantity = newQuantity;
		else
			quantity = 0;
		}
	
	public int getQuantity() {
		return quantity;
	}
	public void printQuantity() {
		System.out.printf("%d%n", quantity);
	}
////////////////////////////////////////////////////	
	private float price = 0;
	
	public void setPrice(float newPrice) {
		if(newPrice != 0)
			price = newPrice;
		else
			price = 0;
		}
	
	public float getPrice() {
		return price;
	}
	public void printPrice() {
		System.out.printf("%f%n", price);
	}
///////////////////////////////////////////////////	
	private float totalPriceItem = 0;

	public void setTotalPriceItem() {
		if(getQuantity() == 0 || getPrice()==0 || getPrice()*getQuantity()<=0)
			totalPriceItem = 0;
		else
			totalPriceItem = getPrice()*getQuantity();//getQuantity()*getPrice();
		}
	
	public float getTotalPriceItem() {
		if(totalPriceItem<1){
			setTotalPriceItem();
		}
		return totalPriceItem;
	}
	public void printTotalPriceItem() {
		System.out.printf("%f%n", totalPriceItem);
	}
	
}
