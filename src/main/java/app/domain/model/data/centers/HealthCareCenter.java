package app.domain.model.data.centers;


import app.domain.model.data.employees.Coordinator;
import app.domain.model.data.vaccine.VaccineType;
import app.domain.shared.CenterAssociations;
import app.domain.utils.Date;
import app.domain.utils.Hour;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class HealthCareCenter extends VaccinationCenter {

    private final List<VaccineType> avaiableTypes;
    private final String associatedTo;

    /**
     * Constructor of the class
     * @param name name of the vaccination center
     * @param address address of the vaccination center
     * @param phoneNumber phone number of the vaccination center
     * @param email email of the vaccination center
     * @param fax fax of the vaccination center
     * @param websiteAddress website of the vaccination center
     * @param centerCoordinator coordinator of the vaccination center
     * @param openHour opening hours of the vaccination center
     * @param closeHour closing hours of the vaccination center
     * @param slotDuration slot duration of the vaccination center
     * @param capacity capacity of the vaccination center
     * @param avaiableTypes vaccine types avaible in the vaccination center
     * @param associatedTo organization that is associated to the center
     */

    public HealthCareCenter(String name, String address, String phoneNumber, String email, String fax, String websiteAddress, Coordinator centerCoordinator, Hour openHour, Hour closeHour, int slotDuration, int capacity, List<VaccineType> avaiableTypes, int associatedTo) {

        super(name, address, phoneNumber, email, fax, websiteAddress, centerCoordinator, openHour, closeHour, slotDuration, capacity);
        if(avaiableTypes.size() == 0){
            throw new IllegalArgumentException("Healthcare center must have at least one avaible vaccine type");
        }else{
            this.avaiableTypes = avaiableTypes;
        }
        if(associatedTo != 1 && associatedTo !=2){
            throw new IllegalArgumentException("Healthcare center must have a valid association");
        }else{
            this.associatedTo = CenterAssociations.getAssociation(associatedTo);
        }
    }

    public HealthCareCenter(String name, String address, String phoneNumber, String email, String fax, String websiteAddress, Coordinator centerCoordinator, Hour openHour, Hour closeHour, int slotDuration, int capacity, List<VaccineType> avaiableTypes, int associatedTo, HashMap<Date,Integer> dailyVaccinated) {

        super(name, address, phoneNumber, email, fax, websiteAddress, centerCoordinator, openHour, closeHour, slotDuration, capacity,dailyVaccinated);
        if(avaiableTypes.size() == 0){
            throw new IllegalArgumentException("Healthcare center must have at least one avaible vaccine type");
        }else{
            this.avaiableTypes = avaiableTypes;
        }
        if(associatedTo != 1 && associatedTo !=2){
            throw new IllegalArgumentException("Healthcare center must have a valid association");
        }else{
            this.associatedTo = CenterAssociations.getAssociation(associatedTo);
        }
    }

    /**
     * Method to add new vaccine types to the avaiable list
     * @param type new vaccine type
     * @return added or not
     */
    public boolean addVaccineType(VaccineType type){
        return this.avaiableTypes.add(type);
    }

    /**
     * Method to remove vaccine types from the avaiable list
     * @param type vaccine type to remove
     * @return removed or not
     */
    public boolean removeVaccineType(VaccineType type){
        return this.avaiableTypes.remove(type);
    }

    /**
     * Method to get the avaiable vaccine types
     * @return available vaccine types
     */
    public List<VaccineType> getAvaiableTypes() {
        return avaiableTypes;
    }

    /**
     * Method to obtain the organization associated to the center
     * @return organization associated to the center
     */
    public String getAssociatedTo() {
        return associatedTo;
    }

    /**
     * Equals method
     * @param o object to compare
     * @return equal or not
     */
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    /**
     * Hash code method
     * @return hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), avaiableTypes, associatedTo);
    }

    /**
     * To string method
     * @return community mass center as a string
     */
    @Override
    public String toString() {
        return "Health care center: " + getName()+ "\n" +
                "Address: " + getAddress() + "\n" +
                "Phone Number: " + getPhoneNumber() + "\n" +
                "E-mail: " + getEmail().getEmail() + "\n" +
                "Fax: " + getFax() + "\n" +
                "Website: " + getWebsiteAddress() + "\n" +
                "Center Coordinator: " + getCenterCoordinator() + "\n" +
                getHours() + getSlot() +
                "Avaiable vaccine types: " + avaiableTypes + "\n" +
                "Associated to: " + associatedTo + "\n";
    }
}
