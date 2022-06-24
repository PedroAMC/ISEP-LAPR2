package app.controller.GuiControllers;

import app.domain.utils.ReadCsvPerformance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CoordinatorGuiController {

    /**
     * Controller Class of the graphical user interface for the coordinator
     *
     * @author Pedro Campos <1211511@isep.ipp.pt> */

    @FXML
    private Button analyzeButton;

    @FXML
    private Button statisticsButton;

    @FXML
    private Button backButton;

    @FXML
    private Button importButton;

    @FXML
    void doAnalyze(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AnalyzeCenterPerformance.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) analyzeButton.getScene().getWindow();
        stage.hide();

        Scene scene = new Scene(root);
        Stage analyze = new Stage();
        analyze.setScene(scene);
        analyze.setTitle("Analyze Center Performance");
        analyze.show();



    }

    @FXML
    void doStatistics(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Statistics.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) statisticsButton.getScene().getWindow();
        stage.hide();

        Scene scene = new Scene(root);
        Stage statistics = new Stage();
        statistics.setScene(scene);
        statistics.setTitle("Statistics");
        statistics.show();
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Login.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.hide();

        Scene scene = new Scene(root);
        Stage login = new Stage();
        login.setScene(scene);
        login.setTitle("Login");
        login.show();
    }

    @FXML
    void doImport(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Import.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.hide();

        Scene scene = new Scene(root);
        Stage login = new Stage();
        login.setScene(scene);
        login.setTitle("Import Data");
        login.show();


    }
}
