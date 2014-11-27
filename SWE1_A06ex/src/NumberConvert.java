/* NumberConvert.java
 * Software Development 1.04 Arrays
 * Institute for Pervasive Computing, JKU Linz, Austria
 * http://www.pervasive.jku.at
 * author: 2007-10-1 Michael Matscheko
 * last change: 2012-10-19 Michael Matscheko */

public class NumberConvert {
	
	public static void main (String argv[]) {
		char c;                                // declare variables
		int i, value = 0, charValue;

		// text line, split in single characters
		char[] line = {'4','2','1','9','5',' ','M','e','t','e','r','\n'};

		i = 0;
		while (i < line.length) {              // as long as there are further chars
			c = line[i];                       // get next char from line
			if (c < '0' || c > '9') break;     // if it isn't a number: stop
			charValue = (int)c - (int)'0';     // convert numeric character to number
			value = 10 * value + charValue;    // include new number in total
			i++;
		}
		System.out.println("Number: " + value);
	}
}