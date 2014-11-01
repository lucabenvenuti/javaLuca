import java.util.Calendar;


public class printXSinCX {

	public static void main(String[] args) {
		int year = 0, month = 0, days = 0, daysMax = 0, m = 0, x = 0, y = 0, d = 0,  yearPrint = 0, age =0 , weekday = 0, dateCheck =0, yearPrintStore = 0, ageRest = 0;
		int yearNow = Calendar.getInstance().get(Calendar.YEAR);
		int monthNow = Calendar.getInstance().get(Calendar.MONTH);
		monthNow = monthNow + 1; //It's just part of the horrendous mess which is the Java date/time API
		int dayNow = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		boolean leapyear; // = true;
		String dayOfTheWeek = null;
		
		System.out.print("Please enter your birth year (YYYY): "); 
		year = Input.readInt(); 
		
		if (year < (yearNow) && year > 1582){
			leapyear = ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
		}
		else{
			System.out.println("Invalid year! (1582 <= YYYY < " + (yearNow) + ")");
			return;
		}
		
		System.out.print("Please enter your birth month (M or MM, 0..12): "); 
		month = Input.readInt(); 
		
		if (month <= 12 && month >0){
		}
		else{
			System.out.print("Invalid month!");
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

		System.out.print("Please enter your birth day (D or DD, 0..31): "); 
		days =  Input.readInt(); 
		
		if (days <= daysMax && days >0){
		}
		else{
			System.out.print("Invalid number of days for this month!");
			return;
		}

		if (monthNow > month ){
			yearPrint = yearNow +1;
			dateCheck = 2;
		} else if (monthNow == month){
			if (dayNow > days){yearPrint = yearNow +1;; dateCheck = 2;}
			else if (dayNow == days){yearPrint = yearNow; dateCheck = 1;}
			else{yearPrint = yearNow;}	
		}
		else {yearPrint = yearNow;}
		
		if (month >= 3){
			m = month - 2;
			x = 8;
			y = yearPrint;
			}
		else{
			m = month;
			x = 13;
			y = yearPrint - 1;
		}
		d = days;
		weekday = (x + d + (31*m)/12 + (5*y)/4 - (3*(1+y/100)/4) ) % 7 ;
		
		switch (weekday) {
		case 0: dayOfTheWeek = "Saturday"; break;
		case 1: dayOfTheWeek = "Sunday"; break;
		case 2: dayOfTheWeek = "Monday";break;
		case 3: dayOfTheWeek = "Tuesday";break;
		case 4: dayOfTheWeek = "Wednesday";break;
		case 5: dayOfTheWeek = "Thursday";break;
		case 6: dayOfTheWeek = "Friday";break;
		}
	
		age = yearPrint - year;

		switch (dateCheck) {
		case 1: { System.out.println("Today is your birthday. Congratulations! Today is: "  + dayOfTheWeek + " and your age is: " + age );
		break;}//birthday today
		case 2: { 
			System.out.println("Your birthday in " + yearNow + " has already passed; birthday in " + yearPrint + " will be on "  + dayOfTheWeek + " and your age will be: " + age );
			break;} //birthday next year

		default:
			System.out.println("Your birthday in " + yearPrint + " will be on: "  + dayOfTheWeek + " and you will be: " + age ); //, yearNow); 
		}
		
		yearPrintStore = yearPrint;
		ageRest = age/10;
		
		for (int ageNew = ageRest * 10 + 10 ; ageNew < 101; ageNew = ageNew+10) {

			yearPrint = ageNew + year;
		    y = yearPrint;
		    weekday = (x + d + (31*m)/12 + (5*y)/4 - (3*(1+y/100)/4) ) % 7 ;
		    
			switch (weekday) {
			case 0: dayOfTheWeek = "Saturday"; break;
			case 1: dayOfTheWeek = "Sunday"; break;
			case 2: dayOfTheWeek = "Monday";break;
			case 3: dayOfTheWeek = "Tuesday";break;
			case 4: dayOfTheWeek = "Wednesday";break;
			case 5: dayOfTheWeek = "Thursday";break;
			case 6: dayOfTheWeek = "Friday";break;
			}
			yearPrint = ageNew + year;
			if (yearPrint!= yearPrintStore){
			System.out.println("Your birthday in " + yearPrint + " will be on: "  + dayOfTheWeek + " and you will be: " + ageNew);}
		 }

	}

}

//	int ageNew = ageRest * 10 + 10;

/*	System.out.printf("Error made: %d \n", yearNow); 
	System.out.printf("Error made: %d \n", monthNow); 
	System.out.printf("Error made: %d \n", dayNow); 
	System.out.printf("Error made: %d \n", weekday); 
				yearPrint = year + ageNew;
	*/

//	    System.out.print("value of x : " + ageNew );
//	    System.out.print("\n");


//	assessment = "hot like hell";

	