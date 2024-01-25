import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CurrentScoreText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CurrentScoreText extends Actor
{   
    private GreenfootImage image;
    public CurrentScoreText(int initialScore) {
        image = new GreenfootImage(initialScore + "\ncookies", 35, Color.WHITE, null);
        setImage(image);
    };
    
    /**
     * Act - do whatever the CurrentScoreText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        WankaWorld wankaWorld = (WankaWorld) getWorld();
        image.clear();
        image = new GreenfootImage(wankaWorld.currentScore + "\ncookies", 35, Color.WHITE, null);
        setImage(image);
    };
}
