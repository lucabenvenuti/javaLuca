public class LoveIndex {
	public static void main(String[] args) { 
		char charRead;
		int char2int = 0,  i = 0, j = 0, sumFirstName = 0, sum = 0, rest = 0, sumSecondName = 0;
		
		System.out.print("Insert your name and the name of your partner (separation by one or more spaces): "); 
		
	    charRead = Input.readCharSequence();
		char2int = (int) charRead;

		while (char2int != 10) {
			
			if (char2int == 32 && j==0){
			}
			else if (char2int == 32 && j==1){
				charRead = Input.readCharSequence();
				char2int = (int) charRead;
				i=i+1;
				break;
			}
			else if (char2int <= 122 && char2int >= 97 ){
				char2int = char2int-32;
				sumFirstName = sumFirstName + char2int;
				j=1;
			}
			else if (char2int <= 90 && char2int >= 65 ){
				sumFirstName = sumFirstName + char2int;
				j=1;
			}
			else{
				System.out.print("Invalid input detected");
				return;
			}
			charRead = Input.readCharSequence();
			char2int = (int) charRead;
			i=i+1;
		}

		if (sumFirstName == 0){
			System.out.print("The love index can only be calculated for 2 names");
			return;
		}
		
		j = 0;
		
		while (char2int != 10) {
			
			if (char2int == 32 && j==0){
			}
			else if (char2int == 32 && j==1){
				break;
			}
			else if (char2int <= 122 && char2int >= 97 ){
				char2int = char2int-32;
				sumSecondName = sumSecondName + char2int;
				j=1;
			}
			else if (char2int <= 90 && char2int >= 65 ){
				sumSecondName = sumSecondName + char2int;
				j=1;
			}
			else{
				System.out.print("Invalid input detected");
				return;
			}
			charRead = Input.readCharSequence();
			char2int = (int) charRead;
			i=i+1;
		}
		
		if (sumSecondName == 0){
			System.out.print("The love index can only be calculated for 2 names");
			return;
		}
		
		sum = sumFirstName + sumSecondName;
		rest = sum % 101;
		
		System.out.printf("Love index: %d %% \n", rest); 
  }

}


/*		System.out.println("Value of obj: " + Arrays.toString(array1));
System.out.println("Value of obj2: " + array1[1]);
System.out.println("Value of obj2: " + array1[2]);
System.out.println("Value of obj2: " + sumFirstName);
System.out.println("Value of obj2: " + sumSecondName);
System.out.println("Value of obj2: " + sum);
System.out.println("Value of obj2: " + rest); */


/*
import java.util.Arrays;


		int[] array1 = new int[50];
		
		System.out.print("Please enter your height in cm (<=0 for exit): "); 
		char charRead = Input.readCharSequence();
		int char2int;
		char2int = (int) charRead;
		int i = 0;
		int j = 0;
		int sumFirstName = 0;
		while (char2int != 10) {
			
			if (char2int == 32 & j==0){
				
			//	i=i+1;
			}
			else if (char2int == 32 & j==1){
				array1[i] = char2int;
				charRead = Input.readCharSequence();
				char2int = (int) charRead;
				i=i+1;
				break;
			}
			else if (char2int <= 122 & char2int >= 97 ){
				char2int = char2int-32;
				sumFirstName = sumFirstName + char2int;
				j=1;
			}
			else if (char2int <= 90 & char2int >= 65 ){
				sumFirstName = sumFirstName + char2int;
				j=1;
			}
			else{
				System.out.print("Invalid input detected");
				return;
			}

			array1[i] = char2int;
			charRead = Input.readCharSequence();
			char2int = (int) charRead;

			i=i+1;
		}

		if (sumFirstName == 0){
			System.out.print("The love index can only be calculated for 2 names");
			return;
		}
		
		j = 0;
		int sumSecondName = 0;

		
		while (char2int != 10) {
			
			if (char2int == 32 & j==0){
			}
			else if (char2int == 32 & j==1){
				break;
			}
			else if (char2int <= 122 & char2int >= 97 ){
				char2int = char2int-32;
				sumSecondName = sumSecondName + char2int;
				j=1;
			}
			else if (char2int <= 90 & char2int >= 65 ){
				sumSecondName = sumSecondName + char2int;
			//	i=i+1;
				j=1;
			}
			else{
				System.out.print("Invalid input detected");
				return;
			}
			
			array1[i] = char2int;
			charRead = Input.readCharSequence();
			char2int = (int) charRead;

			i=i+1;
		}
		
		if (sumSecondName == 0){
			System.out.print("The love index can only be calculated for 2 names");
			return;
		}
		
		int sum = sumFirstName + sumSecondName;
		
		int rest = sum % 101;
		

		System.out.printf("Love index: %d %% \n", rest); 

*/