package tictactoe;

public class Auguri extends Thread {
	  private final String name;
	  private final int age;

	  public Auguri(String name, int age) {
	    this.name = name.toUpperCase();
	    this.age = age;
	  }

	  @Override
	  public void run() {
	    for (int i = 0; i < age; i++) {
	      System.out.println("AUGURI " + name + "!!!!!!");
	    }
	  }

	  public static void main(String[] args) {
	    new Auguri("Luca", 27).start();
	  }
	}