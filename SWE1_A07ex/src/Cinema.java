
public class Cinema {

	public final static String EURO = "\u20AC";
	public final static String S01 = "Choose Screen 1 or 2 or type exit to terminate the program";
	public final static String S02 = "How many seats?";
	public final static String S03 = "Which Row (Note: Category A=24 \u20AC, B=30 \u20AC or C=33 \u20AC)?";
//	public final static String S04 = "or";
//	public final static String S05 = ")?";
//	public final static String S06 = ", ";
	public final static String S07 = "Which Position?";
	public final static String S08 = "Successfully completed booking. Please pay: ";
	public final static String S09 = "Booking failed";	
	public final static String S10 = "	[---------]";

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	Category newCat = new Category('A');
		boolean continuation = true;
		Screen[] Screen1 = new Screen[2];
		int seSc = 0; //selectedScreen;
		int numberOfSeatToBook = 0;
		char symbol = 'Q';
		int positionOfSeatToBook = 0;
		String inputKey = "";
		char [] inputKeyboard;

//		Screen Screen2 = new Screen();
		
		while (continuation){
			System.out.printf("%s%n",S01);
			inputKey = Input.readString();
			if (inputKey.equals("exit")){break;}
			inputKeyboard = inputKey.toCharArray();
			seSc = (int)inputKeyboard[0] - 49;
	//		System.out.println(seSc);
			
			//seSc = Input.readInt()-1;
			System.out.printf("%s%n",S02);
			numberOfSeatToBook = Input.readInt();
			System.out.printf("%s%n",S03);
			
			System.out.printf("%s%n",S07);
			positionOfSeatToBook = Input.readInt();
		
			
			
			seSc = 0;
			numberOfSeatToBook = 0;
			symbol = 'Q';
			positionOfSeatToBook = 0;
		}
	/*	
		Category newCategory = new Category(Input.readChar());
	//	newScreen1.
		
		System.out.println(Screen1[0].getNewScreenRow()[0].getCategory().getSymbol());
		System.out.println(Screen1[0].getNewScreenRow()[0].getRowLayoutCharArray()[1]);
*/
	}

}


