/**
 * Cinema.java
 *
 * A {@link ScreenRow} is a class which holds 
 * the movies and the layout 
 * of a cinema, and interacts with the user
 * 
 * Software Development I, 2014WS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 * 
 * @version 2014-12-26
 */
public class Cinema {

	public static final int NOFSCREENS = 3;
	public static final int NOFMOVIES = 3;
	public static final int MAXPLACES = 20;

	/**
	 * defined strings for output
	 */
	public final static String EURO = "\u20AC";
	public final static String S01 = "Choose Movie 1 or 2 or 3 or type exit to terminate the program";
	public final static String S02 = "How many seats?";
	public final static String S03 = "Which Row (Note: Category A = ";
	public final static String S04 = " \u20AC, B = ";
	public final static String S05 = " \u20AC or C = ";
	public final static String S11 = " \u20AC or D = ";
	public final static String S06 = " \u20AC)? ";
	public final static String S07 = "Which Position?";
	public final static String S08 = "Successfully completed booking. Please pay: ";
	public final static String S09 = "Booking failed";	
	public final static String S10 = "Movie selection:";
	public final static String S12 = "Choose screen:";

	/**
	 * the categories are fixed, both symbols and prices
	 */
	public Category[] categoryArray= {new Category(8,'A'),new Category(10,'B'),
			new Category(11, 'C'), new Category(20, 'D')};

	/**
	 * I create an array with 3 movie and one array of screens for each movie
	 */
	private Screen one, two, three;
	
	private Movie alpha, beta, gamma;
	private Movie[] movie1 = new Movie[3];
	
//	private Screen[] screen1 = new Screen[3];
	private Screen[] screenFilm1= new Screen[1];
	private Screen[] screenFilm2= new Screen[3];
	private Screen[] screenFilm3= new Screen[2];

	/**
	 * I populate the cinema and the screen array
	 */
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

	/*	screen1[0] = one;
		screen1[1] = two;
		screen1[2] = three;*/
		
		screenFilm1[0] = one;
		
		alpha = new HFRThreeDMovie(screenFilm1, 144, "The Hobbit: The Battle of the Five Armies" );
	//	screenFilm1[0] = new Screen(one, alpha, "20:30");
		Screen[] screenFilmFirst =  {new Screen(one, alpha, "Saturday 8:15PM")};
		alpha = new HFRThreeDMovie(screenFilmFirst, alpha.length(), alpha.getName());
		
		screenFilm2[0] = one;
		screenFilm2[1] = two;
		screenFilm2[2] = three;
		
		beta = new TwoDMovie(screenFilm2, 97, "Magic in the Moonlight");
		Screen[] screenFilmSecond =  {new Screen(one, beta, "Sunday 8:00PM"),
				new Screen(two, beta, "Sunday 8:00PM"),
				new Screen(three, beta, "Sunday 6:00PM")};
		beta = new TwoDMovie(screenFilmSecond, beta.length(), beta.getName());
		
		screenFilm3[0] = one;
		screenFilm3[1] = two;
		
		gamma = new SpecialMovie(screenFilm3, 10,  107, "The Zero Theorem with Christoph Waltz");
		Screen[] screenFilmThird = {new Screen(one, gamma, "Saturday 6:00PM"),
				new Screen(two, gamma, "Saturday 7:00PM")};
		gamma = new SpecialMovie(screenFilmThird, gamma.priceSurcharge(), gamma.length(), gamma.getName());
		
		movie1[0] = alpha;
		movie1[1] = beta;
		movie1[2] = gamma;
	
		
	}

	/**
	 * main run of the code
	 */
	public void run() {
		boolean continuation = true; 
		int numberOfSeatToBook = 0, row = 0, positionOfSeatToBook = 0, seSc = 0, seMo = 0; //selected Movie
		char [] inputKeyboard;
		String inputKey = "";


		printMovie();
		System.out.printf("%s%n",S01);
		inputKey = Input.readString();
		System.out.printf("%n");
		while (continuation){

			if (inputKey.equals("exit")){break;}
			else {inputKeyboard = inputKey.toCharArray();
			seMo = (int)inputKeyboard[0] - 49;
			if (seMo<0 || seMo>(NOFMOVIES-1) || inputKey.length()>1){
				System.out.printf("%s%n",S09);
				break;}
			}
			
			seSc = seScRead(movie1[seMo]);
			
			numberOfSeatToBook = numberOfSeatToBookRead();
			row = rowRead(movie1[seMo].getScreens()[seSc], numberOfSeatToBook, movie1[seMo].getScreens()[seSc].getMovie().priceSurcharge());			
			printRow(movie1[seMo].getScreens()[seSc], row);
			positionOfSeatToBook = positionOfSeatToBookRead();
			if (movie1[seMo].getScreens()[seSc].book(row,positionOfSeatToBook,numberOfSeatToBook)) {	
				printPrice(movie1[seMo].getScreens()[seSc], row, numberOfSeatToBook);		
			} else{System.out.printf("%s%n%n",S09);}

			printScreen(movie1[seMo].getScreens()[seSc]);
			System.out.printf("%s%n",S01);
			printMovie();
			inputKey = Input.readString();
		} 	
	}

	/**
	 * @param movie
	 * @return 	
	 * 			asks which movie and shows the screens of the movie
	 */
	private int seScRead(Movie movie) {
		int a= 0, seSc =0;
		for (int i = 0; i<movie.getScreens().length; i++){
			System.out.printf("Screen %d) %n", i+1);
			printScreen(movie.getScreens()[i]);
			a++;
		}
		do {
		System.out.printf("%s%n",S12);
		seSc = Input.readInt() -1;
		}while (seSc<0 || seSc >a);
		
		return seSc;
	}

	/**
	 * it prints the movie properties
	 */
	private void printMovie(){
		StringBuffer moviePrint = new StringBuffer("");
		moviePrint.append(S10);
		moviePrint.append(System.getProperty("line.separator"));
		for (int i=0; i< movie1.length; i++){
			moviePrint.append(Integer.toString(i+1));
			moviePrint.append(") ");
			moviePrint.append(movie1[i].getName());
			moviePrint.append(" ");
			moviePrint.append(movie1[i].getQualifier());
			moviePrint.append(System.getProperty("line.separator"));
		}
		System.out.printf("%s",moviePrint);
	}

	/**
	 * @param screen
	 * @param row
	 * @param numberOfSeatToBook
	 * here the price of the reserved seats is printed
	 */
	private void printPrice(Screen screen, int row,
			int numberOfSeatToBook) {
		int a =0;
		for(ScreenRow screenRow = screen.getHead(); screenRow != null && screenRow.getRow()<=(row);
				screenRow = screenRow.getNext()){
			if(screenRow.getRow()==row){
				a = (screenRow.calcPrice(numberOfSeatToBook)+screen.getMovie().priceSurcharge()*numberOfSeatToBook);
			}
		}
		System.out.printf("%s%d %s%n%n",S08, a, EURO);
	}

	/**
	 * @return
	 * positionOfSeatToBook
	 * requires user input to get the initial position
	 */
	private int positionOfSeatToBookRead() {
		int positionOfSeatToBook = 0;
		do {System.out.printf("%s%n",S07);
		positionOfSeatToBook = Input.readInt();
		System.out.printf("%n");
		}while (positionOfSeatToBook<1 || positionOfSeatToBook>MAXPLACES);
		return positionOfSeatToBook;
	}

	/**
	 * @param screen
	 * @param numberOfSeatToBook
	 * @return
	 * requires user input to get the row, it also prints the row to let the user see which places are free
	 */
	public int rowRead(Screen screen, int numberOfSeatToBook, int surcharge) {
		int row=0;
		
		do {StringBuffer printPrice = new StringBuffer("");
			printPrice.append (S03 + Integer.toString((int)((categoryArray[0].getPrice()+surcharge)*numberOfSeatToBook)));
			
			printPrice.append (S04 + Integer.toString((int)((categoryArray[1].getPrice()+surcharge)*numberOfSeatToBook)));
			printPrice.append (S05 + Integer.toString((int)((categoryArray[2].getPrice()+surcharge)*numberOfSeatToBook)));
			if(screen.getTail().getCategory().getSymbol()=='D'){
				printPrice.append (S11 + Integer.toString((int)((categoryArray[3].getPrice()+surcharge)*numberOfSeatToBook)));
			}
			printPrice.append (S06);
			System.out.printf("%s", printPrice); 
			row = Input.readInt();
		}while (row<1 || row >Screen.MAXROWS);
		return row;
	}

	/**
	 * @return
	 * requires user input to get the number of seats to be booked
	 */
	private int numberOfSeatToBookRead() {
		int numberOfSeatToBook = 0;
		do {System.out.printf("%n%s%n",S02);
		numberOfSeatToBook = Input.readInt();	
		System.out.printf("%n");
		} while (numberOfSeatToBook<1 || numberOfSeatToBook>MAXPLACES);
		return numberOfSeatToBook;
	}

	/**
	 * @param screenRow
	 * @param printRow
	 * @return
	 * makes a StringBuffer to be printed
	 */
	public StringBuffer printString(ScreenRow screenRow, StringBuffer printRow){
		printRow.append("[");
		printRow.append(String.valueOf(screenRow.getCategory().getSymbol()));
		printRow.append("]");
		printRow.append("|");
		printRow.append(screenRow.getRowLayout());
		printRow.append("\n");
		return printRow;
	}

	/**
	 * @param screen
	 * @param row
	 * prints a StringBuffer that shows the row layout, the free and occupied places
	 */
	public void printRow(Screen screen, int row){
		StringBuffer printRow = new StringBuffer("");
		for(ScreenRow screenRow = screen.getHead(); screenRow != null && screenRow.getRow()<=(row);
				screenRow = screenRow.getNext()){
			if(screenRow.getRow()==row){
				printString(screenRow, printRow);
			}
		}
		System.out.printf("%s%n",printRow);
	}
	public void printRow(ScreenRow screenRow){
		StringBuffer printRow = new StringBuffer("");
		printString(screenRow, printRow);
	}

	/**
	 * @param screen
	 * prints a StringBuffer that shows the screen layout, the free and occupied places
	 */
	public void printScreen(Screen screen){
		StringBuffer printRow = new StringBuffer("");
		System.out.printf("    %s%n",screen.getScreeningTime());
		printRow.append("    [");
		for (int i=0; i<screen.getHead().getRowLayout().length()-2;i++)
		{printRow.append("-");}
		printRow.append("]\n");
		for(ScreenRow screenRow = screen.getHead(); screenRow != null ;
				screenRow = screenRow.getNext()){
			printString(screenRow, printRow);
		}
		System.out.printf("%s%n",printRow);
	}

	/**
	 * @param args
	 * run the run method
	 */
	public static void main(String[] args) {
		new Cinema().run();
	}
}