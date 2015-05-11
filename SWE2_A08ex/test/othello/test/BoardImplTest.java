package othello.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import othello.BoardImpl;
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
	 * Check if the candidates are correctly flipped.
	 */
	@Test
	public void testFindCaptureCandidates() {
		assertAllFreeExcept(Pos.D_4, Pos.D_5, Pos.E_4, Pos.E_5);
		game.setStone(Pos.A_1, Stone.WHITE);
		game.setStone(Pos.A_2, Stone.BLACK);
		game.setStone(Pos.A_3, Stone.BLACK);
		game.setStone(Pos.A_4, Stone.BLACK);
		game.setStone(Pos.A_5, Stone.BLACK);
		game.setStone(Pos.A_6, Stone.WHITE);
		assertEquals(game.getStone(Pos.A_5), Stone.WHITE);
		assertEquals(game.getStone(Pos.A_4), Stone.WHITE);
		assertEquals(game.getStone(Pos.A_3), Stone.WHITE);
		assertEquals(game.getStone(Pos.A_2), Stone.WHITE);
	}

	/**
	 * Check if the Board has still free Pos.
	 */
	@Test
	public void testIsFreeAndNotFull() {
		assertAllFreeExcept(Pos.D_4, Pos.D_5, Pos.E_4, Pos.E_5);
		assertTrue(game.isFree(Pos.D_7));
		assertFalse(game.isFull());
		// fail();
	}

	/**
	 * Check if the Board is full.
	 */
	@Test
	public void testIsFull() {
		assertAllFreeExcept(Pos.D_4, Pos.D_5, Pos.E_4, Pos.E_5);
		for (Pos p : Pos.ALL) {
			game.setStone(p, Stone.BLACK);
		}
		assertTrue(game.isFull());

		// if (!condizione1) {
		// fail();
		// }
		// assertTrue(condizione1);
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

	/**
	 * After stone insertion, check if the given array of valid positions is
	 * correct.
	 */
	@Test
	public void testGetValidPositions() {
		assertAllFreeExcept(Pos.D_4, Pos.D_5, Pos.E_4, Pos.E_5);
		game.setStone(Pos.C_4, Stone.BLACK);
		assertArrayEquals(new Pos[] { Pos.C_3, Pos.E_3, Pos.C_5 },
				game.getValidPositions(Stone.WHITE));
		game.setStone(Pos.E_3, Stone.WHITE);
		game.setStone(Pos.F_2, Stone.BLACK);
		assertArrayEquals(new Pos[] { Pos.E_2, Pos.C_3, Pos.B_4, Pos.C_5,
				Pos.C_6 }, game.getValidPositions(Stone.WHITE));
		game.setStone(Pos.C_5, Stone.WHITE);
		game.setStone(Pos.E_6, Stone.BLACK);

		/*
		 * assertArrayEquals(new Pos[] { Pos.G_1, Pos.B_3, Pos.C_3, Pos.D_3,
		 * Pos.F_3, Pos.F_5 }, game.getValidPositions(Stone.WHITE));
		 */

		assertArrayEquals(new Pos[] { Pos.G_1, Pos.C_3, Pos.F_5 },
				game.getValidPositions(Stone.WHITE));

	}

	@Test
	public void testGetValidPositions2() {
		assertAllFreeExcept(Pos.D_4, Pos.D_5, Pos.E_4, Pos.E_5);
		game.setStone(Pos.C_4, Stone.BLACK);
		assertArrayEquals(new Pos[] { Pos.C_3, Pos.E_3, Pos.C_5 },
				game.getValidPositions(Stone.WHITE));
		game.setStone(Pos.C_3, Stone.WHITE);
		game.setStone(Pos.D_3, Stone.BLACK);
		assertArrayEquals(new Pos[] { Pos.E_3, Pos.C_5 },
				game.getValidPositions(Stone.WHITE));
		game.setStone(Pos.E_3, Stone.WHITE);
		game.setStone(Pos.C_2, Stone.BLACK); // 6th move
		assertArrayEquals(new Pos[] { Pos.B_1, Pos.B_2, Pos.B_3, Pos.B_4,
				Pos.B_5, // ??
				Pos.C_5, Pos.C_6, 
				Pos.D_6 // ??
				}, game.getValidPositions(Stone.WHITE));

		game.setStone(Pos.B_1, Stone.WHITE);
		game.setStone(Pos.F_5, Stone.BLACK);

		assertArrayEquals(new Pos[] { Pos.B_3, Pos.B_4, Pos.B_5, Pos.C_5,
				Pos.C_6, Pos.D_6, Pos.E_6, Pos.G_6 },
				game.getValidPositions(Stone.WHITE));

		game.setStone(Pos.B_3, Stone.WHITE);
		game.setStone(Pos.F_4, Stone.BLACK);

		assertArrayEquals(new Pos[] { Pos.B_5, Pos.C_5, Pos.G_5, Pos.D_6,
				Pos.E_6, Pos.F_6, Pos.G_6 },
				game.getValidPositions(Stone.WHITE));
	}

	// private section --------------------------------------------------------

	private void assertAllFreeExcept(Pos... occupied) {
		for (Pos pos : Pos.ALL) {
			if (!inOccupied(pos, occupied)) {
				assertEquals(Stone.FREE, game.getStone(pos));
			}
		}
	}

	private static boolean inOccupied(Pos pos, Pos[] occupied) {
		for (Pos p : occupied) {
			if (p == pos)
				return true;
		}
		return false;
	}

}
