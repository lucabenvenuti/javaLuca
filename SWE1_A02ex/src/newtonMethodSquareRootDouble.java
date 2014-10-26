//package stem.out;

//import Input;

public class newtonMethodSquareRootDouble {
	public static void main(String[] args) { 
		double x = 0, e = 0, r1 = 0, r0 = 0 , eTest = 0 ;
		int i=0;
		System.out.print("Please enter your x (<=0 for exit): "); 
		x = Input.readDouble(); 
		
		if (x>0) {
		} else {
			System.out.print("Uncapable of handling imaginary numbers: restart");
			return;
		}
		
		r1 = x;
		System.out.print("Please enter your e: "); 
		e = Input.readDouble(); 
		
		if (x>0) {
		} else {
			System.out.print("e must be bigger than zero: restart");
			return;
		}
		
		do{
			r0 = r1;
			r1=0.5*(r0+x/r0);

			eTest = Math.abs(r1-r0);
			i=i+1;
		} while (eTest>=e);

		System.out.printf("Square root: %.5f \n",r1); 
		System.out.printf("Error made: %.5f \n", eTest); 
		System.out.printf("Loop made: %d \n", i); 
  }

}
