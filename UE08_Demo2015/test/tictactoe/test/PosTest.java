package tictactoe.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
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
	
	@Test
	public void testGetPosFailed() {
		try {
			Pos.getPos('D', 1); 
			fail(); 
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().endsWith("D_1")); 
		}
		try {
			Pos.getPos('D', 2); 
			fail(); 
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().endsWith("D_2")); 
		}
		try {
			Pos.getPos('D', 3); 
			fail(); 
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().endsWith("D_3")); 
		}
		try {
			Pos.getPos('A', 4); 
			fail(); 
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().endsWith("A_4")); 
		}
		try {
			Pos.getPos('B', 4); 
			fail(); 
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().endsWith("B_4")); 
		}
		try {
			Pos.getPos('C', 6); 
			fail(); 
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().endsWith("C_6")); 
		}
		try {
			Pos.getPos('E', 6); 
			fail(); 
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().endsWith("E_6")); 
		}
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGetPosExeption1() {
		 assertEquals(null, Pos.getPos('D', 1));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGetPosExeption2() {
		 assertEquals(null, Pos.getPos('C', 4));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGetPosExeption3() {
		 assertEquals(null, Pos.getPos('D', 3));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGetPosExeption4() {
		 assertEquals(null, Pos.getPos('A', 5));
	}

	@Test
	public void testGetCol() {
		 assertEquals(1, Pos.A_1.getCol());
		 assertEquals(2, Pos.A_2.getCol());
		 assertEquals(3, Pos.A_3.getCol());
		 assertEquals(1, Pos.B_1.getCol());
		 assertEquals(2, Pos.B_2.getCol());
		 assertEquals(3, Pos.B_3.getCol());
		 assertEquals(1, Pos.C_1.getCol());
		 assertEquals(2, Pos.C_2.getCol());
		 assertEquals(3, Pos.C_3.getCol());
	}

	@Test
	public void testGetRow() {
		 assertEquals('A', Pos.A_1.getRow());
		 assertEquals('A', Pos.A_2.getRow());
		 assertEquals('A', Pos.A_3.getRow());
		 assertEquals('B', Pos.B_1.getRow());
		 assertEquals('B', Pos.B_2.getRow());
		 assertEquals('B', Pos.B_3.getRow());
		 assertEquals('C', Pos.C_1.getRow());
		 assertEquals('C', Pos.C_2.getRow());
		 assertEquals('C', Pos.C_3.getRow());
	}

}
