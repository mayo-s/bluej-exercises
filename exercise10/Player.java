import java.util.*;
/**
 * determine player skills
 * 
 * @author (Mario Schuetz) 
 * @version (2016-01-24)
 */
public class Player
{
    private HashMap<String, Item> storage;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        storage = new HashMap<String, Item>();
    }
    
    public void addToStorage(String itemName, Item item){
        storage.put(itemName, item);
    }
    
    public void removeFromStorage(String itemToDrop){
        storage.remove(itemToDrop);
    }
    
    public void clearStorage(){
        storage.clear();
    }
    
//     public int maxWeight(Item itemToTake){
//         int sumWeight = 0;
//         
//         for(Iterator it = storage.keySet().iterator(); it.hasNext();){
//             sumWeight += storage.it.next().getWeight();
//         }
//         
//         sumWeight += itemToTake.getWeight();
//         
//         return sumWeight;
//     }
}
