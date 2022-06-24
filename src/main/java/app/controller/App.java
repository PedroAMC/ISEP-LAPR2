package app.controller;

import app.domain.model.Company;
import app.domain.model.data.Vaccine;
import app.domain.model.data.centers.*;
import app.domain.model.data.employees.Coordinator;
import app.domain.model.data.snsuser.SnsUser;
import app.domain.model.data.vaccine.VaccineAdministration;
import app.domain.model.data.vaccine.VaccineType;
import app.domain.model.dto.centers.CommunityMassVaccinationCenterDto;
import app.domain.model.dto.centers.HealthCareCenterDto;
import app.domain.model.dto.vaccine.VaccineTypeDto;
import app.domain.shared.Constants;
import app.domain.utils.Hour;
import app.domain.utils.Pair;
import pt.isep.lei.esoft.auth.AuthFacade;
import pt.isep.lei.esoft.auth.UserSession;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.*;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class App {

    private Company company;
    private AuthFacade authFacade;

    private App() {

        Properties props = getProperties();
        this.company = new Company(props.getProperty(Constants.PARAMS_COMPANY_DESIGNATION));
        this.authFacade = this.company.getAuthFacade();
        bootstrap();
        activateSchedule(props);

    }

    private void activateSchedule (Properties props) {

        String definedHour = props.getProperty(Constants.DAILY_REPORT_HOUR);
        String [] hour = definedHour.split(":");
        LocalDateTime date = LocalDateTime.now();
        Date firstTime = new Date(date.getYear()-1900,date.getMonthValue() - 1, date.getDayOfMonth(),Integer.parseInt(hour[0]),Integer.parseInt(hour[1]),0);

        this.company.scheduleDailyVaccinatedReport(firstTime,86400000);

    }

    public Company getCompany()
    {
        return this.company;
    }


    public UserSession getCurrentUserSession()
    {
        return this.authFacade.getCurrentUserSession();
    }

    public boolean doLogin(String email, String pwd)
    {
        return this.authFacade.doLogin(email,pwd).isLoggedIn();
    }

    public void doLogout()
    {
        this.authFacade.doLogout();
    }

    private Properties getProperties()
    {
        Properties props = new Properties();

        // Add default properties and values
        props.setProperty(Constants.PARAMS_COMPANY_DESIGNATION, "DGS/SNS");


        // Read configured values
        try
        {
            InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
            props.load(in);
            in.close();
        }
        catch(IOException ex)
        {

        }
        return props;
    }


    private void bootstrap()
    {
        this.authFacade.addUserRole(Constants.ROLE_ADMIN,Constants.ROLE_ADMIN);
        this.authFacade.addUserRole(Constants.ROLE_SNS_USER,Constants.ROLE_SNS_USER);
        this.authFacade.addUserRole(Constants.ROLE_RECEPTIONIST,Constants.ROLE_RECEPTIONIST);
        this.authFacade.addUserRole(Constants.ROLE_NURSE, Constants.ROLE_NURSE);
        this.authFacade.addUserRole(Constants.ROLE_COORDINATOR, Constants.ROLE_COORDINATOR);
        this.authFacade.addUserWithRole("Main Administrator", "admin@lei.sem2.pt", "123456",Constants.ROLE_ADMIN);
        this.authFacade.addUserWithRole("Receptionist 1", "recep@lei.sem2.pt", "123456",Constants.ROLE_RECEPTIONIST);
        this.authFacade.addUserWithRole("Coordinator", "coordinator@lei.pt", "123456",Constants.ROLE_COORDINATOR);
        this.authFacade.addUserWithRole("Diogo Teixeira","diogo@gmail.com","123",Constants.ROLE_SNS_USER);
        this.authFacade.addUserWithRole("Nurse","nurse@lei.pt","123",Constants.ROLE_NURSE);

        List<VaccineType> avaiableTypes = new ArrayList<>(){{
            add(new VaccineType("AF23P","Covid-19 vaccine",3));

        }};
        List<VaccineType> avaiableTypes2 = new ArrayList<>(){{
            add(new VaccineType("AF23P","Covid-19 vaccine",3));
            add(new VaccineType("AF24T","MonkeyPox vaccine",2));

        }};

        HashMap<app.domain.utils.Date,Integer> vaccinated1 = new HashMap<>(){{
            LocalDateTime dateTime = LocalDateTime.now();
            put(new app.domain.utils.Date(dateTime.getDayOfMonth(),dateTime.getMonthValue() , dateTime.getYear()),143);

        }};

       // HashMap <app.domain.utils.Date,Integer> dailyVaccinated=new HashMap<>();
       // this.company.getVaccineStore().addVaccine(new Vaccine("covid-19","fai",2,10,3,7,8,9));
       // this.company.getVaccineAdministrationStore().addVaccineAdministration(new VaccineAdministration("91188877","covid-19","1","450",new app.domain.utils.Date(5,4,2020),new Hour(8,20,0),new app.domain.utils.Date(5,4,2020),new Hour(8,10,0),new app.domain.utils.Date(5,4,2020),new Hour(8,20,0),new app.domain.utils.Date(5,4,2020),new Hour(8,30,0),new HealthCareCenter("HealthCare Boavista","Margem Sul 23","123456780","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",new Coordinator("jojo@gmail.com","Alberto Jose","COORDINATOR",911666888,22233344,"rua xavier","HealthCare Boavista")new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes2,1,vaccinated1),new Coordinator("jojo@gmail.com","Alberto Jose","COORDINATOR",911666888,22233344,"rua xavier","HealthCare Boavista"),new Hour(8,0,0),new Hour(19,0,0),10,5,dailyVaccinated)));
       // this.company.getVaccineAdministrationStore().addVaccineAdministration(new VaccineAdministration("91188877","covid-19","1","450",new app.domain.utils.Date(5,4,2020),new Hour(9,20,0),new app.domain.utils.Date(5,4,2020),new Hour(9,10,0),new app.domain.utils.Date(5,4,2020),new Hour(9,20,0),new app.domain.utils.Date(5,4,2020),new Hour(9,30,0),new VaccinationCenter("HealthCare Boavista","rua pires","911777888","jose1@gmail.com","222333444000","www.boavistahealthcare.pt",new Coordinator("jojos@gmail.com","Alberto Joses","COORDINATOR",911666887,22233345,"rua xavie","HealthCare Boavista"),new Hour(8,0,0),new Hour(19,0,0),10,5,dailyVaccinated)));



        HashMap<app.domain.utils.Date,Integer> vaccinated2 = new HashMap<>(){{
            LocalDateTime dateTime = LocalDateTime.now();
            put(new app.domain.utils.Date(dateTime.getDayOfMonth(),dateTime.getMonthValue() , dateTime.getYear()),1400);

        }};

        Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");
        HealthCareCenterDto dto = new HealthCareCenterDto("HealthCare Boavista","Margem Sul 23","123456780","vamargemsul@gmail.com","900-300-5555","vamargemsul.com.pt",new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes2,1,vaccinated1);
        dto.setCenterCoordinator(coordinator);
        this.company.getVaccinationCenterStore().createCenter(dto);
        CommunityMassVaccinationCenterDto dto1 = new CommunityMassVaccinationCenterDto("HealthCare Lisboa","Margem Sul 23","123456789","lisboa@gmail.com","900-300-5555","vamargemsul.com.pt",new Hour(9,0,0),new Hour(18,0,0),30,5,avaiableTypes,vaccinated2);
        dto1.setCenterCoordinator(coordinator);
        this.company.getVaccinationCenterStore().createCenter(dto1);

        this.company.getVaccineTypeStore().createVaccineType(new VaccineTypeDto("AF23P","Covid-19 vaccine", 3));
        this.company.getVaccineTypeStore().createVaccineType(new VaccineTypeDto("MT21T","MonkeyPox vaccine", 2));

        this.company.getVaccinationCenterStore();
    }

    // Extracted from https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static App singleton = null;
    public static App getInstance()
    {
        if(singleton == null)
        {
            synchronized(App.class)
            {
                singleton = new App();
            }
        }
        return singleton;
    }
}