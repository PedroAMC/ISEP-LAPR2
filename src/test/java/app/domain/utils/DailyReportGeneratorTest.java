package app.domain.utils;

import app.controller.App;
import app.domain.shared.Constants;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class DailyReportGeneratorTest {


    @Test

    public void testDailyReport(){

        App.getInstance().getCompany().setTask();

        File dailyReport = new File ("out/DailyReport(" + LocalDateTime.now().getDayOfMonth() + "-" + LocalDateTime.now().getMonth() + "-" + LocalDateTime.now().getYear() + ").csv" ) ;

        assertTrue(dailyReport.exists());

    }


}