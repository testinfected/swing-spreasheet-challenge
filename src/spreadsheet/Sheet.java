package spreadsheet;

public class Sheet implements Grid {

	private String value;
	
	public String get() {
		return value;
	}

	public void put(String content) {
		value = content;
	}

}
