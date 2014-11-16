import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;


public class MemoryGame {
	

	  // Implementing Fisher–Yates shuffle
	  static void shuffleArray(int[] ar)
	  {
	    Random rnd = new Random();
	    for (int i = ar.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      int a = ar[index];
	      ar[index] = ar[i];
	      ar[i] = a;
	    }
	  }

	
///////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		//int a=0 , countAlive =0 , jj=0 , value = 0;
		boolean newGen = false;		
		
		int [][] arrayNumbers = new int [20][2];
		int counter =0, counter2 =0;
		
		int row = arrayNumbers.length;
		int col = arrayNumbers[0].length;
		int [][] arrayNumbersNew = new int [row][col];
		int [] arrayStorage = new int [row*col];
		
		double x = Math.random()*77;
		int y = (int) (Math.round(x)+48);	
		
		double rowPos = Math.random()*row;
		int rowPos2 = (int) (Math.round(rowPos));	
		
		System.out.print("CXX test: \n"); 
		System.out.format(" loop number %.3f (%d) ", x, y);
		
		for (int line1 = 0; line1 < row; line1++) {
		    for (int column1 = 0; column1 < col; column1++) {
		    	
		    	if (counter<=(row*col/2) && arrayNumbers[line1][column1] ==0 )
		    	{
		    		//until it is true the while goes
		    		// I want to continue until I get a random that is not in the list //!newGen
		    		counter2 = 0;
		    		newGen = true;
		    		while (newGen){
		    			
		    			if (counter2 > 1000){break;}
		    			
			    		newGen = false;
			    		x = Math.random()*77;
			    		y = (int) (Math.round(x)+48);	
			    		
			    		for (int k = 0; k < arrayStorage.length; k++) {
			    			if (y == arrayStorage[k]){
			    				newGen = true;
			    			
			    			}else {}	
			    		}
		    			counter2 = counter+1;
		    		}
		    		counter2 = 0;
		    		newGen = false;
			    	arrayNumbers[line1][column1] = y;
			    	arrayStorage[counter]=y;
			    	
			    	counter = counter +1;

		    	}

		    	else if (counter>(row*col/2) && arrayNumbers[line1][column1] ==0 )
		    	{
		    	break;}
		    	else {break;}
		    	
		    	arrayNumbers[line1][column1] = arrayNumbersNew[line1][column1];
		    	arrayNumbersNew[line1][column1] = 0;
		    	
		    	System.out.print(y + " \n");
		    }
		    
		    if (counter>(row*col/2) )
	    	{
	    	break;}
		    
		}
		
		
		
		 int[] solutionArray = { 1, 2, 3, 4, 5, 6, 16, 15, 14, 13, 12, 11 };

		    shuffleArray(solutionArray);
		    for (int i = 0; i < solutionArray.length; i++)
		    {
		      System.out.print(solutionArray[i] + " ");
		    }
		    System.out.println();
		

		
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
		}
		    	if (newGen){	
}
		    	else{}
		    	
		    	}		
		*
		*
		*/
