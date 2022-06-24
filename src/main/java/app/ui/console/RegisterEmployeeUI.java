package app.ui.console;

import app.controller.employees.RegisterEmployeeController;
import app.domain.model.dto.employees.EmployeeDto;
import app.ui.console.utils.Utils;


/**
 * class of the user interface for us10
 *
 * @author Nuno Cunha <1211689@isep.ipp.pt>
 */

public class RegisterEmployeeUI implements Runnable{

    private final RegisterEmployeeController employeeController;

    /**
     * Constructor of the ui class
     */

    public RegisterEmployeeUI() {
        this.employeeController = new RegisterEmployeeController();
    }


    /**
     * Run method to run the ui necessary to register a new employee in the system
     */
    @Override
    public void run() {
        final String role;
        final String name;
        final int phoneNumber;
        final String email;
        final int citizenCardNumber;
        final String address;

        System.out.println("---------- Register a new Employee ----------");

            role = Utils.readLineFromConsole("Employee role: ");
            name  = Utils.readLineFromConsole("Employee name: ");
            phoneNumber = Utils.readIntegerFromConsole("Employee phone number: ");
            email = Utils.readLineFromConsole("Employee email: ");
            citizenCardNumber = Utils.readIntegerFromConsole("Employee citizen card number: ");
            address = Utils.readLineFromConsole("Employee address: ");

        EmployeeDto dto = new EmployeeDto(email,name,role,phoneNumber,citizenCardNumber,address);

        try {
            employeeController.createEmployee(dto);

            String string = String.format("Confirm the inputted data (y - yes/ n - no) \n%s\n%s\n%d\n%s\n%d\n%s", role,name,phoneNumber,email,citizenCardNumber,address);
            boolean confirms = Utils.confirm(string);

            if (confirms){
                if (employeeController.registerEmployee()){
                    System.out.println("Employee registered successfully");
                }
            }else{
                System.out.println("There already an employee with that emailin the system");
                System.out.println("Operation failed");
            }

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println("Operation failed");
        }
    }
}
