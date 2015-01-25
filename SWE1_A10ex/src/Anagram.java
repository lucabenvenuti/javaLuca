//package at.jku.pervasive.swe14.UE12.stringBuilder;

public class Anagram {

	public static void main(String[] arg) {
		String s1, s2;

		System.out.println ("first word ? ");
		s1 = Input.readString(); 
		System.out.println ("second word ? ");
		s2 = Input.readString(); 

		System.out.print ("The words are ");
		if (!isAnagram(s1, s2))
			System.out.print("NOT ");
		if (!isAnagram2(s1, s2))
			System.out.print("NOT ");
		System.out.print("anagrams.");
	} // end main
	
	private static boolean isAnagram2(String one, String two) {
		//boolean check = false;
		if (one.length() != two.length()) return false;
		else if (one.length()==0 && two.length()==0) return true;
		else {StringBuilder three = new StringBuilder(two);
			for (int i=0; i<one.length(); i++){
				if (one.charAt(0)==three.charAt(i)){
					return isAnagram(one.substring(1), three.replace(i, i+1,"").toString());
				//	break;
					}
			} return false;
		}}
	
	static boolean isAnagram (String s1, String s2) {
		boolean isAnagram = false;

		if (s1.length() == s2.length()) {
			// create editable copy of s2
			StringBuilder sb2 = new StringBuilder(s2);

			// strike out letters of s1 in sb2
			for (int i = 0; i < s1.length(); i++) {
				int pos = sb2.toString().indexOf(s1.charAt(i));
				if (pos != -1)
					sb2.setCharAt(pos, (char)0);
			} // end for

			// check if all letters are striked out
			int i = 0;
			while (i < sb2.length() && sb2.charAt(i) == (char)0)
				i++;
			isAnagram = (i == sb2.length());
		} // end if
		return isAnagram;
	} // end isAnagram
} // end Anagram