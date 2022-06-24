package app.domain.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TimeSlotTest {


    @Test
    @DisplayName("Test for get methods")
    public void testGet(){


        Hour hour = new Hour(8, 0, 0);
        TimeSlot timeSlot = new TimeSlot(hour);

        Assertions.assertEquals(hour, timeSlot.getTime());
        Assertions.assertEquals(0, timeSlot.getCounter());

    }

    @Test
    @DisplayName("Test for incrementCounter method")
    public void incrementCounterTest(){

        TimeSlot timeSlot = new TimeSlot(new Hour(8, 0, 0));
        timeSlot.incrementCounter();

        Assertions.assertEquals(1, timeSlot.getCounter());


    }

    @Test
    @DisplayName("Test for decrementCounter method")
    public void decrementCounterTest(){

        TimeSlot timeSlot = new TimeSlot(new Hour(8, 0, 0));
        timeSlot.decrementCounter();

        Assertions.assertEquals(-1, timeSlot.getCounter());

    }

}
