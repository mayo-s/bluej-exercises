import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DayTest.
 *
 * @author  (Mario Schuetz)
 * @version (2015-12-30)
 */
public class DayTest
{
    /**
     * Default constructor for test class DayTest
     */
    public DayTest()
    {
    }
    Day day1;
    Day day2;
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
      day1 = new Day(1);
      
      day2 = new Day(1);
      Appointment appointm1 = new Appointment("lang", 2);
      day2.makeAppointment(9, appointm1);
    }

    

    @Test
    public void positiveFindSpace()
    {
        // given an empty day & and a 2 h Appointment:      
        Appointment appointm1 = new Appointment("Zahnarzt", 2);
        //when
        int actual = day1.findSpace(appointm1);
        //then
        assertEquals("first slot of day should be returned",
        9, actual);
    }
     @Test
    public void negativeFindSpace()
    {
        // given a full day & and a 2 h Appointment:
        Appointment appointm1 = new Appointment("lang", 9);
        assertEquals(true, day1.makeAppointment(9, appointm1));
        Appointment appointm2 = new Appointment("Zahnarzt", 2);
        //when
        int actual = day1.findSpace(appointm2);
        //then
        assertEquals("no available time, -1 should be returned",
        -1, actual);
    }

    @Test
    public void positiveMakeAppointment()
    {
        Appointment appointm1 = new Appointment("lang", 8);
        assertEquals(true, day1.makeAppointment(9, appointm1));
        assertEquals(appointm1, day1.getAppointment(9));
    }
    
    @Test //findSpace returns value 10 for 1 hour appointment
    public void oneHourApp(){        
        Appointment newApp1 = new Appointment("First", 1);
        // assertEquals(true, 
        day1.makeAppointment(9, newApp1);
        
        Appointment newApp2 = new Appointment("Whatever", 1);     
        int actual = day1.findSpace(newApp2);        
        assertEquals("First available time for 2nd appointment should be at 10", 10, actual); // should return 10
    }
    
    @Test // use findSpace on a full day
    public void fullDay(){        
        Appointment newApp1 = new Appointment("First", 9);
        // assertEquals(true, 
        day1.makeAppointment(9, newApp1);
        
        Appointment newApp2 = new Appointment("Whatever", 1);     
        int actual = day1.findSpace(newApp2);        
        assertEquals("should return -1", -1, actual);
    }
    
    @Test // two appointments at the same time
    public void falseTwoAppointments()
    {
        Appointment appointm1 = new Appointment("One", 4);
        day1.makeAppointment(12, appointm1); 
        
        Appointment appointm2 = new Appointment("Two", 2);
        assertEquals(false, day1.makeAppointment(13, appointm2));
    }
}


