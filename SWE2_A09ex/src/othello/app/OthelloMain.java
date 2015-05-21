package othello.app;

import othello.Game;
import othello.ai.ArtificialPlayer;
import othello.ui.ConsolePlayer;
import othello.ui.ConsoleUI;

/**
 * Application class with main method for starting the Othello game. 
 */
public class OthelloMain {

	/** 
	 * Main method creating a game with player interacting with the console and an intelligent computer player.  
	 * Starts the game. 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Game game = new Game(new ConsoleUI(), new ConsolePlayer("Me"), new ArtificialPlayer()); 
		game.play();
	}

}
