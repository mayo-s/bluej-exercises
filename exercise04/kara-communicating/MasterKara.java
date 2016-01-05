import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MasterKara here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MasterKara extends Kara
{
    /**
     * Act - do whatever the MasterKara wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Kara slaveKara;
    public void setSlaveKara(Kara slaveKara){
        this.slaveKara = slaveKara;
    }

    public void act() 
    {
        copyRow();
        move();
        slaveKara.move();
        if (treeFront()) 
            Greenfoot.stop();

    }    
    public void copyRow(){
       
    }
}
