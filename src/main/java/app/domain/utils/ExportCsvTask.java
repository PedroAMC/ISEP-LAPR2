package app.domain.utils;

import app.controller.App;

import java.io.IOException;
import java.util.TimerTask;

public class ExportCsvTask extends TimerTask {

    @Override
    public void run() {
        App.getInstance().getCompany().setTask();

    }
}
