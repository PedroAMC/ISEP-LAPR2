package app.controller.GuiControllers;

import app.controller.coordinator.AnalyzeCenterPerformanceController;
import app.domain.model.data.centers.VaccinationCenter;
import app.domain.shared.Constants;
import app.domain.utils.Date;
import app.domain.utils.Hour;
import app.domain.utils.TimeInterval;
import app.domain.utils.TimeSlot;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;


/**
 * Controller Class of the graphical user interface for us16
 *
 * @author Pedro Campos <1211511@isep.ipp.pt> */

public class AnalyzeCenterPerformanceGuiController {

    String vaccinationCenterName = "";
    String algorithmToRun = "";

    @FXML
    private Button backButton;

    @FXML
    private Text centerLabel;

    @FXML
    private Button analyzeButton;

    @FXML
    private DatePicker dateChoice;

    @FXML
    private ChoiceBox<String> intervalBox;

    @FXML
    private ListView<String> leastEffectiveListView;

    @FXML
    private ListView<String> inputListView;

    @FXML
    public void initialize() {

        intervalBox.getItems().add("1");
        intervalBox.getItems().add("5");
        intervalBox.getItems().add("10");
        intervalBox.getItems().add("20");
        intervalBox.getItems().add("30");

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

        leastEffectiveListView.setVisible(false);
        inputListView.setVisible(false);


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



    @FXML
    void analyze(ActionEvent event) throws IOException {

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


        AnalyzeCenterPerformanceController analyzeCenterPerformanceController = new AnalyzeCenterPerformanceController();

        VaccinationCenter vaccinationCenter = analyzeCenterPerformanceController.getVaccinationCenter(vaccinationCenterName);


        LocalDate localDate = dateChoice.getValue();
        Date selectedDate = new Date(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear());

        int selectedTimeInterval = Integer.parseInt(intervalBox.getSelectionModel().getSelectedItem());

        boolean isValidDate;

        try {
            isValidDate = analyzeCenterPerformanceController.verifyInputDate(selectedDate, vaccinationCenter);
        } catch (IllegalArgumentException e){

            isValidDate = false;

        }

        if (!isValidDate){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("That date doesn't have any vaccine administrations for that center, please input another date.");
            alert.showAndWait();
        }
        else {
            if(algorithmToRun.equals("BruteForce")){
                List<TimeSlot> inputList = analyzeCenterPerformanceController.createInputList(selectedTimeInterval, selectedDate, vaccinationCenter);
                TimeInterval leastEffectiveTimeInterval = analyzeCenterPerformanceController.determineLeastEffectiveTimeInterval(inputList);
                List<TimeSlot> leastEffectiveSlots = leastEffectiveTimeInterval.getSlots();



                ObservableList<String> slots = FXCollections.observableArrayList();


                for (int i = 0; i < inputList.size(); i++) {
                    slots.add(inputList.get(i).toString());
                }

                inputListView.setItems(slots);


                ObservableList<String> leastEffective = FXCollections.observableArrayList();

                for (int i = 0; i < leastEffectiveSlots.size(); i++) {
                    leastEffective.add(leastEffectiveSlots.get(i).toString());
                }

                leastEffectiveListView.setItems(leastEffective);
                //inputListView.setVisible(true);
                //leastEffectiveListView.setVisible(true);


                FXMLLoader loader = new FXMLLoader(getClass().getResource("/AnalyzeCenterPerformanceResults.fxml"));
                Parent root = loader.load();
                AnalyzeCenterPerformanceResultsGuiController controller = loader.<AnalyzeCenterPerformanceResultsGuiController>getController();
                controller.setSlots(slots);
                controller.setLeastEffective(leastEffective);
                Hour timeIntervalEnd = new Hour(leastEffectiveSlots.get(leastEffectiveSlots.size()-1).getTime().addMinutes(selectedTimeInterval));
                controller.setIntervalLabelString("The vaccination center was less effective in responding from " + leastEffectiveSlots.get(0).getTime() + " to " + timeIntervalEnd);
                controller.setSumLabelString("Least effective time interval list sum: " + leastEffectiveTimeInterval.getSum());
                Stage stage = (Stage) backButton.getScene().getWindow();
                stage.hide();
                Scene scene = new Scene(root);
                Stage login = new Stage();
                login.setScene(scene);
                login.setTitle("Login");
                login.show();


            } else if (algorithmToRun.equals("Benchmark")) {

                int[] inputList = analyzeCenterPerformanceController.createInputListForBenchmark(selectedTimeInterval, selectedDate, vaccinationCenter);

                int sum = 0;

                ObservableList<String> slots = FXCollections.observableArrayList();
                ObservableList<String> leastEffective = FXCollections.observableArrayList();

                for (int i = 0; i < inputList.length; i++) {
                    slots.add(String.valueOf(inputList[i]));
                }

                int[] leastEffectiveTimeInterval = analyzeCenterPerformanceController.sum(inputList);
                for (int i = 0; i < leastEffectiveTimeInterval.length; i++) {
                    sum += leastEffectiveTimeInterval[i];
                    leastEffective.add(String.valueOf(leastEffectiveTimeInterval[i]));
                }


                FXMLLoader loader = new FXMLLoader(getClass().getResource("/AnalyzeCenterPerformanceResults.fxml"));
                Parent root = loader.load();
                AnalyzeCenterPerformanceResultsGuiController controller = loader.<AnalyzeCenterPerformanceResultsGuiController>getController();
                controller.setSlots(slots);
                controller.setLeastEffective(leastEffective);
                controller.setSumLabelString("Least effective time interval list sum: " + sum);
                Stage stage = (Stage) backButton.getScene().getWindow();
                stage.hide();
                Scene scene = new Scene(root);
                Stage login = new Stage();
                login.setScene(scene);
                login.setTitle("Login");
                login.show();



            }


        }


    }


}