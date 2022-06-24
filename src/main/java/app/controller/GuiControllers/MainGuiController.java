package app.controller.GuiControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainGuiController {

    /**
     * Controller Class of the graphical user interface for the main menu
     *
     * @author Pedro Campos <1211511@isep.ipp.pt> */


    @FXML
    private Button loginButton;

    @FXML
    private Button showDevButton;

    @FXML
    void doLogin(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Login.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.hide();

        Scene scene = new Scene(root);
        Stage login = new Stage();
        login.setScene(scene);
        login.setTitle("Login");
        login.show();

    }

    @FXML
    void showDev(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/DevTeam.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) showDevButton.getScene().getWindow();
        stage.hide();

        Scene scene = new Scene(root);
        Stage devTeam = new Stage();
        devTeam.setScene(scene);
        devTeam.setTitle("Dev Team");
        devTeam.setAlwaysOnTop(true);
        devTeam.show();

    }

}
