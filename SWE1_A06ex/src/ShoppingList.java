
public class ShoppingList {
	public final static int MAXIMALNUMBEROFELEMENTS = 10;
	
	private int shoppingIndex =0;
	
	public void setShoppingIndex(int newShoppingIndex) {
		if(newShoppingIndex >= 0 && newShoppingIndex <MAXIMALNUMBEROFELEMENTS)
			shoppingIndex = newShoppingIndex;
		else
			shoppingIndex = 0;
		}
	
	public int getShoppingIndex() {
		return shoppingIndex;
	}
	public void printShoppingIndex() {
		System.out.println (shoppingIndex);
	}
	
	
	private double subtotalprice = 0.0;
	
	public double getSubTotalPrice(){
				
		return subtotalprice;
//	Returns the sum of all items of your shopping list. //Item[] arrayItem
	}
	
	public void calculateSubTotalPrice(Item[] arrayItem){
		for(int i=0; i<arrayItem.length; i++){
			subtotalprice = subtotalprice + arrayItem[i].getPrice();
			
		}
		
//	Returns the sum of all items of your shopping list. //Item[] arrayItem
	}
	
	
}
