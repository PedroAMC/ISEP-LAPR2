package app.domain.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificationTest {

    @Test

    public void testNotification(){

        Notification notification = new Notification("diogo@gmail.com","Welcome to the DGS app");

        assertEquals("diogo@gmail.com",notification.getAddress());
        assertEquals("Welcome to the DGS app",notification.getMessage());

    }



}