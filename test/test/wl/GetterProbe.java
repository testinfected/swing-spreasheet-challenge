package test.wl;

import org.hamcrest.Description;

import com.objogate.wl.Probe;

public class GetterProbe implements Probe {

	private boolean called = false;
	
	public void called() {
		called = true;
	}
	
	public boolean isSatisfied() {
		return called;
	}

	public void describeTo(Description description) {
		description.appendText("Getter should have been called");
	}

	public boolean describeFailureTo(Description description) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void probe() {
		// nothing to do	
	}
	
}
