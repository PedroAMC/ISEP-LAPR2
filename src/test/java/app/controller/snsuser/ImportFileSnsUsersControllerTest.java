package app.controller.snsuser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class ImportFileSnsUsersControllerTest {

    @Test

    public void testImportFileSnsUsers() throws IOException {

        ImportFileSnsUsersController controller = new ImportFileSnsUsersController();

        File fileUser1 = File.createTempFile("temp", ".csv");
        fileUser1.deleteOnExit();
        FileWriter fileWriter1 = new FileWriter(fileUser1);
        fileWriter1.write("Lucas Gonçalves,m,29/03/2003,Rua de casa,964955155,lucas@gmail.com,123456789,12345678\n" +
                "Afonso Machado,m,16/05/2002,Rua longe,968735213,afonso@gmail.com,987654321,87654321");
        fileWriter1.close();
        controller.SeparateUsers(fileUser1);

        File fileUser2 = File.createTempFile("temp2", ".csv");
        fileUser2.deleteOnExit();
        FileWriter fileWriter2 = new FileWriter(fileUser2);
        fileWriter2.write("nome;sex;birthdate;address;phonenumber;email;snsusernumber;citizencardnumber\n" +
         "Nuno Cunha,m,12/07/2001,Rua de baixo, 987123465,nunocunha@gmail.com,192837465,18273645\n " +
                "Miguel Ferreira,f,29/01/2000,Rua da cidade, 911222333,miguelf@gmail.com,111222333,11223344\n" +
                "Pedro Campos,m,01/01/1999,Rua da vila, 921345687,pcampos@gmail.com,998877665,87876565\n");



    }

}
