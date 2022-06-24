package app.controller.snsuser;
import app.domain.store.snsuser.FileSnsUserStore;
import java.io.File;

/**
 * Controller class of us014
 *
 * @author Lucas Gonçalves <1211601@isep.ipp.pt>
 */
public class ImportFileSnsUsersController {

    private final FileSnsUserStore fileSnsUserStore;

    /**
     * Constructor of the class
     */
    public ImportFileSnsUsersController(){
        this.fileSnsUserStore = new FileSnsUserStore();
    }

    /**
     * Method to separate the parameters in the file
     * @param fileUsers File that contains the information of multiple users to be added
     */
    public String[][] SeparateUsers(File fileUsers){ return this.fileSnsUserStore.separateUsers(fileUsers); }


}
