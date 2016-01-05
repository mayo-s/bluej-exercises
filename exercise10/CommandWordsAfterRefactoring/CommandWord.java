/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public enum CommandWord

{ GO("go"), QUIT("quit"), HELP("huelfe"), USE("use"), UNKNOWN("?");
    
    private String word;
  
    /**
     * Constructor - initialise the command words.
     */

    private CommandWord(String word)
    {
        this.word = word;
    }

    public static String getValidCommandWords(){
        String result = "";
        for (CommandWord cw : CommandWord.values()){
            result += cw.toString();
            result += " ";
        }
        return result.trim();// "go quit help ";
    }
    
    public static CommandWord getForString(String aString){
        for (CommandWord cw : CommandWord.values()){
            if(cw.toString().equals(aString))
                return cw;
        }
        return UNKNOWN;
    }
    @Override
    public String toString(){
        return word;
    }

}
