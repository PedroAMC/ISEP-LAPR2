package app.domain.model.mapper.vaccine;

import app.domain.model.data.vaccine.AdministrationProcess;
import app.domain.model.dto.vaccine.AdministrationProcessDto;

public class AdministrationProcessMappper {

    /**
     * Constructor of the class
     *
     * Nuno Cunha <1211689@isep.ipp.pt>
     */
    public AdministrationProcessMappper() {}

    /**
     * Method to transform an AdministrationProcess into an AdministrationProcessDto carrying the information of the AdministrationProcess
     * @param administrationProcess administration process object
     * @return AdministrationProcessDto
     *
     * * Nuno Cunha <1211689@isep.ipp.pt>
     */
    public AdministrationProcessDto toAdministrationProcessDto(AdministrationProcess administrationProcess){
        return new AdministrationProcessDto(administrationProcess.getSnsUserNumber(),administrationProcess.getAge(),administrationProcess.getVaccine(),administrationProcess.getSchedule());
    }

    /**
     * Method to transform a dto carrying the information of a AdministrationProcessDto into a AdministrationProcess object
     * @param administrationProcessDto dto object with the data of an administration process
     * @return AdministrationProcess
     *
     * * Nuno Cunha <1211689@isep.ipp.pt>
     */
    public AdministrationProcess toAdministrationProcess(AdministrationProcessDto administrationProcessDto){
        return new AdministrationProcess(administrationProcessDto.getSnsUserNumber(),administrationProcessDto.getAge(),administrationProcessDto.getVaccine(),administrationProcessDto.getSchedule());
    }
}
