public class Cinema {

	public static final int NOFSCREENS = 2;
	public static final int MAXPLACES = 11;
	
	public final static String EURO = "\u20AC";
	public final static String S01 = "Choose Screen 1 or 2 or type exit to terminate the program";
	public final static String S02 = "How many seats?";
	public final static String S03 = "Which Row (Note: Category/Row (A or 1)=";
	public final static String S04 = " \u20AC, (B or 2)=";
	public final static String S05 = " \u20AC or (C or 3)=";
	public final static String S06 = " \u20AC)? ";
	public final static String S07 = "Which Position?";
	public final static String S08 = "Successfully completed booking. Please pay: ";
	public final static String S09 = "Booking failed";	
	public final static String S10 = "    [---------]";
	
	private Screen[] Screen1 = new Screen[NOFSCREENS];
	
	public void printRow(boolean printX, Screen[] Screen1, int seSc){
		char symbol = 'Q';
		Category tempCategory;
		for (int i=0; i<Screen.SYMBOLARRAY.length; i++){	
			symbol = Screen.SYMBOLARRAY[i];
			tempCategory = new Category(symbol);
			System.out.printf("[%c]|%s%n",symbol, Screen1[seSc].getNewScreenRow(tempCategory).
					getRowLayoutString(printX));
	}   System.out.printf("%n");
}
	
	public Cinema() {
		
		for (int i =0; i<NOFSCREENS; i++){
			this.Screen1[i] = new Screen(i);		}
		
	}
	
	public void run() {
		boolean continuation = true, ok = false;
		int seSc = 0; //selectedScreen;
		int numberOfSeatToBook = 0, row = 0, positionOfSeatToBook = 0;
		char symbol = 'Q';
		
		char [] inputKeyboard;
		Category tempCategory;
		String inputKey = "", printPrice = "";
		System.out.printf("%s%n",S01);
		inputKey = Input.readString();
		while (continuation){ //do {
			if (inputKey.equals("exit")){break;}
			else {inputKeyboard = inputKey.toCharArray();
				seSc = (int)inputKeyboard[0] - 49;
				if (seSc<0 || seSc>(NOFSCREENS-1) || inputKey.length()>1){
					System.out.printf("%s%n",S09);
					break;}
			}
			System.out.printf("%s%n",S10);

			printRow(false, Screen1, seSc);
			
			do {System.out.printf("%s%n",S02);
				numberOfSeatToBook = Input.readInt();	
				System.out.printf("%n");
			} while (numberOfSeatToBook<1 || numberOfSeatToBook>MAXPLACES);
			
			do {
				printPrice = S03 + Integer.toString((int)(Category.PRICEA*numberOfSeatToBook));
				printPrice += S04 + Integer.toString((int)(Category.PRICEB*numberOfSeatToBook));
				printPrice += S05 + Integer.toString((int)(Category.PRICEC*numberOfSeatToBook));
				printPrice += S06;
				System.out.printf("%s", printPrice);  
				symbol = Input.readChar();	
				row = (int) symbol;
			}while (row<49 || (row>(49+Screen.MAXROWS) && row<65) || row>(65 + Screen.MAXROWS));
			
			if (row>49+Screen.MAXROWS){	
				row = row -65;
				symbol = Screen.SYMBOLARRAY[row];
			}
			else {row = row -49;
				symbol = Screen.SYMBOLARRAY[row];}		
					
			tempCategory = new Category(symbol);
			System.out.printf("[%c]|%s%n",symbol, Screen1[seSc].getNewScreenRow(tempCategory).
					getRowLayoutString(false));
			System.out.printf("%n");
			
			do {System.out.printf("%s%n",S07);
			positionOfSeatToBook = Input.readInt();
			System.out.printf("%n");
			}while (positionOfSeatToBook<1 || positionOfSeatToBook>MAXPLACES);
			
			ok = Screen1[seSc].setNewScreenRow(seSc, row, numberOfSeatToBook, positionOfSeatToBook);
			
			if (ok) {				
				System.out.printf("%s%.0f %s%n%n",S08, Screen1[seSc].getNewScreenRow(tempCategory).
						getTotalPriceRowSingleBooking(), EURO);
				System.out.printf("%s%n",S10);
				printRow(true, Screen1, seSc);
			} else{System.out.printf("%s%n%n",S09);}
			
			seSc = 0;
			numberOfSeatToBook = 0;
			symbol = 'Q';
			positionOfSeatToBook = 0;
			
			
			System.out.printf("%s%n",S01);
			inputKey = Input.readString();
		} //while(inputKey.equals("exit"));
		
	}
	
	public static void main(String[] args) {

	//	Cinema newCinema = new Cinema();
	//	newCinema.run();
		new Cinema().run();
	/*	Screen[] Screen1 = new Screen[NOFSCREENS];
		for (int i =0; i<NOFSCREENS; i++){
			Screen1[i] = new Screen(i);		}*/
		
	//	while (continuation){

			

		//}
	}
}