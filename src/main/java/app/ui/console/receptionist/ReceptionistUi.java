package app.ui.console.receptionist;

import app.controller.App;
import app.domain.model.data.snsuser.SnsUser;
import app.domain.shared.Constants;
import app.ui.console.ChooseVaccinationCenterUi;
import app.ui.console.MenuItem;
import app.ui.console.RegisterEmployeeUI;
import app.ui.console.utils.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author Diogo Teixeira <1200904@isep.ipp.pt>
 */
public class ReceptionistUi implements Runnable{

    /**
     *  Constructor for the receptionist ui class
     */


    public ReceptionistUi()
    {
    }

    /**
     * Method to run the user interface for any receptionist
     */

    @Override
    public void run() {

        new ChooseVaccinationCenterUi().run();
        Properties props = new Properties();
        // Read configured values
        try
        {
            InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
            props.load(in);
            System.out.println(props.get(Constants.VACCINATION_CENTER)); // apagar isto, apenas exemplo de como obter a string e mostrar que esta correta !
            in.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }


        App.getInstance().getCompany().getSnsUserStore().registerSnsUser(new SnsUser("Diogo","Rua de cima","Male","960168874","diogo@gmail.com","19/12/2002","167898423","16658688",1));

        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Register new Client ", new RegisterSnsUserUi()));
        options.add(new MenuItem("Register SNS user arrival.", new RegisterSnsUserArrivalUi()));
        options.add(new MenuItem("Schedule Vaccine", new ScheduleVaccineRecepcionistUi()));

        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nReceptionist Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
