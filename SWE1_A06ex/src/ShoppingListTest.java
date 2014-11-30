
public class ShoppingListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Item[] shoppingList1 = new Item[10];
        //step2 : now create objects in a loop.
        for(int i=0; i<shoppingList1.length; i++){
        	shoppingList1[i] = new Item();//this will call constructor.
        }
        
        shoppingList1[0].setName("fish");
		
		/*	Item[] head = new Item()[10];
			head.setName("fish");
			head.next.setName("meat");
			head.next.setName(null);
			
			if (Item.isInList(head, "fish"))*/
				System.out.println(shoppingList1[0].getName());

			
	}

}
