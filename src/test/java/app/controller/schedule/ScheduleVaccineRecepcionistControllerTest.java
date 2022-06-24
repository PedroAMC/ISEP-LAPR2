package app.controller.schedule;

import app.controller.App;
import app.domain.model.data.snsuser.SnsUser;
import app.domain.model.data.vaccine.VaccineType;
import app.domain.model.dto.centers.HealthCareCenterDto;
import app.domain.model.dto.schedule.ScheduleDto;
import app.domain.model.dto.utils.DateDto;
import app.domain.model.dto.utils.HourDto;
import app.domain.model.dto.vaccine.VaccineTypeDto;
import app.domain.store.snsuser.SnsUserStore;
import app.domain.utils.Hour;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScheduleVaccineRecepcionistControllerTest {

    @Test
    void verifySnsNumber() {

        App.getInstance().getCompany().getSnsUserStore().registerSnsUser(new SnsUser("Diogo","Rua de cima","Male","960168874","diogo@gmail.com","19/12/2002","167898423","16658688",1));
        String snsNumber = "167898423";
        ScheduleVaccineRecepcionistController controller = new ScheduleVaccineRecepcionistController();

        assertTrue(controller.verifySnsNumber(snsNumber));

    }

    @Test
    void createSchedule() {
        ScheduleVaccineRecepcionistController controller = new ScheduleVaccineRecepcionistController();

        List<VaccineType> avaiableTypes = new ArrayList<>() {{
            add(new VaccineType("AF23P", "Covid-19 vaccine", 3));

        }};

        ScheduleDto scheduleDto = new ScheduleDto(new DateDto(12, 1, 2022), new HourDto(12, 30, 0), new HealthCareCenterDto("Maia Center", "Margem Sul 23", "123456789", "vamargemsul@gmail.com", "900-300-5555", "vamargemsul.com.pt", new Hour(9, 0, 0), new Hour(18, 0, 0), 30, 5, avaiableTypes, 2));
        controller.createSchedule(scheduleDto);
        assertNotEquals(controller.getListOfCenters(), new ArrayList<>());
    }
}
