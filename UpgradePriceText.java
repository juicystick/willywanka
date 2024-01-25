import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UpgradePriceText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UpgradePriceText extends Actor
{
    private int upgradeCount;
    private String upgradeTypeName;
    
    private GreenfootImage image;
    private int upgradePrice;
    private float initialUpgradePrice;
    
    public UpgradePriceText(int upgradeCount, String upgradeType) {
        upgradeCount = upgradeCount;
        initialUpgradePrice = determineInitialUpgradePrice(upgradeType);
        upgradePrice = determineActualUpgradePrice(initialUpgradePrice, upgradeCount);
        image = new GreenfootImage(Integer.toString(upgradePrice), 25, Color.GRAY, null);
        setImage(image);
        upgradeTypeName = upgradeType;
    };
    
    /**
     * Act - do whatever the UpgradePriceText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        WankaWorld wankaWorld = (WankaWorld) getWorld();
        if (upgradeTypeName == "gion"){
            upgradeCount = wankaWorld.gionCount;
        } else if (upgradeTypeName == "garden") {
            upgradeCount = wankaWorld.gardenCount;
        } else if (upgradeTypeName == "macBook") {
            upgradeCount = wankaWorld.macBookCount;
        } else if (upgradeTypeName == "printer") {
            upgradeCount = wankaWorld.printerCount;
        };
        
        updateUpgradePriceText(determineActualUpgradePrice(determineInitialUpgradePrice(upgradeTypeName), upgradeCount), upgradeCount, upgradeTypeName);
    };
    
    private float determineInitialUpgradePrice(String upgradeTypeName) {
        if (upgradeTypeName == "gion") {
            return 5.0f;
        };
        if (upgradeTypeName == "garden") {
            return 80.0f;
        };
        if (upgradeTypeName == "macBook") {
            return 480.0f;
        };
        if (upgradeTypeName == "printer") {
            return 3200.0f;
        };
        return 1;
    };
    
    private int determineActualUpgradePrice(float initialUpgradePrice, int upgradeCount) {
        for (int i = 0; i < upgradeCount; i++) {
            initialUpgradePrice = initialUpgradePrice * 1.1f;
        };
        return Math.round(initialUpgradePrice);
    };
    
    public void updateUpgradePriceText(float intialUpgradePrice, int newUpgradeCount, String upgradeTypeName) {
        upgradePrice = determineActualUpgradePrice(initialUpgradePrice, newUpgradeCount);
        image.clear();
        image = new GreenfootImage(Integer.toString(upgradePrice), 25, Color.GRAY, null);
        setImage(image);
        
        WankaWorld wankaWorld = (WankaWorld) getWorld();
        if (upgradeTypeName == "gion") {
            wankaWorld.gionPrice = upgradePrice;
        };
        if (upgradeTypeName == "garden") {
            wankaWorld.gardenPrice = upgradePrice;
        };
        if (upgradeTypeName == "macBook") {
            wankaWorld.macBookPrice = upgradePrice;
        };
        if (upgradeTypeName == "printer") {
            wankaWorld.printerPrice = upgradePrice;
        };        
    };
}
