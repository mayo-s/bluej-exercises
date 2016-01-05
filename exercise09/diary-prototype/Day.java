/**
 * Maintain the appointments for one day in a diary.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class Day
{
    // The first and final bookable hours in a day.
    public static final int START_OF_DAY = 9;
    public static final int FINAL_APPOINTMENT_TIME = 17;
    // The number of bookable hours in a day.
    public static final int MAX_APPOINTMENTS_PER_DAY =
                                FINAL_APPOINTMENT_TIME -
                                START_OF_DAY + 1;
    
    // A day number within a particular year. (1-366)
    private int dayNumber;
    // The current list of appointments for this day.
    private Appointment[] appointments;

    /**
     * Constructor for objects of class Day.
     * @param dayNumber The number of this day in the year (1-366).
     */
    public Day(int dayNumber)
    {
        this.dayNumber = dayNumber;
        appointments = new Appointment[MAX_APPOINTMENTS_PER_DAY];
    }

    /**
     * Try to find space for an appointment.
     * @param appointment The appointment to be accommodated.
     * @return The earliest time today that can accommodate
     *         the appointment. Return -1 if there is 
     *         insufficient space.
     */ 
    public int findSpace(Appointment appointment)
    {
        int duration = appointment.getDuration();
        for(int slot = 0; slot < MAX_APPOINTMENTS_PER_DAY; slot++) {
            if(appointments[slot] == null) {
                final int time = START_OF_DAY + slot;
                // Potential start point.
                if(duration == 1) {
                    // Only a single slot needed.
                    return time;
                }
                else {
                    // How many more slots are needed?
                    int further_slots_required = duration - 1;
                    for(int nextSlot = slot + 1;
                                further_slots_required > 0 &&
                                appointments[nextSlot] == null;
                                    nextSlot++) {
                        further_slots_required--;
                    }
                    if(further_slots_required == 0) {
                        // A big enough space has been found.
                        return time;
                    }
                }
            }
        }
        // Not enough space available.
        return -1;
    }

    /**
     * Make an appointment.
     * @param time The hour at which the appointment starts.
     * @param appointment The appointment to be made.
     * @return true if the appointment was successful,
     *         false otherwise.
     */
    public boolean makeAppointment(int time,
                                   Appointment appointment)
    {
        if(validTime(time)) {
            int startTime = time - START_OF_DAY;
            if(appointments[startTime] == null) {
                int duration = appointment.getDuration();
                // Fill in all the slots for the full duration
                // of the appointment.
                for(int i = 0; i < duration; i++) {
                    appointments[startTime + i] = appointment;
                }
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    
    /**
     * @param time Which time of day. This must be between the
     *        START_OF_DAY time and the FINAL_APPOINTMENT_TIME.
     * @return The Appointment at the given time. null is returned
     *         if either the time is invalid or there is no
     *         Appointment at the given time.
     */
    public Appointment getAppointment(int time)
    {
        if(validTime(time)) {
            return appointments[time - START_OF_DAY];
        }
        else {
            return null;
        }
    }

    /**
     * Print a list of the day's appointments on standard output.
     */
    public void showAppointments()
    {
        System.out.println("=== Day " + dayNumber + " ===");
        int time = START_OF_DAY;
        for(Appointment appointment : appointments) {
            System.out.print(time + ": ");
            if(appointment != null) {
                System.out.println(appointment.getDescription());
            }
            else {
                System.out.println();
            }
            time++;
        }
    }

    /**
     * @return The number of this day within the year (1 - 366).
     */
    public int getDayNumber()
    {
        return dayNumber;
    }
    
    /**
     * @return true if the time is between FINAL_APPOINTMENT_TIME and
     *         END_OF_DAY, false otherwise.
     */
    public boolean validTime(int time)
    {
        return time >= START_OF_DAY && time <= FINAL_APPOINTMENT_TIME;
    }
}
