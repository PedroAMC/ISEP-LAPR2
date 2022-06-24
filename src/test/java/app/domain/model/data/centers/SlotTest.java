package app.domain.model.data.centers;


import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class SlotTest {

    @Test
    public void testCreation (){

        Slot slot = new Slot(30,1);


        assertEquals(slot.getSlotDuration(),30);
        assertEquals(slot.getCapacity(),1);
        assertThrows(Exception.class,() -> {
            slot.updateCapacity();
            slot.updateCapacity();

        });

    }

    @Test

    public void testToString(){

        Slot slot = new Slot(30,1);
        assertEquals(slot.toString(),"Slot :\n" +
                "Duration: 30\n" +
                "Capacity: 1" + "\n");

    }

    @Test

    public void testEquals(){

        Slot slot = new Slot(30,1);
        Slot slot2 = slot;
        Slot slot3 = new Slot(30,1);



        assertEquals(slot,slot2);
        assertNotEquals(slot,null);
        assertNotEquals(slot,"slot");
        assertEquals(slot3,slot);

    }

    @Test

    public void testHash(){

        Slot slot = new Slot(30,1);

        assertEquals(Objects.hash(slot.getSlotDuration(),slot.getCapacity()),slot.hashCode());

    }

}