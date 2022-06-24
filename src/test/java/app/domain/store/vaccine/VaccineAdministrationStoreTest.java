package app.domain.store.vaccine;

import app.controller.App;
import app.domain.model.data.centers.VaccinationCenter;
import app.domain.model.data.employees.Coordinator;
import app.domain.model.data.vaccine.VaccineAdministration;
import app.domain.model.dto.vaccine.VaccineAdministrationDto;
import app.domain.utils.Date;
import app.domain.utils.Hour;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class VaccineAdministrationStoreTest {

    private static boolean setUpIsDone = false;

    Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");
    VaccinationCenter vaccinationCenter = new VaccinationCenter("HealthCare Lisboa","Margem Sul 23","123456789","lisboa@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5);
    VaccineAdministrationStore vaccineAdministrationStore = new VaccineAdministrationStore();

    Date data = new Date(30,5,2022);
    Hour horaSch = new Hour(8, 10);
    Hour horaAdm = new Hour(8,12);


    VaccineAdministrationDto dto1 = new VaccineAdministrationDto("161593120", "Spikevax", "Primeira", "21C16-05", data, horaSch, data, new Hour(8, 29), data, horaAdm, data, new Hour(8, 50),vaccinationCenter);
    VaccineAdministrationDto dto2= new VaccineAdministrationDto("161593121", "Spikevax", "Primeira", "21C16-05", data, horaSch, data, new Hour(8, 15), data, horaAdm, data, new Hour(9, 10),vaccinationCenter);

    VaccineAdministration vac1 = vaccineAdministrationStore.createVaccineAdministration(dto1);
    VaccineAdministration vac2 = vaccineAdministrationStore.createVaccineAdministration(dto2);




    @BeforeEach
    public void setUp() {

        vaccineAdministrationStore = new VaccineAdministrationStore();

        vaccineAdministrationStore.addVaccineAdministration(vac1);
        vaccineAdministrationStore.addVaccineAdministration(vac2);
    }




    @Test
    @DisplayName("Test for the getVaccineAdministrationsByDateAndCenter when there aren't any vaccine administrations for that date and center.")
    public void getVaccineAdministrationsByDateAndCenterTestFalse(){

        Date date = new Date(29,5,2022);

        List<VaccineAdministration> list = vaccineAdministrationStore.getVaccineAdministrationsByDateAndCenter(date, vaccinationCenter);

        Assertions.assertEquals(0, list.size());

    }

    @Test
    @DisplayName("Test for the getVaccineAdministrationsByDateAndCenter when there are vaccine administrations for that date and center.")
    public void getVaccineAdministrationsByDateAndCenterTestPositive(){

        Date date = new Date(30,5,2022);

        List<VaccineAdministration> list = vaccineAdministrationStore.getVaccineAdministrationsByDateAndCenter(date, vaccinationCenter);

        Assertions.assertEquals(2, list.size());

    }

    @Test
    @DisplayName("Test for the getVaccineAdministrationsByVaccinationCenter there are vaccine administrations for that vaccination center.")
    public void getVaccineAdministrationsByVaccinationCenterTestPositive(){


        List<VaccineAdministration> list = vaccineAdministrationStore.getVaccineAdministrationsByVaccinationCenter(vaccinationCenter);

        Assertions.assertEquals(2, list.size());

    }

    @Test
    @DisplayName("Test for the getVaccineAdministrationsByVaccinationCenter there aren't any vaccine administrations for that vaccination center.")
    public void getVaccineAdministrationsByVaccinationCenterTestFalse(){


        List<VaccineAdministration> list = vaccineAdministrationStore.getVaccineAdministrationsByVaccinationCenter(null);

        Assertions.assertEquals(0, list.size());

    }
}
