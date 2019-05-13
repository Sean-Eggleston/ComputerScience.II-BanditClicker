/**
 * Sample Skeleton for 'TitleScreen.fxml' Controller Class
 */
package seggleston_5_javfxgame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class TitleScreenController {

    @FXML
    AnchorPane rootPane;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ImageView Hero;

    @FXML
    void loadSecond(ActionEvent event) throws IOException {
        System.out.println("You clicked a button.");
        AnchorPane pane = FXMLLoader.load(getClass().getResource("CharacterPickRevise.fxml"));
        rootPane.getChildren().setAll(pane);
        /*FXMLLoader fxmlloader2 = new FXMLLoader(getClass().getResource(
                "CharacterCreate.fxml"));
        AnchorPane cc = fxmlloader2.load();
        Scene ccscene = new Scene(cc); */
 /*      primaryStage.setScene(ccscene); // Different 'panels'
        primaryStage.show();
         */

    }

    void initialize() {
        Media media = new Media("file:src/audio/Prophecy.mp3"); 
        MediaPlayer player = new MediaPlayer(media);
        player.play();
    }
}
