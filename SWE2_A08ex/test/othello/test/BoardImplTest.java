package othello.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static othello.Pos.A_1;
import static othello.Pos.A_3;
import static othello.Pos.B_1;
import static othello.Pos.B_2;
import static othello.Pos.C_1;

import java.util.Iterator;

import inout.Out;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import othello.GameState;
import othello.Pos;
import othello.Stone;
import othello.BoardImpl;
import othello.Board;

public class BoardImplTest {
	
	BoardImpl game; 

	@Before
	public void setUp() throws Exception {
		
		game = new BoardImpl(); 
	}

	@After
	public void tearDown() throws Exception {
		game = null; 
	}

	@Test
	public void testBoardImpl() {
		assertAllFreeExcept(Pos.D_4, Pos.D_5, Pos.E_4, Pos.E_5);
	}
	
	@Test
	public void testIsFull() {
		assertAllFreeExcept(Pos.D_4, Pos.D_5, Pos.E_4, Pos.E_5);
		assertFalse(game.isFull());
//		fail();
//		//Iterator<Pos> iterator1 = game.iterator();
//		for (int i = 0; i<50; i++) {
//			Pos pos1 = game.getValidPositions(Stone.BLACK)[0];
//			game.setStone(pos1, Stone.BLACK); 
//				assertEquals(Stone.BLACK, game.getStone(pos1)); 
//		}
//		assertFalse(game.isFull());
	
	}

	@Test
	public void testGetStoneBlack() {
		assertAllFreeExcept(Pos.D_4, Pos.D_5, Pos.E_4, Pos.E_5);
		assertEquals(Stone.BLACK, game.getStone(Pos.D_5)); 
		
		Pos pos1 = game.getValidPositions(Stone.BLACK)[0];
		game.setStone(pos1, Stone.BLACK); 
			assertEquals(Stone.BLACK, game.getStone(pos1)); 
		assertAllFreeExcept(Pos.A_2, Pos.D_4, Pos.D_5, Pos.E_4, Pos.E_5, pos1);
		
		/*game.setStone(Pos.B_2, Stone.BLACK); 
		assertEquals(Stone.BLACK, game.getStone(Pos.B_2)); 
		assertAllFreeExcept(Pos.B_2);
		
		game.setStone(Pos.C_1, Stone.BLACK); 
		assertEquals(Stone.BLACK, game.getStone(Pos.C_1)); 
		assertAllFreeExcept(Pos.C_1);*/
		

		
		/*game.doMove(Pos.C_3); 
		assertEquals(Stone.X, game.getStone(Pos.C_1)); 
		assertEquals(Stone.O, game.getStone(Pos.B_2)); 
		assertEquals(Stone.X, game.getStone(Pos.A_2)); 
		assertEquals(Stone.O, game.getStone(Pos.C_3)); 
		assertAllFreeExcept(Pos.A_2, Pos.B_2, Pos.C_1, Pos.C_3); */
		
	}

	/*@Test
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
		game.doMove(A_1); // X . .  . . .  . . .
		printBoard(game); 
		assertEquals(GameState.RUNNING, game.getGameState()); 
		game.doMove(B_2); // X . .   . 0 .   . . .
		printBoard(game); 
		assertEquals(GameState.RUNNING, game.getGameState()); 
		game.doMove(B_1); // X . .   X 0 .   . . .
		printBoard(game); 
		assertEquals(GameState.RUNNING, game.getGameState()); 
		game.doMove(A_3); // X . 0   X 0 .   . . .
		printBoard(game); 
		assertEquals(GameState.RUNNING, game.getGameState()); 
		game.doMove(C_1); // X . 0   X 0 .   X . .
		printBoard(game); 
		assertEquals(GameState.WINNER_PLAYER_X, game.getGameState()); 		
	}

	@Test
	public void testGetGameState2() {
		game.doMove(Pos.A_1); // X . .   . . .   . . .
		printBoard(game); 
		assertEquals(GameState.RUNNING, game.getGameState()); 
		game.doMove(Pos.B_2); // X . .   . 0 .   . . .
		printBoard(game); 
		assertEquals(GameState.RUNNING, game.getGameState()); 
		game.doMove(Pos.A_2); // X X .   . 0 .   . . .
		printBoard(game); 
		assertEquals(GameState.RUNNING, game.getGameState()); 
		game.doMove(Pos.A_3); // X X 0   . 0 .   . . .
		printBoard(game); 
		assertEquals(GameState.RUNNING, game.getGameState()); 
		game.doMove(Pos.C_1); // X X 0   . 0 .   0 . .
		printBoard(game); 
		assertEquals(GameState.RUNNING, game.getGameState()); 
		game.doMove(Pos.B_1); // X X 0   X 0 .   0 . .
		printBoard(game); 
		assertEquals(GameState.RUNNING, game.getGameState()); 
		game.doMove(Pos.B_3); // X X 0   X 0 X   0 . .
		printBoard(game); 
		assertEquals(GameState.RUNNING, game.getGameState()); 
		game.doMove(Pos.C_2); // X X 0   X 0 X   0 0 .
		printBoard(game); 
		assertEquals(GameState.RUNNING, game.getGameState()); 
		game.doMove(Pos.C_3); // X X 0   X 0 X   0 0 X
		printBoard(game); 
		assertEquals(GameState.DRAW, game.getGameState()); 
	}*/
	
	// private section --------------------------------------------------------
	
	private void assertAllFreeExcept(Pos...occupied) {
		for (Pos pos: Pos.ALL) {
			if (! inOccupied(pos, occupied)) {
				assertEquals(Stone.FREE, game.getStone(pos)); 
			}
		}
	}

	private boolean inOccupied(Pos pos, Pos[] occupied) {
		for (Pos p: occupied) {
			if (p == pos) 
				return true;
		}
		return false; 
	}

	/*private String posOutputString(TTTGame board, int col, char row) {
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
		for (char row = 'A'; row <= 'C'; row = (char)(row+1)) {
			Out.println("  --------------"); 
			Out.print(row + " | "); 
			for (int col = 1; col <= 3; col++) {
				Out.print(" " + posOutputString(board, col, row) + " |");
			}
			Out.println(); 
		}
		Out.println("  --------------"); 
	}*/

}
