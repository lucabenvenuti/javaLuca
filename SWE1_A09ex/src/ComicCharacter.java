public class ComicCharacter {
private String name;
void print() {
System.out.println(name);
}
void dance() {
System.out.println(name + " dances.");
}
void sing() {
System.out.println(name + " sings.");
}
String getName() {
return name;
}
void setName(String name) {
this.name = name;
}
}