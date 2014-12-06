
public class ScreenRow {
	
	public final static String layoutA = "###########";
	public final static String layoutB = "#########";
	public final static String layoutC = "#######";
	
	private Category category;
	
	private char[] rowLayoutCharArray;
	
	public ScreenRow(Category category){
		this.category = category;
		if(category.getSymbol()=='A'){
			this.setRowLayoutCharArray(layoutA.toCharArray());
		} else if(category.getSymbol()=='B'){
			this.setRowLayoutCharArray(layoutB.toCharArray());
		} else if(category.getSymbol()=='C'){
			this.setRowLayoutCharArray(layoutC.toCharArray());
		} else {this.setRowLayoutCharArray("error".toCharArray());}
		
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
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * @return the rowLayoutCharArray
	 */
	public char[] getRowLayoutCharArray() {
		return rowLayoutCharArray;
	}

	/**
	 * @param rowLayoutCharArray the rowLayoutCharArray to set
	 */
	public void setRowLayoutCharArray(char[] rowLayoutCharArray) {
		this.rowLayoutCharArray = rowLayoutCharArray;
	}



}

/*String Str = new String("Welcome to Tutorialspoint.com");

System.out.print("Return Value :" );
char[] a = Str.toCharArray(); //from String to char array
String.valueOf(char[]) //from char array to String
System.out.println(a[1]);*/