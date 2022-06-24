package app.ui.console.SnsUser;

import app.controller.snsuser.ImportFileSnsUsersController;
import app.controller.snsuser.RegisterSnsUserController;
import app.domain.model.dto.snsuser.SnsUserDto;
import app.ui.console.utils.Utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * UI class of us014
 *
 * @author Lucas Gonçalves <1211601@isep.ipp.pt>
 */

public class ImportFileSnsUsersUI implements Runnable{

    private final ImportFileSnsUsersController controller;
    private final RegisterSnsUserController snsUserController;
    public ImportFileSnsUsersUI() {
        this.controller = new ImportFileSnsUsersController();
        this.snsUserController = new RegisterSnsUserController();
    }

    Scanner reader;
    String name;
    String address;
    String sex;
    String phoneNumber;
    String email;
    String birthdate;
    String snsNumber;
    String citizenCardNumber;
    int smsPermission = 0;


    /**
     * @param name of the sns user
     * @param address address of the sns user
     * @param sex sex of the sns user
     * @param phoneNumber phone number of the sns user
     * @param email email of the sns user
     * @param birthDate birthdate of the sns user
     * @param snsNumber sns number of the sns user
     * @param citizenCardNumber citizen card number of the sns user
     * @param smsPermission permission to receive notifications from dgs, always set to 0 since client didn't ask
     */

    /***/

    @Override
    public void run() {

        boolean valid = true;
        File fileUsers = null;
        /**
        * @param valid file path is valid or not
         * @param fileUsers File specified by file path, that contains the information of the user,
         */

        do {

            valid = true;
            try {

                String filePath = Utils.readLineFromConsole("Input path file:");
                /**
                 * @param filePathFile file path specified by user
                 */


                fileUsers = new File(filePath);

                if (fileUsers.isFile() && fileUsers.length() == 0) {

                    System.out.println("\nInvalid file. File must not be blank. Please type a valid file");
                    valid = false;
                } else {

                    reader = new Scanner(fileUsers);


                }

            } catch (FileNotFoundException e) {
                System.out.println("\nWrong file path. Please type a valid path");
                valid = false;

            }

        } while (!valid);

        String[][] listUsers = controller.SeparateUsers(fileUsers);
        /**
         * @param listUsers Array with all users and parameters separated
         */

        boolean validFile = true;
        for (int user = 0; user < listUsers.length; user++){

            name = listUsers[user][0];
            sex = listUsers[user][1];
            birthdate = listUsers[user][2];
            address = listUsers[user][3];
            phoneNumber = listUsers[user][4];
            email = listUsers[user][5];
            snsNumber = listUsers[user][6];
            citizenCardNumber = listUsers[user][7];

            SnsUserDto fileDto = new SnsUserDto(name, address, sex, phoneNumber, email, birthdate, snsNumber, citizenCardNumber, smsPermission);

            try {

                snsUserController.createSnsUser(fileDto);

            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println("Operation failed");
                validFile = false;
            }
        }
        if (validFile){
            for (int user = 0; user < listUsers.length; user++){
                name = listUsers[user][0];
                sex = listUsers[user][1];
                birthdate = listUsers[user][2];
                address = listUsers[user][3];
                phoneNumber = listUsers[user][4];
                email = listUsers[user][5];
                snsNumber = listUsers[user][6];
                citizenCardNumber = listUsers[user][7];

                SnsUserDto fileDto = new SnsUserDto(name, address, sex, phoneNumber, email, birthdate, snsNumber, citizenCardNumber, smsPermission);
                snsUserController.createSnsUser(fileDto);
                snsUserController.registerSnsUser();
            }
            System.out.println("\nUsers created with success");
        } else {
            System.out.println("Users could not be created");
        }

    }
}
