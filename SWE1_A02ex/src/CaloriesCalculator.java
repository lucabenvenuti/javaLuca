//package stem.out;

//import Input;

public class CaloriesCalculator {
	public static void main(String[] args) { 
		int age = 0, weight = 0, height = 0, sexAdd = 0 ;
		float BMR = 0; 
		char sex = 'm';
		
		System.out.print("Please enter your age (<=0 for exit): "); 
		age = Input.readInt(); 
		
		if (age>0) {
		} else {
			return;
		}
		
		System.out.print("Please enter your weight in kg (<=0 for exit): "); 
		weight = Input.readInt(); 
		
		if (weight>0) {
		} else {
			return;
		}		
		
		System.out.print("Please enter your height in cm (<=0 for exit): "); 
		height = Input.readInt(); 
		
		if (height>0) {
		} else {
			return;
		}

		System.out.print("Please enter your sex (f for female, m for male): "); 
		sex = Input.readChar(); 
		
		if (sex=='m') {
			sexAdd = 5;
		} else {
			sexAdd = -161;
		}	
		
		BMR = Math.round(10*weight + 6.25*height - 5*age + sexAdd) ;

		//long BMR2 = Math.round(BMR);

		System.out.printf("Sum of numbers: %.0f ",BMR); 
	//	System.out.println(BMR); 
  }

}
