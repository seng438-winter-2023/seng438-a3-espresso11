package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class ContainsTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	private Range range; 
	@Before
	public void setUp() throws Exception {
		range = new Range(5, 20);// new range from 5 to 20
	}
	
	//if the lower boundary is in the range 
	@Test
	public void inLowerBoundary() {
		assertTrue("The lower boundary is out of the range", this.range.contains(5));
	}
	
	//if the upper boundary is in the range 
	@Test
	public void inUpperBoundary() {
		assertTrue("The upper Bound is out of the range", this.range.contains(20));
	}
	
	//number in between the range
	@Test
	public void numberInRange() {
		assertTrue("The number is out of the range", this.range.contains(10));
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
