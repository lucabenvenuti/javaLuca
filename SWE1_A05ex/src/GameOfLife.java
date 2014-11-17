import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class GameOfLife {
	
	//public static void readFile(String path) throws IOException {
	public static int[][] readFile(String path) throws IOException {
		//comment: method incomplete and needs to be extended!

		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String line = buffRead.readLine();
		int[][] arrayNumbers = new int [10][10];
		int i = 0, j= 0, a =0; // a for acquisition
		
		while (line != null) {
		//split a line into characters
		char[] parts = line.toCharArray();
				
		for(char s:parts){
		// use Character.getNumericValue(s) to transform a character
		// 's' into a numeric value and populate the initial matrix
		a =	Character.getNumericValue(s);
		
		if (a==-1){}
		else {
					
			arrayNumbers[j][i] = a;

			i = i+1;
			}
		}

		line = buffRead.readLine();
		j = j+1;
		i = 0;
		}

		return arrayNumbers;
		
		}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		int countAlive =0 , jj=0 , value = 0; // a=0 , 
		boolean live = true;	
		
		System.out.print("Number of life cycles: "); 
		int cycles = Input.readInt(); 
		
		while (cycles <1 || cycles > 100){
			System.out.print("Wrong input \n"); 
			System.out.print("Number of life cycles: "); 
			cycles = Input.readInt(); 
			
		}
		
		System.out.print("File name (stable.txt, disappears.txt, or alternate.txt): "); 
		String file = Input.readString();
		try {
			int [][] arrayNumbers = readFile(file);
			
			int row = arrayNumbers.length;
			int col = arrayNumbers[0].length;
			int [][] arrayNumbersNew = new int [row][col];
			char [][] arrayNumbersChar = new char [row][col];
			
			for (int k = 0; k < row; k++) {
			    for (int l = 0; l < col; l++) {
			    	if (arrayNumbers[k][l]==1){
			    		System.out.print("*");
			    	}
			    	else{System.out.print(".");}
			        arrayNumbersChar[k][l] = '.';
			    }
			    System.out.print("\n");
			} 
			
			while (live && jj<cycles-1){
				live = false;
				System.out.print("\n");
			for (int line1 = 1; line1 < (row-1); line1++) {
			    for (int column1 = 1; column1 < (col-1); column1++) {
			        countAlive = countAlive + arrayNumbers[line1-1][column1-1];
			        countAlive = countAlive + arrayNumbers[line1-1][column1+1];
			        countAlive = countAlive + arrayNumbers[line1-1][column1];
			        countAlive = countAlive + arrayNumbers[line1][column1-1];
			        countAlive = countAlive + arrayNumbers[line1][column1+1];
			        countAlive = countAlive + arrayNumbers[line1+1][column1-1];
			        countAlive = countAlive + arrayNumbers[line1+1][column1+1];
			        countAlive = countAlive + arrayNumbers[line1+1][column1];		
			        if(countAlive <2 || countAlive>3){
			        	//System.out.print("."); //  DEAD \n");
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
			} 
			
			for (int line1 = 0; line1 < (row); line1++) {
			    for (int column1 = 0; column1 < (col); column1++) {
			
			    	arrayNumbers[line1][column1] = 0;
			    	arrayNumbers[line1][column1] = arrayNumbersNew[line1][column1];
			    	arrayNumbersNew[line1][column1] = 0;
			    }
			}
			jj =jj+1;
  
			for (int k = 0; k < row; k++) {
				    for (int l = 0; l < col; l++) {
				        System.out.print(arrayNumbersChar[k][l]);
				        arrayNumbersChar[k][l] = '.';
				    }
				    System.out.print("\n");
				} 
			}
		} catch (IOException e) {
		e.printStackTrace();
		}

		
}
}
