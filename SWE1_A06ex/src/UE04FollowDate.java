//package at.jku.pervasive.swe14.a04;
/**
 * Software Development I, 2014WS
 * Institute for Pervasive Computing, JKU Linz
 * @author Andreas Riener
 * @version 2014-10-23
 */

public class UE04FollowDate {
	public static void main(String[] args) 
	{ 
		int day; 
		int month; 
		int nrOfDays = 0; 

		day   = Input.readInt();
		month = Input.readInt();
		System.out.print("Given date: " + day + "." + month + "., ");

		switch(month)
		{ 
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:	nrOfDays = 31; 
		break; 
		case 2: nrOfDays = 28;	
		break; 
		case 4: case 6: case 9: case 11: nrOfDays = 30;
		break; 
		} // end of switch

		//continued on next page
		if (day < nrOfDays)
			day = day + 1; 
		else {
			day = 1; month = month + 1;

			if (month == 13)
				month = 1; 
		}
		System.out.println("date of the next day: " + day + "." + month + "."); 

	} // end of main
} // end of class UE04FollowDate