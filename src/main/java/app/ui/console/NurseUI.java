package app.ui.console;
import app.controller.App;
import app.domain.model.data.centers.VaccinationCenter;
import app.domain.model.dto.centers.VaccinationCenterDto;
import app.domain.shared.Constants;
import app.domain.store.center.VaccinationCenterStore;
import app.ui.console.nurse.VaccineAdministrationUi;
import app.ui.console.utils.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class NurseUI implements Runnable {

    public NurseUI (){
    }
    public void run (){
        new ChooseVaccinationCenterUi().run();
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Consult waiting room",new WaitingRoomUI()));
        options.add(new MenuItem("Register vaccine administration",new VaccineAdministrationUi()));
        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nNurse Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }


}