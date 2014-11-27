//package at.jku.pervasive.swe14.a03;
/**
 * Software Development I, 2014WS
 * Institute for Pervasive Computing, JKU Linz
 * @author Andreas Riener
 * @version 2012-10-20
 */

public class UE03RoundingErrorBis {
	public static void main(String[] args) { 

		float f1 = 1.1f;
		float f2 = 0.1f;
		float f3 = f1-2*f2;	    	

		if (f1==1.1f) //ok
			System.out.println(f1);
		if (f2==0.1f) //ok
			System.out.println(f2); 

		if (f3==0.9f)//never
			System.out.println(f3); 
		if (f3==(1.1f-2*0.1f))
			System.out.println(f3); 
		int number1 = 10;
		int number2 = 3;

		float oneThirdWrong   = 3/9;  
		float oneThirdCorrect = 3f/9; 
		double result = number1 / number2;   //NO 
		result = (double)number1 / number2;   //ok  
		result = number1 / (double)number2;   //NO	
	}
} 
