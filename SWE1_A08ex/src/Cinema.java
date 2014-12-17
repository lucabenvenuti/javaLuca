public class Cinema {

	public static final int NOFSCREENS = 3;
	public static final int MAXPLACES = 20;
	
	public final static String EURO = "\u20AC";
	public final static String S01 = "Choose Screen 1 or 2 or 3 or type exit to terminate the program";
	public final static String S02 = "How many seats?";
	public final static String S03 = "Which Row (Note: Category A = ";
	public final static String S04 = " \u20AC, B = ";
	public final static String S05 = " \u20AC or C = ";
	public final static String S11 = " \u20AC or D = ";
	public final static String S06 = " \u20AC)? ";
	public final static String S07 = "Which Position?";
	public final static String S08 = "Successfully completed booking. Please pay: ";
	public final static String S09 = "Booking failed";	
	public final static String S10 = "    [---------]";
	
	public Category[] categoryArray= {new Category(8,'A'),new Category(10,'B'),
			new Category(11, 'C'), new Category(20, 'D')};//new Category[4];
	
	private Screen one;
	private Screen two;
	private Screen three;
	private Screen[] screen1 = new Screen[3];
	
	
	public Cinema() {
		
		one = new Screen(new ScreenRow(categoryArray[0], "##########",1), 
						 new ScreenRow(categoryArray[1], "#### #### ",2), 
						 new ScreenRow(categoryArray[2], "######### ",3), 
						 new ScreenRow(categoryArray[2], "##########",4));
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
		screen1[2] = three;
	}
	
	public void run() {
	boolean continuation = true, ok = false;
		int seSc = 0; 
		int numberOfSeatToBook = 0, row = 0, positionOfSeatToBook = 0, a =0;
		char symbol = 'Q';
		
		char [] inputKeyboard;
		String inputKey = "";
		
		System.out.printf("%s%n",S01);
		inputKey = Input.readString();
		while (continuation){ //do {
			StringBuffer printPrice = new StringBuffer("");
			if (inputKey.equals("exit")){break;}
			else {inputKeyboard = inputKey.toCharArray();
				seSc = (int)inputKeyboard[0] - 49;
				if (seSc<0 || seSc>(NOFSCREENS-1) || inputKey.length()>1){
					System.out.printf("%s%n",S09);
					break;}
			}
			
			printScreen(screen1[seSc]);
			
			do {System.out.printf("%n%s%n",S02);
				numberOfSeatToBook = Input.readInt();	
				System.out.printf("%n");
			} while (numberOfSeatToBook<1 || numberOfSeatToBook>MAXPLACES);
			
			do {
				//;
				printPrice.append (S03 + Integer.toString((int)(categoryArray[0].getPrice()*numberOfSeatToBook)));
				printPrice.append (S04 + Integer.toString((int)(categoryArray[1].getPrice()*numberOfSeatToBook)));
				printPrice.append (S05 + Integer.toString((int)(categoryArray[2].getPrice()*numberOfSeatToBook)));
				if(screen1[seSc].singlyLinkedLinearListSeatRows.getTail().getScreenRow().getCategory().getSymbol()=='D'
					//	screen1[seSc].singlyLinkedLinearListSeatRows.getSize()>3
						){
					printPrice.append (S11 + Integer.toString((int)(categoryArray[3].getPrice()*numberOfSeatToBook)));
				}
				printPrice.append (S06);
				System.out.printf("%s", printPrice); 
				row = Input.readInt();
			}while (row<1 || row >7);
			//System.out.printf("%n");
			printRow(screen1[seSc], row);
			
			do {System.out.printf("%s%n",S07);
			positionOfSeatToBook = Input.readInt();
			System.out.printf("%n");
			}while (positionOfSeatToBook<1 || positionOfSeatToBook>MAXPLACES);
			ok = screen1[seSc].book(row,positionOfSeatToBook,numberOfSeatToBook);			
			if (ok) {	
				for ( DoublyLinkedPlaceList linkedPlaceList = screen1[seSc].singlyLinkedLinearListSeatRows.getHead(); 
						linkedPlaceList != null;// && linkedPlaceList.getRow()<=(row); 
						linkedPlaceList = linkedPlaceList.getNext()){
					if(linkedPlaceList.getRow()==row)
						{a = linkedPlaceList.getScreenRow().calcPrice(numberOfSeatToBook);}
				}
				System.out.printf("%s%d %s%n%n",S08, a, EURO);
			} else{System.out.printf("%s%n%n",S09);}
			
			printScreen(screen1[seSc]);
			
			seSc = 0;
			numberOfSeatToBook = 0;
			symbol = 'Q';
			positionOfSeatToBook = 0;
			
			
			
			System.out.printf("%s%n",S01);
			inputKey = Input.readString();
		} 
		
	}
	
	public StringBuffer printString(DoublyLinkedPlaceList linkedPlaceList, StringBuffer printRow){
	printRow.append("[");
	printRow.append(String.valueOf(linkedPlaceList.getScreenRow().getCategory().getSymbol()));
	printRow.append("]");
	printRow.append("|");
	printRow.append(linkedPlaceList.getScreenRow().getRowLayout());
	printRow.append("\n");
	return printRow;
	}
	
	public void printRow(Screen screen, int row){
		StringBuffer printRow = new StringBuffer("");
		for ( DoublyLinkedPlaceList linkedPlaceList = screen.singlyLinkedLinearListSeatRows.getHead(); 
				linkedPlaceList != null;
				linkedPlaceList = linkedPlaceList.getNext()){
			if (linkedPlaceList.getRow()==row){
				printString(linkedPlaceList, printRow);
			break;}
		}System.out.printf("%s%n",printRow);
	}
	
	public void printScreen(Screen screen){
		StringBuffer printRow = new StringBuffer("");
		printRow.append("    [");
		for (int i=0; i<screen.singlyLinkedLinearListSeatRows.getHead().getScreenRow().getRowLayout().length()-2;i++)
		{printRow.append("-");}
		printRow.append("]\n");
		for ( DoublyLinkedPlaceList linkedPlaceList = screen.singlyLinkedLinearListSeatRows.getHead(); 
				linkedPlaceList != null;
				linkedPlaceList = linkedPlaceList.getNext()){
				printString(linkedPlaceList, printRow);
		}System.out.printf("%s%n",printRow);
	}
	
	public static void main(String[] args) {
		new Cinema().run();
	}
}