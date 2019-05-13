/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seggleston_5_javfxgame;

import java.io.InputStream;
import java.net.URL;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import seggleston_5_javfxgame.*;

/**
 *
 * @author seane1001
 */
public class SEggleston_5_JavFXGame extends Application {

    @FXML
    private AnchorPane rootPane;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //      Player test = new Player("McMillen", "Soldier", "Lone Wolf", 18, 16, 4, 14, 10, true);
        //     Hero test1 = new Hero();
        //     PlayerCharacter test2 = new PlayerCharacter("Test", "Test1", "Test2", 10,10,10,10,10,10,10,10);

        Parent root = FXMLLoader.load(getClass().getResource("TitleScreen.fxml"));
//FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource(
        //"TitleScreen.fxml"));
        //   AnchorPane titlescreen = fxmlloader.load();
        Scene startuptitle = new Scene(root);
        //      Parent root = FXMLLoader.load(getClass().getResource("FXMLtest.fxml"));
        //    Scene startup = new Scene(root);

        //  String syscheck = System.getProperty("os.name"); // Check OS
        //    System.out.println(syscheck);
        //   FXMLLoader loader = new FXMLLoader();
     /*   System.out.println(System.getProperty("user.dir"));
        StackPane stage1 = new StackPane();
        StackPane stage2 = new StackPane();
        StackPane stage3 = new StackPane();
        Scene scene = new Scene(stage1, 1024, 576); // SCENE, resolutionx, resolutiony
        //     Scene scene2 = new Scene(root, 1024, 576);
        Scene scene2 = new Scene(stage2, 1024, 576); // Application Window?
        Scene scene3 = new Scene(stage3, 1024, 576);
        //  loader.setLocation(getClass().getResource("src\\seggleston_5_javfxgame\\FXML.fxml")); LOOK AT LATER
        //   Parent stage3 = loader.load(); LOOK AT LATER
        //      Scene scene3 = new Scene(stage3); LOOK AT LATER

        //    Pane startgame = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        //     System.out.println(getClass().getResource("FXML.fxml"));
        //     startgame.getChildren().add(startgame);
        // Scene init done.
        // Beginning image init.
        String startimg = "file:src/resources/javafx_logo_color_1.jpg";
        String mapimg = "file:src/resources/North_Tyris_Elona_Plus.png";
        String homeimg = "file:src/resources/bg8.jpg";
        String davisimg = "file:src/resources/aLOq3U4.png";
        /*       if (syscheck.contains("Windows")) {
            //    File javafxlogo = new File("\\src\\Resources\\javafx_logo_color_1.jpg");
            //     File mapimg = new File("\\src\\Resources\\North_Tyris_Elonoa_Plus.png");
            // Image init done.
            startimg = startimg.replace("\\", "/");
            mapimg = mapimg.replace("\\", "/");
            homeimg = homeimg.replace("\\", "/");
            davisimg = davisimg.replace("\\", "/");
            System.out.print(startimg);
        } */
       /* Button btn = new Button();
        btn.setText("Map");
        btn.setOnAction((ActionEvent event) -> {
            System.out.println("Moving to MAP!");
            primaryStage.setScene(scene2);
            //           primaryStage.setScene(scene3); LOOK AT LATER
            primaryStage.show();
        });
        Button btn2 = new Button();
        btn2.setText("Enter");
        btn2.setOnAction((ActionEvent event2) -> {
            System.out.println("Moving to Your Home.");
            primaryStage.setScene(scene3);
            primaryStage.show();
        });

        Button btn3 = new Button();
        btn3.setText("Fight!");
        btn3.setOnAction((ActionEvent event3) -> {
            System.out.println("Fighting Paladin McMillen!");
            stage3.getChildren().remove(btn3);
            //       btn3.setTranslateX(50);
            //    btn3.setTranslateX(100);
            //      btn3.setTranslateY(100);
        });
        //   Image img = new Image(getClass().getClassLoader().getResourceAsStream("resources/javafx_logo_color_1.jpg"));
//    Image img = new Image(getClass().getResource("file:///\\resource\\javafx_logo_color_1.jpg").toURI().toURL());
// Image img = new Image("http://mikecann.co.uk/wp-content/uploads/2009/12/javafx_logo_color_1.jpg");
        Image img;
        img = new Image(startimg);
        //  img = new Image(System.getProperty("user.dir") + "\\src\\resources\\javafx_logo_color_1.jpg");
        ImageView imgView = new ImageView(img);
        imgView.setPreserveRatio(true);  // Preserve 16:9
        imgView.fitWidthProperty().bind(stage2.widthProperty()); // FIT the Image to the WIDTH given.
        imgView.fitHeightProperty().bind(stage2.heightProperty()); // FIT the Image to the HEIGHT given.
        stage1.getChildren().add(imgView); // ADD a ELEMENT to a PLANE (Scene)

        Image map = new Image(mapimg);
        ImageView mapView = new ImageView(map);
        mapView.setPreserveRatio(true);
        mapView.fitWidthProperty().bind(stage2.widthProperty());
        mapView.fitHeightProperty().bind(stage2.heightProperty());
        stage2.getChildren().add(mapView);

        Image home = new Image(homeimg);
        ImageView homeView = new ImageView(home);
        homeView.setPreserveRatio(true);
        homeView.fitWidthProperty().bind(stage3.widthProperty());
        homeView.fitHeightProperty().bind(stage3.heightProperty());
        stage3.getChildren().add(homeView);

        // @Credit to NecroMalkin: https://imgur.com/gallery/20jV2kW 
        Image davis = new Image(davisimg);
        ImageView davisView = new ImageView(davis);
        stage3.getChildren().add(davisView);
        //  Image home = new Image("file:src\\resources\\")
        primaryStage.setTitle("@ Adventures"); // Set title of application.

        //  primaryStage.show(); // Show it to program / player.
        stage1.getChildren().add(btn);
        stage2.getChildren().add(btn2);
        stage3.getChildren().add(btn3);
*/
        //       AnchorPane root = FXMLLoader.load(getClass().getResource("FXML1.fxml"));
        primaryStage.setScene(startuptitle); // Different 'panels'
//        primaryStage.minWidthProperty().bind(startuptitle.heightProperty().multiply(2));
        //      primaryStage.minHeightProperty().bind(startuptitle.widthProperty().divide(2));
        primaryStage.show();
    }

    // Thank you to Hussein Saied https://stackoverflow.com/q/33748127
    /*     @FXML Pane stage3; 
    public void loadFxml(ActionEvent event) throws IOException {
        Pane newLoadedPane = FXMLLoader.load(getClass().getResource("file:resources/fxml.fxml"));
        stage3.getChildren().add(newLoadedPane);
    }
     */
    public void startup() {
        //       AnimationTimer timer = new MyTimer();

        //      timer.start();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /*    FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource(
                "CharacterCreate.fxml"));
        fxmlloader.setController(this);
        AnchorPane root = fxmlloader.load();
        Scene startup = new Scene(root); 
     */
 /*
    private void loadSecond(ActionEvent event) throws IOException {
        Parent LoadSecond = FXMLLoader.load(getClass().getResource(""));
        Scene LoadSecondS = new Scene(LoadSecond);
        // rootPane.getChildren().setAll(pane);
     //   AnchorPane root = .load();
        
    }
     */
 /*   static public Stage getPrimaryStage() {
        return SEggleston_5_JavFXGame.;
    }*/
}
