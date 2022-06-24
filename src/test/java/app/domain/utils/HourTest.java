package app.domain.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HourTest {

    @Test
    void testAddMinutes() {

        Hour startHour = new Hour(19,40,0);
        Hour startHour2 = new Hour(23,40,0);
        Hour aftersum = new Hour(20,0,0);
        Hour aftersum2 = new Hour(21,30,0);
        Hour aftersum3 = new Hour(0,10,0);
        assertEquals(aftersum,startHour.addMinutes(20));
        assertEquals(aftersum2,startHour.addMinutes(110));
        assertEquals(aftersum3,startHour2.addMinutes(30));

    }
}