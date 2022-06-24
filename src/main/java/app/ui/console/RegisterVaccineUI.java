package app.ui.console;

/*
import app.controller.RegisterVaccineController;
import app.controller.RegisterVaccineTypeController;
import app.ui.console.utils.Utils;
import java.util.Objects;
*/
/**
 * Class of the user interface for US13
 *
 * @author Lucas Gonçalves <1211601@isep.ipp.pt> */

/**
public class RegisterVaccineUI implements Runnable {

    private final RegisterVaccineController controller;
    private final RegisterVaccineTypeController typeController;
    public RegisterVaccineUI() {
        this.controller = new RegisterVaccineController();
        this.typeController = new RegisterVaccineTypeController();
    }




    public void run() {

        final int type;
        final String name;
        final String brand;
        int totalAmountDoses =-1;
        int vaccineDosage = -1;
        int minAge = -1;
        int maxAge = -1;
        int intervalBetweenDoses;
        String confirm;


        //if (typeController.printlist() == false){
          //  System.out.println("\n----There needs to exist at least one vaccine type to register a vaccine----");

        //} else {
            System.out.println("-----------REGISTRATION OF A NEW VACCINE----------");
            System.out.println();
            System.out.println("What will be the type of the new vaccine?\n");


            type = Utils.readIntegerFromConsole("Type: ");
            name = Utils.readLineFromConsole("Vaccine name: ");
            brand = Utils.readLineFromConsole("Vaccine brand: ");
            totalAmountDoses = Utils.readIntegerFromConsole("Total amount of doses: ");
            while (totalAmountDoses <= 0){
                totalAmountDoses = Utils.readIntegerFromConsole("Invalid amount\nNumber must be higher than 0\n" +
                        "Write valid amount: ");
            }

            vaccineDosage = Utils.readIntegerFromConsole("Vaccine dosage, in mL: ");
            while (vaccineDosage <= 0){
                vaccineDosage=Utils.readIntegerFromConsole("Invalid amount\nNumber must be higher than 0\n" +
                        "Write valid dosage: ");
            }

            minAge = Utils.readIntegerFromConsole("Minimum age requirement: ");
            while (minAge < 0){
                minAge = Utils.readIntegerFromConsole("Invalid amount\nMinimum age must be higher than 0\n" +
                        "Write valid minimum age: ");
            }

            maxAge = Utils.readIntegerFromConsole("Maximum age requirement: ");
            while (maxAge <= minAge){
                if (maxAge < 0){
                    maxAge = Utils.readIntegerFromConsole("Invalid amount\nMaximum age must be higher than 0\n" +
                            "Write valid maximum age: ");
                }
                if (maxAge <= minAge){
                    maxAge = Utils.readIntegerFromConsole("Invalid amount\nMaximum age must be higher than minimum age\n" +
                            "Write valid maximum age: ");
                }
            }
            intervalBetweenDoses = Utils.readIntegerFromConsole("Time interval between doses (in days): ");
            while (intervalBetweenDoses <= 0){
                intervalBetweenDoses = Utils.readIntegerFromConsole("Invalid amount\nTime interval must be higher than 0\n" +
                        "Write valid time interval: ");
            }
            System.out.printf("\nThe vaccine that will be created will be: \n" +
                            "Name= %s\n" +
                            "Brand= %s\n" +
                            "Total Amount of Doses= %d\n" +
                            "Vaccine dosage= %dmL\n" +
                            "Age interval= %d to %d years\n" +
                            "Time interval between doses= %d days\n", name, brand, totalAmountDoses, vaccineDosage, minAge, maxAge,
                    intervalBetweenDoses);

            confirm = Utils.readLineFromConsole("Do you wish to confirm? (yes/no)\n");
            boolean contin = false;
            while (!contin) {
                if (!Objects.equals(confirm, "yes") && !Objects.equals(confirm, "no")) {
                    confirm = Utils.readLineFromConsole("Please choose \"yes\" or \"no\"");

                } else if (Objects.equals(confirm, "no")) {
                    System.out.println("\n----The vaccine will not be created----");
                    contin = true;

                } else {
                    System.out.println("\n----The vaccine will be created----");

                    contin = true;
                }
            }
        //}
    }
}
 */
