import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class EqualsTest {
	@BeforeClass public static void setUpBeforeClass() throws Exception {
    }
	private Range range;
	@Before
    public void setUp() throws Exception {		
		range = new Range(10, 50); //create range from 10 to 100
	}
	
	//if two upper boundaries are same but the lower boundaries are different 
	@Test
	public void sameUpperBoundary() {
		assertEquals("Testing two Range objects with the same upper boundary but different lower boundaries", false, range.equals(new Range(20, 50)));
	}
	
	//if two lower boundaries are same but the upper boundaries are different 
	@Test
	public void  sameLowerBoundary() {
		assertEquals("Testing two Range objects with the same lower boundary but different upper boundaries", false, range.equals(new Range(10, 40)));
	}
	
	//if two different objects with different ranges are equal
	@Test
	public void diffRanges() {
		assertEquals("Testing object with two different ranges", false, range.equals(new Range(30, 70)));
	}
	
	//is two different objects with same ranges are equal
	@Test
	public void sameRanges() {
		assertEquals("Testing object with two same ranges", true, range.equals(new Range(10, 50)));
	}
	
	//if null is used
	@Test
	public void nullRange() {
		assertEquals("Testing a null range object", false, range.equals(null));
	}
	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
