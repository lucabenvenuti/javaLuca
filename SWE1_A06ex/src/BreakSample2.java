/* BreakSample2.java
 * Software Development 1.03 Control Structures
 * Institute for Pervasive Computing, JKU Linz, Austria
 * http://www.pervasive.jku.at
 * author: 2007-10-1 Michael Matscheko
 * last change: 2012-10-15 Michael Matscheko */

public class BreakSample2 {
	public static void main(String[] args) {

		double[][] sensordata = {{ 1,  2,  3},
		                         {-1,  0,  1},
		                         {-5, -3, -2}}; 
		boolean foundNegative = false;
		yLoop: for (int iy = 0; iy < 3; iy++) {
			for (int ix = 0; ix < 3; ix++) {
				if (sensordata[iy][ix] < 0) {
					foundNegative = true;
					break yLoop;
				}
			}
		}
		if (foundNegative) System.out.println("Found a negative value.");
		else System.out.println("All is well...");
	}
}
