package app.domain.model.dto.snsuser;


import pt.isep.lei.esoft.auth.domain.model.Email;

/**
 * Class to carry all the information of a certain SNS user
 *
 * @author Diogo Teixeira <12000904@isep.ipp.pt>
 */

public class SnsUserDto {

    private final String name; //mandatory
    private final String address; //mandatory
    private final String sex; // optional
    private final String phoneNumber; //mandatory and unique
    private final String email; //mandatory and unique
    private final String birthDate; //mandatory
    private final String snsNumber; //mandatory and unique
    private final String citizenCardNumber; //mandatory and unique
    private final int smsPermission; // mandatory

    /**
     * Contructor of the dto class that represents a sns user
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
    public SnsUserDto(String name, String address, String sex, String phoneNumber,String email, String birthDate, String snsNumber, String citizenCardNumber, int smsPermission) {
        this.name = name;
        this.address = address;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthDate = birthDate;
        this.snsNumber = snsNumber;
        this.citizenCardNumber = citizenCardNumber;
        this.smsPermission = smsPermission;
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
     * @return
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
    public String getEmail() {
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


}
