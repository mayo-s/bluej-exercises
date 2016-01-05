import java.util.Random;
import java.util.HashMap;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @original-author     Michael Kölling and David J. Barnes
 * @last edit by        Mario Schuetz
 * @version    0.2 (2015-12-11)
 */
public class Responder
{
    Random answerNum;
    private String[] answers;
    private HashMap<String, Integer> keywords;
    int allAnswers = 22;
    
    
    /**
     * Construct a Responder
     * generating the answer-Array and keyword-HashMap
     */
    public Responder(){
        answers();
        keywordlist();
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     * @param   ai  answer-index
     * @param   lastAnswer  stores last answer-index, so it does not show up twice in row
     */
    public String generateResponse(String input){
        answerNum = new Random();
        int ai = 0;
        int lastAnswer = 0;
        boolean match = false;
        
        String[] splitInput = input.split("[^a-zA-Z]");         
        
        for(int i = 0; i < splitInput.length && !match; i++){
            if(keywords.containsKey(splitInput[i])){
                match = true;
                ai = keywords.get(splitInput[i]);
            }            
        }
        
        if(!match){        
            while(ai == lastAnswer){
                ai = answerNum.nextInt(10);
            }
        }
                
        lastAnswer = ai;
        return answers[ai];
    }
    
    /**
     * Setting up an Array with potential answers
     */
    
    private void answers(){
                
        answers = new String[allAnswers];
        
            answers[0] = "Did you ask google?";
            answers[1] = "Did you turn it off and on?";
            answers[2] = "Keep talking, i'll get myself a coffee.";
            answers[3] = "ohhh my gosh...";
            answers[4] = "42";
            answers[5] = "i have no clue.";
            answers[6] = "have a break, have a kitkat"; 
            answers[7] = "wenn's mal wieder länger dauert...";
            answers[8] = "loading 31%";
            answers[9] = "talk to the hand.";
            answers[10] = "java, java, java";
            answers[11] = "Computer, Rechner, Ordenador";
            answers[12] = "apple, apple, apple, ...";
            answers[13] = "Microsoft, Winzigweich, pico fofo";
            answers[14] = "the answer to life, the universe and everything is 42";
            answers[15] = "Mac, mac, mack, muck, mick...";
            answers[16] = "Aaahhh... we're all gonna die...";
            answers[17] = "this might take a li'l while.";
            answers[18] = "printing is not good for the enviroment.";
            answers[19] = "which distribution?";
            answers[20] = "did you try rooting it?";
               
    }
    
    /**
     * setting up a HashMap with potential keywords
     */    
    private void keywordlist(){
        keywords = new HashMap<String, Integer>();
        
        keywords.put("java", 10);
        keywords.put("computer", 11);
        keywords.put("ios", 12);
        keywords.put("windows", 13);
        keywords.put("life", 14);
        keywords.put("mac", 15);
        keywords.put("crashed", 16);
        keywords.put("loading", 17);
        keywords.put("print", 18);
        keywords.put("linux", 19);
        keywords.put("android", 20);
        keywords.put("problem", 2);
    }
}
