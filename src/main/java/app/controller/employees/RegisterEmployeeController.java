package app.controller.employees;

import app.controller.App;
import app.domain.model.data.employees.Employee;
import app.domain.model.dto.employees.EmployeeDto;
import app.domain.store.employees.EmployeeStore;

/**
 * Controller class of us10
 *
 * @author Nuno Cunha <1211689@isep.ipp.pt>
 */

public class RegisterEmployeeController {

    private final EmployeeStore employeeStore;
    private Employee employee;

    /**
     * Constructor of the class
     */

    public RegisterEmployeeController(){
        this.employeeStore = App.getInstance().getCompany().getEmployeeStore();
    }

    /**
     * Method to create a new Employee
     * @param dto Object that contains all the data of an Employee
     */

    public void createEmployee(EmployeeDto dto){
        this.employee = employeeStore.createEmployee(dto);
    }

    /**
     * Method to register the employee in the system and in the store
     * @return boolean of the result
     */
    public boolean registerEmployee(){
        return employeeStore.registerEmployee(this.employee);
    }
}
