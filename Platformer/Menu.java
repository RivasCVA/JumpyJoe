import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{

    Start startButton = new Start();
    Exit exitButton = new Exit();
    Logo logo = new Logo();
    
    //Screen resolution
    int width = getWidth();
    int height = getHeight();
    
    //music variable
    GreenfootSound music = new GreenfootSound("MenuSound.mp3");
    
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {
         // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 768, 1); 
        
        
        //startButton.getImage().scale(300, 100);
        exitButton.getImage().scale(200, 200);
        
        //Greenfoot.setWorld(new MainGame(width, height));
        
        prepare();
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(exitButton)) {
            Greenfoot.stop();
        }
        if (Greenfoot.mousePressed(startButton)) {
            startButton.ChangeToPressedImage();
        }
        
        
        //loops the music
        if (music.isPlaying() == false) {
            music.playLoop();
        }
        
        if (Greenfoot.mouseClicked(startButton)) {
            music.stop();
            Greenfoot.setWorld(new MainGame(width, height));
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(startButton, width/2, height/2);
        addObject(exitButton, width/2, (height/2) + 200);
        addObject(logo, (width/2) + 30, logo.getImage().getHeight()/2);
    }
}
