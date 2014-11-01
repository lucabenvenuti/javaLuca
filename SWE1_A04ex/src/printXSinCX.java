import java.util.Calendar;


public class printXSinCX {

	public static void main(String[] args) {

		
	}

}

/*double pi = Math.PI; %.3f
double pi2 = pi*2;
double pi3 = pi*3;

//System.out.format("%.3f%n", pi);     // -->  "3.142"
//System.out.format("%.3f", pi);     // -->  "3.142"

System.out.format("The of thee is " + "%.3f, while the value of "
		+ "the integer variable is %.5f, and the string is %.7f", pi, pi2, pi3); */

/*		System.out.print("Please enter your birth year (YYYY): "); 
year = Input.readInt(); 

if (year < (yearNow) && year > 1582){
	leapyear = ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
}
else{
	System.out.println("Invalid yeardd (1582 <= YYYY < " + (yearNow) + ")");
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
 } */
