package org.jfree.data;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class hashCodeTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		x = new String("String");
	        y = new String("String");
	}
	
	@Test
	public void testReflexiveEquality() {
	// for any non-null reference value x, x.equals(x) should return true
		assertTrue(x.equals(x));
		assertTrue(x.hashCode() == x.hashCode());
	}
	
	@Test
	public void testSymmetricEquality() {
	/* for any non-null reference values x and y, x.equals(y) should return true
	if and only if y.equals(x) returns true */
		assertTrue(x.equals(y) && y.equals(x));
		assertTrue(x.hashCode() == y.hashCode());
	}
    
        @After
        public void tearDown() throws Exception {
        }
    
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
