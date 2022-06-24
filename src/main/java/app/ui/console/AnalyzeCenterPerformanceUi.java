package app.ui.console;

import app.controller.coordinator.AnalyzeCenterPerformanceController;
import app.domain.model.data.centers.VaccinationCenter;
import app.domain.shared.Constants;
import app.domain.utils.Date;
import app.domain.utils.Hour;
import app.domain.utils.TimeInterval;
import app.domain.utils.TimeSlot;
import app.ui.console.utils.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Year;
import java.util.*;

/**
 * Class of the user interface for us16
 *
 * @author Pedro Campos <1211511@isep.ipp.pt> */

public class AnalyzeCenterPerformanceUi implements Runnable {

    private final AnalyzeCenterPerformanceController analyzeCenterPerformanceController;

    /**
     *  Constructor for the coordinator ui class
     */

    public AnalyzeCenterPerformanceUi(){

        this.analyzeCenterPerformanceController = new AnalyzeCenterPerformanceController();

    }

    /**
     * Method to run the user interface for the analyze center performance function
     */


    @Override
    public void run(){

        String vaccinationCenterName = "";
        String algorithmToRun = "";
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



        VaccinationCenter vaccinationCenter = analyzeCenterPerformanceController.getVaccinationCenter(vaccinationCenterName);


        Date selectedDate = new Date(10,10,2010); // default value
        int selectedTimeInterval = -1;

        Scanner reader = new Scanner(System.in);
        System.out.println("---------- Analyze Center performance ----------");

        boolean isValidDate = false;

        int day = -1;
        int month = -1;
        int year = -1;


        System.out.println("Input the Date you desire to analyze: ");

        int numberOfTries = 1;

        while (!isValidDate && numberOfTries != 4){

            day = -1;
            month = -1;
            year = -1;

            while(day < 0 || day >31){
                System.out.println("Day: ");
                day = reader.nextInt();

            }

            while(month < 0 || month > 12){
                System.out.println("Month: ");
                month = reader.nextInt();
            }

            while (year < 0) {
                System.out.println("Year: ");
                year = reader.nextInt();
            }

            selectedDate = new Date(day, month, year);


            try {
                isValidDate = analyzeCenterPerformanceController.verifyInputDate(selectedDate, vaccinationCenter);
            } catch (IllegalArgumentException e){

                isValidDate = false;

            }


            if (!isValidDate){


                System.out.println("That date doesn't have any vaccine administrations for that center, please input another date.");
                System.out.println(3-numberOfTries + " attempts left");
                numberOfTries++;

            }

        }

        if (!isValidDate){
            System.out.println("Number of attempts exceeded, please try again.");

        } else {

            System.out.println("Select the time interval to be used in the analysis (minutes).");
            System.out.println("Option (1) - 30");
            System.out.println("Option (2) - 20");
            System.out.println("Option (3) - 10");
            System.out.println("Option (4) - 5");
            System.out.println("Option (5) - 1");

            int option = reader.nextInt();
            while (option != 1 && option != 2 && option != 3 && option != 4 && option != 5){
                System.out.println("invalid option, please select option 1, 2, 3, 4 or 5.");
                option = reader.nextInt();
            }

            switch (option){
                case 1: selectedTimeInterval = 30;
                    break;
                case 2: selectedTimeInterval = 20;
                    break;
                case 3: selectedTimeInterval = 10;
                    break;
                case 4: selectedTimeInterval = 5;
                    break;
                case 5: selectedTimeInterval = 1;
                    break;
            }


            System.out.println("Selected Date: " + day + "/" + month + "/" + year);
            System.out.println("Selected Time Interval: " + selectedTimeInterval);
            int validate = Utils.readIntegerFromConsole("Is the data correct? (1 - yes | 0 - no) ");

            if(validate == 1){

                if(algorithmToRun.equals("BruteForce")){
                    List<TimeSlot> inputList = analyzeCenterPerformanceController.createInputList(selectedTimeInterval, selectedDate, vaccinationCenter);
                    TimeInterval leastEffectiveTimeInterval = analyzeCenterPerformanceController.determineLeastEffectiveTimeInterval(inputList);
                    List<TimeSlot> leastEffectiveSlots = leastEffectiveTimeInterval.getSlots();



                    System.out.println("Input List: ");

                    for (int i = 0; i < inputList.size(); i++) {
                        int counter = inputList.get(i).getCounter();
                        Hour hour = inputList.get(i).getTime();
                        System.out.println(hour + ": " + counter);
                    }

                    System.out.println("Least effective time interval list: ");

                    for (int i = 0; i < leastEffectiveSlots.size(); i++) {
                        int counter = leastEffectiveSlots.get(i).getCounter();
                        Hour hour = leastEffectiveSlots.get(i).getTime();
                        System.out.println(hour + ": " + counter);
                    }

                    System.out.println("Least effective time interval list sum: " + leastEffectiveTimeInterval.getSum());
                    Hour timeIntervalEnd = new Hour(leastEffectiveSlots.get(leastEffectiveSlots.size()-1).getTime().addMinutes(selectedTimeInterval));
                    System.out.println("The vaccination center was less effective in responding from " + leastEffectiveSlots.get(0).getTime() + " to " + timeIntervalEnd);

                } else if (algorithmToRun.equals("Benchmark")) {

                    int[] inputList = analyzeCenterPerformanceController.createInputListForBenchmark(selectedTimeInterval, selectedDate, vaccinationCenter );

                    int sum = 0;
                    System.out.println("Input List: ");
                    for (int i = 0; i < inputList.length; i++) {
                        System.out.println(inputList[i]);

                    }

                    System.out.println("Least effective time interval list: ");

                    int[] leastEffectiveTimeInterval = analyzeCenterPerformanceController.sum(inputList);
                    for (int i = 0; i < leastEffectiveTimeInterval.length; i++) {
                        sum += leastEffectiveTimeInterval[i];
                        System.out.println(leastEffectiveTimeInterval[i]);
                    }

                    System.out.println("Least effective time interval list sum: " + sum);

                }

            }

        }

    }
}
