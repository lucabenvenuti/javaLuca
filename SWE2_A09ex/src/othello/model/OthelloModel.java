package othello.model;

import static othello.GameState.BLACK_NEXT;
import static othello.GameState.BLACK_WINS;
import static othello.GameState.DRAW;
import static othello.GameState.WHITE_NEXT;
import static othello.GameState.WHITE_WINS;
import static othello.Stone.BLACK;
import static othello.Stone.WHITE;

import java.util.ArrayList;
import java.util.List;

import othello.Board;
import othello.BoardImpl;
import othello.GameState;
import othello.Player;
import othello.Pos;
import othello.Stone;
import othello.UserInterface;
import othello.ai.ArtificialPlayer;
import othello.view.GuiPlayer;

/**
 * OthelloModel.java
 *
 * A {@link OthelloModel} is a public class. It performs as Model in an MVC
 * architecture. Serves as the central component for executing a game. Uses a
 * user interface component for interaction, two players white and black, and a
 * board representing the state of the board. In addition maintains the game
 * state.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author TAs & Luca Benvenuti
 */
public class OthelloModel {
	private final List<PosChangeListener> posListeners = new ArrayList<>();
	private final List<StateChangeListener> stateListeners = new ArrayList<>();

	/** user interface component */
	private final UserInterface userInterface;
	/** the board */
	private Board board;
	/** two players */
	private GuiPlayer guiPlayer;
	private ArtificialPlayer artificialPlayer;
	/** the overall state of the game */
	private GameState state;
	/** number of rounds with no move possible */
	private int unableToMove = 0;

	public OthelloModel(UserInterface ui) {
		userInterface = ui;
		board = new BoardImpl();
		guiPlayer = new GuiPlayer();
		artificialPlayer = new ArtificialPlayer();
	}

	/**
	 * Method to perform and control a game.
	 */
	public void play() {

		guiPlayer.setStone(WHITE);
		artificialPlayer.setStone(BLACK);

		state = BLACK_NEXT;
		userInterface.boardChanged(board);
		do {
			Pos pos = getCurrentPlayer().nextMove(board);
			firePosChangeEvent(getCurrentPlayer(), pos);
			if (pos == null) {
				unableToMove++;
			} else {
				unableToMove = 0;
				board.setStone(pos, getCurrentPlayer().getStone());
				userInterface.stoneSet(pos, getCurrentPlayer().getStone());
				userInterface.boardChanged(board);
			}

			computeGameState();
			fireStateChangeEvent(getState());
		} while (state == WHITE_NEXT || state == BLACK_NEXT);

		userInterface.gameOver(getState());
	}

	/**
	 * Gets the current state of the game.
	 * 
	 * @return the current game state
	 */
	public GameState getState() {
		return state;
	}

	/**
	 * Computes the game state on the board and the number of rounds where no
	 * move was possible.
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
	 * 
	 * @return the player in turn next
	 */
	private Player getCurrentPlayer() {
		if (state == WHITE_NEXT) {
			return guiPlayer;
		} else if (state == BLACK_NEXT) {
			return artificialPlayer;
		} else {
			return null;
		}
	}

	/**
	 * 
	 * The user attempts to move
	 * 
	 * @param pos
	 * @return true if the move is done.
	 */
	public boolean attemptMove(Pos pos) {
		if (getCurrentPlayer() == guiPlayer) {
			return guiPlayer.setNextMove(pos);
		}
		return false;
	}

	/**
	 * @return the initial game state.
	 */
	public GameState getInitalGameState() {
		return GameState.WHITE_NEXT;
	}

	/**
	 * Reset the board and restart the game.
	 */
	public void reset() {
		userInterface.reset(board);
		state = BLACK_NEXT;
		Pos pos = getCurrentPlayer().nextMove(board);
		firePosChangeEvent(getCurrentPlayer(), pos);
		computeGameState();
		fireStateChangeEvent(getState());
	}

	/**
	 * Add a PosChangeListener to the list.
	 * 
	 * @param listener
	 */
	public void addListener(PosChangeListener listener) {
		posListeners.add(listener);
	}

	/**
	 * Remove a PosChangeListener to the list.
	 * 
	 * @param listener
	 */
	public void removeListener(PosChangeListener listener) {
		posListeners.remove(listener);
	}

	/**
	 * Add a StateChangeListener to the list.
	 * 
	 * @param listener
	 */
	public void addListener(StateChangeListener listener) {
		stateListeners.add(listener);
	}

	/**
	 * Remove a StateChangeListener to the list.
	 * 
	 * @param listener
	 */
	public void removeListener(StateChangeListener listener) {
		stateListeners.remove(listener);
	}

	private void firePosChangeEvent(Player player, Pos pos) {
		PosChangeEvent evt = new PosChangeEvent(this, player, pos);
		for (PosChangeListener l : posListeners) {
			l.posChanged(evt);
		}
	}

	private void fireStateChangeEvent(GameState state) {
		StateChangeEvent evt = new StateChangeEvent(this, state);
		for (StateChangeListener l : stateListeners) {
			l.stateChanged(evt);
		}
	}
}
