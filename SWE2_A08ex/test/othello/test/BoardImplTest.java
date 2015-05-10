package othello.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import othello.BoardImpl;
import othello.Direction;
import othello.Pos;
import othello.Stone;

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
	public void testGetValidPositionsZero() {
		assertAllFreeExcept(Pos.D_4, Pos.D_5, Pos.E_4, Pos.E_5);
		assertEquals(game.getValidPositions(null).length, 0);
	}

	@Test
	public void testFindCaptureCandidates() {
		assertAllFreeExcept(Pos.D_4, Pos.D_5, Pos.E_4, Pos.E_5);
		game.findCaptureCandidates(new ArrayList<>(), Pos.A_1, Stone.BLACK,
				Direction.W);
	}

	@Test
	public void testIsFull() {
		assertAllFreeExcept(Pos.D_4, Pos.D_5, Pos.E_4, Pos.E_5);
		assertFalse(game.isFull());
		// fail();
	}

	@Test
	public void testGetStoneBlack() {
		assertAllFreeExcept(Pos.D_4, Pos.D_5, Pos.E_4, Pos.E_5);
		assertEquals(Stone.BLACK, game.getStone(Pos.D_5));

		Pos pos1 = game.getValidPositions(Stone.BLACK)[0];
		game.setStone(pos1, Stone.BLACK);
		assertEquals(Stone.BLACK, game.getStone(pos1));
		assertAllFreeExcept(Pos.A_2, Pos.D_4, Pos.D_5, Pos.E_4, Pos.E_5, pos1);

		Pos pos2 = game.getValidPositions(Stone.WHITE)[1];
		game.setStone(pos2, Stone.WHITE);
		assertEquals(Stone.WHITE, game.getStone(pos2));
		assertAllFreeExcept(Pos.A_2, Pos.D_4, Pos.D_5, Pos.E_4, Pos.E_5, pos1,
				pos2);
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

}
