package test.endtoend;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.wl.ApplicationRunner;


public class BasicStoringSpecifications {

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
        application.showsInCell("A1", NOTHING);
        application.showsInCell("C4", NOTHING);
        application.showsInCell("J9", NOTHING);
    }
    
    @Test public void entersTextInACellAndReadsTheContentOfTheCell()  {
        application.openAnEmptySheet();
        application.enterInCell("A1", "Bob");
        application.showsInCell("A1", "Bob");
        application.enterInCell("A1", "Vince");
        application.showsInCell("A1", "Vince");
    }
}
