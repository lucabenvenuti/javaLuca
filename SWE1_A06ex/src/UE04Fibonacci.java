package at.jku.pervasive.swe14.a04;
/**
 * Software Development I, 2014WS
 * Institute for Pervasive Computing, JKU Linz
 * @author Andreas Riener
 * @version 2014-10-30
 */

public class UE04Fibonacci {
	public static void main(String[] arg) {
		int n, fm0 = 0, fm1 = 1, f = 1;
		
		System.out.print("Enter a number: ");
		n = Input.readInt();
		while (n <= 1) {
			System.out.println("Number needs to be > 1!");
			n = Input.readInt();
		}
		while (n > f) {
			f = fm0 + fm1;
			fm0 = fm1;
			fm1 = f;
		}
		if (n == f)
			System.out.println(n + " is a Fibonacci number!");
		else {
			System.out.println(n + " ist not a Fibonacci number!");
			System.out.println("Next smaller Fibonacci number: " + fm0);
		}
	} // end of main
} // end of class UE04Fibonacci