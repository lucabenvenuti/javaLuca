
public class ScreenRow {
	
	public final static String layoutA = "###########";
	public final static String layoutB = "#########";
	public final static String layoutC = "#######";
	
	private Category category;
	
	private char[] rowLayoutCharArray = layoutA.toCharArray();
	
//	public String test = "1"; //String.valueOf(rowLayoutCharArray);
	
	private boolean setInitialLayout = false;
	private int reservedSeats = 0;
	private double totalPriceRow = 0.0;
	
	public ScreenRow(Category category){
		setCategory(category);
	}
	
public ScreenRow() {
		// TODO Auto-generated constructor stub
	}

	/*	public ScreenRow(Category category, int numberOfSeatToBook, int positionOfSeatToBook){
		setCategory(category, numberOfSeatToBook, positionOfSeatToBook);		
	}*/
	

	
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	//	System.out.println(setInitialLayout);
		if (setInitialLayout){}//(getRowLayoutCharArray()[0]=='#'){}
		else {
		setInitialRowLayoutCharArray(this.category);
		}
	//	System.out.println(setInitialLayout);
	}
	

	
	public void setCategory(Category category, int numberOfSeatToBook, int positionOfSeatToBook){
		setCategory(category);
		boolean ok = setBook(numberOfSeatToBook, positionOfSeatToBook);
		if(ok){
			this.reservedSeats = this.reservedSeats + numberOfSeatToBook;
			setTotalPriceRow();
		} else {//wrong input
			}
	}
		
	
	public boolean checkBook(int numberOfSeatToBook, int positionOfSeatToBook) {
		// TODO Auto-generated method stub
		boolean ok = false;
		if ((numberOfSeatToBook + positionOfSeatToBook) > this.rowLayoutCharArray.length){
			return ok;
		}
		//int a = this.rowLayoutCharArray.length;
		for(int i=(positionOfSeatToBook-1); i<(positionOfSeatToBook-1+numberOfSeatToBook); i++){
			if(this.rowLayoutCharArray[positionOfSeatToBook-1]== '#'){
			//	this.rowLayoutCharArray[i]= 'X';
			} else{return ok;}
		}
		//this.rowLayoutCharArray[positionOfSeatToBook-1]= 'X';
		ok = true;
		return ok;
	}
	
	public boolean setBook(int numberOfSeatToBook, int positionOfSeatToBook) {
		boolean ok = checkBook(numberOfSeatToBook, positionOfSeatToBook);
		if(ok){
			for(int i=(positionOfSeatToBook-1); i<(positionOfSeatToBook-1+numberOfSeatToBook); i++){
				this.rowLayoutCharArray[i]= 'X';
			}
		}
		return ok;
	}
	

	/**
	 * @return the rowLayoutCharArray
	 */
	public char[] getRowLayoutCharArray() {
		return rowLayoutCharArray;
	}
	
	public String getRowLayoutString(){ 
		return String.valueOf(rowLayoutCharArray);
			}
	
	public void setInitialRowLayoutCharArray(Category category) {
	//	System.out.println(category.getSymbol());
		if(category.getSymbol()=='A'){
			this.rowLayoutCharArray = layoutA.toCharArray();
		} else if(category.getSymbol()=='B'){
		//	this.rowLayoutCharArray = layoutB.toCharArray();
			this.rowLayoutCharArray = removeElement(2);
		} else if(category.getSymbol()=='C'){
		//	this.rowLayoutCharArray = layoutC.toCharArray();
			this.rowLayoutCharArray = removeElement(4);
		} else {this.rowLayoutCharArray = "error".toCharArray();}
	//	System.out.println(this.rowLayoutCharArray);
		this.setInitialLayout = true;
	}
	
	public char[] removeElement(int element){
		char[] rowLayoutCharArray2 = layoutA.toCharArray();
	    char[] n = new char[rowLayoutCharArray2.length - element];
	    System.arraycopy(rowLayoutCharArray2, 0, n, 0, rowLayoutCharArray2.length - element );
	    return n;
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




/*	public void setCategory(Category category, int reservedSeats) {
setCategory(category);
this.reservedSeats = reservedSeats;
setTotalPriceRow();
}*/
/*	public ScreenRow(Category category, int reservedSeats){
setCategory(category, reservedSeats);
}*/
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