package app.ui.console.SnsUser;

import app.controller.App;
import app.domain.model.data.snsuser.SnsUser;
import app.ui.console.MenuItem;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class SnsUserUi implements Runnable{

    public SnsUserUi() {
        //empty
    }

    @Override
    public void run() {

        App.getInstance().getCompany().getSnsUserStore().registerSnsUser(new SnsUser("Diogo","Rua de cima","Male","960168874","diogo@gmail.com","19/12/2002","167898423","16658688",1));


        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Schedule new Vaccine administration ", new ScheduleVaccineUi()));


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
