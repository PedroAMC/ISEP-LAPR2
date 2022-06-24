package app.controller.center;
import app.controller.App;
import app.domain.model.dto.snsuser.SnsUserDto;
import app.domain.model.dto.utils.HourDto;
import app.domain.store.center.VaccinationCenterStore;
import app.domain.utils.Pair;

import java.util.List;

/**
 * Controller class of us05
 *
 * @author Miguel Ferreira <1211488@isep.ipp.pt>
 */

public class WaitingRoomController {


    /**
     * Method to display the list of users in the waiting room
     *
     * @param vaccinationCenterName String contains the name of the vaccination center in which the nurse works
     */

    private final VaccinationCenterStore vaccinationCenterStore = App.getInstance().getCompany().getVaccinationCenterStore();
    public List<Pair<SnsUserDto, HourDto>> displayWaitingRoom(String vaccinationCenterName) {
        return vaccinationCenterStore.findVaccinationCenter(vaccinationCenterName).getUsersArrived();
    }
}


