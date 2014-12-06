
public class Screen {

	private ScreenRow[] newScreenRow = new ScreenRow[3];
	//private Category category;
	



	public Screen(){
		newScreenRow[0] = new ScreenRow(new Category('A'));
		newScreenRow[1] = new ScreenRow(new Category('B'));
		newScreenRow[2] = new ScreenRow(new Category('C'));
		
	}
	
	public ScreenRow[] getNewScreenRow(){
		return newScreenRow;
	}
	
	//newScreenRow[0].setCategory('A');
	
/*	public void setNewScreenRowCategory(Category category, int arrayPosition){
		this.newScreenRow[arrayPosition].setCategory(category);
		
		
	}*/
	
	
	
	
	
	
}
