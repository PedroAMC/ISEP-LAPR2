package app.ui.console.receptionist;

import app.controller.App;
import app.controller.schedule.ScheduleVaccineRecepcionistController;
import app.domain.model.dto.centers.VaccinationCenterDto;
import app.domain.model.dto.schedule.ScheduleDto;
import app.domain.model.dto.utils.DateDto;
import app.domain.model.dto.utils.HourDto;
import app.domain.model.dto.vaccine.VaccineTypeDto;
import app.domain.shared.Constants;
import app.ui.console.utils.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Year;
import java.util.List;
import java.util.Properties;

/**
 * Class of the user interface for us02
 *
 * @author Nuno Cunha <1211689@isep.ipp.pt>
 */

public class ScheduleVaccineRecepcionistUi implements Runnable{

    ScheduleVaccineRecepcionistController controller;

    /**
     * Constructor of the class
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public ScheduleVaccineRecepcionistUi() {controller = new ScheduleVaccineRecepcionistController();}

    /**
     * Run method to run the ui necessary to register
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    @Override
    public void run() {

        String ongoing = "";
        Properties props = new Properties();

        try
        {
            InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
            props.load(in);
            ongoing = (String) props.get(Constants.ONGOING_BREAK); // apagar isto, apenas exemplo de como obter a string e mostrar que esta correta !
            in.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("============== Schedule a Vaccine Administration ==============");

        boolean valid = false;
        String snsNumber = "";
        
        while(!valid){

            try{
                snsNumber = Utils.readLineFromConsole("\"Please enter your SNS number:\"");
                controller.verifySnsNumber(snsNumber);
                valid = true;
            }catch (IllegalArgumentException e){
                valid = false;
                System.out.println(e.getMessage());
            }


        }


        List<VaccinationCenterDto> centers = controller.getListOfCenters();

        System.out.println("Select a Vaccination center");
        System.out.println(centers);
        VaccinationCenterDto vaccinationCenterDto = centers.get(Utils.selectsIndex(centers));
        int desire = -1 ;

        while(desire != 1 && desire != 0){
            desire = Utils.readIntegerFromConsole("Do you desire to schedule the current outbreak type " + ongoing + "? (1 - yes | 0 - no) ");

        }

        VaccineTypeDto vaccineTypeDto;

        if(desire == 1){
            vaccineTypeDto = controller.getOngoingBreakoutType(ongoing);
        }else {

            List<VaccineTypeDto> typesDto = controller.getListOfTypes();
            System.out.println("Select a Vaccine type");
            System.out.println(typesDto);
            vaccineTypeDto = typesDto.get(Utils.selectsIndex(typesDto));
        }
        int day = -1;
        int month = -1;
        int year = -1;


        System.out.println("Input the Date you desire: ");

        while(day < 0 || day >31){
            day = Utils.readIntegerFromConsole("Day: ");
        }

        while(month < 0 || month > 12){
            month = Utils.readIntegerFromConsole("Month: "); ;
        }

        while (year < 0 || year < Year.now().getValue() ) {
            year = Utils.readIntegerFromConsole("Year: ");
        }

        System.out.println("Input the desire hour");

        int hours = -1;
        int minutes = -1;

        while(hours < 0 || hours > 24){

            hours = Utils.readIntegerFromConsole("Hour: ");
        }

        while(minutes < 0 || minutes > 59){
            minutes = Utils.readIntegerFromConsole("Minutes: ");
        }

        ScheduleDto scheduleDto = new ScheduleDto(new DateDto(day,month,year),new HourDto(hours,minutes,0),vaccinationCenterDto);

        controller.createSchedule(scheduleDto);

        System.out.println("Schedule :");
        System.out.println("Date: " + day + "/" + month + "/" + year);
        System.out.println("Hour: " + hours + ":" + minutes);
        System.out.println("Center: " + vaccinationCenterDto);
        System.out.println("Vaccine Type: " + vaccineTypeDto.getTypeCode() + "," + vaccineTypeDto.getShortDescription() + "," + vaccineTypeDto.getTechnology());

        int validate = Utils.readIntegerFromConsole("The data is correct ? (1 - yes | 0 - no) ");

        if(validate == 1){
            controller.saveSchedule(vaccineTypeDto,snsNumber);
        }

        System.out.println(App.getInstance().getCompany().getScheduleStore().getSchedules());

    }
}
