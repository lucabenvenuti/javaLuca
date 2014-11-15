import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;


public class GameOfLife {
	
	//public static void readFile(String path) throws IOException {
	public static int[][] readFile(String path) throws IOException {
		//comment: method incomplete and needs to be extended!

		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String line = buffRead.readLine();
		int[][] arrayNumbers = new int [10][10];
		int ira = 0, j= 0;
		int a =0;
		
		while (line != null) {
		//split a line into characters
		char[] parts = line.toCharArray();
		
//		System.out.println(Arrays.toString(parts));
	/*	System.out.print("BX: "); 
		System.out.println("The char is " + parts[2]);
		System.out.print("CX: "); 
		
		System.out.format("H: %d", parts.length, "\n"); */
				
		for(char s:parts){
		// use Character.getNumericValue(s) to transform a character
		// 's' into a numeric value and populate the initial matrix
		a =	Character.getNumericValue(s);
		
		if (a==-1){}
		else {
					
			arrayNumbers[j][ira] = a;
			
			System.out.format(" (%d) \n", a);
			ira = ira+1;
			}
		}
		//read next line
		System.out.format("trota \n ");
		line = buffRead.readLine();
		j = j+1;
		ira = 0;
		}
		
		for (int k = 0; k < 10; k++) {
		    for (int l = 0; l < 10; l++) {
		        System.out.print(arrayNumbers[k][l] + " ");
		    }
		    System.out.print("\n");
		}
		
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
