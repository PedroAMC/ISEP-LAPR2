//package app.ui.console;
//
//import app.controller.RegisterVaccinationCenterController;
//import app.domain.utils.Hour;
//import app.domain.model.VaccineBrands;
//import app.domain.model.VaccineType;
//import app.domain.model.VaccineTypeList;
//import app.ui.console.utils.Utils;
//
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
///**
// * Class of the user interface for us09
// *
// * @author Miguel Ferreira <1211488@isep.ipp.pt> */
//
//public class RegisterVaccinationCenterUI implements Runnable {
//    private final RegisterVaccinationCenterController controller;
//    /**
//     * Constructor of the ui class
//     */
//
//    public RegisterVaccinationCenterUI() {
//        this.controller = new RegisterVaccinationCenterController();
//    }
//    /**
//     * Run method to run the ui necessary to register a new Vaccination Center in the system.
//     */
//    @Override
//    public void run() {
//        int type = 10;
//        System.out.println("-----------REGISTRATION OF A NEW VACCINATION CENTER----------");
//        System.out.println();
//        System.out.println("What type of vaccination center do you want to register?");
//        try {
//            do {
//                type = Utils.readIntegerFromConsole("Type:\n 0-A Community MassVaccination Center\n 1-A Healthcare Center");
//            } while (type < 0 || type > 1);
//        } catch (InputMismatchException e) {
//            System.out.println("Invalid category");
//        }
//         String pandemic;
//         String name;
//         String address;
//         int phonenumber;
//         String emailadd;
//         int fax_number;
//         String website;
//         String openinghours;
//         String closinghours;
//         int slot_duration;
//         int vaccines_per_slot;
//        System.out.println("Now write down the Necessary Data");
//        pandemic = Utils.readLineFromConsole("Pandemic to respond to:");
//        name = Utils.readLineFromConsole("Name:");
//        address = Utils.readLineFromConsole("Address:");
//        phonenumber = Utils.readIntegerFromConsole("Phone Number:");
//        emailadd = Utils.readLineFromConsole("Email Address:");
//        fax_number = Utils.readIntegerFromConsole("Fax Number:");
//        website = Utils.readLineFromConsole("Website Address:");
//        openinghours = Utils.readLineFromConsole("Opening hours:");
//        closinghours = Utils.readLineFromConsole("Closing hours:");
//        assert openinghours != null;
//        String[] time = openinghours.split(":");
//        int openinghour = Integer.parseInt(time[0]);
//        int openingminutes = Integer.parseInt(time[1]);
//        Hour opening_hours = new Hour(openinghour, openingminutes);
//        assert closinghours != null;
//        String[] time2 = closinghours.split(":");
//        int closinghour = Integer.parseInt(time2[0]);
//        int closingminutes = Integer.parseInt(time2[1]);
//        Hour closing_hours = new Hour(closinghour, closingminutes);
//        slot_duration = Utils.readIntegerFromConsole("Slot Duration:");
//        vaccines_per_slot = Utils.readIntegerFromConsole("Maximum Number of Vaccines that can be given per slot");
//        if (type == 0) {
//            try {
//                VaccineType type1 = creationofVaccineType();
//                VaccineBrands brands = creationofListOfVaccineBrand();
//                controller.createCommunityMassVaccinationCenter(pandemic, name, address, phonenumber, emailadd, fax_number, website, opening_hours, closing_hours, slot_duration, vaccines_per_slot, type1, brands);
//                String string = String.format("Confirm the inputted data (y - yes/ n - no) \nType:%d(0-Mass Community/1-Healthcare)\nPandemic:%s\nName:%s\nAddress:%s\nPhonenumber:%d\nEmail Address:%s\nFax Number:%d\nWebsite:%s\nOpening hours:%s\nClosing Hours:%s\nSlot Duration:%d\nVaccines per slot:%s", type, pandemic, name, address, phonenumber, emailadd, fax_number, website, opening_hours, closing_hours, slot_duration, vaccines_per_slot);
//                boolean confirmar = Utils.confirm(string);
//                if (confirmar) {
//                    if (controller.registerVaccinationCenter()) {
//                        System.out.println("Vaccination Center registered successfully");
//                    } else {
//                        System.out.println("Operation failed");
//                    }
//                }
//            }catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//                System.out.println("Operation failed");
//            }
//        } else {
//            try {
//                VaccineTypeList types=creationofListOfVaccineType();
//                VaccineBrands brands=creationofListOfVaccineBrand();
//                controller.createHealthCareCenter(pandemic, name, address, phonenumber, emailadd, fax_number, website, opening_hours, closing_hours, slot_duration, vaccines_per_slot,types,brands);
//                String string = String.format("Confirm the inputted data (y - yes/ n - no) \nType:%d(0-Mass Community/1-Healthcare)\nPandemic:%s\nName:%s\nAddress:%s\nPhonenumber:%d\nEmail Address:%s\nFax Number:%d\nWebsite:%s\nOpening hours:%s\nClosing Hours:%s\nSlot Duration:%d\nVaccines per slot:%s", type, pandemic, name, address, phonenumber, emailadd, fax_number, website, opening_hours, closing_hours, slot_duration, vaccines_per_slot);
//                boolean confirmar = Utils.confirm(string);
//                if (confirmar) {
//                    if (controller.registerVaccinationCenter()) {
//                        System.out.println("Vaccination Center registered successfully");
//                    } else {
//                        System.out.println("Operation failed");
//                    }
//                }
//            } catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//                System.out.println("Operation failed");
//            }
//        }
//        String answerlistoption=Utils.readLineFromConsole("Do you want to see the list of Vaccination Centers? Yes(y) or No(n)?");
//        assert answerlistoption != null;
//        if(answerlistoption.equals("y")) {
//            controller.printlist();
//        }
//    }
//
//    /**
//     * creationofVaccineType method to create a vaccine type
//     */
//
//    public VaccineType creationofVaccineType(){
//        Scanner sc=new Scanner(System.in);
//        System.out.println();
//        System.out.println("Now you will write the data about the vaccine type");
//        System.out.println("Please Write Down the code,the description and the technology");
//        System.out.println();
//        System.out.println("Code-5 characters");
//        String code=sc.next();
//        System.out.println();
//        String description=Utils.readLineFromConsole("Description-maximum of 40 characters");
//        System.out.println();
//        String technology=Utils.readLineFromConsole("Techonolgys:Live attenuated vaccines,Inactivated vaccines,Subunit vaccines,Toxoid vaccines,Viral vector vaccines and Messenger RNA (mRNA) vaccines");
//        return new VaccineType(code,description,technology);
//    }
//
//    /**
//     * creationofListOfVaccineBrand method to create the list of the vaccine brands
//     */
//        public VaccineBrands creationofListOfVaccineBrand() {
//            System.out.println();
//            System.out.println("Now you will write the disease and respective supplier/brand of each vaccine");
//            VaccineBrands brands = new VaccineBrands();
//                int quantityofvaccines = Utils.readIntegerFromConsole("How many pharmaceutical brands will supply the vaccinacion center?");
//                for (int i = 0; i <quantityofvaccines ; i++) {
//                    String line=Utils.readLineFromConsole("Write down in the format:disease-brand");
//                    String [] strings=line.split("-");
//                    brands.addVaccineBrand(strings[0],strings[1]);
//                }
//            return brands;
//        }
//
//    /**
//     * creationofListOfVaccineType method to create the list of vaccine types
//     */
//
//        public VaccineTypeList creationofListOfVaccineType(){
//            Scanner sc=new Scanner(System.in);
//            System.out.println("Vaccine Types List:");
//            VaccineTypeList listOfVaccineType = new VaccineTypeList();
//            int quantity = Utils.readIntegerFromConsole("How many Vaccine Types will the Vaccination Center work with?");
//            for (int i = 0; i < quantity; i++) {
//                System.out.println();
//                System.out.println("Now you will write the data about the vaccine type");
//                System.out.println();
//                System.out.println("Please Write Down the code,the description and the technology");
//                System.out.println();
//                System.out.println("Code-5 characters");
//                String code=sc.next();
//                System.out.println();
//                String description=Utils.readLineFromConsole("Description-maximum of 40 characters");
//                System.out.println();
//                String technology=Utils.readLineFromConsole("Techonolgys:Live attenuated vaccines,Inactivated vaccines,Subunit vaccines,Toxoid vaccines,Viral vector vaccines and Messenger RNA (mRNA) vaccines");
//                listOfVaccineType.addVaccineType(code,description,technology);
//            }
//            return listOfVaccineType;
//        }
//    }
