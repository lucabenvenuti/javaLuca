import java.util.*;

public class Reel {
		public final static String SYMBOLS = "9XBQKAWR";
		public final static int MINIMALVALUE = 9;
		public final static int MAXIMALVALUE = 16;
		public final static int ACEVALUE = 14;
	
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
			//System.out.println (reelIndex);
			System.out.printf("%d%n", reelIndex);
		}
		

		
		public List listSpinned = new ArrayList();
		
		public List<String> getListSpinned() {
		    return listSpinned;
		}
		

		
		
		private Random rndGen = new Random(System.nanoTime() + getReelIndex());
		public int randomSpinning = rndGen.nextInt(SYMBOLS.length());
		public char tempChar = 'a';


		public void spinning(int reelIndex){
		//	System.out.print("[");
			System.out.printf("%s", "[");
			for (int i=0; i < getReelIndex(); i++){
				randomSpinning = rndGen.nextInt(SYMBOLS.length());
				tempChar = SYMBOLS.charAt(randomSpinning);
				// tempChar = 'A'; test input
				listSpinned.add(tempChar);
			//	System.out.print(tempChar);
				System.out.printf("%c", tempChar);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (i<getReelIndex()-1) System.out.print("|");
				
			}
			//System.out.print("]");
			System.out.printf("%s", "]");
		}

}
