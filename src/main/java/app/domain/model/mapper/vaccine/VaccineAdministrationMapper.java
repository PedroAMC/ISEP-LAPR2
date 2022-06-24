package app.domain.model.mapper.vaccine;

import app.domain.model.data.employees.Employee;
import app.domain.model.data.vaccine.VaccineAdministration;
import app.domain.model.dto.employees.EmployeeDto;
import app.domain.model.dto.vaccine.VaccineAdministrationDto;

public class VaccineAdministrationMapper {

    /**
     * Class that deals with the dto objects that carry the information
     * of VaccineAdministration objects
     *
     * @author Pedro Campos <1211511@isep.ipp.pt>
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     * @author Lucas Gonçalves <1211601@isep.ipp.pt>
     */


    /**
     * Method to transform an VaccineAdministration into an VaccineAdministrationDto carrying the information of the VaccineAdministration
     *
     * @param vaccineAdministration Object that carries all the information of a Employee
     *
     * @return VaccineAdministrationDto
     */
    public static VaccineAdministrationDto toVaccineAdministrationDto(VaccineAdministration vaccineAdministration){
        return new VaccineAdministrationDto(vaccineAdministration.getSnsUserNumber(), vaccineAdministration.getVaccineName(), vaccineAdministration.getDose(), vaccineAdministration.getLotNumber(), vaccineAdministration.getScheduleDate(), vaccineAdministration.getScheduleHour(), vaccineAdministration.getArrivalDate(), vaccineAdministration.getArrivalHour(), vaccineAdministration.getNurseAdministrationDate(), vaccineAdministration.getNurseAdministrationHour(), vaccineAdministration.getLeavingDate(), vaccineAdministration.getLeavingHour(), vaccineAdministration.getVaccinationCenter());
    }

    /**
     * Method to transform a dto carrying the information of a VaccineAdministrationDto into a VaccineAdministration object
     *
     * @param vaccineAdministrationDto Object that carries all the information of a VaccineAdministration
     *
     * @return vaccineAdministration
     */
    public static VaccineAdministration toVaccineAdministration (VaccineAdministrationDto vaccineAdministrationDto){
        return new VaccineAdministration(vaccineAdministrationDto.getSnsUserNumber(),vaccineAdministrationDto.getVaccineName(),vaccineAdministrationDto.getDose(),vaccineAdministrationDto.getLotNumber(),vaccineAdministrationDto.getScheduleDate(),vaccineAdministrationDto.getScheduleHour(),vaccineAdministrationDto.getArrivalDate(),vaccineAdministrationDto.getArrivalHour(),vaccineAdministrationDto.getNurseAdministrationDate(),vaccineAdministrationDto.getNurseAdministrationHour(),vaccineAdministrationDto.getLeavingDate(),vaccineAdministrationDto.getLeavingHour(), vaccineAdministrationDto.getVaccinationCenter());
    }
}
