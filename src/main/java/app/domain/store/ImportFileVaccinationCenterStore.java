package app.domain.store;

import java.io.File;
import java.util.Scanner;

public class ImportFileVaccinationCenterStore {
    Scanner fileReader;
    int totalAmountLines;
    String filePath;

    public void setFilePath(String filePath){

        this.filePath = filePath;
    }

    public void createFileReader(){

        fileReader = new Scanner(filePath);
        this.fileReader = fileReader;

    }

    public boolean verifyFile(File file){
        if (!file.isFile()){
            System.out.println("Wrong file path. Please type a valid path\n");
            return false;
        }
        if (file.length() == 0){

            System.out.println("Invalid file. File must not be blank. Please type a valid file\n");
            return false;
        }
        return true;
    }

    public int numberOfLines(){

        createFileReader();
        int counter = 0;

        while (fileReader.hasNextLine()){
            fileReader.nextLine();
            counter++;
        }

        this.totalAmountLines = counter;
        return counter;
    }

    public String[][] separateInformation(){

        createFileReader();
        String[][] listUsers = new String[totalAmountLines][8];

        for (int lineNumber = 0; lineNumber < totalAmountLines; lineNumber++){
            String line = fileReader.nextLine();
            listUsers[lineNumber] = line.split(";");
        }
        return listUsers;
    }


}
