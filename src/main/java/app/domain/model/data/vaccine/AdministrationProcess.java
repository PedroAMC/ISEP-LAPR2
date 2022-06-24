package app.domain.model.data.vaccine;

import app.domain.model.data.Vaccine;
import app.domain.model.data.schedule.Schedule;
import app.domain.model.data.snsuser.SnsUser;

import java.util.Objects;

public class AdministrationProcess {
    private String snsUserNumber;
    private String age;
    private Vaccine vaccine;
    private Schedule schedule;

    /**
     * Constructor of the class
     * @param snsUserNumber sns user number
     * @param age sns user's age
     * @param vaccine scheduled vaccine
     * @param schedule schedule made
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public AdministrationProcess(String snsUserNumber, String age, Vaccine vaccine, Schedule schedule) {
        this.snsUserNumber = snsUserNumber;
        this.age = age;
        this.vaccine = vaccine;
        this.schedule = schedule;
    }

    /**
     * Getter method to get sns user
     * @return sns user
     */
    public String getSnsUserNumber() {
        return snsUserNumber;
    }

    /**
     * Setter method to set sns user
     * @param snsUserNumber sns user number
     */
    public void setSnsUserNumber(String snsUserNumber) {
        this.snsUserNumber = snsUserNumber;
    }

    /**
     * Getter method to get age
     * @return age
     */
    public String getAge() {
        return age;
    }

    /**
     * Setter method to set age
     * @param age age string
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * Getter method to get vaccine
     * @return vaccine
     */
    public Vaccine getVaccine() {
        return vaccine;
    }

    /**
     * Setter method to set vaccine
     * @param vaccine vaccine object
     */
    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    /**
     * Getter method to get schedule
     * @return schedule
     */
    public Schedule getSchedule() {
        return schedule;
    }

    /**
     * Setter method to set schedule
     * @param schedule schedule object
     */
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    /**
     * Method equals for the administration process class
     * @param o object o
     * @return boolean with the result
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdministrationProcess that = (AdministrationProcess) o;
        return Objects.equals(snsUserNumber, that.snsUserNumber) && Objects.equals(age, that.age) && Objects.equals(vaccine, that.vaccine) && Objects.equals(schedule, that.schedule);
    }

    /**
     * Method to get the Hashcode
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(snsUserNumber, age, vaccine, schedule);
    }

    /**
     * Method to String
     * @return String with the data
     */
    @Override
    public String toString() {
        return "AdministrationProcess{" +
                "snsUser=" + snsUserNumber +
                ", age='" + age + '\'' +
                ", vaccine=" + vaccine.getBrand() +
                ", schedule=" + schedule.getDate()+
                '}';
    }
}
