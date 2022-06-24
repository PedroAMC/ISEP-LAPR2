package app.controller.center;


import app.controller.App;
import app.domain.model.data.centers.HealthCareCenter;
import app.domain.model.data.centers.VaccinationCenter;
import app.domain.model.data.employees.Coordinator;
import app.domain.model.data.vaccine.VaccineType;
import app.domain.model.dto.centers.HealthCareCenterDto;
import app.domain.store.center.VaccinationCenterStore;
import app.domain.utils.Hour;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RegisterVaccinationCenterControllerTest {

    @Test

    public void testCreateCenter (){
        List<VaccineType> avaiableTypes = new ArrayList<>(){{
            add(new VaccineType("AF23P","Covid-19 vaccine",3));

        }};
        VaccinationCenterStore store = App.getInstance().getCompany().getVaccinationCenterStore();
        RegisterVaccinationCenterController controller = new RegisterVaccinationCenterController();
        Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");
        HealthCareCenterDto dto = new HealthCareCenterDto("HealthCare Boavista","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes,1);
        dto.setCenterCoordinator(coordinator);
        HealthCareCenter center = new HealthCareCenter("HealthCare Boavista","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes,1);
        HashMap<String, VaccinationCenter> expected = new HashMap<>(){{
           put(center.getName(),center);
        }};
        controller.createVaccinationCenter(dto);
        assertEquals(expected,store.getListOfCenters());



    }

}