package tictactoe.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tictactoe.Stone;

public class StoneTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetLabel() {
		assertEquals("-", Stone.FREE.getLabel()); 
		assertEquals("X", Stone.X.getLabel()); 
		assertEquals("O", Stone.O.getLabel()); 
	}

}
