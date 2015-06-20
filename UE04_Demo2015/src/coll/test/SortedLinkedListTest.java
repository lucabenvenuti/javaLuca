package coll.test;


import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*; 

import coll.SortedLinkedList;

public class SortedLinkedListTest {

	SortedLinkedList<String> l; 

	@Before
	public void setUp() throws Exception {
		l = new SortedLinkedList<String>();
	}

	@After
	public void tearDown() throws Exception {
		l = null; 
	}

	@Test
	public void testSize() {
		assertEquals(0, l.size()); 
		l.add("A"); 
		assertEquals(1, l.size()); 
		l.add("B"); 
		assertEquals(2, l.size()); 
		l.add("C"); 
		assertEquals(3, l.size()); 
	}

	@Test
	public void testAdd() {
		Iterator<String> lit; 
		String s; 
		
		l.add("C"); 
		lit = l.iterator(); 
		s = lit.next(); 
		assertEquals("C", s); 
		
		l.add("A"); 
		lit = l.iterator(); 
		s = lit.next(); 
		assertEquals("A", s); 
		s = lit.next(); 
		assertEquals("C", s); 

		l.add("B"); 
		lit = l.iterator(); 
		s = lit.next(); 
		assertEquals("A", s); 
		s = lit.next(); 
		assertEquals("B", s); 
		s = lit.next(); 
		assertEquals("C", s); 
	}

	@Test
	public void testContains() {
		assertFalse(l.contains("A")); 
		assertFalse(l.contains("B")); 
		assertFalse(l.contains("C")); 
		assertFalse(l.contains("D")); 
		assertFalse(l.contains("E")); 
		assertFalse(l.contains("F")); 
		assertFalse(l.contains("G")); 
		l.add("G"); 
		assertFalse(l.contains("A")); 
		assertFalse(l.contains("B")); 
		assertFalse(l.contains("C")); 
		assertFalse(l.contains("D")); 
		assertFalse(l.contains("E")); 
		assertFalse(l.contains("F")); 
		assertTrue(l.contains("G")); 
		l.add("B"); 
		assertFalse(l.contains("A")); 
		assertTrue(l.contains("B")); 
		assertFalse(l.contains("C")); 
		assertFalse(l.contains("D")); 
		assertFalse(l.contains("E")); 
		assertFalse(l.contains("F")); 
		assertTrue(l.contains("G")); 
		l.add("D"); 
		assertFalse(l.contains("A")); 
		assertTrue(l.contains("B")); 
		assertFalse(l.contains("C")); 
		assertTrue(l.contains("D")); 
		assertFalse(l.contains("E")); 
		assertFalse(l.contains("F")); 
		assertTrue(l.contains("G")); 
	}


}
