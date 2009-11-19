package test.integration;

import org.junit.Assert;
import org.junit.Test;

import test.wl.ApplicationRunner;

public class Initialization {
	
	@Test public void
	applicationShouldStartWithASheet() {
		ApplicationRunner runner = new ApplicationRunner();
		try {
			runner.start();
			Assert.assertNotNull(runner.getMainWindow().getActiveSheet());
		} finally {
			runner.stop();
		}
	}
}
