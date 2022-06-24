package app.controller.GuiControllers;

import app.controller.App;
import app.controller.center.StatisticsController;
import app.domain.model.data.centers.VaccinationCenter;
import app.domain.model.dto.centers.StatisticsDto;
import app.domain.model.dto.utils.DateDto;
import app.domain.model.dto.utils.IntegerDto;
import app.domain.shared.Constants;
import app.domain.store.center.StatisticsStore;
import app.domain.store.center.VaccinationCenterStore;
import app.domain.store.snsuser.SnsUserStore;
import app.domain.store.vaccine.VaccineAdministrationStore;
import app.domain.utils.Date;
import app.domain.utils.Pair;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

public class StatisticsGuiController implements Initializable {

    private final StatisticsController controller;

    public StatisticsGuiController() {
        this.controller = new StatisticsController();
    }


    @FXML
    private TextField text1;
    @FXML
    private TextField text2;
    @FXML
    private Button Button;
    @FXML
    private Button export;
    @FXML
    private Button goback;
    @FXML
    private ListView list;
    @FXML
    private Label lab;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Button Return;

    public String getVaccinationCenterName(){
        String vaccinationCenterName = "teste";

        Properties props = new Properties();
        // Read configured values
        try {
            InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
            props.load(in);
            vaccinationCenterName = (String) (props.get(Constants.VACCINATION_CENTER));
            in.close();
        } catch (
                IOException ex) {
            ex.printStackTrace();
        }
        return vaccinationCenterName;
    }


    public void executeAction(){
        boolean fileNameIsValid = false;
        while (!fileNameIsValid) {
            System.out.println();
            String fileName = text1.getText();
            try {
                fileNameIsValid =controller.verifyFileName(fileName);
            } catch (IllegalArgumentException exception) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("The name can't be in blank");
                alert.showAndWait();
            }
        }

        boolean timeIntervalIsValid = false;
        while (!timeIntervalIsValid) {
            String timeInterval=text2.getText();
            try {
                timeIntervalIsValid = controller.verifyTimeInterval(timeInterval);
            } catch (IllegalArgumentException exception) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                if(exception.getMessage().equals("First date is more recent than the second one")){
                    alert.setContentText("First date is more recent than the second one");
                }
                else{
                    alert.setContentText("Time Interval can't be in blank");
                }
                alert.setContentText(exception.getMessage());
                alert.showAndWait();


            }
        }
        String vaccinationCenterName=getVaccinationCenterName();
        StatisticsDto statisticsdto = controller.checkVaccinationStatistics(text2.getText(),vaccinationCenterName);
        List<Pair<DateDto, IntegerDto>> list1 = statisticsdto.getList();
        if(list1.isEmpty()){
            lab.setVisible(true);
        }
        else {
            text1.setVisible(false);
            text2.setVisible(false);
            Button.setVisible(false);
            label1.setVisible(false);
            label2.setVisible(false);
            Return.setVisible(false);
            list.setVisible(true);
            goback.setVisible(true);
            export.setVisible(true);
            list.setItems(FXCollections.observableList(controller.checkVaccinationStatistics(text2.getText(),vaccinationCenterName ).getList()));
        }
    }

    public void initialize(URL url, ResourceBundle resourceBundle){
        lab.setVisible(false);
        list.setVisible(false);
        export.setVisible(false);
        goback.setVisible(false);
        label3.setVisible(false);
    }


    public void export() throws IOException {
        String vaccinationCenterName=getVaccinationCenterName();
        StatisticsDto statisticsdto = controller.checkVaccinationStatistics(text2.getText(),vaccinationCenterName);
        if(controller.exportVaccinationStatistics(statisticsdto.getList(),text1.getText())){
            label3.setVisible(true);
        }
    }

    public void goBack(){
        list.setVisible(false);
        export.setVisible(false);
        goback.setVisible(false);
        text1.setVisible(true);
        text2.setVisible(true);
        Button.setVisible(true);
        label1.setVisible(true);
        label2.setVisible(true);
        Return.setVisible(true);
    }

    @FXML
    void Return(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Coordinator.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) Return.getScene().getWindow();
        stage.hide();

        Scene scene = new Scene(root);
        Stage login = new Stage();
        login.setScene(scene);
        login.setTitle("Login");
        login.setAlwaysOnTop(true);
        login.show();
    }

}
