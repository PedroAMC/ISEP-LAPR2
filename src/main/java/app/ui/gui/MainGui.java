package app.ui.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGui extends Application implements Runnable {
    /**
     * Class of the graphical user interface for the main menu
     *
     * @author Pedro Campos <1211511@isep.ipp.pt> */


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Main.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Main");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setAlwaysOnTop(true);
    }

    @Override
    public void run() {
        launch();
    }

}