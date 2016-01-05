import greenfoot.*;

/**
 * Mushrooms can be pushed by Kara.
 *
 * @author Marco Jakob (majakob@gmx.ch)
 * @version 1.3 (2012-07-04)
 */
public class Mushroom extends Actor
{
    /**
     * This method is called when a new Mushroom is added to the world. It checks 
     * whether it is ok to put it there.
     */
    protected void addedToWorld(World world)
    {
        if (getOneObjectAtOffset(0, 0, Kara.class) != null 
            || getOneObjectAtOffset(0, 0, Mushroom.class) != null
            || getOneObjectAtOffset(0, 0, Tree.class) != null) 
        {
            // There is something in the way, remove it again
            world.removeObject(this);
        }
    }
    
    /**
     * Overriding setLocation(...) of the Actor class to prevent dragging the Mushroom 
     * on a Kara, Tree, or another Mushroom.
     */
    public void setLocation(int x, int y) {
        if (getWorld().getObjectsAt(x, y, Kara.class).isEmpty()
            && getWorld().getObjectsAt(x, y, Mushroom.class).isEmpty()
            && getWorld().getObjectsAt(x, y, Tree.class).isEmpty())
        {
            // Nothing is in the way, we can set the location
            super.setLocation(x, y);
        }
    }
}
