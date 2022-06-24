package app.domain.model.data.centers;

import app.domain.utils.Hour;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CenterDaysTest {


    @Test

    public void testConstruction (){

        CenterDays days = new CenterDays(new Slot(30,5), new CenterHours(new Hour(9,0,0), new Hour(18,0,0)));


        Map<Hour,Slot> expectedMap = new HashMap<>();

        Hour fakeHour = new Hour(9,0,0);

        while (fakeHour.compareTo(new Hour(18,0,0)) <= 0){

            expectedMap.put(fakeHour, new Slot(30,5));
            fakeHour = fakeHour.addMinutes(30);
        }

        for (Hour h : expectedMap.keySet()){

            assertTrue(days.getAvaiability().containsKey(h));
        }

    }


    @Test

    public void testSetSchedule (){


        CenterDays days = new CenterDays(new Slot(30,5), new CenterHours(new Hour(9,0,0), new Hour(18,0,0)));

        try{
            days.setSchedule(new Hour(9,30,0));
            assertEquals(4,days.getAvaiability().get(new Hour(9,30,0)).getCapacity());
        }catch (Exception e){
            e.printStackTrace();
        }

        assertThrows(Exception.class,() -> {
            days.setSchedule(new Hour(9,30,0));
            days.setSchedule(new Hour(9,30,0));
            days.setSchedule(new Hour(9,30,0));
            days.setSchedule(new Hour(9,30,0));
            days.setSchedule(new Hour(9,30,0));

        });

    }

}