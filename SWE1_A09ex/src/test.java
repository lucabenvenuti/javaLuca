
public class test {

	public static void main(String[] args) {
	/*	ComicCharacter cc = new ComicCharacter();
		cc.setName("Gonzo");
		cc.dance();
		SuperHero sh = new SuperHero();
		sh.setName("Arnie");
		sh.dance();
		sh.fight();
		Wizard wd = new Wizard();
		wd.setName("John");
		wd.sing();
		wd.fly(); */
		ComicCharacter cc = new ComicCharacter();
		cc.setName("Papasmurf");
		cc.sing(); // sing() method of class ComicCharacter
		ComicCharacter sm = new Smurf();
		sm.sing(); // sing() method of class Smurf; different
		// behavior (method replaced in class Smurf)
		cc = sm;
		cc.sing(); // cc is of (static) type ComicCharacter;
		// sing() method of class Smurf!!
		cc = new SuperHero();
		cc.sing();
		
		}
	
	

}
