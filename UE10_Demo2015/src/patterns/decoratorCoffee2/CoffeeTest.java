package patterns.decoratorCoffee2;

public class CoffeeTest {
	
	public static void main(String[] args) {
		
		Coffee coffee1 = new JavaCoffee(new BlackCoffee());
		
		Coffee coffee2 = new MilkDecorator(coffee1);
		
		System.out.println(coffee2.getText());
		System.out.println(coffee2.getPrice());
		
		
/*		ContentLetter letter = new ContentLetter();
		letter.appendLine("This is a test letter.");
		letter.appendLine("It has two lines.");

		Letter formalLetter =
			new DateDecorator(
				new DearDecorator(
						new YoursSincerelyDecorator(
								letter, 
								"Paul", 
								"Smith"), 
						"Mrs.", 
						"Brown")
				);
		
		System.out.println(formalLetter.getText());
		System.out.println();
		System.out.println("--------------------------------------------------");

		Letter informalLetter = 
			new HelloDecorator(
				new BestWishesDecorator(
						letter, 
						"Paul", 
						"Smith", 
						false),
				"Susan");
		System.out.println(informalLetter.getText());*/
	}
}
