
public class ScreenRow {
	
	public final static String layoutA = "###########";
	public final static String layoutB = "#########";
	public final static String layoutC = "#######";
	
	private Category category;
	
	private char[] rowLayoutCharArray = layoutA.toCharArray();
	
	private boolean setInitialLayout = false;
	private int reservedSeats = 0;
	private double totalPriceRow = 0.0;
	
	public ScreenRow(Category category){
		setCategory(category);
	}
	
public ScreenRow() {
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
		if (setInitialLayout){}
		else {
		setInitialRowLayoutCharArray(this.category);
		}
	}
	

	
	public boolean setCategory(Category category, int numberOfSeatToBook, int positionOfSeatToBook){
		setCategory(category);
		boolean ok = setBook(numberOfSeatToBook, positionOfSeatToBook);
		if(ok){
			this.reservedSeats = this.reservedSeats + numberOfSeatToBook;
			setTotalPriceRow();
		} else {//wrong input
			}
		return ok;
	}
		
	
	public boolean checkBook(int numberOfSeatToBook, int positionOfSeatToBook) {
		boolean ok = false;
		if ((numberOfSeatToBook + positionOfSeatToBook) > this.rowLayoutCharArray.length){
			return ok;
		}
		for(int i=(positionOfSeatToBook-1); i<(positionOfSeatToBook-1+numberOfSeatToBook); i++){
			if(this.rowLayoutCharArray[positionOfSeatToBook-1]== '#'){
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
	
	public char[] getRowLayoutCharArray() {
		return rowLayoutCharArray;
	}
	
	public String getRowLayoutString(boolean printX){ 
		char[] cloneRowLayoutCharArray = rowLayoutCharArray;
		if (printX){}
		else {
			for (int i = 0; i<cloneRowLayoutCharArray.length; i++ ){
				if (cloneRowLayoutCharArray[i]=='X'){
					cloneRowLayoutCharArray[i]=' ';
				}
			}
		}	
		return String.valueOf(cloneRowLayoutCharArray);
	}
	
	public void setInitialRowLayoutCharArray(Category category) {
		if(category.getSymbol()=='A'){
			this.rowLayoutCharArray = layoutA.toCharArray();
		} else if(category.getSymbol()=='B'){
			this.rowLayoutCharArray = removeElement(2);
		} else if(category.getSymbol()=='C'){
			this.rowLayoutCharArray = removeElement(4);
		} else {this.rowLayoutCharArray = "error".toCharArray();}
		this.setInitialLayout = true;
	}
	
	public char[] removeElement(int element){
		char[] rowLayoutCharArray2 = layoutA.toCharArray();
	    char[] n = new char[rowLayoutCharArray2.length - element];
	    System.arraycopy(rowLayoutCharArray2, 0, n, 0, rowLayoutCharArray2.length - element );
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
	
}