package app.controller.snsuser;

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
import pt.isep.lei.esoft.auth.AuthFacade;

import java.util.List;

public class ScheduleVaccineController {

    private final VaccinationCenterStore centerStore;
    private final VaccineTypeStore typeStore;
    private final ScheduleStore scheduleStore;
    private final AuthFacade authFacade;
    private final SnsUserStore snsUserStore;
    private Schedule schedule;
    private SnsUser snsUser;

    public ScheduleVaccineController() {
        centerStore = App.getInstance().getCompany().getVaccinationCenterStore();
        typeStore = App.getInstance().getCompany().getVaccineTypeStore();
        scheduleStore = App.getInstance().getCompany().getScheduleStore();
        authFacade = App.getInstance().getCompany().getAuthFacade();
        snsUserStore = App.getInstance().getCompany().getSnsUserStore();
    }



    public List<VaccinationCenterDto> getListOfCenters (){
        return centerStore.getListOfCenters();
    }

    public VaccineTypeDto getOngoingBreakoutType (String typeName){
        return typeStore.getOngoingOutbreakType(typeName);
    }

    public List<VaccineTypeDto> getListOfTypes(){
        return typeStore.getVaccineTypes();
    }

    public void createSchedule(ScheduleDto scheduleDto){

        String snsUserEmail = authFacade.getCurrentUserSession().getUserId().getEmail();
        snsUser = snsUserStore.getSnsUserByEmail(snsUserEmail);
        schedule = scheduleStore.createNewSchedule(scheduleDto);


    }

    public void saveSchedule(VaccineTypeDto vaccineTypeDto){
        scheduleStore.saveSchedule(snsUser,schedule,vaccineTypeDto);
    }

}
