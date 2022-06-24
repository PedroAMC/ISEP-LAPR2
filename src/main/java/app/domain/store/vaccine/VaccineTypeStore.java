package app.domain.store.vaccine;


import app.domain.model.data.Vaccine;
import app.domain.model.data.vaccine.VaccineType;
import app.domain.model.dto.vaccine.VaccineTypeDto;
import app.domain.model.mapper.vaccine.VaccineTypeMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Store class of vaccine type
 *
 * @author Diogo Teixeira <1200904@isep.ipp.pt>
 */

public class VaccineTypeStore {

    List <VaccineType> vaccineTypes;

    /**
     * Constructor of the store class of vaccine types
     */
    public VaccineTypeStore() {
        this.vaccineTypes = new ArrayList<>();
    }

    /**
     * Method to create a new vaccine type and store it
     * @param dto vaccine type dto that contains the information of a new vaccine type
     */
    public void createVaccineType (VaccineTypeDto dto){

        VaccineType vaccineType = VaccineTypeMapper.toVaccineType(dto);

        validateType(vaccineType);

        addVaccineTypes(vaccineType);


    }

    /**
     * Method to verify if there is already the same vaccine type
     * as the one the user is trying to create
     * @param type new vaccine type
     */
    private void validateType(VaccineType type){

        if(this.vaccineTypes.contains(type)){

            throw new IllegalArgumentException("There is already this type of vaccine in the system");
        }
    }

    /**
     * Method to add a vaccine type to the existing list of vaccine types
     * @param type vaccine type
     */
    private void addVaccineTypes (VaccineType type){
        this.vaccineTypes.add(type);
    }

    /**
     * Method to get the avaiable vaccine types
     * @return list of vaccine types
     */
    public List<VaccineTypeDto> getVaccineTypes() {
        return VaccineTypeMapper.vaccineTypeListToDto(vaccineTypes);
    }


    public VaccineTypeDto getOngoingOutbreakType (String typeName){

        for(VaccineType type : vaccineTypes){

            if (Objects.equals(type.getShortDescription(), typeName)){
                return VaccineTypeMapper.toVaccineTypeDto(type);

            }
        }
        return null;
    }

}







