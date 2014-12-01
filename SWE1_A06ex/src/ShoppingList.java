
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
		subtotalprice = 0.0;
		for(int i=0; i<arrayItem.length; i++){
			subtotalprice = subtotalprice + arrayItem[i].getPrice();
			}
	}
	
	
	private double salesPercentage = 0.0;
		
	public double getSalesPercentage(){
		
		return salesPercentage;
	}

	public void calculateSalesPercentage(){
		if (getSubTotalPrice()>=1000.0){
			salesPercentage = 15.0/100.0;
		} else if (getSubTotalPrice()>=500.0){
			salesPercentage = 10.0/100.0;
		} else if (getSubTotalPrice()>=100.0){
			salesPercentage = 5.0/100.0;
		} else {
			salesPercentage = 0.0;
		}
	}
	
	private double totalAfterSale = 0.0;
	
	public void calculateTotalAfterSale(){
		totalAfterSale = subtotalprice * (1.0 - salesPercentage);
		
	}

	public double getTotalAfterSale(){
		
		return totalAfterSale;
	}
	
	private int totalItems = 0;
	
	public int getTotalItems(Item[] arrayItem){
		totalItems = 0;
		for(int i=0; i<arrayItem.length; i++){
			
			if(arrayItem[i].getName() != null && !arrayItem[i].getName().isEmpty()){
				totalItems = totalItems + 1;
			}
			} return totalItems;
	}
	
	public void clear(Item[] arrayItem){
		//totalItems = 0;
		for(int i=0; i<arrayItem.length; i++){
			arrayItem[i]=new Item();}
		/*	if(arrayItem[i].getName() != null && !arrayItem[i].getName().isEmpty()){
				totalItems = totalItems + 1;
			}*/
			 //return totalItems;
	}
	
//	Returns the sum of all items of your shopping list. //Item[] arrayItem
	
	
	
}
