package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataUtilitesTest extends DataUtilities {
	Mockery mockingContext;
    private Values2D values;
    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		 mockingContext = new Mockery();
	     values = mockingContext.mock(Values2D.class);
	     
	}
	
	
	
	// calculateColumnTotal() test cases 
//	pass: returns correct value for three rows
	@Test
	public void calculateColumnTotalForThreeRows() {
	    // setup
	 
	    
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(3));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	            one(values).getValue(2, 0);
	            will(returnValue(10));
	            
	        }
	    });
	    //exercise	
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    // verify
	    assertEquals(result, 20.0, .001d);
	    // tear-down: NONE in this test method
	}
	
	// pass: returns correct value for multiple columns
	@Test
	public void calculateColumnTotalForMutipleColumns() {
	    
	    mockingContext.checking(new Expectations() {
	        {
//	        	one(values).getColumnCount();
//	            will(returnValue(2));
	            
	            one(values).getRowCount();
	            will(returnValue(3));
	            
	            one(values).getValue(0, 0);
	            will(returnValue(5));
	            one(values).getValue(1, 0);
	            will(returnValue(10));
	            one(values).getValue(2, 0);
	            will(returnValue(3));
	            
	            will(returnValue(3));
	            one(values).getValue(0, 1);
	            will(returnValue(1));
	            one(values).getValue(1, 1);
	            will(returnValue(1));
	            one(values).getValue(2, 1);
	            will(returnValue(2));
	            
	        }
	    });
	    
	    //exercise	
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    // verify
	    assertEquals(result, 18.0, .00001d);
	    // tear-down: NONE in this test method
	}

	// fails: throws incorrect exception
	@Test (expected = InvalidParameterException.class)
	 public void calculateColumnTotalInvalidObject() throws Exception{
		 DataUtilities.calculateColumnTotal(null, 0);
	 }
	
	// calculateRowTotal() test cases
	// pass: returns correct value for one row
	@Test
	public void calculateRowTotalForOneRow() {
	    
	    mockingContext.checking(new Expectations() {
	        {
	        	
	            one(values).getColumnCount();
	            will(returnValue(1));
	            
	            one(values).getValue(0, 0);
	            will(returnValue(3));
	            one(values).getValue(0, 1);
	            will(returnValue(2));
	            one(values).getValue(0, 2);
	            will(returnValue(3));
	            
	        }
	    });
	    
	    //exercise	
	    double result = DataUtilities.calculateRowTotal(values,0);
	    assertEquals(3, result, .000000001d);
	    // tear-down: NONE in this test method
	}
	
	// pass: returns correct value for multiple rows
	@Test
	public void calculateRowTotalForMutipleRows() {
	    
	    mockingContext.checking(new Expectations() {
	        {
	        	
	            one(values).getColumnCount();
	            will(returnValue(3));
	            
	  
	            one(values).getValue(1, 0);
	            will(returnValue(1));
	            one(values).getValue(1, 1);
	            will(returnValue(1));
	            one(values).getValue(1, 2);
	            will(returnValue(2));
	            
	        }
	    });
	    
	    //exercise	
	    double result = DataUtilities.calculateRowTotal(values,1);
	    // verify
	    assertEquals(4.0, result, .00001d);
	    // tear-down: NONE in this test method
	}
	

	/**
	 * Testing function when data is valid and row is negative
	 */
	@Test
	public void NonEmptyArrayNegRow() {
		
				mockingContext.checking(new Expectations() { 
					{
						one(values).getColumnCount(); 
						will(returnValue(2));
						
						one(values).getValue(-0, 0);
						will(returnValue(null));
						
						one(values).getValue(-0, 1); 
						will(returnValue(null));
						
						
					} 
				});
			
		//exercise	
	    double result = DataUtilities.calculateRowTotal(values,-0);
	    // verify
		assertEquals(0.0, result, .000000001d);
	}

	// fail: throws incorrect exception
	@Test (expected = InvalidParameterException.class)
	 public void calculateRowTotalInvalidObject() throws Exception{
		 DataUtilities.calculateRowTotal(null, 0);
	 }

	
	// createNumberArray() test cases
	/* Fail
	 * The last element is returned as null
	 */
	
	@Test
	 public void createNumberArrayFourDoubleElements() {
		double[] test = new double[] { 1.0, 1.11, -1.52, 1.5};
		Number arr[] = DataUtilities.createNumberArray(new double[] { 1.0, 1.11, -1.52, 1.5});
		assertEquals("Data of arrays should be equal.",
				test[0], arr[0]);	 
	assertEquals("Data of arrays should be equal.",
			test[1], arr[1]);
	assertEquals("Data of arrays should be equal.",
			test[2], arr[2]);
	assertEquals("Data of arrays should be equal.",
			test[3], arr[3]);}
	
	/* Pass 
	 * Returns all the elements except the last one
	 */
	
	@Test
	 public void createNumberArrayThreeDoubleElements() {
		double[] test = new double[] { 1.0, 1.11, -1.52, 1.5};
		Number arr[] = DataUtilities.createNumberArray(new double[] { 1.0, 1.11, -1.52, 1.5});
		assertEquals("Data of arrays should be equal.",
				test[0], arr[0]);	 
	assertEquals("Data of arrays should be equal.",
			test[1], arr[1]);
	assertEquals("Data of arrays should be equal.",
			test[2], arr[2]);}
	
	/* Pass 
	 * Returns the correct length
	 */
	
	@Test
	public void createNumberArraySizeTest() {
		double[] test1 = new double[] { 1.0, 1.11, -1.52, 1.5};
		Number arr1[] = DataUtilities.createNumberArray(new double[] { 1.0, 1.11, -1.52, 1.5});
		assertEquals("Length of arrays should be equal.",
				test1.length, arr1.length);

	}
	
	/* Pass 
	 * Throws an exception if the function is passed a null value
	 */

	@Test(expected = IllegalArgumentException.class)
	 public void createNumberArrayNullArgument() throws Exception{
		 DataUtilities.createNumberArray(null);
	 }
	
	
	// createNumberArray2D() test cases
	/* Fail
	 * The last element is returned as null
	 */
	
	@Test
	public void create2DNumberArrayThreeDoubleElements() {
		double[][] test = new double[][]{{1.0, 3.0, 7.0}, {2.0, 4.0, 4.4}};
		Number[][] arr = DataUtilities.createNumberArray2D(new double[][]{{1.0, 3.0, 7.0}, {2.0, 4.0, 4.4}});
		assertEquals("Data of arrays should be equal.",
				test[0][0], arr[0][0]);	 
		assertEquals("Data of arrays should be equal.",
			test[0][1], arr[0][1]);
		assertEquals("Data of arrays should be equal.",
			test[0][2], arr[0][2]);
		
		assertEquals("Data of arrays should be equal.",
		test[1][2], arr[1][2]);
			
	}
	
	/* Pass 
	 * Returns all the elements except the last one
	 */
	
	@Test
	public void create2DNumberArrayTwoDoubleElements() {
		double[][] test = new double[][]{{1.0, 3.0, 7.0}, {2.0, 4.0, 4.4}};
		Number[][] arr = DataUtilities.createNumberArray2D(new double[][]{{1.0, 3.0, 7.0}, {2.0, 4.0, 4.4}});
		assertEquals("Data of arrays should be equal.",
				test[0][0], arr[0][0]);	 
		assertEquals("Data of arrays should be equal.",
			test[0][1], arr[0][1]);
		assertEquals("Data of arrays should be equal.",
				test[1][0], arr[1][0]);	 
		assertEquals("Data of arrays should be equal.",
			test[1][1], arr[1][1]);
		
			
	}
	
	/* Pass 
	 * Returns the correct length
	 */
	
	@Test
	public void create2DNumberArraySizeTest() {
		double[][] test = new double[][]{{1.0, 3.0, 7.0}, {2.0, 4.0, 4.4}};
		Number[][] arr = DataUtilities.createNumberArray2D(new double[][]{{1.0, 3.0, 7.0}, {2.0, 4.0, 4.4}});
		assertEquals("Length of arrays should be equal.",
				test.length, arr.length);

	}
	
	/* Pass 
	 * Throws an exception if the function is passed a null value
	 */
	
	@Test(expected = IllegalArgumentException.class)
	 public void create2DNumberArrayNullArgument() throws Exception{
		 DataUtilities.createNumberArray2D(null);
	 }
	
	// getCumulativePercentages() test cases
	// fail: returns wrong percentage
	@Test
	 public void testingAllElements(){
		Mockery mockingContext = new Mockery();
		final KeyedValues keyValues = mockingContext.mock(KeyedValues.class);
		 mockingContext.checking(new Expectations() {
			{
				atLeast(1).of(keyValues).getItemCount();
				will(returnValue(3));
	        	
				atLeast(1).of(keyValues).getValue(0);
				will(returnValue(1));
				
				atLeast(1).of(keyValues).getValue(1);
				will(returnValue(2));
				
				atLeast(1).of(keyValues).getValue(2);
				will(returnValue(3));
				
				atLeast(1).of(keyValues).getKey(0);
				will(returnValue("key0"));
				
				atLeast(1).of(keyValues).getKey(1);
				will(returnValue("key1"));
				
				atLeast(1).of(keyValues).getKey(2);
				will(returnValue("key2"));
	     	}
		 });
		 
		 KeyedValues result = DataUtilities.getCumulativePercentages(keyValues);
		 
		 assertEquals(0.5, result.getValue(1).doubleValue(), .000000001d);
		 assertEquals(1.0, result.getValue(2).doubleValue(), .000000001d);
	 }
	

	 // pass: returns correct percentage
	 @Test
		public void allZeroRows(){
			Mockery mockingContext = new Mockery();
			final KeyedValues values = mockingContext.mock(KeyedValues.class);
			mockingContext.checking(new Expectations() {
				{
					allowing(values).getItemCount();
					will(returnValue(4));
					allowing(values).getValue(0);
					will(returnValue(0));
					allowing(values).getValue(1);
					will(returnValue(0));
					allowing(values).getValue(2);
					will(returnValue(0));
					allowing(values).getValue(3);
					will(returnValue(0));
					allowing(values).getKey(0);
					will(returnValue(0));
					allowing(values).getKey(1);
					will(returnValue(1));
					allowing(values).getKey(2);
					will(returnValue(2));
					allowing(values).getKey(3);
					will(returnValue(3));
				}
			});
			
			KeyedValues result = DataUtilities.getCumulativePercentages(values);
			assertEquals(0.0 / 0.0, result.getValue(0));
			assertEquals(0.0 / 0.0, result.getValue(1));
			assertEquals(0.0 / 0.0, result.getValue(2));
			assertEquals(0.0 / 0.0, result.getValue(3));
		}
	 
	 // fail: first percentage value is wrong
	 @Test
		public void lastTwoRowsZero(){
			Mockery mockingContext = new Mockery();
			final KeyedValues values = mockingContext.mock(KeyedValues.class);
			mockingContext.checking(new Expectations() {
				{
					allowing(values).getItemCount();
					will(returnValue(3));
					allowing(values).getValue(0);
					will(returnValue(2));
					allowing(values).getValue(1);
					will(returnValue(0));
					allowing(values).getValue(2);
					will(returnValue(0));
					
					allowing(values).getKey(0);
					will(returnValue(0));
					allowing(values).getKey(1);
					will(returnValue(1));
					allowing(values).getKey(2);
					will(returnValue(2));
					
				}
			});
			
			KeyedValues result = DataUtilities.getCumulativePercentages(values);
			assertEquals(1.0, result.getValue(0));
			assertEquals(1.0, result.getValue(1));
			assertEquals(1.0, result.getValue(2));
			
		}
	 
	 // pass: returns the correct percentage
	 @Test
		public void firstThreeRowsZero(){
			Mockery mockingContext = new Mockery();
			final KeyedValues values = mockingContext.mock(KeyedValues.class);
			mockingContext.checking(new Expectations() {
				{
					allowing(values).getItemCount();
					will(returnValue(3));
					allowing(values).getValue(0);
					will(returnValue(0));
					allowing(values).getValue(1);
					will(returnValue(0));
					allowing(values).getValue(2);
					will(returnValue(2));
					
					allowing(values).getKey(0);
					will(returnValue(0));
					allowing(values).getKey(1);
					will(returnValue(1));
					allowing(values).getKey(2);
					will(returnValue(2));
					
				}
			});
			
			KeyedValues result = DataUtilities.getCumulativePercentages(values);
			assertEquals(0.0, result.getValue(0));
			assertEquals(0.0, result.getValue(1));
			assertEquals(1.0, result.getValue(2));
			
		}
	 
	 // pass: correct exception thrown
	 @Test (expected = IllegalArgumentException.class)
	 public void getCumulativePercentagesNullArgument() throws Exception{
		 DataUtilities.getCumulativePercentages(null);
	 }
	 /**
		 * Test if a null parameter will result the method to fail
		 */
		@Test
		public void nullCumulativePercentageTest() {
			try {
				DataUtilities.getCumulativePercentages(null);
				fail("Cannot pass in null as a variable");
			}catch(Exception e) {
				assertTrue("Null is allowed as an argument", true);
			}
		}
	
	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	
	

	
	

}