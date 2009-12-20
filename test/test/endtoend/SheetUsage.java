package test.endtoend;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SheetUsage {

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
    entersTextInCellsAndSeesTheCellsContent()  {
        application.enterInCell("A1", "one text");
        application.enterInCell("B1", "other text");
        application.displaysInCell("A1", "one text");
        application.displaysInCell("B1", "other text");
        application.enterInCell("A1", "one sentence");
        application.displaysInCell("A1", "one sentence");
    }

    @Test public void
    entersTextInACellAndEditsTheContentOfTheCell()  {
        application.enterInCell("A1", "one text");
        application.enterInCell("B1", "other text");
        application.activateCell("A1");
        application.showsInInputLine("one text");
        application.enterInInputLine("one sentence");
        application.displaysInCell("A1", "one sentence");
    }
}
