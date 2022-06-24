package app.domain.model.mapper.center;

import app.domain.model.data.centers.CommunityMassVaccinationCenter;
import app.domain.model.data.centers.HealthCareCenter;
import app.domain.model.data.centers.VaccinationCenter;
import app.domain.model.data.employees.Coordinator;
import app.domain.model.data.snsuser.SnsUser;
import app.domain.model.data.vaccine.VaccineType;
import app.domain.model.dto.centers.CommunityMassVaccinationCenterDto;
import app.domain.model.dto.centers.HealthCareCenterDto;
import app.domain.model.dto.centers.VaccinationCenterDto;
import app.domain.model.dto.snsuser.SnsUserDto;
import app.domain.model.dto.utils.HourDto;
import app.domain.model.mapper.Utils.HourMapper;
import app.domain.model.mapper.snsuser.SnsUserMapper;
import app.domain.utils.Hour;
import app.domain.utils.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VaccinationCenterMapperTest {

    @Test
    public void testCommunityDto(){
        List<VaccineType> avaiableTypes = new ArrayList<>(){{
            add(new VaccineType("AF23P","Covid-19 vaccine",3));

        }};

        Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");
        CommunityMassVaccinationCenterDto dto = new CommunityMassVaccinationCenterDto("HealthCare Boavista","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes);
        dto.setCenterCoordinator(coordinator);

        CommunityMassVaccinationCenter center = new CommunityMassVaccinationCenter("HealthCare Boavista","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes);

        assertEquals(center,VaccinationCenterMapper.toVaccinationCenter(dto));
    }

    @Test

    public void testHealthcare(){
        List<VaccineType> avaiableTypes = new ArrayList<>(){{
            add(new VaccineType("AF23P","Covid-19 vaccine",3));

        }};

        Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");
        HealthCareCenter center = new HealthCareCenter("HealthCare Boavista","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes,1);
        HealthCareCenterDto dto = new HealthCareCenterDto("HealthCare Boavista","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes,1);
        dto.setCenterCoordinator(coordinator);

        assertEquals(center,VaccinationCenterMapper.toVaccinationCenter(dto));
    }

    @Test

    public void testThrow(){
        Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");
        VaccinationCenterDto dto = new VaccinationCenterDto("Maia Center","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",new Hour(9,0,0),new Hour(18,0,0),30,5);
        VaccinationCenter center = new VaccinationCenter("HealthCare Boavista","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5);
        assertThrows(IllegalArgumentException.class,() -> {
            VaccinationCenterMapper.toVaccinationCenter(dto);
            VaccinationCenterMapper.centerToDto(center);
        });
        assertThrows(IllegalArgumentException.class,() -> {
            VaccinationCenterMapper.centerToDto(center);
        });
    }

    @Test

    public void testlistToDto(){
        List<VaccineType> avaiableTypes = new ArrayList<>(){{
            add(new VaccineType("AF23P","Covid-19 vaccine",3));

        }};
        Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");
        HealthCareCenter center = new HealthCareCenter("HealthCare Boavista","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes,1);
        CommunityMassVaccinationCenter center1 = new CommunityMassVaccinationCenter("HealthCare Lisboa","Margem Sul 23","123456789","lisboa@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes);
        HealthCareCenterDto dto = new HealthCareCenterDto("HealthCare Boavista","Margem Sul 23","123456789","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes,1);
        dto.setCenterCoordinator(coordinator);
        CommunityMassVaccinationCenterDto dto1 = new CommunityMassVaccinationCenterDto("HealthCare Lisboa","Margem Sul 23","123456789","lisboa@gmail.com","900-300-5555","vamargemsul.com.pt",new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes);
        dto1.setCenterCoordinator(coordinator);

        List<VaccinationCenter> original = new ArrayList<>(){{
           add(center);
           add(center1);

        }};

        List<VaccinationCenterDto> expected = new ArrayList<>(){{
           add(dto);
           add(dto1);

        }};


        assertEquals(expected.get(0).getName(),VaccinationCenterMapper.listToDto(original).get(0).getName());
        assertEquals(expected.get(1).getName(),VaccinationCenterMapper.listToDto(original).get(1).getName());
    }

    @Test
    public void usersArrivaltoDto(){
        List<Pair<SnsUserDto, HourDto>> snsUsersArrived = new ArrayList<>();
        List<Pair<SnsUser, Hour>> list1=new ArrayList<>(2);
        SnsUserDto snsuser1dto=new SnsUserDto("Manel","Rua Jose","Masculino","912767999","manel@gmail.com","14/02/2000","234567889","23345677",1);
        HourDto hour1dto=new HourDto(8,40,20);
        SnsUserDto snsuser2dto=new SnsUserDto("Jose","Rua Mario","Masculino","914767999","jose@gmail.com","05/06/2000","234567689","23645677",1);
        HourDto hour2dto=new HourDto(8,20,10);
        SnsUser snsuser1=new SnsUser("Manel","Rua Jose","Masculino","912767999","manel@gmail.com","14/02/2000","234567889","23345677",1);
        Hour hour1=new Hour(8,40,20);
        SnsUser snsuser2=new SnsUser("Jose","Rua Mario","Masculino","914767999","jose@gmail.com","05/06/2000","234567689","23645677",1);
        Hour hour2=new Hour(8,20,10);
        Pair<SnsUser,Hour> pair1=new Pair<>(snsuser1,hour1);
        pair1.setFirst(snsuser1);
        pair1.setSecond(hour1);
        Pair<SnsUser,Hour> pair2=new Pair<>(snsuser2,hour2);
        pair2.setFirst(snsuser2);
        pair2.setSecond(hour2);
        list1.add(pair1);
        list1.add(pair2);
        Pair<SnsUserDto,HourDto> pair=new Pair<>(snsuser1dto,hour1dto);
        pair.setFirst(snsuser1dto);
        pair.setSecond(hour1dto);
        Pair<SnsUserDto,HourDto> pair0=new Pair<>(snsuser2dto,hour2dto);
        pair0.setFirst(snsuser2dto);
        pair0.setSecond(hour2dto);
        snsUsersArrived.add(pair);
        snsUsersArrived.add(pair0);
        Assertions.assertEquals(snsUsersArrived,VaccinationCenterMapper.usersArrivaltoDto(list1));

    }

}