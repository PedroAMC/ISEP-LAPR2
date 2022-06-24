package app.ui.console.nurse;

import app.controller.App;
import app.controller.nurse.VaccineAdministrationController;
import app.domain.model.dto.snsuser.SnsUserDto;
import app.domain.model.dto.utils.HourDto;
import app.domain.model.dto.vaccine.VaccineAdministrationDto;
import app.domain.model.mapper.snsuser.SnsUserMapper;
import app.domain.shared.Constants;
import app.domain.model.dto.vaccine.AdministrationProcessDto;
import app.domain.utils.Date;
import app.domain.utils.Hour;
import app.domain.utils.Pair;
import app.ui.console.utils.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Year;
import java.util.List;
import java.util.Properties;

/**
 * @author Nuno Cunha <1211689@isep.ipp.pt>
 */
public class VaccineAdministrationUi implements Runnable{

    VaccineAdministrationController controller;
    List<Pair<SnsUserDto, HourDto>> snsUsersArrived;
    SnsUserMapper mapper;

    public VaccineAdministrationUi() {
        controller = new VaccineAdministrationController();
    }


    @Override
    public void run() {

        String vaccinationCenterName="teste";

        Properties props = new Properties();
        // Read configured values
        try
        {
            InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
            props.load(in);
            vaccinationCenterName = (String)(props.get(Constants.VACCINATION_CENTER));
            in.close();
        }
        catch(
                IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("Select one of the users arrived: ");

        controller.desiredVaccinationCenter(vaccinationCenterName);

        snsUsersArrived = controller.getUsersArrived();

        int index = 0;

        if (snsUsersArrived.isEmpty()){
            System.out.println("Waiting room is empty");
        }else{
            do {
                index = Utils.selectsIndex(snsUsersArrived);
            }while (!controller.validateIndex(index));
        }


        System.out.println(controller.getSnsUserDto(index , snsUsersArrived).getName());
        System.out.println(controller.getAge(controller.getSnsUserDto(index , snsUsersArrived)));
        System.out.println("No adverse reactions detected");

        AdministrationProcessDto administrationProcessDto = controller.getAdministrationProcess(controller.getSnsUserName(controller.getSnsUserDto(index,snsUsersArrived)), controller.getAge(controller.getSnsUserDto(index , snsUsersArrived)), controller.getVaccine(controller.getAge(controller.getSnsUserDto(index,snsUsersArrived)),controller.getVaccineType(controller.getSnsUserDto(index,snsUsersArrived))), controller.getSchedule(controller.getSnsUserDto(index,snsUsersArrived)));
        System.out.println(administrationProcessDto);

        System.out.println("Please input the necessary data to register the administration");

        String snsNumber = Utils.readLineFromConsole("SNS number: ");
        String vaccineName = Utils.readLineFromConsole("Vaccine name: ");
        String vaccineDose = Utils.readLineFromConsole("Vaccine dose: ");
        String vaccineLotNumber = Utils.readLineFromConsole("Vaccine lot number: ");

        int day = -1;
        int month = -1;
        int year = -1;


        System.out.println("Input the Schedule Date: ");
        while(day < 0 || day >31){
            day = Utils.readIntegerFromConsole("Day: ");
        }

        while(month < 0 || month > 12){
            month = Utils.readIntegerFromConsole("Month: "); ;
        }

        while (year < 0 || year < Year.now().getValue() ) {
            year = Utils.readIntegerFromConsole("Year: ");
        }

        System.out.println("Schedule hour");
        int hours = -1;
        int minutes = -1;
        while(hours < 0 || hours > 24){

            hours = Utils.readIntegerFromConsole("Hour: ");
        }

        while(minutes < 0 || minutes > 59){
            minutes = Utils.readIntegerFromConsole("Minutes: ");
        }

        int day1 = -1;
        int month1 = -1;
        int year1 = -1;

        System.out.println("Input the Arrival Date: ");
        while(day1 < 0 || day1 >31){
            day1 = Utils.readIntegerFromConsole("Day: ");
        }

        while(month1 < 0 || month1 > 12){
            month1 = Utils.readIntegerFromConsole("Month: "); ;
        }

        while (year1 < 0 || year1 < Year.now().getValue() ) {
            year1 = Utils.readIntegerFromConsole("Year: ");
        }


        System.out.println("Arrival hour");
        int hours1 = -1;
        int minutes1 = -1;
        while(hours1 < 0 || hours1 > 24){

            hours1 = Utils.readIntegerFromConsole("Hour: ");
        }

        while(minutes1 < 0 || minutes1 > 59){
            minutes1 = Utils.readIntegerFromConsole("Minutes: ");
        }

        int day2 = -1;
        int month2 = -1;
        int year2 = -1;

        System.out.println("Input the Administration Date: ");
        while(day2 < 0 || day2 >31){
            day2 = Utils.readIntegerFromConsole("Day: ");
        }

        while(month2 < 0 || month2 > 12){
            month2 = Utils.readIntegerFromConsole("Month: "); ;
        }

        while (year2 < 0 || year2 < Year.now().getValue() ) {
            year2 = Utils.readIntegerFromConsole("Year: ");
        }


        System.out.println("Nurse Administration hour");
        int hours2 = -1;
        int minutes2 = -1;
        while(hours2 < 0 || hours2 > 24){

            hours2 = Utils.readIntegerFromConsole("Hour: ");
        }

        while(minutes2 < 0 || minutes2 > 59){
            minutes2 = Utils.readIntegerFromConsole("Minutes: ");
        }

        int day3 = -1;
        int month3 = -1;
        int year3 = -1;
        System.out.println("Input the Schedule Date: ");
        while(day3 < 0 || day3 >31){
            day3 = Utils.readIntegerFromConsole("Day: ");
        }

        while(month3 < 0 || month3 > 12){
            month3 = Utils.readIntegerFromConsole("Month: "); ;
        }

        while (year3 < 0 || year3 < Year.now().getValue() ) {
            year3 = Utils.readIntegerFromConsole("Year: ");
        }

        System.out.println("Leaving hour");
        int hours3 = -1;
        int minutes3 = -1;
        while(hours3 < 0 || hours3 > 24){

            hours3 = Utils.readIntegerFromConsole("Hour: ");
        }

        while(minutes3 < 0 || minutes3 > 59){
            minutes3 = Utils.readIntegerFromConsole("Minutes: ");
        }

        String vaccinationCenter = Utils.readLineFromConsole("Vaccination Center: ");

        //VaccineAdministrationDto vaccineAdministrationDto = new VaccineAdministrationDto(snsNumber,vaccineName,vaccineDose,vaccineLotNumber,scheduleDate, new HourDto(hours,minutes,0),arrivalDate,new HourDto(hours1,minutes1,0),administrationDate,new HourDto(hours2,minutes2,0),leavingDate,new HourDto(hours3,minutes3,0),vaccinationCenter)

        VaccineAdministrationDto vaccineAdministrationDto = new VaccineAdministrationDto(snsNumber,vaccineName,vaccineDose,vaccineLotNumber,new Date(day,month,year),new Hour(hours,minutes,0),new Date(day1,month1,year1),new Hour(hours1,minutes1,0),new Date(day2,month2,year2),new Hour(hours2,minutes2,0),new Date(day3,month3,year3),new Hour(hours3,minutes3,0),controller.getVaccinationCenterByName(vaccinationCenter));

        controller.createVaccineAdministration(vaccineAdministrationDto);

        System.out.println("Vaccine Administration: ");
        System.out.println("SNS number: " + vaccineAdministrationDto.getSnsUserNumber());
        System.out.println("Vaccine name/brand: " + vaccineAdministrationDto.getVaccineName());
        System.out.println("Vaccine dose: "+ vaccineAdministrationDto.getDose());
        System.out.println("Vaccine lot number: " + vaccineAdministrationDto.getLotNumber());
        System.out.println("Schedule date: " + vaccineAdministrationDto.getScheduleDate());
        System.out.println("Schedule Hour: " + vaccineAdministrationDto.getScheduleHour());
        System.out.println("Arrival Date: " + vaccineAdministrationDto.getArrivalDate());
        System.out.println("Arrival hour: " + vaccineAdministrationDto.getArrivalHour());
        System.out.println("Nurse administration date: " + vaccineAdministrationDto.getNurseAdministrationDate());
        System.out.println("Nurse administration hour: " + vaccineAdministrationDto.getNurseAdministrationHour());
        System.out.println("Leaving date: " + vaccineAdministrationDto.getLeavingDate());
        System.out.println("Leaving Hour: " + vaccineAdministrationDto.getLeavingHour());
        System.out.println("Vaccination Center: " + vaccineAdministrationDto.getVaccinationCenter().getName());

        int validate = Utils.readIntegerFromConsole("The data is correct ? (1 - yes | 0 - no) ");

        if (validate == 1){
            controller.saveVaccineAdministration(vaccineAdministrationDto);
            controller.addVaccineAdministration(vaccineAdministrationDto);
        }

        System.out.println(App.getInstance().getCompany().getVaccineAdministrationStore().getVaccineAdministrations());

    }
}
