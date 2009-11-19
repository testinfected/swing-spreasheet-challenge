package test.unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import spreadsheet.Sheet;
import spreadsheet.SheetImpl;

import static org.hamcrest.Matchers.equalTo;

public class SheetImplTest {

	private Sheet sheet;
	
	@Before
    public void setUp() {
    	sheet = new SheetImpl();
    }

    @Test 
    public void canStoreValues() {
    	sheet.putValue("hello world");
    	Assert.assertThat(sheet.getValue(), equalTo("hello world"));
    }
}
