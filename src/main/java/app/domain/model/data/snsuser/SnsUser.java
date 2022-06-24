package app.domain.model.data.snsuser;

import app.domain.model.data.Vaccine;
import app.domain.model.data.schedule.Schedule;
import app.domain.model.data.vaccine.VaccineAdministration;
import app.domain.model.dto.snsuser.SnsUserDto;
import app.domain.store.schedule.ScheduleStore;
import app.domain.store.snsuser.SnsUserStore;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Class that represents the SNS user
 *
 * @author Diogo Teixeira <12000904@isep.ipp.pt>
 */

public class SnsUser {

    private final String name; //mandatory
    private String address; //mandatory
    private String sex; // optional
    private final String phoneNumber; //mandatory and unique
    private final Email email; //mandatory and unique
    private final String birthDate; //mandatory
    private final String snsNumber; //mandatory and unique
    private final String citizenCardNumber; //mandatory and unique
    private int smsPermission; // mandatory

    /**
     * Constructor of Sns user class
     * @param name name of the sns user
     * @param address address of the sns user
     * @param sex sex of the sns user
     * @param phoneNumber phone number of the sns user
     * @param email email of the sns user
     * @param birthDate birthdate of the sns user
     * @param snsNumber sns number of sns user
     * @param citizenCardNumber citizen card number of sns user
     * @param smsPermission permission to receive notifications from dgs
     */
    public SnsUser(String name, String address,String sex, String phoneNumber, String email, String birthDate, String snsNumber, String citizenCardNumber, int smsPermission) {
        validateInformation(name,address,phoneNumber,email,birthDate,snsNumber,citizenCardNumber,smsPermission);
        this.name = name;
        this.address = address;
        if(sex == null || sex.isEmpty() || sex.isBlank()){
            this.sex = "n/a";
        }else{
            this.sex = sex;
        }
        this.phoneNumber = phoneNumber;
        this.email = new Email(email);
        this.birthDate = birthDate;
        this.snsNumber = snsNumber;
        this.citizenCardNumber = citizenCardNumber;
        this.smsPermission = smsPermission;
    }


    /**
     * Method to validate all the parameters given to create a new sns user
     * @param name name of the sns user
     * @param address address of the sns user
     * @param phoneNumber phone number of the sns user
     * @param email email of the sns user
     * @param birthDate birthdate of the sns user
     * @param snsNumber sns number of sns user
     * @param citizenCardNumber citizen card number of sns user
     * @param smsPermission permission to receive notifications from dgs
     */
    private void validateInformation(String name, String address, String phoneNumber, String email, String birthDate, String snsNumber, String citizenCardNumber, int smsPermission){
        Pattern pattern = Pattern.compile("[0-9]{2}/[0-9]{2}/[0-9]{4}");

        if(name == null || name.isBlank() || name.isEmpty()){
            throw new IllegalArgumentException("Name is madatory");
        }

        if(address == null || address.isBlank() || address.isEmpty()){
            throw new IllegalArgumentException("Address is mandatory");
        }

        if (phoneNumber == null || phoneNumber.isEmpty() || phoneNumber.isBlank() ){
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

        if(birthDate == null || birthDate.isEmpty() || birthDate.isBlank()){
            throw new IllegalArgumentException("Birth Date is mandatory");
        }else if(!pattern.matcher(birthDate).matches()){
            throw new IllegalArgumentException("Birth Date should follow the (dd/mm/yyyy) format");
        }

        if(snsNumber == null || snsNumber.isBlank() || snsNumber.isEmpty()){
            throw new IllegalArgumentException("Sns user number is mandatory");
        }else if(snsNumber.length() != 9){
            throw new IllegalArgumentException("Sns user number must have 9 digits ");
        }

        if(citizenCardNumber == null || citizenCardNumber.isEmpty() || citizenCardNumber.isBlank()){
            throw new IllegalArgumentException("Citizen card number is mandatory");
        }else if(citizenCardNumber.length() != 8){
            throw new IllegalArgumentException("Citizen card number must have 8 digits");
        }

        if(smsPermission != 1 && smsPermission != 0 ){
            throw new IllegalArgumentException("User must agree (1) or not (0) to receive SMS");
        }


    }

    /**
     * Get method to obtain the sns user name
     * @return sns user name
     */
    public String getName() {
        return name;
    }

    /**
     * Get method to obtain the address of the sns user
     * @return sns user address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Get method to obtain the sex of the sns user
     * @return sex of the sns user
     */
    public String getSex() {
        return sex;
    }

    /**
     * Get method to obtain the sns user phone number
     * @return sns user phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Get method to obtain the sns user email
     * @return sns user email
     */
    public Email getEmail() {
        return email;
    }

    /**
     * Get method to obtain the birthdate of the sns user
     * @return birthdate of the sns user
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Get method to obtain the sns number of the sns user
     * @return sns number of the sns user
     */
    public String getSnsNumber() {
        return snsNumber;
    }

    /**
     * Get method to obtain the citizen card number of the sns user
     * @return citizen card number of the sns user
     */
    public String getCitizenCardNumber() {
        return citizenCardNumber;
    }

    /**
     * Get method to obtain the sms permission definition of the sns user
     * @return sms permission definition of the sns user
     */
    public int getSmsPermission() {
        return smsPermission;
    }

    /**
     * Set method to change the sns user address
     * @param address sns user address
     */
    public void setAddress(String address) {
        if(address == null || address.isBlank() || address.isEmpty()){
            throw new IllegalArgumentException("Address is mandatory");
        }
        this.address = address;
    }

    /**
     * Set method to change the sns user sex
     * @param sex sns user sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Set method to change the sms permission definition of the sns user
     * @param smsPermission sms permission definition of the sns user
     */
    public void setSmsPermission(int smsPermission) {
        if(smsPermission != 1 && smsPermission != 0 ){
            throw new IllegalArgumentException("User must agree (1) or not (0) to receive SMS");
        }
        this.smsPermission = smsPermission;
    }


    /**
     * Method to get the vaccination status of a user
     * @param vaccineAdministrations
     * @param vaccine
     * @param snsNumber
     * @return
     */
    public String getVaccinationStatus(List<VaccineAdministration> vaccineAdministrations, Vaccine vaccine, String snsNumber){

        List<VaccineAdministration> vaccineAdmins = new ArrayList<>();

        for (VaccineAdministration v : vaccineAdministrations){
            if (Objects.equals(v.getSnsUserNumber(), snsNumber)){
                vaccineAdmins.add(v);
            }
        }

        int count_dose = 0;

        for (VaccineAdministration y : vaccineAdmins){
            if (y.getVaccineName() == vaccine.getName()){
                count_dose = count_dose + 1;
            }
        }


        if (count_dose == vaccine.getTotalAmountDoses()){
            return "Fully vaccinated";
        }

        return "Not fully vaccinated";
    }


    /**
     * Method equals for SNS user class
     * @param o object
     * @return boolean of equality or not
     */
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SnsUser snsUser = (SnsUser) o;
        return Objects.equals(snsNumber, snsUser.snsNumber);

    }

    /**
     * Method to obtain the hascode of an object from the class SNS user
     * @return SNS user hashcode
     */

    @Override
    public int hashCode() {
        return Objects.hash(name, address, sex, phoneNumber, email, birthDate, snsNumber, citizenCardNumber, smsPermission);
    }

    /**
     * Method to string to the object from SNS user class
     *
     * @return SNS user string
     */
    @Override
    public String toString() {
        return "SnsUser : \n" +
                "Name: " + name + "\n" +
                "Address: " + address + "\n" +
                "Sex: " + sex + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "E-mail: " + email + "\n" +
                "Birth Date: " + birthDate + "\n" +
                "Sns user number: " + snsNumber + "\n" +
                "Citizen card number: " + citizenCardNumber + "\n" +
                "SMS permission (1- yes/ 0- no): " + smsPermission + "\n";
    }
}
