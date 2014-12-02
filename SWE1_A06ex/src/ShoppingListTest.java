
public class ShoppingListTest {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean go = true;
		ShoppingList shoppingListHandler = new ShoppingList();
		
		System.out.printf("%s%n%n", ShoppingList.S01);
		Item[] shoppingList1 = new Item[ShoppingList.MAXIMALNUMBEROFELEMENTS];
        //step2 : now create objects in a loop.
        for(int i=0; i<shoppingList1.length; i++){
        	shoppingList1[i] = new Item();//this will call constructor.
        }
        
		
		shoppingListHandler.setShoppingIndex(shoppingList1.length); 
		shoppingListHandler.exportArrayItem(shoppingList1);
		
		goCycle: while (go){
			
			System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s%n%n%s", ShoppingList.S02, ShoppingList.S11, 
					ShoppingList.S12,ShoppingList.S13,ShoppingList.S14,ShoppingList.S15,ShoppingList.S16,ShoppingList.S21);
		char keyboardInput = Input.readChar();
		
		switch (keyboardInput){
		case '1': {
		/*	int adder = shoppingListHandler.getTotalItems();
			System.out.println("Name: ");
			shoppingList1[adder].setName(Input.readString());
			System.out.println("Quantity: ");
			shoppingList1[adder].setQuantity(Input.readInt());
			System.out.println("Price: ");
			shoppingList1[adder].setPrice(Input.readFloat());*/
			
	        Item newItemTemp = new Item();
	        System.out.printf("%s", ShoppingList.S22);
	        newItemTemp.setName(Input.readString());
	        System.out.printf("%s", ShoppingList.S23);
	        newItemTemp.setQuantity(Input.readInt());
	        System.out.printf("%s", ShoppingList.S24);
	        newItemTemp.setPrice(Input.readFloat());
	        
	        shoppingListHandler.addItem(newItemTemp);
	        newItemTemp = new Item();
			
			break;}
		case '2': System.out.println("Name: ");shoppingListHandler.removeItem(Input.readString());break;
		case '3': shoppingListHandler.clear();break;
		case '4': shoppingListHandler.printTotalAfterSale();break;
		case '5': shoppingListHandler.printInvoice(); break;
		case 'q':  System.out.printf("%s", ShoppingList.S30);go = false; break goCycle;
		
		}System.out.printf("%n%s%n%n", ShoppingList.S01);
		}
		
		/* System.out.printf("%s%n", ShoppingList.S11);
		 System.out.printf("%s", ShoppingList.S12);
		 System.out.printf("%s", ShoppingList.S13);
		 System.out.printf("%s", ShoppingList.S14);
		 System.out.printf("%s", ShoppingList.S15);
		
		 */
		
	/*	//option 1
	//	System.out.println(shoppingListHandler.getTotalItems());
	/*	int adder = shoppingListHandler.getTotalItems();
		shoppingList1[adder].setName(Input.readString());
		shoppingList1[adder].setQuantity(Input.readInt());
		shoppingList1[adder].setPrice(Input.readFloat());*/

		
/*       shoppingList1[0].setName(Input.readString());
        shoppingList1[0].setPrice(250);
        shoppingList1[0].setQuantity(3);*/
     /*   shoppingList1[1].setName("fish");
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
        
    //    shoppingListHandler.clear();
        
  //      shoppingListHandler.printTotalAfterSale();
        
        
        
        
        shoppingList1[1].setTotalPriceItem();
	/*	System.out.println("trota");
		System.out.println(shoppingListHandler.getTotalItems());
		System.out.println("trota");*/
       // shoppingListHandler.removeItem("fish");
        //shoppingListHandler.removeItem("meat");
        
   /*     String a1 = Input.readString();
        String a2 = Input.readString();
        
        if(a1.equals("exit")){
        
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
	/*			shoppingListHandler.calculateSubTotalPrice();//shoppingList1);
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
			//	shoppingListHandler.printInvoice();*/
				
	}

}
