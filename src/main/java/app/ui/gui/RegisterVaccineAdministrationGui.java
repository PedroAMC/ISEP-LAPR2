package app.ui.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegisterVaccineAdministrationGui extends Application implements Runnable {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("RegisterVaccineAdministration.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Register Vaccine Administration");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setAlwaysOnTop(true);
    }

    @Override
    public void run() {
        launch();
    }

}