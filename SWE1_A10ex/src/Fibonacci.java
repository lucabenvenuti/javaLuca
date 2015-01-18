/* Fibonacci.java
 * Software Development 1.11 Recursion
 * Institute for Pervasive Computing, JKU Linz, Austria
 * http://www.pervasive.jku.at
 * author: 2007-10-1 Michael Matscheko
 * last change: 2012-12-05 Michael Matscheko */

// Compute Fibonacci-Number
public class Fibonacci {

	static int fib(int n) {
		if (n<1)
			return 0;
		else if (n < 3)
			return 1;
		else
			return fib(n - 1) + fib(n - 2);
	}
	
	public static void main(String[] args) {
		System.out.println(fib(3));
	}

}
