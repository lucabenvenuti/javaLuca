import java.util.Arrays;
import java.util.List;


public class SlotMachineCalc {
	
	private int score = 0;
	
	public char[] array;// = "";
	public int[] array2;
	public char tempChar;
//	public char tempChar2;
//	public int tempInt;
	
/*	public int getArray2(int index) {
		return array2[index];
	}
	
	public void setArray2(int index, int newValue) {
		array2[index]=newValue;
		}*/
	
	public void setScore(List obtainedList) {
		if(obtainedList.isEmpty()){}
		else {		
			char array[] = new char[obtainedList.size()];   
			int array2[] = new int[obtainedList.size()];   
		//	System.out.println(obtainedList.size());
			
			for (int i=0; i < obtainedList.size(); i++){
				array[i] = (Character) obtainedList.get(i);
				array2[i] = Reel.SYMBOLS.indexOf(array[i])+9;
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
			System.out.println(Arrays.toString(array2));
	//		System.out.println(array2);
		/*	System.out.println(Reel.SYMBOLS.indexOf((Character) obtainedList.get(1)));
			
			
		/*	
			
			
			if(array2[0]==array2[1]) {//try equals
				System.out.println("trota");
			}
			else if (array2[0]==(array2[1]-1)){//try straight
				System.out.println("trota2");
			}
			else{//loser
				System.out.println("trotaculo");
			}*/
			
			
			//array[0] = (Character) obtainedList.get(0);
	//		System.out.println(array);
			
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