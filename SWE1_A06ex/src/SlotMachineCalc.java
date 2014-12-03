//import java.util.Arrays;
import java.util.List;


public class SlotMachineCalc {
	
	private int score = 0;
	
	public char[] array;
	public int[] array2;
	public char tempChar;
	public boolean testEquals = false, testStraight = false;
	
	public int getScore() {
		return score;
	}
	
	public void setScore(List obtainedList) {
		if(obtainedList.isEmpty()){}
		else {		
			char array[] = new char[obtainedList.size()];   
			int array2[] = new int[obtainedList.size()];   
			for (int i=0; i < obtainedList.size(); i++){
				array[i] = (Character) obtainedList.get(i);
				array2[i] = Reel.SYMBOLS.indexOf(array[i])+ Reel.MINIMALVALUE;
				}
			
			if(array2[0]==array2[1]) {//try equals
				testEquals = true;		
				for(int i = 2; i < array2.length; i++){
					if (array2[i]==array2[0]&& testEquals){
						testEquals = true;			
					}else {testEquals = false;}
					
				}
				
				if (testEquals){
					if (array2[0]==(Reel.MAXIMALVALUE-1)){//all W, money back
						score=1;
					}
					else if (array2[0]==(Reel.MAXIMALVALUE)){//all R, free re-spin
						score=0;
					}
					else{// all real cards and equals, win money
						score=2;
					}
				}
				else{//loser
					score=-1;
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
					score=4;
				} else if (testStraight){
					score=3;
				} else{//loser
					score=-1;
				}
		
			} else{//loser
				score=-1;
			}
			
			if (score>1){
				switch(obtainedList.size()){
				case 4: score = score*2;break;
				case 5: score = score*3;break;
				default: //score=score;
				}
			}

			}
	}
}