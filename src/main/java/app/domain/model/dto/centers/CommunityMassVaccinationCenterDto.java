package app.domain.model.dto.centers;

import app.domain.model.data.vaccine.VaccineType;
import app.domain.utils.Date;
import app.domain.utils.Hour;

import java.util.HashMap;
import java.util.List;

/**
 * Class to represent a community mass vaccination center as a dto
 *
 * @author Diogo Teixeira <1200904@isep.ipp.pt>
 */
public class CommunityMassVaccinationCenterDto extends VaccinationCenterDto{

    private final List<VaccineType> avaiableTypes;

    /**
     * Constructor of the dto
     * @param name name of the vaccination center
     * @param address address of the vaccination center
     * @param phoneNumber phone number of the vaccination center
     * @param email email of the vaccination center
     * @param fax fax of the vaccination center
     * @param websiteAddress website of the vaccination center
     * @param openHour opening hours of the vaccination center
     * @param closeHour closing hours of the vaccination center
     * @param slotDuration slot duration of the vaccination center
     * @param capacity capacity of the vaccination center
     * @param avaiableTypes vaccine types avaible in the vaccination center
     */
    public CommunityMassVaccinationCenterDto(String name, String address, String phoneNumber, String email, String fax, String websiteAddress, Hour openHour, Hour closeHour, int slotDuration, int capacity, List<VaccineType> avaiableTypes) {
        super(name, address, phoneNumber, email, fax, websiteAddress, openHour, closeHour, slotDuration, capacity);
        this.avaiableTypes = avaiableTypes;
    }

    public CommunityMassVaccinationCenterDto(String name, String address, String phoneNumber, String email, String fax, String websiteAddress, Hour openHour, Hour closeHour, int slotDuration, int capacity, List<VaccineType> avaiableTypes,HashMap<Date,Integer> dailyVaccinated) {
        super(name, address, phoneNumber, email, fax, websiteAddress, openHour, closeHour, slotDuration, capacity,dailyVaccinated);
        this.avaiableTypes = avaiableTypes;
    }


    /**
     * Method to get the available types
     * @return available types
     */
    public List<VaccineType> getAvaiableTypes() {
        return avaiableTypes;
    }


    @Override
    public String toString() {
        return "CommunityMassVaccinationCenter: " + getName()+ "\n" +
                "Address: " + getAddress() + "\n" +
                "Phone Number: " + getPhoneNumber() + "\n" +
                "E-mail: " + getEmail() + "\n" +
                "Fax: " + getFax() + "\n" +
                "Website: " + getWebsiteAddress() + "\n" +
                "Center Coordinator: " + getCenterCoordinator() + "\n" +
                getOpenHour() + "\n"  + getCloseHour() + "\n" + getSlotDuration() + "\n" + getCapacity() + "\n" +
                "Avaiable vaccine types: " + avaiableTypes + "\n";
    }
}
