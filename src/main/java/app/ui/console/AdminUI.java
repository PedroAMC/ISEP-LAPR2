package app.ui.console;

import app.ui.console.SnsUser.ImportFileSnsUsersUI;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */

public class AdminUI implements Runnable{
    public AdminUI()
    {
    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("List Employees", new AdminListEmployeesUi()));
        options.add(new MenuItem("Register Employee", new RegisterEmployeeUI()));
        options.add(new MenuItem("Choose Vaccination Center",new ChooseVaccinationCenterUi()));
//        options.add(new MenuItem("Register Vaccination Center ", new RegisterVaccinationCenterUI()));

        //options.add(new MenuItem("Register new vaccine", new VaccineUI()));

        //options.add(new MenuItem("List and Register Vaccine Types", new RegisterVaccineTypeUI()));
        //options.add(new MenuItem("Register new vaccine", new RegisterVaccineUI()));
        options.add(new MenuItem("Import file to register SNS Users", new ImportFileSnsUsersUI()));

        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
