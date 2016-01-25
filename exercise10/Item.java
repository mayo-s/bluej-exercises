
/**
 * Write a description of class Item here.
 * 
 * @author (Mario Schuetz) 
 * @version (2016-01-12)
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String name;
    private String description;
    private int weight;

    /**
     * Constructor for objects of class Item
     */
    public Item(String name, String description, int weight){
        this.name = name;
        this.description = description;
        this.weight = weight;
    }
    
    public String getDescription(){
        return description;
    }

    public int getWeight(){
        return weight;
    }
    
    public String getName(){
        return name;
    }
}
