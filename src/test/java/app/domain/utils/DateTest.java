package app.domain.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DateTest {

    @Test
    public void validateDataTest(){

        assertThrows(Exception.class,() -> {
            Date date1 = new Date(32,1,2022);
        });

        assertThrows(Exception.class,() -> {
            Date date2 = new Date(31,13,2022);
        });
    }

    @Test
    public void testGet(){

        Date date = new Date(31,1,2022);
        assertEquals(31,date.getDay());
        assertEquals(1,date.getMonth());
        assertEquals(2022,date.getYear());

    }


}
