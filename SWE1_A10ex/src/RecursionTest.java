
public class RecursionTest {
	
	private static int f (int i)
	{
	int y = 5;
	if (i < 0)
	return -1;
	for (; i > 0; i--)
	y += 3;
	return y;
	}

	private static int sumIterative (int max)
	{
	int k = 0;
	for (int i = max; i > 0; i--)
	k += i;
	return k;
	}
	
	private static int sumRecursive (int i)
	{
	if (i <= 0)
	return 0;
	return i + sumRecursive (i - 1);
	}
	
	
	public static void main(String[] args)
	{
	// ...
	//int resIt = sumIterative(5);
	System.out.println(sumIterative(5));
	//int resRec =sumRecursive(5);
	System.out.println(sumRecursive(5));
	// ...
	System.out.println(f(10));
	
	
	}
}
