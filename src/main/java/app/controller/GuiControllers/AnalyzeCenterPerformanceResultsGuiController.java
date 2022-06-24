package app.controller.GuiControllers;

import app.domain.shared.Constants;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AnalyzeCenterPerformanceResultsGuiController {

    @FXML
    private Button backButton;

    @FXML
    private ListView<String> inputListView;

    @FXML
    private Text intervalLabel;

    @FXML
    private ListView<String> leastEffectiveListView;

    @FXML
    private Text listSumLabel;


    public void setInputListView(ListView<String> inputListView) {
        this.inputListView = inputListView;
    }

    public void setIntervalLabel(Text intervalLabel) {
        this.intervalLabel = intervalLabel;
    }

    public void setLeastEffectiveListView(ListView<String> leastEffectiveListView) {
        this.leastEffectiveListView = leastEffectiveListView;
    }

    public void setListSumLabel(Text listSumLabel) {
        this.listSumLabel = listSumLabel;
    }

    public String intervalLabelString;

    public String SumLabelString;

    public ObservableList<String> leastEffective;

    public ObservableList<String> slots;

    public void setLeastEffective(ObservableList<String> leastEffective) {
        this.leastEffective = leastEffective;
    }

    public void setSlots(ObservableList<String> slots) {
        this.slots = slots;
    }

    public void setIntervalLabelString(String intervalLabelString) {
        this.intervalLabelString = intervalLabelString;
    }

    public void setSumLabelString(String sumLabelString) {
        SumLabelString = sumLabelString;
    }



    @FXML private void initialize() {

        Platform.runLater(() -> {

            intervalLabel.setText(intervalLabelString);
            listSumLabel.setText(SumLabelString);
            inputListView.setItems(slots);
            leastEffectiveListView.setItems(leastEffective);


        });

    }
    @FXML
    void goBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AnalyzeCenterPerformance.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.hide();

        Scene scene = new Scene(root);
        Stage login = new Stage();
        login.setScene(scene);
        login.setTitle("Login");
        login.show();
    }

}
