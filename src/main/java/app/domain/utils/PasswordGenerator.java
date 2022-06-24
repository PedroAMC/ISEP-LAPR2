package app.domain.utils;

import java.security.SecureRandom;
import java.util.Random;

public class PasswordGenerator {

    private static final Random RANDOM = new SecureRandom();
    private static final String CAPITAL = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private static final String ALPHABET = "qwertyuiopasdfghjklzxcvbnm";
    private static final String NUMBERS = "0123456789";


    public static String pwdGenerator (int length,int capitals, int numbers){

        StringBuilder buffer = new StringBuilder(length);
        StringBuilder buffer2 = new StringBuilder(length);

        for (int i = 0; i < capitals; i++) {
            buffer.append(CAPITAL.charAt(RANDOM.nextInt(CAPITAL.length())));
        }

        for (int i = 0; i < numbers; i++) {
            buffer.append(NUMBERS.charAt(RANDOM.nextInt(NUMBERS.length())));
        }

        for (int i = 0; i < length -(capitals + numbers); i++) {
            buffer.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        String firstPass = new String(buffer);


        for (int i = 0; i < length  ; i++) {
            String auxiliarChar = String.valueOf(firstPass.charAt(RANDOM.nextInt(firstPass.length())));
            buffer2.append(auxiliarChar);
            firstPass = firstPass.replaceFirst(auxiliarChar,"");

        }


        return new String(buffer2);
    }


}
