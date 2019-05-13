package exampleFXCode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLExample extends Application {
    
    public static void main(String[] args) {
        Application.launch(FXMLExample.class, args);
    }
    
    @Override   
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource(
        "FXMLtest.fxml"));
        fxmlloader.setController(this);
   //     FXMLLoader test = new FXMLLoader;
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLtest.fxml"));
        AnchorPane root = fxmlloader.load();
        Scene scene = new Scene(root);
   //     scene.setRoot(FXMLLoader.load(getClass().getResource("FXMLtest.fxml")));
        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        
        stage.show();
    }
}

