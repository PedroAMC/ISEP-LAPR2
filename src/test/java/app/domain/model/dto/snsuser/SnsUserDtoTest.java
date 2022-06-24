package app.domain.model.dto.snsuser;

import app.domain.model.data.snsuser.SnsUser;
import app.domain.model.dto.snsuser.SnsUserDto;
import org.junit.jupiter.api.Test;
import pt.isep.lei.esoft.auth.domain.model.Email;

import static org.junit.jupiter.api.Assertions.*;

class SnsUserDtoTest {


    @Test
    public void testDtoGet(){
        SnsUserDto dto = new SnsUserDto("Diogo","Rua de cima","Male","960168874","diogocostat@gmail.com","19/12/2002","167898423","16658688",1);

        assertEquals("Diogo",dto.getName());
        assertEquals("Rua de cima",dto.getAddress());
        assertEquals("Male",dto.getSex());
        assertEquals("960168874",dto.getPhoneNumber());
        assertEquals("diogocostat@gmail.com",dto.getEmail());
        assertEquals("19/12/2002",dto.getBirthDate());
        assertEquals("167898423",dto.getSnsNumber());
        assertEquals("16658688",dto.getCitizenCardNumber());
        assertEquals(1,dto.getSmsPermission());



    }
}