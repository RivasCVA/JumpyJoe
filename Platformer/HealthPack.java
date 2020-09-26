import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthPack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthPack extends Actor
{
    int healthToGive = 20;
    
    public HealthPack()
    {
        GreenfootImage myImage = new GreenfootImage("HealthPack.png");
        myImage.scale(40, 40);
        setImage(myImage);
    }
    
    /**
     * Act - do whatever the HealthPack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 
    
    public int GetHealth()
    {
        return healthToGive;
    }
}
