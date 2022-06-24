package app.domain.model.dto.vaccine;

import app.domain.model.data.vaccine.VaccineType;

import java.util.Objects;

/**
 * Dto class of vaccine type
 *
 * @author Diogo Teixeira <1200904@isep.ipp.pt>
 */

public class VaccineTypeDto {

    private final String typeCode;
    private final String shortDescription;
    private final int technology;

    /**
     * Constructor for the dto vaccine type class
     * @param typeCode vaccine type code
     * @param shortDescription vaccine type description
     * @param technology vaccine type technology number of enum class vaccinetechnology
     */
    public VaccineTypeDto(String typeCode, String shortDescription, int technology) {
        this.typeCode = typeCode;
        this.shortDescription = shortDescription;
        this.technology = technology;
    }

    /**
     * Get method to return the vaccine type code
     * @return vaccine type code
     */
    public String getTypeCode() {
        return typeCode;
    }

    /**
     * Get method to return the short description of the vaccine type
     * @return description of the vaccine type
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Get method to return the vaccine type technology used
     * @return vaccine type technology used
     */
    public int getTechnology() {
        return technology;
    }

    /**
     * Method equals to the vaccine type dto class
     *
     * @param o
     * @return boolean with the result
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VaccineTypeDto type = (VaccineTypeDto) o;
        return Objects.equals(typeCode, type.getTypeCode());
    }

    @Override
    public String toString() {
        return "VaccineType: \n" +
                "Code: " + typeCode + "\n" +
                "Description: " + shortDescription + "\n" +
                "Technology: " + technology + "\n" ;
    }
}
