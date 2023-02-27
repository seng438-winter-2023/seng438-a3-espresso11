import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class ConstrainTest{
	@BeforeClass public static void setUpBeforeClass() throws Exception {
    }
	private Range exampleRange;
	private Range exampleRange2;
	
	@Before
    public void setUp() throws Exception { 
		exampleRange = new Range(-1, 1);
		exampleRange2 = new Range(-1, -1);//size zero
    }
	/*if the input number is lower than the lower boundary of the range than the constrain should be the lower boundary*/
	@Test
	public void numberLowerThanLowerBoundary() {
		assertEquals("The constrain value of -5 in the range of -1 and 1 should be -1)",-1,exampleRange.constrain(-5), 0.000001d);
	}
	/*if the input number is lower than the lower boundary of a range of zero than the constrain should be the lower boundary*/
	@Test
	public void numberLowerThanLowerBoundaryWithRangeZero() {
		assertEquals("The constrain value of -5 in the range of -1 and -1 should be -1)",-1,exampleRange2.constrain(-5), 0.000001d);
	}
	/*if the input number is higher than the upper boundary of the range than the constrain should be the upper boundary*/
	@Test
	public void numberHigherThanUpperBoundary() {
		assertEquals("The constrain value of 5 in the range of -1 and 1 should be 1)",1,exampleRange.constrain(-5), 0.000001d);
	}
	/*if the input number is higher than the upper boundary of a range of zero than the constrain should be the upper boundary*/
	@Test
	public void numberHigherThanUpperBoundaryWithRangeZero() {
		assertEquals("The constrain value of 5 in the range of -1 and -1 should be -1)",-1,exampleRange2.constrain(-5), 0.000001d);
	}
	/*if the input number is within the range than the constrain should be the input*/
	@Test
	public void numberWithinRange() {
		assertEquals("The constrain value of 0 in the range of -1 and 1 should be 0)",0,exampleRange.constrain(-5), 0.000001d);
	}
	/*if the input number is equal to the lower boundary of the range than the constrain should be the input/lower boundary*/
	@Test
	public void numberIsLowerBoundary() {
		assertEquals("The constrain value of -1 in the range of -1 and 1 should be -1)",-1,exampleRange.constrain(-5), 0.000001d);
	}
	/*if the input number is equal to the upper boundary of the range than the constrain should be the input/upper boundary*/
	@Test
	public void numberIsUpperBoundary() {
		assertEquals("The constrain value of 1 in the range of -1 and 1 should be 1)",1,exampleRange.constrain(-5), 0.000001d);
	}
	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
