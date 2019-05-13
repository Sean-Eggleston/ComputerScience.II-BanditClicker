/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seggleston_5_javfxgame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author sean-e
 */
public class CharacterPickReviseController implements Initializable {

    public int playerHitDice = 0;
    public String playerNAM = "";
    public String playerCLA = "";
    public String playerJOB = "";
    public int playerSTR = 0;
    public int playerAGI = 0;
    public int playerMAG = 0;
    public int playerCON = 0;
    public boolean alreadyvisible = false;

    @FXML
    ImageView Background;
    @FXML
    ImageView GlowWAR;
    @FXML
    ImageView WAR;
    @FXML
    Text Cla;
    @FXML
    Text Job;
    @FXML
    Text STR;
    @FXML
    Text AGI;
    @FXML
    Text MAG;
    @FXML
    Text CON;
    @FXML
    Button Create;
    @FXML
    ImageView StatBackground;
    @FXML
    AnchorPane rootPane;
    @FXML
    Text NameTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
    }

    @FXML
    private void stopGlowWAR(MouseEvent event) {

    }

    @FXML
    private void glowYellowWAR(MouseEvent event) {

    }

    @FXML
    void showStatsWAR(MouseEvent event) {
        NameTxt.setText("Name: Spartan");
        GlowWAR.setVisible(true);
        playerSTR = 16;
        playerAGI = 12;
        playerMAG = 6;
        playerCON = 14;
        playerCLA = "Warrior";
        playerJOB = "Frontline";
        Cla.setText("Class: " + playerCLA);
        Job.setText("Job: " + playerJOB);
        STR.setText("STR: " + playerSTR);
        AGI.setText("DR: " + (((playerAGI - 10) / 2))*3);
        MAG.setText("DMG: " + (((playerSTR - 10) / 2)+1) + "-" + (((playerSTR-10) / 2) + 6));
        CON.setText("CON: " + playerCON);
        playerHitDice = 10;
        if (!alreadyvisible) {
            NameTxt.setVisible(true);
            StatBackground.setVisible(true);
            Cla.setVisible(true);
            Job.setVisible(true);
            STR.setVisible(true);
            AGI.setVisible(true);
            MAG.setVisible(true);
            CON.setVisible(true);
            Create.setVisible(true);
            alreadyvisible = true;
        }
    }

    @FXML
    private void stopGlowSorc(MouseEvent event) {

    }

    @FXML
    private void GlowSorc(MouseEvent event) {

    }

    @FXML
    void showStatsSORC(MouseEvent event) {
        GlowWAR.setVisible(false);
  
        playerSTR = 6;
        playerAGI = 14;
        playerMAG = 16;
        playerCON = 12;
        playerCLA = "Sorcerer";
        playerJOB = "Caster";
        Cla.setText("Class: " + playerCLA);
        Job.setText("Job: " + playerJOB);
        STR.setText("STR: " + playerSTR);
        AGI.setText("AGI: " + playerAGI);
        MAG.setText("MAG: " + playerMAG);
        CON.setText("CON: " + playerCON);
        playerHitDice = 8;
        if (!alreadyvisible) {
            NameTxt.setVisible(true);
            StatBackground.setVisible(true);
            Cla.setVisible(true);
            Job.setVisible(true);
            STR.setVisible(true);
            AGI.setVisible(true);
            MAG.setVisible(true);
            CON.setVisible(true);
            Create.setVisible(true);
            alreadyvisible = true;
        }
    }

    @FXML
    void NextScreen(ActionEvent event) throws IOException {
        if (playerCLA != "") {
            //      playerNAM = Name.getText();
//(String name, String PlClass, String Job, int STR, int AGI, int MAG, int CON, int HitDie, boolean alive) {
            //      Player player = new Player(playerNAM, playerCLA, playerJOB, playerSTR, playerAGI, playerMAG, playerCON, playerHitDice, true);
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Stage1.fxml"));
            rootPane.getChildren().setAll(pane);
        } else {
            System.out.println("Please pick a character first.");
        }
    }
}
