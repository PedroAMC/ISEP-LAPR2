package app.domain.model.mapper.Utils;

import app.domain.model.dto.utils.IntegerDto;

public class IntegerMapper {
    public static IntegerDto toIntegerDto(Integer integer){
        return new IntegerDto(integer);
    }
}
