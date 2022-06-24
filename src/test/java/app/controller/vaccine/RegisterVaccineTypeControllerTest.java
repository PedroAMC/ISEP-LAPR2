package app.controller.vaccine;

import app.controller.App;
import app.domain.model.data.vaccine.VaccineType;
import app.domain.model.dto.vaccine.VaccineTypeDto;
import app.domain.store.vaccine.VaccineTypeStore;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RegisterVaccineTypeControllerTest {

    @Test

    public void testCreateNewVaccineType (){

        VaccineTypeStore store = App.getInstance().getCompany().getVaccineTypeStore();
        RegisterVaccineTypeController controller = new RegisterVaccineTypeController();

        VaccineTypeDto dto = new VaccineTypeDto("AF23P","Covid-19 vaccine",3);
        VaccineTypeDto dto2 = new VaccineTypeDto("AF23T","MonkeyPox vaccine",4);
        VaccineType type = new VaccineType("AF23P","Covid-19 vaccine",3);
        VaccineType type2 = new VaccineType("AF23T","MonkeyPox vaccine",4);

        List<VaccineType> expectedList = new ArrayList<>(){{
            add(type);
            add(type2);
        }};
        controller.createVaccineType(dto);
        controller.createVaccineType(dto2);


        assertEquals(expectedList,store.getVaccineTypes());

    }

}