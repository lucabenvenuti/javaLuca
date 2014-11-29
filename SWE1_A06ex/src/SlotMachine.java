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
		
		SlotMachine german = new SlotMachine();
		german.setNOfWheels(5);
		Reel germanic = new Reel();
		germanic.setReelIndex(german.getNOfWheels());
		//char[] test= germanic.createSymbolList(german.getNOfWheels());
		germanic.spinning(german.getNOfWheels());//,test);
		
		System.out.println(germanic.a1);
		
		
		SlotMachineCalc teutonic = new SlotMachineCalc();
		
		teutonic.setScore(germanic.a1);
	//	System.out.println(teutonic.getArray2(0));
	}

}
