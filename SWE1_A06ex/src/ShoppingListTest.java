
public class ShoppingListTest {

	
	
	public static void main(String[] args) {
		
		boolean go = true;
		ShoppingList shoppingListHandler = new ShoppingList();
				
		Item[] shoppingList1 = new Item[ShoppingList.MAXIMALNUMBEROFELEMENTS];
        for(int i=0; i<shoppingList1.length; i++){
        	shoppingList1[i] = new Item();//this will call constructor.
        }
        
		shoppingListHandler.setShoppingIndex(shoppingList1.length); 
		shoppingListHandler.exportArrayItem(shoppingList1);
		
		System.out.printf("%s%n%n", ShoppingList.S01);//
		
		goCycle: while (go){
			
			System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s%n%n%s", ShoppingList.S02, ShoppingList.S11, 
					ShoppingList.S12,ShoppingList.S13,ShoppingList.S14,ShoppingList.S15,ShoppingList.S16,ShoppingList.S21);
		char keyboardInput = Input.readChar();//
		
		switch (keyboardInput){
		case '1': {
	        Item newItemTemp = new Item();
	        System.out.printf("%s", ShoppingList.S22);
	        newItemTemp.setName(Input.readString());
	        System.out.printf("%s", ShoppingList.S23);
	        newItemTemp.setQuantity(Input.readInt());
	        System.out.printf("%s", ShoppingList.S24);
	        newItemTemp.setPrice(Input.readFloat());
	        
	        while (newItemTemp.getPrice()*newItemTemp.getQuantity()<0.1 || 
	        		newItemTemp.getName().equals("") || newItemTemp.getPrice()<0.1 ||
	        		newItemTemp.getQuantity()<1){
	        	System.out.printf("%s%n", ShoppingList.S31);
		        System.out.printf("%s", ShoppingList.S22);
		        newItemTemp.setName(Input.readString());
		        System.out.printf("%s", ShoppingList.S23);
		        newItemTemp.setQuantity(Input.readInt());
		        System.out.printf("%s", ShoppingList.S24);
		        newItemTemp.setPrice(Input.readFloat());
	        }
	        shoppingListHandler.addItem(newItemTemp);
	        newItemTemp = new Item();
			
			break;}
		case '2': { System.out.printf("%s", ShoppingList.S22);
					String removeName = Input.readString();
					while (removeName.equals("")){
						System.out.printf("%s", ShoppingList.S22);
						removeName = Input.readString();
					}
					shoppingListHandler.removeItem(removeName);
					break;}
		case '3': shoppingListHandler.clear();break;
		case '4': shoppingListHandler.printTotalAfterSale();break;
		case '5': shoppingListHandler.printInvoice(); break;
		case 'q': System.out.printf("%s", ShoppingList.S30);go = false; break goCycle;
		default : System.out.printf("%n%s%n%n", ShoppingList.S31);
		
		}System.out.printf("%n%s%n%n", ShoppingList.S01);
		}
			
	}

}
