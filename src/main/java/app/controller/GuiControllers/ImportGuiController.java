package app.controller.GuiControllers;

import app.domain.shared.Constants;
import app.domain.utils.ReadCsvPerformance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ImportGuiController {

    /**
     * Controller Class of the graphical user interface for us17
     *
     * @author Pedro Campos <1211511@isep.ipp.pt> */

    @FXML
    private Text centerLabel;

    String vaccinationCenterName = "";
    String algorithmToRun = "";

    @FXML
    public void initialize() {


        Properties props = new Properties();
        // Read configured values
        try
        {
            InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
            props.load(in);
            vaccinationCenterName = (String)(props.get(Constants.VACCINATION_CENTER));
            algorithmToRun = (String)(props.get(Constants.ALGORITHM_TO_RUN));
            in.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }

        centerLabel.setText(vaccinationCenterName);

    }

    @FXML
    private Button backButton;


    @FXML
    private TextField fileField;

    @FXML
    private Button importButton;

    @FXML
    void doImport(ActionEvent event) {
        try{
            ReadCsvPerformance.readCsv(fileField.getText());

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    void goBack(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Coordinator.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.hide();

        Scene scene = new Scene(root);
        Stage login = new Stage();
        login.setScene(scene);
        login.setTitle("Login");
        login.setAlwaysOnTop(true);
        login.show();
    }


}
