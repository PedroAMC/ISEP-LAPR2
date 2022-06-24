package app.controller.employees;

import app.controller.employees.ListEmployeeController;
import app.controller.employees.RegisterEmployeeController;
import app.domain.model.dto.employees.EmployeeDto;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ListEmployeeControllerTest {


    @Test
    public void testGetEmployeeList(){

        ListEmployeeController listEmployeeController = new ListEmployeeController();
        RegisterEmployeeController registerEmployeeController = new RegisterEmployeeController();

        EmployeeDto coordinator = new EmployeeDto("pedro@isep.pt", "Pedro", "COORDINATOR", 911111111, 15555555, "Praceta Isep, n.º45");
        EmployeeDto coordinator2 = new EmployeeDto("antonio@isep.pt", "Antonio", "COORDINATOR", 922222222, 111111111, "Praceta Isep, n.º46");
        EmployeeDto nurse = new EmployeeDto("miguel@isep.pt", "Miguel", "NURSE", 933333333, 22222222, "Praceta Isep, n.º47");

        registerEmployeeController.createEmployee(coordinator);
        registerEmployeeController.registerEmployee();
        registerEmployeeController.createEmployee(coordinator2);
        registerEmployeeController.registerEmployee();
        registerEmployeeController.createEmployee(nurse);
        registerEmployeeController.registerEmployee();




        List<EmployeeDto> coordinatorList = listEmployeeController.getEmployeeList("COORDINATOR");
        List<EmployeeDto> expectedList = new ArrayList<EmployeeDto>();
        expectedList.add(coordinator);
        expectedList.add(coordinator2);

        assertEquals(coordinatorList, expectedList);

    }



}
