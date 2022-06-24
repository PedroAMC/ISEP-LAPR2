package app.controller.employees;

import app.controller.employees.RegisterEmployeeController;
import app.domain.model.dto.employees.EmployeeDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterEmployeeControllerTest {

    @Test
    public void testRegisterEmployee(){
        RegisterEmployeeController controller = new RegisterEmployeeController();

        EmployeeDto dto = new EmployeeDto("nuno@isep.pt", "Nuno", "COORDINATOR", 911111111, 15555555, "Praceta Isep, n.º45");

        controller.createEmployee(dto);

        assertTrue(controller.registerEmployee());
        assertFalse(controller.registerEmployee());

    }
}
