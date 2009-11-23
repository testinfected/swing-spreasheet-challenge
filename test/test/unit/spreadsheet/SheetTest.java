package test.unit.spreadsheet;

import org.junit.Test;
import spreadsheet.Sheet;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class SheetTest {

	private Sheet sheet = new Sheet();

    @Test public void
    atTheMomentOneCellIsStoredAndCanBeRetrieved() {
    	sheet.put("hello world");
    	assertThat(sheet.get(), equalTo("hello world"));
    }
}
