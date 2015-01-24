
public class TubeAssembling {
	
	boolean possible(int length, int l1, int l2, int l3){
		if(length==0){
			return true;
		}	else {
			boolean solution = false;
			solution = solution || possible(length-l1,l1,l2,l3);
			solution = solution || possible(length-l2,l1,l2,l3);
			solution = solution || possible(length-l3,l1,l2,l3);
			return solution;
		}	
		
	//	return false;
	}
	
	boolean possible2(int length, int l1, int l2, int l3){
		if (possibleSingle(length, l1) || possibleSingle(length, l2) || possibleSingle(length, l3))
			return true;
		else return false;
		
	}

	boolean possibleSingle(int length, int lBis){
		if(length==0){
			return true;
		} else if (length>0){
			return possibleSingle(length-lBis,lBis);
		} else {return false;}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TubeAssembling newTubeAssembling = new TubeAssembling();
	//	System.out.println(newTubeAssembling.possible(120,11,9,7));
	//	System.out.println(newTubeAssembling.possible2(120,11,9,7));
		
		StringBuilder one = new StringBuilder("react");
		StringBuilder two = new StringBuilder("crate");
	//	one.replace(2,3, "");
		//System.out.println(isAnagram(one,two));
		int value = 100; String strVal = "trota"; 
		strVal += String.valueOf(value);
		System.out.println(strVal);
		
	}

	private static boolean isAnagram(StringBuilder one, StringBuilder two) {
		//System.out.println(one.length());
		boolean check = false;
		if (one.length() != two.length()) return false;
		else if (one.length()==0) return true;
		else {
			
			
			for (int i=0; i<one.length(); i++){
				
				if (one.charAt(0)==two.charAt(i)){
					check = isAnagram(new StringBuilder(one.substring(1)), two.replace(i, i+1,""));
					break;
				}
			}
			return check;
		}
	}

}
