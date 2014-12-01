
public class ShoppingListTest {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s01 = "======= Your Shopping List =======";
		String s02 = "What would you like to do?";
		
		String s11 = "1. Add an Item to the Shopping List";
		String s12 = "2. Remove an Item from the Shopping List";
		String s13 = "3. Clear the Shopping List";
		String s14 = "4. Show the total amount to Pay";
		String s15 = "5. Print the Invoice";
		String s16 = "q. To Quit";
		
		String s21 = "Choose an option from above:";
		String s22 = "Name:";
		String s23 = "Quantity:";
		String s24 = "Price:";
		String s25 = "The Item ";
		String s26 = " was added in your Shopping List.";
		String s27 = "The quantity of ";
		String s28 = " in your Shopping List has been updated.";
		
		
		System.out.printf("%s%n", s01);
		Item[] shoppingList1 = new Item[ShoppingList.MAXIMALNUMBEROFELEMENTS];
        //step2 : now create objects in a loop.
        for(int i=0; i<shoppingList1.length; i++){
        	shoppingList1[i] = new Item();//this will call constructor.
        }
        
		ShoppingList shoppingListHandler = new ShoppingList();
		shoppingListHandler.setShoppingIndex(shoppingList1.length); 
		shoppingListHandler.exportArrayItem(shoppingList1);
		
		
		//option 1
	//	System.out.println(shoppingListHandler.getTotalItems());
		int adder = shoppingListHandler.getTotalItems();
		shoppingList1[adder].setName(Input.readString());
		shoppingList1[adder].setQuantity(Input.readInt());
		shoppingList1[adder].setPrice(Input.readFloat());
		String s31 = s25 + shoppingList1[adder].getName()+ s26;
		System.out.printf("%s%n", s31);
		
/*       shoppingList1[0].setName(Input.readString());
        shoppingList1[0].setPrice(250);
        shoppingList1[0].setQuantity(3);*/
        shoppingList1[1].setName("fish");
        shoppingList1[1].setQuantity(10);
        shoppingList1[1].setPrice(4);
//        shoppingList1[2].setPrice(5);
        shoppingList1[1].setTotalPriceItem();
	/*	System.out.println("trota");
		System.out.println(shoppingListHandler.getTotalItems());
		System.out.println("trota");*/
       // shoppingListHandler.removeItem("fish");
        //shoppingListHandler.removeItem("meat");
        
   /*     String a1 = Input.readString();
        String a2 = Input.readString();
        
        if(a1.equals("exit")){
        	System.out.println("trotaculo");
        }*/
		
		/*	Item[] head = new Item()[10];
			head.setName("fish");
			head.next.setName("meat");
			head.next.setName(null);
			
			if (Item.isInList(head, "fish"))*/
		//		System.out.println(shoppingList1[1].getName());
		//		System.out.println(shoppingList1[1].getQuantity());
				
// = null;
			//	shoppingListHandler.clear(shoppingList1);
				
		//		shoppingList1[1].printTotalPriceItem();
				shoppingListHandler.calculateSubTotalPrice();//shoppingList1);
		//		System.out.println(shoppingListHandler.getSubTotalPrice());
				shoppingListHandler.calculateSalesPercentage();
		//		System.out.println(shoppingListHandler.getSalesPercentage());
				//otalAfterSale
				shoppingListHandler.calculateTotalAfterSale();
			//	System.out.println(shoppingListHandler.getTotalAfterSale());
				//getTotalItems(Item[] arrayItem)
			//	System.out.println(shoppingListHandler.getTotalItems());//(shoppingList1));
			//	System.out.println(shoppingListHandler.getTotalItems());//(shoppingList1));
			//	System.out.println(shoppingListHandler.getTotalItems(shoppingList1)+1);
				shoppingListHandler.printInvoice();
				
	}

}
