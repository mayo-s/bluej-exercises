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
public class Clock24Display
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;   // simulates the actual display
    private int alarmHour;
    private int alarmMinute;
    private boolean alarmOnOff;     //Switch to turn alarm function on/off
    
    /**
     * Constructor for Clock24Display objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public Clock24Display()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public Clock24Display(int hour, int minute)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
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
        }
        updateDisplay();
        
        alarmRinging();
        
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
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
     * Set the time of Alarm to the specified hour and
     * minute.
     */
    public void setAlarmTime(int hour, int minute, boolean onoff){
        
        alarmHour = hour;
        alarmMinute = minute;
        alarmOnOff = onoff;
    }   
    
    /**
     * Switch to turn the alarm on and off
     */
    public void setAlarmOnOff(boolean onoff){
        
        alarmOnOff = onoff;
        
        if(alarmOnOff == true){
            System.out.println("Alarm Function ON");
        }
        else{
            System.out.println("Alarm Function OFF");
        }
    }
    
    
    /**
     * When alarmtime reached ==> ring
     */
    private void alarmRinging(){
        if(alarmOnOff==true){
            if(alarmHour == hours.getValue() && alarmMinute == minutes.getValue()){
                System.out.println("RIIIIIIIIIIING");
            }
        }
        
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        String isam;
        int hour = hours.getValue();
        
        if(hours.getValue() < 12){
            isam="am";
        }
        else{
            isam="pm";
        }
        
        if(hours.getValue() > 12){
            hour = hours.getValue() - 12;
        }
        if(hours.getValue() == 0){
            hour = 12;
        }
               
        displayString = hour + ":" + minutes.getDisplayValue() + isam;
        
        
    }
}