package app.domain.store.employees;

import app.domain.model.data.employees.Employee;
import app.domain.model.dto.employees.EmployeeDto;
import app.domain.store.employees.EmployeeStore;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeStoreTest {

    @Test
    public void testCreateEmployee(){

        EmployeeStore store = new EmployeeStore();
        EmployeeDto dto = new EmployeeDto("nuno@gmail.com", "Nuno","COORDINATOR", 911111111,1555555555,"Praceta ISEP");
        Employee employee = new Employee("nuno@gmail.com", "Nuno","COORDINATOR", 911111111,1555555555,"Praceta ISEP");

        assertEquals(employee,store.createEmployee(dto));
    }

    @Test
    public void testRegisterEmployee(){

        EmployeeStore store = new EmployeeStore();
        Employee employee = new Employee("nuno@gmail.com", "Nuno","COORDINATOR", 911111111,1555555555,"Praceta ISEP");

        assertFalse(store.registerEmployee(employee));
    }

    @Test
    public void testCreateEmployeeThrow(){
        EmployeeStore store = new EmployeeStore();
        EmployeeDto dto = new EmployeeDto("nuno@gmail.com", "Nuno","COORDINATOR", 911111111,1555555555,"Praceta ISEP");
        Employee employee = new Employee("nuno@gmail.com", "Nuno","COORDINATOR", 911111111,1555555555,"Praceta ISEP");

        assertTrue(store.registerEmployee(employee));

        assertThrows(IllegalArgumentException.class,() -> store.createEmployee(dto));
    }

    @Test
    public void testGetEmployee(){
        EmployeeStore store = new EmployeeStore();
        Employee employee = new Employee("nuno@gmail.com", "Nuno","COORDINATOR", 911111111,1555555555,"Praceta ISEP");
        store.registerEmployee(employee);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        assertEquals(store.getEmployees(), employees);
    }
}
