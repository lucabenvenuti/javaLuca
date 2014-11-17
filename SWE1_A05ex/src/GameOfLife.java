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
			
		//	System.out.format(" (%d) \n", a);
			ira = ira+1;
			}
		}
		//read next line
	//	System.out.format("trota \n ");
		line = buffRead.readLine();
		j = j+1;
		ira = 0;
		}
		

		
	//	int b[][] = {{0, 0 },{ 0, 0}};
		return arrayNumbers;
		
		}

	
///////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		int a=0 , countAlive =0 , jj=0 , value = 0;
		boolean live = true;	
		
		System.out.print("Number of life cycles: "); 
		int cycles = Input.readInt(); 
		
		System.out.print("File name (stable.txt, disappears.txt, or alternate.txt): "); 
		String file = Input.readString();
		try {
			int [][] arrayNumbers = readFile(file);
			
			int row = arrayNumbers.length;
			int col = arrayNumbers[0].length;
			int [][] arrayNumbersNew = new int [row][col];
			char [][] arrayNumbersChar = new char [row][col];
	//		System.out.format(" (%d , %d ) \n \n ",  row, col);
			
	//		System.out.print("CXX: "); 
	//		System.out.print("\n");
			
			for (int k = 0; k < row; k++) {
			    for (int l = 0; l < col; l++) {
			        //System.out.print(arrayNumbers[k][l] + " ");
			    	if (arrayNumbers[k][l]==1){
			    		System.out.print("*");
			    	}
			    	else{System.out.print(".");}
			        //System.out.print(arrayNumbersChar[k][l]);
			        arrayNumbersChar[k][l] = '.';
			    }
			    System.out.print("\n");
			} 
		//	System.out.print("\n");
		//	System.out.print("trota: "); 
		//	System.out.print("\n");
			
			while (live && jj<cycles){
				live = false;
				System.out.print("\n");
			for (int line1 = 1; line1 < (row-1); line1++) {
			    for (int column1 = 1; column1 < (col-1); column1++) {
			       // System.out.print(arrayNumbers[line1][column1] + " ");
			        
			        countAlive = countAlive + arrayNumbers[line1-1][column1-1];
			        countAlive = countAlive + arrayNumbers[line1-1][column1+1];
			        countAlive = countAlive + arrayNumbers[line1-1][column1];
			        countAlive = countAlive + arrayNumbers[line1][column1-1];
			        countAlive = countAlive + arrayNumbers[line1][column1+1];
			        countAlive = countAlive + arrayNumbers[line1+1][column1-1];
			        countAlive = countAlive + arrayNumbers[line1+1][column1+1];
			        countAlive = countAlive + arrayNumbers[line1+1][column1];		
			       // System.out.print("\n");
			        //System.out.format(" (%d, line %d, column %d, initialValue %d) ", countAlive, line1+1 , column1+1, arrayNumbers[line1][column1]);
			        //System.out.print("\n");
			        if(countAlive <2 || countAlive>3){
			        	//System.out.print("."); //  DEAD \n");
			        	//arrayNumbersNew[line1][column1]=0;
			        	arrayNumbersChar[line1][column1] = '.';
			        	value = 0;
			        }
			        else if(countAlive ==2 && arrayNumbers[line1][column1]==1) {
			        	//System.out.print("*"); //ALIVE \n");
			        	live = true;	
			        	arrayNumbersChar[line1][column1] = '*';
			        	value = 1;
			        }
			        else if(countAlive==3) {
			        	//System.out.print("*"); // ALIVE \n");
			        	live = true;	
			        	arrayNumbersChar[line1][column1] = '*';
			        	value = 1;
			        	
			        }
			        else{
			        	//System.out.print("."); // DEAD \n");
			        	arrayNumbersChar[line1][column1] = '.';
			        	value = 0;
			        }
			        countAlive = 0;
			        
			        arrayNumbersNew[line1][column1]=value;
			        value = 0;
			        
			    }
		//	    System.out.print("\n");
			} 
	//		System.out.print(" TROTA \n");
			
			for (int line1 = 0; line1 < (row); line1++) {
			    for (int column1 = 0; column1 < (col); column1++) {
			
			    	arrayNumbers[line1][column1] = 0;
			    	arrayNumbers[line1][column1] = arrayNumbersNew[line1][column1];
			    	arrayNumbersNew[line1][column1] = 0;
			    }
			}
			//arrayNumbers = arrayNumbersNew;
			jj =jj+1;
//			 System.out.format(" loop number (%d) \n", jj);
		      
			
			
			
				for (int k = 0; k < row; k++) {
				    for (int l = 0; l < col; l++) {
				        System.out.print(arrayNumbersChar[k][l]);
				        arrayNumbersChar[k][l] = '.';
				    }
				    System.out.print("\n");
				} 
			

			
			}
	//		System.out.print("CXX: "); 
			
		//add your code here...
		} catch (IOException e) {
		e.printStackTrace();
		}
//		System.out.print("CXX: "); 
		
		
		

		
}
}


/*		switch (month) {
		case 9:
		case 4:
		case 6:
		case 11:
			daysMax = 30;
			break;
		case 2:
			if (leapyear)
				daysMax = 29;
			else
				daysMax = 28;
			break;
		default:
			daysMax = 31;
		}*/
