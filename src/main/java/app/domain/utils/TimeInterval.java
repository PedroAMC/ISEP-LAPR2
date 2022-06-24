package app.domain.utils;

import java.util.List;

public class TimeInterval {

    /**
     * Class to represent each a time interval that was analyzed in US16 brute-force algorithm
     *
     * @author Pedro Campos <1211511@isep.ipp.pt>
     */


    private int sum;
    private List<TimeSlot> slots;

    /**
     * Constructor for the TimeInterval class
     * @param sum
     * @param slots
     */
    public TimeInterval(int sum, List<TimeSlot> slots){
        this.sum = sum;
        this.slots = slots;

    }

    /**
     * Method to get the TimeInterval sum
     * @return sum
     */
    public int getSum() {
        return sum;
    }


    /**
     * Method to get the TimeInterval list of slots
     * @return slots
     */
    public List<TimeSlot> getSlots() {
        return slots;
    }

    @Override
    public String toString() {
        return "TimeInterval{" +
                "sum=" + sum +
                ", slots=" + slots +
                '}';
    }
}
