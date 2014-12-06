
public class ScreenRow {
	
	public final static String layoutA = "###########";
	public final static String layoutB = "#########";
	public final static String layoutC = "#######";
	
	private Category category;
	
	private char[] rowLayoutCharArray;
	
	private int reservedSeats = 0;
	private double totalPriceRow = 0.0;
	
	public ScreenRow(Category category){
		setCategory(category);
	}
	
	public ScreenRow(Category category, int numberOfSeatToBook, int positionOfSeatToBook){
		setCategory(category, numberOfSeatToBook, positionOfSeatToBook);		
	}
	
/*	public ScreenRow(Category category, int reservedSeats){
		setCategory(category, reservedSeats);
	}*/
	
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
		setInitialRowLayoutCharArray(this.category);
	}
	
/*	public void setCategory(Category category, int reservedSeats) {
		setCategory(category);
		this.reservedSeats = reservedSeats;
		setTotalPriceRow();
	}*/
	
	public void setCategory(Category category, int numberOfSeatToBook, int positionOfSeatToBook){
		setCategory(category);
		boolean ok = setBook(numberOfSeatToBook, positionOfSeatToBook);
		if(ok){
			this.reservedSeats = this.reservedSeats + numberOfSeatToBook;
			setTotalPriceRow();
		} else {//wrong input
			}
	}
		
	
	public boolean setBook(int numberOfSeatToBook, int positionOfSeatToBook) {
		// TODO Auto-generated method stub
		boolean ok = false;
		if ((numberOfSeatToBook + positionOfSeatToBook) > this.rowLayoutCharArray.length){
			return ok;
		}
		//int a = this.rowLayoutCharArray.length;
		for(int i=(positionOfSeatToBook-1); i<(positionOfSeatToBook-1+numberOfSeatToBook); i++){
			if(this.rowLayoutCharArray[positionOfSeatToBook-1]== '#'){
				this.rowLayoutCharArray[i]= 'X';
			} else{return ok;}
		}
		//this.rowLayoutCharArray[positionOfSeatToBook-1]= 'X';
		ok = true;
		return ok;
	}

	/**
	 * @return the rowLayoutCharArray
	 */
	public char[] getRowLayoutCharArray() {
		return rowLayoutCharArray;
	}
	
	public void setInitialRowLayoutCharArray(Category category) {
		if(category.getSymbol()=='A'){
			this.rowLayoutCharArray = layoutA.toCharArray();
		} else if(category.getSymbol()=='B'){
			this.rowLayoutCharArray = layoutB.toCharArray();
		} else if(category.getSymbol()=='C'){
			this.rowLayoutCharArray = layoutC.toCharArray();
		} else {this.rowLayoutCharArray = "error".toCharArray();}
	}

	/**
	 * @return the reservedSeats
	 */
	public int getReservedSeats() {
		return reservedSeats;
	}

	/**
	 * @param reservedSeats the reservedSeats to set
	 */
	public void setReservedSeats(int reservedSeats) {
		this.reservedSeats = reservedSeats;
	}

	/**
	 * @return the totalPriceRow
	 */
	public double getTotalPriceRow() {
		return totalPriceRow;
	}

	/**
	 * @param totalPriceRow the totalPriceRow to set
	 */
	public void setTotalPriceRow() {
		this.totalPriceRow = getReservedSeats()*getCategory().getPrice();
	}







}

/*	public ScreenRow(Category category, String rowLayout){
this(category);
//String rowLayout2 = "*****";
this.rowLayoutCharArray = rowLayout.toCharArray();

}

String layout="##### ######";
char [] seats=layout.toCharArray();


/**
* @return the category
*/


/**
* @param rowLayoutCharArray the rowLayoutCharArray to set
*/


/*String Str = new String("Welcome to Tutorialspoint.com");

System.out.print("Return Value :" );
char[] a = Str.toCharArray(); //from String to char array
String.valueOf(char[]) //from char array to String
System.out.println(a[1]);*/