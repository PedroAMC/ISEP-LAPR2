package app.domain.model.mapper.snsuser;

import app.domain.model.data.snsuser.SnsUser;
import app.domain.model.dto.snsuser.SnsUserDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnsUserMapperTest {

    @Test

    public void testToUser(){

        SnsUser user = new SnsUser("Diogo","Rua de cima","Male","960168874","diogocostat@gmail.com","19/12/2002","167898423","16658688",1);

        SnsUserDto dto = new SnsUserDto("Diogo","Rua de cima","Male","960168874","diogocostat@gmail.com","19/12/2002","167898423","16658688",1);
        SnsUser userByDto = SnsUserMapper.toSnsUser(dto);

        assertEquals(userByDto,user);
    }

}