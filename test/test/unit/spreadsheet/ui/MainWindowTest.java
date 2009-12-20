package test.unit.spreadsheet.ui;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import spreadsheet.GridListener;
import spreadsheet.GridView;
import spreadsheet.ui.MainWindow;
import test.drivers.SpreadsheetDriver;
import static org.junit.Assert.*;

public class MainWindowTest implements GridListener {

    private boolean clicked;
    private static MainWindow view;
    private static SpreadsheetDriver driver;

    @BeforeClass
    public static void setUp() {
        view = new MainWindow(10, 10);
        view.showMainWindow();
        driver = new SpreadsheetDriver(1000);
    }

    @AfterClass
    public static void teardown() {
        driver.dispose();
    }

    public void cellClicked(Object content) {
        clicked = true;
    }

    @Test
    public void cellSelectionShouldBeDelegatedToListener() {
        clicked = false;
        view.registerGridViewListener(this);
        driver.activateCell(0, 0);
        assertTrue(clicked);
    }

    @Test
    public void inputLineShouldDisplayTheGivenValue() {
        view.updateInputLine("toto");
        driver.showsInInputLine("toto");
    }

    

}