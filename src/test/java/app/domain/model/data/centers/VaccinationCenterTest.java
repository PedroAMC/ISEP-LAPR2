package app.domain.model.data.centers;

import app.controller.snsuser.RegisterSnsUserArrivalController;
import app.domain.model.data.employees.Coordinator;
import app.domain.model.data.snsuser.SnsUser;
import app.domain.model.data.vaccine.VaccineType;
import app.domain.model.dto.snsuser.SnsUserDto;
import app.domain.model.dto.utils.HourDto;
import app.domain.model.mapper.Utils.HourMapper;
import app.domain.model.mapper.snsuser.SnsUserMapper;
import app.domain.utils.Hour;
import app.domain.utils.Pair;
import org.junit.jupiter.api.Test;
import pt.isep.lei.esoft.auth.domain.model.Email;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class VaccinationCenterTest {


    @Test

    public void testFill(){
        Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");
        VaccinationCenter center = new VaccinationCenter("C.V.Margem Sul","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5);

        center.fillYearSchedule(2022);

        //test to see if the schedule has all the months and if a certain day of a month as the expected slots
        assertEquals(center.getYearSchedule().get(2022).get(1).size(),31);
        assertEquals(center.getYearSchedule().get(2022).get(2).size(),28);
        assertEquals(center.getYearSchedule().get(2022).get(3).size(),31);
        assertEquals(center.getYearSchedule().get(2022).get(4).size(),30);
        assertEquals(center.getYearSchedule().get(2022).get(5).size(),31);
        assertEquals(center.getYearSchedule().get(2022).get(6).size(),30);
        assertEquals(center.getYearSchedule().get(2022).get(7).size(),31);
        assertEquals(center.getYearSchedule().get(2022).get(8).size(),31);
        assertEquals(center.getYearSchedule().get(2022).get(9).size(),30);
        assertEquals(center.getYearSchedule().get(2022).get(10).size(),31);
        assertEquals(center.getYearSchedule().get(2022).get(11).size(),30);
        assertEquals(center.getYearSchedule().get(2022).get(12).size(),31);
        assertEquals(center.getYearSchedule().get(2022).get(1).get(27).getAvaiability().size(),19);


    }

    @Test
    public void testThrows (){
        Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");

        //test name when blank || null || empty
        assertThrows(IllegalArgumentException.class,() -> {
            VaccinationCenter center = new VaccinationCenter("","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5);

        });

        //test address when blank || null || empty
        assertThrows(IllegalArgumentException.class,() -> {
            VaccinationCenter center = new VaccinationCenter("Margem sul center","","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5);

        });

        //test phone number when blank || null || empty
        assertThrows(IllegalArgumentException.class,() -> {
            VaccinationCenter center = new VaccinationCenter("Margem sul center","Rua da margem sul","","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5);

        });

        //test phone number when not following the rules
        assertThrows(IllegalArgumentException.class,() -> {
            VaccinationCenter center = new VaccinationCenter("Margem sul center","Rua da margem sul","1234","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5);

        });

        //test email when blank || null || empty
        assertThrows(IllegalArgumentException.class,() -> {
            VaccinationCenter center = new VaccinationCenter("Margem sul center","Rua da margem sul","123456789","","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5);

        });

        //test email when not following the rules
        assertThrows(IllegalArgumentException.class,() -> {
            VaccinationCenter center = new VaccinationCenter("Margem sul center","Rua da margem sul","123456789","diogo.pt","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5);

        });

        //test fax when blank || null || empty
        assertThrows(IllegalArgumentException.class,() -> {
            VaccinationCenter center = new VaccinationCenter("Margem sul center","Rua da margem sul","123456789","diogo@gmail.pt","","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5);

        });

        //test fax when not following the rules
        assertThrows(IllegalArgumentException.class,() -> {
            VaccinationCenter center = new VaccinationCenter("Margem sul center","Rua da margem sul","123456789","diogo@gmail.pt","123-432-21","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5);

        });

        //test website when blank || null || empty
        assertThrows(IllegalArgumentException.class,() -> {
            VaccinationCenter center = new VaccinationCenter("Margem sul center","Rua da margem sul","123456789","diogo@gmail.pt","123-432-2132","",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5);

        });

        //test website when not following the rules
        assertThrows(IllegalArgumentException.class,() -> {
            VaccinationCenter center = new VaccinationCenter("Margem sul center","Rua da margem sul","123456789","diogo@gmail.pt","123-432-2132","testwebsite",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5);

        });

    }

    @Test

    public void testGets (){

        Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");
        Coordinator coordinator2 = new Coordinator("coordinator2@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");
        VaccinationCenter center = new VaccinationCenter("C.V.Margem Sul","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5);


        assertEquals("C.V.Margem Sul",center.getName());
        assertEquals("Margem Sul 23",center.getAddress());
        assertEquals("123456789",center.getPhoneNumber());
        assertEquals(new Email("vamargemsul@gmail.com"),center.getEmail());
        assertEquals("900-300-5555",center.getFax());
        assertEquals("vamargemsul.com.pt",center.getWebsiteAddress());
        assertEquals(new ArrayList<>(),center.getUsersArrived());
        center.setCenterCoordinator(coordinator2);
        assertEquals(coordinator2,center.getCenterCoordinator());
        assertEquals(new CenterHours(new Hour(9,0,0),new Hour(18,0,0)),center.getHours());
        assertEquals(new Slot(30,5),center.getSlot());

    }

    @Test

    public void testEquals(){

        Coordinator coordinator = new Coordinator("coordinator2@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");
        VaccinationCenter center = new VaccinationCenter("C.V.Margem Sul","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5);
        VaccinationCenter center2 = center;
        VaccinationCenter center3 = new VaccinationCenter("C.V.Margem Sul","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5);


        assertEquals(center,center2);
        assertNotEquals(center,null);
        assertNotEquals(center,"center");
        assertEquals(center,center3);

    }

    @Test

    public void testHash(){

        Coordinator coordinator = new Coordinator("coordinator2@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");
        VaccinationCenter center = new VaccinationCenter("C.V.Margem Sul","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5);

        assertEquals(Objects.hash(center.getName(),center.getPhoneNumber(),center.getEmail()),center.hashCode());
    }

    @Test

    public void testToString(){

        Coordinator coordinator = new Coordinator("coordinator2@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");
        VaccinationCenter center = new VaccinationCenter("C.V.Margem Sul","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5);

        assertEquals("VaccinationCenter: C.V.Margem Sul\n" +
                "Address: Margem Sul 23\n" +
                "Phone Number: 123456789\n" +
                "E-mail: vamargemsul@gmail.com\n" +
                "Fax: 900-300-5555\n" +
                "Website: vamargemsul.com.pt\n" +
                "Center Coordinator: Coordinator\n" +
                "Id: 4\n" +
                "Name: Anthony Liberty\n" +
                "Address: Sesame Street\n" +
                "Phone Number: 960000400\n" +
                "Email: coordinator2@gmail.com\n" +
                "Citizen Number: 14665868\n" +
                "Manages: C.V.Margem Sul\n" +
                "\n" +
                "CenterHours:\n" +
                "Opening Hour: 09:00:00 AM\n" +
                "Closing Hour: 06:00:00 PM\n" +
                "Slot :\n" +
                "Duration: 30\n" +
                "Capacity: 5" + "\n",center.toString());
    }

    @Test
    public void addArrivalTest(){

        List<VaccineType> avaiableTypes2 = new ArrayList<>(){{
            add(new VaccineType("AF23P","Covid-19 vaccine",3));
            add(new VaccineType("AF24T","MonkeyPox vaccine",2));

        }};

        Hour arrivalTime = Hour.tempoAtual();
        HourDto arrivalTimeDto = HourMapper.toHourDto(arrivalTime);


        Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");
        VaccinationCenter vaccinationCenter = new HealthCareCenter("HealthCare Lisboa","Margem Sul 23","123456789","lisboa@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes2,1);
        SnsUserDto dto = new SnsUserDto("Diogo","Rua de cima","Male","960168874","diogocostat@gmail.com","19/12/2002","167898423","16658688",1);
        SnsUser snsUser = SnsUserMapper.toSnsUser(dto);

        vaccinationCenter.addArrival(snsUser, arrivalTime);

        List<Pair<SnsUserDto, HourDto>> usersArrived  = vaccinationCenter.getUsersArrived();
        List<Pair<SnsUserDto, HourDto>> usersArrivedExpected = new ArrayList<Pair<SnsUserDto, HourDto>>();

        usersArrivedExpected.add(new Pair<SnsUserDto, HourDto>(dto, arrivalTimeDto));

        assertEquals(usersArrived.get(0).getFirst().getEmail(), usersArrivedExpected.get(0).getFirst().getEmail());
        assertEquals(usersArrived.get(0).getFirst().getName(), usersArrivedExpected.get(0).getFirst().getName());



    }


}