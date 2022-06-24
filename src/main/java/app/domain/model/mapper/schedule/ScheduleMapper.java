package app.domain.model.mapper.schedule;

import app.domain.model.data.centers.VaccinationCenter;
import app.domain.model.data.schedule.Schedule;
import app.domain.model.dto.schedule.ScheduleDto;
import app.domain.model.mapper.Utils.DateMapper;
import app.domain.model.mapper.Utils.HourMapper;
import app.domain.model.mapper.center.VaccinationCenterMapper;
import app.domain.utils.Date;
import app.domain.utils.Hour;

public class ScheduleMapper {

    /**
     * Method to create a schedule mapper
     * @param scheduleDto dto with all the information of a schedule
     * @return schedule with all the the information necessary
     *
     * @author Nuno Cunha <Nuno Cunha 1211689@isep.ipp.pt>
     */
    public static Schedule toSchedule(ScheduleDto scheduleDto){

        Date date = DateMapper.toDate(scheduleDto.getDate());
        Hour hour = HourMapper.toHour(scheduleDto.getHour());
        VaccinationCenter center = VaccinationCenterMapper.toVaccinationCenter(scheduleDto.getVaccinationCenter());

        return new Schedule(date,hour,center);

    }
}
