
public class ShoppingListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Item[] shoppingList1 = new Item[ShoppingList.MAXIMALNUMBEROFELEMENTS];
        //step2 : now create objects in a loop.
        for(int i=0; i<shoppingList1.length; i++){
        	shoppingList1[i] = new Item();//this will call constructor.
        }
        
        shoppingList1[1].setName("fish");
        shoppingList1[1].setQuantity(10);
        shoppingList1[1].setPrice(4);
        shoppingList1[1].setTotalPriceItem();
		
		/*	Item[] head = new Item()[10];
			head.setName("fish");
			head.next.setName("meat");
			head.next.setName(null);
			
			if (Item.isInList(head, "fish"))*/
				System.out.println(shoppingList1[1].getName());
				System.out.println(shoppingList1[1].getQuantity());
				shoppingList1[1].printTotalPriceItem();
			
	}

}
