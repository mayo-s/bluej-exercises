

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class ResponderTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ResponderTest
{
    /**
     * Default constructor for test class ResponderTest
     */
    public ResponderTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testSplitInputIntoWords()
    {
        Responder responder = new Responder();
        HashSet<String> expected = new HashSet<String>();
        expected.add("my");
        expected.add("computer");
        expected.add("is");
        expected.add("slow");
        // HashSet<String>  actual = responder.splitInputInputIntoWords("my computer is slow");
        // assertEquals(expected, actual);
        // another example how we could do this:
        // assertTrue(actual.contains("computer"));
    }
}

