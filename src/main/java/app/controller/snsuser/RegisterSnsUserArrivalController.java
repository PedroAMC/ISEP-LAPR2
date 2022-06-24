package app.controller.snsuser;
import app.controller.App;
import app.domain.model.data.centers.VaccinationCenter;
import app.domain.model.data.schedule.Schedule;
import app.domain.model.data.snsuser.SnsUser;
import app.domain.model.data.vaccine.VaccineType;
import app.domain.store.center.VaccinationCenterStore;
import app.domain.store.schedule.ScheduleStore;
import app.domain.store.snsuser.SnsUserStore;
import app.domain.utils.Date;
import app.domain.utils.Hour;
import java.time.LocalDateTime;
import java.util.HashMap;


public class RegisterSnsUserArrivalController {

    /**
     * Controller class of us04
     *
     * @author Pedro Campos <1211511@isep.ipp.pt>
     */

    private int snsNumber;
    private final SnsUserStore snsUserStore;
    private final ScheduleStore scheduleStore;
    private final VaccinationCenterStore vaccinationCenterStore;

    /**
     * Constructor of the class
     */


    public RegisterSnsUserArrivalController() {

        this.snsUserStore = App.getInstance().getCompany().getSnsUserStore();
        this.scheduleStore = App.getInstance().getCompany().getScheduleStore();
        this.vaccinationCenterStore = App.getInstance().getCompany().getVaccinationCenterStore();
    }

    /**
     * Method to get a vaccinationCenterObject by name
     * @param vaccinationCenterName
     * @return vaccinataionCenter Object
     */
    public VaccinationCenter getVaccinationCenter(String vaccinationCenterName){

        VaccinationCenter vaccinationCenter = vaccinationCenterStore.findVaccinationCenter(vaccinationCenterName);

        return vaccinationCenter;

    }

    /**
     * Method to verify if a snsNumber is registered in the system
     * @param snsNumber String with the selected snsNumber
     * @return boolean representing if it's in the system or not
     */

    public boolean verifySnsNumber(String snsNumber){

        boolean isValidNumber;

        try {
            isValidNumber = snsUserStore.verifySnsNumber(snsNumber);
        } catch (IllegalArgumentException e){

            isValidNumber = false;

        }

        return isValidNumber;
    }


    /**
     * Method to verify if a snsNumber has a vaccine scheduled for the current date
     * @param snsNumber String with the selected snsNumber
     * @return boolean representing if the user has a vaccine scheduled or not
     */

    public boolean verifyVaccineReservation(String snsNumber, VaccinationCenter vaccinationCenter){

        LocalDateTime now = LocalDateTime.now();

        Date arrivalDate = new Date(now.getDayOfMonth(), now.getMonthValue(), now.getYear());
        Hour arrivalTime = Hour.tempoAtual();

        boolean isValidReservation = scheduleStore.verifySchedule(snsNumber, arrivalDate, vaccinationCenter);

        return isValidReservation;


    }

    /**
     * Method to obtain details of a scheduled vaccine
     * @param snsNumber String with the selected snsNumber
     * @return String with the schedule details, containing hour, date, vaccine type, etc
     */

//    public String getScheduleDetails(String snsNumber){
//
//        HashMap<String, HashMap<Schedule, VaccineType>> scheduleList = scheduleStore.getSchedules();
//        String reservationDetails = "a";
//
//        return reservationDetails;
//    }

    /**
     * Method to register the arrival of a snsUser
     * @param snsNumber String with the selected snsNumber
     * @return void
     */

    public void registerUserArrival(String snsNumber, VaccinationCenter vaccinationCenter){

        SnsUser snsUser = snsUserStore.getSnsUser(snsNumber);
        Hour arrivalTime = Hour.tempoAtual();

        vaccinationCenter.addArrival(snsUser, arrivalTime);

    }

}
