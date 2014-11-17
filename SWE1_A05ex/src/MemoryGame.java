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
		int keyboardInputInt = 0;
		char keyboardInput = '!';
		
		System.out.print("Playground-height: "); 
		int row = Input.readInt(); 
		System.out.print("Playground-width: "); 
		int col = Input.readInt(); 
		
		int [][] arrayNumbers = new int [row][col];
		int counter =0, counter2 =0, counter3 =0;
		
		int [] arrayStorage = new int [row*col/2];
		
		double x = Math.random()*77; 
		int y = (int) (Math.round(x)+48);	//if x = 0 ==> y = 48 // if x = 1 ==> y = 125 // ==> 78 different numbers
		
		while (row*col>156 || row*col<4 || row*col%2==1){
			
			if (row*col>156 || row*col<4){
				System.out.print("The maximal playground size has 156 cards and the minimal 4 cards, yours "
						+ "has 234 cards. Try again. \n"); 	
			}
			
			if (row*col%2==1){
				System.out.print("Odd number of cells. Try again. \n");
			}
			System.out.print("Playground-height: "); 
			row = Input.readInt(); 
			System.out.print("Playground-width: "); 
			col = Input.readInt(); 
		}
		


		
		
		 for (int column1 = 0; column1 < col; column1++) {
		    for (int line1 = 0; line1 < row; line1++) {
		    	if (counter<(row*col/2) && arrayNumbers[line1][column1] ==0 )
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

		    	else {break;}

		    }
		    
		    if (counter>(row*col/2) )
	    	{
	    	break;}
		    
		}

		    shuffleArray(arrayStorage);
		    for (int i = 0; i < arrayStorage.length; i++)
		    {
		      //System.out.print(arrayStorage[i] + " ");
		    }

		    
			 for (int column1 = 0; column1 < col; column1++) {
				    for (int line1 = 0; line1 < row; line1++) {
				    	if (arrayNumbers[line1][column1] ==0 ) //counter>(row*col/2 -1) && 
				    	{
				    		
					    	arrayNumbers[line1][column1] = arrayStorage[counter3];
					    	//arrayStorage[counter]=y;
					    	
					    	counter3 = counter3 +1;
					    	
				    	}

						    }
						}
		

				char [][] arrayLettersNew = new char [row][col];
				//arrayLettersNew[1][1] = 'c';
				
				for (int k = 0; k < row; k++) {
				    for (int l = 0; l < col; l++) {
				    	arrayLettersNew[k][l]= (char)arrayNumbers[k][l];
				    	
				      /////////////////////////////////////////  System.out.print(arrayLettersNew[k][l]);
				     //   System.out.print(" ,");
				    }
				  //////////////////////////////////////////////  System.out.print("\n");
				} 
				
			//	System.out.print(arrayLettersNew[1][1]);
				
				
				
				char [][] arrayCovered = new char [row][col];
				//arrayLettersNew[1][1] = 'c';
				
				for (int k = 0; k < row; k++) {
				    for (int l = 0; l < col; l++) {
				    	arrayCovered[k][l]= '#';
				    	
				        System.out.print(arrayCovered[k][l]);
				     //   System.out.print(" ,");
				    }
				    System.out.print("\n");
				} 
				
				
				
				
				////FIRST INPUT
				int playerNum = 1;
				int playerPrint = 2;
				System.out.format("--- Player %d --- \n", playerNum);
				int h1 = 0, w1 =0, h2 =0, w2 = 1;
				int score1 = 0, score2 = 0;
				
				System.out.print("h1: "); 
				h1 = Input.readInt(); 
				System.out.print("w1: "); 
				w1 = Input.readInt(); 
				
				while (h1>row || w1>col){
					System.out.print("Invalid coordinates. Try again. \n");
					
					System.out.print("h1: "); 
					h1 = Input.readInt(); 
					System.out.print("w1: "); 
					w1 = Input.readInt(); 
				}				
				
				System.out.print("h2: "); 
				h2 = Input.readInt(); 
				System.out.print("w2: "); 
				w2 = Input.readInt(); 
				
				
				while (h2>row || w2>col || (h1==h2 && w1==w2)){
					System.out.print("Invalid coordinates. Try again. \n");
					
					System.out.print("h2: "); 
					h2 = Input.readInt(); 
					System.out.print("w2: "); 
					w2 = Input.readInt(); 
				}

				h1 = h1-1;
				w1 = w1-1;
				h2 = h2-1;
				w2 = w2-1;
				

				
				boolean continuation = true;
				
				while(continuation){
				
				for (int k = 0; k < row; k++) {
				    for (int l = 0; l < col; l++) {
				    	//arrayCovered[k][l]= '#';
				    	
				    	if((k==h1 && l == w1) || (k==h2 && l == w2)){
				    		System.out.print(arrayLettersNew[k][l]);
				    	}
				    	else  { //if ()
				    		 System.out.print(arrayCovered[k][l]);
				    	}

				    }
				    System.out.print("\n");
				} 
				System.out.print("\n");
				
				if (arrayLettersNew[h1][w1]==arrayLettersNew[h2][w2]){
					arrayCovered[h1][w1]=arrayLettersNew[h1][w1];
				//	System.out.print(arrayCovered[h1][w1]);
					arrayCovered[h2][w2]=arrayLettersNew[h2][w2];
				//	System.out.print(arrayCovered[h2][w2]);
					//playerNum = playerNum;
					if (playerNum%2==0){
						//playerPrint = 2;
						score2 = score2+1;
					}
					else{
						//playerPrint = 1;
						score1 = score1+1;
					}
					
				}
				else{
					playerNum = playerNum+1;
				}
				

				if ((score1+score2)==row*col/2){
					break;
				}
				
				else 
				{	System.out.print("'q'/'Q' to quit, <Enter> to continue... \n");
					keyboardInput = Input.readCharSequence();

					keyboardInputInt = (int) keyboardInput;
					
					if (keyboardInput=='q' || keyboardInput == 'Q'){
					//System.out.print("GAME FINISHED \n");
					return;
				}
				else if(keyboardInputInt == 10) {
					
					//System.out.print(a);
					//System.out.print("LET'S PLAY \n");
					//playerNum = playerNum+1;
					if (playerNum%2==0){playerPrint = 2;}
					else{playerPrint = 1;}
					System.out.format("--- Player %d --- \n", playerPrint);
					
					System.out.print("h1: "); 
					h1 = Input.readInt(); 
					System.out.print("w1: "); 
					w1 = Input.readInt(); 
					
					while (h1>row || w1>col || (arrayCovered[h1-1][w1-1] != '#') ){
						System.out.print("Invalid coordinates. Try again. \n");
						
						System.out.print("h1: "); 
						h1 = Input.readInt(); 
						System.out.print("w1: "); 
						w1 = Input.readInt(); 
					}				
					
					System.out.print("h2: "); 
					h2 = Input.readInt(); 
					System.out.print("w2: "); 
					w2 = Input.readInt(); 
					
					
					while (h2>row || w2>col || (h1==h2 && w1==w2) || (arrayCovered[h2-1][w2-1] != '#')){
						System.out.print("Invalid coordinates. Try again. \n");
						
						System.out.print("h2: "); 
						h2 = Input.readInt(); 
						System.out.print("w2: "); 
						w2 = Input.readInt(); 
					}

					h1 = h1-1;
					w1 = w1-1;
					h2 = h2-1;
					w2 = w2-1;

					
				}
				else {
					//System.out.print("trotaculofx \n");
					return;
				}
				}
				}
				
				System.out.format(" counter  (%d) bis (%d) ", score1, score2);
				
/////////////////////////////////////////////////////////////////////////////////////////////////////
				

				
				
				
}
}



//arrayNumbers[line1][column1] = arrayNumbersNew[line1][column1];
//arrayNumbersNew[line1][column1] = 0;

//System.out.print(y + " \n");


//System.out.println();

//  System.out.format(" counter  (%d) ", counter);	 

//int[] solutionArray = { 1, 2, 3, 4, 5, 6, 16, 15, 14, 13, 12, 11 };


//System.out.print(y + " \n");
//	 System.out.print("\n");


/*		for (int k = 0; k < row; k++) {
		    for (int l = 0; l < col; l++) {
		        System.out.print(arrayNumbers[k][l] + " ");
		    }
		    System.out.print("\n");
		} 
		System.out.print(" TROTA \n"); */
		//char a = 'b';

//else {System.out.print("trotaculo2 \n");}


//   System.out.print(arrayCovered[k][l]);
//   System.out.print(" ,");
/*				int attemptsCounter = 0;
tryAttempts[attemptsCounter][0] = h1;
tryAttempts[attemptsCounter][1] = w1;
tryAttempts[attemptsCounter][2] = h2;
tryAttempts[attemptsCounter][3] = w2; */

/*				
		// store the attempts
		//int [][] tryAttempts = new int [70][4];
		
		//int row = arrayNumbers.length;
		//int col = arrayNumbers[0].length;
//		int [][] arrayNumbersNew = new int [row][col];

		
	//	double rowPos = Math.random()*row;
	//	int rowPos2 = (int) (Math.round(rowPos));	
		
	//	System.out.print("CXX test: \n"); 
	//	System.out.format(" loop number %.3f (%d) ", x, y);
	 * h1 = 0;
	 */
	/*			w1 =0;
				h2 =0;
				w2 = 2;
				
				for (int k = 0; k < row; k++) {
				    for (int l = 0; l < col; l++) {
				    	//arrayCovered[k][l]= '#';
				    	
				    	if((k==h1 && l == w1) || (k==h2 && l == w2)){
				    		System.out.print(arrayLettersNew[k][l]);
				    	}
				    	else  { //if ()
				    		 System.out.print(arrayCovered[k][l]);
				    	}
				    	//else {System.out.print("trotaculo2 \n");}
				    	
				    	
				     //   System.out.print(arrayCovered[k][l]);
				     //   System.out.print(" ,");
				    }
				    System.out.print("\n");
				} 
				System.out.print("\n");
				
				if (arrayLettersNew[h1][w1]==arrayLettersNew[h2][w2]){
					arrayCovered[h1][w1]=arrayLettersNew[h1][w1];
				//	System.out.print(arrayCovered[h1][w1]);
					arrayCovered[h2][w2]=arrayLettersNew[h2][w2];
				//	System.out.print(arrayCovered[h2][w2]);
				}
				System.out.print("\n");
				
				//System.out.print("Please enter your age (<=0 for exit): "); 
				//age = Input.readInt(); 
				
		/*		for (int k = 0; k < row; k++) {
				    for (int l = 0; l < col; l++) {
				    //	arrayCovered[k][l]= '#';
				    	
				        System.out.print(arrayCovered[k][l]);
				     //   System.out.print(" ,");
				    }
				    System.out.print("\n");
				} */

//System.out.print("Please enter your age (<=0 for exit): "); 
				//age = Input.readInt(); 
				
			/*	for (int k = 0; k < row; k++) {
				    for (int l = 0; l < col; l++) {
				    //	arrayCovered[k][l]= '#';
				    	
				        System.out.print(arrayCovered[k][l]);
				     //   System.out.print(" ,");
				    }
				    System.out.print("\n");
				} */
	
	////////////////////////////////////////////////////////////////////////////////////////////	
/* 
/* 	 System.out.print(" TROTA \n");
/*/
						   // 	{
						    //	break;}
						    	//else {break;}
						    	
						    	//arrayNumbers[line1][column1] = arrayNumbersNew[line1][column1];
						    	//arrayNumbersNew[line1][column1] = 0;	
 //* 						  //  	else if (counter>(row*col/2) && arrayNumbers[line1][column1] ==0 )
						   // 	{
						    //	break;}
						    	//else {break;}
						    	
						    	//arrayNumbers[line1][column1] = arrayNumbersNew[line1][column1];
						    	//arrayNumbersNew[line1][column1] = 0;
						 /*   if (counter<=(row*col/2) )
				    	{
				    	break;} */
 /* 
 * 
 * switch (month) {
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
		    	int[] solutionArray = { 1, 2, 3, 4, 5, 6, 16, 15, 14, 13, 12, 11 };

		    shuffleArray(solutionArray);
		    for (int i = 0; i < solutionArray.length; i++)
		    {
		      System.out.print(solutionArray[i] + " ");
		    }
		    System.out.println();	
		    
		    
		  //  	else if (counter>(row*col/2) && arrayNumbers[line1][column1] ==0 )
		   // 	{
		    //	break;}
		*
		*
		*/
