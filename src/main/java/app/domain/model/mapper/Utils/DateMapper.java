package app.domain.model.mapper.Utils;

import app.domain.model.dto.utils.DateDto;
import app.domain.utils.Date;

public class DateMapper {

    public static Date toDate(DateDto dateDto){

        return new Date(dateDto.getDay(),dateDto.getMonth(),dateDto.getYear());
    }

    public static DateDto toDateDto(Date date){
        return new DateDto(date.getDay(), date.getMonth(), date.getYear());
    }

}
