import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Actor
{
    int currentCoinImage = Greenfoot.getRandomNumber(6) + 1;
    int animationDelay = 6;
    int currentAnimationDelay = 0;
    
    /**
     * Act - do whatever the Coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Coin()
    {
        GreenfootImage myImage = new GreenfootImage("coin1.png");
        myImage.scale(30, 50);
        setImage(myImage);
    }
    
    public void act() 
    {
        Animate();
    }
    
    public void Animate()
    {
        //Continusly loops through all of the player walking right images
        if (currentCoinImage <= 6 && currentAnimationDelay <= 0) {
            GreenfootImage myImage = new GreenfootImage("coin" + currentCoinImage + ".png");
            myImage.scale(30, 50);
            setImage(myImage);
            currentAnimationDelay = animationDelay;
            currentCoinImage++;
        } 
        if (currentCoinImage > 6) {
            currentCoinImage = 1;
        }
        if (currentAnimationDelay > 0) {
            currentAnimationDelay--;
        }
    }
}
