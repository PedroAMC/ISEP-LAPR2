package app.domain.store.employees;
import app.controller.App;
import app.domain.model.data.employees.Employee;
import app.domain.model.dto.employees.EmployeeDto;
import app.domain.model.mapper.employees.EmployeeMapper;
import app.domain.store.center.VaccinationCenterStore;
import app.domain.utils.PasswordGenerator;
import app.domain.utils.PasswordSaver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to store and create all the Employees of the system
 *
 * @author Pedro Campos <1211511@isep.ipp.pt>
 * @author Nuno Cunha <1211689@isep.ipp.pt>
 */

public class EmployeeStore {

    private final List<Employee> employees;

    public EmployeeStore() {
        this.employees = new ArrayList<Employee>();
    }

    /**
     * Method to create a new Employee
     *
     * @param dto Object that contains all the information of a employee
     *
     * @return the new employee
     */

    public Employee createEmployee(EmployeeDto dto){
        Employee employee = new Employee(dto.getEmail(), dto.getName(), dto.getRole(), dto.getPhoneNumber(), dto.getCitizenCardNumber(), dto.getAddress());

        validateEmployee(employee);

        return employee;
    }

    /**
     * Method to validate that employee don't exist in the system
     * @param employee employee that we want to validate
     */
    private void validateEmployee(Employee employee){
        if (employees.contains(employee)){
            throw new IllegalArgumentException("There is already this Employee int the system");
        }
    }

    /**
     * Method to register the Employee in the system
     *
     * @param employee employee that we want to register
     *
     * @return sucess/failure
     */
    public boolean registerEmployee(Employee employee) {

        String password = PasswordGenerator.pwdGenerator(7,3,2);
        boolean existsEmployee = App.getInstance().getCompany().getAuthFacade().existsUser(employee.getEmail());

        if (!existsEmployee){
            addEmployee(employee);
            try {
                PasswordSaver.saveEmployeesPassword(employee.getEmail(),password);
            }catch (IOException e){
                e.printStackTrace();
            }
        }else {
            return false;
        }

        return App.getInstance().getCompany().getAuthFacade().addUserWithRole(employee.getName(), employee.getEmail(), password, employee.getRole());
    }

    /**
     * method to add to our map of employees a certain Employee
     *
     * @param employee employee that we want to add
     */
    private void addEmployee(Employee employee){
        this.employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<EmployeeDto> getEmployeesDto(){
        return EmployeeMapper.toEmployeeDtoList(employees);
    }

    /**
     * Method to export the EmployeeStore to a file
     * @param employeeStore
     * @param file
     * @return
     */
    public static boolean saveEmployeeList(EmployeeStore employeeStore, String file) {

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            try {
                out.writeObject(employeeStore);
            } finally {
                out.close();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Method to import the EmployeeStore from a file
     * @param file
     * @return vaccineAdministrationStore
     */
    public static EmployeeStore importEmployeeList(String file){
        EmployeeStore employeeStore;

        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            try{
                employeeStore = (EmployeeStore) in.readObject();
            }finally {
                in.close();
            }
            return employeeStore;
        }catch (IOException | ClassNotFoundException e){
            return new EmployeeStore();
        }
    }
}
