package app.domain.utils;

import app.domain.model.dto.centers.VaccinationCenterDto;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;



public class DailyReportGenerator implements CsvExport <VaccinationCenterDto> {

    private static final String DELIMITER = ";";
    private static final String HEADER = "Date;Name;Total Number of Vaccinated\n";

    @Override
    public void exportData(List<VaccinationCenterDto> centersListDto) {

        try{

            FileWriter file = new FileWriter("out/DailyReport(" + LocalDateTime.now().getDayOfMonth() + "-" + LocalDateTime.now().getMonth() + "-" + LocalDateTime.now().getYear() + ").csv" ) ;

            file.append(HEADER);

            for (VaccinationCenterDto vaccinationCenterDto : centersListDto){

                Date date = Date.getCurrentDate();

                file.append(String.valueOf(date.getDay())).append("/").append(String.valueOf(date.getMonth())).append("/").append(String.valueOf(date.getYear())).append(DELIMITER);

                String vaccinationCenterName = vaccinationCenterDto.getName();

                file.append(vaccinationCenterName).append(DELIMITER);

                int totalVaccinated = 0;

                try {
                    totalVaccinated = vaccinationCenterDto.getDailyVaccinated().get(date);
                }catch (NullPointerException e){
                    e.printStackTrace();
                }
                
                file.append(String.valueOf(totalVaccinated));

                file.append("\n");
            }

            file.close();

        }catch (IOException e){
            e.printStackTrace();
        }


    }


}
