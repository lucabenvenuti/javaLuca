import java.util.Calendar;


public class RGBtoHSB {

	public static void main(String[] args) {
		int Rinput = 75, Ginput = 0, Binput = 130;
		double H = 0.0, S = 0.0, V = 0.0, R = 0.0, G = 0.0, B = 0.0, delta = 0.0, cMax = 0.0, cMin = 0.0;
		
		//input
		
		R = (double) Rinput; 
		G = (double) Ginput; 
		B = (double) Binput; 
		
		cMax = Math.max(R,G);
		if (B>cMax) cMax = B;
		
		cMin = Math.min(R,G);
		if (B<cMin) cMin = B;
		
		delta = cMax - cMin;
		
		System.out.format("The of thee is " + "%.3f, while the value of "
				+ "the integer variable is %.3f, and the string is %.3f \n", delta, cMin, cMax); 
		
		
		
		if (cMax==0.0){ //H = 0
		} else if (cMax==R){
			if ((G-B)==0.0 && delta==0.0){H = 0.0;} // (double)(60+360)%360;}
			else {
			H = (60*((G-B)/delta)+360)%360;}
		} else if (cMax==G){
			if ((B-R)==0.0 && delta==0.0){H = 0.0;} // = 180.0;}
			else {
				H = 60*(B-R)/delta + 120;}
		} else if (cMax==B){
			if ((R-G)==0.0 && delta==0.0){H = 0.0;} // = 300.0;}
			else {
				H = 60*(R-G)/delta + 240;}			
		} else {System.out.format("trotaculo");}
		
		if (delta==0.0 && cMax ==0.0){S = 0.0;}
		else {S = delta/cMax;}
		
		V = cMax/255.0;
	//	H = (((45.0)/(117.0))%6)*60;
		System.out.format("The of thee is " + "%.3f, while the value of "
				+ "the integer variable is %.3f, and the string is %.3f", H,S,V); 
		

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

	