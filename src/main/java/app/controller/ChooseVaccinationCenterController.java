package app.controller;

import app.domain.model.dto.centers.VaccinationCenterDto;
import app.domain.store.center.VaccinationCenterStore;

import java.util.List;

public class ChooseVaccinationCenterController {

    private VaccinationCenterStore centerStore;


    public ChooseVaccinationCenterController() {
        this.centerStore = App.getInstance().getCompany().getVaccinationCenterStore();
    }

    public List<VaccinationCenterDto> getListOfCenters(){
        return centerStore.getListOfCenters();
    }
}
