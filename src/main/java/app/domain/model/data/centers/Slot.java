package app.domain.model.data.centers;


import java.util.Objects;

/**
 * Class to represent the details of slots to administrate vaccines at a vaccination center
 *
 * @author Diogo Teixeira <1200904@isep.ipp.pt>
 */
public class Slot {

    private final int slotDuration;
    private int capacity;

    /**
     * Constructor method of the slot class
     *
     * @param slotDuration duration in minutes of the slots of a vaccination center
     * @param maxPerSlot maximum number of vaccines that can be administered per slot
     */
    public Slot(int slotDuration, int maxPerSlot) {
        this.slotDuration = slotDuration;
        this.capacity = maxPerSlot;
    }

    /**
     * Get method to obtain the slot duration
     * @return slot duration
     */
    public int getSlotDuration() {
        return slotDuration;
    }

    /**
     * Get method to obtain the slot capacity
     * @return slot capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Method to update the remaining capacity of a slot when some sns user try to schedule a vaccine
     * @throws Exception when there are no more space for any other user to take a vaccine
     */
    public void updateCapacity() throws Exception {

        if(this.capacity != 0){
            this.capacity --;
        }else {
            throw new Exception("Slot is already full!");
        }

    }

    /**
     * Equals method
     * @param o object to compare
     * @return equal or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slot slot = (Slot) o;
        return slotDuration == slot.slotDuration && capacity == slot.capacity;
    }

    /**
     * HashCode method
     *
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(slotDuration, capacity);
    }

    /**
     *
     * @return String representation of the class
     */
    @Override
    public String toString() {
        return "Slot :\n" +
                "Duration: " + slotDuration + "\n" +
                "Capacity: " + capacity + "\n";
    }
}
