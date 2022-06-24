package app.domain.model.data.vaccine;

import app.domain.shared.VaccineTechnology;
import java.util.Objects;
import java.util.regex.Pattern;


/**
 * Class to represent the Vaccine Type
 *
 * @author Diogo Teixeira <1200904@isep.ipp.pt>
 */

public class VaccineType {

    private final String typeCode;
    private String shortDescription;
    private final String technology;

    /**
     * Constructor for the vaccine type class
     *
     * @param typeCode vaccine type code
     * @param shortDescription vaccine type description
     * @param technology vaccine type technology
     * @throws Exception throwable when some attribute fails to follow the rules
     */
    public VaccineType(String typeCode, String shortDescription,int technology) {
        validateAttributes(typeCode,shortDescription,technology);
        this.typeCode = typeCode;
        this.shortDescription = shortDescription;
        this.technology = VaccineTechnology.getTechnology(technology);
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
    public String getTechnology() {
        return technology;
    }

    /**
     * Set to change the value of the vaccine type description
     * @param shortDescription vaccine type description
     */
    public void setShortDescription(String shortDescription){

        if(shortDescription.length() > 30){
            throw new IllegalArgumentException("The description must be short, no more than 30 chars");
        }

        this.shortDescription = shortDescription;
    }


    /**
     * Method to verify all the attributes of vaccine type class
     *
     * @param typeCode code that refers to a certain vaccine type
     * @param shortDescription description of the vaccine type
     * @param technology technology behind the vaccine type
     * @throws Exception Throwable in the case something don't follow the rules
     */
    private void validateAttributes(String typeCode, String shortDescription,int technology) {

        //pattern used to verify if the type code has 5 alphanumeric chars
        Pattern pattern = Pattern.compile("([a-zA-Z]|[0-9]){5}");

        //validations to the type code
        if(typeCode.isBlank() || typeCode.isEmpty()){
            throw new IllegalArgumentException("The type code is a mandatory field !");
        }else if (typeCode.length() != 5){
            throw new IllegalArgumentException("The type code must have 5 alphanumeric chars");
        }else if(!pattern.matcher(typeCode).matches()){
            throw new IllegalArgumentException("The type code must be made of 5 alphanumeric chars");
        }

        //validations to the short description
        if(shortDescription.length() > 30){
            throw new IllegalArgumentException("The description must be short, no more than 30 chars");
        }

        //validation to the vaccine type technology
        if(technology < 1 || technology > 6){
            throw new IllegalArgumentException("The technology optional must be a number between 1 and 6");
        }


    }

    /**
     * Method equals to the vaccine type class
     *
     * @param o object to compare
     * @return boolean that indicates if the object is equal to the vaccine type
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VaccineType type = (VaccineType) o;
        return Objects.equals(typeCode, type.typeCode);
    }

    /**
     * HashCode method to the vaccine type class
     *
     * @return hascode of the vaccine type
     */
    @Override
    public int hashCode() {
        return Objects.hash(typeCode, shortDescription, technology);
    }

    /**
     * Method to represent the vaccine type as a string
     * @return vaccine type as a string
     */
    @Override
    public String toString() {
        return "VaccineType: \n" +
                "Code: " + typeCode + "\n" +
                "Description: " + shortDescription + "\n" +
                "Technology: " + technology + "\n" ;
    }
}
