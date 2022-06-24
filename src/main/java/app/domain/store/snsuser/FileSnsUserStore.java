package app.domain.store.snsuser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class to store, split and count Users from a CSV file
 *
 * @author Lucas Gonçalves <1211601@isep.ipp.pt>
 */



public class FileSnsUserStore {
    Scanner reader;
    private int qtLines;


    /**
     * Method to count the number of Sns Users in a file
     *
     * @param fileUsers File that contains the parameters of multiple Sns Users
     *
     * @return void
     */
    public void countUsers(File fileUsers){
        try {
            reader = new Scanner(fileUsers);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int qtLines = 0;
        String lastReadLine = "";
        while (reader.hasNextLine()) {
            qtLines++;
            lastReadLine = reader.nextLine();
        }
        if (lastReadLine.contains(";")) {
            qtLines--;

        }

        this.qtLines = qtLines;

    }


    /**
     * Method to separate the parameters of a Sns User in a file
     *
     * @param fileUsers File that contains the parameters of multiple Sns Users
     *
     * @return An array of the Sns users in the file
     */
    public String[][] separateUsers(File fileUsers) {
        countUsers(fileUsers);

        String[][] arrayUsers = new String[qtLines][8];

        try {
            reader = new Scanner(fileUsers);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = reader.nextLine();

        if (line.contains(";")) {

            for (int linenmr = 0; linenmr < qtLines; linenmr++) {

                line = reader.nextLine();
                arrayUsers[linenmr] = line.split(";");

            }

        } else if (line.contains(",")) {
            for (int linenmr = 0; linenmr < qtLines; linenmr++) {

                arrayUsers[linenmr] = line.split(",");

                if (reader.hasNextLine()){
                    line = reader.nextLine();

                }
            }

        } else
            System.out.println("The information should be delimited by \",\" or \";\", but not both.");

        return arrayUsers;
    }

}
