
public class Screen {

	private ScreenRow[] newScreenRow = new ScreenRow[3];
	//private Category category;
	



	public Screen(){
		newScreenRow[0] = new ScreenRow(new Category('A'));
		newScreenRow[1] = new ScreenRow(new Category('B'));
		newScreenRow[2] = new ScreenRow(new Category('C'));
		
	}
	
	public Screen(Category category){
		this();
		setNewScreenRow(category);	
	}
	
	public ScreenRow[] getNewScreenRow(){
		return newScreenRow;
	}
	
	public void setNewScreenRow(Category category){
		this.newScreenRow[defineArrayPosition(category)].setCategory(category);
	}
	
	public void setNewScreenRow(Category category, int numberOfSeatToBook, int positionOfSeatToBook){	
		setNewScreenRow(category);
		boolean ok = this.newScreenRow[defineArrayPosition(category)].setBook(numberOfSeatToBook, positionOfSeatToBook);
		
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
