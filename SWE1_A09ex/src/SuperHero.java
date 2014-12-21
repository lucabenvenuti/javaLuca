public class SuperHero extends ComicCharacter {
// inherits characteristics from ComicCharacter ('print', 'dance', 'sing'),
// adds the functionality to 'fight'
private String superPower;
void fight() {
System.out.println (getName()+" fights.");
}
String getSuperPower() {
return superPower;
}
void setSuperPower(String superPower) {
this.superPower = superPower;
}
}
