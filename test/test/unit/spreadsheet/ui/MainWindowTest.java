package test.unit.spreadsheet.ui;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spreadsheet.EditionListener;
import spreadsheet.GridListener;
import spreadsheet.ui.MainWindow;
import test.drivers.SpreadsheetDriver;

public class MainWindowTest implements GridListener, EditionListener {

    private boolean clicked;
    private boolean modified;
    private static MainWindow view;
    private static SpreadsheetDriver driver;

    @After
    public void teardown() {
        driver.dispose();
    }
    
    @Before
    public void initIndicators() {
    	clicked = false;
    	modified =false;
    	view = new MainWindow(10, 10);
        view.showMainWindow();
        driver = new SpreadsheetDriver(1000);
    }

    public void cellClicked(Object content) {
        clicked = true;
    }
    public void valueChanged(String value) {
		modified = true;
	}

    @Test
    public void cellSelectionShouldBeDelegatedToRegisteredListener() {        
        view.registerGridViewListener(this);
        driver.activateCell(0, 0);
        assertTrue(clicked);
    }

    @Test
    public void inputLineShouldDisplayTheGivenValue() {
        view.updateInputLine("toto");
        driver.showsInInputLine("toto");
    }

    @Test
    public void editionValidationShouldBeDelegatedToRegisteredListener() {
    	view.registerEditionListener(this);
    	driver.enterTextInInputLine(" ");
    	assertTrue(modified);
    }
    
    @Test
    public void newValueIsSentByTypingENTERKey() {
    	view.registerEditionListener(this);
    	driver.typeTextInInputLine(" ");
    	assertFalse(modified);
    }
    
    @Test
    public void selectedCellShouldDisplayTheGivenValue() {
    	driver.activateCell(0, 0);
    	view.updateSelectedCell("tutu");
    	driver.showsCellWithText(0, "A", "tutu");
    }

	
}