package app.domain.store.center;


import app.domain.model.data.centers.VaccinationCenter;
import app.domain.model.dto.centers.VaccinationCenterDto;
import app.domain.model.mapper.center.VaccinationCenterMapper;
import app.domain.store.vaccine.VaccineAdministrationStore;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class to store all the vaccination centers
 *
 * @author Diogo Teixeira <1200904@isep.ipp.pt>
 */
public class VaccinationCenterStore {

    private final HashMap<String,VaccinationCenter> centers;
    private final List<String> phoneNumbers;
    private final List<Email> emails;

    /**
     * Constructor of the class
     */
    public VaccinationCenterStore() {
        this.centers = new HashMap<>();
        this.phoneNumbers = new ArrayList<>();
        this.emails = new ArrayList<>();
    }

    public VaccinationCenter findVaccinationCenter(String vaccinationCenterName){
        return centers.get(vaccinationCenterName);
    }

    /**
     * Method to create a new center and save it
     * @param dto new center
     */
    public void createCenter (VaccinationCenterDto dto){

        VaccinationCenter center = VaccinationCenterMapper.toVaccinationCenter(dto);
        validateCenter(center);

        addCenter(center);
        addCenterPhone(center);
        addCenterEmail(center);

    }

    /**
     * Method to validate the creation of a new vaccination center
     * checks if the name, phone number and email are unique
     * @param center new center
     */
    private void validateCenter (VaccinationCenter center){
        if(centers.containsKey(center.getName())){
            throw new IllegalArgumentException("There is already a vaccination center with this name");
        } else if(phoneNumbers.contains(center.getPhoneNumber())){
            throw new IllegalArgumentException("There is already a vaccination center with this phone number");
        } else  if (emails.contains(center.getEmail())){
            throw new IllegalArgumentException("There is already a vaccination center with this e-mail");
        }
    }

    /**
     * Method to add the center to the current centers map
     * @param center new center
     */
    private void addCenter (VaccinationCenter center){
        this.centers.put(center.getName(),center);
    }

    /**
     * Method to add the center phone number to the current centers phone numbers list
     * @param center center phone number
     */
    private void addCenterPhone (VaccinationCenter center){
        this.phoneNumbers.add(center.getPhoneNumber());
    }

    /**
     * Method to add the center email to the current centers emails list
     * @param center center email
     */
    private void addCenterEmail(VaccinationCenter center){
        this.emails.add(center.getEmail());
    }

    public VaccinationCenterDto getCenter (String vaccinationCenterName){

        return VaccinationCenterMapper.centerToDto(centers.get(vaccinationCenterName));
    }

    /**
     * Method to get the map with the centers
     * @return map with the centers
     */
    public List<VaccinationCenterDto> getListOfCenters() {

        List<VaccinationCenter> list = new ArrayList<>(centers.values());


        return VaccinationCenterMapper.listToDto(list);
    }

    /**
     * Method to get the list of the phone numbers
     * @return list of the phone numbers
     */
    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    /**
     * Method to get the list of the emails
     * @return list of the emails
     */
    public List<Email> getEmails() {
        return emails;
    }

    /**
     * Method to get a vaccination center object from the name
     * @param vaccinationCenterName string with the name
     * @return vaccination center
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public VaccinationCenter getVaccinationCenterByName(String vaccinationCenterName){

        for (VaccinationCenter vaccinationCenter : centers.values()){
            if (vaccinationCenter.getName().equals(vaccinationCenterName)){
                return vaccinationCenter;
            }
        }

        return null;
    }

    /**
     * Method to export the VaccinationCenterStore to a file
     * @param vaccinationCenterStore
     * @param file
     * @return
     */
    public static boolean saveVaccinationCenterList(VaccinationCenterStore vaccinationCenterStore, String file) {

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            try {
                out.writeObject(vaccinationCenterStore);
            } finally {
                out.close();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Method to import the VaccinationCenterStore from a file
     * @param file
     * @return vaccineAdministrationStore
     */
    public static VaccinationCenterStore importVaccineAdministrationList(String file){
        VaccinationCenterStore vaccinationCenterStore;

        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            try{
                vaccinationCenterStore = (VaccinationCenterStore) in.readObject();
            }finally {
                in.close();
            }
            return vaccinationCenterStore;
        }catch (IOException | ClassNotFoundException e){
            return new VaccinationCenterStore();
        }
    }
}
