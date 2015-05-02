package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test01 {

	//public static void main(String[] args) {
		/*try {
			int n = Integer.parseInt("123");
			System.out.println(n);
		} catch (NumberFormatException e) {
			System.out.println("not a number");
		}*/


	    public static void main(String[] args) throws IOException { 
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        System.out.print("Enter String");
	        String s = br.readLine();
	        System.out.print("Enter Integer:");
	        try{
	            int i = Integer.parseInt(br.readLine());
	        }catch(NumberFormatException nfe){
	            System.err.println("Invalid Format!");
	        }
		
	}

}
