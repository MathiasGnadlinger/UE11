package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * @author Mathias Gnadlinger
 * @version 11, 14.01.2021
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Controller.show(primaryStage);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
