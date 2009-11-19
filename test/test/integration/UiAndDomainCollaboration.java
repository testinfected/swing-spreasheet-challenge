package test.integration;

import static org.hamcrest.Matchers.equalTo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spreadsheet.ui.MainWindow;
import test.wl.ApplicationRunner;
import test.wl.GetterProbe;
import test.wl.SpreadsheetDriver;

import com.objogate.wl.swing.probe.ValueMatcherProbe;

public class UiAndDomainCollaboration {

	private final ApplicationRunner applicationRunner = new ApplicationRunner();
	private MainWindow mainWindow;

    @Before
    public void startApplication() {
    	applicationRunner.start();
        mainWindow = applicationRunner.getMainWindow();
    }

    @After
    public void stopApplication() {
    	applicationRunner.stop();
    }
    
	@Test public void
	storeInSheetWhenTextIsEntered() {
		final ValueMatcherProbe<String> valueReceivedProbe = 
		      new ValueMatcherProbe<String>(equalTo("vince"), "store request");
		mainWindow.setActiveSheet(new SheetAdapter() {
			public void putValue(String content) {
				valueReceivedProbe.setReceivedValue(content);
			}

		});
		
		SpreadsheetDriver driver = new SpreadsheetDriver(1000);
		driver.enterTextInCell(0, 0, "vince");
		driver.check(valueReceivedProbe);
	}
	
	@Test public void
	readFromSheetWhenRenderingIsNeeded() {
		final GetterProbe getterProbe = new GetterProbe();
		mainWindow.setActiveSheet(new SheetAdapter() {
			public String getValue() {
				getterProbe.called();
				return "";
			}

		});
		
		SpreadsheetDriver driver = new SpreadsheetDriver(1000);
		driver.enterTextInCell(0, 0, "vince");
		driver.check(getterProbe);
	}
}
