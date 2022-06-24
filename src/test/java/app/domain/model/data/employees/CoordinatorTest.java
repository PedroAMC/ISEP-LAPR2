package app.domain.model.data.employees;

import app.domain.model.data.centers.VaccinationCenter;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatorTest {


    @Test
    public void testCreation (){

       Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "USS Athena");

       assertEquals("USS Athena",coordinator.getVaccinationCenter());
       coordinator.setVaccinationCenter("Maia Center");
       assertEquals("Maia Center",coordinator.getVaccinationCenter());


    }


    @Test

    public void testEquals (){

        Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street");
        Coordinator coordinator1 = coordinator;

        assertEquals(coordinator1,coordinator);
    }

    @Test
    public void testHash(){

        Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street","USS Athena");

        assertEquals(Objects.hash(Objects.hash(coordinator.getRole(),coordinator.getName(),coordinator.getPhoneNumber(),coordinator.getEmail(),coordinator.getCitizenCardNumber(),coordinator.getAddress()),coordinator.getVaccinationCenter()),coordinator.hashCode());

    }

    @Test

    public void testString (){

        Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street","USS Athena");

        assertEquals(coordinator.toString(),"Coordinator\n" +
                "Id: 3\n" +
                "Name: Anthony Liberty\n" +
                "Address: Sesame Street\n" +
                "Phone Number: 960000400\n" +
                "Emailcoordinator@gmail.com\n" +
                "Citizen Number: 14665868\n" +
                "Manages: USS Athena" + "\n");

    }


}