package app.ui.console;

import app.controller.center.StatisticsController;
import app.domain.model.dto.centers.StatisticsDto;
import app.domain.model.dto.utils.DateDto;
import app.domain.model.dto.utils.IntegerDto;
import app.domain.shared.Constants;
import app.domain.utils.Pair;
import app.ui.console.utils.Utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;


/**
 * Class of the user interface for US05
 *
 * @author Miguel Ferreira <1211488@isep.ipp.pt>
 */

public class StatisticsUI implements Runnable {

   private final StatisticsController controller;

    /**
     * Constructor of the ui class
     */

    public StatisticsUI() {
        this.controller = new StatisticsController();
    }

    /**
     * Run method to run the ui necessary to check/export Vaccination Statistics
     */
    @Override
    public void run() {

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


        System.out.println("--------------------Statistics----------------------");

        System.out.println();

        boolean fileNameIsValid = false;

        String fileName = null;
        while (!fileNameIsValid) {
            System.out.println();
            fileName = Utils.readLineFromConsole("Write down the name of the file to export to");
            try {
                fileNameIsValid = controller.verifyFileName(fileName);
            } catch (IllegalArgumentException exception) {
                System.out.println();
                System.out.print("The File Name can't be in blank");
                System.out.println();
            }
        }


        boolean timeIntervalIsValid = false;

        String timeInterval = null;
        while (!timeIntervalIsValid) {
            System.out.println();
            timeInterval = Utils.readLineFromConsole("Write down the time interval(in numbers) in the respective form:\nFirst Date-Second Date (Day,Month,Year-Day,Month,Year)");
            try {
                timeIntervalIsValid = controller.verifyTimeInterval(timeInterval);
            } catch (IllegalArgumentException exception) {
                System.out.println();
                System.out.println(exception);
                System.out.println();
            }
        }

        String confirm = Utils.readLineFromConsole("Confirm the Data:\n" + "File Name: " + fileName + "\n" + "Time Interval: " + timeInterval + "\n" + "Yes(y) or No(n)\n");


        if (confirm.equals("y")) {
            StatisticsDto statisticsdto = controller.checkVaccinationStatistics(timeInterval, vaccinationCenterName);


            List<Pair<DateDto, IntegerDto>> list = statisticsdto.getList();
            if (list.isEmpty()) {
                System.out.println();
                System.out.println("There were no fully Vaccinated Users in the Time Interval you gave!");
            } else {

                String format = "%-20s%s%n";
                System.out.printf(format, "DATE", "Total Number of Fully Vaccinated Users");
                System.out.println("--------------------------------------------------");


                for (Pair<DateDto, IntegerDto> pair : list) {
                    DateDto date = pair.getFirst();
                    IntegerDto integer = pair.getSecond();
                    System.out.printf(format, date, integer);
                }

                System.out.println();

                String exportOption = Utils.readLineFromConsole("Do you want to export the Vaccinacion Statistics?Yes(y) or No(n)");
                if (exportOption.equals("y")) {
                    try {
                        controller.exportVaccinationStatistics(statisticsdto.getList(), fileName);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }
}

