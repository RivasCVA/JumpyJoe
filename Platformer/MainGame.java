import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainGame extends World
{
    Joe joe = new Joe();
    Healthbar healthbar = new Healthbar();
    
    long currentTicks = 0;
    long startTicks = 0;
    
    //public char currentState = 'M';
    boolean runLevelStartup = false;
    long time = 0;
    long timeLimit = 80000;
    int joeLifes = 3;
    int currentLevel = 1;
    
    int totalTimeTaken = 0;
    
    //music variable
    GreenfootSound music = new GreenfootSound("MainGame.mp3");
    GreenfootSound newLevelSound = new GreenfootSound("nextLevel.mp3");
    
    /**
     * Constructor for objects of class MainGame.
     * 
     */
    public MainGame(int width, int height)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(width, height, 1);
        
        //Creates the player and its healthbar
        addObject(joe,30, getHeight() - 60);
        addObject(healthbar, ((joe.getX() - (joe.getImage().getWidth()/2)) + (healthbar.getImage().getWidth()/2)) + 5, joe.getY() - (joe.getImage().getHeight()/2) - 5);
        
        //Loads all objects into the scene
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        LoadLevel(currentLevel);
        startTicks = System.currentTimeMillis();
    }
    
    private void LoadLevel(int number)
    {
        if (number == 1) {
            //set level 1 background
            GreenfootImage image = new GreenfootImage("level1.jpg");
            image.scale(getWidth(), getHeight());
            setBackground(image);
            
            Floor floor = new Floor();
            addObject(floor,198,766);
            floor.setLocation(199,763);
            Floor floor2 = new Floor();
            addObject(floor2,597,764);
            floor2.setLocation(597,764);
            floor2.setLocation(597,764);
            floor2.setLocation(597,764);
            floor2.setLocation(597,764);
            floor2.setLocation(597,764);
            floor2.setLocation(597,764);
            floor2.setLocation(597,764);
            floor2.setLocation(597,764);
            floor2.setLocation(599,763);
            Floor floor3 = new Floor();
            addObject(floor3,921,748);
            floor3.setLocation(999,763);
            Floor floor4 = new Floor();
            addObject(floor4,389,679);
            Floor floor5 = new Floor();
            addObject(floor5,829,592);
            Floor floor6 = new Floor();
            addObject(floor6,375,538);
            Floor floor7 = new Floor();
            addObject(floor7,157,544);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(49,536);
            floor7.setLocation(50,538);
            Floor floor8 = new Floor();
            addObject(floor8,346,435);
            Floor floor9 = new Floor();
            addObject(floor9,735,440);
            floor9.setLocation(736,435);
            Healthbar healthbar = new Healthbar();
            addObject(healthbar,627,344);
            removeObject(healthbar);
            Floor floor10 = new Floor();
            addObject(floor10,625,340);
            Floor floor11 = new Floor();
            addObject(floor11,201,253);
            Floor floor12 = new Floor();
            addObject(floor12,848,263);
            floor12.setLocation(845,260);
            floor12.setLocation(845,250);
            Floor floor13 = new Floor();
            addObject(floor13,511,163);
            Flag flag = new Flag();
            addObject(flag,546,167);
            flag.setLocation(538,118);
            Enemy enemy = new Enemy();
            addObject(enemy,380,101);
            enemy.setLocation(377,117);
            Enemy enemy2 = new Enemy();
            addObject(enemy2,659,127);
            enemy2.setLocation(658,121);
            Enemy enemy3 = new Enemy();
            addObject(enemy3,904,215);
            Enemy enemy4 = new Enemy();
            addObject(enemy4,57,210);
            Enemy enemy5 = new Enemy();
            addObject(enemy5,359,396);
            removeObject(enemy);
            enemy2.setLocation(488,114);
            Enemy enemy6 = new Enemy();
            addObject(enemy6,847,549);
            Enemy enemy7 = new Enemy();
            addObject(enemy7,695,725);
            Coin coin = new Coin();
            addObject(coin,88,490);
            coin.setLocation(72,510);
            Coin coin2 = new Coin();
            addObject(coin2,281,636);
            coin2.setLocation(252,649);
            Coin coin3 = new Coin();
            addObject(coin3,965,695);
            coin3.setLocation(948,725);
            Coin coin4 = new Coin();
            addObject(coin4,959,574);
            coin4.setLocation(985,561);
            Coin coin5 = new Coin();
            addObject(coin5,633,415);
            coin5.setLocation(890,408);
            Coin coin6 = new Coin();
            addObject(coin6,617,319);
            coin6.setLocation(588,317);
            Coin coin7 = new Coin();
            addObject(coin7,850,203);
            coin7.setLocation(987,224);
            Coin coin8 = new Coin();
            addObject(coin8,48,201);
            coin8.setLocation(36,225);
            Coin coin9 = new Coin();
            addObject(coin9,349,131);
            Coin coin10 = new Coin();
            addObject(coin10,674,129);
            coin10.setLocation(684,137);
        }
        if (number == 2) {
            //set level 2 background
            GreenfootImage image = new GreenfootImage("level2.png");
            image.scale(getWidth(), getHeight());
            setBackground(image);
            
            Floor floor = new Floor();
            addObject(floor,237,690);
            floor.setLocation(198,764);
            Floor floor2 = new Floor();
            addObject(floor2,552,718);
            floor2.setLocation(595,764);
            Floor floor3 = new Floor();
            addObject(floor3,891,749);
            floor3.setLocation(981,764);
            Floor floor4 = new Floor();
            addObject(floor4,317,722);
            Floor floor5 = new Floor();
            addObject(floor5,717,636);
            Floor floor6 = new Floor();
            addObject(floor6,842,546);
            Floor floor7 = new Floor();
            addObject(floor7,470,464);
            Floor floor8 = new Floor();
            addObject(floor8,161,386);
            floor8.setLocation(114,371);
            Floor floor9 = new Floor();
            addObject(floor9,491,300);
            Floor floor10 = new Floor();
            addObject(floor10,835,233);
            floor10.setLocation(835,221);
            floor9.setLocation(491,292);
            floor10.setLocation(834,206);
            floor7.setLocation(472,453);
            Floor floor11 = new Floor();
            addObject(floor11,340,170);
            Floor floor12 = new Floor();
            addObject(floor12,230,83);
            floor12.setLocation(230,83);
            floor12.setLocation(230,83);
            floor12.setLocation(230,83);
            floor12.setLocation(230,83);
            floor12.setLocation(230,83);
            floor12.setLocation(230,83);
            floor12.setLocation(230,83);
            floor12.setLocation(230,83);
            floor12.setLocation(230,83);
            floor12.setLocation(230,83);
            floor12.setLocation(230,83);
            floor12.setLocation(230,83);
            floor12.setLocation(230,83);
            floor12.setLocation(230,83);
            floor12.setLocation(230,83);
            floor12.setLocation(230,83);
            floor12.setLocation(230,83);
            floor12.setLocation(230,83);
            floor12.setLocation(69,89);
            floor12.setLocation(35,89);
            floor12.setLocation(3,96);
            floor12.setLocation(3,96);
            floor12.setLocation(3,96);
            floor12.setLocation(3,96);
            floor12.setLocation(3,96);
            floor12.setLocation(3,96);
            floor12.setLocation(3,96);
            floor12.setLocation(3,96);
            floor12.setLocation(3,96);
            floor12.setLocation(3,96);
            floor12.setLocation(3,96);
            floor12.setLocation(3,96);
            floor12.setLocation(3,96);
            floor12.setLocation(0,91);
            floor12.setLocation(0,91);
            floor12.setLocation(0,91);
            floor12.setLocation(0,91);
            floor12.setLocation(0,91);
            floor12.setLocation(0,91);
            floor12.setLocation(0,91);
            floor12.setLocation(0,91);
            floor12.setLocation(0,91);
            floor12.setLocation(0,91);
            floor12.setLocation(0,91);
            floor12.setLocation(0,91);
            floor12.setLocation(0,91);
            floor12.setLocation(0,91);
            floor12.setLocation(0,91);
            floor12.setLocation(0,91);
            floor12.setLocation(0,91);
            floor12.setLocation(0,91);
            floor12.setLocation(0,91);
            floor12.setLocation(0,91);
            floor12.setLocation(0,91);
            floor12.setLocation(0,91);
            floor12.setLocation(0,91);
            floor12.setLocation(0,91);
            floor12.setLocation(0,91);
            floor12.setLocation(0,91);
            floor12.setLocation(0,91);
            Flag flag = new Flag();
            addObject(flag,931,702);
            flag.setLocation(992,721);
            flag.setLocation(992,717);
            Coin coin = new Coin();
            addObject(coin,821,592);
            coin.setLocation(877,609);
            Coin coin2 = new Coin();
            addObject(coin2,460,641);
            coin2.setLocation(471,686);
            Coin coin3 = new Coin();
            addObject(coin3,856,744);
            coin3.setLocation(905,742);
            Coin coin4 = new Coin();
            addObject(coin4,703,505);
            coin4.setLocation(703,505);
            coin4.setLocation(703,505);
            coin4.setLocation(703,505);
            coin4.setLocation(703,505);
            coin4.setLocation(703,505);
            coin4.setLocation(989,521);
            Coin coin5 = new Coin();
            addObject(coin5,397,422);
            coin5.setLocation(377,425);
            Coin coin6 = new Coin();
            addObject(coin6,319,245);
            coin6.setLocation(494,266);
            Coin coin7 = new Coin();
            addObject(coin7,923,169);
            coin7.setLocation(954,182);
            Coin coin8 = new Coin();
            addObject(coin8,337,132);
            coin8.setLocation(253,140);
            Coin coin9 = new Coin();
            addObject(coin9,32,55);
            coin9.setLocation(32,62);
            Coin coin10 = new Coin();
            addObject(coin10,34,328);
            coin10.setLocation(29,343);
            HealthPack healthpack = new HealthPack();
            addObject(healthpack,508,634);
            healthpack.setLocation(832,606);
            HealthPack healthpack2 = new HealthPack();
            addObject(healthpack2,206,292);
            healthpack2.setLocation(78,342);
            HealthPack healthpack3 = new HealthPack();
            addObject(healthpack3,199,51);
            healthpack3.setLocation(67,62);
            Enemy enemy = new Enemy();
            addObject(enemy,270,690);
            enemy.setLocation(265,678);
            Enemy enemy2 = new Enemy();
            addObject(enemy2,726,601);
            enemy2.setLocation(714,595);
            Enemy enemy3 = new Enemy();
            addObject(enemy3,820,509);
            enemy3.setLocation(827,506);
            enemy3.setLocation(828,502);
            Enemy enemy4 = new Enemy();
            addObject(enemy4,486,396);
            enemy4.setLocation(486,406);
            Enemy enemy5 = new Enemy();
            addObject(enemy5,157,331);
            Enemy enemy6 = new Enemy();
            addObject(enemy6,562,255);
            enemy6.setLocation(552,249);
            enemy6.setLocation(472,248);
            Enemy enemy7 = new Enemy();
            addObject(enemy7,838,167);
            enemy7.setLocation(835,163);
            Enemy enemy8 = new Enemy();
            addObject(enemy8,125,55);
            enemy8.setLocation(120,46);
        }
        if (number == 3) {
            //set level 2 background
            GreenfootImage image = new GreenfootImage("level3.jpg");
            image.scale(getWidth(), getHeight());
            setBackground(image);
            
            Floor floor = new Floor();
            addObject(floor,248,559);
            floor.setLocation(195,762);
            Floor floor2 = new Floor();
            addObject(floor2,570,733);
            floor2.setLocation(589,762);
            Floor floor3 = new Floor();
            addObject(floor3,930,740);
            floor3.setLocation(930,740);
            floor3.setLocation(930,740);
            floor3.setLocation(930,740);
            floor3.setLocation(930,740);
            floor3.setLocation(986,762);
            Floor floor4 = new Floor();
            addObject(floor4,830,683);
            Floor floor5 = new Floor();
            addObject(floor5,888,579);
            floor5.setLocation(922,583);
            Healthbar healthbar = new Healthbar();
            addObject(healthbar,468,505);
            removeObject(healthbar);
            Floor floor6 = new Floor();
            addObject(floor6,479,515);
            Floor floor7 = new Floor();
            addObject(floor7,110,501);
            floor7.setLocation(108,493);
            floor6.setLocation(486,493);
            Floor floor8 = new Floor();
            addObject(floor8,788,386);
            floor8.setLocation(839,411);
            floor8.setLocation(843,411);
            Floor floor9 = new Floor();
            addObject(floor9,439,338);
            floor9.setLocation(430,319);
            Floor floor10 = new Floor();
            addObject(floor10,194,223);
            Floor floor11 = new Floor();
            addObject(floor11,855,227);
            floor11.setLocation(848,219);
            Floor floor12 = new Floor();
            addObject(floor12,514,117);
            Floor floor13 = new Floor();
            addObject(floor13,817,87);
            floor13.setLocation(937,55);
            floor12.setLocation(521,136);
            floor13.setLocation(981,99);
            floor13.setLocation(986,80);
            Floor floor14 = new Floor();
            addObject(floor14,167,74);
            floor14.setLocation(48,85);
            Coin coin = new Coin();
            addObject(coin,227,729);
            coin.setLocation(417,723);
            Coin coin2 = new Coin();
            addObject(coin2,989,650);
            coin2.setLocation(966,650);
            Coin coin3 = new Coin();
            addObject(coin3,922,549);
            coin3.setLocation(962,555);
            Coin coin4 = new Coin();
            addObject(coin4,84,440);
            coin4.setLocation(61,457);
            Coin coin5 = new Coin();
            addObject(coin5,958,359);
            coin5.setLocation(982,381);
            Coin coin6 = new Coin();
            addObject(coin6,378,260);
            coin6.setLocation(340,281);
            Coin coin7 = new Coin();
            addObject(coin7,949,178);
            coin7.setLocation(986,191);
            Coin coin8 = new Coin();
            addObject(coin8,84,183);
            coin8.setLocation(64,186);
            Coin coin9 = new Coin();
            addObject(coin9,998,40);
            coin9.setLocation(988,54);
            Coin coin10 = new Coin();
            addObject(coin10,56,49);
            coin10.setLocation(40,52);
            Enemy enemy = new Enemy();
            addObject(enemy,409,717);
            Enemy enemy2 = new Enemy();
            addObject(enemy2,826,651);
            enemy2.setLocation(846,635);
            Enemy enemy3 = new Enemy();
            addObject(enemy3,851,538);
            Enemy enemy4 = new Enemy();
            addObject(enemy4,173,440);
            Enemy enemy5 = new Enemy();
            addObject(enemy5,854,368);
            Enemy enemy6 = new Enemy();
            addObject(enemy6,470,270);
            Enemy enemy7 = new Enemy();
            addObject(enemy7,175,180);
            Enemy enemy8 = new Enemy();
            addObject(enemy8,872,176);
            Enemy enemy9 = new Enemy();
            addObject(enemy9,879,30);
            Enemy enemy10 = new Enemy();
            addObject(enemy10,144,32);
            Enemy enemy11 = new Enemy();
            addObject(enemy11,530,87);
            HealthPack healthpack = new HealthPack();
            addObject(healthpack,913,696);
            healthpack.setLocation(952,725);
            HealthPack healthpack2 = new HealthPack();
            addObject(healthpack2,845,586);
            healthpack2.setLocation(974,559);
            healthpack2.setLocation(987,550);
            HealthPack healthpack3 = new HealthPack();
            addObject(healthpack3,223,431);
            healthpack3.setLocation(112,454);
            HealthPack healthpack4 = new HealthPack();
            addObject(healthpack4,552,277);
            healthpack4.setLocation(401,290);
            HealthPack healthpack5 = new HealthPack();
            addObject(healthpack5,900,164);
            healthpack5.setLocation(943,186);
            HealthPack healthpack6 = new HealthPack();
            addObject(healthpack6,67,50);
            healthpack6.setLocation(78,57);
            Flag flag = new Flag();
            addObject(flag,78,648);
            flag.setLocation(77,713);
        }
    }
    
    public Healthbar addHealthbar(int x, int y)
    {
        Healthbar newHealthbar = new Healthbar();
        addObject(newHealthbar, x, y);
        return newHealthbar;
    }
    
    
    private void CheckForLevelCompletion() 
    {
        if (joe.CheckForLevelCompletion() == true) {
            if (currentLevel == 1) {
                removeAllObjectsInWorld();
                totalTimeTaken += time/1000;
                currentLevel++;
                startTicks = System.currentTimeMillis();
                
                newLevelSound.play();
                
                
                
                
                LoadLevel(currentLevel);
                Reset();
            }
            else if (currentLevel == 2) {
                removeAllObjectsInWorld();
                totalTimeTaken += time/1000;
                currentLevel++;
                startTicks = System.currentTimeMillis();
                
                newLevelSound.play();
                
                
                
                LoadLevel(currentLevel);
                Reset();
            }
            else if (currentLevel == 3) {
                totalTimeTaken += time/1000;
                newLevelSound.play();
                music.stop();
                Greenfoot.setWorld(new WinningScreen(getWidth(), getHeight(), totalTimeTaken, joeLifes));
            }
        }
    }
    
    private void playMusic()
    {
        if (music.isPlaying() == false) {
            music.playLoop();
            music.setVolume(40);
        }
    }
    
    public void act()
    {
        //update the ticks
        currentTicks = System.currentTimeMillis();
        time = currentTicks - startTicks;
        
        //plays music
        playMusic();
        
        //Updates the healthbar's location to where the player is
        healthbar.setLocation(((joe.getX() - (joe.getImage().getWidth()/2)) + (healthbar.getImage().getWidth()/2)) + 5, joe.getY() - (joe.getImage().getHeight()/2) - 5);
        //Updates the player's location for the enemy's AI
        UpdatePlayerLocationToEnemey();
        //Shows the number of coins that have been collected
        DisplayCoinsCollected();
        //Show time
        DisplayTime();
        //shows number of lifes
        DisplayJoeLifes();
        
        //Check to see if joe has died
        CheckForJoeDeath();
        
        //Checks to see if player has completed the current leve
        CheckForLevelCompletion();
        
        
        //Sees if the game is over
        CheckForGameover();
    }
    
    public void DisplayTime()
    {
        showText("Time Left: " + (timeLimit - time)/1000, 200, 10);
    }
    
    public void CheckForJoeDeath()
    {
        if (joe.getHealth() <= 0 || (int)(timeLimit - time)/1000 < 1) {
            removeAllObjectsInWorld();
            joeLifes--;
            Reset();
            prepare();
        }
    }
    
    void removeAllObjectsInWorld()
    {
        for (int i = 0; i < getObjects(Enemy.class).size(); i++) {
            getObjects(Enemy.class).get(i).RemoveHealthbar();
        }
        //removes all objects from the world
        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < getObjects(Actor.class).size(); i++) {
                if (getObjects(Actor.class).get(i).getClass() != Joe.class && getObjects(Actor.class).get(i).getClass() != Healthbar.class) {
                    removeObject(getObjects(Actor.class).get(i));
                    removeAllObjectsInWorld();
                }
            }
        }
    }

    public void addBullet(int x, int y, char direction)
    {
        //Creates a new bullet to shoot
        Bullet bullet = new Bullet();
        addObject(bullet, x, y);
        bullet.setDirection(direction);
    }
    
    void CheckForGameover()
    {
        if (joeLifes <= 0) {
            music.stop();
            Greenfoot.setWorld(new LosingScreen(getWidth(), getHeight()));
        }
    }
    
    void DisplayJoeLifes()
    {
        showText("Lifes: " + joeLifes, 400, 10);
    }
    
    void Reset()
    {
        joe.Reset();
        joe.setLocation(30, getHeight() - 60);
        healthbar.Reset();
        time = 0;
    }
    
    public int GetHealthPackHealth()
    {
        if (getObjects(HealthPack.class).isEmpty() == false) {
            return getObjects(HealthPack.class).get(0).GetHealth();
        }
        return 0;
    }
    
    public void DisplayCoinsCollected()
    {
        showText("Coins: " + joe.coinsCollected, 50, 10);
    }
    
    public int getJoeCoinsCollected()
    {
         return joe.getCoinsCollected();
    }
    
    
    public void UpdatePlayerLocationToEnemey()
    {
        //Loops through all of the enemies on the world to updates the player's position for AI
        int i = 0;
        while (i < getObjects(Enemy.class).size()) {
            getObjects(Enemy.class).get(i).UpdatePlayerPosition(joe.getX(), joe.getY());
            i++;
        }
    }
}
