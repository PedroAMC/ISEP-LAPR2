package app.domain.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TimeIntervalTest {

    @Test
    @DisplayName("Test for get methods")
    public void testGetters(){

        List<TimeSlot> slots = new ArrayList<>();
        slots.add(new TimeSlot(new Hour(8, 0, 0)));

        TimeInterval timeInterval = new TimeInterval(10, slots);

        Assertions.assertEquals(10, timeInterval.getSum());
        Assertions.assertEquals(slots, timeInterval.getSlots());

    }
}
