package app.domain.model.dto.centers;

import app.domain.model.data.employees.Coordinator;
import app.domain.utils.Date;
import app.domain.utils.Hour;

import java.util.HashMap;

/**
 * Class that represents a vaccination center as a dto
 *
 * @author Diogo Teixeira <1200904@isep.ipp.pt>
 */
public class VaccinationCenterDto {

    private final String name;
    private final String address ;
    private final String phoneNumber ;
    private final String email;
    private final String fax;
    private final String websiteAddress;
    private Coordinator centerCoordinator;
    private final Hour openHour;
    private final Hour closeHour;
    private final int slotDuration;
    private final int capacity;

    private HashMap<Date,Integer> dailyVaccinated; // method to see the vaccinated in a certain date


    /**
     * Constructor of the class
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
     */
    public VaccinationCenterDto(String name, String address, String phoneNumber, String email, String fax, String websiteAddress, Hour openHour, Hour closeHour, int slotDuration, int capacity) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.fax = fax;
        this.websiteAddress = websiteAddress;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.slotDuration = slotDuration;
        this.capacity = capacity;
    }

    public VaccinationCenterDto(String name, String address, String phoneNumber, String email, String fax, String websiteAddress, Hour openHour, Hour closeHour, int slotDuration, int capacity,HashMap<Date,Integer> dailyVaccinated) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.fax = fax;
        this.websiteAddress = websiteAddress;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.slotDuration = slotDuration;
        this.capacity = capacity;
        this.dailyVaccinated = dailyVaccinated;
    }

    /**
     * Get method to obtain the name of the vaccination center
     *
     * @return name of the vaccination center
     */
    public String getName() {
        return name;
    }

    /**
     * Get method to obtain the vaccination center address
     * @return vaccination center address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Get method to obtain the vaccination center phone number
     *
     * @return vaccination center phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Get method to obtain the vaccination center email
     * @return vaccination center email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get method to obtain the fax of the vaccination center
     * @return fax of the vaccination center
     */
    public String getFax() {
        return fax;
    }

    /**
     * Get method to obtain the website address of the vaccination center
     * @return website address of the vaccination center
     */
    public String getWebsiteAddress() {
        return websiteAddress;
    }

    /**
     * Get method to obtain the center coordinator of the vaccination center
     * @return center coordinator of the vaccination center
     */
    public Coordinator getCenterCoordinator() {
        return centerCoordinator;
    }

    /**
     * Get method to obtain the opening hour of the vaccination center
     * @return opening hour of the vaccination center
     */
    public Hour getOpenHour() {
        return openHour;
    }

    /**
     * Get method to obtain the close hour of the vaccination center
     * @return close hour of the vaccination center
     */
    public Hour getCloseHour() {
        return closeHour;
    }

    /**
     * Get method to obtain the slot duration of the vaccination center
     * @return slot duration of the vaccination center
     */
    public int getSlotDuration() {
        return slotDuration;
    }

    /**
     * Get method to obtain the capacity of the vaccination center
     * @return
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Set the center coordinator method
     * @param centerCoordinator center coordinator
     */
    public void setCenterCoordinator(Coordinator centerCoordinator) {
        this.centerCoordinator = centerCoordinator;
    }

    public HashMap<Date, Integer> getDailyVaccinated() {
        return dailyVaccinated;
    }

    @Override
    public String toString() {
        return "VaccinationCenter: " + name + "\n" +
                "Address: " + address + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "E-mail: " + email + "\n" +
                "Fax: " + fax + "\n" +
                "Website: " + websiteAddress + "\n" +
                "Center Coordinator: " + centerCoordinator + "\n" +
                openHour + "\n"  + closeHour + "\n" + slotDuration + "\n" + "\n" + capacity + "\n" ;
    }
}
