package app.ui.console;
/**
import app.controller.RegisterVaccineTypeController;
import app.domain.store.vaccine.VaccineTypeStore;
import app.ui.console.utils.Utils;
import java.util.InputMismatchException;
import java.util.Objects;

public class RegisterVaccineTypeUI implements Runnable {

    private final RegisterVaccineTypeController controller;

    public RegisterVaccineTypeUI() {
        this.controller = new RegisterVaccineTypeController();
    }


    @Override
    public void run() {
        String code;
        String technology = "technology";
        int technologyNum;
        String description;
        String confirm;
        System.out.println("\n----Do you want to see already registered vaccine types, or register a new one?----");
        int type = 2;
        try {
            do {
                type = Utils.readIntegerFromConsole("Type:\n" +
                        "1. List Existing Vaccine Types\n" +
                        "2. Register New Vaccine Type");
                if (type < 1 || type > 2) {
                    System.out.println("\nInvalid number\nPlease choose one of the options");
                }
            } while (type < 1 || type > 2);
        } catch (InputMismatchException e) {
            System.out.println("Invalid category");
        }

        if (type == 1) {
           // if (controller.GetTypes() == null){
             //   System.out.println("\n---The Vaccine Type List is empty---");
            //} else {
            controller.GetTypes();
            controller.printlist();
        //}



        } else {
            code = Utils.readLineFromConsole("Vaccination code (must have five alphanumeric characters):");
            try {
                do {
                    technologyNum = Utils.readIntegerFromConsole("Choose Vaccination technology:\n" +
                            "1 - Live-attenuated vaccines\n" +
                            "2 - Inactivated vaccines\n" +
                            "3 - Subunit vaccines\n" +
                            "4 - Toxoid vaccines\n" +
                            "5 - Viral vector vaccines\n" +
                            "6 - Messenger RNA (mRNA) vaccines");
                    switch (technologyNum) {
                        case 1:
                            technology = "Live-attenuated vaccines";
                            break;

                        case 2:
                            technology = "Inactivated vaccines";
                            break;

                        case 3:
                            technology = "Subunit vaccines";
                            break;

                        case 4:
                            technology = "Toxoid vaccines";
                            break;

                        case 5:
                            technology = "Viral vector vaccines";
                            break;

                        case 6:
                            technology = "Messenger RNA (mRNA) vaccines";
                            break;

                        default:
                            System.out.println("Invalid number\nPlease choose one of the options");
                    }
                } while (technologyNum < 1 || technologyNum > 6);
            } catch (InputMismatchException e) {
                System.out.println("Invalid category");
            }

            description = Utils.readLineFromConsole("Write a description");
            confirm = Utils.readLineFromConsole("Do you wish to confirm? (yes/no)\n");
            boolean contin = false;
            while (contin == false) {
                if (!Objects.equals(confirm, "yes") && !Objects.equals(confirm, "no")) {
                    confirm = Utils.readLineFromConsole("Please choose \"yes\" or \"no\"");

                } else if (Objects.equals(confirm, "no")) {
                    System.out.println("\n----The vaccine type will not be created----");
                    contin = true;

                } else {
                    System.out.println("\n----The vaccine type will be created----");

                    contin = true;
                    controller.createVaccineType(code, description, technology);
                }


            }
        }

    }
}

 */
