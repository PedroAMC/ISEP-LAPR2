package app.domain.model.dto;

/**
 * Class that represents the vaccines
 *
 * @author Lucas Gonçalves <1211601@isep.ipp.pt>
 */

public class VaccineDto {

    private String name;
    private String brand;
    private int totalAmountDoses;
    private int vacineDosage;
    private int minAge;
    private int maxAge;
    private int intervalBetweenDoses;
    private String type;

    /**
     * Constructor of Vaccine class
     *
     * @param name Name of the vaccine
     * @param brand Brand of the brand
     * @param totalAmountDoses Number of total amount of doses to be administered
     * @param vacineDosage Quantity of vaccine to administer
     * @param minAge Minimum age for the age group
     * @param maxAge Maximum age for the age group
     * @param intervalBetweenDoses Time interval between doses
     * @param type Vaccine type
     */
    public VaccineDto(String name, String brand, int totalAmountDoses, int vacineDosage, int minAge, int maxAge, int intervalBetweenDoses, String type){

        this.name = name;
        this.brand = brand;
        this.totalAmountDoses = totalAmountDoses;
        this.vacineDosage = vacineDosage;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.intervalBetweenDoses = intervalBetweenDoses;
        this.type = type;
    }


    /**
     * Method to get the vaccine name
     *
     * @return name
     */
    public String getName() { return name; }

    /**
     * Method to get the vaccine brand
     *
     * @return brand
     */
    public String getBrand() { return brand; }

    /**
     * Method to get the total amount of doses
     *
     * @return Total amount of doses to be administered
     */
    public int getTotalAmountDoses() { return totalAmountDoses; }

    /**
     * Method to get the quantity of dosage in ml
     *
     * @return Quantity of dosage
     */
    public int getVacineDosage() { return vacineDosage; }

    /**
     * Method to get the time interval between doses, in days
     *
     * @return the time interval between doses
     */
    public int getIntervalBetweenDoses() { return intervalBetweenDoses; }

    /**
     * Method to get the lowest possible age to get the vaccine administered, for these parameters
     *
     * @return Lowest age
     */
    public int getMinAge() { return minAge; }

    /**
     * Method to get the highest possible age to get the vaccine administered, for these parameters
     *
     * @return Highest age
     */
    public int getMaxAge() { return maxAge; }

    /**
     * Method to get the type of vaccine associated
     *
     * @return Vaccine type
     */
    public String getType() { return type; }

}
