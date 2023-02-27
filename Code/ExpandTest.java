import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class ExpandTest {
	@BeforeClass public static void setUpBeforeClass() throws Exception {
    }
	@Before
    public void setUp() throws Exception {		
	}
	
	private Range range1, range2;

	//if we can use 0 for the lower and upper boundary
	@Test
	public void expandUsingZeroMarginsTest() {
		range1 = new Range(12, 32);
		range2 = new Range(13, 20);
		assertEquals("Used expand with 0 on both ranges but the range changed.", Range.expand(range1, 0, 0), range2);
	}
	
	//if null range object is used
	@Test
	public void nullRange() {
		try {
			Range.expand(null,0.2,0.5);
			fail("InvalidParameterException was not used");
		}
		catch(Exception e) {
			assertEquals("Did not use InvalidParameterException", IllegalArgumentException.class, e.getClass());
		}
	}
	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}


}
