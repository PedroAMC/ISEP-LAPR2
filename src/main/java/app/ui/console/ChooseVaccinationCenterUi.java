package app.ui.console;

import app.controller.ChooseVaccinationCenterController;
import app.domain.model.dto.centers.VaccinationCenterDto;
import app.domain.shared.Constants;
import app.ui.console.utils.Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class ChooseVaccinationCenterUi implements Runnable{

    private ChooseVaccinationCenterController controller;

    public ChooseVaccinationCenterUi() {
        this.controller = new ChooseVaccinationCenterController();
    }

    @Override
    public void run() {

        List<VaccinationCenterDto> centers = controller.getListOfCenters();
        System.out.println(centers);


        Properties props = new Properties();
        // Read configured values
        try
        {
            InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
            props.load(in);
            in.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        props.setProperty(Constants.VACCINATION_CENTER, centers.get(Utils.selectsIndex(centers)).getName());

        try {
            props.store(new FileOutputStream(Constants.PARAMS_FILENAME),null);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
