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

/**
 * BoardImplTest.java
 *
 * A {@link BoardImplTest} is a test public class. Its state consists in an
 * object of {@link BoardImpl}, that is instantiated before and thrown after.
 * Its methods check if {@link BoardImpl} has been implemented correctly.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class BoardImplTest {

	BoardImpl game;

	/**
	 * 
	 * Initialize BoardImpl.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		game = new BoardImpl();
	}

	/**
	 * 
	 * Close BoardImpl.
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		game = null;
	}

	/**
	 * Test if the Constructor has been implemented as required, all Pos free
	 * but the 4 in the center.
	 */
	@Test
	public void testBoardImpl() {
		assertAllFreeExcept(Pos.D_4, Pos.D_5, Pos.E_4, Pos.E_5);
	}

	/**
	 * Obtain none valid Pos when given a null Stone.
	 */
	@Test
	public void testGetValidPositionsZero() {
		assertAllFreeExcept(Pos.D_4, Pos.D_5, Pos.E_4, Pos.E_5);
		assertEquals(game.getValidPositions(null).length, 0);
	}

	/**
	 * Check null branch of findCaptureCandidates() when it goes out of the
	 * Board.
	 */
	@Test
	public void testFindCaptureCandidates() {
		assertAllFreeExcept(Pos.D_4, Pos.D_5, Pos.E_4, Pos.E_5);
		game.findCaptureCandidates(new ArrayList<>(), Pos.A_1, Stone.BLACK,
				Direction.W);
	}

	/**
	 * Check if the Board has still free Pos.
	 */
	@Test
	public void testIsNotFull() {
		assertAllFreeExcept(Pos.D_4, Pos.D_5, Pos.E_4, Pos.E_5);
		assertFalse(game.isFull());
		// fail();
	}

	/**
	 * Check if a black stone and a white stone have been set correctly by
	 * getting them.
	 */
	@Test
	public void testGetStoneSetStone() {
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
