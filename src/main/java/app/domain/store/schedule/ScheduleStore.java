
package app.domain.store.schedule;

import app.domain.model.data.centers.VaccinationCenter;
import app.domain.model.data.schedule.Schedule;
import app.domain.model.data.snsuser.SnsUser;
import app.domain.model.data.vaccine.VaccineType;
import app.domain.model.dto.schedule.ScheduleDto;
import app.domain.model.dto.snsuser.SnsUserDto;
import app.domain.model.dto.vaccine.VaccineTypeDto;
import app.domain.model.mapper.schedule.ScheduleMapper;
import app.domain.model.mapper.vaccine.VaccineTypeMapper;
import app.domain.store.snsuser.SnsUserStore;
import app.domain.utils.Date;
import app.domain.utils.Notification;
import app.domain.utils.NotificationSender;

import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

public class ScheduleStore {

    private final HashMap<String,HashMap<Schedule, VaccineType>> schedules;

    public ScheduleStore() {
        this.schedules = new HashMap<>();
    }

    /**
     *Method to verify if the user has a vaccine scheduled for a certain date and vaccination center
     * @param snsNumber snsNumber of the user
     * @param date date that the user arrives
     * @param center vaccination center that the user arrived to
     * @return boolean representing if the user has a vaccine scheduled for this day and center
     */
    public boolean verifySchedule (String snsNumber, Date date, VaccinationCenter center){


        if (schedules.containsKey(snsNumber)){
            for (Schedule s : schedules.get(snsNumber).keySet()){

                if(center.equals(s.getVaccinationCenter())){
                    return true;
                }
            }
        }

        return false;
    }
//    public boolean verifySchedule (String snsNumber, Date date, VaccinationCenter center){
//
//
//        for (Schedule s : schedules.get(snsNumber).keySet()){
//
//            if(date == s.getDate() && center == s.getVaccinationCenter()){
//                return true;
//            }
//
//        }
//        return false;
//    }

    /**
     * Method to get the schedules
     * @return hash map with the schedules
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public HashMap<String, HashMap<Schedule, VaccineType>> getSchedules() {
        return schedules;
    }

    /**
     * Method to return
     * @param snsUserDto dto object with sns user data
     * @return Schedule
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public Schedule getSchedule(SnsUserDto snsUserDto){
        String snsNumber = snsUserDto.getSnsNumber();
        Set<Schedule> set = schedules.get(snsNumber).keySet();
        int smallestDiference = 10000;
        Schedule desired = null;

        for (Schedule s : set) {
            LocalDate date = LocalDate.now();

            //if years are equal
            if (date.getYear() == s.getDate().getYear()) {
                if (date.getMonthValue() != s.getDate().getMonth()) {
                    int diference = Math.abs(date.getMonthValue() - s.getDate().getMonth());
                    if (diference < smallestDiference) {
                        smallestDiference = diference;
                        desired = s;
                    }
                }
                if (date.getMonthValue() == s.getDate().getMonth()) {
                    int diference = Math.abs(date.getDayOfMonth() - s.getDate().getDay());
                    if (diference < smallestDiference) {
                        smallestDiference = diference;
                        desired = s;
                    }
                }
            } else {
                int diference = Math.abs(date.getYear() - s.getDate().getYear());

                if (diference < smallestDiference) {
                    smallestDiference = diference;
                    desired = s;
                }
            }
        }

        return desired;
    }


    public VaccineType getVaccineType(SnsUserDto snsUserDto) {
        Schedule schedule = getSchedule(snsUserDto);
        return schedules.get(snsUserDto.getSnsNumber()).get(schedule);
    }


    /**
     * Method to create a new schedule
     * @param scheduleDto dto with the information
     * @return schedule
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public Schedule createNewSchedule(ScheduleDto scheduleDto){

        return ScheduleMapper.toSchedule(scheduleDto);
    }

    /**
     * Method to save schedule
     * @param snsUser user information
     * @param schedule schedule information
     * @param vaccineTypeDto vaccine type dto object
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public void saveSchedule(SnsUser snsUser, Schedule schedule, VaccineTypeDto vaccineTypeDto){

        VaccineType vaccineType = VaccineTypeMapper.toVaccineType(vaccineTypeDto);
        saveSchedule(snsUser.getSnsNumber(),schedule,vaccineType);

        if(snsUser.getSmsPermission() == 1){
            Notification notification = new Notification(snsUser.getEmail().getEmail(),"Schedule accepted to" + schedule.getDate());
            try{
                NotificationSender.sendNotification(notification);
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }

    /**
     * Method to save schedule
     * @param snsUserNumber information of the user
     * @param schedule information of the schedule
     * @param vaccineType information of the vaccine type
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    private void saveSchedule(String snsUserNumber,Schedule schedule, VaccineType vaccineType){
        HashMap<Schedule,VaccineType> map = new HashMap<>();

        if(schedules.get(snsUserNumber) != null && !Objects.equals(schedules.get(snsUserNumber), new HashMap<Schedule, VaccineType>())){
            schedules.get(snsUserNumber).put(schedule,vaccineType);
        }else{
            map.put(schedule,vaccineType);
            schedules.put(snsUserNumber,map);
        }
    }


    /**
     * Method to export the ScheduleStore to a file
     * @param scheduleStore
     * @param file
     * @return
     */
    public static boolean saveScheduleList(ScheduleStore scheduleStore, String file) {

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            try {
                out.writeObject(scheduleStore);
            } finally {
                out.close();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Method to import the scheduleStore from a file
     * @param file
     * @return snsUserStore
     */
    public static ScheduleStore importScheduleList(String file){
        ScheduleStore scheduleStore;

        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            try{
                scheduleStore = (ScheduleStore) in.readObject();
            }finally {
                in.close();
            }
            return scheduleStore;
        }catch (IOException | ClassNotFoundException e){
            return new ScheduleStore();
        }
    }

}

