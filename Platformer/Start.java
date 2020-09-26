import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends Actor
{
    
    public Start()
    {
        GreenfootImage myImage = new GreenfootImage("PlayButton1.png");
        myImage.scale(300, 300);
        setImage(myImage);
    }
    
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }
    
    public void ChangeToPressedImage()
    {
        GreenfootImage myImage = new GreenfootImage("PlayButton2.png");
        myImage.scale(275, 275);
        setImage(myImage);
    }
    
    public void ChangeToUnpressedImage()
    {
        GreenfootImage myImage = new GreenfootImage("PlayButton1.png");
        myImage.scale(300, 300);
        setImage(myImage);
    }
}
