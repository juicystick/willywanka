import greenfoot.*;
import java.io.*;
 // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WankaWorld extends World
{
    // Global Variables
    int currentScore;
    int currentScorePerSecond;
    int gionCount;
    int gardenCount;
    int macBookCount;
    int printerCount;
    int gionPrice;
    int gardenPrice;
    int macBookPrice;
    int printerPrice;

    // Private Variables
    private boolean success = false;
    private int oldScore;
    private int timerUpgrade = 60;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public WankaWorld() {    
        // Create a new world with 1266x778 cells with a cell size of 1x1 pixels.
        super(1266, 778, 1);
        try {
            manageDataFile();
        }catch (Throwable err){
            try{
                saveGameToDataFile();
            }catch(Throwable error){
                System.out.println(error);
            };
        }
        currentScorePerSecond = (gionCount * 1) + (gardenCount * 10) + (macBookCount * 50) + (printerCount * 200);
        setBackground("Background.png");
        prepare();
        oldScore = currentScore;
    };

    private void manageDataFile() throws IOException {
        File file = new File("data.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = "";
        String sst = "";
        int count = 0;
        while ((st = br.readLine()) != null)
            sst = st;
        String[] result = sst.split("[,]", 0);
        for (String splitString: result) {
            if (splitString == "") {
                splitString = "0";
            };
            if (count == 0) {
                currentScore = Integer.parseInt(splitString);
                count++;
            } else {
                if (count == 1) {
                    gionCount = Integer.parseInt(splitString);
                    count++;
                } else {
                    if (count == 2) {
                        gardenCount = Integer.parseInt(splitString);
                        count++;
                    } else {
                        if (count == 3) {
                            macBookCount = Integer.parseInt(splitString);
                            count++;
                        } else {
                            if (count == 4) {
                                printerCount = Integer.parseInt(splitString);
                                count++;
                            };
                        };
                    };
                };
            };
        };
    };
    
    private void saveGameToDataFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt", false));
        writer.write(currentScore + "," + gionCount + "," + gardenCount + "," + macBookCount + "," + printerCount);
        writer.close();
    };

    public void act() {
        timerUpgrade--;
        try{
            saveGameToDataFile();
        }catch(Throwable err){
            System.out.println(err);
        };
        
        if (timerUpgrade == 0){
            currentScorePerSecond = (gionCount * 1) + (gardenCount * 10) + (macBookCount * 50) + (printerCount * 200);
            currentScore = currentScore + currentScorePerSecond;

            timerUpgrade = 60;
        };    
    };
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Cookie cookie = new Cookie();
        addObject(cookie,364,466);
        CurrentScoreText currentScoreText = new CurrentScoreText(currentScore);
        addObject(currentScoreText,369,130);
        CookiesPerSecondText cookiesPerSecondText = new CookiesPerSecondText(currentScorePerSecond);
        addObject(cookiesPerSecondText, 369, 180);
        UpgradeCountText upgradeCountText = new UpgradeCountText(gionCount, "gion");
        addObject(upgradeCountText,920,160);
        UpgradeCountText upgradeCountText2 = new UpgradeCountText(gardenCount, "garden");
        addObject(upgradeCountText2,920,260);
        UpgradeCountText upgradeCountText3 = new UpgradeCountText(macBookCount, "macBook");
        addObject(upgradeCountText3,920,360);
        UpgradeCountText upgradeCountText4 = new UpgradeCountText(printerCount, "printer");
        addObject(upgradeCountText4,920,460);
        UpgradePriceText upgradePriceText = new UpgradePriceText(gionCount, "gion");
        addObject(upgradePriceText,1150,160);
        UpgradePriceText upgradePriceText2 = new UpgradePriceText(gardenCount, "garden");
        addObject(upgradePriceText2,1150,260);
        UpgradePriceText upgradePriceText3 = new UpgradePriceText(macBookCount, "macBook");
        addObject(upgradePriceText3,1150,360);
        UpgradePriceText upgradePriceText4 = new UpgradePriceText(printerCount, "printer");
        addObject(upgradePriceText4,1150,460);
        UpgradeButton upgradeButton1 = new UpgradeButton("gion");
        addObject(upgradeButton1,830,160);
        UpgradeButton upgradeButton2 = new UpgradeButton("garden");
        addObject(upgradeButton2,830,260);
        UpgradeButton upgradeButton3 = new UpgradeButton("macbook");
        addObject(upgradeButton3,830,360);
        UpgradeButton upgradeButton4 = new UpgradeButton("printer");
        addObject(upgradeButton4,830,460);
    }
}
