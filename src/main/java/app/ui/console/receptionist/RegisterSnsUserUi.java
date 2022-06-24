package app.ui.console.receptionist;


import app.controller.snsuser.RegisterSnsUserController;
import app.domain.model.dto.snsuser.SnsUserDto;
import app.ui.console.utils.Utils;


import java.util.Scanner;

/**
 * Class of the user interface for us03
 *
 * @author Diogo Teixeira <1200904@isep.ipp.pt> */
public class RegisterSnsUserUi implements Runnable{

    private final RegisterSnsUserController snsUserController;

    /**
     * Constructor of the ui class
     */

    public RegisterSnsUserUi(){
        this.snsUserController = new RegisterSnsUserController();
    }

    /**
     * Run method to run the ui necessary to register a new client in the system
     */

    @Override
    public void run() {
        Scanner reader = new Scanner(System.in);
        final String name;
        final String address;
        final String sex;
        final String phoneNumber;
        final String email;
        final String birthdate;
        final String snsNumber;
        final String citizenCardNumber;
        int smsPermission;


        System.out.println("---------- Register a new Client ----------");



            name = Utils.readLineFromConsole("Sns user full name: ");
            address = Utils.readLineFromConsole("Sns user address: ");
            sex = Utils.readLineFromConsole("Sns user sex (optional): ");
            phoneNumber = Utils.readLineFromConsole("Sns user phone number: ");
            System.out.println("User e-mail: ");
            email = reader.next();
            birthdate = Utils.readLineFromConsole("Sns user birthdate (dd/mm/yyyy): ");
            System.out.print("SNS User Number:");
            snsNumber = reader.next();
            citizenCardNumber = Utils.readLineFromConsole("Sns user citizen card number: ");
            smsPermission = Utils.readIntegerFromConsole("Does user want to receive sms's (1 - yes/ 0 - no)");

            SnsUserDto dto = new SnsUserDto(name,address,sex,phoneNumber,email,birthdate,snsNumber,citizenCardNumber,smsPermission);

            try {

                snsUserController.createSnsUser(dto);


                String string = String.format("Confirm the inputted data (y - yes/ n - no) \n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%d",name,address,sex,phoneNumber,email,birthdate,snsNumber,citizenCardNumber,smsPermission );
                boolean confirm = Utils.confirm(string);

                if(confirm){

                    if(snsUserController.registerSnsUser()){
                        System.out.println("Sns User registered successfully");
                    }else{
                        System.out.println("There is already a User with the same e-mail in the system");
                        System.out.println("Operation failed");
                    }
                }


            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println("Operation failed");
            }








    }
}
