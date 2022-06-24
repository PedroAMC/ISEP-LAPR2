package app.domain.utils;

import app.controller.App;
import app.domain.model.data.centers.VaccinationCenter;
import app.domain.model.data.vaccine.VaccineAdministration;
import app.domain.model.dto.centers.VaccinationCenterDto;
import app.domain.model.dto.vaccine.VaccineAdministrationDto;
import app.domain.model.mapper.center.VaccinationCenterMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class ReadCsvPerformance {

    public static CsvFileInfo [] readCsv (String path) throws IOException {

        CsvFileInfo [] info = new CsvFileInfo[7049];

        File csv = new File(path);
        FileReader fileReader = new FileReader(csv);


        try (BufferedReader reader = new BufferedReader(fileReader)) {

            String header = reader.readLine();
            String information ;
            int index = 0;

            while((information = reader.readLine()) != null){

                String [] allInformation = information.split(";");

                CsvFileInfo i = handleInfo(allInformation);

                info[index] = i;

                index ++ ;




            }

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

//        System.out.println(App.getInstance().getCompany().getVaccineAdministrationStore());
        return info;

    }

    private static CsvFileInfo handleInfo (String [] allinformation){

        String snsNumber = allinformation[0];
        String vaccineName = allinformation[1];
        String dose = allinformation[2];
        String lotNumber = allinformation [3];



        Date scheduleDate = getDate(allinformation,4);
        Date arrivalDate = getDate(allinformation,5);
        Date nurseDate = getDate(allinformation,6);
        Date leavingDate = getDate(allinformation,7);

        VaccinationCenterDto centerDto = App.getInstance().getCompany().getVaccinationCenterStore().getCenter("HealthCare Boavista");
        VaccinationCenter vaccinationCenter = VaccinationCenterMapper.toVaccinationCenter(centerDto);
        VaccineAdministrationDto dto = new VaccineAdministrationDto(snsNumber, vaccineName, dose, lotNumber,getDate2(allinformation,4), new Hour(scheduleDate.getHours(),scheduleDate.getMinutes()) , getDate2(allinformation,5), new Hour(arrivalDate.getHours(),arrivalDate.getMinutes()), getDate2(allinformation,6), new Hour(nurseDate.getHours(),nurseDate.getMinutes()),getDate2(allinformation,7), new Hour(leavingDate.getHours(), leavingDate.getMinutes()),vaccinationCenter);
        VaccineAdministration adm = App.getInstance().getCompany().getVaccineAdministrationStore().createVaccineAdministration(dto);
        App.getInstance().getCompany().getVaccineAdministrationStore().addVaccineAdministration(adm);

        return new CsvFileInfo(snsNumber,vaccineName,dose,lotNumber,scheduleDate,arrivalDate,nurseDate,leavingDate);
    }

    private static app.domain.utils.Date getDate2(String [] allinformation, int index) {

        String [] splitDate = allinformation[index].split(" ");
        String [] date = splitDate[0].split("/");
        int month = Integer.parseInt(date[0]);
        int day = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);

        return new app.domain.utils.Date(day,month,year);


    }

    private static Date getDate (String [] allinformation, int index){

        String [] splitDate = allinformation[index].split(" ");
        String [] date = splitDate[0].split("/");
        int month = Integer.parseInt(date[0]);
        int day = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);

        String [] hours = splitDate[1].split(":");
        int hour = Integer.parseInt(hours[0]);
        int minutes = Integer.parseInt(hours[1]);

        return new Date (year - 1900, month - 1, day, hour, minutes,0);
    }



}
