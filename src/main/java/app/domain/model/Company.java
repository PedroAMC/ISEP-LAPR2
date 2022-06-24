package app.domain.model;

import app.domain.model.dto.centers.VaccinationCenterDto;
import app.domain.store.VaccineStore;
import app.domain.store.center.StatisticsStore;
import app.domain.store.center.VaccinationCenterStore;
import app.domain.store.employees.EmployeeStore;
import app.domain.store.schedule.ScheduleStore;
import app.domain.store.vaccine.VaccineAdministrationStore;
import app.domain.store.vaccine.VaccineTypeStore;
import app.domain.store.snsuser.SnsUserStore;
import app.domain.utils.CsvExport;
import app.domain.utils.DailyReportGenerator;
import app.domain.utils.ExportCsvTask;
import pt.isep.lei.esoft.auth.AuthFacade;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Timer;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company implements Serializable {

    private String designation;
    private AuthFacade authFacade;
    private SnsUserStore snsUserStore;
    private EmployeeStore employeeStore;
    private final VaccineTypeStore vaccineTypeStore;
    private VaccinationCenterStore vaccinationCenterStore;
    private ScheduleStore scheduleStore;
    private VaccineAdministrationStore vaccineAdministrationStore;
    private final VaccineStore vaccineStore;
    private final StatisticsStore statisticsStore;



    public Company(String designation)
    {

        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");

        this.designation = designation;
        this.authFacade = new AuthFacade();
        this.snsUserStore = new SnsUserStore();
        this.employeeStore = new EmployeeStore();
        this.vaccineTypeStore = new VaccineTypeStore();
        this.vaccinationCenterStore =new VaccinationCenterStore();
        this.scheduleStore = new ScheduleStore();
        this.vaccineAdministrationStore = new VaccineAdministrationStore();
        this.vaccineStore = new VaccineStore();
        this.statisticsStore=new StatisticsStore();
    }

    public String getDesignation() {
        return designation;
    }

    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    public SnsUserStore getSnsUserStore() {
        return snsUserStore;
    }

    public EmployeeStore getEmployeeStore() {
        return employeeStore;
    }

    public VaccineTypeStore getVaccineTypeStore() {
        return vaccineTypeStore;
    }

    public VaccinationCenterStore getVaccinationCenterStore() {
        return vaccinationCenterStore;
    }

    public ScheduleStore getScheduleStore() { return scheduleStore; }

    public VaccineStore getVaccineStore() { return vaccineStore; }

    public VaccineAdministrationStore getVaccineAdministrationStore() { return vaccineAdministrationStore; }

    public StatisticsStore getStatisticsStore(){ return statisticsStore; }

    public void scheduleDailyVaccinatedReport(Date firstTime,long waitTillNext){

        ExportCsvTask task = new ExportCsvTask();
        Timer timer = new Timer();

        timer.schedule(task,firstTime,waitTillNext);


    }

    public void setTask() {

        List <VaccinationCenterDto> centersListDto = this.vaccinationCenterStore.getListOfCenters();

        CsvExport <VaccinationCenterDto> dailyReportGenerator = new DailyReportGenerator();

        dailyReportGenerator.exportData(centersListDto);

    }

    /**
     * Serialization Methods to import
     */


    public boolean saveVaccineAdministrationList(String file){return VaccineAdministrationStore.saveVaccineAdministrationList(vaccineAdministrationStore,file);}
    public void importVaccineAdministrationList(String file){ vaccineAdministrationStore = VaccineAdministrationStore.importVaccineAdministrationList(file);}

    public boolean saveVaccinationCenterList(String file){return VaccinationCenterStore.saveVaccinationCenterList(vaccinationCenterStore,file);}
    public void importVaccinationCenterList(String file){ vaccinationCenterStore = VaccinationCenterStore.importVaccineAdministrationList(file);}

    public boolean saveEmployeeList(String file){return EmployeeStore.saveEmployeeList(employeeStore,file);}
    public void importEmployeeList(String file){ employeeStore = EmployeeStore.importEmployeeList(file);}

    public boolean saveSnsUserList(String file){return SnsUserStore.saveSnsUserList(snsUserStore,file);}
    public void importSnsUserList(String file){ snsUserStore = SnsUserStore.importSnsUserList(file);}

    public boolean saveScheduleList(String file){return ScheduleStore.saveScheduleList(scheduleStore,file);}
    public void importScheduleList(String file){ scheduleStore = ScheduleStore.importScheduleList(file);}




}
