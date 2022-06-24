package app.domain.store.vaccine;

import app.domain.model.data.vaccine.VaccineType;
import app.domain.model.dto.vaccine.VaccineTypeDto;
import app.domain.store.vaccine.VaccineTypeStore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class VaccineTypeStoreTest {

    @Test
    public void testCreation(){

        VaccineTypeStore store = new VaccineTypeStore();
        VaccineTypeDto dto = new VaccineTypeDto("AF23P","Covid-19 vaccine", 3);
        VaccineTypeDto dto2 = new VaccineTypeDto("AF23P","Covid-19 vaccine", 3);
        VaccineType type = new VaccineType("AF23P","Covid-19 vaccine", 3);
        //Expected list of vaccine types in the current store
        List<VaccineType> expectedList = new ArrayList<>();
        expectedList.add(type);
        //method to add the vaccine type to the store
        store.createVaccineType(dto);

        //Test to see if the actual list is equal to the expected store
        assertEquals(store.getVaccineTypes(),expectedList);

        //test to see if a vaccine type already exists it fails
        assertThrows(IllegalArgumentException.class,() -> {
            store.createVaccineType(dto2);
        });
    }

}