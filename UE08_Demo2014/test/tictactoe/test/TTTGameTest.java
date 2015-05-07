package tictactoe.test;

import static org.junit.Assert.assertEquals;
import static tictactoe.Pos.A_1;
import static tictactoe.Pos.A_3;
import static tictactoe.Pos.B_1;
import static tictactoe.Pos.B_2;
import static tictactoe.Pos.C_1;
import inout.Out;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tictactoe.GameState;
import tictactoe.Pos;
import tictactoe.Stone;
import tictactoe.TTTGame;
import tictactoe.TTTGameImpl;

public class TTTGameTest {

	private TTTGame game;

	@Before
	public void setUp() throws Exception {
		game = new TTTGameImpl();
	}

	@After
	public void tearDown() throws Exception {
		game = null;
	}

	@Test
	public void testBoardImpl() {
		assertAllFreeExcept();
	}

	@Test
	public void testGetStone() {
		assertAllFreeExcept();

		game.doMove(Pos.A_2);
		assertEquals(Stone.X, game.getStone(Pos.A_2));
		assertAllFreeExcept(Pos.A_2);

		game.doMove(Pos.B_2);
		assertEquals(Stone.O, game.getStone(Pos.B_2));
		assertEquals(Stone.X, game.getStone(Pos.A_2));
		assertAllFreeExcept(Pos.A_2, Pos.B_2);

		game.doMove(Pos.C_1);
		assertEquals(Stone.X, game.getStone(Pos.C_1));
		assertEquals(Stone.O, game.getStone(Pos.B_2));
		assertEquals(Stone.X, game.getStone(Pos.A_2));
		assertAllFreeExcept(Pos.A_2, Pos.B_2, Pos.C_1);

		game.doMove(Pos.C_3);
		assertEquals(Stone.X, game.getStone(Pos.C_1));
		assertEquals(Stone.O, game.getStone(Pos.B_2));
		assertEquals(Stone.X, game.getStone(Pos.A_2));
		assertEquals(Stone.O, game.getStone(Pos.C_3));
		assertAllFreeExcept(Pos.A_2, Pos.B_2, Pos.C_1, Pos.C_3);

	}

	@Test
	public void testGetMoveNumber() {
		assertEquals(0, game.getMoveNumber());

		game.doMove(Pos.A_2);
		assertEquals(1, game.getMoveNumber());

		game.doMove(Pos.B_2);
		assertEquals(2, game.getMoveNumber());

		game.doMove(Pos.C_1);
		assertEquals(3, game.getMoveNumber());

		game.doMove(Pos.C_3);
		assertEquals(4, game.getMoveNumber());
	}

	@Test
	public void testDoMove() {
		game.doMove(Pos.A_2);
		assertEquals(Stone.X, game.getStone(Pos.A_2));
		assertAllFreeExcept(Pos.A_2);

		game.doMove(Pos.B_2);
		assertEquals(Stone.O, game.getStone(Pos.B_2));
		assertEquals(Stone.X, game.getStone(Pos.A_2));
		assertAllFreeExcept(Pos.A_2, Pos.B_2);

		game.doMove(Pos.C_1);
		assertEquals(Stone.X, game.getStone(Pos.C_1));
		assertEquals(Stone.O, game.getStone(Pos.B_2));
		assertEquals(Stone.X, game.getStone(Pos.A_2));
		assertAllFreeExcept(Pos.A_2, Pos.B_2, Pos.C_1);

		game.doMove(Pos.C_3);
		assertEquals(Stone.X, game.getStone(Pos.C_1));
		assertEquals(Stone.O, game.getStone(Pos.B_2));
		assertEquals(Stone.X, game.getStone(Pos.A_2));
		assertEquals(Stone.O, game.getStone(Pos.C_3));
		assertAllFreeExcept(Pos.A_2, Pos.B_2, Pos.C_1, Pos.C_3);
	}

	@Test
	public void testGetGameState1() {
		game.doMove(A_1); // X . . . . . . . .
		printBoard(game);
		assertEquals(GameState.RUNNING, game.getGameState());
		game.doMove(B_2); // X . . . 0 . . . .
		printBoard(game);
		assertEquals(GameState.RUNNING, game.getGameState());
		game.doMove(B_1); // X . . X 0 . . . .
		printBoard(game);
		assertEquals(GameState.RUNNING, game.getGameState());
		game.doMove(A_3); // X . 0 X 0 . . . .
		printBoard(game);
		assertEquals(GameState.RUNNING, game.getGameState());
		game.doMove(C_1); // X . 0 X 0 . X . .
		printBoard(game);
		assertEquals(GameState.WINNER_PLAYER_X, game.getGameState());
	}

	@Test
	public void testGetGameState1a() {
		game.doMove(A_1); // X . . . . . . . .
		printBoard(game);
		assertEquals(GameState.RUNNING, game.getGameState());
		game.doMove(B_2); // X . . . 0 . . . .
		printBoard(game);
		assertEquals(GameState.RUNNING, game.getGameState());
		game.doMove(B_1); // X . . X 0 . . . .
		printBoard(game);
		assertEquals(GameState.RUNNING, game.getGameState());
		game.doMove(Pos.A_2); // X . 0 X 0 . . . .
		printBoard(game);
		assertEquals(GameState.RUNNING, game.getGameState());
		game.doMove(Pos.C_3); // X . 0 X 0 . X . .
		printBoard(game);
		game.doMove(Pos.C_2);
		printBoard(game);
		assertEquals(GameState.WINNER_PLAYER_O, game.getGameState());
	}

	@Test
	public void testGetGameState1c() {
		game.doMove(A_1); // X . . . . . . . .
		assertEquals(GameState.RUNNING, game.getGameState());
		game.doMove(B_2); // X . . . 0 . . . .
		assertEquals(GameState.RUNNING, game.getGameState());
		game.doMove(B_1); // X . . X 0 . . . .
		assertEquals(GameState.RUNNING, game.getGameState());
		game.doMove(Pos.A_2); // X . 0 X 0 . . . .
		assertEquals(GameState.RUNNING, game.getGameState());
		game.doMove(Pos.C_3); // X . 0 X 0 . X . .
		game.doMove(Pos.C_2);
		assertEquals(GameState.WINNER_PLAYER_O, game.getGameState());
		Assert.assertTrue(game.isFree(Pos.C_1));
		Assert.assertTrue(game.isFree(Pos.A_3));
		Assert.assertFalse(game.isFree(Pos.B_2));
	}

	@Test
	public void testGetGameState2() {
		game.doMove(Pos.A_1); // X . . . . . . . .
		printBoard(game);
		assertEquals(GameState.RUNNING, game.getGameState());
		game.doMove(Pos.B_2); // X . . . 0 . . . .
		printBoard(game);
		assertEquals(GameState.RUNNING, game.getGameState());
		game.doMove(Pos.A_2); // X X . . 0 . . . .
		printBoard(game);
		assertEquals(GameState.RUNNING, game.getGameState());
		game.doMove(Pos.A_3); // X X 0 . 0 . . . .
		printBoard(game);
		assertEquals(GameState.RUNNING, game.getGameState());
		game.doMove(Pos.C_1); // X X 0 . 0 . 0 . .
		printBoard(game);
		assertEquals(GameState.RUNNING, game.getGameState());
		game.doMove(Pos.B_1); // X X 0 X 0 . 0 . .
		printBoard(game);
		assertEquals(GameState.RUNNING, game.getGameState());
		game.doMove(Pos.B_3); // X X 0 X 0 X 0 . .
		printBoard(game);
		assertEquals(GameState.RUNNING, game.getGameState());
		game.doMove(Pos.C_2); // X X 0 X 0 X 0 0 .
		printBoard(game);
		assertEquals(GameState.RUNNING, game.getGameState());
		game.doMove(Pos.C_3); // X X 0 X 0 X 0 0 X
		printBoard(game);
		assertEquals(GameState.DRAW, game.getGameState());
	}

	// private section --------------------------------------------------------
	private void assertAllFreeExcept(Pos... occupied) {
		for (Pos pos : Pos.ALL) {
			if (!inOccupied(pos, occupied)) {
				assertEquals(Stone.FREE, game.getStone(pos));
			}
		}
	}

	private boolean inOccupied(Pos pos, Pos[] occupied) {
		for (Pos p : occupied) {
			if (p == pos)
				return true;
		}
		return false;
	}

	private String posOutputString(TTTGame board, int col, char row) {
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

	private void printBoard(TTTGame board) {
		Out.println("Board at move " + board.getMoveNumber());
		Out.println("with state " + board.getGameState());
		Out.println("  --------------");
		Out.println("  |  1 | 2 | 3 |");
		for (char row = 'A'; row <= 'C'; row = (char) (row + 1)) {
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
