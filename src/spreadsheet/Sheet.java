package spreadsheet;

public class Sheet implements Grid {

	private String value;
	
	public String getValue() {
		return value;
	}

	public void putValue(String content) {
		value = content;
	}

}
