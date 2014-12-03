import java.util.*;


public class SlotMachine {
	
	private int nOfWheels = 0;
	
	final static int INITIALMONEYSLOT = 200;

	
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
		System.out.printf("%d", nOfWheels);
	}

	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int moneyAvailable = 100, moneySlot = 200;
		boolean play = true, mustRePlay = false, poor = false;
		SlotMachine newRunSlotMachine = new SlotMachine();
		
		System.out.printf("Which SlotMachine type do you want to play with? 3,4,5 Reels \n"); 
		int numberOfWheels = Input.readInt(); 
		
		while (numberOfWheels<3 || numberOfWheels>5){
			System.out.printf("Which SlotMachine type do you want to play with? 3,4,5 Reels \n"); 
			numberOfWheels = Input.readInt();			
		}
		
		newRunSlotMachine.setNOfWheels(numberOfWheels);
		
		while(play){
		System.out.printf("Your Credit: %d \n", moneyAvailable); 
		System.out.printf("Hit Enter to spin or type exit to terminate the program \n"); 
		
		char keyboardInput;
		if(!mustRePlay){
			keyboardInput = Input.readCharSequence();
			
		}else {
			keyboardInput = 'c';
				}
		mustRePlay = false;
//		String userInput = "";
		int keyboardInputInt = (int) keyboardInput;
	
		if (keyboardInput=='e'){
	//		userInput += keyboardInput;
			while (keyboardInput !=10){
				keyboardInputInt = keyboardInputInt + (int) keyboardInput;
				keyboardInput = Input.readCharSequence();
		//		userInput += keyboardInput;
			}
			if (keyboardInputInt==543){//stop playing(mustRePlay){//
				break;
			}
			else{}
				}
		else if (poor){
			System.out.printf("%s%n", "Not enough credit. Please leave.");
		}
		else if (moneyAvailable>0){
			Reel newGameReel = new Reel();
			newGameReel.setReelIndex(newRunSlotMachine.getNOfWheels());
			newGameReel.spinning(newRunSlotMachine.getNOfWheels());//,test);
			
		if (moneyAvailable>0){
		
			SlotMachineCalc newGameSlotMachineCalc = new SlotMachineCalc();
			
			newGameSlotMachineCalc.setScore(newGameReel.getListSpinned());
			
			if (newGameSlotMachineCalc.getScore()==-1 || newGameSlotMachineCalc.getScore()>1){
				moneyAvailable = moneyAvailable +newGameSlotMachineCalc.getScore();
				if(newGameSlotMachineCalc.getScore()>1) {
			//		System.out.print("\n");
			//		System.out.printf("You have won the following amount of credit: %d \n", newGameSlotMachineCalc.getScore());}
				System.out.printf("%n%s%d%n","You have won the following amount of credit: ",newGameSlotMachineCalc.getScore());}
			} else if (newGameSlotMachineCalc.getScore()==0){//all R, free re-spin
				mustRePlay = true;
			//	System.out.print("\n");
			//	System.out.printf("You got a re-spin for free \n");
				System.out.printf("%n%s%n","You got a re-spin for free ");
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else if (newGameSlotMachineCalc.getScore()==1){//all W, money back
			//	System.out.print("\n");
			//	System.out.printf("You got your money back \n");
				System.out.printf("%n%s%n","You got your money back ");
			}
			else{}

			moneySlot = INITIALMONEYSLOT - moneyAvailable;}
			else {
			//	System.out.printf("Not enough credit. Please leave. \n");
				System.out.printf("%n%s%n","Not enough credit. Please leave. ");
				poor = true;
			}
			
		}
		else {
	//		System.out.printf("Not enough credit. Please leave. \n");
			System.out.printf("%n%s%n","Not enough credit. Please leave. ");
			poor = true;
		}
		System.out.printf("%n");
	//	System.out.println("\n");
	}
		
	//	System.out.printf("The SlotMachine contains %d credit \n", moneySlot); 
		System.out.printf("%n%s%d%s%n","The SlotMachine contains ", moneySlot, " credit ");
	}

}
