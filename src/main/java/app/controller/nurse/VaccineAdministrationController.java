package app.controller.nurse;

import app.controller.App;
import app.domain.model.data.Vaccine;
import app.domain.model.data.centers.VaccinationCenter;
import app.domain.model.data.schedule.Schedule;
import app.domain.model.data.snsuser.SnsUser;
import app.domain.model.data.vaccine.VaccineAdministration;
import app.domain.model.data.vaccine.VaccineType;
import app.domain.model.dto.snsuser.SnsUserDto;
import app.domain.model.dto.utils.HourDto;
import app.domain.model.dto.vaccine.VaccineAdministrationDto;
import app.domain.model.mapper.vaccine.VaccineAdministrationMapper;
import app.domain.store.VaccineStore;
import app.domain.store.center.VaccinationCenterStore;
import app.domain.store.schedule.ScheduleStore;
import app.domain.model.dto.vaccine.AdministrationProcessDto;
import app.domain.store.vaccine.VaccineAdministrationStore;
import app.domain.utils.Pair;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;


/**
 * Controller class of the US08
 *
 * @author Nuno Cunha <1211689@isep.ipp.pt>
 */

public class VaccineAdministrationController {

    private VaccineStore vaccineStore;
    private VaccinationCenterStore vaccinationCenterStore;
    private ScheduleStore scheduleStore;
    private VaccinationCenter vaccinationCenter;
    private VaccineAdministration vaccineAdministration;
    private VaccineAdministrationStore store;

    /**
     * Constructor of the class
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public VaccineAdministrationController() {
        vaccineStore = App.getInstance().getCompany().getVaccineStore();
        vaccinationCenterStore = App.getInstance().getCompany().getVaccinationCenterStore();
        scheduleStore = App.getInstance().getCompany().getScheduleStore();
    }

    /**
     * Method to select the desired vaccination center
     *
     * Nuno Cunha <1211689@isep.ipp.pt>
     */
    public void desiredVaccinationCenter(String vaccinationCenterName){
        vaccinationCenter = vaccinationCenterStore.findVaccinationCenter(vaccinationCenterName);
    }

    /**
     * Method to get a vaccination center users arrived
     * @return users arrived
     *
     * Nuno Cunha <1211689@isep.ipp.pt>
     */
    public List<Pair<SnsUserDto, HourDto>> getUsersArrived() {
        return vaccinationCenter.getUsersArrived();
    }

    /**
     * Method to validate index
     * @param index index of the chosen center
     * @return boolean
     *
     * Nuno Cunha <1211689@isep.ipp.pt>
     */
     public boolean validateIndex(int index){
        if (index < 0 || index > vaccinationCenter.getUsersArrived().size()){
            return false;
        }
        return true;
     }

    /**
     * Method to get the dto object from the class snsUser
     * @param index index of the desired pair
     * @param usersArrived list of users arrived
     * @return sns user dto object
     *
     * Nuno Cunha <1211689@isep.ipp.pt>
     */
     public SnsUserDto getSnsUserDto(int index , List<Pair<SnsUserDto, HourDto>> usersArrived){
         SnsUserDto snsUserDto = usersArrived.get(index).getFirst();

         return snsUserDto;
     }

    /**
     * Method to get a sns user object
     * @param snsUserDto dto object with sns user
     * @return
     */
     public SnsUser getSnsUser(SnsUserDto snsUserDto){
         return new SnsUser(snsUserDto.getName(),snsUserDto.getAddress(),snsUserDto.getSex(),snsUserDto.getPhoneNumber(),snsUserDto.getEmail(),snsUserDto.getBirthDate(),snsUserDto.getSnsNumber(),snsUserDto.getCitizenCardNumber(),snsUserDto.getSmsPermission());
     }

    /**
     * Method to get a sns username
     * @param snsUserDto dto object with all the data
     * @return string with the name
     *
     * Nuno Cunha <1211689@isep.ipp.pt>
     */
     public String getSnsUserName(SnsUserDto snsUserDto){
         return snsUserDto.getName();
     }

    /**
     * Method to get the sns user age
     * @param snsUserDto dto object with all the data
     * @return string with the name
     *
     * Nuno Cunha <1211689@isep.ipp.pt>
     */
     public String getAge(SnsUserDto snsUserDto){
         int today = LocalDate.now().getYear();
         String[] ints = snsUserDto.getBirthDate().split("/" , 3);

         int age = today - Integer.parseInt(ints[3]);
         return String.valueOf(age);
     }


    /**
     * Method to get the schedule store
     * @return hashmap with the schedules
     *
     * Nuno Cunha <1211689@isep.ipp.pt>
     */
    public HashMap<String, HashMap<Schedule, VaccineType>> getScheduleStore(){
         return scheduleStore.getSchedules();
    }

    /**
     * Method to get schedule
     * @param snsUserDto dto object with the data
     * @return schedule
     *
     * Nuno Cunha <1211689@isep.ipp.pt>
     */
    public Schedule getSchedule (SnsUserDto snsUserDto){
        return scheduleStore.getSchedule(snsUserDto);
    }

    /**
     * Method to get vaccine type
     * @param snsUserDto dto object with the data
     * @return vaccine type
     *
     * Nuno Cunha <1211689@isep.ipp.pt>
     */
    public VaccineType getVaccineType(SnsUserDto snsUserDto){
        return scheduleStore.getVaccineType(snsUserDto);
    }


    public Vaccine getVaccine(String age, VaccineType vaccineType){
        return vaccineStore.getVaccine(age,vaccineType);
    }

    /**
     * Method to get the AdministrationProcess
     * @param snsUserNumber snsUser number
     * @param age String with age
     * @param vaccine vaccine object
     * @param schedule schedule object
     * @return administrationProcessDto object
     *
     * Nuno Cunha <1211689@isep.ipp.pt>
     */
    public AdministrationProcessDto getAdministrationProcess(String snsUserNumber, String age, Vaccine vaccine, Schedule schedule){
        return new AdministrationProcessDto(snsUserNumber,age,vaccine,schedule);
    }

    /**
     * Method to get VaccinationCenterByName
     * @param vaccinationCenterName String with the name
     * @return vaccination center object
     */
    public VaccinationCenter getVaccinationCenterByName(String vaccinationCenterName){
        return vaccinationCenterStore.getVaccinationCenterByName(vaccinationCenterName);
    }

    /**
     * Method to create a new vaccine administration
     * @param vaccineAdministrationDto dto object with the vaccine administration
     */
    public void createVaccineAdministration(VaccineAdministrationDto vaccineAdministrationDto){
        vaccineAdministration = store.createNewVaccineAdministration(vaccineAdministrationDto);
    }

    /**
     * method to save a new vaccine administration
     * @param vaccineAdministration vaccine administration object
     */
    public void saveVaccineAdministration(VaccineAdministrationDto vaccineAdministration){
        store.saveVaccineAdministration(vaccineAdministration);
    }

    /**
     * method to add vaccine administration
     * @param vaccineAdministrationDto vaccine administration
     */
    public void addVaccineAdministration(VaccineAdministrationDto vaccineAdministrationDto){

        VaccineAdministration vaccineAdministration = VaccineAdministrationMapper.toVaccineAdministration(vaccineAdministrationDto);
        store.addVaccineAdministration(vaccineAdministration);
    }
}
