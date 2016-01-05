import greenfoot.*;

/**
 * This class creates a world for Kara. It contains settings for height and 
 * width of the world and initializes the Actors.
 * 
 * @author Marco Jakob (majakob@gmx.ch)
 * @version 1.3 (2012-07-04)
 */
public class KaraWorld extends World 
{   
    private static final int WORLD_WIDTH = 22;  // Number of horizontal cells
    private static final int WORLD_HEIGHT = 20;  // Number of vertical cells

    private static final int CELL_SIZE = 28; // Size of one cell

    /**
     * Creates a world for Kara.
     */
    public KaraWorld() 
    {
        // Create the new world
        super(WORLD_WIDTH, WORLD_HEIGHT, CELL_SIZE);

        setPaintOrder(Kara.class, Tree.class, Mushroom.class, Leaf.class);
        Greenfoot.setSpeed(20);

        // Initialize actors
        prepare();
    }

    /**
     * Prepare the world, i.e. create all initial actors.
     * 
     * Hint:
     * First create and position all Actors with the mouse in the world.
     * Then right-click on the world and choose 'Save the World'. This will
     * automatically generate the content of this method.
     */
    private void prepare() 
    {


        MasterKara masterkara = new MasterKara();
        addObject(masterkara, 10, 19);
        
        SlaveKara slavekara = new SlaveKara();
        addObject(slavekara, 11, 19);
        
        masterkara.setSlaveKara(slavekara);
        
        slavekara.turnLeft();
        masterkara.turnLeft();
        
        Leaf leaf = new Leaf();
        addObject(leaf, 9, 18);
        Leaf leaf2 = new Leaf();
        addObject(leaf2, 8, 18);
        Leaf leaf3 = new Leaf();
        addObject(leaf3, 7, 18);
        Leaf leaf4 = new Leaf();
        addObject(leaf4, 6, 18);
        Leaf leaf5 = new Leaf();
        addObject(leaf5, 5, 18);
        Leaf leaf6 = new Leaf();
        addObject(leaf6, 4, 18);
        Leaf leaf7 = new Leaf();
        addObject(leaf7, 3, 18);
        Leaf leaf8 = new Leaf();
        addObject(leaf8, 2, 18);
        Leaf leaf9 = new Leaf();
        addObject(leaf9, 4, 16);
        Leaf leaf10 = new Leaf();
        addObject(leaf10, 5, 16);
        Leaf leaf11 = new Leaf();
        addObject(leaf11, 3, 16);
        Leaf leaf12 = new Leaf();
        addObject(leaf12, 6, 16);
        Leaf leaf13 = new Leaf();
        addObject(leaf13, 7, 16);
        Leaf leaf15 = new Leaf();
        addObject(leaf15, 9, 16);
        Leaf leaf16 = new Leaf();
        addObject(leaf16, 8, 16);
        Leaf leaf17 = new Leaf();
        addObject(leaf17, 9, 14);
        Leaf leaf18 = new Leaf();
        addObject(leaf18, 8, 14);
        Leaf leaf19 = new Leaf();
        addObject(leaf19, 7, 14);
        Leaf leaf20 = new Leaf();
        addObject(leaf20, 6, 14);
        Leaf leaf21 = new Leaf();
        addObject(leaf21, 5, 14);
        Leaf leaf22 = new Leaf();
        addObject(leaf22, 4, 14);
        Leaf leaf23 = new Leaf();
        addObject(leaf23, 5, 12);
        Leaf leaf24 = new Leaf();
        addObject(leaf24, 6, 12);
        Leaf leaf25 = new Leaf();
        addObject(leaf25, 7, 12);
        Leaf leaf26 = new Leaf();
        addObject(leaf26, 8, 12);
        Leaf leaf27 = new Leaf();
        addObject(leaf27, 9, 12);
        Leaf leaf28 = new Leaf();
        addObject(leaf28, 9, 10);
        Leaf leaf29 = new Leaf();
        addObject(leaf29, 8, 10);
        Leaf leaf30 = new Leaf();
        addObject(leaf30, 7, 10);
        Leaf leaf31 = new Leaf();
        addObject(leaf31, 6, 10);
        Leaf leaf32 = new Leaf();
        addObject(leaf32, 5, 10);
        removeObject(leaf32);
        Leaf leaf33 = new Leaf();
        addObject(leaf33, 7, 8);
        Leaf leaf34 = new Leaf();
        addObject(leaf34, 8, 8);
        Leaf leaf35 = new Leaf();
        addObject(leaf35, 9, 8);
        Leaf leaf36 = new Leaf();
        addObject(leaf36, 8, 6);
        Leaf leaf37 = new Leaf();
        addObject(leaf37, 9, 6);
        Leaf leaf38 = new Leaf();
        addObject(leaf38, 9, 4);
        Leaf leaf39 = new Leaf();
        addObject(leaf39, 4, 2);
        Leaf leaf40 = new Leaf();
        addObject(leaf40, 4, 3);
        Leaf leaf41 = new Leaf();
        addObject(leaf41, 4, 4);
        Leaf leaf42 = new Leaf();
        addObject(leaf42, 3, 3);
        Leaf leaf43 = new Leaf();
        addObject(leaf43, 5, 3);
        Tree tree = new Tree();
        addObject(tree, 0, 18);
        Tree tree2 = new Tree();
        addObject(tree2, 0, 19);
        Tree tree3 = new Tree();
        addObject(tree3, 0, 17);
        Tree tree4 = new Tree();
        addObject(tree4, 0, 16);
        Tree tree5 = new Tree();
        addObject(tree5, 0, 15);
        Tree tree6 = new Tree();
        addObject(tree6, 0, 14);
        Tree tree7 = new Tree();
        addObject(tree7, 0, 13);
        Tree tree8 = new Tree();
        addObject(tree8, 0, 12);
        Tree tree9 = new Tree();
        addObject(tree9, 0, 11);
        Tree tree10 = new Tree();
        addObject(tree10, 0, 10);
        Tree tree11 = new Tree();
        addObject(tree11, 0, 9);
        Tree tree12 = new Tree();
        addObject(tree12, 0, 8);
        Tree tree13 = new Tree();
        addObject(tree13, 0, 7);
        Tree tree14 = new Tree();
        addObject(tree14, 0, 6);
        Tree tree15 = new Tree();
        addObject(tree15, 0, 5);
        Tree tree16 = new Tree();
        addObject(tree16, 0, 4);
        Tree tree17 = new Tree();
        addObject(tree17, 0, 3);
        Tree tree18 = new Tree();
        addObject(tree18, 0, 2);
        Tree tree19 = new Tree();
        addObject(tree19, 0, 1);
        Tree tree20 = new Tree();
        addObject(tree20, 0, 0);
        Tree tree21 = new Tree();
        addObject(tree21, 1, 0);
        Tree tree22 = new Tree();
        addObject(tree22, 2, 0);
        Tree tree23 = new Tree();
        addObject(tree23, 3, 0);
        Tree tree24 = new Tree();
        addObject(tree24, 4, 0);
        Tree tree25 = new Tree();
        addObject(tree25, 5, 0);
        Tree tree26 = new Tree();
        addObject(tree26, 6, 0);
        Tree tree27 = new Tree();
        addObject(tree27, 8, 0);
        Tree tree28 = new Tree();
        addObject(tree28, 7, 0);
        Tree tree29 = new Tree();
        addObject(tree29, 9, 0);
        Tree tree30 = new Tree();
        addObject(tree30, 10, 0);
    }
}
