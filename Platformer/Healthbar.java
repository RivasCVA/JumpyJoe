import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Healthbar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Healthbar extends Actor
{
    public int startWidth = 40;
    public int startHeight = 5;
    
    public Healthbar()
    {
        getImage().scale(startWidth, startHeight);
    }
    
    /**
     * Act - do whatever the Healthbar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //if health is more than 75%
        if (getImage().getWidth() > startWidth - (startWidth / 4)) {
            getImage().setColor(new Color(0, 255, 0, 255));
            getImage().fill();
        }
        //if health is between 25% - 75&
        if (getImage().getWidth() < startWidth - (startWidth / 4) && getImage().getWidth() > startWidth - (3*(startWidth / 4))) {
            getImage().setColor(new Color(255, 255, 0, 255));
            getImage().fill();
        }
        //if health is less than 25%
        if (getImage().getWidth() < startWidth - ((3*(startWidth / 4)) - 5)) {
            getImage().setColor(new Color(255, 0, 0, 255));
            getImage().fill();
        }
    }
    
    public void Reset()
    {
        getImage().scale(startWidth, startHeight);
    }
    
    public void reduceSize(int amount)
    {
        //reduces the size of the healthbar proportionally
        if (getImage().getWidth() - amount > 0) {
            getImage().scale(getImage().getWidth() - amount, startHeight);
        }
    }
    
    public void setPosition(int x, int y)
    {
        setLocation(x, y);
    }
}
