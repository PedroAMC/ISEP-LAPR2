package app.ui.console;

import app.domain.utils.ReadCsvPerformance;

import java.util.Scanner;

public class ImportLegacyDataUi implements Runnable {

    @Override
    public void run(){

        Scanner reader = new Scanner(System.in);
        System.out.printf("Choose import file: ");
        String fileName = reader.next();

        try{
            ReadCsvPerformance.readCsv(fileName);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
