package test.endtoend;

import org.junit.After;
import org.junit.Before;


public class WorkBookUsage {

	private final ApplicationRunner application = new ApplicationRunner();

    @Before
    public void startApplication() {
        application.start();
    }

    @After
    public void stopApplication() {
        application.stop();
    }
    /*
	@Test public void
	startsWithASingleSheetInOneTab() {
		application.displaysOneTab();
	}*/
}
