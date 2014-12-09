
public class Screen {

	public final static int MAXROWS = 3;
	public final static String LAYOUT1A = "##########";
	public final static String LAYOUT1B = "####  ####";
	public final static String LAYOUT1C = "#########";
	public final static String LAYOUT2A = "###########";
	public final static String LAYOUT2B = " ########";
	public final static String LAYOUT2C = "  ######";	
	
	private ScreenRow[] newScreenRowArray = new ScreenRow[MAXROWS];

	public Screen(int screenNumber){		
		newScreenRowArray[0] = new ScreenRow(new Category('A'));
		newScreenRowArray[1] = new ScreenRow(new Category('B'));
		newScreenRowArray[2] = new ScreenRow(new Category('C'));
	}
	
	public Screen(int screenNumber, Category category){
		this(screenNumber);
		setNewScreenRow(category);	
	}
	
	public Screen(int screenNumber, Category category, int numberOfSeatToBook, int positionOfSeatToBook){
		this(screenNumber, category);
		this.newScreenRowArray[defineArrayPosition(category)].setBook(numberOfSeatToBook, positionOfSeatToBook);		
	}
	
	public ScreenRow[] getnewScreenRowArray(){
		return newScreenRowArray;
	}
	
	public ScreenRow getNewScreenRow(Category category){
		return newScreenRowArray[defineArrayPosition(category)];
	}
	
	public void setNewScreenRow(Category category){
		this.newScreenRowArray[defineArrayPosition(category)].setCategory(category);
	}
	
	public boolean setNewScreenRow(Category category, int numberOfSeatToBook, int positionOfSeatToBook){	
		setNewScreenRow(category);
		boolean ok = this.newScreenRowArray[defineArrayPosition(category)].setCategory(category, numberOfSeatToBook, positionOfSeatToBook);
		return ok;
	}
	
	public Category setNewScreenRow(int rowNumber){
		Category category = new Category(defineCategory(rowNumber));
		this.newScreenRowArray[rowNumber].setCategory(category);
	//	System.out.println(this.newScreenRowArray[rowNumber].getCategory().getSymbol());
	//	System.out.println(category.getSymbol());
	//	System.out.println(rowNumber);
		return category;
	}

	public boolean setNewScreenRow(int rowNumber, int numberOfSeatToBook, int positionOfSeatToBook){
	//	System.out.println(rowNumber);
	  boolean ok = this.newScreenRowArray[rowNumber].setCategory(setNewScreenRow(rowNumber), rowNumber, numberOfSeatToBook, positionOfSeatToBook);
	  return ok;
	}
		
	public int defineArrayPosition(Category category){
		switch(category.getSymbol()){
			case 'A': return 0; 
			case 'B': return 1;
			case 'C': return 2;
			default:return 0;
		}
	}
	
	public char defineCategory(int rowNumber){
		switch(rowNumber){
			case 0: return 'A';
			case 1: return 'B'; 
			case 2: return 'C';
			default:return '0';
		}
	}
		
}
