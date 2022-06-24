package app.controller.snsuser;



import app.domain.model.data.employees.Coordinator;
import app.domain.model.data.vaccine.VaccineType;
import app.domain.model.dto.centers.CommunityMassVaccinationCenterDto;
import app.domain.model.dto.centers.HealthCareCenterDto;
import app.domain.model.dto.centers.VaccinationCenterDto;
import app.domain.model.dto.vaccine.VaccineTypeDto;
import app.domain.utils.Hour;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleVaccineControllerTest {


    @Test

    public void testGetList(){


        VaccineTypeDto type = new VaccineTypeDto("AF23P","Covid-19 vaccine",3);
        VaccineTypeDto type1 = new VaccineTypeDto("MT21T","MonkeyPox vaccine",2);

        List<VaccineTypeDto> types = new ArrayList<>(){{
            add(type);
            add(type1);
        }};

        ScheduleVaccineController controller = new ScheduleVaccineController();

        assertEquals(types,controller.getListOfTypes());



        List<VaccineType> avaiableTypes = new ArrayList<>(){{
            add(new VaccineType("AF23P","Covid-19 vaccine",3));

        }};
        List<VaccineType> avaiableTypes2 = new ArrayList<>(){{
            add(new VaccineType("AF23P","Covid-19 vaccine",3));
            add(new VaccineType("AF24T","MonkeyPox vaccine",2));

        }};

        Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");
        HealthCareCenterDto dto = new HealthCareCenterDto("HealthCare Boavista","Margem Sul 23","123456780","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes2,1);
        dto.setCenterCoordinator(coordinator);

        CommunityMassVaccinationCenterDto dto1 = new CommunityMassVaccinationCenterDto("HealthCare Lisboa","Margem Sul 23","123456789","lisboa@gmail.com","900-300-5555","vamargemsul.com.pt",new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes);
        dto1.setCenterCoordinator(coordinator);

        List<VaccinationCenterDto> centers = new ArrayList<>(){{
           add(dto1);
           add(dto);
        }};

        assertEquals(centers.get(0).getName(),controller.getListOfCenters().get(0).getName());
        assertEquals(centers.get(1).getName(),controller.getListOfCenters().get(1).getName());


    }


    @Test

    public void getOngoing () {

        ScheduleVaccineController controller = new ScheduleVaccineController();

        VaccineTypeDto type = new VaccineTypeDto("AF23P","Covid-19 vaccine",3);

        assertEquals(type,controller.getOngoingBreakoutType("Covid-19 vaccine"));


    }


}