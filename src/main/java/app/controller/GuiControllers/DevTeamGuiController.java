package app.controller.GuiControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DevTeamGuiController {

    /**
     * Controller Class for the dev team graphical interface
     *
     * @author Pedro Campos <1211511@isep.ipp.pt> */

    @FXML
    private Button goBackButton;

    @FXML
    void goBack(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Main.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) goBackButton.getScene().getWindow();
        stage.hide();

        Scene scene = new Scene(root);
        Stage main = new Stage();
        main.setScene(scene);
        main.setTitle("Login");
        main.setAlwaysOnTop(true);
        main.show();

    }


}
