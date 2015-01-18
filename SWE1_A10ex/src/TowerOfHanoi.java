
public class TowerOfHanoi {

	public static void D (int h, int a, int b)
	{
	System.out.println("Disc " + h + " from " + a + " to " + b);
	}
	public static void T (int h, int a, int b)
	{System.out.println("trota");
	if (h > 0)
	{
	T (h - 1, a, 3 - (a+b));
//	
	D (h, a, b);
	T (h - 1, 3 - (a+b), b);
	}
	}
	public static void main(String[] args)
	{
	T (3, 0, 2);
	}

}
