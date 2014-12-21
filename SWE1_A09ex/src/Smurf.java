class Smurf extends ComicCharacter {
private String color;
Smurf() {
color = "Blue";
}
void sing() {
System.out.println(color + " Smurfs don't sing!");
}

void dance() {
super.dance();
System.out.println("The other Smurfs applaud");
}

}