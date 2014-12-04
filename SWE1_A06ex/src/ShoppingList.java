import java.util.Arrays;


public class ShoppingList {
	
	public final static int MAXIMALNUMBEROFELEMENTS = 10;
	
	public final static String EURO = "\u20AC";
	
	public final static String S1  = "-----------------------------------------------------";
	public final static String S2  = "|*********************INVOICE***********************|";
	public final static String S3  = "|Nr  Product                Quantity           Price|";
	public final static String S4  = "|                                                   |"; 
	public final static String S9  = "|                          Sale (%):";
	public final static String S33 = "|                          SubTotal:";
	
	public final static String S01 = "======= Your Shopping List =======";
	public final static String S02 = "What would you like to do?";
	
	public final static String S11 = "1. Add an Item to the Shopping List";
	public final static String S12 = "2. Remove an Item from the Shopping List";
	public final static String S13 = "3. Clear the Shopping List";
	public final static String S14 = "4. Show the total amount to Pay";
	public final static String S15 = "5. Print the Invoice";
	public final static String S16 = "q. To Quit";
	
	public final static String S21 = "Choose an option from above: ";
	public final static String S22 = "Name: ";
	public final static String S23 = "Quantity: ";
	public final static String S24 = "Price: ";
	public final static String S25 = "The Item ";
	public final static String S26 = " was added in your Shopping List.";
	public final static String S27 = "The quantity of ";
	public final static String S28 = " in your Shopping List has been updated.";
	public final static String S29 = "The total Amount to be paid is: ";
	public final static String S30 = "Goodbye!"; 
	public final static String S31 = "Invalid inputs"; 
	public final static String S32 = " was not available in your Shopping List.";

/////////////////////////////////////////////////////////////////////////////////////	/
	private Item[] arrayItem2 = new Item[MAXIMALNUMBEROFELEMENTS];
	
	public void exportArrayItem(Item[] arrayItem){
		arrayItem2 = arrayItem;
		
	}
	
	public Item[] getArrayItem(){
		return arrayItem2;
		
	}
	
	public void setSingleArrayItem(int i, Item newItem){
		arrayItem2[i]=newItem;		
	}
/////////////////////////////////////////////////////////////////////////////////////////	
	
	
	public String obtain2DecimalsStringOfTotalAfterSale(){
		getTotalAfterSale();
		double number = 0.0;
		if (getTotalItems()==0){}
		else {number =  Math.round(getTotalAfterSale() * 100);}
		number = number/100;
		String s51 = Double.toString(number);
		return s51;
	}
	
	public String obtain2DecimalsStringOfTotalAfterSale(float price){
		String total2;
		double number2 =  Math.round(price * 100);
		number2 = number2/100;
		total2 = Double.toString(number2);
		return total2;
	}
	
	//
////////////////////////////////////////////////////////////////////////////////////////	
	
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
	
///////////////////////////////////////////////////////////////////////////////////////////	
	private double subtotalprice = 0.0;
	
	public double getSubTotalPrice(){
					calculateSubTotalPrice();
		return subtotalprice;
	}
	
	public void calculateSubTotalPrice(){
		subtotalprice = 0.0;
		for(int i=0; i<getArrayItem().length; i++){
			subtotalprice = subtotalprice + getArrayItem()[i].getTotalPriceItem();
			}
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////	
	private double salesPercentage = 0.0;
		
	public double getSalesPercentage(){
	//	if (salesPercentage<0.01){
			calculateSalesPercentage();
		//}
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
//////////////////////////////////////////////////////////////////////////////////////////////	
	private double totalAfterSale = 0.0;
	
	public void calculateTotalAfterSale(){
		totalAfterSale = getSubTotalPrice() * (1.0 - getSalesPercentage());
		
	}

	public double getTotalAfterSale(){
			calculateTotalAfterSale();
		return totalAfterSale;
	}
	
	public void printTotalAfterSale(){

		String s33 = ShoppingList.S29 + obtain2DecimalsStringOfTotalAfterSale() + EURO;
		System.out.printf("%s%n", s33);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////
	private int totalItems = 0;
	
	public int getTotalItems(){
		totalItems = 0;
		for(int i=0; i<getArrayItem().length; i++){
			
			if(getArrayItem()[i].getName() != null && !getArrayItem()[i].getName().isEmpty()){
				totalItems = totalItems + 1;
			}
			} return totalItems;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////
	public void clear(){
		for(int i=0; i<getArrayItem().length; i++){
			getArrayItem()[i]=new Item();}}
	
/////////////////////////////////////////////////////////////////////////////////////////////////	
	public void addItem(Item newItem){
		boolean isANewItem = true;
		int position = 0;
		int temp = 0;
		for(int i=0; i<getArrayItem().length; i++){
			if (getArrayItem()[i].getName().equals(newItem.getName())){
				isANewItem = false;
				position = i;
				break;
			}}

			if (isANewItem){
				setSingleArrayItem(getTotalItems(),newItem);
				String s31 = ShoppingList.S25 + newItem.getName()+ ShoppingList.S26;
				System.out.printf("%s%n", s31);
			} //I give the new item to the first free position
			else{
				if (getArrayItem()[position].getName().equals(newItem.getName())){ //double check
					temp = getArrayItem()[position].getQuantity();
					getArrayItem()[position].setQuantity(temp + newItem.getQuantity());
					String s31 = ShoppingList.S25 + newItem.getName()+ ShoppingList.S28;
					System.out.printf("%s%n", s31);
				}
			}
			getTotalItems();
			calculateTotalAfterSale();	
	}


//////////////////////////////////////////////////////////////////////////////////////////////	
	public void removeItem(String name){
		int position =0;
		int total = getTotalItems();
		boolean willDelete = false;
		for(int i=0; i<total; i++){
			if (getArrayItem()[i].getName().equals(name)){
				willDelete = true;
				position =i;
				break;
			}
		}
		getArrayItem()[position].getQuantity();
		String s31 = "";
		if (willDelete && getArrayItem()[position].getQuantity()==1){
			for(int i=position; i<(total); i++){				
			setSingleArrayItem(i,getArrayItem()[i+1]);
				}
			setSingleArrayItem(total, new Item());
		s31 = ShoppingList.S25 + name+ ShoppingList.S28;
		}
		else if (willDelete && getArrayItem()[position].getQuantity()>1){getArrayItem()[position].setQuantity(getArrayItem()[position].getQuantity()-1);
			s31 = ShoppingList.S25 + name+ ShoppingList.S28;}
		else {s31 = ShoppingList.S25 + name+ ShoppingList.S32;}
			System.out.printf("%s%n", s31);
		getTotalItems();
	}

/////////////////////////////////////////////////////////////////////////////////////////////////	
	public void printInvoice(){
		calculateSalesPercentage();
		for(int i=0; i<(getTotalItems()); i++){
			getArrayItem()[i].setTotalPriceItem();}
		
		String s5 = "";
		String s6 = "";
		String s7 = "";
		String s8 = "";
		int counter = 0;
		
		int counter2 =0;
		if(getSalesPercentage()>0.09){counter2 = 14;}
		else{counter2=15;}
		char[] chars3 = new char[counter2];
		Arrays.fill(chars3, ' ');
		String s12 = new String(chars3);
		
		String s10 =(int)(getSalesPercentage()*100) + "|";
		String s11 = S9+s12+s10;
		
		char[] chars4 = new char[14-obtain2DecimalsStringOfTotalAfterSale().length()];
		Arrays.fill(chars4, ' ');
		String s16  = new String(chars4);
		String s15 = S33 + s16 + obtain2DecimalsStringOfTotalAfterSale() + " " + EURO  + "|"; 
		String total2;
		if (getTotalItems()==0){s5 = S4;}
		else {s5 = S3;
			for(int i=0; i<(getTotalItems()); i++){
				s6 = "";
				if(i>=8)s7 = "  ";
				else s7 = "   ";
				if(getArrayItem()[i].getQuantity()>9)counter = 29;
				else counter = 30;
				char[] chars = new char[counter-getArrayItem()[i].getName().length()];
				Arrays.fill(chars, ' ');
				s6 = new String(chars);
				
				total2 = obtain2DecimalsStringOfTotalAfterSale(getArrayItem()[i].getTotalPriceItem());
				char[] chars2 = new char[14-total2.length()];
				Arrays.fill(chars2, ' ');
				s8 = new String(chars2);
				s5 = s5 + "\n" + "|" + (i+1) + s7 + getArrayItem()[i].getName() + s6 + getArrayItem()[i].getQuantity() 
						+  s8 + total2 + " " + EURO + "|";
				s6 = "";
			}
			}
		System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n", S1, S2, S1, s5, S1, s11, s15, S1);
	}
}
