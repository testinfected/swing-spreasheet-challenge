package test.endtoend.spreadsheet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SpreadsheetEndToEndTest {

    private static final String NOTHING = "";
    private final ApplicationRunner application = new ApplicationRunner();

    @Before
    public void startApplication() {
        application.start();
    }

    @After
    public void stopApplication() {
        application.stop();
    }

    @Test public void
    entersNothingAndSeesAnEmptySpreadsheet() {
        application.openAnEmptySheet();
        application.showsInCell("A1", NOTHING);
        application.showsInCell("C4", NOTHING);
        application.showsInCell("J9", NOTHING);
    }
}
