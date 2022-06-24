package app.domain.store.snsuser;

import app.controller.App;
import app.domain.model.data.snsuser.SnsUser;
import app.domain.model.dto.snsuser.SnsUserDto;
import app.domain.model.mapper.snsuser.SnsUserMapper;
import app.domain.shared.Constants;
import app.domain.store.vaccine.VaccineAdministrationStore;
import app.domain.utils.Notification;
import app.domain.utils.NotificationSender;
import app.domain.utils.PasswordGenerator;
import app.domain.utils.PasswordSaver;
import pt.isep.lei.esoft.auth.AuthFacade;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Class to store and create all the Sns Users of the system
 *
 * @author Diogo Teixeira <1200904@isep.ipp.pt>
 */


public class SnsUserStore {

    private final Map<String, SnsUser> snsUsers;
    private final List<String> phoneNumbers;
    private final List<String> citizenCardNumbers;

    public SnsUserStore() {
        this.snsUsers = new HashMap<>();
        this.phoneNumbers = new ArrayList<>();
        this.citizenCardNumbers = new ArrayList<>();
    }

    /**
     * Method to create a new SNS User
     *
     * @param dto Object that contains all the information of a SNS User
     *
     * @return The new SNS User
     */
    public SnsUser createSnsUser(SnsUserDto dto){

        SnsUser snsUser = SnsUserMapper.toSnsUser(dto);

        validateUser(snsUser);

        return snsUser;

    }

    /**
     * Method to validate that the User don't exist in the system
     * @param snsUser SNS User that we want to validate
     */
    private void validateUser(SnsUser snsUser){

        if(snsUsers.containsKey(snsUser.getSnsNumber())){
            throw new IllegalArgumentException("There is already a Sns User with this SNS Number");
        } else if (phoneNumbers.contains(snsUser.getPhoneNumber())){
            throw new IllegalArgumentException("There is already a Sns User with this phone number");
        } else if (App.getInstance().getCompany().getAuthFacade().existsUser(snsUser.getEmail().getEmail())){
            throw new IllegalArgumentException("There is already a Sns User with this e-mail");
        } else if (citizenCardNumbers.contains(snsUser.getCitizenCardNumber())){
            throw new IllegalArgumentException("There is already a Sns User with this citizen card number");
        }

    }

    /**
     * Method to register teh SNS User in the system
     *
     * @param snsUser SNS User that we want to register
     *
     * @return success/failure
     */
    public boolean registerSnsUser(SnsUser snsUser){

        AuthFacade authFacade = App.getInstance().getCompany().getAuthFacade();
        Email email = snsUser.getEmail();
        String name = snsUser.getName();
        //boolean existsSnsUser = App.getInstance().getCompany().getAuthFacade().existsUser(email.getEmail()); //already in the validate user step
        String password = PasswordGenerator.pwdGenerator(7,3,2);
        addSnsUser(snsUser);
        addSnsUserPhone(snsUser);
        addCitizenCardNumber(snsUser);

        try {
        PasswordSaver.saveSnsUserPassword(snsUser.getEmail().getEmail(),password);
        NotificationSender.sendNotification(new Notification(snsUser.getEmail().getEmail(),"You sucessfully registered in the dgs app"));
        }catch (IOException e){
            e.printStackTrace();
        }


        return authFacade.addUserWithRole(name,email.getEmail(),password, Constants.ROLE_SNS_USER);

    }

    /**
     * Method to add to our map of SNS Users a certain SNS User
     *
     * @param snsUser SNS User that we want to add
     */
    private void addSnsUser (SnsUser snsUser){
        this.snsUsers.put(snsUser.getSnsNumber(),snsUser);
    }

    /**
     * Method to add to our list of phone numbers the phone number of a valid sns user that we are registering in the system
     * @param snsUser valid sns user that we are registering in the system
     */
    private void addSnsUserPhone (SnsUser snsUser){
        this.phoneNumbers.add(snsUser.getPhoneNumber());
    }

    /**
     * Method to add to our list of citizen card numbers of a valid sns user that we are registering in the system
     * @param snsUser valid sns user that we are registering in the system
     */
    private void addCitizenCardNumber (SnsUser snsUser){
        this.citizenCardNumbers.add(snsUser.getCitizenCardNumber());
    }

    /**
     * Method to verify if the sns number exists in the store
     * @param snsNumber
     * @return boolean
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public boolean verifySnsNumber (String snsNumber){
        if (snsUsers.containsKey(snsNumber)){
            return true;
        }else{
            throw new IllegalArgumentException("SNS number doesn´t exist.");
        }
    }

    /**
     * Get method to obtain the map of SNS Users of the system
     *
     * @return map of SNS Users
     */
    public Map<String, SnsUser> getSnsUsers() {
        return snsUsers;
    }

    /**
     * Get method to obtain the list of phone numbers assigned to the already registered users
     * @return list of phone numbers assigned to the already registered users
     */
    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }


    /**
     * Get method to obtain the list of citizen card numbers assigned to the already registered users
     * @return list of citizen card numbers assigned to the already registered users
     */
    public List<String> getCitizenCardNumbers() {
        return citizenCardNumbers;
    }

    public SnsUser getSnsUser (String snsUserNumber){

        return snsUsers.get(snsUserNumber);
    }

    public SnsUser getSnsUserByEmail (String snsUserEmail){

        for (SnsUser user : snsUsers.values()){

            if(user.getEmail().getEmail().equals(snsUserEmail)){
                return user;
            }
        }

        return null;
    }

    /**
     * Method to get the sns user by the sns number
     * @param snsNumber string with the number
     * @return sns user object
     */
    public SnsUser getSnsUserBySnsNumber (String snsNumber){

        for (SnsUser user : snsUsers.values()){

            if(user.getSnsNumber().equals(snsNumber)){
            //if(user.getEmail().getEmail().equals(snsUserEmail)){
                return user;
            }
        }

        return null;
    }

    /**
     * Method to export the snsUserStore to a file
     * @param snsUserStore
     * @param file
     * @return
     */
    public static boolean saveSnsUserList(SnsUserStore snsUserStore, String file) {

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            try {
                out.writeObject(snsUserStore);
            } finally {
                out.close();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Method to import the snsUserStore from a file
     * @param file
     * @return snsUserStore
     */
    public static SnsUserStore importSnsUserList(String file){
        SnsUserStore snsUserStore;

        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            try{
                snsUserStore = (SnsUserStore) in.readObject();
            }finally {
                in.close();
            }
            return snsUserStore;
        }catch (IOException | ClassNotFoundException e){
            return new SnsUserStore();
        }
    }

}
