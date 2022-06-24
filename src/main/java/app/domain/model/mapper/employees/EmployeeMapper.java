package app.domain.model.mapper.employees;

import app.domain.model.data.employees.Employee;
import app.domain.model.dto.employees.EmployeeDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that deals with the dto objects that carry the information
 * of Employees
 *
 * @author Pedro Campos <1211511@isep.ipp.pt>
 */

public class EmployeeMapper {


    /**
     * Method to transform an Employee into an EmployeeDto carrying the information of the employeee
     *
     * @param employee Object that carries all the information of a Employee
     *
     * @return EmployeeDto
     */
    public static EmployeeDto toEmployeeDto(Employee employee){
        return new EmployeeDto(employee.getEmail(),employee.getName(), employee.getRole(),employee.getCitizenCardNumber(), employee.getPhoneNumber(), employee.getAddress());
    }

    /**
     * Method to transform an Employee List to an EmployeeDto list
     * @param employeeList list of employees
     * @return employeeDtoList
     */
    public static List<EmployeeDto> toEmployeeDtoList(List<Employee> employeeList){
        List<EmployeeDto> employeeDtoList = new ArrayList<EmployeeDto>(employeeList.size());
        for (int i = 0; i < employeeList.size(); i++) {
            EmployeeDto employeeDto = EmployeeMapper.toEmployeeDto(employeeList.get(i));
            employeeDtoList.add(employeeDto);

        }
        return employeeDtoList;
    }

    /**
     * Method to transform a dto carrying the information of an employee into a Employee object
     *
     * @param dto Object that carries all the information of an Employee
     *
     * @return employee
     */
    public static Employee toEmployee (EmployeeDto dto){
        return new Employee(dto.getEmail(), dto.getName(), dto.getRole(), dto.getPhoneNumber(), dto.getCitizenCardNumber(), dto.getAddress());
    }
}
