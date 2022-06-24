package app.domain.model.data.centers;

import app.domain.utils.Hour;
import java.util.HashMap;
import java.util.Map;


/**
 * Class to represent the avaiability of a day in the vaccination center
 *
 * @author Diogo Teixeira <1200904@isep.ipp.pt>
 */

public class CenterDays {

    private final Map<Hour,Slot> avaiability;

    /**
     * Constructor of the CenterDays class
     * @param slot division of the administration periods during a day
     * @param hours opening and closing hours of the vaccination center
     *
     */
    public CenterDays(Slot slot,CenterHours hours) {
        this.avaiability = new HashMap<>();
        fillDefaultSchedule(slot,hours);

    }

    /**
     * Method to update the capacity of a slot
     * @param hour hour that the user want to schedule the vaccine administration
     */
    public void setSchedule (Hour hour) throws Exception {

        Slot slot = avaiability.get(hour);

        slot.updateCapacity();

    }

    /**
     * Method to fill the vaccine center timetable with the given properties of the slots
     * @param slot division of the administration periods during a day
     * @param hours opening and closing hours of the vaccination center
     */
    public void fillDefaultSchedule(Slot slot, CenterHours hours){

        int slotDuration = slot.getSlotDuration();
        int slotCapacity = slot.getCapacity();

        Hour scheduleHour;

        avaiability.put(hours.getOpeningHour(),new Slot(slotDuration,slotCapacity));
        scheduleHour = hours.getOpeningHour().addMinutes(slotDuration);

        while (scheduleHour.compareTo(hours.getClosingHour()) <= 0){

            avaiability.put(scheduleHour, new Slot(slotDuration,slotCapacity));

            scheduleHour = scheduleHour.addMinutes(slotDuration);

        }

    }

    /**
     * Get method to obtain the timetable of a given day
     * @return timetable of a given day
     */
    public Map<Hour, Slot> getAvaiability() {
        return avaiability;
    }


}
