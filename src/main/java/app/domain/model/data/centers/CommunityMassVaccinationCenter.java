package app.domain.model.data.centers;


import app.domain.model.data.employees.Coordinator;
import app.domain.model.data.vaccine.VaccineType;
import app.domain.utils.Date;
import app.domain.utils.Hour;


import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Class to represent the community mass vaccination center
 *
 * @author Diogo Teixeira <1200904@isep.ipp.pt>
 */
public class CommunityMassVaccinationCenter extends VaccinationCenter {

    private final List<VaccineType> avaiableTypes;

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
     */
    public CommunityMassVaccinationCenter(String name, String address, String phoneNumber, String email, String fax, String websiteAddress, Coordinator centerCoordinator, Hour openHour, Hour closeHour, int slotDuration, int capacity, List<VaccineType> avaiableTypes) {
        super(name, address, phoneNumber, email, fax, websiteAddress, centerCoordinator, openHour, closeHour, slotDuration, capacity);
        if(avaiableTypes.size() == 1){
            this.avaiableTypes = avaiableTypes;
        }else if(avaiableTypes.size() == 0){
            throw new IllegalArgumentException("The Community mass center has to administrate one type of vaccine");
        }else{
            throw new IllegalArgumentException("The Community mass center can only administrate one type of vaccine");
        }

    }

    public CommunityMassVaccinationCenter(String name, String address, String phoneNumber, String email, String fax, String websiteAddress, Coordinator centerCoordinator, Hour openHour, Hour closeHour, int slotDuration, int capacity, List<VaccineType> avaiableTypes, HashMap<Date,Integer> dailyVaccinated ) {
        super(name, address, phoneNumber, email, fax, websiteAddress, centerCoordinator, openHour, closeHour, slotDuration, capacity,dailyVaccinated);
        if(avaiableTypes.size() == 1){
            this.avaiableTypes = avaiableTypes;
        }else if(avaiableTypes.size() == 0){
            throw new IllegalArgumentException("The Community mass center has to administrate one type of vaccine");
        }else{
            throw new IllegalArgumentException("The Community mass center can only administrate one type of vaccine");
        }

    }
    /**
     * Method to add new vaccine types to the avaiable list
     * @param type new vaccine type
     * @return added or not
     */
    public boolean addVaccineType(VaccineType type){

        if(avaiableTypes.size() == 1){
            throw new IllegalArgumentException("The Community mass center can only administrate one type of vaccine");
        }else {
            return this.avaiableTypes.add(type);
        }
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
        return Objects.hash(super.hashCode(), avaiableTypes);
    }

    /**
     * Method to get the avaiable vaccine types
     * @return available vaccine types
     */
    public List<VaccineType> getAvaiableTypes() {
        return avaiableTypes;
    }

    /**
     * To string method
     * @return community mass center as a string
     */
    @Override
    public String toString() {
        return "CommunityMassVaccinationCenter: " + getName()+ "\n" +
                "Address: " + getAddress() + "\n" +
                "Phone Number: " + getPhoneNumber() + "\n" +
                "E-mail: " + getEmail().getEmail() + "\n" +
                "Fax: " + getFax() + "\n" +
                "Website: " + getWebsiteAddress() + "\n" +
                "Center Coordinator: " + getCenterCoordinator() + "\n" +
                getHours() + getSlot() +
                "Avaiable vaccine types: " + avaiableTypes + "\n";
    }
}
