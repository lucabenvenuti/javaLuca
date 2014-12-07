import java.util.Arrays;


public class Cinema {
	
	public static final char[] symbolArray = {'A','B', 'C'};
	
	public final static String EURO = "\u20AC";
	public final static String S01 = "Choose Screen 1 or 2 or type exit to terminate the program";
	public final static String S02 = "How many seats?";
	public final static String S03 = "Which Row (Note: Category A=24 \u20AC, B=30 \u20AC or C=33 \u20AC)?";
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
			System.out.printf("%s%n",S10);

			newCinema.printRow(false, Screen1, seSc);
			System.out.printf("%s%n",S02);
			numberOfSeatToBook = Input.readInt();
			System.out.printf("%s%n",S03);
			symbol = Input.readChar();
			tempCategory = new Category(symbol);
			System.out.printf("[%c]|%s%n",symbol, Screen1[seSc].getNewScreenRow(tempCategory).getRowLayoutString(false));
			System.out.printf("%s%n",S07);
			positionOfSeatToBook = Input.readInt();
			
			ok = Screen1[seSc].setNewScreenRow(tempCategory, numberOfSeatToBook, positionOfSeatToBook);
			
			if (ok) {
			System.out.printf("%s%.0f %s%n%n",S08, Screen1[seSc].getNewScreenRow(tempCategory).getTotalPriceRow(), EURO);
			newCinema.printRow(true, Screen1, seSc);
			} else{System.out.printf("%s%n",S09);}
			
			seSc = 0;
			numberOfSeatToBook = 0;
			symbol = 'Q';
			positionOfSeatToBook = 0;
			System.out.printf("%n");
		}

	}

}