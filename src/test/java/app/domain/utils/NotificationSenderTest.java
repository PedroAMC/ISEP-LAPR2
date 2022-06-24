package app.domain.utils;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class NotificationSenderTest {


    @Test

    public void testNotificationSender () throws IOException {

        NotificationSender.sendNotification(new Notification("diogocostat@gmail.com","Welcome to the Dgs App"));

        File notifications = new File("out/Notifications.txt");

        assertTrue(notifications.exists());
    }

}