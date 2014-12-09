
public class ScreenRow {
	
	public final static String LAYOUTA = "           ";
	
	private char[] rowLayoutCharArray = LAYOUTA.toCharArray();
	
	private Category category;
	
	private boolean setInitialLayout = false;
	private int reservedSeats = 0;
	private int reservedSeatsSingleBooking = 0;
	private double totalPriceRow = 0.0;
	private double totalPriceRowSingleBooking = 0.0;
	
	public ScreenRow(char[] rowLayoutCharArray) {
		//this.rowLayoutCharArray = rowLayoutCharArray;
		setRowLayoutCharArray(rowLayoutCharArray);
	}
	
	public ScreenRow(char[] rowLayoutCharArray, Category category){
	//	this.rowLayoutCharArray = rowLayoutCharArray;
		setCategory(rowLayoutCharArray, category);
	}
	
	public Category getCategory() {
		return category;
	}

	public char[] getRowLayoutCharArray() {
		return rowLayoutCharArray;
	}
	
	public void setRowLayoutCharArray(char[] rowLayoutCharArray) {
		//return rowLayoutCharArray;
		if (!setInitialLayout){
			this.rowLayoutCharArray = rowLayoutCharArray;
			this.setInitialLayout = true;
		}
		
	}
	public void setCategory(char[] rowLayoutCharArray, Category category) {
		this.category = category;
		setRowLayoutCharArray(rowLayoutCharArray);
	}
	
	public boolean setCategory(char[] rowLayoutCharArray, Category category, int numberOfSeatToBook, int positionOfSeatToBook){
		setCategory(rowLayoutCharArray, category);
		boolean ok = setBook(numberOfSeatToBook, positionOfSeatToBook);
		makeBook(ok, numberOfSeatToBook);
		return ok;
	}
	
	public void makeBook(boolean ok, int numberOfSeatToBook){
		if(ok){
			this.reservedSeats = this.reservedSeats + numberOfSeatToBook;
			setReservedSeatsSingleBooking(numberOfSeatToBook);
			setTotalPriceRowSingleBooking(numberOfSeatToBook);
		}
	}
	
	public boolean checkBook(int numberOfSeatToBook, int positionOfSeatToBook) {
		boolean ok = false;
		if ((numberOfSeatToBook + positionOfSeatToBook-1) > this.rowLayoutCharArray.length){
			return ok;
		}
		for(int i=(positionOfSeatToBook-1); i<(positionOfSeatToBook-1+numberOfSeatToBook); i++){
			if(this.rowLayoutCharArray[i]== '#'){
			} else{return ok;}
		}
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
	

	
	public String getRowLayoutString(boolean printX){ 
		char[] cloneRowLayoutCharArray = rowLayoutCharArray;
		if (printX){}
		else {
			for (int i = 0; i<cloneRowLayoutCharArray.length; i++ ){
				if (cloneRowLayoutCharArray[i]=='X'){
					cloneRowLayoutCharArray[i]='+';
				}
			}
		}	
		return String.valueOf(cloneRowLayoutCharArray);
	}
	
	public char[] removeElement(int element){
	    char[] n = new char[rowLayoutCharArray.length - element];
	    System.arraycopy(rowLayoutCharArray, 0, n, 0, rowLayoutCharArray.length - element );
	    return n;
	}

	public int getReservedSeats() {
		return reservedSeats;
	}

	public void setReservedSeats(int reservedSeats) {
		this.reservedSeats = reservedSeats;
	}

	public double getTotalPriceRow() {
		return totalPriceRow;
	}

	public void setTotalPriceRow() {
		this.totalPriceRow = getReservedSeats()*getCategory().getPrice();
	}

	public int getReservedSeatsSingleBooking() {
		return reservedSeatsSingleBooking;
	}

	public void setReservedSeatsSingleBooking(int reservedSeatsSingleBooking) {
		this.reservedSeatsSingleBooking = reservedSeatsSingleBooking;
	}

	public double getTotalPriceRowSingleBooking() {
		return totalPriceRowSingleBooking;
	}

	public void setTotalPriceRowSingleBooking(int numberOfSeatToBook) {
		this.totalPriceRowSingleBooking = numberOfSeatToBook*category.getPrice();
	}
	
}