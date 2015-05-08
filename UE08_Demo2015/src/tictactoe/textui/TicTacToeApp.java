package tictactoe.textui;

import inout.In;
import inout.Out;
import tictactoe.Pos;
import tictactoe.Stone;
import tictactoe.TTTGame;
import tictactoe.TTTGameImpl;

/**
 * Text-based user interface for TicTacToe.
 */
public class TicTacToeApp {

	public static void main(String[] args) {
		
		TTTGame game = new TTTGameImpl();

		while (game.getGameState() == tictactoe.GameState.RUNNING) {
			printBoard(game);
			Pos pos = readMovePos(game); 
			game.doMove(pos); 
		}
		
		assert(game.getGameState() != tictactoe.GameState.RUNNING);
		
		printBoard(game);

		Out.println();
		Out.println("Game over!");
		if (game.getGameState() == tictactoe.GameState.WINNER_PLAYER_O) {
			Out.println("Player O has won!");
		} else if (game.getGameState() == tictactoe.GameState.WINNER_PLAYER_X) {
			Out.println("Player X has won!");
		} else if (game.getGameState() == tictactoe.GameState.DRAW) {
			Out.println("It's a draw!");
		}
	}
	

	public static Pos readMovePos(TTTGame game) {
		Out.print("Enter move for player " + (game.getMoveNumber() % 2 == 0 ? "X" : "O") + " (col row): ");
		Pos pos = null;
		do {
			int col = In.readInt();
			char row = Character.toUpperCase(In.readChar());
			In.readLine(); // skip remaining line

			if (col < 0 || col > 3 || row < 'A' || row > 'C') {
				Out.println("Invalid position! New input: ");
			} else {
				try {pos = Pos.getPos(row, col); 
					if (game.getStone(pos) != Stone.FREE) {
						Out.print("Position occupied! New input: ");
						pos = null;
					}
				} catch (IllegalArgumentException e) {
					Out.println("Wrong input! Provide 1, 2, or 3 for colum and A, B, or C for row! New input: ");
				}
			}
		} while (pos == null);
		
		assert game.isFree(pos); 

		return pos;
	}


	private static String posOutputString(TTTGame board, int col, char row) {
		switch (board.getStone(Pos.getPos(row, col))) {
		case X:
			return "X";
		case O:
			return "O";
		case FREE:
			return " ";
		default:
			throw new AssertionError("illegal state");
		}
	}

	private static void printBoard(TTTGame board) {
		Out.println("  |  1 | 2 | 3 |"); 
		for (char row = 'A'; row <= 'C'; row = (char)(row+1)) {
			Out.println("  --------------"); 
			Out.print(row + " | "); 
			for (int col = 1; col <= 3; col++) {
				Out.print(" " + posOutputString(board, col, row) + " |");
			}
			Out.println(); 
		}
		Out.println("  --------------"); 
	}

}
