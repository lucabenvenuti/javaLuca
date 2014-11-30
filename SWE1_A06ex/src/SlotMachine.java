import java.util.*;


public class SlotMachine {
	
	private int nOfWheels = 0;
	
	

	
	public void setNOfWheels(int newNOfWheels) {
		if(newNOfWheels > 0)
			nOfWheels = newNOfWheels;
		else
			nOfWheels = 0;
		}
	
	public int getNOfWheels() {
		return nOfWheels;
	}
	public void printNOfWheels() {
		System.out.println (nOfWheels);
	}

	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int moneyAvailable = 100;
		int moneySlot = 100;
		boolean play = true;
		boolean mustRePlay = true;
		
		SlotMachine german = new SlotMachine();
		
		System.out.format("Which SlotMachine type do you want to play with? 3,4,5 Reels \n"); 
		int numberOfWheels = Input.readInt(); 
		
		while (numberOfWheels<3 || numberOfWheels>5){
			System.out.format("Which SlotMachine type do you want to play with? 3,4,5 Reels \n"); 
			numberOfWheels = Input.readInt();			
		}
		
		german.setNOfWheels(numberOfWheels);
		
		while(play){
		System.out.format("Your Credit: %d \n", moneyAvailable); 
		System.out.format("Hit Enter to spin or type exit to terminate the program \n"); 
		
		char keyboardInput = Input.readCharSequence();
		String userInput = "";
		int keyboardInputInt = (int) keyboardInput;
	//	System.out.println(keyboardInput);
		if (keyboardInput=='e'){
			userInput += keyboardInput;
			while (keyboardInput !=10){
				keyboardInputInt = keyboardInputInt + (int) keyboardInput;
			//	System.out.print(keyboardInputInt);
			//	System.out.print("\n");
				keyboardInput = Input.readCharSequence();
				userInput += keyboardInput;
			}
		//	System.out.print(userInput);
		//	System.out.print(keyboardInputInt);
		//	System.out.println("trota");
			if (keyboardInputInt==543){//stop playing(mustRePlay){//
				System.out.println("trota2");
				break;
			}
			else{
				
				
			}
			
			//System.out.print("GAME FINISHED \n");
		//	break;
				}
		//else if(keyboardInputInt == 10) {
		else{
			Reel germanic = new Reel();
			germanic.setReelIndex(german.getNOfWheels());
			//char[] test= germanic.createSymbolList(german.getNOfWheels());
			germanic.spinning(german.getNOfWheels());//,test);
			
			System.out.println(germanic.getListSpinned());
			
			
			SlotMachineCalc teutonic = new SlotMachineCalc();
			
			teutonic.setScore(germanic.getListSpinned());
			System.out.println(teutonic.getScore());
			
		}
	}
	//	while(keyboardInput!= -1 || keyboardInput != 'BS')
		

	//	System.out.println(teutonic.getArray2(0));
	}

}
