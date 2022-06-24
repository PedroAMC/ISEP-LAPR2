package app.domain.model.data;

/**
 * Class that represents the vaccines
 *
 * @author Lucas Gonçalves <1211601@isep.ipp.pt>
 */

public class Vaccine {

    private String name;
    private String brand;
    private int totalAmountDoses;
    private int vaccineDosage;
    private int minAge;
    private int maxAge;
    private int intervalBetweenDoses;
    private int type;

    /**
     * Constructor of Vaccine class
     *
     * @param name Name of the vaccine
     * @param brand Brand of the brand
     * @param totalAmountDoses Number of total amount of doses to be administered
     * @param vaccineDosage Quantity of vaccine to administer
     * @param minAge Minimum age for the age group
     * @param maxAge Maximum age for the age group
     * @param intervalBetweenDoses Time interval between doses
     * @param type Vaccine type
     */
    public Vaccine(String name, String brand, int totalAmountDoses, int vaccineDosage, int minAge, int maxAge, int intervalBetweenDoses, int type){

        this.name = name;
        this.brand = brand;
        this.totalAmountDoses = totalAmountDoses;
        this.vaccineDosage = vaccineDosage;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.intervalBetweenDoses = intervalBetweenDoses;
        this.type = type;
    }

    public Vaccine(){}

    @Override
    public String toString() {
        return "Vaccine: \n" +
                "name=" + name + "\n" +
                "brand=" + brand + "\n" +
                "totalAmountDoses= " + totalAmountDoses + "\n" +
                "vaccineDosage= " + vaccineDosage + "\n" +
                "minAge= " + minAge + "\n" +
                "maxAge= " + maxAge + "\n" +
                "intervalBetweenDoses= " + intervalBetweenDoses + "\n" +
                "type= " + type +  "\n";
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
    public int getVaccineDosage() { return vaccineDosage; }

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
    public int getType() { return type; }

    /**
     * Method to set the vaccine name
     *
     */
    public void setName(String name) {this.name = name;}

    /**
     * Method to set the vaccine brand
     *
     */
    public void setBrand(String brand) {this.brand = brand;}

    /**
     * Method to set the total amount of doses
     *
     */
    public void setTotalAmountDoses(int totalAmountDoses) { this.totalAmountDoses = totalAmountDoses; }

    /**
     * Method to set the total amount of doses
     *
     */
    public void setVaccineDosage(int vaccineDosage) { this.vaccineDosage = vaccineDosage; }

    /**
     * Method to set the time interval between doses, in days
     *
     */
    public void setIntervalBetweenDoses(int intervalBetweenDoses) { this.intervalBetweenDoses = intervalBetweenDoses; }

    /**
     * Method to set the lowest possible age to get the vaccine administered, for these parameters
     *
     */
    public void setMinAge(int minAge) { this.minAge = minAge; }

    /**
     * Method to set the highest possible age to get the vaccine administered, for these parameters
     *
     */
    public void setMaxAge(int maxAge) { this.maxAge = maxAge; }

    /**
     * Method to set the type of vaccine associated
     *
     */
    public void setType(int type) { this.type = type; }
}
