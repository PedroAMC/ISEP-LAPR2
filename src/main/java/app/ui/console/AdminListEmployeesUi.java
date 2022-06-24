package app.ui.console;
import app.controller.employees.ListEmployeeController;
//import app.controller.RegisterSnsUserController;
import app.domain.model.dto.employees.EmployeeDto;
import java.util.List;
import java.util.Scanner;

/**
 * Class of the user interface for us11
 *
 * @author Pedro Campos <1211511@isep.ipp.pt> */

public class AdminListEmployeesUi implements Runnable{



    private final ListEmployeeController listEmployeeController;

    /**
     *  Constructor for the admin ui class
     */

    public AdminListEmployeesUi(){
        this.listEmployeeController = new ListEmployeeController();
    }


    /**
     * Method to run the user interface for the list employees function
     */

    @Override
    public void run() {
        Scanner reader = new Scanner(System.in);
        System.out.println("---------- Select the employee role to be list ----------");
        System.out.println("Option (1) - Nurse");
        System.out.println("Option (2) - Coordinator");
        System.out.println("Option (3) - Receptionist");
        String option = reader.next();
        while (!option.equals("1") && !option.equals("2") && !option.equals("3")){
            System.out.println("invalid option, please select option 1, 2 or 3");
            option = reader.next();
        }

        String employeeRole = "";

        if (option.equals("1")){
            employeeRole = "NURSE";
        } else if (option.equals("2")){
            employeeRole = "COORDINATOR";
        } else if (option.equals("3")){
            employeeRole = "RECEPTIONIST";
        }



        List<EmployeeDto> employeeDtoList = listEmployeeController.getEmployeeList(employeeRole);

        if (employeeDtoList.size() == 0){
            System.out.println("There are no employees with the selected role.");
        } else {
            for (int i = 0; i < employeeDtoList.size(); i++) {
                String employeeName = employeeDtoList.get(i).getName();
                String employeeEmail = employeeDtoList.get(i).getEmail();
                int employeeIndex = i + 1;

                System.out.println(employeeRole + " " + employeeIndex + "- name: " + employeeName + ", email: " + employeeEmail);
        }

        }


    }

}
