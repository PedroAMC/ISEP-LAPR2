package app.controller.vaccine;


import app.controller.App;
import app.domain.model.dto.vaccine.VaccineTypeDto;
import app.domain.store.vaccine.VaccineTypeStore;


/**
 * Controller class to create a new vaccine type
 *
 * @author Diogo Teixeira <1200904@isep.ipp.pt>
 */

public class RegisterVaccineTypeController {

    private final VaccineTypeStore vaccineTypeStore;

    /**
     * Controller's constructor
     */
    public RegisterVaccineTypeController() {
        this.vaccineTypeStore = App.getInstance().getCompany().getVaccineTypeStore();
    }

    /**
     * Method to create a new vaccine type and store it
     * @param dto information to the creation of a new vaccine type
     */
    public void createVaccineType(VaccineTypeDto dto){
        vaccineTypeStore.createVaccineType(dto);
    }


}
