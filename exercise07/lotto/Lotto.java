import java.util.Random;
import java.util.HashSet;
import java.util.Iterator;
/**
 * Lotto 6 out of 49.
 * 
 * @author (Mario Schuetz) 
 * @version (2015-12-08)
 */
public class Lotto
{
    Random pickNum = new Random();
    int[] lottoStatistics;
    
     /**
     * Constructor for objects of class Lotto
     */
    public Lotto(){
        
    }

    /**
     * picking 6 numbers between 1 and 49, no duplicates
     */
    public void theSixNumbers(int runs, boolean print){
        
        lottoStatistics = new int[50];
        
        for(int i = 1; i <= runs; i++){
            HashSet<Integer> lottoNums = new HashSet<Integer>();
        
            while(lottoNums.size() < 6){
                lottoNums.add(pickOneNum());        
            }
        
            Iterator<Integer> it = lottoNums.iterator();
        
            while(it.hasNext()){
                int k = it.next();
                lottoStatistics[k] += 1;
                if(print)
                    System.out.print(k + " ");
            } 
            if(print)
                System.out.println();
        }
        
    }
    
    private int pickOneNum(){
       int oneNum = pickNum.nextInt(49)+1;
       return oneNum;
    }
    
    public void outputStats(){
            for(int i = 1; i < lottoStatistics.length;){
                for(int k = 0; k < 7 && i<lottoStatistics.length + 1; k++){
                    if(i<10)
                        System.out.print("0" + i + " " + lottoStatistics[i] + "-times. ");
                    else
                        System.out.print(i + " " + lottoStatistics[i] + "-times. ");
                    i += 1;
                }
                System.out.println("");
           }
    }
}
