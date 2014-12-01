
public class Item {
	//trotaculo

	// name of the person
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
		System.out.println(name);
	}
	
	
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
		System.out.println(quantity);
	}
	
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
		System.out.println(price);
	}
	
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
		System.out.println(totalPriceItem);
	}
	
	
	
	
	
}






	// returns true if the person with the specified name is in the list.
	// the list is started by head. 
/*	public static boolean isInList(Item newHead, String newName) {
		Item search = newHead;
		while (search != null && !search.name.equals(newName)) search = search.next;
		return search != null;
	}
	
	// append a person after this person, or insert, if there is already one
	public void appendOne(Item p) {
		p.next = this.next;
		this.next = p;
	}*/
	
/*	int eno;

public void Emp(int no){
       eno = no;
       System.out.println("emp constructor called..eno is.."+eno);
   }
// next node in list; null if end of list
/*	public Item next;*/

