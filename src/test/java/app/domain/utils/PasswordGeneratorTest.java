package app.domain.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordGeneratorTest {

    @Test

    public void testPwdGenerator(){

        String pwd = PasswordGenerator.pwdGenerator(7,3,2);
        int capitalCount = 0;
        int digitCount = 0;
        int alphaCount = 0;

        String capital = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String alphabet = "qwertyuiopasdfghjklzxcvbnm";
        String numbers = "0123456789";

        for (int i = 0; i < pwd.length(); i++) {

            for (int j = 0; j < capital.length(); j++) {
                if(pwd.charAt(i) == capital.charAt(j)){
                    capitalCount ++;
                }
                if(pwd.charAt(i) == alphabet.charAt(j)){
                    alphaCount ++;
                }
            }

            for (int j = 0; j < numbers.length(); j++) {
                if(pwd.charAt(i) == numbers.charAt(j)){
                    digitCount ++;
                }
            }
        }

        assertEquals(capitalCount,3);
        assertEquals(alphaCount,2);
        assertEquals(digitCount,2);
    }
}