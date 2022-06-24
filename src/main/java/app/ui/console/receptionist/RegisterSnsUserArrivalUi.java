package app.ui.console.receptionist;
import app.controller.snsuser.RegisterSnsUserArrivalController;
import app.domain.model.data.centers.VaccinationCenter;
import app.domain.shared.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

/**
 * Class of the user interface for us04
 *
 * @author Pedro Campos <1211511@isep.ipp.pt> */

public class RegisterSnsUserArrivalUi implements Runnable {

    private final RegisterSnsUserArrivalController registerSnsUserArrivalController;

    /**
     *  Constructor for the receptionist ui class
     */

    public RegisterSnsUserArrivalUi(){
        this.registerSnsUserArrivalController = new RegisterSnsUserArrivalController();
    }

    /**
     * Method to run the user interface for the register sns user arrival function
     */

    @Override
    public void run(){

        String vaccinationCenterName = "";
        Properties props = new Properties();
        // Read configured values
        try
        {
            InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
            props.load(in);
            vaccinationCenterName = (String)(props.get(Constants.VACCINATION_CENTER)); // apagar isto, apenas exemplo de como obter a string e mostrar que esta correta !
            in.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }

        String snsNumber;
        boolean isValidNumber;
        VaccinationCenter vaccinationCenter = registerSnsUserArrivalController.getVaccinationCenter(vaccinationCenterName);



        Scanner reader = new Scanner(System.in);
        System.out.println("---------- Register a new user arrival ----------");
        System.out.print("Input the User SNS Number: ");


        snsNumber = reader.next();

        while (snsNumber.isBlank() || snsNumber.isEmpty()){

            System.out.println("Invalid format for SNS Number, please type it again.");
            snsNumber = reader.next();
        }


        isValidNumber = registerSnsUserArrivalController.verifySnsNumber(snsNumber);

        while (!isValidNumber && !snsNumber.equals("exit")){

            System.out.println("The selected SNS number is not registered in the system, please select a new one or type exit to exit.");
            snsNumber = reader.next();
            isValidNumber = registerSnsUserArrivalController.verifySnsNumber(snsNumber);

        }

        if (!snsNumber.equals("exit")) {

            if (registerSnsUserArrivalController.verifyVaccineReservation(snsNumber, vaccinationCenter) == false){

                System.out.println("The selected SNS user doesn't have any vaccine scheduled for this day or vaccination center.");
            }

            else {

                //String scheduleDetails = registerSnsUserArrivalController.getScheduleDetails(snsNumber);
                System.out.println("The user has a vaccine scheduled."); // substituir pelos detalhes da marcação
                System.out.println("Register the arrival of the user? (y for Yes or n for No)");
                String option = reader.next();
                while (!option.equals("y") && !option.equals("n")){
                    System.out.println("invalid option, please type y or n");
                    option = reader.next();
                }

                if (option.equals("y")){

                    registerSnsUserArrivalController.registerUserArrival(snsNumber, vaccinationCenter);
                    System.out.println("Operation Finished.");

                }



            }


        }


    }
}
