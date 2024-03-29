import java.util.*;



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
		boolean newGen = false, continuation = true;		
		int keyboardInputInt = 0, counter =0, counter2 =0, counter3 =0, y = 0, playerNum = 1, playerPrint = 2, h1 = 0, w1 =0, h2 =0, w2 = 1, score1 = 0, score2 = 0;
		char keyboardInput = '!';
		double x = 0.0;
	
		System.out.print("Playground-height: "); 
		int row = Input.readInt(); 
		System.out.print("Playground-width: "); 
		int col = Input.readInt(); 

		
		while (row<1 || col<1 || row*col>156 || row*col<4 || row*col%2==1){
			//the while with OR-OR are read in order, when the first condition is true, it does not read the following			
			if (row<1 || col<1 || row*col>156 || row*col<4){
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
		
		int [][] arrayNumbers = new int [row][col];
		int [] arrayStorage = new int [row*col/2];
		char [][] arrayLettersNew = new char [row][col];
		char [][] arrayCovered = new char [row][col];

		 for (int column1 = 0; column1 < col; column1++) {
		    for (int line1 = 0; line1 < row; line1++) {
		    	if (counter<(row*col/2) && arrayNumbers[line1][column1] ==0 )
		    	{
		    		//while it is true the while goes
		    		// I want to continue until I get a random that is not in the list //!newGen
		    		counter2 = 0;
		    		newGen = true;
		    		while (newGen){
		    			
		    			if (counter2 > 1000){break;}
		    			
			    		newGen = false;
			    		x = Math.random()*77; //if x = 0 ==> y = 48 // if x = 1 ==> y = 125 // ==> 78 different numbers
			    		y = (int) (Math.round(x)+48);	 //if x = 0 ==> y = 48 // if x = 1 ==> y = 125 // ==> 78 different numbers
			    					    		
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

		    
			 for (int column1 = 0; column1 < col; column1++) {
				    for (int line1 = 0; line1 < row; line1++) {
				    	if (arrayNumbers[line1][column1] ==0 ) //counter>(row*col/2 -1) && 
				    	{arrayNumbers[line1][column1] = arrayStorage[counter3];
					    	counter3 = counter3 +1;}
						    }
						}
			
				for (int k = 0; k < row; k++) {
				    for (int l = 0; l < col; l++) {
				    	arrayLettersNew[k][l]= (char)arrayNumbers[k][l];
				    }
				} 

				

	
				for (int k = 0; k < row; k++) {
				    for (int l = 0; l < col; l++) {
				    	arrayCovered[k][l]= '#';
				    	
				        System.out.print(arrayCovered[k][l]);

				    }
				    System.out.print("\n");
				} 
				
				////FIRST INPUT

				System.out.format("--- Player %d --- \n", playerNum);

				
				System.out.print("h1: "); 
				h1 = Input.readInt(); 
				System.out.print("w1: "); 
				w1 = Input.readInt(); 
				
				while (h1>row || w1>col || h1<1 || w1<1){
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
				
				
				while (h2>row || w2>col || (h1==h2 && w1==w2) || h2<1 || w2<1){
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
				
				while(continuation){
				
				for (int k = 0; k < row; k++) {
				    for (int l = 0; l < col; l++) {
				    	
				    	
				    	if((k==h1 && l == w1) || (k==h2 && l == w2)){
				    		System.out.print(arrayLettersNew[k][l]);
				    	}
				    	else  { 
				    		 System.out.print(arrayCovered[k][l]);
				    	}

				    }
				    System.out.print("\n");
				} 
				System.out.print("\n");
				
				if (arrayLettersNew[h1][w1]==arrayLettersNew[h2][w2]){
					arrayCovered[h1][w1]= '#';
					arrayCovered[h1][w1]=arrayLettersNew[h1][w1];
					arrayCovered[h2][w2]= '#';
					arrayCovered[h2][w2]=arrayLettersNew[h2][w2];

					if (playerNum%2==0){
						
						score2 = score2+1;
					}
					else{
						
						score1 = score1+1;
					}
					
				}
				else{
					playerNum = playerNum+1;
				}
				
				if ((score1+score2)==row*col/2){
					break;
				} else 
				{	System.out.print("'q'/'Q' to quit, <Enter> to continue... (any other key + Enter to abort) ");
					keyboardInput = Input.readCharSequence();
					keyboardInputInt = (int) keyboardInput;
					
					if (keyboardInput=='q' || keyboardInput == 'Q'){
					//System.out.print("GAME FINISHED \n");
					break;
						}
						else if(keyboardInputInt == 10) {
											
						//System.out.print("LET'S PLAY \n");
						if (playerNum%2==0){playerPrint = 2;}
						else{playerPrint = 1;}
						System.out.format("--- Player %d --- \n", playerPrint);
						
						System.out.print("h1: "); 
						h1 = Input.readInt(); 
						System.out.print("w1: "); 
						w1 = Input.readInt(); 
						
						while (h1<1 || w1<1 || h1>row || w1>col || (arrayCovered[h1-1][w1-1] != '#')){
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
	
						while (h2<1 || w2<1 || h2>row || w2>col || (h1==h2 && w1==w2) || (arrayCovered[h2-1][w2-1] != '#')){
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
					return;
				}
				}
				}
				
				System.out.format("Player 1 scores %d \n", score1);
				System.out.format("Player 2 scores %d \n", score2);
				
	}
}
