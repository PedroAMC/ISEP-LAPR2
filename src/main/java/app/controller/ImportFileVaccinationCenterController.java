package app.controller;

import app.domain.store.ImportFileVaccinationCenterStore;

import java.io.File;
import java.util.Scanner;

public class ImportFileVaccinationCenterController {

    private final ImportFileVaccinationCenterStore store;

    public void SetFilePath(String filePath) { this.store.setFilePath(filePath); }

    public void CreateFileReader(){ this.store.createFileReader(); }

    public ImportFileVaccinationCenterController(){
        this.store = new ImportFileVaccinationCenterStore();
    }

    public boolean VerifyFile(File file){ return this.store.verifyFile(file); }

    public int NumberOfLines(){ return this.store.numberOfLines(); }

    public String[][] SeparateInformation() { return this.store.separateInformation();}


}
