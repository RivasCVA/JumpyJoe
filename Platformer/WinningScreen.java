import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinningScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinningScreen extends World
{   
    PlayAgain playAgainButton = new PlayAgain();
    BackToMenu backToMenuButton = new BackToMenu();
    GreenfootSound winSong = new GreenfootSound("winSong.mp3");
    
    /**
     * Constructor for objects of class WinningScreen.
     * 
     */
    public WinningScreen(int width, int height, int totalTimeTaken, int lifesLeft)
    {   
        super(width, height, 1);
        GreenfootImage image = new GreenfootImage("WinBackground.jpg");
        image.scale(getWidth(), getHeight());
        setBackground(image);
        playAgainButton.getImage().scale(250, 100);
        addObject(playAgainButton, getWidth()/2, getHeight()/2);
        backToMenuButton.getImage().scale(200,100);
        addObject(backToMenuButton, getWidth()/2, getHeight()/2 + 200);
        prepare();
        
        ScoreBoard scoreBoard = new ScoreBoard(totalTimeTaken);
        addObject(scoreBoard, getWidth()/2, (scoreBoard.getImage().getHeight()/2) + 10);
        winSong.playLoop();
    }
    
    public WinningScreen()
    {
        super(1024, 768, 1);
        int totalTimeTaken = 84;
        int lifesLeft = 2;
        GreenfootImage image = new GreenfootImage("WinBackground.jpg");
        image.scale(getWidth(), getHeight());
        setBackground(image);
        playAgainButton.getImage().scale(250, 100);
        addObject(playAgainButton, getWidth()/2, getHeight()/2);
        backToMenuButton.getImage().scale(200, 200);
        addObject(backToMenuButton, getWidth()/2, getHeight()/2 + 200);
        prepare();
        
        ScoreBoard scoreBoard = new ScoreBoard(totalTimeTaken);
        addObject(scoreBoard, getWidth()/2, (scoreBoard.getImage().getHeight()/2) + 10);
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
    
    public void displayTotalTimeTaken()
    {
        
    }
    
    public void displayLifesLeft()
    {
        
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
