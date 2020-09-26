import greenfoot.*;
import java.awt.Color;
import java.awt.Font;

/**
 * The ScoreBoard is used to display results on the screen. It can display some
 * text and a score.
 * 
 * @author M Kölling
 * @version 1.0
 */
public class ScoreBoard extends Actor
{
    public static final float FONT_SIZE = 36.0f;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    
    /**
     * Create a score board with dummy result for testing.
     */
    public ScoreBoard()
    {
        this(100);
    }

    /**
     * Create a score board for the final result.
     */
    public ScoreBoard(int score)
    {
        makeImage("YOU WON!!!", "Time Taken: ", score);
    }

    /**
     * Make the score board image.
     */
    private void makeImage(String title, String prefix, int score)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        
        Color color = new Color(255, 0, 0, 255);
        
        image.setColor(color);
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(0, 0, 255, 200));
        image.fillRect(10, 10, WIDTH-20, HEIGHT-20);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        
        Color fontColor = new Color(0, 255, 0, 255);
        image.setColor(fontColor);
        image.drawString(title, (WIDTH/2) - 110, 100);
        fontColor = new Color(255, 200, 150, 255);
        image.setColor(fontColor);
        image.drawString(prefix + score + "s", (WIDTH/2) - 120, 200);
        setImage(image);
    }
}
