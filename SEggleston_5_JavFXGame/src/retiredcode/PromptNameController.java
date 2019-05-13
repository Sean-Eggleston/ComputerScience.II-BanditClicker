/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retiredcode;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author seane1001
 */
public class PromptNameController implements Initializable {
    String playerrole = "";
    int playerstr = 0;
    int playerdex = 0;
    int playercon = 0;
    int playerwis = 0;
    int playerint = 0;
    int playercha = 0;
    int hitdice = 0;
    int playerHP = 0;
    int playerMP = 0;
    int playerAP = 0;

    @FXML
    AnchorPane rootPane;
    @FXML
    TextField textfield;
    @FXML
    private ComboBox<String> classField;
    @FXML
    private Text Pstr;

    @FXML
    private Text Pdex;

    @FXML
    private Text Pcon;

    @FXML
    private Text Pwis;

    @FXML
    private Text Pint;

    @FXML
    private Text Pcha;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        classField.getItems().removeAll(classField.getItems());
        classField.getItems().addAll("Choose One", "Soldier", "Sorcerer");
        classField.getSelectionModel().select("Choose One");
    }

    @FXML
    void displayStats(ActionEvent event) {
        if (classField.getValue() == "Soldier") {
            playerstr = 16;
            playerdex = 14;
            playercon = 14;
            playerwis = 8;
            playerint = 12;
            playercha = 10;
            playerrole = "Fighter";
            playerHP = 10 + ((playercon - 10)/2);
            playerMP = 0 + ((playerint - 10)/2);
            playerAP = 1;
        } else if (classField.getValue() == "Sorcerer") {
            playerstr = 8;
            playerdex = 14;
            playercon = 12;
            playerwis = 14;
            playerint = 16;
            playercha = 10;
            playerrole = "Caster";
            playerHP = 8 + ((playercon - 10)/2);
            playerMP = 2 + ((playerint - 10)/2);
            playerAP = 1;
        } else if (classField.getValue() == "Choose One") {
            playerstr = 0;
            playerdex = 0;
            playercon = 0;
            playerwis = 0;
            playerint = 0;
            playercha = 0;
            playerrole = "Unknown";
            playerHP = 0;
            playerMP = 0;
            playerAP = 0;
        }
        Pstr.setText("STR: " + playerstr);
        Pdex.setText("DEX: " + playerdex);
        Pcon.setText("CON: " + playercon);
        Pwis.setText("WIS: " + playerwis);
        Pint.setText("INT: " + playerint);
        Pcha.setText("CHA: " + playercha);
    }

    @FXML
    void loadSecond(ActionEvent event) throws IOException {
        //      System.out.println("You clicked a button.");
        String Name = textfield.getText();
        String Job = classField.getValue();
        String Role = playerrole;
        if (Job != "Choose One") {
            Pane pane = FXMLLoader.load(getClass().getResource(
                    "CharacterCreation.fxml"
            ));
            System.out.println("-------------");
            System.out.println("ADVENTURER PORTFOLIO");
            System.out.println("Full name: " + Name);
            System.out.println("Job name: " + Job);
            System.out.println("---------\nPhysical Ratings\n---------");
            System.out.println(Pstr.getText());
            System.out.println(Pdex.getText());
            System.out.println(Pcon.getText());
            System.out.println("---------\nMental Ratings\n---------");
            System.out.println(Pwis.getText());
            System.out.println(Pint.getText());
            System.out.println("---------\nSocial Ratings\n---------");
            System.out.println(Pcha.getText());
            rootPane.getChildren().setAll(pane);
            // Constructor: (String name, String job, String role, int HP, int MP, int AP, boolean alive)
//            Player player = new Player(Name, Job, Role, playerHP, playerMP, playerAP, true);
        } else {
            System.out.println("Please choose a class first.");
        }
    }   

    @FXML
    void SetName(InputMethodEvent event) {

    }

}
