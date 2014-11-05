

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
		
//		System.out.format("trotaaaa  %.8f, %.8f \n", adding, test); 
		
		while (Math.abs(adding)>10e-8) {
			
			sinX = sinX + adding; 
			k = k+1;
			adding = calcPower(-1, k)*calcPower(x, (2*k+1))/calcFactorial(2*k+1); //calcPower(-1, k)*
			
			test = calcFactorial(2*k+1);
			double testBis = calcPower(x, (2*k+1));
	//		System.out.format("rest  %.8f, %.8f, %.8f \n", adding, test, testBis); 
		 } 
		
//		System.out.format("rest  %.8f \n", sinX); 
	//	xx = x * 8;
		// do calculations here;
		return sinX; // leave the method
		}
	

	public static void main(String[] args) {
		int m = 35, l = 45, a = 0, b = 2;
		double c = 1.5;
		int power2=10 , n = 8, num2 = 10, posStar =0;
		double poweredNum2 = 2.0, factorialNum2 = 0.0, sineNum2 = 0.0, posStar2 =0.0;
		double trota = Math.PI, x = 1.85;
		

		
//	poweredNum2 = calcPower(num2, power2);
//	factorialNum2 = calcFactorial(2*3+1);
	
//	sineNum2 = calcSine(6);
		
	System.out.print("m: "); 
	m = Input.readInt(); 	
	
	System.out.print("l: "); 
	l = Input.readInt(); 	
	
	System.out.print("b: "); 
	b = Input.readInt(); 	
	
	System.out.print("a: "); 
	a = Input.readInt(); 	
	
	System.out.print("c: "); 
	c = Input.readDouble(); 	
		
	
	posStar = (int) ((int)(l*(b*Math.PI + x* calcSine(c*x)))/(2*b*Math.PI));
	posStar2 = (l*(b*Math.PI + x* calcSine(c*x)))/(2*b*Math.PI);
	


	int lHalf = (int) l/2 -1;
	//posStar =22;
	int k = 0;
	while (k<=l){
		if (k == posStar){
			System.out.print("*"); 
		}else if(k == lHalf){
	System.out.print("|"); 
		}else {
	System.out.print("-"); 
		}
//	System.out.println(sum); 
	k = k+1;
	}
	System.out.print("\n"); 
	
	
	System.out.format("H:  %.3f H:  %d H:  %.8f, H:  %.8f \n", poweredNum2, posStar, posStar2, sineNum2); 
	
	//int nLines = (b-a)/m;
	double interval = (b-a)*Math.PI/m;
	double xx = 0.0;
	double fx = 0.0;
	int i = 0;
	
	while (i<=m){
		xx = interval*i;
		fx = xx* calcSine(c*xx);
		posStar = (int) ((int)(l*(b*Math.PI + fx))/(2*b*Math.PI));
		posStar2 = (l*(b*Math.PI + xx* calcSine(c*xx)))/(2*b*Math.PI);

	//	System.out.format("pippoH:  %.3f H:  %d H:  %.8f, H:  %d \n", xx, posStar, posStar2, i); 
		i = i+1;
		
		
		k = 0;
		while (k<=l){
			if (k == posStar){
				System.out.print("*"); 
			}else if(k == lHalf){
		System.out.print("|"); 
			}else {
		System.out.print("-"); 
			}
//		System.out.println(sum); 
		k = k+1;
		}
		System.out.format("( %.3f , %.8f ) \n", xx, fx); 
//		System.out.print("\n"); 
		
	}
		
	}

}

//	sineNum2 = Math.abs(10e-8);
