//package at.jku.pervasive.swe14.UE12.fibonacci;

public class Fibonacci {
	public static long fib(int a)
	{ if (a == 1) 	return 1;
	  else if (a == 2) 	return 1;
      else return fib(a-1) + fib(a-2);}
	
	public static void main (String[] args) {
		System.out.println((fib(10))); } }