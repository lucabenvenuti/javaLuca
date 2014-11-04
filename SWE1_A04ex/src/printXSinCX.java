

public class printXSinCX {
	
	public static double calcPower (double num, int power){
		double poweredNum = num;
		
		if (power==1){poweredNum = num;}
		else {

		//poweredNum = num * power;
		
		while (power !=1){
			poweredNum = poweredNum * num; //n * 
			power = power -1;
			// n = n -1;
		//	System.out.format("Hvv  %d ", nn); 
		}
		}
	//	System.out.format("power:   %.4f  ", poweredNum); 
		// do calculations here;
		return poweredNum; // leave the method
		}
	
	public static double calcFactorial (int n){
		double nn = (double) n;
		if (n==1){nn =1.0;}
		else{
		
		
		double nBis = (double) n - 1.0;
		
		while (nBis !=1){
			nn = nBis * nn; //n * 
			nBis = nBis -1;
			// n = n -1;

		}
		}

		// do calculations here;
		return nn; // leave the method
		}
	
	public static double calcSine (double x){
		//double xx = 0.0;
		x = x%(2*Math.PI);
		double sinX = 0.0, adding = 0.0;
		int k = 3;
		
		
		sinX = x / calcFactorial(1) - calcPower(x, 3)/ calcFactorial(3) + calcPower(x, 5)/ calcFactorial(5);
		
		adding = calcPower(-1, k)*calcPower(x, (2*k+1))/calcFactorial(2*k+1);
		
		double test = Math.abs(calcFactorial(2*k+1));
		
		System.out.format("trotaaaa  %.8f, %.8f \n", adding, test); 
		
		while (Math.abs(adding)>10e-8) {
			
			sinX = sinX + adding; 
			k = k+1;
			adding = calcPower(-1, k)*calcPower(x, (2*k+1))/calcFactorial(2*k+1); //calcPower(-1, k)*
			
			test = calcFactorial(2*k+1);
			double testBis = calcPower(x, (2*k+1));
			System.out.format("rest  %.8f, %.8f, %.8f \n", adding, test, testBis); 
		 } 
		
		System.out.format("rest  %.8f \n", sinX); 
	//	xx = x * 8;
		// do calculations here;
		return sinX; // leave the method
		}
	

	public static void main(String[] args) {
		int m = 0, l = 0, a = 0, b = 1;
		double c = 0.0;
		int power2=10 , n = 8, num2 = 10;
		double poweredNum2 = 2.0, factorialNum2 = 0.0, sineNum2 = 0.0;
		

		
	poweredNum2 = calcPower(num2, power2);
	factorialNum2 = calcFactorial(2*3+1);
	double trota = Math.PI;
	sineNum2 = calcSine(6);
	
	
	System.out.format("H:  %.3f H:  %.3f H:  %.8f", poweredNum2, factorialNum2, sineNum2); 
		
	}

}

//	sineNum2 = Math.abs(10e-8);
