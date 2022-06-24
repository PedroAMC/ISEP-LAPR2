package app.domain.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class to save the notifications sent by the system
 *
 * @author Diogo Teixeira <1200904@isep.ipp.pt>
 */

public class NotificationSender {


    /**
     * Method to save a certain notification
     * @param notification notification
     */
    public static void sendNotification(Notification notification) throws IOException {

        String path = "out/Notifications.txt";
        File passwords = new File(path);
        BufferedWriter out;

        if(passwords.exists()){
            FileWriter fstream = new FileWriter(path, true); //true tells to append data.
            out = new BufferedWriter(fstream);
            out.write("\nSended to: " + notification.getAddress() + "\nMessage: " + notification.getMessage());
            out.close();
        }else{

            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write("SnsUsers Notifications:\n\nSended to: " + notification.getAddress() + "\nMessage: " + notification.getMessage());
            fileWriter.close();

        }



    }
}
