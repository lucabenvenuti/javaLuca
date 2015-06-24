package persons5;

public class PersonApp {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Student stdt = new Student("Hans", Study.CS);
		Professor prof = new Professor("Wirth", "Software"); 
		
		Person p1 = stdt; 
		Person p2 = prof; 
	
		// 1. Test
//		p1.meetsWith(p2); 
//		stdt.meetsWith(p2); 
//		stdt.meetsWith(prof);
//		p2.meetsWith(p1); 
//		prof.meetsWith(p1); 
		
		p1.meetsWith(stdt); 
		p1.meetsWith(p1); 
		p1.meetsWith(prof); 
		
		// 2. Test
		p1.meetsWith(p2); 
		p1.meetsWith(prof); 
		stdt.meetsWith(p2); 
		stdt.meetsWith(prof); 
		
		
	}

}
