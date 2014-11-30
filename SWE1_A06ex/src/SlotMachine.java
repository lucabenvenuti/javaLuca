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
	//5	System.out.println (nOfWheels);
	}

	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int moneyAvailable = 100;
		int moneySlot = 200;
		boolean play = true;
		boolean mustRePlay = false;
		boolean poor = false;
		
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
		
		char keyboardInput;
		if(!mustRePlay){
			keyboardInput = Input.readCharSequence();
		}else {
			keyboardInput = 'c';
			mustRePlay = false;
		}
		
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
			//	System.out.println("trota2");
				break;
			}
			else{
				
				
			}
			
			//System.out.print("GAME FINISHED \n");
		//	break;
				}
		//else if(keyboardInputInt == 10) {
		else if (poor){
			System.out.format("Not enough credit. Please leave. \n");
		}
		else if (moneyAvailable>0){
			Reel germanic = new Reel();
			germanic.setReelIndex(german.getNOfWheels());
			//char[] test= germanic.createSymbolList(german.getNOfWheels());
			germanic.spinning(german.getNOfWheels());//,test);
			
		//	System.out.println(germanic.getListSpinned());
			if (moneyAvailable>0){
		//	moneyAvailable = moneyAvailable -1;
			SlotMachineCalc teutonic = new SlotMachineCalc();
			
			teutonic.setScore(germanic.getListSpinned());
			//System.out.println("\n");
			if (teutonic.getScore()==-1 || teutonic.getScore()>1){
				moneyAvailable = moneyAvailable +teutonic.getScore();
				if(teutonic.getScore()>1) {
					System.out.print("\n");
					System.out.format("You have won the following amount of credit: %d \n", teutonic.getScore());}
			} else if (teutonic.getScore()==0){//all R, free re-spin
				//moneyAvailable = moneyAvailable
				mustRePlay = true;
				System.out.format("You got a re-spin for free \n");
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (teutonic.getScore()==1){//all W, money back
				//moneyAvailable = moneyAvailable
				System.out.format("You got your money back \n");
			}
			else{}
			//moneyAvailable = moneyAvailable -1;
			
		//	System.out.println("\n");
		//	System.out.println(moneyAvailable);
			moneySlot = INITIALMONEYSLOT - moneyAvailable;}
			else {
				System.out.format("Not enough credit. Please leave. \n");
				poor = true;
			}
			
		}
		else {
			System.out.format("Not enough credit. Please leave. \n");
			poor = true;
		}
		
		System.out.println("\n");
	}
	//	while(keyboardInput!= -1 || keyboardInput != 'BS')
		
		System.out.format("The SlotMachine contains %d credit \n", moneySlot); 
		//System.out.println(moneySlot);
	}

}
