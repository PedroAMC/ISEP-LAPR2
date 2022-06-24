package app.controller.coordinator;

import app.controller.App;
import app.domain.model.data.centers.VaccinationCenter;
import app.domain.model.data.employees.Coordinator;
import app.domain.model.data.vaccine.VaccineAdministration;
import app.domain.model.dto.centers.VaccinationCenterDto;
import app.domain.model.dto.vaccine.VaccineAdministrationDto;
import app.domain.model.mapper.center.VaccinationCenterMapper;
import app.domain.model.mapper.vaccine.VaccineTypeMapper;
import app.domain.store.vaccine.VaccineAdministrationStore;
import app.domain.utils.*;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class AnalyzeCenterPerformanceControllerTest {

    private static boolean setUpIsDone = false;

    public int [] twentyFour;
    public int [] thirtySix ;
    public int [] seventyTwo ;
    public int [] hundrendFortyFour;
    public int [] sevenhundredTwentyTwo;

    AnalyzeCenterPerformanceController analyzeCenterPerformanceController = new AnalyzeCenterPerformanceController();
    Coordinator coordinator = new Coordinator("coordinator@gmail.com","Anthony Liberty","COORDINATOR",960000400,14665868,"Sesame Street", "C.V.Margem Sul");
    VaccinationCenter vaccinationCenter = new VaccinationCenter("HealthCare Lisboa","Margem Sul 23","123456789","lisboa@gmail.com","900-300-5555","vamargemsul.com.pt",coordinator,new Hour(9,0,0),new Hour(18,0,0),30,5);
    VaccineAdministrationStore vaccineAdministrationStore = App.getInstance().getCompany().getVaccineAdministrationStore();

    Date data = new Date(30,5,2021);
    Hour horaSch = new Hour(8, 10);
    Hour horaChegada = new Hour(8,11);
    Hour horaAdm = new Hour(8,12);
    Hour horaSa = new Hour(8,31);


    VaccineAdministrationDto dto1 = new VaccineAdministrationDto("161593120", "Spikevax", "Primeira", "21C16-05", data, horaSch, data, new Hour(8, 29), data, horaAdm, data, new Hour(8, 50),vaccinationCenter);
    VaccineAdministrationDto dto2= new VaccineAdministrationDto("161593121", "Spikevax", "Primeira", "21C16-05", data, horaSch, data, new Hour(8, 15), data, horaAdm, data, new Hour(9, 10),vaccinationCenter);
    VaccineAdministrationDto dto3= new VaccineAdministrationDto("161593121", "Spikevax", "Primeira", "21C16-05", data, horaSch, data, new Hour(8, 31), data, horaAdm, data, new Hour(9, 10),vaccinationCenter);
    VaccineAdministrationDto dto4= new VaccineAdministrationDto("161593121", "Spikevax", "Primeira", "21C16-05", data, horaSch, data, new Hour(8, 42), data, horaAdm, data, new Hour(9, 10),vaccinationCenter);
    VaccineAdministrationDto dto5= new VaccineAdministrationDto("161593121", "Spikevax", "Primeira", "21C16-05", data, horaSch, data, new Hour(10, 10), data, horaAdm, data, new Hour(10, 42),vaccinationCenter);
    VaccineAdministrationDto dto6= new VaccineAdministrationDto("161593121", "Spikevax", "Primeira", "21C16-05", data, horaSch, data, new Hour(10, 15), data, horaAdm, data, new Hour(10, 50),vaccinationCenter);
    VaccineAdministrationDto dto7= new VaccineAdministrationDto("161593121", "Spikevax", "Primeira", "21C16-05", data, horaSch, data, new Hour(10, 17), data, horaAdm, data, new Hour(10, 51),vaccinationCenter);
    VaccineAdministrationDto dto8= new VaccineAdministrationDto("161593121", "Spikevax", "Primeira", "21C16-05", data, horaSch, data, new Hour(10, 28), data, horaAdm, data, new Hour(10, 52),vaccinationCenter);
    VaccineAdministrationDto dto9= new VaccineAdministrationDto("161593121", "Spikevax", "Primeira", "21C16-05", data, horaSch, data, new Hour(10, 12), data, horaAdm, data, new Hour(10, 57),vaccinationCenter);


    VaccineAdministration vac1 = vaccineAdministrationStore.createVaccineAdministration(dto1);
    VaccineAdministration vac2 = vaccineAdministrationStore.createVaccineAdministration(dto2);
    VaccineAdministration vac3 = vaccineAdministrationStore.createVaccineAdministration(dto3);
    VaccineAdministration vac4 = vaccineAdministrationStore.createVaccineAdministration(dto4);
    VaccineAdministration vac5 = vaccineAdministrationStore.createVaccineAdministration(dto5);
    VaccineAdministration vac6 = vaccineAdministrationStore.createVaccineAdministration(dto6);
    VaccineAdministration vac7 = vaccineAdministrationStore.createVaccineAdministration(dto7);
    VaccineAdministration vac8 = vaccineAdministrationStore.createVaccineAdministration(dto8);
    VaccineAdministration vac9 = vaccineAdministrationStore.createVaccineAdministration(dto9);





    @BeforeEach
    public void setUp() {
        if (setUpIsDone) {
            return;
        }

        vaccineAdministrationStore.addVaccineAdministration(vac1);
        vaccineAdministrationStore.addVaccineAdministration(vac2);
        vaccineAdministrationStore.addVaccineAdministration(vac3);
        vaccineAdministrationStore.addVaccineAdministration(vac4);
        vaccineAdministrationStore.addVaccineAdministration(vac5);
        vaccineAdministrationStore.addVaccineAdministration(vac6);
        vaccineAdministrationStore.addVaccineAdministration(vac7);
        vaccineAdministrationStore.addVaccineAdministration(vac8);
        vaccineAdministrationStore.addVaccineAdministration(vac9);

        setUpIsDone = true;
    }



    @BeforeEach
    public void generateInputs (){

        Random random = new Random();
        twentyFour = random.ints(24,0,500).toArray();
        thirtySix = random.ints(36,0,500).toArray();
        seventyTwo = random.ints(72,0,500).toArray();
        hundrendFortyFour = random.ints(144,0,500).toArray();
        sevenhundredTwentyTwo = random.ints(720,0,500).toArray();


    }


    @Test
    @DisplayName("Test for createInputList method")
    public void createInputListTest(){


        List<TimeSlot> inputList = analyzeCenterPerformanceController.createInputList(30, data,vaccinationCenter);



        /*
        for (int i = 0; i < inputList.size(); i++) {
            int counter = inputList.get(i).getCounter();
            Hour hour = inputList.get(i).getTime();
            System.out.println(hour + ": " + counter);
        }
        */

        Assertions.assertEquals(inputList.get(0).getCounter(), 2);
        Assertions.assertEquals(inputList.get(1).getCounter(), 1);
        Assertions.assertEquals(inputList.get(2).getCounter(), -3);
        Assertions.assertEquals(inputList.get(3).getCounter(), 0);


    }

    @Test
    @DisplayName("Test for getIntervalSum")
    public void getIntervalSumTest(){

        List<TimeSlot> inputList = analyzeCenterPerformanceController.createInputList(30, data,vaccinationCenter);
        TimeInterval interval = analyzeCenterPerformanceController.getIntervalSum(inputList, 0, 2);

        int sum = interval.getSum();

        Assertions.assertEquals(sum, 3);

    }

    @Test
    @DisplayName("Test for getVaccinationCenter when the vaccinationCenter doesn't exist")
    public void getVaccinationCenterFalse(){

        VaccinationCenter vaccinationCenterExpected = analyzeCenterPerformanceController.getVaccinationCenter("HealthCare Aveiro");

        assertNull(vaccinationCenterExpected);

    }

    @Test
    @DisplayName("Test for getVaccinationCenter when the vaccinationCenter exists")
    public void getVaccinationCenterTrue(){

        VaccinationCenter vaccinationCenterExpected = analyzeCenterPerformanceController.getVaccinationCenter("HealthCare Lisboa");

        assertEquals(vaccinationCenterExpected.getEmail(), vaccinationCenter.getEmail());
        assertEquals(vaccinationCenterExpected.getPhoneNumber(), vaccinationCenter.getPhoneNumber());
        assertEquals(vaccinationCenterExpected.getUsersArrived(), vaccinationCenter.getUsersArrived());
        assertEquals(vaccinationCenterExpected.getWebsiteAddress(), vaccinationCenter.getWebsiteAddress());
        assertEquals(vaccinationCenterExpected.getName(), vaccinationCenter.getName());
        assertEquals(vaccinationCenterExpected.getAddress(), vaccinationCenter.getAddress());

    }


    @Test
    @DisplayName("Test for determineLeastEffectiveTimeInterval using brute-force method")
    public void determineLeastEffectiveTimeIntervalTest(){



        List<TimeSlot> inputList = analyzeCenterPerformanceController.createInputList(30, data,vaccinationCenter);
        TimeInterval timeInterval = analyzeCenterPerformanceController.determineLeastEffectiveTimeInterval(inputList);



        /*
        System.out.println(timeInterval.getSum());

        List<TimeSlot> leastEffectiveSlots = timeInterval.getSlots();

        for (int i = 0; i < leastEffectiveSlots.size(); i++) {
            int counter = leastEffectiveSlots.get(i).getCounter();
            Hour hour = leastEffectiveSlots.get(i).getTime();
            System.out.println(hour + ": " + counter);
        }

        System.out.println("The vaccination center was less effective in responding from " + leastEffectiveSlots.get(0).getTime() + " to " + leastEffectiveSlots.get(leastEffectiveSlots.size()-1).getTime());

        */

        Assertions.assertEquals(timeInterval.getSum(), 5);

    }

    /*
    @Test

    public void test (){

        try{
            ReadCsvPerformance.readCsv("performanceDataFromGaoFuNationalCenterDoPortoVaccinationCenter.csv");

        }catch (Exception e){
            e.printStackTrace();
        }



        AnalyzeCenterPerformanceController analyzeCenterPerformanceController = new AnalyzeCenterPerformanceController();
        Date data = new Date(30,5,2022);

        VaccinationCenterDto centerDto = App.getInstance().getCompany().getVaccinationCenterStore().getCenter("HealthCare Boavista");
        VaccinationCenter center = VaccinationCenterMapper.toVaccinationCenter(centerDto);

        List<VaccineAdministration> list = vaccineAdministrationStore.getVaccineAdministrationsByDateAndCenter(data, vaccinationCenter);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf(list.get(i).toString());
            
        }
        List<TimeSlot> inputList = analyzeCenterPerformanceController.createInputList(20, data,center);
        TimeInterval timeInterval = analyzeCenterPerformanceController.determineLeastEffectiveTimeInterval(inputList);
        List<TimeSlot> leastEffectiveSlots = timeInterval.getSlots();


        for (int i = 0; i < leastEffectiveSlots.size(); i++) {
            int counter = leastEffectiveSlots.get(i).getCounter();
            Hour hour = leastEffectiveSlots.get(i).getTime();
            System.out.println(hour + ": " + counter);
        }

    }

*/

    @Test

    public void testBruteForce(){

        determineLeastEffectiveTimeInterval(sevenhundredTwentyTwo);

    }

    @Test

    public void testBenchmark(){

        determineLeastEffectiveTimeInterval(sevenhundredTwentyTwo);

    }

    @Test

    public void createInputListForBenchmark(){

        analyzeCenterPerformanceController.createInputListForBenchmark(30, data,vaccinationCenter);

    }

    @Test

    public void sumTest(){

        analyzeCenterPerformanceController.sum(sevenhundredTwentyTwo);

    }

    public Integer determineLeastEffectiveTimeInterval(int[] centerPerformance){
        int max = Integer.MIN_VALUE;
        int s = 0;
        int f = 0;

        for (int firstIndex = 0 ; firstIndex < centerPerformance.length ; firstIndex++) {
            int sum = 0;
            for (int secondIndex = 0 ; secondIndex < centerPerformance.length ; secondIndex++) {

                sum += centerPerformance[secondIndex];

                if(sum > max){

                    s = firstIndex;
                    f = secondIndex;

                    max = sum;

                }
            }
        }


        return max;
    }

    public  int[] max(int[] seq) {
        int maxSoFar = 0;
        int maxEndingHere = 0;
        int startMaxSoFar = 0;
        int endMaxSoFar = 0;
        int startMaxEndingHere = 0;

        for(int i = 0; i < seq.length; ++i) {
            int elem = seq[i];
            int endMaxEndingHere = i + 1;
            if (maxEndingHere + elem < 0) {
                maxEndingHere = 0;
                startMaxEndingHere = i + 1;
            } else {
                maxEndingHere += elem;
            }

            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                startMaxSoFar = startMaxEndingHere;
                endMaxSoFar = endMaxEndingHere;
            }
        }

        return Arrays.copyOfRange(seq, startMaxSoFar, endMaxSoFar);
    }

    @Test
    @DisplayName("Test for verifyInputDateTest when there are no valid administrations for the date and center")
    public void verifyInputDateTestFalse(){


        boolean isValid;

        try {
            isValid = analyzeCenterPerformanceController.verifyInputDate(new Date(10,10,10), vaccinationCenter);
        } catch (IllegalArgumentException e){

            isValid = false;

        }
        Assertions.assertFalse(isValid);

    }

    @Test
    @DisplayName("Test for verifyInputDateTest when there are valid administrations for the date and center")
    public void verifyInputDateTestTrue(){

        boolean isValid;

        try {
            isValid = analyzeCenterPerformanceController.verifyInputDate(data, vaccinationCenter);
        } catch (IllegalArgumentException e){

            isValid = false;

        }
        Assertions.assertTrue(isValid);

    }


}
