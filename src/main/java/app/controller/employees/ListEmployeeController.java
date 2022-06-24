package app.controller.employees;
import app.controller.App;
import app.domain.model.data.employees.Employee;
import app.domain.model.dto.employees.EmployeeDto;
import app.domain.model.mapper.employees.EmployeeMapper;
import app.domain.store.employees.EmployeeStore;

import java.util.ArrayList;
import java.util.List;

public class ListEmployeeController {

    /**
     * Controller class of us11
     *
     * @author Pedro Campos <1211511@isep.ipp.pt>
     */

    private String role;
    private final EmployeeStore employeeStore;

    /**
     * Constructor of the class
     */

    public ListEmployeeController() {

        this.employeeStore = App.getInstance().getCompany().getEmployeeStore();

    }

    /**
     * Method to retrieve the list of employees with a certain role
     * @param role String with the selected role
     * @return employeeRoleDtoList
     */

    public List<EmployeeDto> getEmployeeList (String role){

        List<Employee> employeeList = employeeStore.getEmployees();
        List<EmployeeDto> employeeDtoList = EmployeeMapper.toEmployeeDtoList(employeeList);
        List<EmployeeDto> employeeRoleDtoList = new ArrayList<EmployeeDto>();

        for (int i = 0; i < employeeDtoList.size(); i++) {
            String employeeRole = employeeDtoList.get(i).getRole();
            if (employeeRole.equals(role)){
                employeeRoleDtoList.add(employeeDtoList.get(i));
            }

        }
        return employeeRoleDtoList;
    }
}
