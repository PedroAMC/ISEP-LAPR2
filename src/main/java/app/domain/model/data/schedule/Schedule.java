package app.domain.model.data.schedule;

import app.domain.model.data.centers.VaccinationCenter;
import app.domain.utils.Date;
import app.domain.utils.Hour;


import java.util.Objects;

/**
 * Class Schedule Vaccine
 *
 * @author Nuno Cunha <1211689@isep.ipp.pt>
 */

public class Schedule {

    private Date date;
    private Hour hour;
    private VaccinationCenter vaccinationCenter;

    /**
     * Constructor of the class
     * @param date date desired
     * @param hour hour desired
     * @param vaccinationCenter vaccination center desired
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public Schedule(Date date, Hour hour, VaccinationCenter vaccinationCenter) {
        this.date = date;
        this.hour = hour;
        this.vaccinationCenter = vaccinationCenter;
    }

    /**
     * Method to get the date
     * @return date
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public Date getDate() {
        return date;
    }

    /**
     * Method to set the date
     * @param date date
     * @return date
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Method to get the hour
     * @return hour
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public Hour getHour() {
        return hour;
    }

    /**
     * Method to set the hour
     * @param hour hour
     * @return hour
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public void setHour(Hour hour) {
        this.hour = hour;
    }

    /**
     * Method to get the vaccination center
     * @return vaccination center
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    /**
     * Method to set the vaccination center
     * @param vaccinationCenter vaccination center
     * @return vaccination center
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }

    /**
     * Method to string to the object from schedule vaccine class
     * @return schedule vaccine string
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    @Override
    public String toString() {
        return "ScheduleVaccine{" +
                "date=" + date +
                ", hour=" + hour +
                ", vaccinationCenter='" + vaccinationCenter + '\'' +
                '}';
    }

    /**
     * Method equals from the object of the class schedule vaccine
     * @param o object
     * @return boolean with the equality or not
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule that = (Schedule) o;
        return date == that.date && hour == that.hour && vaccinationCenter.equals(that.vaccinationCenter);
    }

    /**
     * Method to obtain the hash code of an object from the class schedule vaccine
     *
     * @return object's hash code
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    @Override
    public int hashCode() {
        return Objects.hash(date, hour, vaccinationCenter);
    }
}
