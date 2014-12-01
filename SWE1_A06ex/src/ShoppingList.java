
public class ShoppingList {
	public final static int MAXIMALNUMBEROFELEMENTS = 10;
	
	private Item[] arrayItem2 = new Item[MAXIMALNUMBEROFELEMENTS];
	
	public void exportArrayItem(Item[] arrayItem){
		arrayItem2 = arrayItem;
		
	}
	
	public Item[] getArrayItem(){
		return arrayItem2;
		
	}
	
	public void setSingleArrayItem(int i, Item newItem){
	//	return arrayItem2;
		arrayItem2[i]=newItem;
		
	}
	
	/*public void setQuantity(int newQuantity) {
		if(newQuantity != 0)
			quantity = newQuantity;
		else
			quantity = 0;
		}*/
	
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
	
	public void calculateSubTotalPrice(){//(Item[] arrayItem){
		subtotalprice = 0.0;
		for(int i=0; i<getArrayItem().length; i++){
			subtotalprice = subtotalprice + getArrayItem()[i].getPrice();
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
	
	public int getTotalItems(){//(Item[] arrayItem){
		totalItems = 0;
		for(int i=0; i<getArrayItem().length; i++){
			
			if(getArrayItem()[i].getName() != null && !getArrayItem()[i].getName().isEmpty()){
				totalItems = totalItems + 1;
			}
			} return totalItems;
	}
	
	public void clear(){//(Item[] arrayItem){
		//totalItems = 0;
		for(int i=0; i<getArrayItem().length; i++){
			getArrayItem()[i]=new Item();}}
	
		/*	if(arrayItem[i].getName() != null && !arrayItem[i].getName().isEmpty()){
				totalItems = totalItems + 1;
			}*/
			 //return totalItems;
	
	public void addItem(Item newItem){
		//getTotalItems()
	//	newItem.setName(newName);
		boolean isANewItem = true;
		for(int i=0; i<getArrayItem().length; i++){
			if (getArrayItem()[i].getName()==newItem.getName()){
				isANewItem = false;
				break;
			}
			
		//	getArrayItem()[i]=new Item();
			if (isANewItem){
				setSingleArrayItem(getTotalItems(),newItem);} //I give the new item to the first free position
			getTotalItems();								 // arrays in java starts from zero
			}
		}
//	Returns the sum of all items of your shopping list. //Item[] arrayItem
	
	public void removeItem(String name){
		int position =0;
		boolean willDelete = false;
		for(int i=0; i<getArrayItem().length; i++){
			if (getArrayItem()[i].getName().equals(name)){
				willDelete = true;
				position =i;
				break;
				
			}
			
		}
		if (willDelete){
			for(int i=position; i<(getArrayItem().length-1); i++){
				//setSingleArrayItem(int i, Item newItem)
			setSingleArrayItem(i,getArrayItem()[i-1]);}
			getArrayItem()[getArrayItem().length]=new Item();
		}
		
		
	}

	
	
	
	
	
	
	
	
	
}
