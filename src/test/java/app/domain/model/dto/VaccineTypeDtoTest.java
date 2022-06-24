package app.domain.model.dto;

import app.domain.model.dto.vaccine.VaccineTypeDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VaccineTypeDtoTest{

    /**
     * method to test getters and setters methods from the class VaccineTypeDto
     *
     * @author Diogo Teixeira <1200904@isep.ipp.pt>
     */
    @Test
    public void testGetAndSet(){
        VaccineTypeDto dto = new VaccineTypeDto("AF23P","Covid-19 vaccine", 3);
        //test the getTypeCode
        assertEquals("AF23P",dto.getTypeCode());
        //test the getShortDescription
        assertEquals("Covid-19 vaccine",dto.getShortDescription());
        //test the getTechnology
        assertEquals(3,dto.getTechnology());

    }

    /**
     * Method to test equals method from the class VaccineTypeDto
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    @Test
    public void testEquals(){
        VaccineTypeDto dto1 = new VaccineTypeDto("AF23P","Covid-19 vaccine", 3);
        VaccineTypeDto dto2 = new VaccineTypeDto("AF23P","Covid-19 vaccine", 3);
        assertEquals(dto1, dto2);
        assertNotEquals(dto1,null);
        assertNotEquals(dto2,null);
    }

}