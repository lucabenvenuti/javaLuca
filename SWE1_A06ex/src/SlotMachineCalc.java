import java.util.Arrays;
import java.util.List;


public class SlotMachineCalc {
	
	private int score = 0;
	
	public char[] array;// = "";
	public int[] array2;
	public char tempChar;
	public boolean testEquals = false;
	public boolean testStraight = false;
//	public char tempChar2;
//	public int tempInt;
	
/*	public int getArray2(int index) {
		return array2[index];
	}
	
	public void setArray2(int index, int newValue) {
		array2[index]=newValue;
		}*/
	
	public int getScore() {
		return score;
	}
	
	public void setScore(List obtainedList) {
		if(obtainedList.isEmpty()){}
		else {		
			char array[] = new char[obtainedList.size()];   
			int array2[] = new int[obtainedList.size()];   
		//	System.out.println(obtainedList.size());
			
			for (int i=0; i < obtainedList.size(); i++){
				array[i] = (Character) obtainedList.get(i);
				array2[i] = Reel.SYMBOLS.indexOf(array[i])+ Reel.MINIMALVALUE;
		/*		tempChar = (Character) obtainedList.get(i);
				array[i] = tempChar;
				switch (tempChar) {
				case '9': array2[i]=9;break;//System.out.println("trota");break;
				case 'X': array2[i]=10;break;
				case 'B': array2[i]=11;break;
				case 'Q': array2[i]=12;break;
				case 'K': array2[i]=13;break;
				case 'A': array2[i]=14;break;
				default:array2[i]=20;
				}*/
		//		System.out.println(i);
			//	System.out.println(array2[i]);
	//			System.out.format("%d \n",tempInt); 
		//		tempInt= ((int)(tempChar2)+1);
		//		array2[i]=tempInt;
			}
	//		System.out.println(Arrays.toString(array2));
	//		System.out.println(array2);
		/*	System.out.println(Reel.SYMBOLS.indexOf((Character) obtainedList.get(1)));*/
			
			
		/*	for(int i = 0; i < array2.length; i++){
				array2[i]=13;
			}
	/*	//	array2[3]=10;*/
		/*	array2[0]=10;
			array2[1]=11;
			array2[2]=12;
		//	array2[3]=13;
		//	array2[4]=14;*/
			
			if(array2[0]==array2[1]) {//try equals
				testEquals = true;		
				for(int i = 2; i < array2.length; i++){
					if (array2[i]==array2[0]&& testEquals){
						testEquals = true;			
					}else {testEquals = false;}
					
				}
				
				if (testEquals){
					if (array2[0]==(Reel.MAXIMALVALUE-1)){//all W, money back
				//		System.out.println("W");
						score=1;
					}
					else if (array2[0]==(Reel.MAXIMALVALUE)){//all R, free re-spin
					//	System.out.println("R");
						score=0;
					}
					else{// all real cards and equals, win money
					//	System.out.println("great");
						score=2;
					}
				}
				else{//loser
					score=-1;
			//		System.out.println("loser");
				}
			}
			else if (array2[0]==(array2[1]-1)){//try straight
				testStraight = true;	
				for(int i = 2; i < array2.length; i++){
					if (array2[i]==(array2[0]+i)&& testStraight && array2[i]<=Reel.ACEVALUE){
						testStraight = true;			
					}else {testStraight = false;}
					
				}				
				if (testStraight && (array2[array2.length-1]==Reel.ACEVALUE)){
			//		System.out.println("royal straight winner");
					score=4;
				} else if (testStraight){
			//		System.out.println("straight winner");
					score=3;
				} else{//loser
					score=-1;
			//		System.out.println("loser3");
				}
		//		System.out.println("trota2");
				
				
			} else{//loser
				score=-1;
		//		System.out.println("loser2");
			}
			
			if (score>1){
				switch(obtainedList.size()){
				case 4: score = score*2;break;
				case 5: score = score*3;break;
				default: //score=score;
				}
			}
			//array[0] = (Character) obtainedList.get(0);
		//	System.out.println(score);
			
	//		int temp =0;
			
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
			
			
			
/*			setArray2(0,array[0]);
			/*String array[] = new String[obtainedList.size()];  
			for(int j =0;j<obtainedList.size();j++){
				  array[j] = obtainedList.get(j);
				}
			System.out.println(array);
			
	/*		int[] arrayPlayed =new int [obtainedList.size()];
			for (int i=0; i < obtainedList.size(); i++){
				arrayPlayed[i]=(int) obtainedList.get(i);
				
			}
			
			
		/*	if (((int)obtainedList.get(0))==((int)obtainedList.get(1)+1)){ //try straight
								
			}
			else if */
			
			
			
			
	/*		for (int i=0; i < obtainedList.size(); i++){
			
			score =1;}*/
			}
	}
}