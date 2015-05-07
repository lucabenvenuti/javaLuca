package tictactoe;

/**
 * Implementation of the TicTacToe play field.<br>
 * 
 * The position of the players is encoded as a bit-field in one integer value
 * per player. This allows a simple and efficient test if the game is over by
 * using bitwise logical functions with predefined masks of winning situations.
 */
public class TTTGameImpl implements TTTGame {
	
	/** The number of the current move. */
	private int moveNumber;

	/** The board with stones. */
	private final Stone[] board; 
	
	/** Constructor initializing the game */
	public TTTGameImpl() {
		board = new Stone[Pos.ALL.length];
		for (int i = 0; i < board.length; i++) {
			board[i] = Stone.FREE; 
		}
		moveNumber = 0;
	}

	/**
	 * Gets the state of the game, i.e. checks if the game is still
	 * running, if one of the player has won, or if the game is draw. 
	 * 
	 * @return The state of the game.
	 */
	public GameState getGameState() {
		if (isWinner(Stone.X, board)) {
			return GameState.WINNER_PLAYER_X;
		} else if (isWinner(Stone.O, board)) {
			return GameState.WINNER_PLAYER_O;
		} else if (moveNumber > 8) {
			return GameState.DRAW;
		} else {
			return GameState.RUNNING;
		}
	}

	/**
	 * Returns the stone at the specified position.
	 * 
	 * @param pos
	 *            The position.
	 * @return The stone at the board.
	 */
	@Override
	public Stone getStone(Pos pos) {
		return board[pos.ordinal()]; 
	}

	/** Tests if this position is free.
	 * @param pos the position to test
	 * @return true if free
	 */
	@Override
	public boolean isFree(Pos pos) {
		return getStone(pos) == Stone.FREE;
	}

	/**
	 * Returns the number of the current move.
	 * 
	 * @return The move number, starting with 0.
	 */
	@Override
	public int getMoveNumber() {
		return moveNumber;
	}

	/**
	 * Performs a move at the specified position for the current player.
	 * 
	 * @param pos
	 *            The position for the move.
	 */
	@Override
	public void doMove(Pos pos) {
		assert getGameState() == GameState.RUNNING;
		assert getStone(pos) == Stone.FREE;

		board[pos.ordinal()] = getNextStone(); 
		moveNumber++;
	}

	
	// private section 
	
	/**
	 * Gets the next stone to set based on move number.
	 * @return the next stone to set
	 */
	private Stone getNextStone() {
		return Stone.values()[moveNumber & 1];
	}

	/**
	 * Checks if the player with stone has won at the given board (maybe simulated). 
	 * @param stone the stone to test
	 * @param board the board to test
	 * @return true if player with stone has won with given board 
	 */
	private boolean isWinner(Stone stone, Stone[] board) {
		return existsSameThree(stone, board); 
	}
	
	/**
	 * Checks if there are three in a row of same stone 
	 * @param stone the stone to check 
	 * @param board the board 
	 * @return true if three in a row exist for stone on board 
	 */
	private boolean existsSameThree(Stone stone, Stone[] board) {
		for (Pos[] threePos: winnerCodings) {
			if (allSameStones(threePos, stone, board)) {
				return true; 
			}
		}
		return false; 
	}

	/**
	 * Checks if are of same stone <code>stone</code> 
	 * on the three given positions on the given board. 
	 * @param positions three positions
	 * @param stone the stone to test
	 * @param board the board
	 * @return true if stone <code>stone</code> is on all three positions
	 */
	private boolean allSameStones(Pos[] positions, Stone stone, Stone[] board) {
		for (Pos pos:  positions) {
			if (board[pos.ordinal()] != stone) {
				return false; 
			}
		}
		return true; 
	}

	/**
	 * Pre-computed positions of winning situations: 3 rows, 3 columns, and 2
	 * diagonals.
	 */
	private static final Pos[][] winnerCodings = 
			new Pos[][] {
				new Pos[] { Pos.A_1, Pos.A_2, Pos.A_3 }, 
				new Pos[] { Pos.B_1, Pos.B_2, Pos.B_3 }, 
				new Pos[] { Pos.C_1, Pos.C_2, Pos.C_3 }, 
				new Pos[] { Pos.A_1, Pos.B_1, Pos.C_1 }, 
				new Pos[] { Pos.A_2, Pos.B_2, Pos.C_2 }, 
				new Pos[] { Pos.A_3, Pos.B_3, Pos.C_3 }, 
				new Pos[] { Pos.A_1, Pos.B_2, Pos.C_3 }, 
				new Pos[] { Pos.A_3, Pos.B_2, Pos.C_1 }
			};

}
