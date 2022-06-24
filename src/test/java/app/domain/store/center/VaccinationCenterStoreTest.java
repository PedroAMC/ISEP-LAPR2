package app.domain.store.center;

import app.controller.App;
import app.domain.model.data.centers.HealthCareCenter;
import app.domain.model.data.centers.VaccinationCenter;
import app.domain.model.data.employees.Coordinator;
import app.domain.model.data.vaccine.VaccineType;
import app.domain.model.dto.centers.HealthCareCenterDto;
import app.domain.model.dto.centers.VaccinationCenterDto;
import app.domain.model.mapper.center.VaccinationCenterMapper;
import app.domain.utils.Hour;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VaccinationCenterStoreTest {

    @Test

    public void testCreate() {
        VaccinationCenterStore store = new VaccinationCenterStore();


        List<VaccineType> avaiableTypes = new ArrayList<>(){{
            add(new VaccineType("AF23P","Covid-19 vaccine",3));

        }};

        Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");
        HealthCareCenterDto dto = new HealthCareCenterDto("HealthCare Boavista","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes,1);
        HealthCareCenterDto dto2 = new HealthCareCenterDto("HealthCare Central","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes,1);
        HealthCareCenterDto dto3 = new HealthCareCenterDto("HealthCare Periferica","Margem Sul 23","123456289","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes,1);


        store.createCenter(dto);

        assertThrows(IllegalArgumentException.class,() -> store.createCenter(dto));
        assertThrows(IllegalArgumentException.class,() -> store.createCenter(dto2));
        assertThrows(IllegalArgumentException.class,() -> store.createCenter(dto3));

    }

    @Test

    public void testGets(){
        Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");
        List<VaccineType> avaiableTypes = new ArrayList<>(){{
            add(new VaccineType("AF23P","Covid-19 vaccine",3));

        }};
        List<String> expectedPhone = new ArrayList<>();
        expectedPhone.add("123456789");

        List<Email> expectedEmail = new ArrayList<>();
        expectedEmail.add(new Email("vamargemsul@gmail.com"));


        HealthCareCenter center = new HealthCareCenter("HealthCare Boavista","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes,1);
        VaccinationCenterStore store = new VaccinationCenterStore();

        List<VaccinationCenterDto> expected = new ArrayList<>() {{
            add(VaccinationCenterMapper.centerToDto(center));

        }};

        HealthCareCenterDto dto = new HealthCareCenterDto("HealthCare Boavista","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes,1);
        dto.setCenterCoordinator(coordinator);
        store.createCenter(dto);
        assertEquals(expected.get(0).getName(),store.getListOfCenters().get(0).getName());
        assertEquals(expectedPhone,store.getPhoneNumbers());
        assertEquals(expectedEmail,store.getEmails());

    }
    @Test
    public void testfindvaccinationcenter(){
        List<VaccineType> listvac=new ArrayList<>();
        VaccineType vactype=new VaccineType("NOU45","analisa o SARSCOV2",5);
        listvac.add(vactype);
        VaccinationCenter vac1=new HealthCareCenter("Centro de Vacinação de Matosinhos","Rua António Manuel","910666777","jordan@gmail.com","222888999090","www.ola.pt",new Coordinator("jojo@gmail.com","ola","COORDINATOR",910888999,23456788,"Rua Manuel Eva","Centro de Vacinação de Matosinhos"),new Hour(7,30,0),new Hour(19,20,0),8,10,listvac,2);
        VaccinationCenterStore vacstore = new VaccinationCenterStore();
        vacstore.createCenter(VaccinationCenterMapper.centerToDto(vac1));
        Assertions.assertEquals(vac1,vacstore.findVaccinationCenter("Centro de Vacinação de Matosinhos"));
    }

}