package app.domain.model.mapper.Utils;

import app.domain.model.dto.utils.HourDto;
import app.domain.utils.Hour;
/**
 * Class that deals with the dto objects that carry the information
 * of the Hour
 *
 * @author Miguel Ferreira <1211488@isep.ipp.pt>
 */

public class HourMapper {

    /**
     * Method to transform an Hour into an HourDto carrying the information of the Hour
     *
     * @param hour Object that carries all the information of the Hour
     *
     * @return HourDto
     */

    public static HourDto toHourDto(Hour hour){
        return new HourDto(hour.getHoras(), hour.getMinutos(), hour.getSegundos());
    }

    /**
     * Method to transform an HourDto in to an Hour
     * @param hourDto HourDto
     * @return Hour
     */

    public static Hour toHour(HourDto hourDto){
        return new Hour(hourDto.getHoras(), hourDto.getMinutos(), hourDto.getSegundos());
    }
}
