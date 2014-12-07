
public class Screen {

	private ScreenRow[] newScreenRow = new ScreenRow[3];
	//private Category category;
	

//	public int test1= 33;

	public Screen(){		
		newScreenRow[0] = new ScreenRow(new Category('A'));
		newScreenRow[1] = new ScreenRow(new Category('B'));
		newScreenRow[2] = new ScreenRow(new Category('C'));
		
	}
	
		public Screen(Category category){
		this();
		setNewScreenRow(category);	
	}
	
	public Screen(Category category, int numberOfSeatToBook, int positionOfSeatToBook){
		this(category);
		//setNewScreenRow();
		boolean ok = this.newScreenRow[defineArrayPosition(category)].setBook(numberOfSeatToBook, positionOfSeatToBook);		
	}
	
	public ScreenRow[] getNewScreenRow(){
		return newScreenRow;
	}
	
	public ScreenRow getNewScreenRow(Category category){
		//System.out.println(defineArrayPosition(category));
		return newScreenRow[defineArrayPosition(category)];
	}
	
	public void setNewScreenRow(Category category){
		this.newScreenRow[defineArrayPosition(category)].setCategory(category);
	}
	
	public boolean setNewScreenRow(Category category, int numberOfSeatToBook, int positionOfSeatToBook){	
		setNewScreenRow(category);
		//boolean ok = this.newScreenRow[defineArrayPosition(category)].setBook(numberOfSeatToBook, positionOfSeatToBook);
		boolean ok = this.newScreenRow[defineArrayPosition(category)].setCategory(category, numberOfSeatToBook, positionOfSeatToBook);
		//System.out.println(ok);
		return ok;
	}
	
	public int defineArrayPosition(Category category){
		switch(category.getSymbol()){
			case 'A': return 0; //break;
			case 'B': return 1; //break;
			case 'C': return 2; //break;
			default:return 0;
		}
		
	}
	
	//newScreenRow[0].setCategory('A');
	
/*	public void setNewScreenRowCategory(Category category, int arrayPosition){
		this.newScreenRow[arrayPosition].setCategory(category);
		
		
	}*/
	
	
	
	
	
	
}
