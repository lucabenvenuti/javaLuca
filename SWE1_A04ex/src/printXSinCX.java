

public class printXSinCX {
	
	public static double calcPower (double num, int power){
		double poweredNum = num;
		
		if (power==1){poweredNum = num;}
		else {


		
		while (power !=1){
			poweredNum = poweredNum * num; //n * 
			power = power -1;

		}
		}

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
		}
		}

		return nn; // leave the method aabb
		}
	
	public static double calcSine (double x){

		x = x%(2*Math.PI);
		double sinX = 0.0, adding = 0.0;
		int k = 3;
		
		
		sinX = x / calcFactorial(1) - calcPower(x, 3)/ calcFactorial(3) + calcPower(x, 5)/ calcFactorial(5);
		
		adding = calcPower(-1, k)*calcPower(x, (2*k+1))/calcFactorial(2*k+1);
		
//		double test = Math.abs(calcFactorial(2*k+1));

		
		while (Math.abs(adding)>10e-8) {
			
			sinX = sinX + adding; 
			k = k+1;
			adding = calcPower(-1, k)*calcPower(x, (2*k+1))/calcFactorial(2*k+1); //calcPower(-1, k)*
			
//			test = calcFactorial(2*k+1);
//			double testBis = calcPower(x, (2*k+1));

		 } 

		return sinX; // leave the method
		}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		int m = 0, l = 0, a = 0, b = 0, posStar =0,i = 0, lHalf = 0, k = 0 ;
		double c = 0.0, posStar2 =0.0, xx = 0.0, fx = 0.0 , xPrint = 0.0 , interval = 0.0,  xStart = 0.0;
		boolean col = true;


		

		
	System.out.print("Enter m (number of lines): "); 
	m = Input.readInt(); 	
	
	System.out.print("Enter l (number of columns): "); 
	l = Input.readInt(); 	
	
	System.out.print("Enter b (maximum value of the interval): "); 
	b = Input.readInt(); 	
	
	System.out.print("Enter a (minimum value of the interval) (a<b): "); 
	a = Input.readInt(); 	
	
	while (a>b) {
		System.out.print("Invalid input! (a<b): \n"); 
		System.out.print("Enter a (minimum value of the interval) (a<b): "); 
		a = Input.readInt(); 
	} 
	
	System.out.print("Enter c (multiplication factor): "); 
	c = Input.readDouble(); 	

	lHalf =  l/2 ;

	
    if (l % 2 == 0 ){
    	 col = true;

        }
     else{
    	 col = false;

        }
	

	interval = (b-a)*Math.PI/(m-1);
	xStart = a*Math.PI;

	System.out.format("Graph of the function: x*sin(c*x) on interval: [%d*Pi,%d*Pi] \n", a,b); 
	
	while (i<m){
		xx = interval*i;
		xPrint = xx +xStart;
		fx = xx* calcSine(c*xx);
		if (col){
			posStar = (int) ((int)(l*(b*Math.PI + fx))/(2*b*Math.PI)+1);}
		else {
			posStar = (int) ((int)(l*(b*Math.PI + fx))/(2*b*Math.PI) );
		}
		posStar2 = (l*(b*Math.PI + xx* calcSine(c*xx)))/(2*b*Math.PI);

		i = i+1;
				
		k = 0;
		while (k<l){
			if (k == posStar){
				System.out.print("*"); 
			}else if(k == lHalf){
		System.out.print("|"); 
			}else {
		System.out.print("-"); 
			}

		k = k+1;
		}
		System.out.format(" ( %.2f , %.2f , %d , %d  , %d, %d) \n", xPrint, fx, posStar, lHalf, k, i); 
	
	}
		
	}

}
//poweredNum2 = calcPower(num2, power2);
//factorialNum2 = calcFactorial(2*3+1);

//sineNum2 = calcSine(6);


//	sineNum2 = Math.abs(10e-8);
//	System.out.format("pippoH:  %.3f H:  %d H:  %.8f, H:  %d \n", xx, posStar, posStar2, i); 
//Graph of the function: x*sin(c*x) on interval: [1*Pi,2*Pi]
//System.out.println(sum); 
//System.out.print("\n");
//    System.out.println("You entered an odd number.");
//    System.out.println("You entered an even number.");

/*	while (k<=l){
if (k == posStar){
	System.out.print("*"); 
}else if(k == lHalf){
System.out.print("|"); 
}else {
System.out.print("-"); 
}
//System.out.println(sum); 
k = k+1;
}
System.out.print("\n");  */

//check if the columnns are odd or even
//posStar =22;

//	System.out.format("power:   %.4f  ", poweredNum); 
// do calculations here;
//poweredNum = num * power;


//System.out.format("rest  %.8f \n", sinX); 
//	xx = x * 8;
// do calculations here;

// n = n -1;
//	System.out.format("Hvv  %d ", nn); 

// n = n -1;

// do calculations here;
//double xx = 0.0;

//System.out.format("trotaaaa  %.8f, %.8f \n", adding, test); 
//		System.out.format("rest  %.8f, %.8f, %.8f \n", adding, test, testBis); 
//int power2=10 , n = 8, num2 = 10;
//double poweredNum2 = 2.0, factorialNum2 = 0.0, sineNum2 = 0.0;
//double trota = Math.PI, x = 1.85;

//double ;		double 
//double ;
//double ;
//double ;
//int ;

//int ;
//int ;


//posStar = (int) ((int)(l*(b*Math.PI + x* calcSine(c*x)))/(2*b*Math.PI));
//posStar2 = (l*(b*Math.PI + x* calcSine(c*x)))/(2*b*Math.PI);