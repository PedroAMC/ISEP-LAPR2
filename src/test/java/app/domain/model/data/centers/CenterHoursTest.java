package app.domain.model.data.centers;

import app.domain.utils.Hour;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CenterHoursTest {


    @Test

    public void testCenterHours (){

        CenterHours hours = new CenterHours(new Hour(9,0,0),new Hour(18,0,0));

        assertEquals(new Hour(9,0,0),hours.getOpeningHour());
        assertEquals(new Hour(18,0,0),hours.getClosingHour());

    }

    @Test

    public void testCenterhoursToString (){

        CenterHours hours = new CenterHours(new Hour(9,0,0),new Hour(18,0,0));
        assertEquals("CenterHours:\n" +
                "Opening Hour: 09:00:00 AM\n" +
                "Closing Hour: 06:00:00 PM" + "\n",hours.toString());
    }

    @Test

    public void testEquals(){
        CenterHours hours = new CenterHours(new Hour(9,0,0),new Hour(18,0,0));
        CenterHours hours2 = hours;
        CenterHours hours3 = new CenterHours(new Hour(9,0,0),new Hour(18,0,0));



        assertEquals(hours,hours2);
        assertNotEquals(hours,null);
        assertNotEquals(hours,"hours");
        assertEquals(hours3,hours);


    }

    @Test

    public void testHash(){

        CenterHours hours = new CenterHours(new Hour(9,0,0),new Hour(18,0,0));

        assertEquals(Objects.hash(hours.getOpeningHour(),hours.getClosingHour()),hours.hashCode());
    }


}