package test.endtoend.spreadsheet;

import spreadsheet.Application;
import spreadsheet.ui.MainWindow;

public class ApplicationRunner {

    private static final int LINE_COUNT = 99;
    private SpreadsheetDriver driver;

    public void start() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Application.main();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.setDaemon(true);
        thread.start();

        driver = new SpreadsheetDriver(1000);
        driver.hasTitle(MainWindow.APPLICATION_TITLE);
        driver.hasColumnTitles();
        driver.hasLines(LINE_COUNT);
    }

    public void stop() {
        if (driver != null) driver.dispose();
    }

    public void openAnEmptySheet() {
    }

    public void showsCellContent(String reference, String value) {
    }
}
