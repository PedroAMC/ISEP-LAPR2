package app.domain.utils;

import java.util.Date;
import java.util.Objects;

public class CsvFileInfo {

    String snsNumber;
    String vaccineName;
    String dose;
    String lotNumber;
    Date scheduleDate;
    Date arrivalDate;
    Date nurseDate;
    Date leavingDate;

    public CsvFileInfo(String snsNumber, String vaccineName, String dose, String lotNumber, Date scheduleDate, Date arrivalDate, Date nurseDate, Date leavingDate) {
        this.snsNumber = snsNumber;
        this.vaccineName = vaccineName;
        this.dose = dose;
        this.lotNumber = lotNumber;
        this.scheduleDate = scheduleDate;
        this.arrivalDate = arrivalDate;
        this.nurseDate = nurseDate;
        this.leavingDate = leavingDate;
    }


    public Date getDate (String sortBy){

        if(Objects.equals(sortBy, "arrivaltime")){
            return arrivalDate;
        }else if(Objects.equals(sortBy, "centerleaving")){
            return leavingDate;
        }

        return null;
    }
}
