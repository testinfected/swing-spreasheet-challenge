package test.unit.spreadsheet;

import org.junit.Test;
import spreadsheet.Sheet;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class SheetTest {

	private Sheet sheet = new Sheet();

    @Test public void
    oneCellIsStoredAndCanBeRetrieved() {
    	sheet.put("A1", "hello world");
    	assertThat(sheet.get("A1"), equalTo("hello world"));
    }
    
    @Test public void
    twoCellsCanBeStoredAndCanBeRetrieved() {
    	sheet.put("A1", "hello world");
    	sheet.put("B2", "hola mundo");
    	assertThat(sheet.get("A1"), equalTo("hello world"));
    	assertThat(sheet.get("B2"), equalTo("hola mundo"));
    }
}
