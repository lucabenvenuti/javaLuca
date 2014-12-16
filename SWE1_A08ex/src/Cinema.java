public class Cinema {

	public static final int NOFSCREENS = 3;
	public static final int MAXPLACES = 20;
	
	public final static String EURO = "\u20AC";
	public final static String S01 = "Choose Screen 1 or 2 or 3 or type exit to terminate the program";
	public final static String S02 = "How many seats?";
	public final static String S03 = "Which Row (Note: Category A =";
	public final static String S04 = " \u20AC, B =";
	public final static String S05 = " \u20AC or C =";
	public final static String S11 = " \u20AC or D =";
	public final static String S06 = " \u20AC)? ";
	public final static String S07 = "Which Position?";
	public final static String S08 = "Successfully completed booking. Please pay: ";
	public final static String S09 = "Booking failed";	
	public final static String S10 = "    [---------]";
	
/*	private Screen[] screen1 = new Screen[NOFSCREENS];
	
	public void printRow(boolean printX, Screen[] screen1, int seSc){
		char symbol = 'Q';
		Category tempCategory;
		for (int i=0; i<Screen.SYMBOLARRAY.length; i++){	
			symbol = Screen.SYMBOLARRAY[i];
			tempCategory = new Category(symbol);
			System.out.printf("[%c]|%s%n",symbol, screen1[seSc].getNewScreenRow(tempCategory).
					getRowLayoutString(printX));
	}   System.out.printf("%n");
}*/
	
	public Category[] categoryArray= {new Category(8,'A'),new Category(10,'B'),
			new Category(11, 'C'), new Category(20, 'D')};//new Category[4];
	
	//private Screen[] screen1 = new Screen[NOFSCREENS];
//	categoryArray[0];// = ;
	/*	categoryArray[1] = ;
	categoryArray[2] = ;*/
//	categoryArray[3] = ;
	
	private Screen one;
	private Screen two;
	private Screen three;
	private Screen[] screen1 = new Screen[3];
	
	
	public Cinema() {
		

		Category a = categoryArray[0];
		Category b = categoryArray[1];
		Category c = categoryArray[2];
		Category d = categoryArray[3];
		//ScreenRow screenRow1 = new ScreenRow(new Category(8, 'A'), "#X##X##########", 1);
		one = new Screen(new ScreenRow(categoryArray[0], "##########",1), 
						 new ScreenRow(categoryArray[1], "#### #### ",2), 
						 new ScreenRow(categoryArray[2], "######### ",3), 
						 new ScreenRow(categoryArray[2], "##########",4));
		/*two = new Screen(new ScreenRow(a, "########"), new ScreenRow(b,
				"########"), new ScreenRow(c, "########"));*/
		two = new Screen(new ScreenRow(categoryArray[0], "###########",1), 
						 new ScreenRow(categoryArray[1], " ########  ",2), 
						 new ScreenRow(categoryArray[2], "  ######   ",3), 
						 new ScreenRow(categoryArray[3], "    ##     ",4));
		
		three = new Screen( new ScreenRow(categoryArray[0], "####################",1), 
							new ScreenRow(categoryArray[1], "####################",2), 
							new ScreenRow(categoryArray[2], "####################",3), 
							new ScreenRow(categoryArray[2], "####################",4), 
							new ScreenRow(categoryArray[3], "   ##          ##   ",5));
		screen1[0] = one;
		screen1[1] = two;
		screen1[2] = three;//] = {one, two, three};
	}
	
//	private Screen[] screen1 = {one, two, three};
	
	public void run() {
	boolean continuation = true, ok = false;
		int seSc = 0; //selectedScreen;
		int numberOfSeatToBook = 0, row = 0, positionOfSeatToBook = 0, a =0;
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
			
		//	printRow(false, screen1, seSc);
			
			do {System.out.printf("%s%n",S02);
				numberOfSeatToBook = Input.readInt();	
				System.out.printf("%n");
			} while (numberOfSeatToBook<1 || numberOfSeatToBook>MAXPLACES);
			
		/*	*/
			
			do {
				printPrice = S03 + Integer.toString((int)(categoryArray[0].getPrice()*numberOfSeatToBook));
				printPrice += S04 + Integer.toString((int)(categoryArray[1].getPrice()*numberOfSeatToBook));
				printPrice += S05 + Integer.toString((int)(categoryArray[2].getPrice()*numberOfSeatToBook));
				if(screen1[seSc].singlyLinkedLinearListSeatRows.getSize()>3){
					printPrice += S11 + Integer.toString((int)(categoryArray[3].getPrice()*numberOfSeatToBook));
				}
				printPrice += S06;
				System.out.printf("%s", printPrice); 
				row = Input.readInt();
			//	symbol = Input.readChar();	
			//	row = (int) symbol;
			}while (row<1 || row >7);
			//while (row<49 || (row>(49+Screen.MAXROWS) && row<65) || row>(65 + Screen.MAXROWS));
			
			/*	if (row>49+Screen.MAXROWS){	
				row = row -65;
				symbol = screen1[seSc].singlyLinkedLinearListSeatRows.getHead().getScreenRow().getCategory().getSymbol();//Screen.SYMBOLARRAY[row];
			}
			else {row = row -49;
				symbol = screen1[seSc].singlyLinkedLinearListSeatRows.getHead().getScreenRow().getCategory().getSymbol();//Screen.SYMBOLARRAY[row];}		
					
					tempCategory = new Category(symbol);
			System.out.printf("[%c]|%s%n",symbol, screen1[seSc].getNewScreenRow(tempCategory).
					getRowLayoutString(false));*/
			System.out.printf("%n");
			
			do {System.out.printf("%s%n",S07);
			positionOfSeatToBook = Input.readInt();
			System.out.printf("%n");
			}while (positionOfSeatToBook<1 || positionOfSeatToBook>MAXPLACES);
			
			//book(int row, int position, int seats) 
		//	System.out.println(
			ok = screen1[seSc].book(row,positionOfSeatToBook,numberOfSeatToBook);//);
		//	System.out.println(screen1[seSc].singlyLinkedLinearListSeatRows.getHead().getNext().getNext().getScreenRow().getRowLayout());
		//	System.out.println(screen1[seSc].singlyLinkedLinearListSeatRows.getSize());
			//System.out.println(
		//	System.out.println(screen1[seSc].singlyLinkedLinearListSeatRows.getHead().getScreenRow().getCategory().getSymbol());

			
	//		ok = screen1[seSc].setNewScreenRow(seSc, row, numberOfSeatToBook, positionOfSeatToBook);
			
			if (ok) {	
			//	screen1[seSc].singlyLinkedLinearListSeatRows.getHead()			
				for ( DoublyLinkedPlaceList linkedPlaceList = screen1[seSc].singlyLinkedLinearListSeatRows.getHead(); 
						linkedPlaceList != null;// && linkedPlaceList.getRow()<=(row); 
						linkedPlaceList = linkedPlaceList.getNext()){
					if(linkedPlaceList.getRow()==row)
						{a = linkedPlaceList.getScreenRow().calcPrice(numberOfSeatToBook);}
				}
				System.out.printf("%s%d %s%n%n",S08, a, EURO);
				System.out.printf("%s%n",S10);
			//	printRow(true, screen1, seSc);
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
	/*	Screen[] screen1 = new Screen[NOFSCREENS];
		for (int i =0; i<NOFSCREENS; i++){
			screen1[i] = new Screen(i);		}*/
		
	//	while (continuation){

			

		//}
	}
}