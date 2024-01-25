import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UpgradeCountText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UpgradeCountText extends Actor
{
    GreenfootImage image;
    private String upgradeTypeName;    
    public UpgradeCountText(int upgradeCount, String upgradeType) {
        image = new GreenfootImage(Integer.toString(upgradeCount), 25, Color.GRAY, null);
        setImage(image);
        upgradeTypeName = upgradeType;
    };
    
    /**
     * Act - do whatever the UpgradeCountText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        WankaWorld wankaWorld = (WankaWorld) getWorld();
        if (upgradeTypeName == "gion"){
            image.clear();
            image = new GreenfootImage(Integer.toString(wankaWorld.gionCount), 25, Color.GRAY, null);
            setImage(image);
        } else if (upgradeTypeName == "garden") {
            image.clear();
            image = new GreenfootImage(Integer.toString(wankaWorld.gardenCount), 25, Color.GRAY, null);
            setImage(image);
        } else if (upgradeTypeName == "macBook") {
            image.clear();
            image = new GreenfootImage(Integer.toString(wankaWorld.macBookCount), 25, Color.GRAY, null);
            setImage(image);
        } else if (upgradeTypeName == "printer") {
            image.clear();
            image = new GreenfootImage(Integer.toString(wankaWorld.printerCount), 25, Color.GRAY, null);
            setImage(image);
        };
    };
}
