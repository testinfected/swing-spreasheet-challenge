package spreadsheet;

import java.util.HashMap;
import java.util.Map;

public class Sheet implements Grid {

	private Map<String, String> values = new HashMap<String, String>();
	
	public String get(String reference) {
		return values.get(reference);
	}

	public void put(String reference, String content) {
		values.put(reference, content);
	}

}
