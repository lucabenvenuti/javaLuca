package othello.ui;

import inout.Out;

import java.io.PrintStream;

import othello.Board;
import othello.Game;
import othello.GameState;
import othello.Pos;
import othello.Stone;
import othello.UserInterface;

/**
 * UI component used by a the game. 
 */
public class ConsoleUI implements UserInterface {

	/* (non-Javadoc)
	 * @see othello.UserInterface#boardChanged(othello.Board)
	 */
	@Override
	public void boardChanged(Board board) {
		print(board, System.out); 
	}

	/* (non-Javadoc)
	 * @see othello.UserInterface#gameOver(othello.Game)
	 */
	@Override
	public void gameOver(Game game) {
		Out.println(); 
		Out.println("!!!!!!!!!!!!! Game over !!!!!!!!!!!!!!!!!!!!"); 
		if (game.getState() == GameState.BLACK_WINS) {
			Out.println("Black has won!"); 
		} else if (game.getState() == GameState.WHITE_WINS) {
			Out.println("White has won!"); 
		} else if (game.getState() == GameState.DRAW) {
			Out.println("It's a draw!"); 
		} 
	}

	/* (non-Javadoc)
	 * @see othello.UserInterface#stoneSet(othello.Pos, othello.Stone)
	 */
	@Override
	public void stoneSet(Pos pos, Stone stone) {
		Out.println("Stone " + stone + " set on " + pos);
	}

	private void print(Board b, PrintStream out) {
		out.println(" ----------------------------");
		out.print("|   |");
		for (char col : Pos.COLS) {
			out.print(String.format(" %c ", col));
		}
		out.println("|"); 
		out.println(" ----------------------------");
		for (int row : Pos.ROWS) {
			out.print(String.format("| %d |", row));
			for (char col : Pos.COLS) {
				out.print(String.format(" %s ", b.getStone(Pos.getPos(row, col))));
			}
			out.println("|"); 
		}
		out.println(" ----------------------------");
	}


}
