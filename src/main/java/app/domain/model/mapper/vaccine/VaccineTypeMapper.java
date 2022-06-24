package app.domain.model.mapper.vaccine;

import app.domain.model.data.vaccine.VaccineType;
import app.domain.model.dto.vaccine.VaccineTypeDto;
import app.domain.shared.VaccineTechnology;

import java.util.ArrayList;
import java.util.List;


/**
 * Class that deals with the dto objects that carry the information
 * of vaccine type
 *
 * @author Nuno Cunha <1211689@isep.ipp.pt>
 * @author Diogo Teixeira <1200904@isep.ipp.pt>
 */
public class VaccineTypeMapper {

    /**
     * Method to transform a vaccine type dto into a vaccine type object
     * @param dto vaccine type dto
     * @return vaccine type
     *
     * @author Diogo Teixeira <1200904@isep.ipp.pt>
     */
    public static VaccineType toVaccineType (VaccineTypeDto dto){
        return new VaccineType(dto.getTypeCode(),dto.getShortDescription(),dto.getTechnology());
    }

    /**
     * Method to transform a vaccine dto into a vaccine type
     * @param vaccineType vaccine type dto
     * @return dto
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public static VaccineTypeDto toVaccineTypeDto (VaccineType vaccineType) {
        return new VaccineTypeDto(vaccineType.getTypeCode(),vaccineType.getShortDescription(), VaccineTechnology.getIndex(vaccineType.getTechnology()));
    }

    /**
     * Method to transform a vaccine type list to a vaccine type dto list
     *
     * @param vaccineTypeList
     * @return vaccineTypeDtoList
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public static List<VaccineTypeDto> vaccineTypeListToDto (List<VaccineType> vaccineTypeList){
        List<VaccineTypeDto> vaccineTypeDtoList = new ArrayList<VaccineTypeDto>();
            for (VaccineType vaccineType : vaccineTypeList) {
                vaccineTypeDtoList.add(toVaccineTypeDto(vaccineType));
            }
        return vaccineTypeDtoList;
    }
}

