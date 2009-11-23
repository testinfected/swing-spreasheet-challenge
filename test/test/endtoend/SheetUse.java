package test.endtoend;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SheetUse {

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
        application.displaysInCell("A1", NOTHING);
        application.displaysInCell("C4", NOTHING);
        application.displaysInCell("J9", NOTHING);
    }
    
    @Test public void 
    entersTextInACellAndReadsTheContentOfTheCell()  {
        application.enterInCell("A1", "Bob");
        application.displaysInCell("A1", "Bob");
    }
}