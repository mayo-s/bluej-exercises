import java.util.*;
/**
 * determine player skills
 * 
 * @author (Mario Schuetz & Maria Katharina Wunder) 
 * @version (2016-01-24)
 */
public class Player
{
    private int maxWeight;
    public ArrayList<Item> itemBag;

    /**
     * Constructor for objects of class Player
     */
    public Player(int maxWeight)
    {
        this.maxWeight = maxWeight;
        itemBag = new ArrayList<Item>();
    }

    public void addToBag(Item itemToAdd)
    {
        itemBag.add(itemToAdd);
    }

    public boolean canBePickedUp(Item itemToTake)
    {
        int totalWeight = 0;

        for (Item item : itemBag) {  
            totalWeight += item.getWeight();
        }

        if (totalWeight + itemToTake.getWeight() >= maxWeight)
        {
            return false;
        }

        return true;
    }

    public String getBag()
    {
        String itemsInBag = "";
        for (Item item : itemBag) {  
            itemsInBag += item.getNameString() + " ";
        }
        return itemsInBag;
    }

    public Item getItemFromBag(Command command)
    {
        for (Item item : itemBag) {  
            if(item.getNameString().equals(command.getSecondWord())){
                return item;
            }
        }
        return null;
    }

    public void removeFromBag(Item itemToRemove)
    {
        itemBag.remove(itemToRemove);
    }

    public String moveAllItemsTo(Room room)
    {
        if(!itemBag.isEmpty()){
            for (Item item : itemBag) { 
                room.setItem(item);
            }
            itemBag.clear();
            return "You have dropped all your items in the current room\n";
        }
        return "You have nothing to drop.\n";
    }

    public void moveItemTo(Room room, Item itemToCheck)
    {
        for (Item item : itemBag) { 
            if (item.equals(itemToCheck)){
                room.setItem(item);
            }
        }
    }
}
    
//     private HashMap<String, Item> storage;
// 
//     /**
//      * Constructor for objects of class Player
//      */
//     public Player()
//     {
//         storage = new HashMap<String, Item>();
//     }
//     
//     public void addToStorage(String itemName, Item item){
//         storage.put(itemName, item);
//     }
//     
//     public void removeFromStorage(String itemToDrop){
//         storage.remove(itemToDrop);
//     }
//     
//     public void clearStorage(){
//         storage.clear();
//     }
//     
//     /**
//      * @return single item
//      */
//     public Item getItem(String itemToDrop){
//         return storage.get(itemToDrop);
//     }
//     
//     /**
//      * @return all items in backpack
//      */
//     public String getItems(){
//         String backpackItems = "";
//         for(Iterator it = storage.keySet().iterator(); it.hasNext();){
//              backpackItems += (String) it.next() + " ";
//         }
//         return backpackItems;
//     }
// //     public int maxWeight(Item itemToTake){
// //         int sumWeight = 0;
// //         
// //         for(Iterator it = storage.keySet().iterator(); it.hasNext();){
// //             sumWeight += storage.it.next().getWeight();
// //         }
// //         
// //         sumWeight += itemToTake.getWeight();
// //         
// //         return sumWeight;
// //     }
// }
