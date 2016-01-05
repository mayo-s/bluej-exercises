import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Parser 
{
    private CommandWords commandWords;  // holds all valid command words
    private Scanner reader;         // source of command input

    /**
     * Create a parser to read from the terminal window.
     */
    public Parser() 
    {
        commandWords = new CommandWords();
        reader = new Scanner(System.in);
    }

    private String readLine(){
        System.out.print("> ");     // print prompt
        return  reader.nextLine();
    }

    /**
     * @return The next command from the user.
     */
    public Command getCommand() 
    {
        String inputLine = readLine(); 
        return getCommand(inputLine);
    }
    public Command getCommand(String inputLine){
        
        String word1 = null;
        String word2 = null;

        // Find up to two words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();      // get first word
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();      // get second word
                // note: we just ignore the rest of the input line.
            }
        }

        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command).
        if(commandWords.isCommand(word1)) {
            return new Command(word1, word2);
        }
        else {
            return new Command(null, word2); 
        }
    }
}
