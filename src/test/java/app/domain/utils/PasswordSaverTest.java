package app.domain.utils;

import app.domain.model.data.snsuser.SnsUser;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PasswordSaverTest {


    @Test

    public void testPasswordSaver () throws IOException {

        PasswordSaver.saveSnsUserPassword("joaozinho@gmail.com","AF43G");

        File passwords = new File("out/SnsUsersPassword.txt");

        assertTrue(passwords.exists());
    }

    @Test

    public void testPasswordSaver2 () throws IOException {

        PasswordSaver.saveEmployeesPassword("joaozinho@gmail.com","AF43G");

        File passwords = new File("out/EmployeesPassword.txt");

        assertTrue(passwords.exists());
    }



}