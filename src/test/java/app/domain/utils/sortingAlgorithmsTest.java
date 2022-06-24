package app.domain.utils;

import app.controller.App;
import app.controller.coordinator.AnalyzeCenterPerformanceController;
import app.domain.model.data.centers.VaccinationCenter;
import app.domain.model.dto.centers.VaccinationCenterDto;
import app.domain.model.mapper.center.VaccinationCenterMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class sortingAlgorithmsTest {

    CsvFileInfo [] info;
    @BeforeEach
    public void generate () throws IOException {
        info = ReadCsvPerformance.readCsv("base_data_22.csv");

    }

    @Test
    public void testBubbleLeaving () throws IOException {

        System.out.println("======== SORTED by CENTER LEAVING TIME ==================");
        CsvFileInfo [] infoSorted = sortingAlgorithms.bubbleSort(info,"centerleaving");
        for (CsvFileInfo csvFileInfo : infoSorted) {
            System.out.println("Sns Number: " + csvFileInfo.snsNumber + " Arrival Time: " + csvFileInfo.arrivalDate + " Leaving Time: " + csvFileInfo.leavingDate);
        }



    }

    @Test
    public void testBubbleArrival () throws IOException {

        System.out.println("======== SORTED by CENTER LEAVING TIME================");

        CsvFileInfo [] infoSorted2 = sortingAlgorithms.bubbleSort(info,"arrivaltime");

        for (CsvFileInfo csvFileInfo : infoSorted2) {
            System.out.println("Sns Number: " + csvFileInfo.snsNumber + " Arrival Time: " + csvFileInfo.arrivalDate + " Leaving Time: " + csvFileInfo.leavingDate);
        }
    }

    @Test
    public void testInsertLeaving () throws IOException {

        System.out.println("======== SORTED by CENTER LEAVING TIME ==================");
        CsvFileInfo [] infoSorted = sortingAlgorithms.bubbleSort(info,"centerleaving");
        for (CsvFileInfo csvFileInfo : infoSorted) {
            System.out.println("Sns Number: " + csvFileInfo.snsNumber + " Arrival Time: " + csvFileInfo.arrivalDate + " Leaving Time: " + csvFileInfo.leavingDate);
        }



    }

    @Test
    public void testInsertArrival () throws IOException {

        System.out.println("======== SORTED by CENTER LEAVING TIME================");

        CsvFileInfo [] infoSorted2 = sortingAlgorithms.bubbleSort(info,"arrivaltime");

        for (CsvFileInfo csvFileInfo : infoSorted2) {
            System.out.println("Sns Number: " + csvFileInfo.snsNumber + " Arrival Time: " + csvFileInfo.arrivalDate + " Leaving Time: " + csvFileInfo.leavingDate);
        }
    }


}