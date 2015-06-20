package coll.test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*; 

import coll.LinkedList;


public class LinkedListTest {

	LinkedList<String> l; 

	@Before
	public void setUp() throws Exception {
		l = new LinkedList<String>();
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
	public void testContains() {
		assertFalse(l.contains(null)); 
		assertFalse(l.contains("A")); 
		assertFalse(l.contains("B")); 
		assertFalse(l.contains("C")); 
		l.add("A"); 
		assertFalse(l.contains(null)); 
		assertTrue(l.contains("A")); 
		assertFalse(l.contains("B")); 
		assertFalse(l.contains("C")); 
		l.add("B"); 
		assertFalse(l.contains(null)); 
		assertTrue(l.contains("A")); 
		assertTrue(l.contains("B")); 
		assertFalse(l.contains("C")); 
		l.add("C"); 
		assertFalse(l.contains(null)); 
		assertTrue(l.contains("A")); 
		assertTrue(l.contains("B")); 
		assertTrue(l.contains("C")); 
	}

	@Test
	public void testAdd() {
		l.add("A"); 
		assertTrue(l.contains("A")); 
		assertEquals(1, l.size()); 
		l.add("B"); 
		assertTrue(l.contains("A")); 
		assertTrue(l.contains("B")); 
		assertEquals(2, l.size()); 
		l.add("C"); 
		assertTrue(l.contains("A")); 
		assertTrue(l.contains("B")); 
		assertTrue(l.contains("C")); 
		assertEquals(3, l.size()); 
	}

	@Test
	public void testIterator() {
		assertFalse(l.iterator().hasNext()); 
		
		l.add("A"); 
		Iterator<String>  lit = l.iterator(); 
		assertTrue(lit.hasNext()); 
		String v = lit.next(); 
		assertEquals("A", v); 
		assertFalse(lit.hasNext()); 
		
		l.add("B"); 
		lit = l.iterator(); 
		assertTrue(lit.hasNext()); 
		v = lit.next(); 
		assertEquals("B", v); 
		assertTrue(lit.hasNext()); 
		v = lit.next(); 
		assertEquals("A", v); 
		assertFalse(lit.hasNext()); 

	}
	
	@Test
	public void testIteratorException1 () {
		Iterator<String>  lit; 
		lit = l.iterator(); 
		try {
			lit.next(); 
			fail(); 
		} catch (NoSuchElementException expt) {
			assertEquals("No more element in list", expt.getMessage()); 
		}
		
		l.add("A"); 
		l.add("B"); 
		
		lit = l.iterator(); 
		lit.next(); 
		lit.next(); 
		try {
			lit.next(); 
			fail(); 
		} catch (NoSuchElementException expt) {
			assertEquals("No more element in list", expt.getMessage()); 
		}
		
		try {
			lit.remove(); 
			fail(); 
		} catch (UnsupportedOperationException excpt) {
			assertEquals("removal of elements not supported", excpt.getMessage()); 
		}
	}

	@Test(expected = NoSuchElementException.class)
	public void testIteratorException2 () {
		Iterator<String>  lit; 
		lit = l.iterator(); 
		lit.next(); 
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testIteratorException3 () {
		Iterator<String>  lit; 
		l.add("A"); 
		l.add("B"); 
		lit = l.iterator(); 
		lit.next(); 
		lit.next(); 
		lit.next(); 
	}		

	@Test(expected = UnsupportedOperationException.class)
	public void testIteratorException4 () {
		Iterator<String>  lit; 
		l.add("A"); 
		l.add("B"); 
		lit = l.iterator(); 
		lit.next(); 
		lit.remove();
	}

}
