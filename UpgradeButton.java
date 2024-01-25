import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UpgradeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UpgradeButton extends Actor
{  
    private GreenfootImage image;
    private String upgradeTypeName;
    public UpgradeButton(String upgradeType) {
        image = new GreenfootImage(upgradeType + ".png");
        setImage(image);
        upgradeTypeName = upgradeType;
    };
    
    /**
     * Act - do whatever the UpgradeButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        if (Greenfoot.mouseClicked(this)==true) {
            WankaWorld wankaWorld = (WankaWorld) getWorld();
            if (upgradeTypeName == "gion"){
                if (wankaWorld.currentScore >= wankaWorld.gionPrice){
                    wankaWorld.gionCount++;
                    wankaWorld.currentScore = wankaWorld.currentScore - wankaWorld.gionPrice;
                };
            } else if (upgradeTypeName == "garden") {
                if (wankaWorld.currentScore >= wankaWorld.gardenPrice){
                    wankaWorld.gardenCount++;
                    wankaWorld.currentScore = wankaWorld.currentScore - wankaWorld.gardenPrice;
                };
            } else if (upgradeTypeName == "macbook") {
                if (wankaWorld.currentScore >= wankaWorld.macBookPrice){
                    wankaWorld.macBookCount++;
                    wankaWorld.currentScore = wankaWorld.currentScore - wankaWorld.macBookPrice;
                };
            } else if (upgradeTypeName == "printer") {
                if (wankaWorld.currentScore >= wankaWorld.printerPrice){
                    wankaWorld.printerCount++;
                    wankaWorld.currentScore = wankaWorld.currentScore - wankaWorld.printerPrice;
                };
            };
        };
    }
}
