package app.domain.model.data.centers;


import app.domain.model.data.snsuser.SnsUser;
import app.domain.model.data.employees.Coordinator;
import app.domain.model.dto.snsuser.SnsUserDto;
import app.domain.model.dto.utils.HourDto;
import app.domain.model.mapper.center.VaccinationCenterMapper;
import app.domain.utils.Date;
import app.domain.utils.Hour;
import app.domain.utils.Pair;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.time.Year;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Class to represent a vaccination center
 *
 * @author Diogo Teixeira <1200904@isep.ipp.pt>
 */
public class VaccinationCenter {

    private String name; //mandatory and unique
    private String address; //mandatory
    private String phoneNumber; //mandatory and unique
    private Email email; //mandatory and unique
    private String fax; //mandatory
    private String websiteAddress; //mandatory
    private List<Pair<SnsUser,Hour>> usersArrived; //updated in us 04
    private Coordinator centerCoordinator; //mandatory
    private HashMap<Integer,HashMap<Integer,HashMap<Integer,CenterDays>>> yearSchedule; //set by default with the current year
    private CenterHours hours; //mandatory
    private Slot slot; //mandatory
    private HashMap <Date,Integer> dailyVaccinated; // method to see the vaccinated in a certain date

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
     */
    public VaccinationCenter(String name, String address, String phoneNumber, String email, String fax, String websiteAddress, Coordinator centerCoordinator, Hour openHour, Hour closeHour, int slotDuration, int capacity) {
        validateData(name,address,phoneNumber,email,fax,websiteAddress);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = new Email(email);
        this.fax = fax;
        this.websiteAddress = websiteAddress;
        this.usersArrived = new ArrayList<>();
        this.centerCoordinator = centerCoordinator;
        this.yearSchedule = new HashMap<>();
        this.hours = new CenterHours(openHour,closeHour);
        this.slot = new Slot(slotDuration,capacity);
        fillYearSchedule(Calendar.getInstance().get(Calendar.YEAR));
    }

    public VaccinationCenter(String name, String address, String phoneNumber, String email, String fax, String websiteAddress, Coordinator centerCoordinator, Hour openHour, Hour closeHour, int slotDuration, int capacity,HashMap <Date,Integer> dailyVaccinated) {
        validateData(name,address,phoneNumber,email,fax,websiteAddress);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = new Email(email);
        this.fax = fax;
        this.websiteAddress = websiteAddress;
        this.usersArrived = new ArrayList<>();
        this.centerCoordinator = centerCoordinator;
        this.yearSchedule = new HashMap<>();
        this.hours = new CenterHours(openHour,closeHour);
        this.slot = new Slot(slotDuration,capacity);
        fillYearSchedule(Calendar.getInstance().get(Calendar.YEAR));
        this.dailyVaccinated = dailyVaccinated;
    }

    /**
     * Method to validate all the parameters of the constructor
     * @param name name of the vaccination center
     * @param address address of the vaccination center
     * @param phoneNumber phone number of the vaccination center
     * @param email email of the vaccination center
     * @param fax fax of the vaccination center
     * @param websiteAddress website of the vaccination center
     */
    private void validateData (String name, String address, String phoneNumber, String email, String fax, String websiteAddress){
        Pattern pattern = Pattern.compile("(http:\\/\\/|https:\\/\\/)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[\u200C\u200Ba-z]{3}\\.([a-z]+)?");

        if(name == null || name.isEmpty() || name.isBlank()){
            throw new IllegalArgumentException("Name is madatory");
        }

        if(address == null || address.isEmpty() || address.isBlank()){
            throw new IllegalArgumentException("Address is mandatory");
        }

        if (phoneNumber == null || phoneNumber.isBlank() || phoneNumber.isEmpty()){
            throw new IllegalArgumentException("Phone number is mandatory");
        }else if(phoneNumber.length() != 9){
            throw new IllegalArgumentException("Phone number must have 9 digits");
        }

        if(email == null || email.isEmpty() || email.isBlank()){
            throw new IllegalArgumentException("E-mail is mandatory");
        }else{
            try{
                new Email(email);
            }catch (IllegalArgumentException e){
                throw new IllegalArgumentException("Invalid e-mail type");
            }
        }

        if (fax == null || fax.isEmpty() || fax.isBlank() ){
            throw new IllegalArgumentException("Fax is mandatory");
        }else if(fax.length() != 12){
            throw new IllegalArgumentException("Fax must have 12 digits");
        }

        if (websiteAddress == null || websiteAddress.isEmpty() || websiteAddress.isBlank() ){
            throw new IllegalArgumentException("Phone number is mandatory");
        }else if(!pattern.matcher(websiteAddress).matches()){
            throw new IllegalArgumentException("Phone number must have 9 digits");
        }

    }

    /**
     * Method to fill with the given slots all the days of a given year
     * @param year year
     */
    public void fillYearSchedule (int year){

        boolean leap = Year.isLeap(year);

        //month, days of the month
        HashMap<Integer,Integer> monthDays = Date.generateMonths(leap);

        //month, day,centerday
        HashMap<Integer,HashMap<Integer,CenterDays>> months = new HashMap<>();

        for (int i = 1; i <= 12; i++) {

            int day = 1;
            //day, centerday
            HashMap<Integer,CenterDays> daysOfMonth = new HashMap<>();
            int j = monthDays.get(i);
            while(day != monthDays.get(i) + 1){

                daysOfMonth.put(day,new CenterDays(this.slot,this.hours));

                day ++;

            }

            months.put(i,daysOfMonth);
        }

        this.yearSchedule.put(year,months);

    }

    /**
     * Get method to obtain the vaccination center name
     * @return vaccination center name
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
     * @return vaccination center phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Get method to obtain the vaccination center email
     * @return vaccination center email
     */
    public Email getEmail() {
        return email;
    }

    /**
     * Get method to obtain the vaccination center fax
     * @return vaccination center fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * Get method to obtain the vaccination center website address
     * @return vaccination center website address
     */
    public String getWebsiteAddress() {
        return websiteAddress;
    }

    /**
     * Get method to obtain the vaccination center users that arrived
     * @return vaccination center users that arrived
     */
    public List<Pair<SnsUserDto, HourDto>> getUsersArrived() {
        usersArrived.sort(new Comparator<Pair<SnsUser, Hour>>() {
            @Override
            public int compare(Pair<SnsUser, Hour> o1, Pair<SnsUser, Hour> o2) {
                return o1.getSecond().compareTo(o2.getSecond());
            }
        });

        return VaccinationCenterMapper.usersArrivaltoDto(usersArrived);
    }


    /**
     * Get method to obtain the vaccination center coordinator
     * @return vaccination center coordinator
     */
    public Coordinator getCenterCoordinator() {
        return centerCoordinator;
    }

    /**
     * Get method to obtain the vaccination center year schedule
     * @return vaccination center year schedule
     */
    public HashMap<Integer, HashMap<Integer, HashMap<Integer, CenterDays>>> getYearSchedule() {
        return yearSchedule;
    }

    /**
     * Get method to obtain the vaccination center hours
     * @return vaccination center hours
     */
    public CenterHours getHours() {
        return hours;
    }

    /**
     * Get method to obtain the vaccination center slot
     * @return vaccination center slot
     */
    public Slot getSlot() {
        return slot;
    }

    /**
     * Set method to set the center coordinator
     * @param centerCoordinator center coordinator
     */
    public void setCenterCoordinator(Coordinator centerCoordinator) {
        this.centerCoordinator = centerCoordinator;
    }


    public HashMap<Date, Integer> getDailyVaccinated() {
        return dailyVaccinated;
    }

    /**
     * Method to add a user to the arrival list
     * @param user snsUser
     * @param hour arrivalHour
     */
    public void addArrival(SnsUser user, Hour hour){

        this.usersArrived.add(new Pair<SnsUser, Hour>(user, hour));
    }

    /**
     * Equals method
     * @param o object to compare
     * @return equal or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VaccinationCenter center = (VaccinationCenter) o;
        return phoneNumber == center.phoneNumber && Objects.equals(name, center.name) && Objects.equals(email, center.email);
    }

    /**
     * Hashcode method
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber, email);
    }

    /**
     * to string method
     * @return vaccination center as string
     */
    @Override
    public String toString() {
        return "VaccinationCenter: " + name + "\n" +
                "Address: " + address + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "E-mail: " + email + "\n" +
                "Fax: " + fax + "\n" +
                "Website: " + websiteAddress + "\n" +
                "Center Coordinator: " + centerCoordinator + "\n" +
                hours + slot ;
    }

}
