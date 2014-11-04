public class RGBtoHSB {

	public static void main(String[] args) {
		int Rinput = 1000, Ginput = 1000, Binput = -1000;
		double H = 0.0, S = 0.0, V = 0.0, R = 0.0, G = 0.0, B = 0.0, delta = 0.0, cMax = 0.0, cMin = 0.0;
		
		//input
		
		System.out.print("R: "); 
		Rinput = Input.readInt(); 
		
		while (Rinput<0 || Rinput>255) {
			System.out.print("R: "); 
			Rinput = Input.readInt(); 
		} 
		
		System.out.print("G: "); 
		Ginput = Input.readInt(); 
		
		while (Ginput<0 || Ginput>255) {
			System.out.print("G: "); 
			Ginput = Input.readInt(); 
		} 
		
		System.out.print("B: "); 
		Binput = Input.readInt(); 
		
		while (Binput<0 || Binput>255) {
			System.out.print("B: "); 
			Binput = Input.readInt(); 
		} 
		
		R = (double) Rinput; 
		G = (double) Ginput; 
		B = (double) Binput; 
		
		cMax = Math.max(R,G);
		if (B>cMax) cMax = B;
		
		cMin = Math.min(R,G);
		if (B<cMin) cMin = B;
		
		delta = cMax - cMin;
		
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
		System.out.format("H: %.3f S: "
				+ "%.3f V: %.3f", H,S,V); 
		

	}

}
