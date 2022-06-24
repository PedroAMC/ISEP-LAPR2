package app.domain.model.dto.schedule;

import app.domain.model.dto.centers.VaccinationCenterDto;
import app.domain.model.dto.utils.DateDto;
import app.domain.model.dto.utils.HourDto;

/**
 * Class to create dto object from the schedule class
 *
 * @author Nuno Cunha <1211689@isep.ipp.pt>
 */

public class ScheduleDto {

    private final DateDto date;
    private final HourDto hour;
    private final VaccinationCenterDto vaccinationCenter;

    /**
     * Constructor of the class
     *
     * @param date dto object with the parameters from the class date
     * @param hour dto object with the parameters from the class hour
     * @param vaccinationCenter dto object with the parameters from the class vaccinationCenter
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public ScheduleDto(DateDto date, HourDto hour, VaccinationCenterDto vaccinationCenter) {
        this.date = date;
        this.hour = hour;
        this.vaccinationCenter = vaccinationCenter;
    }

    /**
     * Method to get date
     * @return date
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public DateDto getDate() {
        return date;
    }

    /**
     * Method to get hour
     * @return hour
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public HourDto getHour() {
        return hour;
    }

    /**
     * Method to get vaccination center
     * @return vaccination center
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public VaccinationCenterDto getVaccinationCenter() {
        return vaccinationCenter;
    }


}
