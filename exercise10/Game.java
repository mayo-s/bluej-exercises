/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kolling and David J. Barnes and Mario Schuetz
 * @version 2016-01-24
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Room lastRoom;
    private Room item;
    private Player you;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     * also adding items to the rooms.
     */
    private void createRooms()
    {
        Room outside, theatre, pub, lab, office;        

        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office.\nThere is a golden magic coffee machine.");
        
        // initialise room exits
        outside.setExits("east", theatre);
        outside.setExits("west", pub);
        outside.setExits("south", lab);
        theatre.setExits("west", outside);
        pub.setExits("east", outside);
        lab.setExits("north", outside);
        lab.setExits("east", office);
        office.setExits("west", lab);
        
        createItems(outside, theatre, pub, lab, office);
              
        lastRoom = null; //remember last room to go back
        currentRoom = outside;  // start game outside
    }
    
    private void createItems(Room outside, Room theatre, Room pub, Room lab, Room office){
       Item beer, flute, drum, drugs, bread, apple, wine, coffee, stone, rock, orange;
       
       // create the items
        apple = new Item("apple", "a delicious red apple",1);
        beer = new Item("beer", "a refreshing beer",1);
        flute = new Item("flute", "a handcrafted flute",2);
        drum = new Item("drum", "a funny looking drum",2);
        drugs = new Item("drugs", "some bad stuff (drugs)",0);
        bread = new Item("bread", "a delicious fresh bread",2);
        wine = new Item("wine", "a red wine",2);
        coffee = new Item("coffee", "a dark reviving coffee",1);
        stone = new Item("stone", "a small stone",3);
        rock = new Item("rock", "a heavy rock",5);
        orange = new Item("orange", "a juicy, orange orange",1);
       
       //initialise room items
        outside.setItem(apple);
        outside.setItem(orange);
        outside.setItem(stone);
        outside.setItem(rock);
        pub.setItem(bread);
        pub.setItem(beer);
        pub.setItem(wine);
        theatre.setItem(flute);
        theatre.setItem(drum);
        lab.setItem(drugs);
        office.setItem(coffee);
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            String output = processCommand(command);
            finished = (null == output);
            if (!finished)
            { 
                System.out.println(output);
            }
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    public String processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            return "I don't know what you mean...";
        }

        String commandWord = command.getCommandWord();
        String result = null;
        if (commandWord.equals("help"))
            result = printHelp();
        else if (commandWord.equals("go"))
            result = goRoom(command);
        else if (commandWord.equals("quit"))
            result = quit(command);
        else if (commandWord.equals("look"))
            result = look(command);
        else if (commandWord.equals("eat"))
            result = eat(command);
        else if (commandWord.equals("scream"))
            result = scream(command);
        else if(commandWord.equals("back"))
            result = back(command);
        else if(commandWord.equals("check"))
            result = checkItem(command);
        else if(commandWord.equals("take"))
            result = takeItem(command);
        else if(commandWord.equals("drop"))
            result = dropItem(command);

        return result;

    }

    // implementations of user commands:
    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private String printHelp() 
    {   String result = "";
        result += "You are lost. You are alone. You wander\n";
        result += "around at the university.\n";
        result += "\n";
        result += "Your command words are:\n";
        result += parser.showCommands() + "\n";
        return result;
    }

    /** 
     * Try to go to one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private String goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            return "Go where?";
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.findRoom(direction);
        String result = "";
        if (nextRoom == null) {
            result += "There is no door!";
        }
        else {
            lastRoom = currentRoom;
            currentRoom = nextRoom;
            result += currentRoom.getLongDescription();
        }
        //result += "\n";

        return result;
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return null, if this command quits the game, something else to output otherwise.
     */
    private String quit(Command command) 
    {
        if(command.hasSecondWord()) {
            return "Quit what?";
        }
        else {
            return null;  // signal that we want to quit
        }
    }
    
    private String look(Command command){
        if(command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            return "Try again!";
        }
        else
            return currentRoom.getLongDescription();
    }
   
    private String eat(Command command){
        if(command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            return "You better don't.";
        }
        else
            return "You have eaten now and are not hungry anymore.\n";
    }
    
    private String checkItem(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            return "Check what?\n";
        }

        String itemToCheck = command.getSecondWord();
        String result = "";
        if (itemToCheck == null) {
            result += "Which item do you want to check?";
        }
        else if(itemToCheck == "backpack")
            return "Your backpack currently holds " + you.getBag();
        else {
            result += currentRoom.getItemDescription(itemToCheck);
            result += " It weights " + currentRoom.getItemWeight(itemToCheck);
        }
        result += "\n";

        return result;
    }
    
    private String scream(Command command){
        if(command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            return "Try again!";
        }
        else
            return "You screamed as loud as possible but got ignored by everyone.\n";
    }
    
    private String back(Command command){
        if(command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            return "What? There is only one way to go back.\n";
        }
        
        if(lastRoom == null)
            return "I don't remember where i came from.\n";
        else{
            currentRoom = lastRoom;
            lastRoom = null;
            return exitsInfo();
        }
            
    }
    
    private String takeItem(Command command){
        String itemToStore = command.getSecondWord();
        String result = "";
        Item input = currentRoom.getItem(itemToStore);

        if(!command.hasSecondWord()) {
            return "Take what?\n";
        }

        if(input == null) {
            return "You cannot take " + itemToStore + "!\n";
        }

        if (you.canBePickedUp(input))
        {
            you.addToBag(input);
            currentRoom.removeItem(itemToStore);
            return "You added the item "+ input.getName() + " to your backpack.\n";   
        }
        return "Your backpack is already full\n";   
    }    
    
    private String dropItem(Command command){
        String itemToDrop = command.getSecondWord();
        String result = "";
        if(!command.hasSecondWord()) {
            return "Drop what?";
        }
        else{
            result += "You removed ";
            result += currentRoom.getItemDescription(itemToDrop);
            result += " from your storage.\n";
            
            return result;
        }
    }
   
    public static void main(String[] args){
        Game game = new Game();
        game.play();
    }

    /**
     * @return print all possible exits in room
     */
    private String exitsInfo(){
        String exits = "";
        System.out.println("You are " + currentRoom.getDescription());
        System.out.print("Possible Exits: ");        
        exits += currentRoom.getExits();
        return exits;
    }
    
}
