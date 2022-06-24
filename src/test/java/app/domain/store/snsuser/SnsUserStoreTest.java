package app.domain.store.snsuser;

import app.domain.model.data.snsuser.SnsUser;
import app.domain.model.dto.snsuser.SnsUserDto;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SnsUserStoreTest {


    @Test

    public void testCreateSnsUserThrow(){

        SnsUserStore store = new SnsUserStore();
        //same sns number
        SnsUserDto dto = new SnsUserDto("Diogo","Rua de cima","Male","960168874","diogocostat@gmail.com","19/12/2002","167898423","16658688",1);
        //same phone number
        SnsUserDto dto2 = new SnsUserDto("Diogo","Rua de cima","Male","960168874","diogocostat@gmail.com","19/12/2002","167898422","16658688",1);
        //same email
        SnsUserDto dto3 = new SnsUserDto("Diogo","Rua de cima","Male","960168872","diogocostat@gmail.com","19/12/2002","167898422","16658688",1);
        //same citizen card number
        SnsUserDto dto4 = new SnsUserDto("Diogo","Rua de cima","Male","960168872","diogocostat1@gmail.com","19/12/2002","167898422","16658688",1);
        //all different
        SnsUserDto dto5 = new SnsUserDto("Joao","Rua de baixo","Male","960168873","joaozinho@gmail.com","12/12/2002","167198322","16654688",0);
        //original
        SnsUser snsUser = new SnsUser("Diogo","Rua de cima","Male","960168874","diogocostat@gmail.com","19/12/2002","167898423","16658688",1);
        //all different
        SnsUser snsUser2 = new SnsUser("Joao","Rua de baixo","Male","960168873","joaozinho@gmail.com","12/12/2002","167198322","16654688",0);


        //initial regist of a sns user
        store.registerSnsUser(snsUser);

        //same sns number error
        assertThrows(IllegalArgumentException.class,() -> {
            store.createSnsUser(dto);
        });

        //same phone number error
        assertThrows(IllegalArgumentException.class,() -> {
            store.createSnsUser(dto2);
        });

        //same email error
        assertThrows(IllegalArgumentException.class,() -> {
            store.createSnsUser(dto3);
        });

        //same citizen card number
        assertThrows(IllegalArgumentException.class,() -> {
            store.createSnsUser(dto4);
        });

        //teste creation of a new user withut throw
        assertEquals(snsUser2,store.createSnsUser(dto5));



    }

    @Test

    public void testCreateSnsUser(){

        SnsUserStore store = new SnsUserStore();
        SnsUserDto dto = new SnsUserDto("Diogo","Rua de cima","Male","960168874","diogocostat1@gmail.com","19/12/2002","167898423","16658688",1);
        SnsUser snsUser = new SnsUser("Diogo","Rua de cima","Male","960168874","diogocostat1@gmail.com","19/12/2002","167898423","16658688",1);


        assertEquals(snsUser,store.createSnsUser(dto));

    }

    @Test

    public void testRegisterSnsUser(){

        SnsUserStore store = new SnsUserStore();
        SnsUser snsUser = new SnsUser("Diogo","Rua de cima","Male","960168874","diogocostat2@gmail.com","19/12/2002","167898423","16658688",1);

        assertTrue(store.registerSnsUser(snsUser));


    }


    @Test

    public void testGetSnsUsers(){

        SnsUserStore store = new SnsUserStore();
        SnsUser snsUser = new SnsUser("Diogo","Rua de cima","Male","960168874","diogocostat@gmail.com","19/12/2002","167898423","16658688",1);
        store.registerSnsUser(snsUser);

        Map<String, SnsUser> snsUsers = new HashMap<>();
        snsUsers.put(snsUser.getSnsNumber(),snsUser);

        assertEquals(store.getSnsUsers(),snsUsers);


    }

    @Test

    public void testGetPhoneNumbers(){
        SnsUserStore store = new SnsUserStore();
        SnsUser snsUser = new SnsUser("Diogo","Rua de cima","Male","960168874","diogocostat@gmail.com","19/12/2002","167898423","16658688",1);
        store.registerSnsUser(snsUser);

        List<String> expectedNumbers = new ArrayList<>(){{
           add("960168874");
        }};

        assertEquals(expectedNumbers,store.getPhoneNumbers());

    }

    @Test

    public void testGetCitizenCardNumbers (){
        SnsUserStore store = new SnsUserStore();
        SnsUser snsUser = new SnsUser("Diogo","Rua de cima","Male","960168874","diogocostat@gmail.com","19/12/2002","167898423","16658688",1);
        store.registerSnsUser(snsUser);

        List<String> expectedCitizenCardNumbers = new ArrayList<>(){{
           add("16658688");
        }};

        assertEquals(expectedCitizenCardNumbers,store.getCitizenCardNumbers());
    }


    @Test

    public void testVerifySnsNumber(){
        SnsUserStore store = new SnsUserStore();
        SnsUser snsUser1 = new SnsUser("Diogo","Rua de cima","Male","960168874","diogocostat@gmail.com","19/12/2002","167898423","16658688",1);
        store.registerSnsUser(snsUser1);
        assertTrue(store.verifySnsNumber(snsUser1.getSnsNumber()));

        SnsUser snsUser2 = new SnsUser("Diogo","Rua de cima","Male","960168874","diogocostat@gmail.com","19/12/2002","111111111","16658688",1);
        assertThrows(IllegalArgumentException.class,() -> {
            store.verifySnsNumber(snsUser2.getSnsNumber());
        });

    }
}