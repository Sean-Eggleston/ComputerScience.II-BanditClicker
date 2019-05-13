/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seggleston_5_javfxgame;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * FXML Controller class
 *
 * @author sean-e
 */
public class Stage1Controller implements Initializable {

    // Essential Utilities
    int StageNum = 1; // Stage number for difficulty and overall game.
    private Random randnum = new Random(); // For random number generator.
    Timer timer; // For Timeout function; timed animations.
    int clicks = 0; // For indication of tutorial.
    boolean hasdied = false; // For shop tutorial.

    // FXML Objects are required to be declared within the controller in order to be manipulated.
    // It is a good practice to have every GUI element given a FX:ID.
    // @FXML declares that it is intended for the FXML file, without it SceneBuilder and the FXML it's self would not find it.
    // ImageView, Button, Text, etc.. are various object types used within both JavaFX and FXML.
    // private {ObjectType} [Given FX:ID]
    // *** FXML OBJECT INITIATION BEGINS *** //
    @FXML
    private ProgressBar PlayerAP;

    @FXML
    private ProgressBar PlayerXP;

    @FXML
    private ProgressBar PlayerHP;

    @FXML
    private ImageView idleBandit;

    @FXML
    private ImageView attackingBandit;

    @FXML
    private ImageView magicAttack;

    @FXML
    private ImageView attackingHero;

    @FXML
    private ImageView idleHero;

    @FXML
    private ProgressBar enemyHP;

    @FXML
    private ImageView dialogueBox;

    @FXML
    private Text actionText;

    @FXML
    private Button endTurnBtn;

    @FXML
    private ImageView injuredBandit;

    @FXML
    private ImageView deadBandit;

    @FXML
    private ImageView arrowImage;

    @FXML
    private Text clickText;

    @FXML
    private Button shopButton;

    @FXML
    private Button statsButton;

    @FXML
    private ImageView healingGlow;

    @FXML
    private ImageView dyingHero;

    @FXML
    private ImageView StatsBackground;

    @FXML
    private Text STRText;

    @FXML
    private Text AGIText;

    @FXML
    private Text CONText;

    @FXML
    private Text WEPText;

    @FXML
    private Button increaseSTRButton;

    @FXML
    private Button increaseAGIButton;

    @FXML
    private Button increaseCONButton;

    @FXML
    private Button increaseWEPButton;

    @FXML
    private Text PointsText;

    @FXML
    private Button hideButtons;
    // *** FXML OBJECT INITIATION ENDS *** //

    public int randnum(int i) {
        // nextInt(i) will give the next value from randnum conforming to range i
        return randnum.nextInt(i);
    }

    //*** Passing variables into new FXML Controller isn't working, looking into fix. ***\\ 
    //** I was only able to create only one class to work within the controller. Thus I chose the enemy class.**\\
    //* I will attempt to learn another way to create 2 classes within this controller. *\\
    // PLAYER
    String pName = "Spartan";
    int playerLevel = 1;     // Level
    int playerPoints = 1;
    int playerGold = 0;
    int playerSTR = 16;
    int playerAGI = 12;     // Stats
    int playerMAG = 6;
    int playerCON = 14;

    int pSTRMOD = ((16 - 10) / 2);
    int pAGIMOD = ((12 - 10) / 2);          // D&D Like Modifiers calc
    int pMAGMOD = ((12 - 10) / 2);
    int pCONMOD = ((12 - 10) / 2);

    double playerHP = ((double) (pCONMOD + 10) * playerLevel);
    double playerAP = ((playerLevel / 5) + 1);
    int playerDR = (pAGIMOD * 3);

    double[] levelList = {300, 900, 2700, 6500, 14000, 23000, 34000, 48000, 64000, 85000, 100000, 120000, 140000,
        165000, 195000, 225000, 305000, 355000};

    int toLevel = playerLevel - 1;
    double toNextLvl = levelList[toLevel];
    double playerXP = toNextLvl;

    double pCurrentAP = playerAP;
    double pCurrentHP = playerHP; // starting battle at refreshed resources.
    double pCurrentXP = 0.0;

    float pMaxAP = (float) playerAP;
    float pMaxHP = (float) playerHP; // For percentile calc
    float pMaxXP = (float) playerXP;

    int pWeaponDi = 6; // Player damage "dice".
    int lowestrange = (pSTRMOD + 1);
    int highestrange = (pSTRMOD + pWeaponDi);

    //ENEMY
    void playerStatsRefresh() {
        pSTRMOD = ((playerSTR - 10) / 2);
        pAGIMOD = ((playerAGI - 10) / 2);          // D&D Like Modifiers calc
        pCONMOD = ((playerCON - 10) / 2);
        playerDR = (pAGIMOD * 3);
        playerHP = ((double) (pCONMOD + 10) * playerLevel);
        System.out.println("Player HP: " + playerHP);
        playerAP = ((playerLevel / 5) + 1);
        System.out.println("Player AP: " + playerAP);
        pMaxAP = (float) playerAP;
        pMaxHP = (float) playerHP; // For percentile calc
        System.out.println("Player.Stats.Refresh done!");
    }

    Enemy enemy = new Enemy("Lightly Armored Bandit", ((double) randnum(5) + 6 + 1), 4, 2); // Starting enemy.
    // Default AP = 1?
    // Let's not delve into complexity of spells, yeah?

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void toAttackButton(MouseEvent event) {
        clicks++;
        if (clicks >= 10) {
            arrowImage.setVisible(false);
            clickText.setVisible(false);
        }
//        System.out.println((float) currentHP / playerMaxHP);
        //      System.out.println(((float) currentHP / 12.0f));
        // System.out.println((12*((float) currentHP/12.0f)));
        // System.out.println((double) (12*((float) currentHP/12.0f)));
        // playerisAttacking();
        if (pCurrentHP > 0) {
            if (pCurrentAP >= 1) {
                playerisAttacking();
                //actionText.setText("Hero deals " + playerDamage() + " to " + eName + "!");

                //     PlayerHP.setProgress((float) currentHP / playerMaxHP);
                //      PlayerAP.setProgress((float) currentAP / playerMaxAP);
            } else {
                /*        attackingHero.setVisible(false);
                magicAttack.setVisible(false);
                idleHero.setVisible(true);
              actionText.setText("You do not have enough Action Points to do that...");
                endTurnBtn.setVisible(true);
                 */
            }
        }
    }

    void playerisAttacking() {
        attackingHero.setVisible(true);
        attackingBandit.setVisible(false);
        idleHero.setVisible(false);
        magicAttack.setVisible(true);
        Timeout(heroattack, 1);
        pCurrentAP = pCurrentAP - 1;
        PlayerAP.setProgress((float) pCurrentAP / pMaxAP);
        enemytakesdamage();
        if (pCurrentAP <= 0) {
            enemyattacks();
            refreshplayer();
        }
    }

    void enemytakesdamage() {
        int thisturndamage = DamageCalc(pWeaponDi, pSTRMOD); // Random num seed.
        // System.out.println(thisturndamage); // Debug
        // System.out.println(enemy.geteCurrentHP()); // Debug
        String actiontext = pName + " deals "; // Start system log...
        enemy.seteCurrentHP(enemy.geteCurrentHP() - thisturndamage); // Enemy takes damage, set accordingly.
        // System.out.println(enemy.geteCurrentHP()); // Debug.
        actiontext = actiontext + thisturndamage + " to " + enemy.geteName(); // Continue log...
        if ((int) enemy.geteCurrentHP() <= 0) { // IF <Kills enemy>
            actiontext = actiontext + ", killing it!"; // fin log
            enemyHP.setProgress(0);
            idleBandit.setVisible(false); // Clean animations
            injuredBandit.setVisible(false);
            attackingBandit.setVisible(false);
            deadBandit.setVisible(true); // Play dead animation.
            playerGold = playerGold + enemy.getGoldreward();
            pCurrentXP = pCurrentXP + enemy.getXpreward();
            System.out.println(pCurrentXP);
            System.out.println(playerGold);
            System.out.println("To get to new Level: " + toNextLvl);
            if (pCurrentXP / pMaxXP >= 1) {
                playerLevel++;
                playerPoints++;
                toLevel++;
                toNextLvl = levelList[toLevel];
                pMaxXP = (float) toNextLvl;
                playerAP = ((playerLevel / 5) + 1);
                playerStatsRefresh();
            }
            PlayerXP.setProgress((float) pCurrentXP / pMaxXP);
            Timeout(newEnemy, 1); // Wait <1-2> seconds, execute Runnable <newEnemy>
        } else {
            actiontext = actiontext + "!"; // fin log
            enemyHP.setProgress((float) enemy.geteCurrentHP() / enemy.geteMaxHP()); // Set percentile hp accordingly
            if ((float) enemy.geteCurrentHP() / enemy.geteMaxHP() <= 0.50) { // HP less than 50% = Trigger animation
                idleBandit.setVisible(false);
                injuredBandit.setVisible(true);
            }
        }
        actionText.setText(actiontext); // Print action log to game log...
    }

    int DamageCalc(int di, int STRMOD) { // For random number generation.

        int incomingdmg = randnum((di - 1)) + STRMOD + 1; // 9-4==rand(5), +3+1, Range of 4-9.
        return incomingdmg;

    }

    @FXML
    void endTurn(ActionEvent event) {
        enemyattacks(); // DEPRICATED CODE
    }

    void enemyattacks() {
        if (enemy.geteCurrentHP() > 0) { // IF ACTUALLY ALIVE
            idleBandit.setVisible(false);
            injuredBandit.setVisible(false);
            attackingBandit.setVisible(true); // Close all other anim, trigger attack animation.
            int enemydmg = DamageCalc(enemy.geteWeaponDi(), enemy.geteSTRMOD()); // Save random damage calc.
            enemydmg = enemydmg - playerDR;
            if (enemydmg < 0) {
                enemydmg = 0;
            }
            String eActiontext = enemy.geteName() + " deals ";
            pCurrentHP = pCurrentHP - enemydmg;
            eActiontext = eActiontext + enemydmg + " to " + pName;
            if ((int) pCurrentHP <= 0) {
                eActiontext = eActiontext + ", killing " + pName + "!!!";
                PlayerHP.setProgress(0);
                idleHero.setVisible(false);
                attackingHero.setVisible(false);
                magicAttack.setVisible(false);
                dyingHero.setVisible(true);
                healingGlow.setVisible(true);
                Timeout(playerdeathsetup, 1);
                Timeout(playerdeath, 4);
            } else {
                eActiontext = eActiontext + "!";
                PlayerHP.setProgress((float) pCurrentHP / pMaxHP);
            }
            actionText.setText(eActiontext);
            Timeout(enemyattack, 1);
        } else {
            // start new enemy...
        }
    }

    void refreshplayer() {
        pCurrentAP = pMaxAP;
        PlayerAP.setProgress((float) pCurrentAP / pMaxAP);
    }

    void resetplayer() {
        pCurrentHP = pMaxHP;
        pCurrentAP = pMaxAP;

        PlayerAP.setProgress((float) pCurrentAP / pMaxAP);
        PlayerHP.setProgress((float) pCurrentHP / pMaxHP);
    }

    void Timeout(Runnable task, int seconds) {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.schedule(task, seconds, TimeUnit.SECONDS);
        scheduler.shutdown();
    }

    Runnable heroattack = () -> { // Lambda expression to run...
        attackingHero.setVisible(false);
        magicAttack.setVisible(false);
        if (pCurrentHP > 0) {
            idleHero.setVisible(true);
        }
    };

    Runnable newEnemy = () -> {
        StageNum++; // Stage Number
        int EnhancementLevel = StageNum - 1; // *** Overall enhancement grade to increase difficulty. ***
        enemy.seteName(enemy.getOriginName() + " +" + EnhancementLevel); // Indicates to player enhancement level via name.
        enemy.seteCurrentHP(((double) randnum(5) + 6 + 1 + EnhancementLevel)); // HP goes up by one every enhancement level.
        enemy.seteMaxHP((float) enemy.geteCurrentHP()); // Re-set MAX HP for percentile recalculation.
        if (EnhancementLevel % 5 == 0) {
            enemy.seteWeaponDi(enemy.getOriginWeaponDi() + (EnhancementLevel / 5)); // 1:5 Ratio for incremental weapon di increase.
        }
        if (EnhancementLevel % 10 == 0) {
            enemy.seteSTRMOD(enemy.getOriginSTRMOD() + (EnhancementLevel / 10)); // 1:10 due to guranteed damage increase.
        }
        enemy.setGoldreward(enemy.getGoldreward() + EnhancementLevel);
        enemy.setXpreward(enemy.getXpreward() + EnhancementLevel);
        enemyHP.setProgress(1);
        deadBandit.setVisible(false);
        idleBandit.setVisible(true);
        resetplayer();
    };

    Runnable enemyattack = () -> {
        attackingBandit.setVisible(false);
        if (enemy.geteCurrentHP() > 0) {
            if ((float) enemy.geteCurrentHP() / enemy.geteMaxHP() <= 0.50) {
                injuredBandit.setVisible(true);
            } else {
                idleBandit.setVisible(true);
            }
        } else {
            deadBandit.setVisible(true);
        }
    };
    
    Runnable playerdeathsetup = () -> {
      actionText.setText("Healing... Going back 5 enhancements...");
    };

    Runnable playerdeath = () -> {
        StageNum = StageNum - 5;
        idleBandit.setVisible(false);
        injuredBandit.setVisible(false);
        deadBandit.setVisible(false);
        Timeout(newEnemy, 1);
        dyingHero.setVisible(false);
        healingGlow.setVisible(false);
        resetplayer();
        idleHero.setVisible(true);
    };

    void StatsTextBuffer() {
        PointsText.setText("Points to Spend: " + playerPoints);
        STRText.setText("STR: " + playerSTR + ", +" + pSTRMOD);
        AGIText.setText("DR: " + playerDR + " Dmg Resist");
        CONText.setText("CON: " + playerCON + ", +" + pCONMOD);
        WEPText.setText("WEP: " + (pSTRMOD + 1) + "-" + (pSTRMOD + pWeaponDi) + " Dmg");
    }

    @FXML
    void increaseAGI(ActionEvent event) {
        if (playerPoints > 1) {
            playerAGI = playerAGI + 2;
            playerPoints = playerPoints - 2;
            playerStatsRefresh();
            StatsTextBuffer();
        } else {
            System.out.println("Sorry, you do not have enough points for this!");
        }
    }

    @FXML
    void increaseCON(ActionEvent event) {
        if (playerPoints > 1) {
            playerCON = playerCON + 2;
            playerPoints = playerPoints - 2;
            playerStatsRefresh();
            StatsTextBuffer();
        } else {
            System.out.println("Sorry, you do not have enough points for this!");
        }
    }

    @FXML
    void increaseSTR(ActionEvent event) {
        if (playerPoints > 1) {
            playerSTR = playerSTR + 2;
            playerPoints = playerPoints - 2;
            playerStatsRefresh();
            StatsTextBuffer();
        } else {
            System.out.println("Sorry, you do not have enough points for this!");
        }
    }

    @FXML
    void increaseWEP(ActionEvent event) {
        if (playerPoints > 0) {
            pWeaponDi++;
            playerPoints--;
            playerStatsRefresh();
            StatsTextBuffer();
        } else {
            System.out.println("Sorry, you do not have enough points for this!");
        }
    }

    void UIElementsVisi(boolean first, boolean second) {
        StatsBackground.setVisible(first);
        STRText.setVisible(first);
        AGIText.setVisible(first);
        CONText.setVisible(first);
        WEPText.setVisible(first);
        increaseSTRButton.setVisible(first);
        increaseAGIButton.setVisible(first);
        increaseCONButton.setVisible(first);
        increaseWEPButton.setVisible(first);
        PointsText.setVisible(first);
        statsButton.setVisible(second);
        hideButtons.setVisible(first);
    }

    @FXML
    void openLevelUp(ActionEvent event) {
        StatsTextBuffer();
        UIElementsVisi(true, false);
    }

    @FXML
    void closeLevelUp(ActionEvent event) {
        UIElementsVisi(false, true);
    }

    class Enemy {

        private final String OriginName;
        private String eName;
        private double eCurrentHP;
        private float eMaxHP;
        private int eWeaponDi;
        private int eSTRMOD;
        private int goldreward;
        private int xpreward;
        private final int OriginWeaponDi;
        private final int OriginSTRMOD;

        public Enemy(String eName, double eCurrentHP, int eWeaponDi, int eSTRMOD) {
            this.eName = eName;
            this.eCurrentHP = eCurrentHP;
            this.eMaxHP = (float) eCurrentHP;
            this.eWeaponDi = eWeaponDi;
            this.eSTRMOD = eSTRMOD;
            this.OriginName = eName;
            this.goldreward = 10;
            this.OriginWeaponDi = eWeaponDi;
            this.OriginSTRMOD = eSTRMOD;
            this.xpreward = 5;
        }

        public void setXpreward(int xpreward) {
            this.xpreward = xpreward;
        }

        public int getXpreward() {
            return xpreward;
        }

        public int getOriginWeaponDi() {
            return OriginWeaponDi;
        }

        public int getOriginSTRMOD() {
            return OriginSTRMOD;
        }

        public int getGoldreward() {
            return goldreward;
        }

        public void setGoldreward(int goldreward) {
            this.goldreward = goldreward;
        }

        public String getOriginName() {
            return OriginName;
        }

        public String geteName() {
            return eName;
        }

        public double geteCurrentHP() {
            return eCurrentHP;
        }

        public float geteMaxHP() {
            return eMaxHP;
        }

        public int geteWeaponDi() {
            return eWeaponDi;
        }

        public int geteSTRMOD() {
            return eSTRMOD;
        }

        public void seteName(String eName) {
            this.eName = eName;
        }

        public void seteCurrentHP(double eCurrentHP) {
            this.eCurrentHP = eCurrentHP;
        }

        public void seteMaxHP(float eMaxHP) {
            this.eMaxHP = eMaxHP;
        }

        public void seteWeaponDi(int eWeaponDi) {
            this.eWeaponDi = eWeaponDi;
        }

        public void seteSTRMOD(int eSTRMOD) {
            this.eSTRMOD = eSTRMOD;
        }

    }

}
