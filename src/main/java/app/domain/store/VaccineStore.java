package app.domain.store;

import app.controller.RegisterVaccineController;
import app.domain.model.data.Vaccine;
import app.domain.model.data.vaccine.VaccineType;
import app.domain.shared.VaccineTechnology;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class Vaccine Store
 *
 * @author Nuno Cunha <1211689@isep.ipp.pt>
 */
public class VaccineStore {
    private final List<Vaccine> vaccineList=new ArrayList<>();

    /**
     * Constructor of the class
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public VaccineStore(){}

    /**
     * Method to add vaccine
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public void addVaccine(Vaccine vac){
        vaccineList.add(vac);
        //vaccineList.add(RegisterVaccineController.getNewVaccine());
    }

    /**
     * Method to get the list of vaccines
     * @return vaccineList
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public List<Vaccine> getVaccineList(){ return vaccineList; }

    /**
     * Method to verify the message
     * @param vaccine vaccine from the list
     * @return String with the message
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public String verificationMessage(Vaccine vaccine){

        return String.format("The vaccine that will be created will be: \nName= %s\nBrand= %s\nTotal Amount of Doses= %d\nVaccine dosage= %d\nYear interval= %d-%d\nTime interval between doses= %d\n", vaccine.getName(), vaccine.getBrand(), vaccine.getTotalAmountDoses(), vaccine.getVaccineDosage(), vaccine.getMinAge(), vaccine.getMaxAge(), vaccine.getIntervalBetweenDoses());

    }


    /**
     * Method to get vaccine
     * @param age age of the sns user
     * @param vaccineType vaccine type required
     * @return vaccine scheduled
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public Vaccine getVaccine(String age, VaccineType vaccineType){

        Vaccine desiredVaccine = null;

        for (Vaccine v : vaccineList){
            if (Integer.parseInt(age)>v.getMinAge() && Integer.parseInt(age)<v.getMaxAge() && Objects.equals(vaccineType.getTechnology(), String.valueOf(v.getType()))){
                desiredVaccine = v;
            }
        }

        return desiredVaccine;
    }
    public Vaccine getVaccineByVaccineName(String vaccineName){
        for (Vaccine v : vaccineList){
            if(v.getName().equals(vaccineName)){
                return v;
            }
        }

        return null;
    }



}
