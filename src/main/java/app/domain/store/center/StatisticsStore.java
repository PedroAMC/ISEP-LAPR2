package app.domain.store.center;

import app.domain.model.data.centers.VaccinationCenter;
import app.domain.model.data.snsuser.SnsUser;
import app.domain.model.data.vaccine.VaccineAdministration;
import app.domain.model.dto.centers.StatisticsDto;
import app.domain.model.mapper.center.StatisticsMapper;
import app.domain.store.VaccineStore;
import app.domain.store.schedule.ScheduleStore;
import app.domain.store.snsuser.SnsUserStore;
import app.domain.store.vaccine.VaccineAdministrationStore;
import app.domain.utils.Date;
import app.domain.utils.Pair;
import pt.isep.lei.esoft.auth.domain.model.User;

import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Store class of us15
 *
 * @author Miguel Ferreira <1211488@isep.ipp.pt>
 */

public class StatisticsStore {

    private static  List<Pair<Date, Integer>> list1=new ArrayList<>();
    private static  List<Date> list2=new ArrayList<>();
    private VaccineStore vaccineStore;

    /**
     * Method to get the StatisticsDto
     *
     * @param administrationsStore Store with the vaccine administrations
     * @param timeInterval String contains the time interval of the statistics the user wants
     * @param userStore Store with Users
     * @param vac Vaccination Center in which the Coordinator works
     */

    public StatisticsDto getFullyVaccinatedUsers(VaccineAdministrationStore administrationsStore, String timeInterval, SnsUserStore userStore, VaccinationCenter vac) {
        List<VaccineAdministration> vaccineAdministrations=administrationsStore.getVaccineAdministrationsByVaccinationCenter(vac);
        for(VaccineAdministration vacad : vaccineAdministrations){
            Date date = vacad.getArrivalDate();
            if(dateIsWithinTimeInterval(date,timeInterval)) {
                String SnsNumber = vacad.getSnsUserNumber();
                SnsUser user = userStore.getSnsUser(SnsNumber);
               if(user.getVaccinationStatus(vaccineAdministrations, vaccineStore.getVaccineByVaccineName(vacad.getVaccineName()),SnsNumber).equals("Fully vaccinated")){
                    addFullyVaccinatedUser(date, list2);
                }
            }
        }
        list2tolist1(list1,list2);
        return StatisticsMapper.statisticsToDto(list1);
    }

    /**
     * Method to check if a certain date is within the Time Interval
     *
     * @param date   a certain date
     * @param timeInterval String contains the time interval of the statistics the user wants
     */

    public boolean dateIsWithinTimeInterval(Date date, String timeInterval) {
        String [] array=timeInterval.split("-");
        String[] array2=array[0].split(",");

        int []date1=new int[array2.length];

        for (int i = 0; i < array2.length; i++) {
            date1[i]=Integer.parseInt(array2[i]);
        }

        String[] array3=array[1].split(",");
        int []date2=new int[array3.length];

        for (int i = 0; i < array3.length; i++) {
            date2[i]=Integer.parseInt(array3[i]);
        }

        Date firstDate=new Date(date1[0],date1[1],date1[2]);
        Date secondDate=new Date(date2[0],date2[1],date2[2]);

        return date.isWithinTimeInterval(firstDate,secondDate);
    }

    /**
     * Method to add  a certain date to a list of dates
     *
     * @param date  a certain date
     * @param list list of dates
     */

    public void addFullyVaccinatedUser( Date date, List<Date> list){
        list.add(date);
    }

    /**
     * Method to add dates and the number of each in a list of Dates
     *
     * @param list1  list with dates and each respective integer number
     * @param list2 list with dates
     */

    public  void list2tolist1(List<Pair<Date, Integer>> list1, List<Date> list2){
        for(Date date:list2){
            if(!isEqual(date,list1)){
                list1.add(new Pair<>(date,counterPairDate(list2,date)));
            }
        }
    }

    /**
     * Method to count the dates in a list of Dates
     *
     * @param date  a certain date
     * @param list2 a list of dates
     */


    public Integer counterPairDate(List<Date> list2, Date date){
        Integer counter=0;
        for(Date date2: list2){
            if(date2.equals(date)){
                counter++;
            }
        }
        return  counter;
    }

    /**
     * Method to check if the a certain date is already in the list
     *
     * @param date  a certain date
     * @param list list with dates and the respective integer number
     */

    public boolean isEqual(Date date, List<Pair<Date, Integer>> list){
        for(Pair<Date,Integer> p:list){
            if(date.equals(p.getFirst())){
                return true;
            }
        }
        return false;
    }
}
