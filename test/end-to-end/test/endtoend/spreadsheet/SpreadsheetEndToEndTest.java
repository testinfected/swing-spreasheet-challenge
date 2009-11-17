package test.endtoend.spreadsheet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SpreadsheetEndToEndTest {

    private final ApplicationRunner application = new ApplicationRunner();

    @Before
    public void startApplication() throws Exception {
        application.start();
    }

    @After
    public void stopApplication() {
        application.stop();
    }

    @Test public void
    entersNothingAndSeesAnEmptySpreadsheet() {
        application.openAnEmptySheet();
        application.showsCellContent("A1", "");
        application.showsCellContent("J42", "");
        application.showsCellContent("Z99", "");
    }
}
