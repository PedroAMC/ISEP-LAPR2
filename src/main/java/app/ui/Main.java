package app.ui;

import app.domain.utils.ReadCsvPerformance;
import app.domain.utils.TimeInterval;
import app.domain.utils.TimeSlot;
import app.ui.console.MainMenuUI;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */

//Teste
public class Main {

    public static void main(String[] args)
    {

        /*
        try{
            ReadCsvPerformance.readCsv("performanceDataFromGaoFuNationalCenterDoPortoVaccinationCenter.csv");

        }catch (Exception e){
            e.printStackTrace();
        }


         */

//        int [] test = {242, 194, 241, 92, 53, 27, 74, -75, -357, -125, -29, 141, 269, 121, 50, 26, -29, -118, -254, 89, 246, -20, -119, -322};
//        System.out.println(determineLeastEffectiveTimeInterval(test));

        try
        {
            MainMenuUI menu = new MainMenuUI();
            menu.run();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }


//    public static Integer determineLeastEffectiveTimeInterval(int[] centerPerformance){
//        int max = Integer.MIN_VALUE;
//        int s = 0;
//        int f = 0;
//
//        for (int firstIndex = 0 ; firstIndex < centerPerformance.length ; firstIndex++) {
//            int sum = 0;
//            for (int secondIndex = 0 ; secondIndex < centerPerformance.length ; secondIndex++) {
//
//                sum += centerPerformance[secondIndex];
//
//                if(sum > max){
//
//                    s = firstIndex;
//                    f = secondIndex;
//
//                    max = sum;
//
//                }
//            }
//        }
//
//        for (int i = s; i < f + 1; i++) {
//            System.out.println(centerPerformance[i]);
//        }
//        return max;
//    }



}
