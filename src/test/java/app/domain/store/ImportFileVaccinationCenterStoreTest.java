package app.domain.store;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class ImportFileVaccinationCenterStoreTest {

    @Test
    public void testVerifyFileWhenTheFileIsNotAFileThenReturnFalse() {
        ImportFileVaccinationCenterStore importFileVaccinationCenterStore = new ImportFileVaccinationCenterStore();
        File file = new File("notAFile");

        boolean result = importFileVaccinationCenterStore.verifyFile(file);

        assertFalse(result);
    }

    @Test
    public void testVerifyFileWhenTheFileIsBlankThenReturnFalse() {
        ImportFileVaccinationCenterStore importFileVaccinationCenterStore = new ImportFileVaccinationCenterStore();
        File file = new File("src/test/resources/blankFile.txt");

        boolean result = importFileVaccinationCenterStore.verifyFile(file);

        assertFalse(result);
    }

    @Test
    public void testCreateFileReaderWhenFilePathIsValid() {
        ImportFileVaccinationCenterStore importFileVaccinationCenterStore = new ImportFileVaccinationCenterStore();
        importFileVaccinationCenterStore.setFilePath("src/test/resources/test.txt");
        importFileVaccinationCenterStore.createFileReader();

        assertNotNull(importFileVaccinationCenterStore.fileReader);
    }


    @Test
    public void testSetFilePathShouldSetTheFilePath() {
        ImportFileVaccinationCenterStore importFileVaccinationCenterStore = new ImportFileVaccinationCenterStore();
        String filePath = "C:\\Users\\User\\Desktop\\file.txt";

        importFileVaccinationCenterStore.setFilePath(filePath);

        assertEquals(filePath, importFileVaccinationCenterStore.filePath);
    }
}