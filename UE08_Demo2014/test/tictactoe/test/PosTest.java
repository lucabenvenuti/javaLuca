package tictactoe.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tictactoe.Pos;

public class PosTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPos() {
		assertEquals(Pos.A_1, Pos.getPos('A', 1));
		assertEquals(Pos.A_2, Pos.getPos('A', 2));
		assertEquals(Pos.A_3, Pos.getPos('A', 3));
		assertEquals(Pos.B_1, Pos.getPos('B', 1));
		assertEquals(Pos.B_2, Pos.getPos('B', 2));
		assertEquals(Pos.B_3, Pos.getPos('B', 3));
		assertEquals(Pos.C_1, Pos.getPos('C', 1));
		assertEquals(Pos.C_2, Pos.getPos('C', 2));
		assertEquals(Pos.C_3, Pos.getPos('C', 3));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetPosA() {
		Pos.getPos('Z', 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetPosB() {
		Pos.getPos('0', 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetPosC() {
		Pos.getPos('A', 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetPosD() {
		Pos.getPos('A', 6);
	}

	@Test
	public void testGetPosE() {
		Assert.assertEquals('A', Pos.A_1.getRow());
	}

	@Test
	public void testGetPosF() {
		Assert.assertEquals(1, Pos.A_1.getCol());
	}

}
