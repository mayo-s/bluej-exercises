/**
 * Represent a week's worth of Days.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class Week
{
    // Represent a Week as a set of Monday to Friday days.
    public static final int BOOKABLE_DAYS_PER_WEEK = 5;
    
    // A week number within a particular year (0-52).
    private final int weekNumber;
    private final Day[] days;

    /**
     * Constructor for objects of class Week.
     * @param weekNumber The week number (0-52).
     */
    public Week(int weekNumber)
    {
        this.weekNumber = weekNumber;
        days = new Day[BOOKABLE_DAYS_PER_WEEK];
        int dayInYear = weekNumber * 7 + 1;
        for(int day = 0; day < BOOKABLE_DAYS_PER_WEEK; day++) {
            days[day] = new Day(dayInYear);
            dayInYear++;
        }
    }

    /**
     * Print a list of appointments for this week on standard output.
     */
    public void showAppointments()
    {
        System.out.println("*** Week " + weekNumber + " ***");
        for(Day day : days) {
            day.showAppointments();
        }
    }

    /**
     * @param dayInWeek Which day (1..BOOKABLE_DAYS_PER_WEEK).
     * @return The Day representing that day number, or null if
     *         dayInWeek is out of range.
     */
    public Day getDay(int dayInWeek)
    {
        if(dayInWeek >= 1 && dayInWeek <= BOOKABLE_DAYS_PER_WEEK) {
            return days[dayInWeek - 1];
        }
        else {
            return null;
        }
    }

    /**
     * @return The week number (0-52).
     */
    public int getWeekNumber()
    {
        return weekNumber;
    }
}
