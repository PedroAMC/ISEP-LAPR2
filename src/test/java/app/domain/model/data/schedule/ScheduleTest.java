package app.domain.model.data.schedule;

import app.domain.model.data.centers.VaccinationCenter;
import app.domain.model.data.employees.Coordinator;
import app.domain.utils.Date;
import app.domain.utils.Hour;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Class of tests to the schedule vaccine class
 *
 * @author Nuno Cunha <1211689@isep.ipp.pt>
 */
public class ScheduleTest {

    @Test
    public void testGetAndSet(){

        Schedule schedule = new Schedule(new Date(12,1,2003) , new Hour(12,30) , new VaccinationCenter("C.V.Margem Sul","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul"),new Hour(9,0,0),new Hour(18,0,0),30,5));

        assertEquals(new Date(12,1,2003), schedule.getDate());
        schedule.setDate(new Date(11,11,2003));
        assertEquals(new Date(11,11,2003), schedule.getDate());

        assertEquals(new Hour(12,30),schedule.getHour());
        schedule.setHour(new Hour(12,45));
        assertEquals(new Hour(12,45),schedule.getHour());

        assertEquals(new VaccinationCenter("C.V.Margem Sul","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul"),new Hour(9,0,0),new Hour(18,0,0),30,5), schedule.getVaccinationCenter());
        schedule.setVaccinationCenter(new VaccinationCenter("C.V.Margem Norte","Margem Norte 23","123456799","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul"),new Hour(9,0,0),new Hour(18,0,0),30,5));
        assertEquals(new VaccinationCenter("C.V.Margem Norte","Margem Norte 23","123456799","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul"),new Hour(9,0,0),new Hour(18,0,0),30,5), schedule.getVaccinationCenter());
    }

    @Test
    public void testEquals(){
        Schedule schedule = new Schedule(new Date(12,1,2003) , new Hour(12,30) , new VaccinationCenter("C.V.Margem Sul","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul"),new Hour(9,0,0),new Hour(18,0,0),30,5));
        Schedule schedule1 = schedule;

        assertEquals(schedule, schedule1);
        assertNotEquals(schedule,null);
        assertNotEquals(schedule, "schedule");

    }

    @Test
    public void testHashCode(){
        Schedule schedule = new Schedule(new Date(12,1,2003) , new Hour(12,30) , new VaccinationCenter("C.V.Margem Sul","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul"),new Hour(9,0,0),new Hour(18,0,0),30,5));

        assertEquals(Objects.hash(schedule.getDate(),schedule.getHour(),schedule.getVaccinationCenter()),schedule.hashCode());
    }

    @Test
    public void testToString(){
        VaccinationCenter center = new VaccinationCenter("C.V.Margem Sul","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul"),new Hour(9,0,0),new Hour(18,0,0),30,5);
        Date date = new Date(12,1,2003);
        Hour hour = new Hour(12,30);
        Schedule schedule = new Schedule(date , hour , center);
        assertEquals("ScheduleVaccine{" +
                "date=" + date +
                ", hour=" + hour +
                ", vaccinationCenter='" + center + '\'' +
                '}', schedule.toString());
    }
}
