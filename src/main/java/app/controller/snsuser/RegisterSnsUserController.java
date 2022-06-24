package app.controller.snsuser;

import app.controller.App;
import app.domain.model.data.snsuser.SnsUser;
import app.domain.model.dto.snsuser.SnsUserDto;
import app.domain.store.snsuser.SnsUserStore;


/**
 * Controller class of us03
 *
 * @author Diogo Teixeira <1200904@isep.ipp.pt>
 */

public class RegisterSnsUserController {

    private final SnsUserStore snsUserStore;
    private SnsUser snsUser;

    /**
     * Constructor of the class
     */

    public RegisterSnsUserController() {

        this.snsUserStore = App.getInstance().getCompany().getSnsUserStore();
    }

    /**
     * Method to create a new Sns User
     * @param dto Object that contains all the information of a SNS User
     */

    public void createSnsUser(SnsUserDto dto){

        this.snsUser = snsUserStore.createSnsUser(dto);

    }

    /**
     * Method to register the SNS User in the system and in the store
     * @return boolean of success/failure
     */
    public boolean registerSnsUser(){

        return snsUserStore.registerSnsUser(this.snsUser);
    }

}
