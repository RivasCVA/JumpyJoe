import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Joe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Joe extends Actor
{
    //Health
    public int health = 100;
    public int coinsCollected = 0;
    
    // movement variables
    int moveSpeed = 3;
    int gravity = 5;
    boolean isStandingStill = false;
    
    //Jump variables [TEMPORARY]
    int JUMP_SPEED = 15;
    int currentJumpSpeed = JUMP_SPEED;
    int JUMP_DELAY = 50;
    int currentJumpDelay = 0;
    int jumpCycles = 0;
    boolean isInAir = false;
    boolean needsToJump = false;
    
    //animating varibales
    int currentWalkImage = 1;
    int animationDelay = 5;
    int currentAnimationDelay = 0;
    char currentDirection = 'R';
    
    //Firing
    int FIRE_RATE = 15;
    int currentFireDelay = 0;
    
    //Store the previous frame positions
    int previousX = 0;
    int previousY = 0;
    
    //sound fx
    GreenfootSound shotSound = new GreenfootSound("pistol.wav");
    GreenfootSound coinSound = new GreenfootSound("coinCollect.mp3");
    
    public Joe()
    {
        
    }
    
    /**
     * Act - do whatever the Joe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {  
        UpdateKeyPress();
        Animate();
        Jump();
        SimulateGravity();
        CheckForBulletHit();
        CheckForCoinCollection();
        CheckForHealthPackCollection();
        
        // Updates the X and Y positions to be used for next frame
        previousX = getX();
        previousY = getY();
    }
    
    public void CheckForBulletHit()
    {
        // Checks if the player has been hit by a bullet
        if (isTouching(Bullet.class)) {
            takeDamage(15);
            removeTouching(Bullet.class);
        }
    }
    
    public void takeDamage(int damage)
    {
        // takes damage and updates healthbar
        health -= damage;
        MainGame lvl = (MainGame)getWorld();
        lvl.healthbar.reduceSize(5);
    }
    
    public void UpdateKeyPress()
    {
        boolean hasMoved = false;
        // moves the character if he is not colliding with anything
        //Moves Right
        if (Greenfoot.isKeyDown("right") && !(isTouching(Block.class)))
        {
            if (currentDirection == 'R') {
                currentWalkImage++;
            } else {
                currentDirection = 'R';
                currentWalkImage = 1;
            }
            hasMoved = true;
            move(moveSpeed);
        }
        //Moves Left
        if (Greenfoot.isKeyDown("left") && !(isTouching(Block.class)))
        {
            if (currentDirection == 'L') {
                currentWalkImage--;
            } else {
                currentDirection = 'L';
                currentWalkImage = 9;
            }
            hasMoved = true;
            move(-moveSpeed);
        }
        
        //Checks if joe was moved or not
        if (hasMoved == false) {
            isStandingStill = true;
        }
        else {
            isStandingStill = false;
        }
        
        //Jumps
        if (Greenfoot.isKeyDown("up")) {
            needsToJump = true;
        }
        //Fires a bullet
        if (Greenfoot.isKeyDown("space") && currentFireDelay <= 0 && isInAir == false) {
            MainGame lvl = (MainGame)getWorld();
            
            shotSound.stop();
            shotSound.play();
            if (currentDirection == 'R') {
                lvl.addBullet(getX() + 40, getY() - 7, currentDirection);
            }
            if (currentDirection == 'L') {
                lvl.addBullet(getX() - 40, getY() - 7, currentDirection);
            }
            
            
            currentFireDelay = FIRE_RATE;
        }
        //Reduces the fire delay to be able to fire again
        if (currentFireDelay > 0) {
            currentFireDelay--;
        }
    }
    
    public void SimulateGravity()
    {
        //moves the character down simulating gravity
        setLocation(getX(), getY() + gravity);
        //if the character collides the variable will be true meaning that the character will be moved upwards temporarily to see if he has collided in another place also, if it is true at the end then the character will be moved down to its originial position
        boolean moveup = false;
        
        //Checks collision on the players feet
        if (getOneObjectAtOffset((getImage().getWidth()/2), (getImage().getHeight()/2), Floor.class) != null || getOneObjectAtOffset(-(getImage().getWidth()/2), (getImage().getHeight()/2), Floor.class) != null) {
            Actor touchingFloor = null;
            if (getOneObjectAtOffset((getImage().getWidth()/2), (getImage().getHeight()/2), Floor.class) != null) {
                touchingFloor = getOneObjectAtOffset((getImage().getWidth()/2), (getImage().getHeight()/2), Floor.class);
            }
            if (getOneObjectAtOffset(-(getImage().getWidth()/2), (getImage().getHeight()/2), Floor.class) != null) {
                touchingFloor = getOneObjectAtOffset(-(getImage().getWidth()/2), (getImage().getHeight()/2), Floor.class);
            }
            
            if (touchingFloor != null) {
                int distApart = touchingFloor.getY() - getY();
                int minDist = (touchingFloor.getImage().getHeight()/2) + (getImage().getHeight()/2);
                int collisionDepth = minDist - distApart;
                
                isInAir = false;
                moveup = true;
                setLocation(getX(), (getY() - collisionDepth) - 5);
            }
            
        }
        //Checks collision on the players head
        else if (getOneObjectAtOffset((getImage().getWidth()/2), -(getImage().getHeight()/2), Floor.class) != null || getOneObjectAtOffset(-(getImage().getWidth()/2), -(getImage().getHeight()/2), Floor.class) != null) {
            Actor touchingFloor = null;
            if (getOneObjectAtOffset((getImage().getWidth()/2), -(getImage().getHeight()/2), Floor.class) != null) {
                touchingFloor = getOneObjectAtOffset((getImage().getWidth()/2), -(getImage().getHeight()/2), Floor.class);
            }
            if (getOneObjectAtOffset(-(getImage().getWidth()/2), -(getImage().getHeight()/2), Floor.class) != null) {
                touchingFloor = getOneObjectAtOffset(-(getImage().getWidth()/2), -(getImage().getHeight()/2), Floor.class);
            }
            
            if (touchingFloor != null) {
                int distApart = getY() - touchingFloor.getY();
                int minDist = (touchingFloor.getImage().getHeight()/2) + (getImage().getHeight()/2);
                int collisionDepth = minDist - distApart;
            
                setLocation(getX(), getY() + collisionDepth);
            }
            
        }
        
        //Checks collision on the right side of the player
        if (isTouching(Floor.class) && getX() > previousX) {
            setLocation(getX() - moveSpeed, getY());
        }
        //Checks collision on the left side of the player
        else if (isTouching(Floor.class) && getX() < previousX) {
            setLocation(getX() + moveSpeed, getY());
        }
        
        //moves the character down if it was moved upward to detect other collions
        if (moveup == true) {
            setLocation(getX(), getY() + 5);
        }
    }
    
    public void CheckForCoinCollection()
    {
        if (isTouching(Coin.class)) {
            coinsCollected++;
            coinSound.stop();
            coinSound.play();
            removeTouching(Coin.class);
        }
    }
    
    public void CheckForHealthPackCollection()
    {
        if (isTouching(HealthPack.class)) {
            MainGame lvl = (MainGame)getWorld();
            health += lvl.GetHealthPackHealth();
            lvl.healthbar.reduceSize(-5);
            removeTouching(HealthPack.class);
        }
        
    }
    
    public boolean CheckForLevelCompletion()
    {
        if (isTouching(Flag.class) && coinsCollected >= 10) {
            return true;
        }
        return false;
    }
    
    public int getCoinsCollected()
    {
        return coinsCollected;
    }
    
    public void Reset()
    {
        health = 100;
        coinsCollected = 0;
    }
    
    public void Animate()
    {
        //Continusly loops through all of the player walking right images
        if (currentWalkImage <= 9 && currentDirection == 'R' && currentAnimationDelay <= 0) {
            setImage("gunJoeWalkRight" + currentWalkImage + ".png");
            currentAnimationDelay = animationDelay;
        } if (currentWalkImage > 9 && currentDirection == 'R') {
            currentWalkImage = 1;
        }
        //Continusly loops through all of the player walking left images
        if (currentWalkImage >= 1 && currentDirection == 'L' && currentAnimationDelay <= 0) {
            setImage("gunJoeWalkLeft" + currentWalkImage + ".png");
            currentAnimationDelay = animationDelay;
        } if (currentWalkImage < 1 && currentDirection == 'L'){
            currentWalkImage = 9;
        }
        
        //Sets the first image if player is not moving
        if (isStandingStill == true && currentDirection == 'L') {
            setImage("gunJoeWalkLeft9.png");
        }
        if (isStandingStill == true && currentDirection == 'R') {
            setImage("gunJoeWalkRight1.png");
        }
        
        //Sets the jumping image if the player is not on the ground
        if (isInAir == true && currentDirection == 'R') {
            setImage("jumpRight.png");
        }
        if (isInAir == true && currentDirection == 'L') {
            setImage("jumpLeft.png");
        }
        
        //reduces the animation delay to show the next image
        if (currentAnimationDelay > 0) {
            currentAnimationDelay--;
        }
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public void Jump() //TEMPOERARY: NEED TO IMPLEMENT BETTER JUMP
    {
        //Sets the jump delay to 0 if the player has already touched the ground so it can jump again
        if (isInAir == false) {
            currentJumpDelay = 0;
        }
        
        //Moves the player upwards
        if (needsToJump == true && currentJumpDelay <= 0) {
            setLocation(getX(), getY() - currentJumpSpeed);
            isInAir = true;
            jumpCycles++;
        }
        
        //Reduces the jump speed so that the player jumps smoothly
        if (jumpCycles >= 2 && needsToJump == true) {
            currentJumpSpeed--;
            jumpCycles = 0;
        }
        
        //When the player has no more motion upward, then the jump is over
        if (currentJumpSpeed <= 0) {
            currentJumpSpeed = JUMP_SPEED;
            currentJumpDelay = JUMP_DELAY;
            needsToJump = false;
        }
    }
}
