package app.domain.model.data;

import app.domain.model.data.employees.Employee;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    public void testUserCreation() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Employee("", "Nuno", "Nurse", 910000000, 122222222, "Teste");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Employee("test@gmail.com", "Nuno", "", 910000000, 122222222, "teste");
        });


        assertThrows(IllegalArgumentException.class, () -> {
            new Employee("test@gmail.com", "Nuno", "Coordinator", 910000000, 122222222, "teste");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Employee("test@gmail.com", "Nuno", "NURSE", 910000000, 12222222, "");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Employee("test@gmail.com", "", "NURSE", 910000000, 122222222, "teste");
        });
    }

    @Test
    public void testEquals(){
        Employee employee1 = new Employee("nuno@gmail.com", "Nuno","COORDINATOR", 911111111,1555555555,"Praceta ISEP");
        Employee employeeCopy = employee1;
        Employee employee2 = new Employee("nunocunha@gmail.com", "Antonio","NURSE", 911112222,1555552222,"Praceta FEUP");

        assertEquals(employee1,employeeCopy);
        assertNotEquals(employee1,"Hello World");
        assertNotEquals(employee1,null);
        assertNotEquals(employee1,employee2);
    }

    @Test
    public void testHash(){
        String email = "nuno@gmail.com";
        String name = "Nuno";
        String role = "COORDINATOR";
        int phoneNumber = 911111111;
        int citizenCardNumber = 1555555555;
        String address = "Praceta ISEP";

        Employee employee = new Employee(email,name,role,phoneNumber,citizenCardNumber,address);

        assertEquals(employee.hashCode(), Objects.hash(role,name,phoneNumber,email,citizenCardNumber,address));
    }

    @Test
    public void testToString(){

        Employee employee = new Employee("nuno@gmail.com", "Nuno","COORDINATOR", 911111111,1555555555,"Praceta ISEP");
        System.out.println(employee);
        assertEquals(employee.toString(), "Employee{employeeID=0, role='COORDINATOR', name='Nuno', phoneNumber=911111111, email='nuno@gmail.com', citizenCardNumber=1555555555}");
    }
}
