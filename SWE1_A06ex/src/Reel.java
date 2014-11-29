import java.util.*;

public class Reel {
	private final static String SYMBOLS = "9XBQKAWR";
		private int reelIndex =0;
		
		public void setReelIndex(int newReelIndex) {
			if(newReelIndex > 0)
				reelIndex = newReelIndex;
			else
				reelIndex = 0;
			}
		
		public int getReelIndex() {
			return reelIndex;
		}
		public void printReelIndex() {
			System.out.println (reelIndex);
		}
		
		
		public char[] createSymbolList(int newReelIndex) {
			 //...
			 char[] symbolExtractedList2 = new char[newReelIndex];
			 //... set values ...
			 return symbolExtractedList2;
			}
		
		
		//public char[] symbolExtractedList = new char[getReelIndex()];
		
	//	public char[] symbolExtractedList;
		
		//public int[] saveList;// = new int[getReelIndex()];
		
	/*	public void setSymbolExtracted(int wheelIndex, char wheelChar) {
			//if(wheelIndex >= 0 && wheelIndex<getReelIndex())
				symbolExtractedList[wheelIndex] = wheelChar;
			//else
				//symbolExtractedList[wheelIndex] = wheelChar;
			}
		
	/*	public char getSymbolExtracted(int wheelIndex, char[] symbolExtractedList) {
			return symbolExtractedList[wheelIndex];
		}
	/*public void printSymbolExtracted(int wheelIndex) {
			System.out.println (symbolExtractedList[wheelIndex]);
		}*/
		
		
		
		
		private Random rndGen = new Random(System.nanoTime() + getReelIndex());
		//rndGen = new Random(System.nanoTime() + reelIndex);
		public int randomSpinning = rndGen.nextInt(SYMBOLS.length());
		public char tempChar = 'a';

//		public char[] spinning(int reelIndex, char[] symbolExtractedList) {
		public char[] spinning(int reelIndex){//, char[] symbolExtractedList) {	
			System.out.println(getReelIndex()); 
			char[] symbolExtractedList1 = createSymbolList(getReelIndex());
			
			//char[] symbolExtractedList = new char[getReelIndex()];
			System.out.println(symbolExtractedList1.length);
			System.out.format("\n"); 
			
			for (int i=0; i < getReelIndex(); i++){
				randomSpinning = rndGen.nextInt(SYMBOLS.length());
				tempChar = SYMBOLS.charAt(randomSpinning);
	//			this.saveList[i]=randomSpinning;
				symbolExtractedList1[i]=tempChar;
//				setSymbolExtracted(i, (char)randomSpinning);
	//			printSymbolExtracted(i);
				
				System.out.format("%d ", randomSpinning); 
				System.out.println(tempChar);
				System.out.println(symbolExtractedList1[i]);
				System.out.format("\n"); 
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		return symbolExtractedList1;
		}

}


/*	private char[] symbolExtracted (int nOfWheelsImported){
char[] symbolExtractedList = new char[nOfWheelsImported];
return symbolExtractedList; 

} //= '0';*/

// loop over all i wheels
/*try {
Thread.sleep(250);
} catch (InterruptedException e) {
e.printStackTrace();
}
// output of wheel i*/