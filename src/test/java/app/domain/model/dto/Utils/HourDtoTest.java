package app.domain.model.dto.Utils;

import app.domain.model.dto.utils.HourDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HourDtoTest {
    @Test
    public void HourDtoTest() {
        HourDto hourdto=new HourDto(9,20,0);
        Assertions.assertEquals(9,hourdto.getHoras());
        Assertions.assertEquals(20,hourdto.getMinutos());
        Assertions.assertEquals(0,hourdto.getSegundos());
    }
}
