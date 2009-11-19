package test.wl;

import junit.framework.Assert;

import org.junit.Test;




public class ApplicationRunnerTest {

	@Test public void
	canExtractColumnIndexFromReference() {
		ApplicationRunner application = new ApplicationRunner();
		Assert.assertEquals(0, application.columnIndex("A1"));
		Assert.assertEquals(1, application.columnIndex("B9"));
		Assert.assertEquals(9, application.columnIndex("J10"));
	}
}
