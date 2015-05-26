package othello.view;

import othello.Board;
import othello.Player;
import othello.Pos;
import othello.Stone;

/**
 * GuiPlayer.java
 *
 * A {@link GuiPlayer} is a public class representing the human player. It
 * implements the methods given in {@link Player}.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 * 
 */
public class GuiPlayer implements Player {
	public static final String PLAYER_NAME = "Player";
	private Stone stone;
	private Pos[] validMoves;
	private Pos nextMove; // buffer of size 1

	@Override
	public String getName() {
		return PLAYER_NAME;
	}

	// consumer
	@Override
	public synchronized Pos nextMove(Board board) {
		validMoves = board.getValidPositions(this.getStone());
		if (validMoves.length == 0) {
			return null;
		} else {
			nextMove = null;
			while (nextMove == null) {
				try {
					wait();
				} catch (InterruptedException e) {
				}
			}
			return nextMove;
		}
	}

	/**
	 * Producer of nextMove.
	 * 
	 * @param move
	 * @return true if the Pos has been produced.
	 */
	public synchronized boolean setNextMove(Pos move) {
		if (nextMove == null) {
			for (Pos p : validMoves) {
				if (p == move) {
					nextMove = move;
					this.notify();
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void setStone(Stone stone) {
		this.stone = stone;
	}

	@Override
	public Stone getStone() {
		return stone;
	}
}
