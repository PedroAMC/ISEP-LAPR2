package app.controller.schedule;

import app.controller.App;
import app.domain.model.data.schedule.Schedule;
import app.domain.model.data.snsuser.SnsUser;
import app.domain.model.dto.centers.VaccinationCenterDto;
import app.domain.model.dto.schedule.ScheduleDto;
import app.domain.model.dto.vaccine.VaccineTypeDto;
import app.domain.store.center.VaccinationCenterStore;
import app.domain.store.schedule.ScheduleStore;
import app.domain.store.snsuser.SnsUserStore;
import app.domain.store.vaccine.VaccineTypeStore;

import java.util.List;

/**
 * Controller class of the Us02
 *
 * @author Nuno Cunha <1211689@isep.ipp.pt>
 */

public class ScheduleVaccineRecepcionistController {
    private final VaccinationCenterStore centerStore;
    private final VaccineTypeStore typeStore;
    private final ScheduleStore scheduleStore;
    private final SnsUserStore snsUserStore;
    private Schedule schedule;
    private SnsUser snsUser;

    /**
     *Constructor of the class
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public ScheduleVaccineRecepcionistController() {
        this.centerStore = App.getInstance().getCompany().getVaccinationCenterStore();
        this.typeStore = App.getInstance().getCompany().getVaccineTypeStore();
        this.scheduleStore = App.getInstance().getCompany().getScheduleStore();
        this.snsUserStore = App.getInstance().getCompany().getSnsUserStore();
    }

    /**
     * Method to verify locally the sns number
     * @param snsNumber sns number of the sns user
     * @return boolean with the result
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public boolean verifySnsNumber (String snsNumber){
        return snsUserStore.verifySnsNumber(snsNumber);
    }

    /**
     * Method to get the list of vaccination centers
     * @return list of center
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public List<VaccinationCenterDto> getListOfCenters(){return centerStore.getListOfCenters(); }

    /**
     * Method to get the ongoing breakout vaccine
     * @param typeName name of the type of vaccine
     * @return the name of the vaccine
     *
     * @author  Nuno Cunha <1211689@isep.ipp.pt>
     */
    public VaccineTypeDto getOngoingBreakoutType (String typeName){
        return typeStore.getOngoingOutbreakType(typeName);
    }

    /**
     * Method to get the list of the vaccine types
     * @return list of vaccine types
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public List<VaccineTypeDto> getListOfTypes(){return typeStore.getVaccineTypes();}

    /**
     * Method to create schedule of a vaccine
     * @param scheduleDto dto with schedule information
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public void createSchedule(ScheduleDto scheduleDto){
        schedule = scheduleStore.createNewSchedule(scheduleDto);
    }

    /**
     * Save the schedule vaccine
     * @param vaccineTypeDto the dto with the information of the vaccine type
     * @param snsUserNumber SNS number of the user
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public void saveSchedule (VaccineTypeDto vaccineTypeDto, String snsUserNumber){
        snsUser = snsUserStore.getSnsUser(snsUserNumber);
        scheduleStore.saveSchedule(snsUser,schedule,vaccineTypeDto);
    }
}
