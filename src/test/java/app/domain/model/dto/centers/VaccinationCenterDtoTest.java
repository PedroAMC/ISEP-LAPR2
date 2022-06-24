package app.domain.model.dto.centers;

import app.domain.model.data.centers.VaccinationCenter;
import app.domain.model.data.employees.Coordinator;
import app.domain.utils.Hour;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VaccinationCenterDtoTest {

    @Test

    public void testDto(){
        Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");
        VaccinationCenterDto dto = new VaccinationCenterDto("Maia Center","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",new Hour(9,0,0),new Hour(18,0,0),30,5);

        assertEquals("Maia Center",dto.getName());
        assertEquals("Margem Sul 23",dto.getAddress());
        assertEquals("123456789",dto.getPhoneNumber());
        assertEquals("vamargemsul@gmail.com",dto.getEmail());
        assertEquals("900-300-5555",dto.getFax());
        assertEquals("vamargemsul.com.pt",dto.getWebsiteAddress());
        assertEquals(new Hour(9,0,0),dto.getOpenHour());
        assertEquals(new Hour(18,0,0),dto.getCloseHour());
        assertEquals(30,dto.getSlotDuration());
        assertEquals(5,dto.getCapacity());
        dto.setCenterCoordinator(coordinator);
        assertEquals(coordinator,dto.getCenterCoordinator());



    }

}