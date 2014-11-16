import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;


public class MemoryGame {
	
	

	
///////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		//int a=0 , countAlive =0 , jj=0 , value = 0;
		//boolean live = true;		
		
		int [][] arrayNumbers = new int [20][20];
		
		int row = arrayNumbers.length;
		int col = arrayNumbers[0].length;
		int [][] arrayNumbersNew = new int [row][col];
		
		double x = Math.random()*77;
		int y = (int) (Math.round(x)+48);		
		
		System.out.print("CXX test: \n"); 
		System.out.format(" loop number %.3f (%d) ", x, y);
		
		for (int line1 = 0; line1 < 10; line1++) {
		    for (int column1 = 0; column1 < 10; column1++) {
		
		    	arrayNumbers[line1][column1] = 0;
		    	arrayNumbers[line1][column1] = arrayNumbersNew[line1][column1];
		    	arrayNumbersNew[line1][column1] = 0;
		    }
		}
		

		
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
