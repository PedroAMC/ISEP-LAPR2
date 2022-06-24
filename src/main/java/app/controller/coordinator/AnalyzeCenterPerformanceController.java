package app.controller.coordinator;

import app.controller.App;
import app.domain.model.data.centers.VaccinationCenter;
import app.domain.model.data.vaccine.VaccineAdministration;
import app.domain.store.center.VaccinationCenterStore;
import app.domain.store.vaccine.VaccineAdministrationStore;
import app.domain.utils.Algorithms;
import app.domain.utils.Date;
import app.domain.utils.Hour;
import app.domain.utils.TimeInterval;
import app.domain.utils.TimeSlot;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AnalyzeCenterPerformanceController implements Algorithms {

    /**
     * Controller class of us16
     *
     * @author Pedro Campos <1211511@isep.ipp.pt>
     */

    private final VaccinationCenterStore vaccinationCenterStore;
    private final VaccineAdministrationStore vaccineAdministrationStore;
    private final int MINUTES_IN_DAY_OF_WORK = 720;


    /**
     * Constructor of the class
     */

    public AnalyzeCenterPerformanceController(){

        this.vaccinationCenterStore = App.getInstance().getCompany().getVaccinationCenterStore();
        this.vaccineAdministrationStore = App.getInstance().getCompany().getVaccineAdministrationStore();

    }


    /**
     * Method to get a vaccinationCenterObject by name
     * @param vaccinationCenterName
     * @return vaccinataionCenter Object
     */
    public VaccinationCenter getVaccinationCenter(String vaccinationCenterName){

        VaccinationCenter vaccinationCenter = vaccinationCenterStore.findVaccinationCenter(vaccinationCenterName);

        return vaccinationCenter;

    }

    /**
     * Method to get verify if there are any vaccine administrations on the selected date
     * @param date selected day
     * @return boolean representing if there are any administrations or not
     */
    public boolean verifyInputDate(Date date, VaccinationCenter vaccinationCenter){
        if (!vaccineAdministrationStore.getVaccineAdministrationsByDateAndCenter(date, vaccinationCenter).isEmpty()){
            return true;
        } else {
            throw new IllegalArgumentException("There are no vaccine administrations for that date.");
        }

    }

    /**
     * Method to get the list where each value represents the difference between the number of new clients arriving and clients leaving for that time interval
     * @param timeInterval selected timeInterval
     * @param date selected date
     * @return list
     */
    public List<TimeSlot> createInputList(int timeInterval, Date date, VaccinationCenter vaccinationCenter){
        List<VaccineAdministration> dayList = vaccineAdministrationStore.getVaccineAdministrationsByDateAndCenter(date, vaccinationCenter);
        /*
        for (int i = 0; i < dayList.size(); i++) {
            System.out.println(dayList.get(i).getArrivalDate().getDay());
        }
        */
        List<TimeSlot> inputList = new LinkedList<>();
        Hour start = new Hour(8,0);
        Hour end = new Hour(20,00);

        inputList.add(new TimeSlot(start));
        while (start.compareTo(end) < 0  ){
            start = start.addMinutes(timeInterval);
            inputList.add(new TimeSlot(start));
        }

        for (VaccineAdministration v : dayList){
            boolean increment = false;
            boolean decrement = false;
            Hour incrementTime = v.getArrivalHour();
            Hour decrementTime = v.getLeavingHour();


            for (int i = 1; i < inputList.size(); i++) {
                if (!incrementTime.isMaior(inputList.get(i).getTime()) && !increment){
                    inputList.get(i-1).incrementCounter();
                    increment = true;
                }

                if (!decrementTime.isMaior(inputList.get(i).getTime()) && !decrement){
                    inputList.get(i-1).decrementCounter();
                    decrement = true;
                }

                if (increment && decrement){
                    break;
                }
            }



        }
        return inputList;
    }

    /**
     * Method to get the list where each value represents the difference between the number of new clients arriving and clients leaving for that time interval
     * @param timeInterval selected timeInterval
     * @param date selected date
     * @return list
     */
    public int[] createInputListForBenchmark(int timeInterval, Date date, VaccinationCenter vaccinationCenter){
        List<VaccineAdministration> dayList = vaccineAdministrationStore.getVaccineAdministrationsByDateAndCenter(date, vaccinationCenter);
        /*
        for (int i = 0; i < dayList.size(); i++) {
            System.out.println(dayList.get(i).getArrivalDate().getDay());
        }
        */
        List<TimeSlot> inputList = new LinkedList<>();
        Hour start = new Hour(8,0);
        Hour end = new Hour(20,00);

        inputList.add(new TimeSlot(start));
        while (start.compareTo(end) < 0  ){
            start = start.addMinutes(timeInterval);
            inputList.add(new TimeSlot(start));
        }

        for (VaccineAdministration v : dayList){
            boolean increment = false;
            boolean decrement = false;
            Hour incrementTime = v.getArrivalHour();
            Hour decrementTime = v.getLeavingHour();


            for (int i = 1; i < inputList.size(); i++) {
                if (!incrementTime.isMaior(inputList.get(i).getTime()) && !increment){
                    inputList.get(i-1).incrementCounter();
                    increment = true;
                }

                if (!decrementTime.isMaior(inputList.get(i).getTime()) && !decrement){
                    inputList.get(i-1).decrementCounter();
                    decrement = true;
                }

                if (increment && decrement){
                    break;
                }
            }

        }
        int[] returnList = new int[inputList.size()];

        for (int i = 0; i < inputList.size(); i++) {
            int value = inputList.get(i).getCounter();
            returnList[i] = value;
        }

        return returnList;
    }



    /**
     * Method to get the least effective time interval of the vaccination center, using a brute-force algorithm to calculate the sublist with the maximum sum
     * @param centerPerformance list of the time slots of the vaccination center
     * @return least effective time interval object
     */
    public TimeInterval determineLeastEffectiveTimeInterval(List<TimeSlot> centerPerformance){

        int max = 0;
        int startIndex = 0;
        int finalIndex = 0;

        for (int firstIndex = 0; firstIndex < centerPerformance.size(); firstIndex++) {

            int sum = 0;

            for (int secondIndex = 0; secondIndex < centerPerformance.size(); secondIndex++) {

                sum += centerPerformance.get(secondIndex).getCounter();

                if (max < sum){

                    startIndex = firstIndex;
                    finalIndex = secondIndex;
                    max = sum;
                }

            }
        }



        return new TimeInterval(max,centerPerformance.subList(startIndex ,finalIndex + 1));
    }

    /**
     * Method to get the sum of a interval within the center performance list
     * @param centerPerformance list of the time slots of the vaccination center
     * @param start starting index of the time interval to be analyzed
     * @param end last index of the time interval to be analyzed
     * @return list
     */


    public TimeInterval getIntervalSum(List<TimeSlot> centerPerformance, int start, int end){
        int sum = 0;
        List<TimeSlot> observedInterval = centerPerformance.subList(start, end);
        for (TimeSlot t : observedInterval){
            sum += t.getCounter();
        }
        return new TimeInterval(sum, observedInterval);
    }

    /**
     * Benchmark algorithm provived
     */
    public int[] sum(final int[] seq) {
        int maxSoFar = 0;
        int maxEndingHere = 0;
        int startMaxSoFar = 0;
        int endMaxSoFar = 0;
        int startMaxEndingHere = 0;
        for (int i = 0; i < seq.length; ++i) {
            final int elem = seq[i];
            final int endMaxEndingHere = i + 1;
            if (maxEndingHere + elem < 0) {
                maxEndingHere = 0;
                startMaxEndingHere = i + 1;
            }
            else {
                maxEndingHere += elem;
            }
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                startMaxSoFar = startMaxEndingHere;
                endMaxSoFar = endMaxEndingHere;
            }
        }
        return Arrays.copyOfRange(seq, startMaxSoFar, endMaxSoFar);
    }
}
