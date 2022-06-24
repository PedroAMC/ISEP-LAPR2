package app.controller.center;

import app.controller.App;
import app.domain.model.data.centers.VaccinationCenter;
import app.domain.model.dto.centers.StatisticsDto;
import app.domain.model.dto.utils.DateDto;
import app.domain.model.dto.utils.IntegerDto;
import app.domain.store.center.StatisticsStore;
import app.domain.store.center.VaccinationCenterStore;
import app.domain.store.schedule.ScheduleStore;
import app.domain.store.snsuser.SnsUserStore;
import app.domain.store.vaccine.VaccineAdministrationStore;
import app.domain.utils.Date;
import app.domain.utils.Pair;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Controller class of us15
 *
 * @author Miguel Ferreira <1211488@isep.ipp.pt>
 */

public class StatisticsController {

    private VaccineAdministrationStore administrationstore;
    private final VaccinationCenterStore vaccinationCenterStore;
    private final ScheduleStore scheduleStore;
    private final SnsUserStore snsUserStore;
    private StatisticsStore statisticsStore;
    private static final String DELIMITER = ";";
    private static final String HEADER = "Date;Total Number of Fully Vaccinated Users \n";
    public StatisticsController(){
        administrationstore= App.getInstance().getCompany().getVaccineAdministrationStore();
        snsUserStore=App.getInstance().getCompany().getSnsUserStore();
        vaccinationCenterStore=App.getInstance().getCompany().getVaccinationCenterStore();
        scheduleStore=App.getInstance().getCompany().getScheduleStore();
        statisticsStore=App.getInstance().getCompany().getStatisticsStore();
    }

    /**
     * Method to get the Vaccination Center in which the Coordinator works
     *
     * @param vac String contains the name of the vaccination center in which the coordinator works
     */

    public VaccinationCenter getVaccinationCenter(String vac) {
        return vaccinationCenterStore.findVaccinationCenter(vac);
    }

    /**
     * Method to check the Vaccination Statistics
     *
     * @param vac String contains the name of the vaccination center in which the coordinator works
     * @param timeInterval String contains the time interval of the statistics the user wants
     */

    public StatisticsDto checkVaccinationStatistics(String timeInterval, String vac){
        return statisticsStore.getFullyVaccinatedUsers(administrationstore,timeInterval,snsUserStore,getVaccinationCenter(vac));
    }

    /**
     * Method to export the Vaccination Statistics to a csv file
     *
     * @param list List contains the list of the total number of fully vaccinated users per day.
     * @param fileName String contains the name of the file
     */


    public boolean exportVaccinationStatistics(List<Pair<DateDto, IntegerDto>> list, String fileName) throws IOException {
        try {
            FileWriter file = new FileWriter("out/"+fileName+".csv");
            file.append(HEADER);
            for (Pair<DateDto, IntegerDto> pair : list) {
                file.append(String.valueOf(pair.getFirst().getDay())).append("/").append(String.valueOf(pair.getFirst().getMonth())).append("/").append(String.valueOf(pair.getFirst().getYear())).append(DELIMITER);
                file.append(String.valueOf(pair.getSecond()));
            }
            file.close();
            return true;
        }catch(NullPointerException exception){
            exception.printStackTrace();
            return false;
        }
    }

    /**
     * Method to verify/validate the time interval
     *
     * @param timeInterval String contains the time interval of the statistics the user wants
     */

    public boolean verifyTimeInterval(String timeInterval){
        if(timeInterval.trim().isEmpty() || timeInterval.isBlank() || timeInterval.isEmpty()){
            throw new IllegalArgumentException("Time Interval can't be in blank");
        }
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
        if (!secondDate.moreRecent(firstDate)) {
            throw new IllegalArgumentException("First date is more recent than the second one");
        }
        return true;
    }

    /**
     * Method to verify/validate the File Name
     *
     * @param fileName String contains the name of the file
     */

    public boolean verifyFileName(String fileName) {
        if (fileName.trim().isEmpty() || fileName.isBlank() || fileName.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return true;
    }

}
