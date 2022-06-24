package app.controller.center;

import app.controller.App;
import app.controller.snsuser.RegisterSnsUserController;
import app.domain.model.data.centers.HealthCareCenter;
import app.domain.model.data.centers.VaccinationCenter;
import app.domain.model.data.employees.Coordinator;
import app.domain.model.data.snsuser.SnsUser;
import app.domain.model.data.vaccine.VaccineType;
import app.domain.model.dto.snsuser.SnsUserDto;
import app.domain.model.dto.utils.HourDto;
import app.domain.model.mapper.center.VaccinationCenterMapper;
import app.domain.store.center.VaccinationCenterStore;
import app.domain.utils.Hour;
import app.domain.utils.Pair;
import app.ui.console.receptionist.RegisterSnsUserArrivalUi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class WaitingRoomControllerTest {

    @Test
    public void testdisplayWaitingRoom(){
        List<Pair<SnsUserDto,HourDto>> list1=new ArrayList<>(2);
        SnsUserDto snsuser1dto=new SnsUserDto("Manel","Rua Jose","Masculino","912767999","manel@gmail.com","14/02/2000","234567889","23345677",1);
        HourDto hour1dto=new HourDto(8,40,20);
        SnsUserDto snsuser2dto=new SnsUserDto("Jose","Rua Mario","Masculino","914767999","jose@gmail.com","05/06/2000","234567689","23645677",1);
        HourDto hour2dto=new HourDto(8,20,10);
        Pair<SnsUserDto,HourDto> pair1=new Pair<>(snsuser1dto,hour1dto);
        pair1.setFirst(snsuser1dto);
        pair1.setSecond(hour1dto);
        Pair<SnsUserDto,HourDto> pair2=new Pair<>(snsuser2dto,hour2dto);
        pair2.setFirst(snsuser2dto);
        pair2.setSecond(hour2dto);
        list1.add(pair1);
        list1.add(pair2);
        WaitingRoomController controller=new WaitingRoomController();
        List<VaccineType> listvac=new ArrayList<>();
        VaccineType vactype=new VaccineType("NOU45","analisa o SARSCOV2",5);
        listvac.add(vactype);
        VaccinationCenter vac1=new HealthCareCenter("Centro de Vacinação de Matosinhos","Rua António Manuel","910666777","jordan@gmail.com","222888999090","www.ola.pt",new Coordinator("jojo@gmail.com","ola","COORDINATOR",910888999,23456788,"Rua Manuel Eva","Centro de Vacinação de Matosinhos"),new Hour(7,30,0),new Hour(19,20,0),8,10,listvac,2);
        SnsUser snsuser1=new SnsUser("Manel","Rua Jose","Masculino","912767999","manel@gmail.com","14/02/2000","234567889","23345677",1);
        Hour hour1=new Hour(8,40,20);
        SnsUser snsuser2=new SnsUser("Jose","Rua Mario","Masculino","914767999","jose@gmail.com","05/06/2000","234567689","23645677",1);
        Hour hour2=new Hour(8,20,10);
        VaccinationCenterStore vaccinationCenterStore = App.getInstance().getCompany().getVaccinationCenterStore();
        vac1.addArrival(snsuser1,hour1);
        vac1.addArrival(snsuser2,hour2);
        /*List<Pair<SnsUserDto,HourDto>> lista1=new ArrayList<>();
        lista1= vac1.getUsersArrived();*/
        vaccinationCenterStore.createCenter(VaccinationCenterMapper.centerToDto(vac1));
        Assertions.assertEquals(list1,controller.displayWaitingRoom(vac1.getName()));
    }
}
