package test.endtoend;

import static java.lang.String.valueOf;

import java.util.ArrayList;
import java.util.List;

import spreadsheet.Application;
import spreadsheet.ui.MainWindow;
import test.drivers.SpreadsheetDriver;

public class ApplicationRunner {

    private static final int TOTAL_ROWS = 10;
    private static final int TOTAL_COLUMNS = 10;

    private SpreadsheetDriver driver;
    
    public static void main(String[] arg) {
    	ApplicationRunner runner = new ApplicationRunner();
    	runner.startApplication();
    }

    protected void startApplication() {
        try {
        	Application.main(valueOf(TOTAL_ROWS), valueOf(TOTAL_COLUMNS));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public void start() {
        Thread thread = new Thread() {
            public void run() {
                try {
                	startApplication();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.setDaemon(true);
        thread.start();

        driver = new SpreadsheetDriver(1000);
        driver.hasTitle(MainWindow.APPLICATION_TITLE);
        driver.hasColumnsWithTitles(lettersOfTheAlphabet());
        driver.hasRowCount(TOTAL_ROWS);
    }

    public void stop() {
        if (driver != null) driver.dispose();
    }

    private int rowIndex(String reference) {
        final String rowReference = reference.substring(1);
        return Integer.valueOf(rowReference) - 1;
    }

    private String columnName(String reference) {
        return valueOf(reference.charAt(0));
    }

    private int columnIndex(String reference) {
		return Character.getNumericValue(reference.charAt(0)) - 10;
	}

    private String[] lettersOfTheAlphabet() {
        List<String> alphabet = new ArrayList<String>();
        for (char letter = 'A'; letter < 'A' + TOTAL_COLUMNS; letter++) {
            alphabet.add(valueOf(letter));
        }
        return alphabet.toArray(new String[TOTAL_COLUMNS]);
    }

    public void displaysInCell(String reference, String content) {
        driver.showsCellWithText(rowIndex(reference), columnName(reference), content);
    }

    public void enterInCell(String reference, String content) {
    	driver.enterTextInCell(rowIndex(reference), columnIndex(reference), content);
	}

    public void activateCell(String reference) {
        driver.activateCell(rowIndex(reference), columnIndex(reference));
    }

    public void showsInInputLine(String literal) {
        driver.showsInInputLine(literal);
    }

    public void enterInInputLine(String text) {
        driver.enterTextInInputLine(text);
    }
}
