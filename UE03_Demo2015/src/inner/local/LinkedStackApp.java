package inner.local;

public class LinkedStackApp {
	
	public static void main(String[] args) {
		
		LinkedStack stack = new LinkedStack(); 
		
		stack.push("A"); 
		stack.push("B"); 
		stack.push("C"); 
		
		for (Object o : stack)  {
			System.out.println(o); 
		}
		
		System.out.println(); 
		
		System.out.println(stack.top()); 
		stack.pop(); 
		System.out.println(stack.top()); 
		stack.pop(); 
		System.out.println(stack.top()); 
		stack.pop(); 
		
	}

}
