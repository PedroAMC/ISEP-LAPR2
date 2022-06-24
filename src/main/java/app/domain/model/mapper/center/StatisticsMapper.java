package app.domain.model.mapper.center;

import app.domain.model.data.snsuser.SnsUser;
import app.domain.model.dto.centers.StatisticsDto;
import app.domain.model.dto.utils.DateDto;
import app.domain.model.dto.utils.IntegerDto;
import app.domain.model.mapper.Utils.DateMapper;
import app.domain.model.mapper.Utils.IntegerMapper;
import app.domain.utils.Date;
import app.domain.utils.Pair;

import java.util.ArrayList;
import java.util.List;

public class StatisticsMapper {
    public static StatisticsDto statisticsToDto(List<Pair<Date,Integer>> list){
        List<Pair<DateDto,IntegerDto>> list2=new ArrayList<>();
        for(Pair<Date,Integer> pair : list){
            DateDto datedto= DateMapper.toDateDto(pair.getFirst());
            IntegerDto integerDto= IntegerMapper.toIntegerDto(pair.getSecond());
            list2.add(new Pair<>(datedto,integerDto));
        }
        return new StatisticsDto(list2);
    }
}
