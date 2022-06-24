package app.domain.model.mapper;

import app.domain.model.data.employees.Employee;
import app.domain.model.dto.employees.EmployeeDto;
import app.domain.model.mapper.employees.EmployeeMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeMapperTest {

    @Test
    public void testToUser(){

        Employee employee = new Employee("nuno@gmail.com", "Nuno","COORDINATOR", 911111111,1555555555,"Praceta ISEP");
        EmployeeDto dto = new EmployeeDto("nuno@gmail.com", "Nuno","COORDINATOR", 911111111,1555555555,"Praceta ISEP");
        Employee employeeByDto = EmployeeMapper.toEmployee(dto);

        assertEquals(employeeByDto,employee);

    }
}
