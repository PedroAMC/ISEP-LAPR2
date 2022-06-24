package app.ui.console;

import app.domain.utils.ReadCsvPerformance;
import app.ui.console.utils.Utils;
import app.ui.gui.StatisticsGui;

import java.util.ArrayList;
import java.util.List;

public class CoordinatorUi implements Runnable {
    /**
     *
     * @author Miguel Ferreira <1211488@isep.ipp.pt>
     * @author Pedro Campos <1211511@isep.ipp.pt>
     */

    public CoordinatorUi()
    {
    }

    public void run()
    {
        new ChooseVaccinationCenterUi().run();
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Check/Export Vaccination Statistics", new StatisticsUI()));
        options.add(new MenuItem("Analyze Center Performance", new AnalyzeCenterPerformanceUi()));
        options.add(new MenuItem("Import Data", new ImportLegacyDataUi()));



        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nCoordinator Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }

}
