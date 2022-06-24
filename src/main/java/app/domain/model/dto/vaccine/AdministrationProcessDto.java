package app.domain.model.dto.vaccine;

import app.domain.model.data.Vaccine;
import app.domain.model.data.schedule.Schedule;
import app.domain.model.data.snsuser.SnsUser;

public class  AdministrationProcessDto {

    private String snsUserNumber;
    private String age;
    private Vaccine vaccine;
    private Schedule schedule;

    /**
     * constructor of the class
     * @param snsUserNumber sns user number string
     * @param age string age
     * @param vaccine vaccine object
     * @param schedule schedule object
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public AdministrationProcessDto(String snsUserNumber, String age, Vaccine vaccine, Schedule schedule) {
        this.snsUserNumber = snsUserNumber;
        this.age = age;
        this.vaccine = vaccine;
        this.schedule = schedule;
    }

    /**
     * Method to get the sns user
     * @return sns user
     */
    public String getSnsUserNumber() {
        return snsUserNumber;
    }

    /**
     * Method to get the age
     * @return age string
     */
    public String getAge() {
        return age;
    }

    /**
     * Method to get the vaccine
     * @return vaccine object
     */
    public Vaccine getVaccine() {
        return vaccine;
    }

    /**
     * Method to get the schedule
     * @return schedule object
     */
    public Schedule getSchedule() {
        return schedule;
    }
}
