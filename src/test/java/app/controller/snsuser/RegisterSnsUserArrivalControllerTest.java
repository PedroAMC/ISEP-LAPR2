package app.controller.snsuser;

import app.controller.schedule.ScheduleVaccineRecepcionistController;
import app.domain.model.data.centers.HealthCareCenter;
import app.domain.model.data.centers.VaccinationCenter;
import app.domain.model.data.employees.Coordinator;
import app.domain.model.data.snsuser.SnsUser;
import app.domain.model.data.vaccine.VaccineType;
import app.domain.model.dto.centers.VaccinationCenterDto;
import app.domain.model.dto.schedule.ScheduleDto;
import app.domain.model.dto.snsuser.SnsUserDto;
import app.domain.model.dto.utils.DateDto;
import app.domain.model.dto.utils.HourDto;
import app.domain.model.dto.vaccine.VaccineTypeDto;
import app.domain.model.mapper.Utils.HourMapper;
import app.domain.model.mapper.center.VaccinationCenterMapper;
import app.domain.store.schedule.ScheduleStore;
import app.domain.store.snsuser.SnsUserStore;
import app.domain.utils.Hour;
import app.domain.utils.Pair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterSnsUserArrivalControllerTest {

    @Test
    @DisplayName("Should return false when the user sns number is not registered in the system")
    public void verifySnsNumberTestFalse() {

        RegisterSnsUserArrivalController controller = new RegisterSnsUserArrivalController();

        assertFalse(controller.verifySnsNumber("12132131"));

    }

    @Test
    @DisplayName("Should return true when the user sns number is registered in the system")
    public void verifySnsNumberTestTrue() {

        RegisterSnsUserArrivalController controller = new RegisterSnsUserArrivalController();
        RegisterSnsUserController snsUserController = new RegisterSnsUserController();

        SnsUserDto dto = new SnsUserDto("Diogo","Rua de cima","Male","960168874","diogocostat@gmail.com","19/12/2002","167898423","16658688",1);

        //snsUserController.createSnsUser(dto);
        //snsUserController.registerSnsUser();

        assertTrue(controller.verifySnsNumber("167898423"));

    }

    @Test
    @DisplayName("Should return false when the user doesn't have a vaccine scheduled in the system")
    public void verifyVaccineReservationTestFalse(){

        RegisterSnsUserArrivalController controller = new RegisterSnsUserArrivalController();
        RegisterSnsUserController snsUserController = new RegisterSnsUserController();

        Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");
        VaccinationCenter vaccinationCenter = new VaccinationCenter("HealthCare Lisboa","Margem Sul 23","123456789","lisboa@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5);

        //SnsUserDto dto = new SnsUserDto("Diogo","Rua de cima","Male","960168874","diogocostat@gmail.com","19/12/2002","167898423","16658688",1);

        //snsUserController.createSnsUser(dto);
        //snsUserController.registerSnsUser();

        assertFalse(controller.verifyVaccineReservation("167898423", vaccinationCenter));


    }

    @Test
    @DisplayName("Should return true when the user has a vaccine scheduled in the system")
    public void verifyVaccineReservationTestTrue(){


        List<VaccineType> avaiableTypes2 = new ArrayList<>(){{
            add(new VaccineType("AF23P","Covid-19 vaccine",3));
            add(new VaccineType("AF24T","MonkeyPox vaccine",2));

        }};

        RegisterSnsUserArrivalController controller = new RegisterSnsUserArrivalController();
        RegisterSnsUserController snsUserController = new RegisterSnsUserController();
        ScheduleVaccineRecepcionistController scheduleVaccineRecepcionistController = new ScheduleVaccineRecepcionistController();
        ScheduleStore scheduleStore = new ScheduleStore();
        Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");
        VaccinationCenter vaccinationCenter = new HealthCareCenter("HealthCare Lisboa","Margem Sul 23","123456789","lisboa@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes2,1);
        //SnsUserDto dto = new SnsUserDto("Diogo","Rua de cima","Male","960168874","diogocostat@gmail.com","19/12/2002","167898423","16658688",1);
        //snsUserController.createSnsUser(dto);
        //snsUserController.registerSnsUser();
        //SnsUser snsUser = SnsUserMapper.toSnsUser(dto);
        //VaccineTypeDto vaccineTypeDto = scheduleVaccineController.getOngoingBreakoutType(ongoing)
        VaccineTypeDto vaccineTypeDto = new VaccineTypeDto("12345", "Covid-19", 2);

        VaccinationCenterDto vaccinationCenterDto = VaccinationCenterMapper.centerToDto(vaccinationCenter);

        ScheduleDto scheduleDto = new ScheduleDto(new DateDto(01,06,2022),new HourDto(12,30,0),vaccinationCenterDto);
        scheduleVaccineRecepcionistController.createSchedule(scheduleDto);
        scheduleVaccineRecepcionistController.saveSchedule(vaccineTypeDto, "167898423");




        assertTrue(controller.verifyVaccineReservation("167898423", vaccinationCenter));


    }

    @Test
    @DisplayName("Should return true if it correctly registers the user.")
    public void registerUserArrivalTest(){

        List<VaccineType> avaiableTypes2 = new ArrayList<>(){{
            add(new VaccineType("AF23P","Covid-19 vaccine",3));
            add(new VaccineType("AF24T","MonkeyPox vaccine",2));

        }};

        RegisterSnsUserArrivalController controller = new RegisterSnsUserArrivalController();
        RegisterSnsUserController snsUserController = new RegisterSnsUserController();
        SnsUserStore snsUserStore = new SnsUserStore();

        Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");
        VaccinationCenter vaccinationCenter = new HealthCareCenter("HealthCare Lisboa","Margem Sul 23","123456789","lisboa@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes2,1);
        SnsUserDto dto = new SnsUserDto("Diogo","Rua de cima","Male","960168874","diogocostat@gmail.com","19/12/2002","167898423","16658688",1);
        snsUserController.createSnsUser(dto);
        snsUserController.registerSnsUser();

        controller.registerUserArrival("167898423", vaccinationCenter);

        List<Pair<SnsUserDto, HourDto>> usersArrived  = vaccinationCenter.getUsersArrived();
        List<Pair<SnsUserDto, HourDto>> usersArrivedExpected = new ArrayList<Pair<SnsUserDto, HourDto>>();

        Hour arrivalTime = Hour.tempoAtual();
        HourDto arrivalTimeDto = HourMapper.toHourDto(arrivalTime);

        SnsUser snsUser = snsUserStore.getSnsUser("167898423");
        //SnsUserDto snsUserDto = SnsUserMapper.toSnsUserDto(snsUser);


        usersArrivedExpected.add(new Pair<SnsUserDto, HourDto>(dto, arrivalTimeDto));

        assertEquals(usersArrived.get(0).getFirst().getEmail(), usersArrivedExpected.get(0).getFirst().getEmail());

    }

    @Test
    @DisplayName("Should return true if it gets the same vaccination center")
    public void getVaccinaationCenterTest(){

        List<VaccineType> avaiableTypes2 = new ArrayList<>(){{
            add(new VaccineType("AF23P","Covid-19 vaccine",3));
            add(new VaccineType("AF24T","MonkeyPox vaccine",2));

        }};

        RegisterSnsUserArrivalController controller = new RegisterSnsUserArrivalController();


        Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");
        VaccinationCenter vaccinationCenter = new HealthCareCenter("HealthCare Lisboa","Margem Sul 23","123456789","lisboa@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes2,1);
        SnsUserDto dto = new SnsUserDto("Diogo","Rua de cima","Male","960168874","diogocostat@gmail.com","19/12/2002","167898423","16658688",1);

        VaccinationCenter vaccinationCenterExpected = controller.getVaccinationCenter("HealthCare Lisboa");

        assertEquals(vaccinationCenterExpected.getEmail(), vaccinationCenter.getEmail());
        assertEquals(vaccinationCenterExpected.getPhoneNumber(), vaccinationCenter.getPhoneNumber());
        assertEquals(vaccinationCenterExpected.getUsersArrived(), vaccinationCenter.getUsersArrived());
        assertEquals(vaccinationCenterExpected.getWebsiteAddress(), vaccinationCenter.getWebsiteAddress());
        assertEquals(vaccinationCenterExpected.getName(), vaccinationCenter.getName());
        assertEquals(vaccinationCenterExpected.getAddress(), vaccinationCenter.getAddress());


    }


}