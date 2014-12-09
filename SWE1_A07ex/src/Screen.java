public class Screen {

	public final static int MAXROWS = 3;
	public final static String[][] LAYOUT = { {"##########", "####  ####","#########"}, {"###########", " ########", "  ######"	}};
	public static final char[] SYMBOLARRAY = {'A','B', 'C'};
	
	private ScreenRow[] newScreenRowArray = new ScreenRow[MAXROWS];

	public Screen(int screenNumber){		
		for (int i= 0; i<MAXROWS; i++){
			newScreenRowArray[i]=new ScreenRow(LAYOUT[screenNumber][i].toCharArray(), new Category(SYMBOLARRAY[i]));
		}
	}
	
	public Screen(int screenNumber, Category category){
		this(screenNumber);
		setNewScreenRow(screenNumber, category);	
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
	
	public void setNewScreenRow(int screenNumber, Category category){
		this.newScreenRowArray[defineArrayPosition(category)].setCategory(LAYOUT[screenNumber][defineArrayPosition(category)].toCharArray(), category); //setCategory(char[] rowLayoutCharArray, Category category)
	}
	
	public boolean setNewScreenRow(int screenNumber, Category category, int numberOfSeatToBook, int positionOfSeatToBook){	
		setNewScreenRow(screenNumber, category);
		boolean ok = this.newScreenRowArray[defineArrayPosition(category)].setCategory(
				LAYOUT[screenNumber][defineArrayPosition(category)].toCharArray(), category, numberOfSeatToBook, positionOfSeatToBook);
		return ok;
	}
	
	public Category setNewScreenRow(int screenNumber, int rowNumber){
		Category category = new Category(defineCategory(rowNumber));
		this.newScreenRowArray[rowNumber].setCategory(LAYOUT[screenNumber][rowNumber].toCharArray(), category);
		return category;
	}

	public boolean setNewScreenRow(int screenNumber, int rowNumber, int numberOfSeatToBook, int positionOfSeatToBook){
		Category category = new Category(defineCategory(rowNumber));
	  boolean ok = this.newScreenRowArray[rowNumber].setCategory(LAYOUT[screenNumber][rowNumber].toCharArray(), category, numberOfSeatToBook, positionOfSeatToBook);
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
