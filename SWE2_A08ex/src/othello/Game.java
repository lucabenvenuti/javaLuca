package othello;

import static othello.GameState.BLACK_NEXT;
import static othello.GameState.BLACK_WINS;
import static othello.GameState.DRAW;
import static othello.GameState.WHITE_NEXT;
import static othello.GameState.WHITE_WINS;
import static othello.Stone.BLACK;
import static othello.Stone.WHITE;

/**
 * Class representing an Othello game. Serves as the central component 
 * for executing a game. Uses a user interface component for interaction, two 
 * players white and black, and a board representing the state of the board. 
 * In addition maintains the game state. 
 */
public class Game {
	
	/** user interface component */
	private UserInterface userInterface;
	/** the board */
	private Board board;
	/** two players */
	private Player white, black;
	/** the overall state of the game */
	private GameState state;
	/** number of rounds with no move possible */
	private int unableToMove = 0; 
	
	/**
	 * Constructor setting user interface and the two players.
	 * @param ui the user interface component
	 * @param white the white player 
	 * @param black the black player 
	 */
	public Game(UserInterface ui, Player white, Player black) {
		userInterface = ui;
		board = new BoardImpl();
		this.white = white; 
		this.black = black; 
		
	}
	
	/** 
	 * Method to perform and control a game.
	 */
	public void play() {
			
		this.white.setStone(WHITE); 
		this.black.setStone(BLACK);
		
		state = BLACK_NEXT;
		userInterface.boardChanged(board);
		do {
			Pos pos = getCurrentPlayer().nextMove(board);
			if (pos == null) {
				unableToMove++; 
			} else {
				unableToMove = 0; 
				board.setStone(pos, getCurrentPlayer().getStone());
				userInterface.stoneSet(pos, getCurrentPlayer().getStone());
				userInterface.boardChanged(board);
			}

			computeGameState();
		} while (state == WHITE_NEXT || state == BLACK_NEXT);
		
		userInterface.gameOver(this);
	}

	/** 
	 * Gets the current state of the game. 
	 * @return the current game state
	 */
	public GameState getState() {
		return state;
	}

	/**
	 * Computes the game state on the board and the number of rounds where no move was possible. 
	 */
	private void computeGameState() {
		if (unableToMove == 2) {
			state = DRAW;
		} else if (board.isFull()) {
			int nWhite = 0; 
			int nBlack = 0; 
			for (Pos pos : board) {
				Stone stone = board.getStone(pos);
				if (stone == WHITE) {
					nWhite++;
				} else {
					nBlack++;
				}
			}
			if (nWhite == nBlack) {
				state = DRAW;
			} else if (nWhite > nBlack) {
				state = WHITE_WINS;
			} else {
				state = BLACK_WINS;
			}
		} else {
			if (state == WHITE_NEXT) {
				state = BLACK_NEXT;
			} else {
				state = WHITE_NEXT;
			}
		}
	}

	/**
	 * Gets the player in turn. 
	 * @return  the player in turn next
	 */
	private Player getCurrentPlayer() {
		if (state == WHITE_NEXT) {
			return white; 
		} else if (state == BLACK_NEXT) {
			return black; 
		} else {
			return null; 
		}
	}

}
