
abstract class AbstractMovie implements Movie {
//class Circle implements GeometricFigure
	
	public int priceSurcharge(){
		if (length()>120){
			return 1;
		}else {return 0;}
		
	}
	
	
	public String getName(){
		return "trota";
	}
	public int length(){
		return 10;
	}


	public void setScreens(Screen[] screens){
		
	}
	public Screen[] getScreens(){
		return new Screen[4];
	}
	
}
