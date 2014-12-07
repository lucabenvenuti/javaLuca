import java.util.Arrays;


public class Cinema {
	
	public static final char[] symbolArray = {'A','B', 'C'};
	
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
	public final static String S10 = "    [---------]";

	
	public void printRow(boolean printX, Screen[] Screen1, int seSc){
		char symbol = 'Q';
		Category tempCategory;
		for (int i=0; i<symbolArray.length; i++){
	
		symbol = symbolArray[i];
		tempCategory = new Category(symbol);
		char[] chars3 = new char[i];
		Arrays.fill(chars3, ' ');
		String s12 = new String(chars3);
		System.out.printf("[%c]|%s%s%n",symbol, s12, Screen1[seSc].getNewScreenRow(tempCategory).getRowLayoutString(printX));
	}
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	Category newCat = new Category('A');
		boolean continuation = true;
		boolean ok = false;
		int maxScreen = 2;
		Screen[] Screen1 = new Screen[maxScreen];
		Screen1[0]= new Screen();
		Screen1[1]= new Screen(); // the array of objects must be initialized
		
		int seSc = 0; //selectedScreen;
		int numberOfSeatToBook = 0;
		char symbol = 'Q';
		int positionOfSeatToBook = 0;
		String inputKey = "";
		char [] inputKeyboard;
		Category tempCategory;// = new Category(symbol);
		Cinema newCinema = new Cinema();
	//	Category tempCategory2;
	//	Screen Screen2 = new Screen();
	//	Category tempCategory2 = new Category('B');
	//	System.out.println(tempCategory2.getSymbol());
	//	ScreenRow screenRow1 = new ScreenRow(tempCategory2);
	//	screenRow1.setCategory(tempCategory2);
	//	Screen1[0].getNewScreenRow()[0].setCategory(tempCategory2);
	//	System.out.println(screenRow1.getCategory().getSymbol());
	//	System.out.println(screenRow1.getRowLayoutCharArray());

	//	Screen Screen2 = new Screen();
//		System.out.println(Screen1[seSc].getNewScreenRow(tempCategory2));
		
		while (continuation){
			System.out.printf("%s%n",S01);
			inputKey = Input.readString();
			if (inputKey.equals("exit")){break;}
			else {inputKeyboard = inputKey.toCharArray();
				seSc = (int)inputKeyboard[0] - 49;
				if (seSc<0 || seSc>(maxScreen-1) || inputKey.length()>1){
					System.out.printf("%s%n",S09);
					break;}
			}
	//		System.out.println(seSc);
			System.out.printf("%s%n",S10);
		//	tempCategory2 = new Category(symbol);

			newCinema.printRow(false, Screen1, seSc);
		/*	symbol = 'A';
			tempCategory = new Category(symbol);
			
			symbol = 'B';
			tempCategory = new Category(symbol);
			System.out.printf("[%c]| %s%n",symbol, Screen1[seSc].getNewScreenRow(tempCategory).getRowLayoutString(false));
			symbol = 'C';
			tempCategory = new Category(symbol);
			System.out.printf("[%c]|  %s%n",symbol, Screen1[seSc].getNewScreenRow(tempCategory).getRowLayoutString(false));
			symbol = 'Q';*/
			//seSc = Input.readInt()-1;
			System.out.printf("%s%n",S02);
			numberOfSeatToBook = Input.readInt();
			System.out.printf("%s%n",S03);
			symbol = Input.readChar();
			tempCategory = new Category(symbol);
			System.out.printf("[%c]|%s%n",symbol, Screen1[seSc].getNewScreenRow(tempCategory).getRowLayoutString(false));
			System.out.printf("%s%n",S07);
			positionOfSeatToBook = Input.readInt();
			
		//	Screen1[seSc].setNewScreenRow(tempCategory);
			ok = Screen1[seSc].setNewScreenRow(tempCategory, numberOfSeatToBook, positionOfSeatToBook);
			//System.out.println(ok);
			if (ok) {
			//	System.out.printf("%s%n",Screen1[seSc].getNewScreenRow(tempCategory).getRowLayoutString(true));
	//		System.out.printf("%d%n",Screen1[seSc].getNewScreenRow(tempCategory).getReservedSeats());
			System.out.printf("%s%.0f %s%n%n",S08, Screen1[seSc].getNewScreenRow(tempCategory).getTotalPriceRow(), EURO);
			newCinema.printRow(true, Screen1, seSc);
			} else{System.out.printf("%s%n",S09);}
					//.getCategory().getSymbol());
			
			seSc = 0;
			numberOfSeatToBook = 0;
			symbol = 'Q';
			positionOfSeatToBook = 0;
			System.out.printf("%n");
		}
	/*	
		Category newCategory = new Category(Input.readChar());
	//	newScreen1.
		
		System.out.println(Screen1[0].getNewScreenRow()[0].getCategory().getSymbol());
		System.out.println(Screen1[0].getNewScreenRow()[0].getRowLayoutCharArray()[1]);
*/
	}

}


