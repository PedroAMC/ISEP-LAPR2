package app.domain.model.data.centers;

import app.domain.model.data.employees.Coordinator;
import app.domain.model.data.vaccine.VaccineType;
import app.domain.utils.Hour;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CommunityMassVaccinationCenterTest {

    @Test

    public void testMassCenter(){

        List<VaccineType> avaiableTypes = new ArrayList<>(){{
            add(new VaccineType("AF23P","Covid-19 vaccine",3));
            add(new VaccineType("AF24P","MonkeyPox vaccine",3));

        }};

        //test when avaiable types is empty
        assertThrows(IllegalArgumentException.class,() -> {
            Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");

            CommunityMassVaccinationCenter center = new CommunityMassVaccinationCenter("HealthCare Boavista","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5,new ArrayList<>());
        });

        //test when avaiable types more than 1 vaccine type
        assertThrows(IllegalArgumentException.class,() -> {
            Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");

            CommunityMassVaccinationCenter center = new CommunityMassVaccinationCenter("HealthCare Boavista","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes);
        });

    }

    @Test

    public void testGetAndSet(){

        List<VaccineType> avaiableTypes = new ArrayList<>(){{
            add(new VaccineType("AF23P","Covid-19 vaccine",3));

        }};

        List<VaccineType> avaiableTypes2 = new ArrayList<>(){{
            add(new VaccineType("AF23P","Covid-19 vaccine",3));
            add( new VaccineType("AF24P","MonkeyPox vaccine",3));
        }};

        Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");
        CommunityMassVaccinationCenter center = new CommunityMassVaccinationCenter("HealthCare Boavista","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes);

        VaccineType type = new VaccineType("AF24P","MonkeyPox vaccine",3);



        assertThrows(IllegalArgumentException.class,() -> {
           center.addVaccineType(type);
        });
        center.removeVaccineType(new VaccineType("AF23P","Covid-19 vaccine",3));
        assertEquals(avaiableTypes,center.getAvaiableTypes());
        center.addVaccineType(type);



    }

    @Test

    public void testEquals(){

        List<VaccineType> avaiableTypes = new ArrayList<>(){{
            add(new VaccineType("AF23P","Covid-19 vaccine",3));

        }};

        Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");
        CommunityMassVaccinationCenter center = new CommunityMassVaccinationCenter("HealthCare Boavista","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes);
        CommunityMassVaccinationCenter center1 = center;
        CommunityMassVaccinationCenter center2 = new CommunityMassVaccinationCenter("HealthCare Boavista","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes);


        assertEquals(center,center1);
        assertNotEquals(center,null);
        assertNotEquals(center,"center");
        assertEquals(center,center2);

    }

    @Test

    public void testHash(){


        List<VaccineType> avaiableTypes = new ArrayList<>(){{
            add(new VaccineType("AF23P","Covid-19 vaccine",3));

        }};

        Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");
        CommunityMassVaccinationCenter center = new CommunityMassVaccinationCenter("HealthCare Boavista","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes);

        assertEquals(Objects.hash(Objects.hash(center.getName(),center.getPhoneNumber(),center.getEmail()),center.getAvaiableTypes()),center.hashCode());


    }

    @Test

    public void testToString(){

        List<VaccineType> avaiableTypes = new ArrayList<>(){{
            add(new VaccineType("AF23P","Covid-19 vaccine",3));

        }};

        Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");
        CommunityMassVaccinationCenter center = new CommunityMassVaccinationCenter("HealthCare Boavista","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes);

        assertEquals("CommunityMassVaccinationCenter: HealthCare Boavista\n" +
                "Address: Margem Sul 23\n" +
                "Phone Number: 123456789\n" +
                "E-mail: vamargemsul@gmail.com\n" +
                "Fax: 900-300-5555\n" +
                "Website: vamargemsul.com.pt\n" +
                "Center Coordinator: Coordinator\n" +
                "Id: 1\n" +
                "Name: Anthony Liberty\n" +
                "Address: Sesame Street\n" +
                "Phone Number: 960000400\n" +
                "Email: coordinator@gmail.com\n" +
                "Citizen Number: 14665868\n" +
                "Manages: C.V.Margem Sul\n" +
                "\n" +
                "CenterHours:\n" +
                "Opening Hour: 09:00:00 AM\n" +
                "Closing Hour: 06:00:00 PM\n" +
                "Slot :\n" +
                "Duration: 30\n" +
                "Capacity: 5\n" +
                "Avaiable vaccine types: [VaccineType: \n" +
                "Code: AF23P\n" +
                "Description: Covid-19 vaccine\n" +
                "Technology: Subunit vaccine\n" +
                "]\n" ,center.toString());
    }

}