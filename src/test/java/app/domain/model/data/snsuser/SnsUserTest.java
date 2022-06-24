package app.domain.model.data.snsuser;

import app.domain.model.data.snsuser.SnsUser;
import org.junit.jupiter.api.Test;
import pt.isep.lei.esoft.auth.domain.model.Email;



import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class SnsUserTest {


    @Test
    public void testUserCreation(){

        //name test when blank|null|empty
        assertThrows(IllegalArgumentException.class,() -> {
            new SnsUser("","Rua de cima","Male","960168874","diogocostat@gmail.com","19/12/2002","167898423","16658688",1);
        });

        //address test when blank|null|empty
        assertThrows(IllegalArgumentException.class, () ->{
            new SnsUser("Diogo","","Male","960168874","diogocostat@gmail.com","19/12/2002","167898423","16658688",1);
        });

        //phone number test when blank|null|empty
        assertThrows(IllegalArgumentException.class, () ->{
            new SnsUser("Diogo","Rua de cima","Male","","diogocostat@gmail.com","19/12/2002","167898423","16658688",1);
        });

        //phone number test when it doesn't follow the rules
        assertThrows(IllegalArgumentException.class, () -> {
            new SnsUser("Diogo","Rua de cima","Male","96016893","diogocostat@gmail.com","19/12/2002","167898423","16658688",1);
        });

        //email test when blank|null|empty
        assertThrows(IllegalArgumentException.class, () -> {
            new SnsUser("Diogo","Rua de cima","Male","960168933","","19/12/2002","167898423","16658688",1);
        });

        //email test when it doesn't follow the rules
        assertThrows(IllegalArgumentException.class, () -> {
            new SnsUser("Diogo","Rua de cima","Male","960168933","diogo.gmail.com","19/12/2002","167898423","16658688",1);
        });

        //birthdate test when blank|null|empty
        assertThrows(IllegalArgumentException.class, () -> {
            new SnsUser("Diogo","Rua de cima","Male","960168933","diogo@gmail.com","","167898423","16658688",1);
        });

        //birthdate test when it doesn't follow the rules
        assertThrows(IllegalArgumentException.class, () -> {
            new SnsUser("Diogo","Rua de cima","Male","960168933","diogo@gmail.com","19-12-2002","167898423","16658688",1);
        });

        //SNS number test when blank|null|empty
        assertThrows(IllegalArgumentException.class, () -> {
            new SnsUser("Diogo","Rua de cima","Male","960168933","diogo@gmail.com","19/12/2002","","16658688",1);
        });

        //SNS number test when it doesn't follow the rules
        assertThrows(IllegalArgumentException.class, () -> {
            new SnsUser("Diogo","Rua de cima","Male","960168933","diogo@gmail.com","19/12/2002","123456","16658688",1);
        });

        //citizen card number test when blank|null|empty
        assertThrows(IllegalArgumentException.class, () -> {
            new SnsUser("Diogo","Rua de cima","Male","960168933","diogo@gmail.com","19/12/2002","123456789","",1);
        });

        //citizen card number test when it doesn't follow the rules
        assertThrows(IllegalArgumentException.class, () -> {
            new SnsUser("Diogo","Rua de cima","Male","960168933","diogo@gmail.com","19/12/2002","123456789","1234567",1);
        });

        //citizen card number test when it doesn't follow the rules
        assertThrows(IllegalArgumentException.class, () -> {
            new SnsUser("Diogo","Rua de cima","Male","960168933","diogo@gmail.com","19/12/2002","123456789","12345678",2);
        });
    }


    @Test
    public void testGetAndSet (){

        SnsUser user = new SnsUser("Diogo","Rua de cima","","960168933","diogo@gmail.com","19/12/2002","123456789","12345678",1);
        SnsUser user2 = new SnsUser("Diogo","Rua de cima","","960168933","diogo@gmail.com","19/12/2002","123456789","12345678",1);


        //test for each get and set
        assertEquals("Diogo",user.getName());
        user.setAddress("Rua de baixo");
        assertEquals("Rua de baixo",user.getAddress());
        assertEquals("n/a",user2.getSex());
        user.setSex("Male");
        assertEquals("Male",user.getSex());
        assertEquals("960168933",user.getPhoneNumber());
        assertEquals(new Email("diogo@gmail.com"),user.getEmail());
        assertEquals("19/12/2002",user.getBirthDate());
        assertEquals("123456789",user.getSnsNumber());
        assertEquals("12345678",user.getCitizenCardNumber());
        user.setSmsPermission(0);
        assertEquals(0,user.getSmsPermission());

        //test for the trowable sets
        assertThrows(IllegalArgumentException.class, () -> {
           user.setAddress("");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            user.setSmsPermission(2);
        });

    }

    @Test

    public void testEquals(){

        SnsUser user = new SnsUser("Diogo","Rua de cima","","960168933","diogo@gmail.com","19/12/2002","123456789","12345678",1);
        SnsUser user2 = user;
        SnsUser user3 = new SnsUser("Diogo","Rua de cima","","960168933","diogo@gmail.com","19/12/2002","123456789","12345678",1);

        assertEquals(user,user2);
        assertNotEquals(user,null);
        assertNotEquals(user,"user");
        assertEquals(user,user3);

    }

    @Test
    public void testHashCode (){

        SnsUser user = new SnsUser("Diogo","Rua de cima","","960168933","diogo@gmail.com","19/12/2002","123456789","12345678",1);

        assertEquals(Objects.hash(user.getName(),user.getAddress(),user.getSex(),user.getPhoneNumber(),user.getEmail(),user.getBirthDate(),user.getSnsNumber(),user.getCitizenCardNumber(),user.getSmsPermission()),user.hashCode());
    }


    @Test

    public void testToString (){
        SnsUser user = new SnsUser("Diogo","Rua de cima","","960168933","diogo@gmail.com","19/12/2002","123456789","12345678",1);
        assertEquals("SnsUser : \n" +
                "Name: Diogo\n" +
                "Address: Rua de cima\n" +
                "Sex: n/a\n" +
                "Phone Number: 960168933\n" +
                "E-mail: diogo@gmail.com\n" +
                "Birth Date: 19/12/2002\n" +
                "Sns user number: 123456789\n" +
                "Citizen card number: 12345678\n" +
                "SMS permission (1- yes/ 0- no): 1" + "\n",user.toString());

    }

}