

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AppointmentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AppointmentTest
{
    /**
     * Default constructor for test class AppointmentTest
     */
    public AppointmentTest()
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

    /**
     * check for appointment
     */
    @Test
     
    public void checkApp()
    {
        Appointment appointm1 = new Appointment("Sports", 3);
        assertEquals("Sports", appointm1.getDescription());
        assertEquals(3, appointm1.getDuration());
    }
}

