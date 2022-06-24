package app.controller.snsuser;


import app.domain.model.dto.snsuser.SnsUserDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterSnsUserControllerTest {

    @Test

    public void testRegisterSnsUser(){

        RegisterSnsUserController controller = new RegisterSnsUserController();

        SnsUserDto dto = new SnsUserDto("Diogo","Rua de cima","Male","960168874","diogocostat@gmail.com","19/12/2002","167898423","16658688",1);

        controller.createSnsUser(dto);

        assertTrue(controller.registerSnsUser());
        assertFalse(controller.registerSnsUser());
    }


}