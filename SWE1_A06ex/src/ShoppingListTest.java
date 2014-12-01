
public class ShoppingListTest {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Item[] shoppingList1 = new Item[ShoppingList.MAXIMALNUMBEROFELEMENTS];
        //step2 : now create objects in a loop.
        for(int i=0; i<shoppingList1.length; i++){
        	shoppingList1[i] = new Item();//this will call constructor.
        }
        
		ShoppingList shoppingListHandler = new ShoppingList();
		shoppingListHandler.setShoppingIndex(shoppingList1.length); 
		shoppingListHandler.exportArrayItem(shoppingList1);
		
		
  /*      shoppingList1[0].setName("meat");
        shoppingList1[0].setPrice(5);
        shoppingList1[0].setQuantity(3);
        shoppingList1[1].setName("fish");
        shoppingList1[1].setQuantity(10);
        shoppingList1[1].setPrice(4);
        shoppingList1[2].setPrice(500);
        shoppingList1[1].setTotalPriceItem();
        
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
				System.out.println(shoppingListHandler.getSubTotalPrice());
				shoppingListHandler.calculateSalesPercentage();
				System.out.println(shoppingListHandler.getSalesPercentage());
				//otalAfterSale
				shoppingListHandler.calculateTotalAfterSale();
				System.out.println(shoppingListHandler.getTotalAfterSale());
				//getTotalItems(Item[] arrayItem)
				System.out.println(shoppingListHandler.getTotalItems());//(shoppingList1));
				System.out.println(shoppingListHandler.getTotalItems());//(shoppingList1));
			//	System.out.println(shoppingListHandler.getTotalItems(shoppingList1)+1);
				
	}

}
