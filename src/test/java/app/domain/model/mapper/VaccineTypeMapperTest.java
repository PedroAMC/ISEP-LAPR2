package app.domain.model.mapper;

import app.domain.model.data.vaccine.VaccineType;
import app.domain.model.dto.vaccine.VaccineTypeDto;
import app.domain.model.mapper.vaccine.VaccineTypeMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VaccineTypeMapperTest {

    @Test

    public void testMapper(){

        VaccineType type = new VaccineType("af23P","Covid-19 vaccine",2);
        VaccineTypeDto dto = new VaccineTypeDto("af23P","Covid-19 vaccine",2);
        assertEquals(VaccineTypeMapper.toVaccineType(dto),type);
    }


    @Test
    public void testToVaccineTypeDto(){

        VaccineType type = new VaccineType("af23P","Covid-19 vaccine",2);
        VaccineTypeDto dto = new VaccineTypeDto("af23P","Covid-19 vaccine",2);

        assertEquals(dto, VaccineTypeMapper.toVaccineTypeDto(type));
    }
}