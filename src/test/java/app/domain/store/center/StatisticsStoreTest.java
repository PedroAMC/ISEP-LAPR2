package app.domain.store.center;


import app.domain.utils.Date;
import app.domain.utils.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class StatisticsStoreTest {
    StatisticsStore store=new StatisticsStore();
    @Test
    public void testDateIsWithinTimeInterval(){
        Date date=new Date(4,5,2022);
        Assertions.assertTrue(store.dateIsWithinTimeInterval(date, "3,4,2022-10,5,2022"));
    }

    @Test
    public void testDateIsWithinTimeInterval2(){
        Date date=new Date(1,4,2022);
        Assertions.assertFalse(store.dateIsWithinTimeInterval(date, "3,4,2022-10,5,2022"));
    }

    @Test
    public void testCounterPairDate(){
        Date date =new Date(4,2,2022);
        List<Date> list=new ArrayList<>();
        list.add(new Date(4,2,2022));
        list.add(new Date(3,2,2022));
        list.add(new Date(4,2,2022));
        list.add(new Date(1,2,2022));
        Assertions.assertEquals(2,store.counterPairDate(list,date));
    }
    @Test
    public void testIsEqual(){
        List<Pair<Date,Integer>> list=new ArrayList<>();
        Date date=new Date(1,4,2022);
        list.add(new Pair<>(new Date(1,4,2019),5));
        list.add(new Pair<>(new Date(1,4,2021),3));
        list.add(new Pair<>(new Date(1,4,2020),2));
        list.add(new Pair<>(new Date(1,4,2022),7));
        Assertions.assertTrue(store.isEqual(date,list));
    }
}
