/* BreakSample1.java
 * Software Development 1.03 Control Structures
 * Institute for Pervasive Computing, JKU Linz, Austria
 * http://www.pervasive.jku.at
 * author: 2007-10-1 Michael Matscheko
 * last change: 2012-10-15 Michael Matscheko */

public class BreakSample1 {
	public static void main(String[] args) {
		int total = 0;
		do { 
			System.out.print("Enter a number: ");
			total += Input.readInt();
			if (total > 50) break;
			if (total <= 20) continue;
			System.out.println("Subtotal: " + total);
		} while (total <= 50);
		System.out.println("Total: " + total);
		total = 0;
		do { 
			System.out.print("Enter a number: ");
			total += Input.readInt();
			if (total > 20 && total <= 50)
				System.out.println("Subtotal: " + total);
		} while (total <= 50);
		System.out.println("Total: " + total);
	}
}
