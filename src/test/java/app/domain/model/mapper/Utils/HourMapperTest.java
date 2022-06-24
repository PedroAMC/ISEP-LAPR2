package app.domain.model.mapper.Utils;

import app.domain.model.dto.Utils.HourDtoTest;
import app.domain.model.dto.utils.HourDto;
import app.domain.utils.Hour;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HourMapperTest {
    @Test
    public void toHour(){
    Hour hour1=new Hour(11,20,30);
    HourDto hourdto1=new HourDto(11,20,30);
    Assertions.assertEquals(hour1,HourMapper.toHour(hourdto1));
    }
    @Test
    public void toHourDto(){
        Hour hour2=new Hour(10,10,30);
        HourDto hourdto2=new HourDto(10,10,30);
        Assertions.assertEquals(hourdto2.getHoras(),HourMapper.toHourDto(hour2).getHoras());
        Assertions.assertEquals(hourdto2.getMinutos(),HourMapper.toHourDto(hour2).getMinutos());
        Assertions.assertEquals(hourdto2.getSegundos(),HourMapper.toHourDto(hour2).getSegundos());
    }
}
