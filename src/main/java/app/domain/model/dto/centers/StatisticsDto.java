package app.domain.model.dto.centers;

import app.domain.model.dto.utils.DateDto;
import app.domain.model.dto.utils.IntegerDto;
import app.domain.utils.Pair;
import app.domain.utils.Date;
import java.util.List;

public class StatisticsDto {
    private final List<Pair<DateDto, IntegerDto>> list;

    public StatisticsDto(List<Pair<DateDto, IntegerDto>> list) {
        this.list = list;
    }

    public List<Pair<DateDto, IntegerDto>> getList() {
        return list;
    }
}
