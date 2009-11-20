package test.unit;

import org.junit.Test;
import spreadsheet.Sheet;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class SheetTest {

	private Sheet sheet = new Sheet();

    @Test public void
    atTheMomentOneCellIsStoredAndCanBeRetrieved() {
    	sheet.putValue("hello world");
    	assertThat(sheet.getValue(), equalTo("hello world"));
    }
}
