package app.domain.store.vaccine;


import app.domain.model.data.centers.VaccinationCenter;
import app.domain.model.data.employees.Employee;
import app.domain.model.data.snsuser.SnsUser;
import app.domain.model.data.vaccine.VaccineAdministration;
import app.domain.model.dto.employees.EmployeeDto;
import app.domain.model.dto.vaccine.VaccineAdministrationDto;
import app.domain.model.mapper.vaccine.VaccineAdministrationMapper;
import app.domain.store.snsuser.SnsUserStore;
import app.domain.utils.Date;
import app.domain.utils.Hour;
import app.domain.utils.Notification;
import app.domain.utils.NotificationSender;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to store and create all the VaccinationAdministration objects
 *
 * @author Pedro Campos <1211511@isep.ipp.pt>
 * @author Lucas Gonçalves <1211601@isep.ipp.pt>
 * @author Nuno Cunha <1211689@isep.ipp.pt>
 */


public class VaccineAdministrationStore implements Serializable {

    private final List<VaccineAdministration> vaccineAdministrations;

    public VaccineAdministrationStore(){

        this.vaccineAdministrations = new ArrayList<VaccineAdministration>();

    }

    /**
     * Method to create a new VaccineAdministration
     *
     * @param vaccineAdministrationDto Object that contains all the information of a VaccineAdministration
     *
     * @return the new vaccineAdministration
     */

    public VaccineAdministration createVaccineAdministration(VaccineAdministrationDto vaccineAdministrationDto){
        VaccineAdministration vaccineAdministration = new VaccineAdministration(vaccineAdministrationDto.getSnsUserNumber(),vaccineAdministrationDto.getVaccineName(),vaccineAdministrationDto.getDose(),vaccineAdministrationDto.getLotNumber(),vaccineAdministrationDto.getScheduleDate(),vaccineAdministrationDto.getScheduleHour(),vaccineAdministrationDto.getArrivalDate(),vaccineAdministrationDto.getArrivalHour(),vaccineAdministrationDto.getNurseAdministrationDate(),vaccineAdministrationDto.getNurseAdministrationHour(),vaccineAdministrationDto.getLeavingDate(),vaccineAdministrationDto.getLeavingHour(), vaccineAdministrationDto.getVaccinationCenter());

        validateVaccineAdministration(vaccineAdministration);

        return vaccineAdministration;
    }

    /**
     * Method to validate that vaccineAdministration doesn't exist in the system
     * @param vaccineAdministration vaccineAdministration that we want to validate
     */
    private void validateVaccineAdministration(VaccineAdministration vaccineAdministration){
        if (vaccineAdministrations.contains(vaccineAdministration)){
            throw new IllegalArgumentException("There is already this VaccineAdministration registered in the system");
        }
    }


    /**
     * method to add to our map of VaccineAdministrations a certain VaccineAdministration
     *-
     * @param vaccineAdministration vaccineAdministration that we want to add
     */
    public void addVaccineAdministration(VaccineAdministration vaccineAdministration){
        this.vaccineAdministrations.add(vaccineAdministration);
    }

    /**
     * Method to get the vaccine administrations
     * @return vaccine administrations
     */
    public List<VaccineAdministration> getVaccineAdministrations() {
        return vaccineAdministrations;
    }

    /**
     * Method to get the vaccine administrations in a certain date at a certain center
     * @param date1 date desired
     * @param vaccinationCenter vaccination center desired
     * @return list with the desired data
     */
    public List<VaccineAdministration> getVaccineAdministrationsByDateAndCenter (Date date1, VaccinationCenter vaccinationCenter){
        List<VaccineAdministration> list =new ArrayList<>();
        for (VaccineAdministration vaccineAdministration: this.vaccineAdministrations){
            if (vaccineAdministration.getArrivalDate().equals(date1) && vaccineAdministration.getVaccinationCenter().equals(vaccinationCenter)){
                list.add(vaccineAdministration);
            }
        }
        return list;
    }

    /**
     * method to get the vaccine administrations in a certain center
     * @param vaccinationCenter desired vaccination center
     * @return list with the data
     */
    public List<VaccineAdministration> getVaccineAdministrationsByVaccinationCenter ( VaccinationCenter vaccinationCenter){
        List<VaccineAdministration> list =new ArrayList<>();
        for (VaccineAdministration vaccineAdministration: this.vaccineAdministrations){
            if (vaccineAdministration.getVaccinationCenter().equals(vaccinationCenter)){
                list.add(vaccineAdministration);
            }
        }
        return list;
    }

    /**
     * Method to create a vaccine administration
     * @param vaccineAdministrationDto dto object with a vaccine administration data
     * @return vaccine administration object
     */
    public VaccineAdministration createNewVaccineAdministration(VaccineAdministrationDto vaccineAdministrationDto){
        return VaccineAdministrationMapper.toVaccineAdministration(vaccineAdministrationDto);
    }

    /**
     * Method to save a new vaccine administration
     * @param vaccineAdministrationDto vaccine administration object
     */
    public void saveVaccineAdministration(VaccineAdministrationDto vaccineAdministrationDto){

        VaccineAdministration vaccineAdministration = VaccineAdministrationMapper.toVaccineAdministration(vaccineAdministrationDto);

        if (vaccineAdministrations.contains(vaccineAdministration)){
            throw new IllegalArgumentException("Vaccine administration already exists");
        }else{
            vaccineAdministrations.add(vaccineAdministration);
        }
    }


    /**
     * Method to export the vaccineAdministrationStore to a file
     * @param vaccineAdministrationStore
     * @param file
     * @return
     */
    public static boolean saveVaccineAdministrationList(VaccineAdministrationStore vaccineAdministrationStore, String file) {

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            try {
                out.writeObject(vaccineAdministrationStore);
            } finally {
                out.close();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Method to import the vaccineAdministrationStore from a file
     * @param file
     * @return vaccineAdministrationStore
     */
    public static VaccineAdministrationStore importVaccineAdministrationList(String file){
        VaccineAdministrationStore vaccineAdministrationStore;

        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            try{
                vaccineAdministrationStore = (VaccineAdministrationStore) in.readObject();
            }finally {
                in.close();
            }
            return vaccineAdministrationStore;
        }catch (IOException | ClassNotFoundException e){
            return new VaccineAdministrationStore();
        }
    }


    public void createNotification(VaccineAdministration vaccineAdministration, SnsUserStore snsUserStore){

    }



}
