import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CookiesPerSecondText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CookiesPerSecondText extends Actor
{
    private GreenfootImage image;
    public CookiesPerSecondText(int initialPerSecond) {
        image = new GreenfootImage(initialPerSecond + "\nper second", 15, Color.WHITE, null);
        setImage(image);
    };
    /**
     * Act - do whatever the CookiesPerSecondText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        WankaWorld wankaWorld = (WankaWorld) getWorld();
        image.clear();
        image = new GreenfootImage(wankaWorld.currentScorePerSecond + "\nper second", 15, Color.WHITE, null);
        setImage(image);
    }
}
