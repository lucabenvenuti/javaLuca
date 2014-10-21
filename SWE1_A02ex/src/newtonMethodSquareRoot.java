//package stem.out;

//import Input;

public class newtonMethodSquareRoot {
	public static void main(String[] args) { 
		float x = 0, e = 0, r1 = 0, r0 = 0 , eTest = 0 ;
		int i=0;
		System.out.print("Please enter your x (<=0 for exit): "); 
		x = Input.readFloat(); 
//		r0 = x;
		r1 = x;
		System.out.print("Please enter your e (<=0 for exit): "); 
		e = Input.readFloat(); 
		

		do{
			r0 = r1;
			r1=(float) (0.5*(r0+x/r0));
//			System.out.printf("pippo"); 
			eTest = Math.abs(r1-r0);
			i=i+1;
		} while (eTest>=e);

		System.out.printf("Square root: %.8f \n",r1); 
		System.out.printf("Error made: %.8f \n", eTest); 
		System.out.printf("Error made: %d \n", i); 
  }

}
