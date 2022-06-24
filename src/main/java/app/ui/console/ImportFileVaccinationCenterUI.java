package app.ui.console;

import app.controller.ImportFileVaccinationCenterController;
import app.ui.console.utils.Utils;
import java.io.File;
import java.util.Scanner;

public class ImportFileVaccinationCenterUI implements Runnable{
    private final ImportFileVaccinationCenterController controller;

    public ImportFileVaccinationCenterUI(){
        this.controller = new ImportFileVaccinationCenterController();

    }


    @Override
    public void run() {
        File file;
        String filePath;
        boolean validFile;
        int sortingStyle;
        int increasingDecreasing;


        do{
            filePath = Utils.readLineFromConsole("Input path file");
            file = new File(filePath);
            validFile = controller.VerifyFile(file);
        }while (!validFile);



        //try{

            controller.SetFilePath(filePath);
            controller.CreateFileReader();

            if (controller.NumberOfLines() > 1){

                String[][] usersInfo = controller.SeparateInformation();

                System.out.println("Display information by:");
                sortingStyle = Utils.readIntegerFromConsole("\n1. Arrival Time\n2. Center Leaving Time");

                while (sortingStyle < 1 || sortingStyle > 2){

                    System.out.println("Please choose one of the available options");
                    sortingStyle = Utils.readIntegerFromConsole("\n1. Arrival Time\n2. Center Leaving Time");
                }

                increasingDecreasing = Utils.readIntegerFromConsole("\n1. Increasing\n2. Decreasing");

                while (increasingDecreasing < 1 || increasingDecreasing > 2){

                    System.out.println("Please choose one of the available options");
                    increasingDecreasing = Utils.readIntegerFromConsole("\n1. Increasing\n2. Decreasing");

                }


                if (sortingStyle == 1){


                } else {


                }


            } else {
                System.out.println("The file doesn't contain any information about SNS Users");
            }

        //} catch(Exception e) {
        //  e.getMessage();
        //System.out.println("File could not be read");
        //}

    }
}