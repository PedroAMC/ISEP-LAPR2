package app.ui.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ImportGui extends Application implements Runnable {

    /**
     * Class of the graphical user interface for us17
     *
     * @author Pedro Campos <1211511@isep.ipp.pt> */

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Import.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Import Data");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setAlwaysOnTop(true);
    }

    @Override
    public void run() {
        launch();
    }

}