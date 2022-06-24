package app.domain.model.data.vaccine;

import app.domain.model.data.centers.VaccinationCenter;
import app.domain.store.schedule.ScheduleStore;
import app.domain.utils.Date;
import app.domain.utils.Hour;

import java.time.LocalDate;

/**
 * Class that represents the company employees
 *
 * @author Pedro Campos <1211511@isep.ipp.pt>
 * @author Lucas Gonçalves <1211601@isep.ipp.pt>
 * @author Nuno Cunha <1211689@isep.ipp.pt>
 */


public class VaccineAdministration {

    private String snsUserNumber;
    private String vaccineName;
    private String dose;
    private String lotNumber;
    private Date scheduleDate;
    private Hour scheduleHour;
    private Date arrivalDate;
    private Hour arrivalHour;
    private Date nurseAdministrationDate;
    private Hour nurseAdministrationHour;
    private Date leavingDate;
    private Hour leavingHour;
    private VaccinationCenter vaccinationCenter;


    /**
     * Constructor of the VaccineAdministration class
     * @param snsUserNumber
     * @param vaccineName
     * @param dose
     * @param lotNumber
     * @param scheduleDate
     * @param scheduleHour
     * @param arrivalDate
     * @param arrivalHour
     * @param nurseAdministrationDate
     * @param nurseAdministrationHour
     * @param leavingDate
     * @param leavingHour
     */

    public VaccineAdministration(String snsUserNumber, String vaccineName, String dose, String lotNumber, Date scheduleDate, Hour scheduleHour, Date arrivalDate, Hour arrivalHour, Date nurseAdministrationDate, Hour nurseAdministrationHour, Date leavingDate, Hour leavingHour, VaccinationCenter vaccinationCenter) {
        this.snsUserNumber = snsUserNumber;
        this.vaccineName = vaccineName;
        this.dose = dose;
        this.lotNumber = lotNumber;
        this.scheduleDate = scheduleDate;
        this.scheduleHour = scheduleHour;
        this.arrivalDate = arrivalDate;
        this.arrivalHour = arrivalHour;
        this.nurseAdministrationDate = nurseAdministrationDate;
        this.nurseAdministrationHour = nurseAdministrationHour;
        this.leavingDate = leavingDate;
        this.leavingHour = leavingHour;
        this.vaccinationCenter = vaccinationCenter;
    }


    public String getSnsUserNumber() {
        return snsUserNumber;
    }

    public void setSnsUserNumber(String snsUserNumber) {
        this.snsUserNumber = snsUserNumber;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Hour getScheduleHour() {
        return scheduleHour;
    }

    public void setScheduleHour(Hour scheduleHour) {
        this.scheduleHour = scheduleHour;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Hour getArrivalHour() {
        return arrivalHour;
    }

    public void setArrivalHour(Hour arrivalHour) {
        this.arrivalHour = arrivalHour;
    }

    public Date getNurseAdministrationDate() {
        return nurseAdministrationDate;
    }

    public void setNurseAdministrationDate(Date nurseAdministrationDate) {
        this.nurseAdministrationDate = nurseAdministrationDate;
    }

    public Hour getNurseAdministrationHour() {
        return nurseAdministrationHour;
    }

    public void setNurseAdministrationHour(Hour nurseAdministrationHour) {
        this.nurseAdministrationHour = nurseAdministrationHour;
    }

    public Date getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(Date leavingDate) {
        this.leavingDate = leavingDate;
    }

    public Hour getLeavingHour() {
        return leavingHour;
    }

    public void setLeavingHour(Hour leavingHour) {
        this.leavingHour = leavingHour;
    }

    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }

    public void validateInformation(String snsUserNumber, String vaccineName, String dose, String lotNumber, Date scheduleDate, Hour scheduleHour, Date arrivalDate, Hour arrivalHour, Date nurseAdministrationDate, Hour nurseAdministrationHour, Date leavingDate, Hour leavingHour, VaccinationCenter vaccinationCenter){
        if (snsUserNumber == null || snsUserNumber.isEmpty() || snsUserNumber.isBlank()){
            throw new IllegalArgumentException("SNS number must be typed");
        }

        if (vaccineName == null || vaccineName.isEmpty() || vaccineName.isBlank()){
            throw new IllegalArgumentException("Vaccine name must be typed");
        }

        if (dose == null || dose.isEmpty() || dose.isBlank()){
            throw new IllegalArgumentException("Vaccine dose must be typed");
        }

        if (lotNumber == null || lotNumber.isEmpty() || lotNumber.isBlank()){
            throw new IllegalArgumentException("Vaccine lot number must be typed");
        }

        if (!Date.getCurrentDate().moreRecent(scheduleDate)){
            throw new IllegalArgumentException("Date incorrect");
        }

        if (!(scheduleHour.getHoras() > 0) || !(scheduleHour.getHoras() < 24) || !(scheduleHour.getMinutos() > 0) || !(scheduleHour.getMinutos() < 60) || !(scheduleHour.getSegundos() > 0) || !(scheduleHour.getSegundos() < 60)){
            throw new IllegalArgumentException("Hour form incorrect");
        }

        if (scheduleDate.moreRecent(arrivalDate)){
            throw new IllegalArgumentException("Date incorrect");
        }

        if (!(arrivalHour.getHoras() > 0) || !(arrivalHour.getHoras() < 24) || !(arrivalHour.getMinutos() > 0) || !(arrivalHour.getMinutos() < 60) || !(arrivalHour.getSegundos() > 0) || !(arrivalHour.getSegundos() < 60)){
            throw new IllegalArgumentException("Hour form incorrect");
        }

        if (arrivalDate.moreRecent(nurseAdministrationDate)){
            throw new IllegalArgumentException("Date incorrect");
        }

        if (!(nurseAdministrationHour.getHoras() > 0) || !(nurseAdministrationHour.getHoras() < 24) || !(nurseAdministrationHour.getMinutos() > 0) || !(nurseAdministrationHour.getMinutos() < 60) || !(nurseAdministrationHour.getSegundos() > 0) || !(nurseAdministrationHour.getSegundos() < 60)){
            throw new IllegalArgumentException("Hour form incorrect");
        }

        if (!leavingDate.moreRecent(nurseAdministrationDate)){
            throw new IllegalArgumentException("Date incorrect");
        }

        if (!(leavingHour.getHoras() > 0) || !(leavingHour.getHoras() < 24) || !(leavingHour.getMinutos() > 0) || !(leavingHour.getMinutos() < 60) || !(leavingHour.getSegundos() > 0) || !(leavingHour.getSegundos() < 60)){
            throw new IllegalArgumentException("Hour form incorrect");
        }

        if (vaccinationCenter.getName().isEmpty() || vaccinationCenter.getName().isBlank() || vaccinationCenter.getName() == null){
            throw new IllegalArgumentException("Center doesn't exist");
        }
    }

    @Override
    public String toString() {
        return "VaccineAdministration{" +
                "snsUserNumber='" + snsUserNumber + '\'' +
                ", vaccineName='" + vaccineName + '\'' +
                ", dose='" + dose + '\'' +
                ", lotNumber='" + lotNumber + '\'' +
                ", scheduleDate=" + scheduleDate +
                ", scheduleHour=" + scheduleHour +
                ", arrivalDate=" + arrivalDate +
                ", arrivalHour=" + arrivalHour +
                ", nurseAdministrationDate=" + nurseAdministrationDate +
                ", nurseAdministrationHour=" + nurseAdministrationHour +
                ", leavingDate=" + leavingDate +
                ", leavingHour=" + leavingHour +
                '}';
    }
}
