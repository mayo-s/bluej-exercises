
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class Clock12Display
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    private boolean isam=true; //declares am (default) or pm
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00 (am default).
     */
    public Clock12Display()
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public Clock12Display(int hour, int minute, boolean isam)
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        this.isam = isam;
        setTime(hour, minute, isam);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
            if(hours.getValue() == 0){
                   isam=false;
            }
            else{
                   isam =true;
            }
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute, boolean isam)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        this.isam = isam;
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        String isamValue;
               
        if(isam==true){
            isamValue="am";
        }
        else{
            isamValue="pm";
        }
        
        if(hours.getValue() == 0){
            displayString = "12:" + minutes.getDisplayValue() + isamValue;
        }
        else{    
            displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue() + isamValue;
                    }
    }
}
