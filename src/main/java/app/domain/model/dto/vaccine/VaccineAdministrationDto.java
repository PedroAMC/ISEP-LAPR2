package app.domain.model.dto.vaccine;

import app.domain.model.data.centers.VaccinationCenter;
import app.domain.utils.Date;
import app.domain.utils.Hour;

/**
 * Class to carry all the information of a certain VaccineAdministration
 *
 * @author Pedro Campos <1211511@isep.ipp.pt>
 * @author Lucas Gonçalves <1211601@isep.ipp.pt>
 * @author Nuno Cunha <1211689@isep.ipp.pt>
 */

public class VaccineAdministrationDto {

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
     *
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
    public VaccineAdministrationDto(String snsUserNumber, String vaccineName, String dose, String lotNumber, Date scheduleDate, Hour scheduleHour, Date arrivalDate, Hour arrivalHour, Date nurseAdministrationDate, Hour nurseAdministrationHour, Date leavingDate, Hour leavingHour, VaccinationCenter vaccinationCenter) {
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

    public String getVaccineName() {
        return vaccineName;
    }

    public String getDose() {
        return dose;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public Hour getScheduleHour() {
        return scheduleHour;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public Hour getArrivalHour() {
        return arrivalHour;
    }

    public Date getNurseAdministrationDate() {
        return nurseAdministrationDate;
    }

    public Hour getNurseAdministrationHour() {
        return nurseAdministrationHour;
    }

    public Date getLeavingDate() {
        return leavingDate;
    }

    public Hour getLeavingHour() {
        return leavingHour;
    }

    public VaccinationCenter getVaccinationCenter(){ return vaccinationCenter; }
}
