import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Enemy here.
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    int health = 100;
    
    boolean justSpawned = true;
    
    Healthbar healthbar = new Healthbar();
    
    boolean isDead = false;
    int timeLeftOnFloor = 70;
    
    int moveSpeed = 2;
    char direction = 'R';
    int patrolMaxDistance = 100;
    int currentPatrolDistance = Greenfoot.getRandomNumber(50) + 1;
    
    boolean isInAir = false;
    
    int MIN_Y_DIST_TO_PLAYER = 50;
    int MIN_X_DIST_TO_PLAYER = 200;
    int MIN_X_DIST_TO_SHOOT = 150;
    int MIN_X_DIST_TO_MOVE_TOWARDS_PLAYER = 80;
    boolean isFollowingPlayer = false;
    
    int currentWalkImage = 1;
    int currentAnimationDelay = 0;
    int animationDelay = 10;
    
    
    
    int FIRE_RATE = 50;
    int currentFireDelay = 0;
    
    int previousX = 0;
    int previousY = 0;
    
    int playerX = 0;
    int playerY = 0;
    
    GreenfootSound deathSound = new GreenfootSound("enemyDeath.wav");
    GreenfootSound shotSound = new GreenfootSound("enemyShot.wav");
    boolean hasPlayedFx = false;
    
    public Enemy()
    {
       
    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (isDead == false) {
            //executed only once
            if (justSpawned == true) {
                MainGame maingame = (MainGame) getWorld();
                maingame.addObject(healthbar, getX(), getY());
                justSpawned = false;
            }
            
            // moves the enemy left or right to patrol and area
            if (currentPatrolDistance <= patrolMaxDistance && isFollowingPlayer == false) {
                if (direction == 'R') {
                    move(moveSpeed);
                    currentWalkImage++;
                }
                if (direction == 'L') {
                    move(-moveSpeed);
                    currentWalkImage--;
                }
                currentPatrolDistance++;
            }
            
            //changes the players movement direction after it has moved a certain distance in the other direction
            if (currentPatrolDistance > patrolMaxDistance) {
                if (direction == 'R') {
                    direction = 'L';
                } else if (direction == 'L') {
                    direction = 'R';
                }
                currentPatrolDistance = 0;
            }
            
            Animate();
            CheckDistanceFromPlayer();
            CheckForBulletHit();
            SimulateGravity();
            
            //updates healthbar location
            healthbar.setPosition(getX(), getY() - 40);
            
            
            //Reduces the fire delay to shoot again
            if (currentFireDelay > 0) {
                currentFireDelay--;
            }
            
            
            //Updates the player x and y position for use on next frame
            previousX = getX();
            previousY = getY();
            
            //checks if the player dies; has to be used at the end to avoid errors
            CheckForDeath();
        }
        else {
            if (hasPlayedFx == false) {
                deathSound.play();
                hasPlayedFx = true;
            }
            playDeadAnimation();
            MainGame myworld = (MainGame) getWorld();
            myworld.removeObject(healthbar);

            //removes the player after the animation is done and time left on ground is over
            if (timeLeftOnFloor <= 0) {
                getWorld().removeObject(this);
            }
        }
    }
    
    public void CheckDistanceFromPlayer()
    {
        //variable is used to change the distance variable back to its origianl value if it was taken its absolute value
        boolean ChangeBack = false;
        
        //gets the distance from this enemy to the player
        int distanceX = playerX - getX();
        int distanceY = playerY - getY();
        
        //changes the distance variables to their absolute value
        if (distanceX < 0) {
            distanceX *= -1;
            ChangeBack = true;
        }
        if (distanceY < 0) {
            distanceY *= -1;
        }
        
        //checks if the enemy and player's distance is close enough to shoot and move towards it
        if (distanceY < MIN_Y_DIST_TO_PLAYER) {
            if (distanceX < MIN_X_DIST_TO_PLAYER) {
                isFollowingPlayer = true;
                boolean canMoveTowardsPlayer = false;
                //shoots if it is close enough
                if (distanceX < MIN_X_DIST_TO_SHOOT) {
                    Shoot();
                }
                
                //check if the enemy is not too close to the player
                if (distanceX > MIN_X_DIST_TO_MOVE_TOWARDS_PLAYER) {
                    canMoveTowardsPlayer = true;
                }
                
                //changes the distance variables back to original to see if the player is to the right or left
                if (ChangeBack == true) {
                    distanceX *= -1;
                }
                if (distanceX < 0) {
                    direction = 'L';
                } else if (distanceX > 0) {
                    direction = 'R';
                }
                
                //moves the enemy towards the player
                if (canMoveTowardsPlayer == true) {
                    if (direction == 'R') {
                        move(moveSpeed);
                        currentWalkImage++;
                    }
                    if (direction == 'L') {
                        move(-moveSpeed);
                        currentWalkImage--;
                    }
                }
                else {
                    if (direction == 'R') {
                        setImage("P_EnemyWalkRight1.png");
                    }
                    if (direction == 'L') {
                        setImage("P_EnemyWalkLeft6.png");
                    }
                }
            }
            else {
                isFollowingPlayer = false;
            }
        }
        else {
            isFollowingPlayer = false;
        }
    }
    
    public void CheckForBulletHit()
    {
        //checks if it was hit by a bullet
        if (isTouching(Bullet.class)) {
            health -= 30;
            healthbar.reduceSize(10);
            removeTouching(Bullet.class);
        }
    }
    
    public void RemoveHealthbar()
    {
        MainGame myworld = (MainGame) getWorld();
        myworld.removeObject(healthbar);
    }
    
    public void CheckForDeath()
    {
        //removes the enemy if the health is 0
        if (health <= 0) {
            //getWorld().removeObject(this);
            isDead = true;
            if (direction == 'R') {
                currentWalkImage = 1;
            }
            if (direction == 'L') {
                currentWalkImage = 4;
            }
            animationDelay = 8;
        }
    }
    
    public void SimulateGravity()
    {
        //variables that will help predict if the enemy is on the edge
        boolean collidingRight = false;
        boolean collidingLeft = false;
        
        //simulates gravity
        setLocation(getX(), getY() + 5);
        
        //SAME AS JOE's COLLISION DETECTION
        boolean moveup = false;
        
        if (getOneObjectAtOffset((getImage().getWidth()/2), (getImage().getHeight()/2), Floor.class) != null || getOneObjectAtOffset(-(getImage().getWidth()/2), (getImage().getHeight()/2), Floor.class) != null) {
            Actor touchingFloor = null;
            if (getOneObjectAtOffset((getImage().getWidth()/2), (getImage().getHeight()/2), Floor.class) != null) {
                touchingFloor = getOneObjectAtOffset((getImage().getWidth()/2), (getImage().getHeight()/2), Floor.class);
                collidingRight = true;
            }
            if (getOneObjectAtOffset(-(getImage().getWidth()/2), (getImage().getHeight()/2), Floor.class) != null) {
                touchingFloor = getOneObjectAtOffset(-(getImage().getWidth()/2), (getImage().getHeight()/2), Floor.class);
                collidingLeft = true;
            }
            
            //will make character change direction if he is on edge of floor
            if (collidingRight == false && collidingLeft == true) {
                direction = 'L';
                currentPatrolDistance = 0;
            }
            if (collidingLeft = false && collidingRight == true) {
                direction = 'R';
                currentPatrolDistance = 0;
            }
            
            if (touchingFloor != null) {
                int distApart = touchingFloor.getY() - getY();
                int minDist = (touchingFloor.getImage().getHeight()/2) + (getImage().getHeight()/2);
                int collisionDepth = minDist - distApart;
                
                //isInAir = false;
                isInAir = false;
                
                moveup = true;
                setLocation(getX(), (getY() - collisionDepth) - 5);
            }
            else {
                isInAir = true;
            }
            
        } else if (getOneObjectAtOffset((getImage().getWidth()/2), -(getImage().getHeight()/2), Floor.class) != null || getOneObjectAtOffset(-(getImage().getWidth()/2), -(getImage().getHeight()/2), Floor.class) != null) {
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
        
        if (isTouching(Floor.class) && getX() > previousX) {
            setLocation(getX() - moveSpeed, getY());
            direction = 'L';
            currentPatrolDistance = 0;
        } else if (isTouching(Floor.class) && getX() < previousX) {
            setLocation(getX() + moveSpeed, getY());
            direction = 'R';
            currentPatrolDistance = 0;
        }
        
        if (moveup == true) {
            setLocation(getX(), getY() + 5);
        }
    }
    
    void Shoot()
    {
        //Shoots bullets
        if (currentFireDelay <= 0) {
            MainGame lvl = (MainGame)getWorld();
            shotSound.stop();
            shotSound.play();
            if (direction == 'R') {
                lvl.addBullet(getX() + (getImage().getWidth() - 2), getY() - 10, direction);
            }
            if (direction == 'L') {
                lvl.addBullet(getX() - (getImage().getWidth() + 2), getY() - 10, direction);
            }
            currentFireDelay = FIRE_RATE;
        }
        
    }
    
    void Animate()
    {
        if (currentWalkImage > 6) {
            currentWalkImage = 1;
        }
        if (currentWalkImage < 1) {
            currentWalkImage = 6;
        }
        
        //Continusly loops through all of the player walking left images
        if (currentWalkImage >= 1 && direction == 'L' && currentAnimationDelay <= 0) {
            setImage("P_EnemyWalkLeft" + currentWalkImage + ".png");
            currentAnimationDelay = animationDelay;
        } if (currentWalkImage < 1 && direction == 'L'){
            currentWalkImage = 6;
        }
        
        //Continusly loops through all of the player walking right images
        if (currentWalkImage <= 6 && direction == 'R' && currentAnimationDelay <= 0) {
            setImage("P_EnemyWalkRight" + currentWalkImage + ".png");
            currentAnimationDelay = animationDelay;
        } if (currentWalkImage > 6 && direction == 'R') {
            currentWalkImage = 1;
        }
        
        //reduces the animation delay to show the next image
        if (currentAnimationDelay > 0) {
            currentAnimationDelay--;
        }

    }
    
    void playDeadAnimation()
    {
        //Plays the animation of the enemy dying
        if (currentAnimationDelay == 0 && direction == 'R' && currentWalkImage <= 4) {
            setImage("P_EnemyDieRight" + currentWalkImage + ".png");
            currentAnimationDelay = animationDelay - 2;
            currentWalkImage++;
        }
        if (currentAnimationDelay == 0 && direction == 'L' && currentWalkImage >= 1) {
            setImage("P_EnemyDieLeft" + currentWalkImage + ".png");
            currentAnimationDelay = animationDelay;
            currentWalkImage--;
        }
        
        
        if (currentWalkImage > 4 || currentWalkImage < 1) {
            timeLeftOnFloor--;
        }
        
        //reduces the animation delay to show the next image
        if (currentAnimationDelay > 0) {
            currentAnimationDelay--;
        }
    }
        
    void UpdatePlayerPosition(int x, int y)
    {
        playerX = x;
        playerY = y;
    }
}
