//package at.jku.pervasive.swe14.a01;
//import at.jku.pervasive.swe14.a01;
/**
 * Software Development I, 2014WS
 * Institute for Pervasive Computing, JKU Linz
 * @author Andreas Riener
 * @version 2014-10-08
 */

public class Sum {
	public static void main(String[] args) { 
		int sum = 0; 
		int number;
		
		System.out.print("Please enter number (<=0 for exit): "); 
		number = Input.readInt(); 
		while (number > 0) { 
			sum = sum + number;
			System.out.print("Please enter number (<=0 for exit): "); 
			number = Input.readInt(); 
		} 
		System.out.print("Sum of numbers: "); 
		System.out.println(sum); 
  }
} 