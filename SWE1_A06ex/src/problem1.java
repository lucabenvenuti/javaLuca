
public class problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double tax = 0.0;
		double income = 0.0;

		System.out.print("Enter your income (in euro): ");
		income = Input.readDouble();

		if (income > 60000.0) 
		{ 
			tax = 20235.0 + (income - 60000)/2.0; 
		} 
		else if (income > 25000.0)
		{ 
			tax = 5110.0 + (income - 25000.0)*15125.0/35000.0; 
		}
		else if (income > 11000.0)
		{ 
			tax = (income - 11000.0)*5110.0/14000.0; 
		} 
		else if (income > 0.0)
		{ 
			tax = 0.0; 
		} 
		else 
		{  
			System.out.print("wrong input"); 
			return;
		} // end of if

		System.out.format("taxes are %.2f euro", tax);
	
	}

}
