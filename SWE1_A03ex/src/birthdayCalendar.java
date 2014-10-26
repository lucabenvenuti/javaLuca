//import java.util.Date;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
import java.util.Calendar;


public class birthdayCalendar {

	public static void main(String[] args) {
		int year = 0, month = 0, days = 0, daysMax = 0, m = 0, x = 0, y = 0, d = days, weekday = 0, yearPrint = 0 ;
		int yearNow = Calendar.getInstance().get(Calendar.YEAR);
		int monthNow = Calendar.getInstance().get(Calendar.MONTH);
		monthNow = monthNow + 1; //It's just part of the horrendous mess which is the Java date/time API
		int dayNow = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		boolean leapyear; // = true;
		
		System.out.print("Please enter your birth year: "); 
		year = Input.readInt(); 
		System.out.print("Please enter your birth month: "); 
		month = Input.readInt(); 
		System.out.print("Please enter your birth day: "); 
		days = Input.readInt(); 
		
		if (year < 2015 & year > 1582){
			leapyear = ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
		}
		else{
			System.out.print("Invalid year (1582 <= YYYY <= 2014)");
			return;
		}
		
		if (month <= 12 & month >0){
		}
		else{
			System.out.print("Invalid month");
			return;
		}
		
		switch (month) {
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
		}

//		System.out.println(days + " days");
		
		if (days <= daysMax & days >0){
		}
		else{
			System.out.print("Invalid days detected");
			return;
		}
	
		
		if (month >= 3){
			m = month - 2;
			x = 8;
			y = year;
			}
		else{
			m = month;
			x = 13;
			y = year - 1;
		}
		
		weekday = (x + d + (31*m)/12 + (5*y)/4 - (3*(1+y/100)/4) ) % 7;
		

		System.out.printf("Error made: %d \n", yearNow); 
		System.out.printf("Error made: %d \n", monthNow); 
		System.out.printf("Error made: %d \n", dayNow); 
		System.out.printf("Error made: %d \n", weekday); 
		
		if (monthNow > month ){
			yearPrint = yearNow +1;
		} else if (monthNow == month){
			if (dayNow > days){yearPrint = yearNow +1;}
			else if (dayNow == days){yearPrint = yearNow +1;}
			else{yearPrint = yearNow;}	
		}
		else {yearPrint = yearNow;}
		
		String assessment = null;
		assessment = "hot like hell";
		
		System.out.printf("Your birthday in %d will be on:  + rest + and you will be: 26: %d \n", yearNow); 
		
	}

}

/*for(int x = 10; x < 20; x = x+1) {
    System.out.print("value of x : " + x );
    System.out.print("\n");
 } */

//if (year < 2015 & year > 1582 & year != 1600 & year != 2000 ){			

/*		 rest = year % 4;
	if (rest==0)
		leapyear = true;
	else
		leapyear = false;
}
else if (year == 1600 | year == 2000){
	leapyear = false; */