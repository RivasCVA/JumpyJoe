import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LosingScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LosingScreen extends World
{
    PlayAgain playAgainButton = new PlayAgain();
    BackToMenu backToMenuButton = new BackToMenu();
    GameOverLogo gameOverLogo = new GameOverLogo();
    GreenfootSound losingSong = new GreenfootSound("losingSong.mp3");
    
    /**
     * Constructor for objects of class LosingScreen.
     * 
     */
    public LosingScreen(int width, int height)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(width, height, 1);
        GreenfootImage image = new GreenfootImage("LoseBackground.jpg");
        image.scale(width, height);
        setBackground(image);
        gameOverLogo.getImage().scale(width, height);
        addObject(gameOverLogo, width/2, height/2);
        playAgainButton.getImage().scale(270, 100);
        addObject(playAgainButton, getWidth()/2, getHeight()/2);
        backToMenuButton.getImage().scale(200, 100);
        addObject(backToMenuButton, getWidth()/2, getHeight()/2 + 200);
        losingSong.playLoop();
    }
    
    public LosingScreen()
    {
        super(1024, 768, 1);
        GreenfootImage image = new GreenfootImage("LoseBackground.jpg");
        image.scale(getWidth(), getHeight());
        setBackground(image);
        playAgainButton.getImage().scale(270, 100);
        addObject(playAgainButton, getWidth()/2, getHeight()/2);
        backToMenuButton.getImage().scale(200, 200);
        addObject(backToMenuButton, getWidth()/2, getHeight()/2 + 200);
    }
    
    public void act()
    {
        //DisplayLosingText();
        if (Greenfoot.mouseClicked(playAgainButton)) {
            Greenfoot.setWorld(new MainGame(getWidth(), getHeight()));
        }
        if (Greenfoot.mouseClicked(backToMenuButton)) {
            Greenfoot.setWorld(new Menu());
        }
    }
}
