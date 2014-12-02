
public class ShoppingListTest {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		ShoppingList shoppingListHandler = new ShoppingList();
		
		System.out.printf("%s%n", ShoppingList.S01);
		Item[] shoppingList1 = new Item[ShoppingList.MAXIMALNUMBEROFELEMENTS];
        //step2 : now create objects in a loop.
        for(int i=0; i<shoppingList1.length; i++){
        	shoppingList1[i] = new Item();//this will call constructor.
        }
        
		
		shoppingListHandler.setShoppingIndex(shoppingList1.length); 
		shoppingListHandler.exportArrayItem(shoppingList1);
		
		
		//option 1
	//	System.out.println(shoppingListHandler.getTotalItems());
		int adder = shoppingListHandler.getTotalItems();
		shoppingList1[adder].setName(Input.readString());
		shoppingList1[adder].setQuantity(Input.readInt());
		shoppingList1[adder].setPrice(Input.readFloat());

		
/*       shoppingList1[0].setName(Input.readString());
        shoppingList1[0].setPrice(250);
        shoppingList1[0].setQuantity(3);*/
        shoppingList1[1].setName("fish");
        shoppingList1[1].setQuantity(10);
        shoppingList1[1].setPrice(4);
//        shoppingList1[2].setPrice(5);
        
        Item umbrella = new Item();
        umbrella.setName("umbrella");
        umbrella.setQuantity(5);
        umbrella.setPrice(8);
        
        shoppingListHandler.addItem(umbrella);
        
 //       umbrella.setName("umbrella");
        umbrella.setQuantity(5);
        
        shoppingListHandler.addItem(umbrella);
        shoppingListHandler.removeItem("fish");
        
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
