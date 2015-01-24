//package at.jku.pervasive.swe14.UE12.tubeDisassembling;

public class TubeDisassembling {

	static boolean possible(int l, int l1, int l2, int l3) {
		
		// recursion anchor
		if (l == 0) {
			return true;
		
		// recursion anchor
		} else if (l < 0) {
			return false;

		} else {
			return possible(l - l1, l1, l2, l3) || 
				   possible(l - l2, l1, l2, l3) || 
				   possible(l - l3, l1, l2, l3);
		}
	}

	public static void main (String[] args) {
		System.out.println(possible(100,1,2,4));
		System.out.println(possible(26570,10,5,3));
	}
}
