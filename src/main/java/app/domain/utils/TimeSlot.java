package app.domain.utils;

import java.time.LocalTime;

public class TimeSlot  extends Hour {

    /**
     * Class to represent each time slot used to analyze the center performance in US16
     *
     * @author Pedro Campos <1211511@isep.ipp.pt>
     */


    private Hour time;
    private int counter;


    /**
     * Constructor for the TimeSlot class
     * @param time
     */
    public TimeSlot(Hour time){

        this.time = time;
        this.counter = 0;
    }

    /**
     * Method to get the TimeSlot time
     * @return time
     */
    public Hour getTime() {
        return time;
    }

    /**
     * Method to get the TimeSlot counter
     * @return counter
     */
    public int getCounter() {
        return counter;
    }

    /**
     * Method to get increment the TimeSlot counter
     */
    public void incrementCounter(){
        counter++;

    }

    /**
     * Method to get decrement the TimeSlot counter
     */
    public void decrementCounter(){
        counter--;
    }

    @Override
    public String toString() {
        return "TimeSlot{" +
                "time=" + time +
                ", counter=" + counter +
                '}';
    }
}
