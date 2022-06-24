package app.domain.model.dto;


import app.domain.model.dto.employees.EmployeeDto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeDtoTest {

    @Test
    public void testDtoGet(){
        EmployeeDto dto = new EmployeeDto("nuno@gmail.com", "Nuno","coordinator", 911111111,1555555555,"Praceta ISEP");

        assertEquals("nuno@gmail.com", dto.getEmail());
        assertEquals("Nuno", dto.getName());
        assertEquals("coordinator", dto.getRole());
        assertEquals(911111111, dto.getPhoneNumber());
        assertEquals(1555555555, dto.getCitizenCardNumber());
        assertEquals("Praceta ISEP", dto.getAddress());
    }
}
