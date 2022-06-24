package app.controller.center;


import app.controller.App;
import app.domain.model.dto.centers.VaccinationCenterDto;
import app.domain.store.center.VaccinationCenterStore;

public class RegisterVaccinationCenterController {

    private final VaccinationCenterStore vaccinationCenterStore;

    public RegisterVaccinationCenterController() {
        this.vaccinationCenterStore = App.getInstance().getCompany().getVaccinationCenterStore();
    }

    public void createVaccinationCenter(VaccinationCenterDto dto){
        vaccinationCenterStore.createCenter(dto);
    }


}
