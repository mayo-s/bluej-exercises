import java.util.*;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kolling and David J. Barnes and Mario Schuetz
 * @version 2016-01-24
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private ArrayList<Item> items;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        items = new ArrayList<Item>();
    }

    /**
     * Define the exits of this room. 
     */
    public void setExits(String direction, Room neighbor){
        exits.put(direction, neighbor);
    }

    /**
     * setup Items in the room
     */
    public void setItem(Item item){
        items.add(item);
    }
    
    /**
     * @return a String of all items in the room.
     */
    public String getItems(){
        String roomItems = "";
        for(Item item : items){
             roomItems += item.getName() + " ";
        }
        return roomItems;
    }
    
    /**
     * @return single item
     */
    public Item getItem(String itemToTake){
        for(Item item : items){
            if(item.getName().equals(itemToTake)){
                return item;
            }
        }
    }
    
    /**
     * remove items from room when picked up
     */
    public void removeItem(String itemName){
        items.remove(itemName);
    }
    
    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * gives long desscription of what to see in the room
     * @return all exits and items of/in the room
     */
    public String getLongDescription(){
        return "You are " + description + ".\n" + "You can see the following items laying around " + getItems() + "\n" + "Your possible exits are " + getExits()  + "\n";
    }
        
    /**
     * @return All exits of the room.
     */
    public String getExits(){
        String nearexits = "";
        for(Iterator it = exits.keySet().iterator(); it.hasNext();){
            nearexits += (String) it.next() + " ";
        }
        return nearexits;
    }
    
    /**
     * @return a description of an item
     */
    public String getItemDescription(String itemToCheck){
        
        for(
        if(items.contains(itemToCheck)){
            String description = items.get(itemToCheck).getDescription();
            return description;
        }
        else
            return "This object does not exist in this room.";
    }
        
    /**
     * @return the weight of an item
     */
    public int getItemWeight(String itemToCheck){
        if(items.containsKey(itemToCheck)){
            int weight = items.get(itemToCheck).getWeight();        
            return weight;
        }
        else
            return 0;
    }
    
    /**
     * check if exit is available
     */    
    public Room findRoom(String direction){
        return exits.get(direction);
    }
}
