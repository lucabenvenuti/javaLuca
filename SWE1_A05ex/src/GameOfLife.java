import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


public class GameOfLife {
	
	//public static void readFile(String path) throws IOException {
	public static int[][] readFile(String path) throws IOException {
		//comment: method incomplete and needs to be extended!
		int a[][] = new int [20][20];
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String line = buffRead.readLine();
		while (line != null) {
		//split a line into characters
		char[] parts = line.toCharArray();
		char c = 'a';
		int value = 0, charValue;
	/*	System.out.print("B: "); 
		
		//int lengthParts = parts.length;
		System.out.println(parts[0]);
		System.out.print("C: "); 
		System.out.println(parts[1]); */
		int i = 0;
		int j = 0;
	//	for(char s:parts){
	//	for (int i = 0;i<11; i++){
		
		while (i < parts.length){
	//	a[i][j] =	Character.getNumericValue(s);
		// use Character.getNumericValue(s) to transform a character
		// 's' into a numeric value and populate the initial matrix
		//	System.out.println(s);
		
		if (c < '0' || c > '9') break;     // if it isn't a number: stop
		charValue = (int)c - (int)'0';     // convert numeric character to number
		value = 10 * value + charValue;  
		
			System.out.format(" (%d) \n", a[i][j]);
			
			i = i+1;
		}
		System.out.println("Number: " + value);
		//read next line
		line = buffRead.readLine();
		j = j +1;
		}
		buffRead.close();
		
/*		for (int k = 0; k < a.length; k++) {
		    for (int l = 0; l < a.length; l++) {
		        System.out.print(a[k][l] + " ");
		    }
		    System.out.print("\n");
		}
		*/
	//	System.out.format(" (%d) \n", a[2]);
	//	System.out.print("CX: "); 
	//	System.out.println(a[2][1]);
	/*	System.out.println(a[3][2]);
		System.out.println(a[13][1]);
		System.out.println(a[8][3]); */
		int b[][] = {{0, 0 },{ 0, 0}};
		return b;
		
		}

	
///////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		int a=0;
		System.out.print("B: "); 
		String file = Input.readString();
		try {
		readFile(file);
		//add your code here...
		} catch (IOException e) {
		e.printStackTrace();
		}
		System.out.print("CX: "); 
}
}
