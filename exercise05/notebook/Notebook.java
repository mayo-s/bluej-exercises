import java.util.ArrayList;
import java.util.Iterator;

/**
 * A class to maintain an arbitrarily long list of notes.
 * Notes are numbered for external reference by a human user.
 * In this version, note numbers start at 0.
 * 
 * @author David J. Barnes and Michael Kolling.
 * @version 2008.03.30
 */
public class Notebook
{
    // Storage for an arbitrary number of notes.
    private ArrayList<String> notes;
    
    /**
     * Perform any initialization that is required for the
     * notebook.
     */
    public Notebook()
    {
        notes = new ArrayList<String>();
    }

    public ArrayList<Integer> primeNumbers(){
        //long startTime = System.currentTimeMillis();
        ArrayList<Integer> primes = new ArrayList<Integer>();
                      
        for(int num=2; num<1000; num++){
           boolean isPrime=true;
           for(int div=2; div<num && isPrime; div++){
               if(num%div==0)
                    isPrime=false;
           }
           if(isPrime){
                primes.add(num);
                //System.out.println(num);
            }
        }
        //long endTime = System.currentTimeMillis();
        //System.out.println(endTime - startTime + "ms");
        System.out.println(primes.size());
        return primes;
        
    }
        
    /**
     * Store a new note into the notebook.
     * @param note The note to be stored.
     */
    public void storeNote(String note)
    {
        notes.add(note);
    }

    /**
     * @return The number of notes currently in the notebook.
     */
    public int numberOfNotes()
    {
        return notes.size();
    }

    /**
     * Show a note.
     * @param noteNumber The number of the note to be shown.
     */
    public void showNote(int noteNumber)
    {
        if(noteNumber < 0) {
            // This is not a valid note number, so do nothing.
        }
        else if(noteNumber < numberOfNotes()) {
            // This is a valid note number, so we can print it.
            System.out.println(notes.get(noteNumber));
        }
        else {
            // This is not a valid note number, so do nothing.
        }
    }
    
    public void showAllNotes(){
        
        for(int i = 0; i < notes.size(); i++){
            System.out.println(notes.indexOf(notes.get(i)) + " " + notes.get(i));
        }
    }
    
    public void removeNoteWithIterator(String removeNote){
        Iterator<String> it = notes.iterator();
        while(it.hasNext()){
            String note = it.next();
            if(note.contains(removeNote)){
                it.remove();
            }
        }
    }
    
    public void removeNoteWithWhile(String removeNote){
        int i = notes.size();
        boolean noneFound = true;
        while(i >= 0){
            String note = notes.get(i);
            if(note.contains(removeNote)){
                notes.remove(i);
                noneFound = false;
            }            
            i--;
        }
        
        if(noneFound)
            System.out.println("No notes have been removed.");
        
    }
   
}
