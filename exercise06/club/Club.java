import java.util.ArrayList;
import java.util.Iterator;
/**
 * Store details of club memberships.
 * 
 * @author (Mario Schuetz) 
 * @version (2015-12-01)
 */
public class Club
{
    private ArrayList<Membership> clubMembers;
    
    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
        clubMembers = new ArrayList<Membership>();        
    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member){
        
        if(search(member.getName())==0){
            clubMembers.add(member);            
            System.out.println(member.getName() + " added to club-list.");
        }
        else{
            System.out.println(member.getName() + " is already a member of the club.");
        }        
     }

    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers(){
         return clubMembers.size();
    }
    
    /**
    *   return number of joined members in particular month of year
    */
    public void numberJoinedInMonth(int month, int year){
              
        if(month > 0 && month <=12){            
            int membersJoined = 0;
            
            for(Membership member : clubMembers){                
                if(month == member.getMonth() && year == member.getYear()){
                    membersJoined++;
                }
            }
            System.out.println(membersJoined + " have joind your club in the " + month + "th month of " + year);
        }
        else
            System.out.println("Not a valid month. Enter a number between 1 and 12.");
        
    }
    
    public void listJoinedInMonth(int month, int year){
        if(month > 0 && month <=12){
            for(Membership member : clubMembers){                
                if(month == member.getMonth() && year == member.getYear()){
                    System.out.println(member.getName());
                }
            }
        }   
        else
            System.out.println("Not a valid month. Enter a number between 1 and 12.");
        
    }
    
    public int search(String nameToSearch){
        int matchFound = 0;
        for(Membership member : clubMembers){                
                if(nameToSearch.equals(member.getName())){
                    matchFound++;
                }
            }
        System.out.println(matchFound + " match(es) found for " + nameToSearch + ".");
        return matchFound;
    }
    
    public void remove(String nameToSearch){
        Iterator<Membership> it = clubMembers.iterator();
        int match = 0;
        while(it.hasNext()){
            Membership  member = it.next();
            if(member.getName().toLowerCase().equals(nameToSearch.toLowerCase())){
                it.remove();
                match++;
            }
        }
        System.out.println(match + " match(es) found for " + nameToSearch + " and removed from List.");
    }
}
