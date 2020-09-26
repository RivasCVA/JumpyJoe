import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    char direction = 'R';
    int speed = 10;
    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Bullet()
    {
        getImage().scale(20, 20);
        
    }
    
    public void act() 
    {
        if (direction == 'R') {
            move(speed);
        }
        if (direction == 'L') {
            move(-speed);
        }
        
        if (isAtEdge() == true) {
            MainGame lvl = (MainGame)getWorld();
            lvl.removeObject(this);
        }
    }
    
    public void setDirection(char _direction_)
    {
        direction = _direction_;
    }
}
